package qvick.security.auth;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import qvick.user.dto.User;

import java.util.Collection;
import java.util.Collections;

@Getter
@Slf4j
public class CustomUserDetails implements UserDetails {

    private final User user;
    private final Collection<? extends GrantedAuthority> authorities;

    private CustomUserDetails(final User user, final Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    public CustomUserDetails(final User user) {
        this.user = user;
        this.authorities = Collections.singleton(() -> user.getUserRole().getKey());
    }

    public static CustomUserDetails create(User user) {
        return new CustomUserDetails(user, Collections.singleton((GrantedAuthority) user.getUserRole()::getKey));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> user.getUserRole().getKey());
//        return authorities;
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
