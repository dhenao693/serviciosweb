package com.itm.servicioswebmaven.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GenericGenerator(name = "SEQ_VALOR", strategy = "increment")
    @GeneratedValue(generator = "SEQ_VALOR")
    private long document;

    private String user;

    private String password;

    private String name;

    private String lastname;
}
