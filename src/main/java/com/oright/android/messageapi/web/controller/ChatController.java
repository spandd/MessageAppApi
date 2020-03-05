package com.oright.android.messageapi.web.controller;


import com.oright.android.messageapi.web.model.Chat;
import com.oright.android.messageapi.web.model.Friend;
import com.oright.android.messageapi.web.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("findChatList")
    public List<Chat> findChatList(@RequestBody Friend friend){
        return chatService.findChatList(friend.getUserId(),friend.getFriendId());
    }

    @PostMapping("sendMessage")
    public int sendMessage(@RequestBody Chat chat){
        return chatService.sendMessage(chat);
    }
}
