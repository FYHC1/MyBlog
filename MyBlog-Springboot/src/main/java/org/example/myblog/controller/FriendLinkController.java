package org.example.myblog.controller;

import org.example.myblog.pojo.FriendLink;
import org.example.myblog.pojo.Result;
import org.example.myblog.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/friendlink")
public class FriendLinkController {
    @Autowired
    FriendLinkService friendLinkService;
    @GetMapping
    public Result<FriendLink[]> getFriendLink() {
        FriendLink[] friendLinks=friendLinkService.getFriendLinkList();
        return Result.success(friendLinks);
    }

    @PostMapping("/addfriendlink")
    public Result addFriendLink(@RequestBody FriendLink friendLink) {
        friendLinkService.addFriendLink();
        return Result.success();
    }
}
