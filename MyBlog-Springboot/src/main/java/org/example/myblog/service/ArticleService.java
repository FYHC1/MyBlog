package org.example.myblog.service;

import org.example.myblog.pojo.Article;
import org.example.myblog.pojo.Result;


public interface ArticleService {
    Article[] getAllArticles();

    Result addArticle(Article article);

    Article getContentById(Integer id);

    void updateArticle(Article article);

    void deleteArticle(Integer id);

    Integer articleNum();
}
