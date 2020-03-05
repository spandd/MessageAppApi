package com.oright.android.messageapi.web.model;


import java.io.Serializable;

public class Chat implements Serializable {

    private Integer userId;
    private Integer friendId;
    private String chatContent;
    private byte[] chatPhotoB;
    private String chatPhotoS;
    private Integer isLast;
    private Integer isRead;
    private Integer isMe;
    private String chatLatitude;
    private String chatLongitude;
    private String chatDirection;
    private String chatAccuracy;
    private int chatType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public int getIsLast() {
        return isLast;
    }

    public void setIsLast(int isLast) {
        this.isLast = isLast;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public int getIsMe() {
        return isMe;
    }

    public void setIsMe(int isMe) {
        this.isMe = isMe;
    }

    public byte[] getChatPhotoB() {
        return chatPhotoB;
    }

    public void setChatPhotoB(byte[] chatPhotoB) {
        this.chatPhotoB = chatPhotoB;
    }

    public String getChatPhotoS() {
        return chatPhotoS;
    }

    public void setChatPhotoS(String chatPhotoS) {
        this.chatPhotoS = chatPhotoS;
    }



    public int getChatType() {
        return chatType;
    }

    public void setChatType(int chatType) {
        this.chatType = chatType;
    }

    public String getChatLatitude() {
        return chatLatitude;
    }

    public void setChatLatitude(String chatLatitude) {
        this.chatLatitude = chatLatitude;
    }

    public String getChatLongitude() {
        return chatLongitude;
    }

    public void setChatLongitude(String chatLongitude) {
        this.chatLongitude = chatLongitude;
    }

    public String getChatDirection() {
        return chatDirection;
    }

    public void setChatDirection(String chatDirection) {
        this.chatDirection = chatDirection;
    }

    public String getChatAccuracy() {
        return chatAccuracy;
    }

    public void setChatAccuracy(String chatAccuracy) {
        this.chatAccuracy = chatAccuracy;
    }
}
