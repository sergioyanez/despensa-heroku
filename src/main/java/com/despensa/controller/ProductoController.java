package com.despensa.controller;


import com.despensa.model.Producto;
import com.despensa.servicios.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * El RestController de Producto brinda acceso a los servicios que competen a esta entidad.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *          Nicolás Carsaniga: nikitobombero@gmail.com
 *          Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Producto
 * @since 25/06/2022
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {

    /**
     * Bean(instancia única) de los servicios de Producto.
     *
     * @see ProductoService
     */
    @Autowired
    private ProductoService productoService;


    /**
     * Controlador que provee acceso al servicio encargado de devolver el listado de productos.
     *
     * @return listado: Productos
     */
    @GetMapping("")
    @Operation(
            summary = "Devuelve el listado: Productos",
            description = "Servicio encargado de devolver el listado de productos.",
            tags = { "Producto-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productoService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de retornar un producto con id ingresado por parámetro.
     *
     * @param id Long identificador único
     * @return Producto
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Devuelve un producto",
            description = "Servicio encargado de retornar un producto con id ingresado por parámetro {id}.",
            tags = { "Producto-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productoService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de persistir un producto, retornando el producto con el id asignado.
     *
     * @param entity producto a persistir
     * @return Producto
     */
    @PostMapping("")
    @Operation(
            summary = "Persiste un producto",
            description = "Servicio encargado de persistir un producto, retorna el producto con el id asignado.",
            tags = { "Producto-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>save(@RequestBody Producto entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productoService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error.  Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de actualizar un producto con el ID especificado.
     *
     * @param id identificador único.
     * @param entity producto con cambios
     * @return Producto actualizado
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Actualiza un producto",
            description = "Servicio encargado de actualizar un producto con el ID especificado, devolviendo el producto actualizado.",
            tags = { "Producto-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody Producto entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productoService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de eliminar un producto con el ID especificado.
     *
     * @param id Long identificador único
     * @return mensaje de respuesta
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Elimina un producto",
            description = "Servicio encargado de eliminar un producto con el ID especificado.",
            tags = { "Producto-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productoService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

}
