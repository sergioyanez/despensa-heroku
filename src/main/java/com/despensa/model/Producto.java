package com.despensa.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad Producto
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *			Héctor Liceaga: lice2187@gmail.com
 *			Nicolás Carsaniga: nikitobombero@gmail.com
 *			Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 */
@Getter
@Setter
@Entity 
@Data
@Table(name = "producto")
public class Producto implements Serializable {

	/**
	 *  Identificador único
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * Nombre del producto
	 */
	@Column
	private String nombre;

	/**
	 * Precio del producto
	 */
	@Column
	private float precio;

	/**
	 * Stock disponible
	 */
	@Column
	private int stock;

	/**
	 * Contructor vacío
	 */
	public Producto(){
		super();
	}

	/**
	 * Contructor con todos los atributos
	 *
	 * @param nombre nombre del producto
	 * @param stock cantidad disponible para la venta
	 * @param precio valor unitario del producto
	 */
	public Producto(String nombre, int stock, float precio) {
		this.nombre=nombre;
		this.precio= precio;
		this.stock=stock;
	}
}
