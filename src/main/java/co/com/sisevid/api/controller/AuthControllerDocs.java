package co.com.sisevid.api.controller;

import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.dto.security.JwtDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Tag(name = "Auth")
public interface AuthControllerDocs {

    @Operation(summary = "Create a token")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Token created successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = JwtDto.class))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<JwtDto>> getAuthorization();
}
