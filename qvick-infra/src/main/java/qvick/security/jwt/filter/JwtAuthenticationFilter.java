package qvick.security.jwt.filter;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import qvick.security.jwt.JwtExtract;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtExtract jwtExtractor;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException, ExpiredJwtException {
        String token = jwtExtractor.extractTokenFromRequest(request);
        if (token != null) {
            SecurityContextHolder.getContext().setAuthentication(jwtExtractor.getAuthentication(token));
        }
        filterChain.doFilter(request, response);
    }

}
