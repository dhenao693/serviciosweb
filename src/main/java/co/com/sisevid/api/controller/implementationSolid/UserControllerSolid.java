package co.com.sisevid.api.controller.implementationSolid;

import co.com.sisevid.api.controller.docs.UserControllerDoc;
import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.entities.Evidence;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class UserControllerSolid implements UserControllerDoc {
    @Override
    public ResponseEntity<ApiResponseDTO<EvidenceDTO>> save(Evidence evidence) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseDTO<Object>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseDTO<EvidenceDTO>> update(Evidence client) throws EntityNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseDTO<List<EvidenceDTO>>> findEvidences(Long id, String idUserInfo, String password, String user, String userCreate) throws EntityNotFoundException {
        return null;
    }


}
