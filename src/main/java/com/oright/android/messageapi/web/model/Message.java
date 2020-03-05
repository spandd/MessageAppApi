package com.oright.android.messageapi.web.model;


import java.io.Serializable;
import java.sql.Blob;

public class Message implements Serializable {
    private Blob friendHeadPortrait;
    private String friendName;
    private String chatContent;
    private Integer friendId;
    private int chatType;
    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public Blob getFriendHeadPortrait() {
        return friendHeadPortrait;
    }

    public void setFriendHeadPortrait(Blob friendHeadPortrait) {
        this.friendHeadPortrait = friendHeadPortrait;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public int getChatType() {
        return chatType;
    }

    public void setChatType(int chatType) {
        this.chatType = chatType;
    }
}
