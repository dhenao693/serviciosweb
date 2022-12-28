package co.com.sisevid.api.controller.docs;

import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.dto.UserRolDTO;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.entities.UserRol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Tag(name = "Rols")
public interface UserRolControllerDoc {
    @Operation(summary = "Create a rol")
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
    ResponseEntity<ApiResponseDTO<UserRolDTO>> save(@RequestBody final UserRol userRol);

    @Operation(summary = "Delete a rol")
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

    @Operation(summary = "Update a rol")
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
    ResponseEntity<ApiResponseDTO<UserRolDTO>> update(@RequestBody final UserRol userRol) throws EntityNotFoundException;

    @Operation(summary = "Find a evidence by filters")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Rol list retrieved successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = EvidenceDTO.class)))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<List<UserRolDTO>>> findEvidences(
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
