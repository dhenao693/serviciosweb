package com.itm.servicioswebmaven.repositoty;

import com.itm.servicioswebmaven.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long>{
    User findByUser(String user);

}
