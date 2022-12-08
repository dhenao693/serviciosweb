package com.itm.servicioswebmaven.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private long document;
    private String user;
    private String password;
    private String name;
    private String lastname;
}
