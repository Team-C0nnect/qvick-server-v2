package qvick.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import qvick.security.auth.CustomUserDetails;
import qvick.security.jwt.enums.JwtType;
import qvick.security.jwt.exception.TokenTypeException;
import qvick.user.domain.mapper.UserMapper;
import qvick.user.domain.repository.jpa.UserRepository;
import qvick.user.dto.User;
import qvick.user.exception.UserNotFoundException;

@Component
@RequiredArgsConstructor
public class JwtExtract {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Authentication getAuthentication(final String token) {
        final Jws<Claims> claims = jwtProvider.getClaims(token);

        if (isWrongType(claims, JwtType.ACCESS)) {
            throw TokenTypeException.EXCEPTION;
        }

        User user = userRepository.findByEmail(claims
                .getBody()
                .getSubject())
                .map(userMapper::toUser)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        final CustomUserDetails details = new CustomUserDetails(user);

        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
    }

    public String extractTokenFromRequest(HttpServletRequest request) {
        return extractToken(request.getHeader(HttpHeaders.AUTHORIZATION));
    }

    public String extractToken(final String token) {
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return token;
    }

    public boolean isWrongType(final Jws<Claims> claims, final JwtType jwtType) {
        return !(claims.getHeader().get(Header.JWT_TYPE).equals(jwtType.toString()));
    }

}
