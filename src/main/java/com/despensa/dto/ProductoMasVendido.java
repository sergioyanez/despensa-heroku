package com.despensa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *DTO(Data Transfer Object) encargado de transportar información de producto más vendido.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *          Nicolás Carsaniga: nikitobombero@gmail.com
 *          Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 */
@Entity
public class ProductoMasVendido {
    /**
     * Identificador único
     */
    @Id
    private long id;

    /**
     * Nombre del producto
     */
    @Column
    private String nombre;

    /**
     * Cantida vendida de producto
     */
    @Column
    private long cantidad;

    /**
     * Constructor con los parámetros nombre y cantidad vendida.
     *
     * @param nombre nombre del producto mas vendido
     * @param cantidad cantidad del producto mas vendido
     */
    public ProductoMasVendido(String nombre, long cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;

    }

    /**
     * Contructor de clase
     */
    public ProductoMasVendido() {
        super();

    }

    /**
     * Getter para el atributo nombre.
     *
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter para la cantidad de producto vendido.
     *
     * @return cantidad de producto vendido.
     */
    public long getCantidad() {
        return cantidad;
    }

    /**
     * Especifica la forma en cómo se muestra un objeto de esta clase por consola.
     *
     * @return Texto con la información de un objeto de esta clase.
     */
    @Override
    public String toString() {
        return "ProductoMasVendido{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
