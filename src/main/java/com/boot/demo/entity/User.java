package com.boot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    private Integer  id;
    private String username;
    private String password;
    private Integer plat;
    private Date registdate;

    public User(String username, String password, int plat) {
        this.username = username;
        this.password = password;
        this.plat = plat;
        this.registdate = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", plat=" + plat +
                ", registdate=" + registdate +
                '}';
    }
}
