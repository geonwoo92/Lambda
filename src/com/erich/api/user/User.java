package com.erich.api.user;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class User {
    private Long id;
    private String username;
    private String password;
    private String verify_password;
    private String name;
    private String phone;
    private Long address;
    private String job;
    private double height;
    private double weight;

    @Builder(builderMethodName = "builder")

    public User(String job, String username, String password, String verify_password,
                String name, String phone, double height, double weight) {

        this.username = username;
        this.password = password;
        this.verify_password = verify_password;
        this.name = name;
        this.phone = phone;
        this.height = height;
        this.weight = weight;
        this.job = job;
    }

    public void setPassword(String password) {
    }

}
