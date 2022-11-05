package com.fastporte.fastportewebservice.controller;


import com.fastporte.fastportewebservice.entities.Experience;
import com.fastporte.fastportewebservice.entities.Vehicle;
import com.fastporte.fastportewebservice.service.IVehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    //Retornar driver por id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> findVehicleById(@PathVariable("id") Long id) {
        try {
            Optional<Vehicle> vehicle = vehicleService.getById(id);
            if (vehicle.isPresent())
                return new ResponseEntity<>(vehicle.get(), HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //@GetMapping(value = "/find/{type_card}/{category}/{quantity}",
    //        produces = MediaType.APPLICATION_JSON_VALUE)
    //public ResponseEntity<List<Vehicle>> finByType_cardQuantityCategory(
    //        @PathVariable("type_card") String type_card,
    //        @PathVariable("quantity") Long quantity,
    //        @PathVariable("category") String category) {
    //    try {
    //        List<Vehicle> vehicle = vehicleService.finByType_cardQuantityCategory(type_card, quantity, category);
    //        if (vehicle == null)
    //            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    //    } catch (Exception ex) {
    //        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //    }
    //}
    // Insertar vehicle
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Insert Vehicle", notes="Method to insert a vehicle")
    @ApiResponses({
            @ApiResponse(code=201, message="Vehicle created"),
            @ApiResponse(code=404, message="Vehicle not created"),
            @ApiResponse(code=501, message="Vehicle server error")
    })
    public ResponseEntity<Vehicle> insertExperience(@Valid @RequestBody Vehicle vehicle) {
        try {
            Vehicle vehicleNew = vehicleService.save(vehicle);
            return ResponseEntity.status(HttpStatus.CREATED).body(vehicleNew);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Actualizar vehicle
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Update Vehicle", notes="Method to update a vehicle")
    @ApiResponses({
            @ApiResponse(code=201, message="Vehicle updated"),
            @ApiResponse(code=404, message="Vehicle not updated"),
            @ApiResponse(code=501, message="Vehicle server error")
    })
    public ResponseEntity<Vehicle> updateClient(@PathVariable("id") Long id,
                                                   @Valid @RequestBody Vehicle vehicle) {
        try {
            Optional<Vehicle> vehicleUpdate = vehicleService.getById(id);
            if (!vehicleUpdate.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            vehicle.setId(id);
            vehicleService.save(vehicle);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Eliminar vehicle
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Delete Vehicle", notes="Method to delete a vehicle")
    @ApiResponses({
            @ApiResponse(code=201, message="Vehicle deleted"),
            @ApiResponse(code=404, message="Vehicle not deleted"),
            @ApiResponse(code=501, message="Vehicle server error")
    })
    public ResponseEntity<Vehicle> deleteExperience(@PathVariable("id") Long id) {
        try {
            Optional<Vehicle> vehicleDelete = vehicleService.getById(id);
            if (!vehicleDelete.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            vehicleService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
