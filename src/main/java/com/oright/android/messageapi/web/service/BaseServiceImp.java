package com.oright.android.messageapi.web.service;

import com.oright.android.messageapi.constants.BaseConstants;
import com.oright.android.messageapi.web.mapper.UserMapper;
import com.oright.android.messageapi.web.model.BaseInfo;
import com.oright.android.messageapi.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

@Service
public class BaseServiceImp implements BaseService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseInfo login(User user) {
        User selectUser = userMapper.getUserByUserName(user);
        BaseInfo loginInfo = new BaseInfo();
        if (selectUser == null){
            loginInfo.setLoginStatus(BaseConstants.loginInfoUserNameNotFoundCode);
            loginInfo.setLoginInfo(BaseConstants.loginInfoUserNameNotFound);
        }
        else if (selectUser.getPassword().equals(user.getPassword())){
            loginInfo.setLoginStatus(BaseConstants.loginInfoSuccessCode);
            loginInfo.setLoginInfo(BaseConstants.loginInfoSuccess);
        }
        else{
            loginInfo.setLoginStatus(BaseConstants.loginInfoPasswordErrorCode);
            loginInfo.setLoginInfo(BaseConstants.loginInfoPasswordError);
        }
        return loginInfo;
    }

    @Override
    public BaseInfo register(User user) {
        int insertNum = userMapper.setUser(user);
        BaseInfo registerInfo = new BaseInfo();
        if (insertNum == 1){
            registerInfo.setRegisterStatus(BaseConstants.registerInfoSuccessCode);
            registerInfo.setRegisterInfo(BaseConstants.registerInfoSuccess);
        }
        else{
            registerInfo.setRegisterStatus(BaseConstants.registerInfoErrorCode);
            registerInfo.setRegisterInfo(BaseConstants.registerInfoError);
        }
        return registerInfo;
    }

    @Override
    public BaseInfo foundUserNameIsRepeat(String userName) {
        User user = userMapper.findUserNameIsRepeat(userName);
        BaseInfo registerInfo = new BaseInfo();
        if (user != null){
            registerInfo.setRegisterStatus(BaseConstants.registerInfoUserNameRepeatCode);
            registerInfo.setRegisterInfo(BaseConstants.registerInfoUserNameRepeat);
        }
        else{
            registerInfo.setRegisterStatus(BaseConstants.registerInfoUserNameNotRepeatCode);
            registerInfo.setRegisterInfo(BaseConstants.registerInfoUserNameNotRepeat);
        }
        return registerInfo;
    }

    @Override
    public User findUserBaseInfo(String userName) {
         User user = userMapper.findUserBaseInfo(userName);
         if (user != null){
             if (user.getBlobHeadPortrait() != null){
                 user.setStringHeadPortrait(new BASE64Encoder().encodeBuffer(user.getBlobHeadPortrait()));
                 user.setBlobHeadPortrait(null);
             }
         }
        return user;
    }
}
