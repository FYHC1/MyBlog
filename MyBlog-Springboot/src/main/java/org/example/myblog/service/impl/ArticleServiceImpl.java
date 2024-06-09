package org.example.myblog.service.impl;

import org.example.myblog.mapper.ArticleMapper;
import org.example.myblog.pojo.Article;
import org.example.myblog.pojo.Result;
import org.example.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Article[] getAllArticles() {
        return articleMapper.getAllArticles();
    }

    @Override
    public Result addArticle(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.addArticle(article);
        return Result.success(article.getTitle());
    }

    @Override
    public Article getContentById(Integer id) {
        return articleMapper.getContentById(id);
    }

    @Override
    public void updateArticle(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.updateArticle(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteArticle(id);
    }

    @Override
    public Integer articleNum() {
        return articleMapper.articleNum();
    }
}
