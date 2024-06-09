package org.example.myblog.mapper;

import org.apache.ibatis.annotations.*;
import org.example.myblog.pojo.Article;

@Mapper
public interface ArticleMapper {
    @Select("select * from article")
    Article[] getAllArticles();

    @Insert("insert into article(title,content,create_time,update_time)"+
            "values(#{title},#{content},#{createTime},#{updateTime})")
    void addArticle(Article article);

    @Select("select * from article where id=#{id}")
    Article getContentById(Integer id);

    @Update("update article set title=#{title},content=#{content},update_time=#{updateTime} where id=#{id}")
    void updateArticle(Article article);

    @Delete("delete  from  article where id=#{id}")
    void deleteArticle(Integer id);

    @Select("select COUNT(myblog.article.id) from article")
    Integer articleNum();
}
