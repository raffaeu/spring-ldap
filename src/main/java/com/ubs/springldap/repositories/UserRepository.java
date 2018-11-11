package com.ubs.springldap.repositories;

import com.ubs.springldap.models.User;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends LdapRepository<User> {
    User findByUsername(String username);
}
