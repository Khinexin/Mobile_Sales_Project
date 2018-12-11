package com.demo.mobileproject.config;

import com.demo.mobileproject.domain.login.AppRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class HomeOauth2User implements OAuth2User {

    private final List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(AppRole.ROLE_USER);



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
