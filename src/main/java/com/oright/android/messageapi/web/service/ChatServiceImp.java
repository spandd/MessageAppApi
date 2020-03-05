package com.oright.android.messageapi.web.service;

import com.alibaba.fastjson.JSONObject;
import com.oright.android.messageapi.socket.ClientPool;
import com.oright.android.messageapi.web.mapper.ChatMapper;
import com.oright.android.messageapi.web.model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ChatServiceImp implements ChatService{

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public List<Chat> findChatList(Integer userId, Integer friendId) {
        List<Chat> chats = chatMapper.findChatList(userId,friendId);
        for(int i = 0;i < chats.size();i++){
            if (chats.get(i).getChatPhotoB() != null){
                chats.get(i).setChatPhotoS(new BASE64Encoder().encodeBuffer(chats.get(i).getChatPhotoB()));
                chats.get(i).setChatPhotoB(null);
            }
        }
        return chats;
    }

    @Override
    public int sendMessage(Chat chat) {
        for (int i = 0; i < ClientPool.clients.size(); i++){
            if (ClientPool.clients.get(i).getUserId().intValue() == chat.getFriendId().intValue()){
                String message = JSONObject.toJSONString(chat);
                ClientPool.clients.get(i).sendMessage("chat");
                ClientPool.clients.get(i).sendMessage(message);
            }
        }
        int resNum = chatMapper.updateChatStatus1(chat) + chatMapper.updateChatStatus2(chat);
        if (resNum == 0 || resNum == 2){

            if(chat.getChatType() == 0){
                return chatMapper.sendMessage1_0(chat) + chatMapper.sendMessage2_0(chat);
            }
            else if (chat.getChatType() == 1){
                try {
                    chat.setChatPhotoB(new BASE64Decoder().decodeBuffer(chat.getChatPhotoS()));
                    return chatMapper.sendMessage1_1(chat) + chatMapper.sendMessage2_1(chat);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (chat.getChatType() == 2){
                return chatMapper.sendMessage1_2(chat) + chatMapper.sendMessage2_2(chat);
            }
        }
        return 0;
    }
}
