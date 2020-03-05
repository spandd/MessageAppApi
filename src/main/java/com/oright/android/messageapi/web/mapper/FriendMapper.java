package com.oright.android.messageapi.web.mapper;
        import com.oright.android.messageapi.web.model.Friend;
        import com.oright.android.messageapi.web.model.User;
        import org.apache.ibatis.annotations.*;

        import java.util.List;

@Mapper
public interface FriendMapper {

    @Select("select user_id,user_name,birthday_month,birthday_day,blob_head_portrait from user where user_id=#{friendId}")
    public User findDisAddFriend(Integer friendId);

    @Select("select * from friend where user_id=#{userId} and friend_id=#{friendId}")
    public Friend findFriend(Integer userId, Integer friendId);

    @Select("select * from friend where user_id=#{userId}")
    public List<Friend> findFriend2(Integer userId);

    @Insert("insert into friend(user_id,friend_id,friend_name,friend_birthday_month,friend_birthday_day,me_is_accept) select #{userId}," +
            "user_id,user_name,birthday_month,birthday_day,#{meIsAccept} " +
            "from user where user_id=#{friendId}")
    public int addFriend1(Integer userId,Integer friendId,int meIsAccept);

    @Insert("insert into friend(user_id,friend_id,friend_name,friend_birthday_month,friend_birthday_day,friend_is_accept) select #{userId}," +
            "user_id,user_name,birthday_month,birthday_day,#{friendIsAccept} " +
            "from user where user_id=#{friendId}")
    public int addFriend2(Integer userId,Integer friendId,int friendIsAccept);

    @Update("update friend set me_is_accept=1 where user_id=#{userId} and friend_id=#{friendId}")
    public int acceptAddFriendRequest1(Integer userId,Integer friendId);

    @Update("update friend set friend_is_accept=1 where user_id=#{userId} and friend_id=#{friendId}")
    public int acceptAddFriendRequest2(Integer userId,Integer friendId);

    @Delete("delete from friend where user_id=#{userId} and friend_id=#{friendId}")
    public int deleteFriend(Integer userId,Integer friendId);

    @Delete("delete from chat where user_id=#{userId} and friend_id=#{friendId}")
    public int deleteChatCache(Integer userId,Integer friendId);
}
