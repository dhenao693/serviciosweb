package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.Evidence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvidenceCrudRepository extends CrudRepository<Evidence, Long> {
    @Query("SELECT e FROM Evidence e WHERE" +
            "(:id is null or e.id  = :id) " +
            " AND (:title is null or e.title  = :title) " +
            " AND (:description is null or e.description  = :description) " +
            " AND (:type is null or e.type  = :type) " +
            " AND (:typeFile is null or e.typeFile  = :typeFile) " +
            " AND (:evidenceCreationDate is null or e.evidenceCreationDate  = :evidenceCreationDate) " +
            " AND (:evidenceRegisterDate is null or e.evidenceRegisterDate  = :evidenceRegisterDate) " +
            " AND (:authors is null or e.authors  = :authors) " +
            " AND (:observation is null or e.observation  = :observation) " +
            " AND (:userCreate is null or e.userCreate  = :userCreate) " +
            " AND (:creationDate is null or e.creationDate  = :creationDate) "
    )
    List<Evidence> findByFilters(
            final Long id,
            final String title,
            final String description,
            final String type,
            final String typeFile,
            final String evidenceCreationDate,
            final String evidenceRegisterDate,
            final String authors,
            final String observation,
            final String userCreate,
            final String creationDate
    );
}
