package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.EvidenceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvidenceDetailsRepository extends JpaRepository<EvidenceDetails, Long> {
    @Query(value = "select * from evidencia_detalle ed where ID_EVIDENCIA = ?1",
            nativeQuery = true)
    List<EvidenceDetails> findByEvidenceId(Long evidenceId);
}
