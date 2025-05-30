package br.unesp.rc.MSReservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unesp.rc.ReservationModel.model.RentableArea;
import br.unesp.rc.ReservationModel.service.ReservationRentableAreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Rentable Area Controller", description = "CRUD operations for rentable areas")
@RestController("RentableAreaController")
@RequestMapping("/rentableArea")
@CrossOrigin
public class RentableAreaController {
    
    @Autowired
    ReservationRentableAreaService rentableAreaService;

    @Operation(
        summary = "Find all rentable areas",
        description = "Find all rentable areas in database and return a list of rentable areas"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Returns a list of rentable areas",
            content = @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = RentableArea.class))
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
    public ResponseEntity<?> findAll()  {

        try {
            List<RentableArea> rentableAreas = rentableAreaService.findAll();

            return new ResponseEntity<List<RentableArea>>(rentableAreas, HttpStatus.OK);
        } catch (Exception e) {
            
            return new ResponseEntity<Error>(new Error(e), HttpStatus.BAD_REQUEST);
        }
    }


    @Operation(
        summary = "Find a rentable area by ID",
        description = "Find a rentable area by id specified in path and return a rentable area object"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Returns a rentable area object",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = RentableArea.class)
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
    public ResponseEntity<?> findById(@PathVariable Long id) {
       
        try {
            RentableArea rentableArea = rentableAreaService.findById(id);

            return new ResponseEntity<RentableArea>(rentableArea, HttpStatus.OK);
        } catch (Exception e) {
            
            return new ResponseEntity<Error>(new Error(e), HttpStatus.BAD_REQUEST);
        }
    }

}
