package com.oright.android.messageapi.web.service;

import com.alibaba.fastjson.JSONObject;
import com.oright.android.messageapi.socket.ClientPool;
import com.oright.android.messageapi.web.mapper.FriendMapper;

import com.oright.android.messageapi.web.model.Friend;
import com.oright.android.messageapi.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.util.List;

@Service
public class FriendServiceImp implements FriendService {

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public User findDisAddFriend(Integer userId,Integer friendId) {
        if (friendMapper.findFriend(userId,friendId) == null){
            User user = friendMapper.findDisAddFriend(friendId);
            if (user != null){
                if (user.getBlobHeadPortrait() != null){
                    user.setStringHeadPortrait(new BASE64Encoder().encodeBuffer(user.getBlobHeadPortrait()));
                    user.setBlobHeadPortrait(null);
                }
            }
            return user;
        }
        else{
            return null;
        }
    }

    @Override
    public int addFriend(Integer userId,Integer friendId) {
        int resCode = friendMapper.addFriend1(userId,friendId,1) + friendMapper.addFriend2(friendId,userId,1);
        if (resCode == 2){
            for (int i = 0; i < ClientPool.clients.size(); i++){
                if (ClientPool.clients.get(i).getUserId().intValue() == friendId.intValue()){
                    ClientPool.clients.get(i).sendMessage("friend");
                    ClientPool.clients.get(i).sendMessage("add");
                }
            }
        }
        return resCode;
    }

    @Override
    public List<Friend> findFriendList(Integer userId) {
        return friendMapper.findFriend2(userId);
    }

    @Override
    public int acceptAddFriendRequest(Integer userId, Integer friendId) {
        int resCode = friendMapper.acceptAddFriendRequest1(userId,friendId) + friendMapper.acceptAddFriendRequest2(friendId,userId);
        if (resCode == 2){
            for (int i = 0; i < ClientPool.clients.size(); i++){
                if (ClientPool.clients.get(i).getUserId().intValue() == friendId.intValue()){
                    ClientPool.clients.get(i).sendMessage("friend");
                    ClientPool.clients.get(i).sendMessage("accept");
                }
            }
        }
        return resCode;
    }

    @Override
    public int deleteFriend(Integer userId, Integer friendId) {
        int resCode = friendMapper.deleteFriend(userId,friendId) + friendMapper.deleteFriend(friendId,userId);
        friendMapper.deleteChatCache(userId,friendId);
        friendMapper.deleteChatCache(friendId,userId);
        if (resCode == 2){
            for (int i = 0; i < ClientPool.clients.size(); i++){
                if (ClientPool.clients.get(i).getUserId().intValue() == friendId.intValue()){
                    ClientPool.clients.get(i).sendMessage("friend");
                    ClientPool.clients.get(i).sendMessage("delete");
                }
            }
        }
        return resCode;
    }
}
