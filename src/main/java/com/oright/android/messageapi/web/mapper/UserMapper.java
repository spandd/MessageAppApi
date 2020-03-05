package com.oright.android.messageapi.web.mapper;


import com.oright.android.messageapi.web.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select user_name,password from user where user_name=#{userName}")
    public User getUserByUserName(User user);
    @Insert("insert into user (user_name,password,birthday_month,birthday_day) values(#{userName},#{password},#{birthdayMonth},#{birthdayDay}) ")
    public int setUser(User user);
    @Select("select user_name from user where user_name=#{userName}")
    public User findUserNameIsRepeat(String userName);

    @Select("select user_id,user_name,birthday_month,birthday_day,blob_head_portrait from user where user_name=#{userName}")
    public User findUserBaseInfo(String userName);
}
