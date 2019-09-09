package com.hx.tmall.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data // getter setter toString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class User {
    // psvm
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int status;
}
