package com.despensa.controller;

import com.despensa.dto.ProductoMasVendido;
import com.despensa.dto.ReporteClientesMonto;
import com.despensa.model.ItemVenta;
import com.despensa.servicios.ItemVentaService;
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
 * RestController que brinda acceso a los servicios que competen a esta entidad.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *          Nicolás Carsaniga: nikitobombero@gmail.com
 *          Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see ItemVenta
 * @since 25/06/2022
 */
@RestController
@RequestMapping("/itemVenta")
public class ItemVentaController {

    /**
     * Bean(instancia única) de los servicios de itemVenta.
     *
     * @see ItemVentaService
     */
    @Autowired
    private ItemVentaService itemVentaService;

    /**
     * Controlador que provee acceso al servicio encargado de devolver el listado de ítems de ventas.
     *
     * @return listado: ItemVenta
     */
    @GetMapping("")
    @Operation(
            summary = "Devuelve el listado: ItemVenta",
            description = "Servicio encargado de devolver el listado de ítems de ventas.",
            tags = { "ItemVenta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItemVenta.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(itemVentaService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de retornar un ítem de venta con id ingresado por parámetro.
     *
     * @param id Long identificador único
     * @return ItemVenta
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Devuelve un ItemVenta",
            description = "Servicio encargado de retornar un ítem de venta con id ingresado por parámetro {id}.",
            tags = { "ItemVenta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItemVenta.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(itemVentaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de persistir un item de venta, retornando el ítem con el id asignado.
     * @param entity itemVenta a persistir.
     * @return ItemVenta
     */
    @PostMapping("")
    @Operation(
            summary = "Persiste un ItemVenta",
            description = "Servicio encargado de persistir un ítem de venta, retornando el ítem con el id asignado.",
            tags = { "ItemVenta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItemVenta.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> save(@RequestBody ItemVenta entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(itemVentaService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de actualizar el ítem de venta con el ID ingresado por parámetro, retornando el ítem actualizado.
     *
     * @param id Long identificador único
     * @param entity itemVenta con cambios
     * @return ItemVenta actualizado
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Actualiza un ItemVenta",
            description = "Servicio encargado de actualizar el ítem de venta con el ID ingresado por parámetro, retornando el ítem actualizado.",
            tags = { "ItemVenta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItemVenta.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody ItemVenta entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(itemVentaService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de eliminar el ítem de venta con el ID ingresado por parámetro.
     *
     * @param id Long identificador único
     * @return mensaje de respuesta
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Elimina un ItemVenta",
            description = "Servicio encargado de eliminar el ítem de venta con el ID ingresado por parámetro.",
            tags = { "ItemVenta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItemVenta.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(itemVentaService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de generar un reporte con la lista de productos más vendidos.
     *
     * @return Reporte de productos más vendidos.
     * @see ProductoMasVendido
     * @see ItemVentaService#getProductoMasVendido
     */
    @GetMapping("/productoMasVendido")
    @Operation(
            summary = "Devuelve el producto más vendido.",
            description = "Servicio encargado de devolver un reporte con el producto más vendido.",
            tags = { "ItemVenta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductoMasVendido.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ProductoMasVendido getProductoMasvendido(){
        return this.itemVentaService.getProductoMasVendido().get(0);
    }

    /**
     * Controlador que provee acceso al servicio encargado de generar un reporte con los clientes y su monto total.
     *
     * @return Reporte de clientes y sus respectivos montos.
     * @see ReporteClientesMonto
     * @see ItemVentaService#reporteEjercicio3
     */
    @GetMapping("/reporteMontoClientes")
    @Operation(
            summary = "Devuelve un reporte con los clientes y sus respectivos montos tottales.",
            description = "Servicio encargado de devolver un reporte con el producto más vendido.",
            tags = { "ItemVenta-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReporteClientesMonto.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public List<ReporteClientesMonto> generarReporteMontoClientes(){
        return this.itemVentaService.reporteEjercicio3();
    }

}
