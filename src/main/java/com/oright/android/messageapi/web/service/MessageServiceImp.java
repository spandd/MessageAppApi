package com.oright.android.messageapi.web.service;

import com.oright.android.messageapi.web.mapper.MessageMapper;
import com.oright.android.messageapi.web.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImp implements MessageService{

    @Autowired
    private MessageMapper messageMapper;


    @Override
    public List<Message> findMessageList(Integer userId) {
        List<Message> messages = messageMapper.findMessageList(userId);
        return messages;
    }
}
