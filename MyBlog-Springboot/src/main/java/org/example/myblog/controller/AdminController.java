package org.example.myblog.controller;

import org.example.myblog.pojo.Article;
import org.example.myblog.pojo.Result;
import org.example.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/getarticlelist")
    public Result<Article[]> getArticleList() {
        return Result.success( articleService.getAllArticles());
    }

    @PostMapping("/addarticle")
    public Result addArticle(@RequestBody Article article){
       articleService.addArticle(article);
       return Result.success();
    }

    @GetMapping("/getcontentbyid")
    public Result<Article> getContentById(Integer id){
        Article article= articleService.getContentById(id);

        return Result.success(article);
    }

    @PutMapping("/updatearticle")
    public Result updateArticle(@RequestBody Article article){
        articleService.updateArticle(article);
        return Result.success();
    }

    @DeleteMapping("/deletearticle")
    public Result deleteArticle(Integer id){
        articleService.deleteArticle(id);
        System.out.println(id);
        return Result.success();
    }
}
