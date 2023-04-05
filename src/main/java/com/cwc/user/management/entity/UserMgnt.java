package com.cwc.user.management.entity;

import lombok.*;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

@Entity
public class UserMgnt {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    private String firstname;
    private String lastname;
    private String emailId;
}
