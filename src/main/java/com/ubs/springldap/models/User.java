package com.ubs.springldap.models;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Entry(
        base = "ou=people,dc=springframework,dc=org",
        objectClasses = { "person", "inetOrgPerson", "top" })
public class User {
    @Id
    private Name id;

    private @Attribute(name = "uid") String username;
    private @Attribute(name = "cn") String fullName;
    private @Attribute(name = "gpin") String gPin;

    public String getFullName() {
        return fullName;
    }

    public String getgPin() {
        return gPin;
    }
}