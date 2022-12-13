package co.com.sisevid.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EvidenceDetailsDTO {
    private long id;
    private String evidenceId;
    private String userUpdate;
    private String dateUpdate;
    private String status;
    private String active;
}
