package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE" +
            "(:id is null or u.id  = :id) " +
            " AND (:idUserInfo is null or u.idUserInfo  = :idUserInfo) " +
            " AND (:user is null or u.user  = :user) " +
            " AND (:password is null or u.password  = :password) " +
            " AND (:userCreate is null or u.userCreate  = :userCreate) " +
            " AND (:dateCreate is null or u.dateCreate  = :dateCreate) "
    )
    List<User> findByFilters(
            final Long id,
            final String idUserInfo,
            final String user,
            final String password,
            final String userCreate,
            final String dateCreate
    );
}
