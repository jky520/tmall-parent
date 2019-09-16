package com.hx.tmall.entity;

import lombok.*;

import java.io.Serializable;

@Data // getter setter toString
@NoArgsConstructor
@AllArgsConstructor
//@Slf4j
public class User implements Serializable {
    // psvm
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int status;
}
