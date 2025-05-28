package ee.valiit.groomlyback.controller.registration;

import ee.valiit.groomlyback.NewCustomer;
import ee.valiit.groomlyback.controller.registration.dto.NewGroomer;
import ee.valiit.groomlyback.infrastructure.error.ApiError;
import ee.valiit.groomlyback.services.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;


    @PostMapping("/registration-customer")
    @Operation(summary = "Kliendi registreerimine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise kasutajanimega kasutaja on juba olemas, errorCode 444", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void registerCustomer(@RequestBody NewCustomer newCustomer) {
        registrationService.registerCustomer(newCustomer);
    }


    @PostMapping("/registration-groomer")
    @Operation(summary = "Lemmiklooma iluteenindaja registreerimine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise kasutajanimega kasutaja on juba olemas, errorCode 444", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void registerGroomer(@RequestBody NewGroomer newGroomer) {
        registrationService.registerGroomer(newGroomer);
    }

}
