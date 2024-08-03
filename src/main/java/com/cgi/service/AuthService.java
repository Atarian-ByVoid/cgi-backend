package com.cgi.service;

import java.util.Base64;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cgi.auth.CustomDetailsService;
import com.cgi.auth.JwtService;
import com.cgi.errors.ErrorException;
import com.cgi.representation.AuthDetails;
import com.cgi.representation.records.AccessToken;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@SuppressWarnings("null")
public class AuthService {
    private final static String AUTHORIZATION = "Authorization";

    private final static String BASIC = "Basic ";

    private final CustomDetailsService customDetailsService;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AccessToken login() {
        String[] credentials = getCredentials();

        UserDetails userDetails = customDetailsService.loadUserByUsername(credentials[0]);

        if (Objects.isNull(userDetails)) {
            throw new ErrorException(HttpStatus.UNAUTHORIZED,
                    "Credencias incorretas.",
                    "Unauthorized");
        }

        if (!new BCryptPasswordEncoder().matches(credentials[1], userDetails.getPassword())) {
            throw new ErrorException(HttpStatus.UNAUTHORIZED,
                    "Credencias incorretas.",
                    "Unauthorized");
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                credentials[0], credentials[1]);

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        return jwtService.generateToken((AuthDetails) authenticate.getPrincipal());
    }

    private String[] getCredentials() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();

        if (Objects.isNull(servletRequestAttributes)) {
            throw new ErrorException(HttpStatus.BAD_REQUEST,
                    "Não foi possivel concluir a requisição.",
                    "Unauthorized");
        }

        HttpServletRequest request = servletRequestAttributes.getRequest();

        if (!existsHeaderAuthorization(request)) {
            throw new ErrorException(HttpStatus.UNAUTHORIZED,
                    "Sem autorização",
                    "Unauthorized");
        }

        return base64Decoded(request.getHeader(AUTHORIZATION).replace(BASIC, "")).split(":");
    }

    private String base64Decoded(String request) {
        byte[] decode = Base64.getDecoder().decode(request);

        return new String(decode);
    }

    private boolean existsHeaderAuthorization(HttpServletRequest request) {
        String header = request.getHeader(AUTHORIZATION);

        return Objects.nonNull(header) && header.startsWith(BASIC);
    }

}
