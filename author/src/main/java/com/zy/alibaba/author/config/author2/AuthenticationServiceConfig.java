package com.zy.alibaba.author.config.author2;

import com.zy.alibaba.author.support.DefineClientDetailsService;
import com.zy.alibaba.author.support.DefineUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;


@Configuration
@EnableAuthorizationServer
public class AuthenticationServiceConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private DefineUserDetailService userDetailsService;

    @Autowired
    private DefineClientDetailsService defineClientDetailsService;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许表单认证
        security.allowFormAuthenticationForClients();
        security
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置客户端
//        clients.inMemory()   // 基于内存
//                .withClient("client1")  //授权客户端
//                .secret(passwordEncoder.encode("admin"))  //授权码
//                .accessTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(1))  // 授权过期时间
//                .authorizedGrantTypes("password", "refresh_token")  // 授权模式
//                .scopes("app") ; // 授权范围

        clients.withClientDetails(defineClientDetailsService);
    }


    /**
     * 注入authenticationManager
     * 来支持 password grant type
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore)
                .userDetailsService(userDetailsService);
    }
}
