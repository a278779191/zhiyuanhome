package life.zhiyuanhome.oranger.mapper;

import life.zhiyuanhome.oranger.model.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @author yzy
 * @create 2019-07-18 21:26
 */
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmt_create},#{gmt_modified}) ")
    void insert(User user);



}
