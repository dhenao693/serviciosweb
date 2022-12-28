package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.UserInfoContact;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoCrudRepository extends CrudRepository<UserInfoContact, Long> {
    /*@Query("SELECT uic FROM UserInfoContact uic WHERE" +
            "(:id is null or uic.id  = :id) " +
            " AND (:documentType is null or uic.documentType  = :documentType) " +
            " AND (:documentNumber is null or uic.documentNumber  = :documentNumber) " +
            " AND (:name is null or uic.name  = :name) " +
            " AND (:lastName is null or uic.lastName  = :lastName) " +
            " AND (:phone is null or uic.phone  = :phone) " +
            " AND (:email is null or uic.email  = :email) " +
            " AND (:userCreate is null or uic.userCreate  = :userCreate) " +
            " AND (:dateCreate is null or uic.dateCreate  = :dateCreate) "
    )
    List<UserInfoContact> findByFilters(
            final Long id,
            final String documentType,
            final String documentNumber,
            final String name,
            final String lastName,
            final String phone,
            final String email,
            final String userCreate,
            final String dateCreate
    );*/
}


