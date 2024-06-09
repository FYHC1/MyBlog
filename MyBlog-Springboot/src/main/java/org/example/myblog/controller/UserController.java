package org.example.myblog.controller;

import jakarta.validation.constraints.Pattern;
import org.example.myblog.Util.JwtUtil;
import org.example.myblog.Util.Md5Util;
import org.example.myblog.pojo.Result;
import org.example.myblog.pojo.User;
import org.example.myblog.service.ArticleService;
import org.example.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{2,10}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password) {
        User user = userService.findByUserName(username);
        if (user == null) {
            userService.register(username, password);
            return Result.success();
        }else {
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{2,10}$")String username,@Pattern(regexp = "^\\S{5,16}$") String password) {
        User loginuser = userService.findByUserName(username);
        if (loginuser == null) {
            return Result.error("用户名错误");
        }
        if(loginuser.getPassword().equals(Md5Util.getMD5String(password))) {
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginuser.getId());
            claims.put("username",loginuser.getUsername());
            String token= JwtUtil.genToken(claims);
            //把token存储到redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token,token,1, TimeUnit.HOURS);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }
}
