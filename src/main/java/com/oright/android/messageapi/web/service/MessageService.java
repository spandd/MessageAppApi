package com.oright.android.messageapi.web.service;

import com.oright.android.messageapi.web.model.Message;

import java.util.List;

public interface MessageService {

    public List<Message> findMessageList(Integer userId);
}
