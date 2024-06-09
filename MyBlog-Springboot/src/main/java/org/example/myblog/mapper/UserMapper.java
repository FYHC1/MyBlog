package org.example.myblog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.myblog.pojo.User;

@Mapper
public interface UserMapper {
    @Insert("insert into user(username,password)" + "value(#{username},#{md5String})")
    void register(String username, String md5String);

    @Select("select * from user where username=#{username}")
    User findByUerName(String username);
}
