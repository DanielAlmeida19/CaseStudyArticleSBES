package br.unesp.rc.MSCondominium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unesp.rc.CondominiumModel.model.Resident;
import br.unesp.rc.CondominiumModel.service.CondominiumResidentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Resident Controller", description = "CRUD operations for Unit")
@RestController("ResidentController")
@RequestMapping("/resident")
@CrossOrigin
public class ResidentController {
    
    @Autowired
    CondominiumResidentService residentService;

    @Operation(
        summary = "Find all residents",
        description = "Find all residents in database and return a list of residents"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Returns a list of residents",
            content = @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Resident.class))
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Error.class)
            )
        )
    })
    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<?> findAll() {

        try {
            List<Resident> residents = residentService.findAll();
            return new ResponseEntity<List<Resident>>(residents, HttpStatus.OK);
        } catch (Exception e) {            
            return new ResponseEntity<Error>(new Error(e), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(
        summary = "Find resident by id",
        description = "Find a resident by id specified in path and return a resident object"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Returns a resident object",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Resident.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Error.class)
            )
        )
    })
    @GetMapping(value = "/findById/{id}", produces = "application/json")
    public ResponseEntity<?> findById(@PathVariable String id) {
        try {
            Resident resident = residentService.findById(id);
            return new ResponseEntity<Resident>(resident, HttpStatus.OK);
        } catch (Exception e) {            
            return new ResponseEntity<Error>(new Error(e), HttpStatus.BAD_REQUEST);
        }
    }

}
