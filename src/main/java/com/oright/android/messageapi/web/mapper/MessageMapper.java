package com.oright.android.messageapi.web.mapper;


import com.oright.android.messageapi.web.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("select friend.friend_id,friend.friend_name,friend_head_portrait,chat.chat_content,chat.chat_type " +
            "FROM chat LEFT JOIN friend on chat.user_id = friend.user_id and chat.friend_id = friend.friend_id " +
            "where chat.user_id=#{userId} and chat.is_last=1")
    public List<Message> findMessageList(Integer userId);
}
