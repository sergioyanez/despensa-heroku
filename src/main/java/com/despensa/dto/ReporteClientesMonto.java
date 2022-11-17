package com.despensa.dto;

import javax.persistence.*;

/**
 *DTO(Data Transfer Object) encargado de transportar información de los clientes y montos totales.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *          Nicolás Carsaniga: nikitobombero@gmail.com
 *          Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 */
@Entity
public class ReporteClientesMonto {

    /**
     * Identificador único
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    /**
     * Nombre del producto
     */
    @Column
    private String nombre;

    /**
     * Monto total del cliente
     */
    @Column
    private double monto;

    /**
     * Contructor de clase
     */
    public ReporteClientesMonto() {
        super();
    }

    /**
     * Contructor con los parámetros nombre y monto total.
     *
     * @param nombre nombredel cliente
     * @param monto cantidad de dinero a pagar por el cliente
     */
    public ReporteClientesMonto(String nombre, double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    /**
     * Getter para el atributo nombre.
     *
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter para el atributo monto.
     *
     * @return monto total del cliente.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Especifica la forma en cómo se muestra un objeto de esta clase por consola.
     *
     * @return Texto con la información de un objeto de esta clase.
     */
    @Override
    public String toString() {
        return "ReporteClientesMonto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", monto=" + monto +
                '}';
    }
}
