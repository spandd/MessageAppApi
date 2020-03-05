package com.oright.android.messageapi.web.mapper;


import com.oright.android.messageapi.web.model.Chat;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ChatMapper {


    @Select("select * from chat where user_id=#{userId} and friend_id=#{friendId}")
    public List<Chat> findChatList(Integer userId, Integer friendId);

    @Insert("insert into chat(user_id,friend_id,chat_content,is_read,chat_type) values(#{userId},#{friendId},#{chatContent},1,0)")
    public int sendMessage1_0(Chat chat);

    @Insert("insert into chat(user_id,friend_id,chat_photo_b,is_read,chat_type) values(#{userId},#{friendId},#{chatPhotoB},1,1)")
    public int sendMessage1_1(Chat chat);

    @Insert("insert into chat(user_id,friend_id,chat_latitude,chat_longitude,chat_direction,chat_accuracy,is_read,chat_type) " +
            "values(#{userId},#{friendId},#{chatLatitude},#{chatLongitude},#{chatDirection},#{chatAccuracy},1,2)")
    public int sendMessage1_2(Chat chat);

    @Insert("insert into chat(user_id,friend_id,chat_content,is_me,chat_type) values(#{friendId},#{userId},#{chatContent},0,0)")
    public int sendMessage2_0(Chat chat);

    @Insert("insert into chat(user_id,friend_id,chat_photo_b,is_me,chat_type) values(#{friendId},#{userId},#{chatPhotoB},0,1)")
    public int sendMessage2_1(Chat chat);

    @Insert("insert into chat(user_id,friend_id,chat_latitude,chat_longitude,chat_direction,chat_accuracy,is_me,chat_type) " +
            "values(#{friendId},#{userId},#{chatLatitude},#{chatLongitude},#{chatDirection},#{chatAccuracy},0,2)")
    public int sendMessage2_2(Chat chat);

    @Update("update chat set is_last=0 where user_id=#{userId} and friend_id=#{friendId} and is_last=1")
    public int updateChatStatus1(Chat chat);
    @Update("update chat set is_last=0 where user_id=#{friendId} and friend_id=#{userId} and is_last=1")
    public int updateChatStatus2(Chat chat);
}
