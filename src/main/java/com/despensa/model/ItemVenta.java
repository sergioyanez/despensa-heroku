package com.despensa.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad ItemVenta
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *			Héctor Liceaga: lice2187@gmail.com
 *			Nicolás Carsaniga: nikitobombero@gmail.com
 *			Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Producto
 * @see Venta
 * @since 25/06/2022
 */
@Getter
@Setter
@Entity
@Table(name = "item_venta")
@Data
public class ItemVenta implements Serializable{

	/**
	 *  Identificador único
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * int cantidad de productos
	 */
	@Column
	private int cantidad;

	/**
	 * Venta a la cual se asocia este ítem de venta
	 */
	@ManyToOne
	private Venta venta;

	/**
	 * Producto al que hace referencia este ítem de venta
	 */
	@ManyToOne
	private Producto producto;

	/**
	 * Constructor vacío
	 */
	public ItemVenta(){
		super();
	}

	/**
	 * Constructor con todos sus atributos
	 * @param producto Producto adquirido
	 * @param venta Venta a la que se asocia
	 * @param cantidad de producto adquirida
	 */

	public ItemVenta(Producto producto, Venta venta,  int cantidad){
		super();
		this.venta= venta;
		this.cantidad= cantidad;
		this.producto= producto;

	}

}
