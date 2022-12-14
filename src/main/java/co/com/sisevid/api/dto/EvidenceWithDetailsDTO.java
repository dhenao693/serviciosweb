package co.com.sisevid.api.dto;

import co.com.sisevid.api.entities.EvidenceDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EvidenceWithDetailsDTO {
    private long id;
    private String title;
    private String description;
    private String type;
    private String typeFile;
    private String evidenceCreationDate;
    private String evidenceRegisterDate;
    private String authors;
    private String observation;
    private String userCreate;
    private String creationDate;
    private String status;
    private EvidenceDetails evidenceDetail;
}
