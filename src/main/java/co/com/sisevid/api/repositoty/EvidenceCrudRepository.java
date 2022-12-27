package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.Evidence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvidenceCrudRepository extends CrudRepository<Evidence, Long> {
    @Query("SELECT e FROM EVIDENCIA e "
            /*"WHERE (:id IS NULL OR e.ID_EVIDENCIA = :id) "
            "SELECT e FROM EVIDENCIA e WHERE" +
            "(:id is null or e.ID_EVIDENCIA  = :id) " +
            " AND (:title is null or e.TITULO  = :title) " +
            " AND (:description is null or e.DESCRIPCIÓN  = :description) " +
            " AND (:type is null or e.TIPO  = :type) " +
            " AND (:typeFile is null or e.TIPO_ARCHIVO  = :typeFile) " +
            " AND (:evidenceCreationDate is null or e.FECHA_CREACION_EVIDENCIA  = :evidenceCreationDate) " +
            " AND (:evidenceRegisterDate is null or e.FECHA_REGISTRO_EVIDENCIA  = :evidenceRegisterDate) " +
            " AND (:authors is null or e.AUTORES  = :authors) " +
            " AND (:observation is null or e.OBSERVACION  = :observation) " +
            " AND (:userCreate is null or e.USUARIO_CREACION  = :userCreate) " +
            " AND (:creationDate is null or e.FECHA_CREACION  = :creationDate) "*/
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
