package com.oright.android.messageapi.web.controller;

import com.oright.android.messageapi.web.model.Friend;
import com.oright.android.messageapi.web.model.User;
import com.oright.android.messageapi.web.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("findDisAddFriend")
    public User findDisAddFriend(Integer userId,Integer friendId){
        return friendService.findDisAddFriend(userId,friendId);
    }
    @GetMapping("addFriend")
    public String addFriend(Integer userId,Integer friendId){
        return String.valueOf(friendService.addFriend(userId,friendId));
    }

    @GetMapping("findFriendList")
    public List<Friend> findFriendList(Integer userId){
        return friendService.findFriendList(userId);
    }

    @GetMapping("acceptAddFriendRequest")
    public int acceptAddFriendRequest(Integer userId,Integer friendId){
        return friendService.acceptAddFriendRequest(userId,friendId);
    }

    @GetMapping("deleteFriend")
    public int deleteFriend(Integer userId,Integer friendId){
        return friendService.deleteFriend(userId,friendId);
    }
}
