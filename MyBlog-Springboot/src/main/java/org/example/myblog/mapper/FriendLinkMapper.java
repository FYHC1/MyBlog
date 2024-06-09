package org.example.myblog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.myblog.pojo.FriendLink;

@Mapper
public interface FriendLinkMapper {
    @Select("select * from friendlink")
    FriendLink[] getAll();

    @Insert("insert into friendlink(fname,link)"+"value(fname=#{fname},link=#{link})")
    void addFriendLink();
}
