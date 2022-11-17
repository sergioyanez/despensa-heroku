package com.despensa.controller;

import com.despensa.dto.ReporteVentasPorDia;
import com.despensa.model.Venta;
import com.despensa.servicios.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController que Venta brinda acceso a los servicios que competen a esta entidad.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *          Nicolás Carsaniga: nikitobombero@gmail.com
 *          Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Venta
 * @since 25/06/2022
 */
@RestController
@RequestMapping("/venta")
//@Tag(name = "Venta-controller", descripcion = "Endpoints de manejo de ventas")
public class VentaController {

    /**
     * Bean(instancia única) de los servicios de Venta.
     *
     * @see VentaService
     */
    @Autowired
    private VentaService ventaService;

    /**
     * Controlador que provee acceso al servicio encargado de devolver el listado de ventas y sus clientes asociados.
     *
     * @return Listado: Venta
     */
    @GetMapping("")
    @Operation(
            summary = "Devuelve el listado: Ventas",
            description = "Servicio encargado de devolver el listado de ventas y sus clientes asociados.",
            tags = { "Venta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> getAll() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ventaService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de devolver una venta con id ingresado por parámetro.
     *
     * @param id Long identificador único
     * @return Venta
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Devuelve una venta",
            description = "Servicio encargado de retornar una venta con id ingresado por parámetro {id}.",
            tags = { "Venta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ventaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
        }
    }


    /**
     * Controlador que provee acceso al servicio encargado de persistir una venta, retornando la venta con el id asignado.
     *
     * @param entity venta a persistir
     * @return Venta
     */
    @PostMapping("")
    @Operation(
            summary = "Persiste una Venta",
            description = "Servicio encargado de persistir una venta, retornando la venta con el id asignado.",
            tags = { "Venta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>save(@RequestBody Venta entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ventaService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de actualizar la venta con el ID ingresado por parámetro, retornando la venta actualizada.
     *
     * @param id Long identificador único
     * @param entity venta con cambios
     * @return Venta actualizada
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Actualiza una Venta",
            description = "Servicio encargado de actualizar la venta con el ID ingresado por parámetro, retornando la venta actualizada.",
            tags = { "Venta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody Venta entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ventaService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de eliminar la venta con el ID ingresado por parámetro.
     *
     * @param id Long identificador único
     * @return mensaje de respuesta
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Elimina una Venta",
            description = "Servicio encargado de eliminar la venta con el ID ingresada por parámetro.",
            tags = { "Venta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ventaService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de generar un reporte de ventas por día.
     *
     * @return Reporte de ventas por día.
     * @see ReporteVentasPorDia
     * @see VentaService#reporteEjercicio4
     */
    @GetMapping("/ventasPorDia")
    @Operation(
            summary = "Devuelve el reporte de ventas por día.",
            description = "Servicio encargado de devolver el reporte de ventas por día.",
            tags = { "Venta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReporteVentasPorDia.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public List<ReporteVentasPorDia> generarReporteDeVentasPorDia(){
        return this.ventaService.reporteEjercicio4();
    }

}
