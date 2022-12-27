package co.com.sisevid.api.controller.docs;

import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.entities.Evidence;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface EvidencesControllerDoc {
    @Operation(summary = "Create a evidence")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Evidence created successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = EvidenceDTO.class))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<EvidenceDTO>> save(@RequestBody final Evidence evidence);

    @Operation(summary = "Delete a client")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client deleted successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ApiResponseDTO.class))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<Object>> delete(@PathVariable final Long id);

    @Operation(summary = "Update a client")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client updated successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = EvidenceDTO.class))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<EvidenceDTO>> update(@RequestBody final Evidence client) throws EntityNotFoundException;

    @Operation(summary = "Find a client by filters")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client list retrieved successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = EvidenceDTO.class)))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<List<EvidenceDTO>>> findEvidences(
            @RequestParam(name = "id", required = false) final Long id,
            @RequestParam(name = "title", required = false) final String title,
            @RequestParam(name = "description", required = false) final String description,
            @RequestParam(name = "type", required = false) final String type,
            @RequestParam(name = "typeFile", required = false) final String typeFile,
            @RequestParam(name = "typeFile", required = false) final String evidenceCreationDate,
            @RequestParam(name = "typeFile", required = false) final String evidenceRegisterDate,
            @RequestParam(name = "typeFile", required = false) final String authors,
            @RequestParam(name = "typeFile", required = false) final String observation,
            @RequestParam(name = "typeFile", required = false) final String userCreate,
            @RequestParam(name = "typeFile", required = false) final String creationDate
    ) throws EntityNotFoundException;
}
