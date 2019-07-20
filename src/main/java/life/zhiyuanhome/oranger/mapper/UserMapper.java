package life.zhiyuanhome.oranger.mapper;

import life.zhiyuanhome.oranger.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author yzy
 * @create 2019-07-18 21:26
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{Token},#{gmtCreate},#{gmtModified}) ")
    void insert(User user);

    @Select("select * from user where token = # {token}")
    User finByToken(@Param("token") String token);
}
