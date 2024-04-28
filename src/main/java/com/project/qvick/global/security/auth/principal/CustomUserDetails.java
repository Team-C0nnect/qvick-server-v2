package com.project.qvick.global.security.auth.principal;

import com.nimbusds.jose.proc.SecurityContext;
import com.project.qvick.domain.user.presentation.dto.User;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@Slf4j
public class CustomUserDetails implements UserDetails {

    private final User user;
    private Collection<? extends GrantedAuthority> authorities;

    private CustomUserDetails(final User user, final Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    public CustomUserDetails(final User user) {
        this.user = user;
    }

    public static CustomUserDetails create(User user) {
        return new CustomUserDetails(user, Collections.singleton((GrantedAuthority) user.getUserRole()::getKey));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton((GrantedAuthority) user.getUserRole()::getKey);
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
