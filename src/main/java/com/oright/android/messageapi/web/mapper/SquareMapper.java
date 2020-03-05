package com.oright.android.messageapi.web.mapper;

import com.oright.android.messageapi.web.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface SquareMapper {

    @Update("update user set blob_head_portrait=#{blobHeadPortrait} where user_id=#{userId}")
    public int editUserHeadPortrait(User user);
}
