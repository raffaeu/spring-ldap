package com.ubs.springldap.controllers;

import com.ubs.springldap.models.User;
import com.ubs.springldap.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<SimpleGrantedAuthority> authorities =
                (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext()
                        .getAuthentication().getAuthorities();

        User user = userRepository.findByUsername(authentication.getName());
        return new StringBuilder()
                .append("Welcome ")
                .append(authentication.getName())
                .append("<br />your name is: ")
                .append(user.getFullName())
                .append("<br />your PIN is: ")
                .append(user.getgPin())
                .append("<br />Granted Authority is: ")
                .append(authorities.stream().map(a -> a.getAuthority()).collect(Collectors.joining(", ")))
                .toString();
    }
}