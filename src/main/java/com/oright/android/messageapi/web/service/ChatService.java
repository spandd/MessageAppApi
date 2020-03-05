package com.oright.android.messageapi.web.service;

import com.oright.android.messageapi.web.model.Chat;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ChatService {
    public List<Chat> findChatList(Integer userId,Integer friendId);

    public int sendMessage(Chat chat);
}
