package com.zy.alibaba.author.support;

import com.zy.alibaba.author.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DefineUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUserDetails user = userMapper.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        List<GrantedAuthority> list = new ArrayList<>();
        if(!StringUtils.isEmpty(user.getRoles())) {
            String[] arr = user.getRoles().split(";");
            for (String s : arr) {
                list.add(new SimpleGrantedAuthority(s));
            }
        }
        user.setAuthorities(list);
        return user;
//        Set<GrantedAuthority> grantedAuthorities =  new HashSet();
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("admin");
//        grantedAuthorities.add(grantedAuthority);
//        return new MyUserDetails("admin","$2a$10$ODoZJKtLmhwpdfeoU08Q7OqrpftHfWpaBGhsRG.Xw4XRk69/RkLR.",grantedAuthorities);
    }
}
