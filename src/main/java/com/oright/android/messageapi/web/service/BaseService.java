package com.oright.android.messageapi.web.service;

import com.oright.android.messageapi.web.model.BaseInfo;
import com.oright.android.messageapi.web.model.User;

public interface BaseService {
    public BaseInfo login(User user);
    public BaseInfo register(User user);
    public BaseInfo foundUserNameIsRepeat(String userName);
    public User findUserBaseInfo(String userName);
}
