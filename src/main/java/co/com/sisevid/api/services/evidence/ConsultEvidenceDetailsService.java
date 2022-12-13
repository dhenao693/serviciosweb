package co.com.sisevid.api.services.evidence;

import co.com.sisevid.api.dto.EvidenceDetailsDTO;

import java.util.List;

public interface ConsultEvidenceDetailsService {
    public List<EvidenceDetailsDTO> consultEvidenceDetails(Long evidenceId);
}
