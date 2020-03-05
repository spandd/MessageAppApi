package com.oright.android.messageapi.web.service;

import com.oright.android.messageapi.web.mapper.SquareMapper;
import com.oright.android.messageapi.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.IOException;

@Service
public class SquareServiceImp implements SquareService {

    @Autowired
    private SquareMapper squareMapper;

    @Override
    public int editUserHeadPortrait(User user) {
        try {
            user.setBlobHeadPortrait(new BASE64Decoder().decodeBuffer(user.getStringHeadPortrait()));
            return squareMapper.editUserHeadPortrait(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
