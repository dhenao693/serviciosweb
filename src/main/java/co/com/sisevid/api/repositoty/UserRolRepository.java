package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRolRepository extends JpaRepository<UserRol, Long> {
    @Query(value = "SELECT * FROM USUARIO_ROLES_INTERMEDIA uri WHERE uri.ID_USUARIO = ?1",
            nativeQuery = true)
    List<UserRol> findByUser(Long userId);
}


