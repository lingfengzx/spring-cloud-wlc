package org.spring.cloud.WLC.base.oauth2.jwt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.spring.cloud.wlc.base.domain.user.WlcUser;

@Mapper
public interface UserMapper {
	
	@Select("select user_id userId,user_name userName,user_password userPassword"
			+ ",user_token userToken,user_desc userDesc from wlc_user where user_name = #{userName}")
	@ResultType(WlcUser.class)
	public WlcUser findByName(String userName);
	
	@Select("select role_name from wlc_user_role where user_name=#{userName}")
	@ResultType(String.class)
	public List<String> queryRoleNames(String userName);
}
