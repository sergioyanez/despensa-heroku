package com.despensa.controller;

import com.despensa.servicios.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.despensa.model.Cliente;

/**
 * RestController de cliente brinda acceso a los servicios que competen a esta entidad.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *          Nicolás Carsaniga: nikitobombero@gmail.com
 *          Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Cliente
 * @since 25/06/2022
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    /**
     * Bean(instancia única) de los servicios de cliente.
     *
     * @see ClienteService
     */
	@Autowired
	private ClienteService clienteService;

    /**
     * Controlador que provee acceso al servicio encargado de devolver el listado de clientes.
     *
     * @return listado: Cliente
     */
    @GetMapping("")
    @Operation(
            summary = "Devuelve el listado: Cliente",
            description = "Servicio encargado de devolver el listado de clientes.",
            tags = { "Cliente-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de retornar un cliente con id ingresado por parámetro
     * @param id identificador único
     * @return Cliente
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Devuelve un cliente",
            description = "Servicio encargado de retornar un cliente con id ingresado por parámetro {id}.",
            tags = { "Cliente-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de persistir un cliente, retornando el cliente con el id asignado.
     *
     * @param entity Cliente a persistir.
     * @return Cliente c
     */
    @PostMapping("")
    @Operation(
            summary = "Persiste un Cliente",
            description = "Servicio encargado de persistir un cliente, retornando el cliente con el id asignado.",
            tags = { "Cliente-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> save(@RequestBody Cliente entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de actualizar el cliente con el ID ingresado por parámetro, retornando el cliente actualizado.
     *
     * @param id  identificador único
     * @param entity cliente con cambios
     * @return cliente actualizado
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Actualiza un Cliente",
            description = "Servicio encargado de actualizar el cliente con el ID ingresado por parámetro, retornando el cliente actualizado.",
            tags = { "Cliente-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Cliente entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de eliminar el cliente con el ID ingresado por parámetro.
     *
     * @param id identificador único
     * @return mensaje de respuesta
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Elimina una Cliente",
            description = "Servicio encargado de eliminar el cliente con el ID ingresado por parámetro.",
            tags = { "Cliente-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clienteService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }
	
}
