package co.com.sisevid.api.controller.implementationSolid;

import co.com.sisevid.api.controller.docs.EvidencesControllerDoc;
import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.entities.Evidence;
import co.com.sisevid.api.services.implementation.EvidencesCrud;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evidencesCrud")
@CrossOrigin(origins = "*")
public class EvidenceControllerSolid implements EvidencesControllerDoc {
    private final EvidencesCrud evidencesCrud;
    private final ObjectMapper objectMapper;

    public EvidenceControllerSolid(EvidencesCrud evidencesCrud, ObjectMapper objectMapper) {

        this.evidencesCrud = evidencesCrud;
        this.objectMapper = objectMapper;
    }

    @PostMapping()
    public ResponseEntity<ApiResponseDTO<EvidenceDTO>> save(Evidence evidence) {
        final Evidence evidenceSaved = evidencesCrud.save(evidence);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseDTO.<EvidenceDTO>builder()
                        .code(HttpStatus.CREATED.value())
                        .message("Client saved successfully")
                        .data(objectMapper.convertValue(evidenceSaved, EvidenceDTO.class))
                        .build()
                );
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDTO<Object>> delete(Long id) {
        evidencesCrud.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.builder()
                        .code(HttpStatus.OK.value())
                        .message("Evidence deleted successfully")
                        .build()
                );
    }

    @PutMapping()
    public ResponseEntity<ApiResponseDTO<EvidenceDTO>> update(Evidence evidence) throws EntityNotFoundException {
        final Evidence evidenceSaved = null;
        evidencesCrud.save(evidence);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseDTO.<EvidenceDTO>builder()
                        .code(HttpStatus.CREATED.value())
                        .message("Client saved successfully")
                        .data(objectMapper.convertValue(evidenceSaved, EvidenceDTO.class))
                        .build()
                );
    }

    @GetMapping(path = "/findEvidences", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ApiResponseDTO<List<EvidenceDTO>>> findEvidences(
            @RequestParam(name = "id", required = false) final Long id,
            @RequestParam(name = "title", required = false) final String title,
            @RequestParam(name = "description", required = false) final String description,
            @RequestParam(name = "type", required = false) final String type,
            @RequestParam(name = "typeFile", required = false) final String typeFile,
            @RequestParam(name = "evidenceCreationDate", required = false) final String evidenceCreationDate,
            @RequestParam(name = "evidenceRegisterDate", required = false) final String evidenceRegisterDate,
            @RequestParam(name = "authors", required = false) final String authors,
            @RequestParam(name = "observation", required = false) final String observation,
            @RequestParam(name = "userCreate", required = false) final String userCreate,
            @RequestParam(name = "creationDate", required = false) final String creationDate
    ) throws EntityNotFoundException {
        List<Evidence> evidenceIterator = evidencesCrud.findByFilters(id, title, description, type, typeFile,
                evidenceCreationDate, evidenceRegisterDate, authors, observation, userCreate, creationDate);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.<List<EvidenceDTO>>builder()
                        .code(HttpStatus.OK.value())
                        .message("Client list retrieved successfully")
                        .data(evidenceIterator.stream().map(this::convertModelToDto).collect(Collectors.toList()))
                        .build()
                );
    }

    private EvidenceDTO convertModelToDto(Evidence evidence) {
        return objectMapper.convertValue(evidence, EvidenceDTO.class);
    }
}
