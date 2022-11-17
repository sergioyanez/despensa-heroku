package com.despensa.dto;

import javax.persistence.*;
import java.time.LocalDate;

/**
 *DTO(Data Transfer Object) encargado de transportar información de las ventas por día.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *          Nicolás Carsaniga: nikitobombero@gmail.com
 *          Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 */
@Entity
public class ReporteVentasPorDia {

    /**
     * Identificador único
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    /**
     * Fecha en la que se efectuó la venta
     */
    @Column
    private LocalDate fecha;

    /**
     * Nombre del producto vendido
     */
    @Column
    private String nombreProducto;

    /**
     * Sumatoria de las cantidades vendidas
     */
    @Column
    private long cantidadVentas;

    /**
     * Constructor de clase
     */
    public ReporteVentasPorDia() {
        super();
    }

    /**
     * Constructor con los parámetros fecha y cantidades vendidas.
     *
     * @param fecha en la que se realizó la venta.
     * @param cantidadVentas cantidades vendidas.
     */
    public ReporteVentasPorDia(LocalDate fecha, long cantidadVentas) {
        this.fecha = fecha;
        this.cantidadVentas = cantidadVentas;
    }

    /**
     * Constructor con los parámetros fecha, nombre del producto y cantidades vendidas.
     *
     * @param fecha fecha en la que se realizó la venta.
     * @param nombreProducto nombre del producto.
     * @param cantidadVentas cantidadVentas cantidades vendidas.
     */
    public ReporteVentasPorDia(LocalDate fecha, String nombreProducto, long cantidadVentas) {
        this.fecha = fecha;
        this.nombreProducto = nombreProducto;
        this.cantidadVentas = cantidadVentas;
    }

    /**
     * Getter para el atributo nombre del producto.
     *
     * @return nombredel producto.
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Getter del atributo fecha.
     *
     * @return fecha en la que se efectuó la venta.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Getter del atributo cantidad de producto vendido.
     *
     * @return cantidad de producot vendido.
     */
    public long getCantidadVentas() {
        return cantidadVentas;
    }

    /**
     * Especifica la forma en cómo se muestra un objeto de esta clase por consola.
     *
     * @return Texto con la información de un objeto de esta clase.
     */
    @Override
    public String toString() {
        return "ReporteVentasPorDia{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", producto='" + nombreProducto + '\'' +
                ", cantidad de ventas=" + cantidadVentas +
                '}';
    }
}
