package com.oright.android.messageapi.web.controller;


import com.oright.android.messageapi.web.model.Message;
import com.oright.android.messageapi.web.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("findMessageList")
    public List<Message> findMessageList(Integer userId){
        return messageService.findMessageList(userId);
    }
}
