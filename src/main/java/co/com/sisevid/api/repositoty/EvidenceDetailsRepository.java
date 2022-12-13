package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.EvidenceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvidenceDetailsRepository extends JpaRepository<EvidenceDetails, Long> {
    List <EvidenceDetails> findByEvidenceId(Long evidenceId);
}
