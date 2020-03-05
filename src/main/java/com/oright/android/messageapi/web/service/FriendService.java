package com.oright.android.messageapi.web.service;

import com.oright.android.messageapi.web.model.Friend;
import com.oright.android.messageapi.web.model.User;

import java.util.List;

public interface FriendService {
    public User findDisAddFriend(Integer userId,Integer friendId);
    public int addFriend(Integer userId,Integer friendId);


    /**
     * 查询好友列表
     */
    public List<Friend> findFriendList(Integer userId);

    /**
     * 同意好友的添加请求
     */
    public int acceptAddFriendRequest(Integer userId,Integer friendId);

    /**
     * 删除好友
     */

    public int deleteFriend(Integer userId,Integer friendId);
}
