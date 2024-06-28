package qvick.common.repository;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import qvick.security.auth.CustomUserDetails;
import qvick.user.dto.User;

@Repository
public class UserSecurityImpl implements UserSecurity{

    @Override
    public User getUser() {
        return ((CustomUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getUser();
    }

}
