package co.com.sisevid.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EvidenceDTO {
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
}
