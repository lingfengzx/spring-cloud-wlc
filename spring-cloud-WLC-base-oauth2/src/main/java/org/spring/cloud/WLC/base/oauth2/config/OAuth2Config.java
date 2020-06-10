package org.spring.cloud.WLC.base.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * POST /oauth/authorize 授权码模式认证授权接口 GET/POST /oauth/token 获取 token 的接口 POST
 * /oauth/check_token 检查 token 合法性接口
 * 
 * @author zxk
 *
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

	@Autowired
	public PasswordEncoder passwordEncoder;

	@Autowired
	public UserDetailsService kiteUserDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenStore redisTokenStore;

	/**
	 * authenticationManage() 调用此方法才能支持 password 模式。 userDetailsService() 设置用户验证服务。
	 * tokenStore() 指定 token 的存储方式。
	 * tokenServices设置token过期时间。
	 */
	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		/**
		 * redis token 方式
		 */
		endpoints.authenticationManager(authenticationManager).userDetailsService(kiteUserDetailsService)
				.tokenStore(redisTokenStore);
		

	}

	/**
	 * ClientId、Client-Secret：这两个参数对应请求端定义的 cleint-id 和 client-secret
	 * 
	 * authorizedGrantTypes 可以包括如下几种设置中的一种或多种：
	 * 
	 * authorization_code：授权码类型。 implicit：隐式授权类型。 password：资源所有者（即用户）密码类型。
	 * client_credentials：客户端凭据（客户端ID以及Key）类型。 refresh_token：通过以上授权获得的刷新令牌来获取新的令牌。
	 * 
	 * accessTokenValiditySeconds：token 的有效期
	 * 
	 * scopes：用来限制客户端访问的权限，在换取的 token 的时候会带上 scope 参数，只有在 scopes 定义内的，才可以正常换取 token。
	 * 
	 * 上面代码中是使用 inMemory 方式存储的，将配置保存到内存中，相当于硬编码了。正式环境下的做法是持久化到数据库中，比如 mysql 中。
	 *
	 * 
	 * 数据库方式：
	 *
	 * 在数据库中增加表，并插入数据
	 * 
	 * create table oauth_client_details ( client_id VARCHAR(256) PRIMARY KEY,
	 * resource_ids VARCHAR(256), client_secret VARCHAR(256), scope VARCHAR(256),
	 * authorized_grant_types VARCHAR(256), web_server_redirect_uri VARCHAR(256),
	 * authorities VARCHAR(256), access_token_validity INTEGER,
	 * refresh_token_validity INTEGER, additional_information VARCHAR(4096),
	 * autoapprove VARCHAR(256) ); INSERT INTO oauth_client_details (client_id,
	 * client_secret, scope, authorized_grant_types, web_server_redirect_uri,
	 * authorities, access_token_validity, refresh_token_validity,
	 * additional_information, autoapprove) VALUES ('user-client',
	 * '$2a$10$o2l5kA7z.Caekp72h5kU7uqdTDrlamLq.57M1F6ulJln9tRtOJufq', 'all',
	 * 'authorization_code,refresh_token,password', null, null, 3600, 36000, null,
	 * true);
	 * 
	 * INSERT INTO oauth_client_details (client_id, client_secret, scope,
	 * authorized_grant_types, web_server_redirect_uri, authorities,
	 * access_token_validity, refresh_token_validity, additional_information,
	 * autoapprove) VALUES ('order-client',
	 * '$2a$10$GoIOhjqFKVyrabUNcie8d.ADX.qZSxpYbO6YK4L2gsNzlCIxEUDlW', 'all',
	 * 'authorization_code,refresh_token,password', null, null, 3600, 36000, null,
	 * true);
	 * 
	 * 注意： client_secret 字段不能直接是 secret 的原始值，需要经过加密。因为是用的
	 * BCryptPasswordEncoder，所以最终插入的值应该是经过 BCryptPasswordEncoder.encode()之后的值。
	 * 
	 * 然后在配置文件 application.yml 中添加关于数据库的配置
	 * 
	 * spring: datasource: url:
	 * jdbc:mysql://localhost:3306/spring_cloud?characterEncoding=UTF-8&useSSL=false
	 * username: root password: password hikari: connection-timeout: 30000
	 * idle-timeout: 600000 max-lifetime: 1800000 maximum-pool-size: 9
	 * 
	 * Spring Boot 2.0 之后默认使用 hikari 作为数据库连接池。如果使用其他连接池需要引入相关包，然后对应的增加配置。
	 * 
	 * 在 OAuth2 配置类(OAuth2Config)中增加 DataSource 的注入
	 * 
	 * @Autowired private DataSource dataSource;
	 * 
	 *            将 public void configure(ClientDetailsServiceConfigurer
	 *            clients)重写方法修改为如下：
	 * 
	 * @Override public void configure(ClientDetailsServiceConfigurer clients)
	 *           throws Exception { JdbcClientDetailsServiceBuilder jcsb =
	 *           clients.jdbc(dataSource); jcsb.passwordEncoder(passwordEncoder); }
	 * 
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("order-client").secret(passwordEncoder.encode("order-secret-8888"))
				.authorizedGrantTypes("refresh_token", "authorization_code", "password")
				.accessTokenValiditySeconds(3600).scopes("all")
				.and().withClient("user-client")
				.secret(passwordEncoder.encode("user-secret-8888"))
				.authorizedGrantTypes("refresh_token", "authorization_code", "password")
				.accessTokenValiditySeconds(3600).scopes("all");
	}

	/**
	 * 限制客户端访问认证接口的权限。 security.allowFormAuthenticationForClients();
	 * security.checkTokenAccess("isAuthenticated()");
	 * security.tokenKeyAccess("isAuthenticated()");
	 * 
	 * 第一行代码是允许客户端访问 OAuth2 授权接口，否则请求 token 会返回 401。
	 * 
	 * 第二行和第三行分别是允许已授权用户访问 checkToken 接口和获取 token 接口。
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients();
		security.checkTokenAccess("isAuthenticated()");
		security.tokenKeyAccess("isAuthenticated()");
	}
}