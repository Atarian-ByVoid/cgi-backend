package com.cgi.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cgi.repository.UsuarioRepository;

@Service
public class CustomDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.loadUserByUsername(email);
    }

}
