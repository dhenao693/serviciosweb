package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.UserRol;
import org.springframework.data.repository.CrudRepository;

public interface UserRolCrudRepository extends CrudRepository<UserRol, Long> {
    /*@Query("SELECT ur FROM UserRol ur WHERE" +
            "(:id is null or ur.id  = :id) " +
            " AND (:user is null or ur.user  = :user) " +
            " AND (:rol is null or ur.rol  = :rol) "
    )
    List<UserRol> findByFilters(
            final Long id,
            final User user,
            final Rol rol
    );*/
}
