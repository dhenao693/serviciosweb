package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <User, Long>{
    User findByUser(String user);

}
