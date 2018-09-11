package com.example.springbootldap.entity;

import lombok.Data;
import org.springframework.ldap.odm.annotations.*;

import javax.naming.Name;

@Data
@Entry(base = "ou=people,dc=moons,dc=com", objectClasses = "inetOrgPerson")
public class Person {

    @Id
    private Name id;
    @DnAttribute(value = "uid", index = 3)
    private String uid;
    @Attribute(name = "cn")
    private String commonName;
    @Attribute(name = "sn")
    private String suerName;
    private String userPassword;

}

