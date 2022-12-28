package co.com.sisevid.api.controller.docs;

import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.dto.UserInfoContactDTO;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.entities.UserInfoContact;
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

@Tag(name = "UserInfo")
public interface UserInfoControllerDoc {
    @Operation(summary = "Create a user info")
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
    ResponseEntity<ApiResponseDTO<UserInfoContactDTO>> save(@RequestBody final UserInfoContact evidence);

    @Operation(summary = "Delete a user info")
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

    @Operation(summary = "Update a user info")
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
    ResponseEntity<ApiResponseDTO<UserInfoContactDTO>> update(@RequestBody final UserInfoContact userInfoContact) throws EntityNotFoundException;

    @Operation(summary = "Find a user info by filters")
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
    ResponseEntity<ApiResponseDTO<List<UserInfoContactDTO>>> findUsers(
            @RequestParam(name = "id", required = false) final Long id,
            @RequestParam(name = "documentType", required = false) final String documentType,
            @RequestParam(name = "documentNumber", required = false) final String documentNumber,
            @RequestParam(name = "name", required = false) final String name,
            @RequestParam(name = "lastName", required = false) final String lastName,
            @RequestParam(name = "phone", required = false) final String phone,
            @RequestParam(name = "email", required = false) final String email,
            @RequestParam(name = "userCreate", required = false) final String userCreate,
            @RequestParam(name = "dateCreate", required = false) final String dateCreate
    ) throws EntityNotFoundException;
}