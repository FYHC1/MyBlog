package org.example.myblog.controller;

import org.example.myblog.pojo.Result;
import org.example.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/getmassagenum")
    public Result<Integer> getMassagenum() {
       Integer num= articleService.articleNum();
       return Result.success(num);
    }


}
