package com.despensa.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Entidad Venta
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *			Héctor Liceaga: lice2187@gmail.com
 *			Nicolás Carsaniga: nikitobombero@gmail.com
 *			Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Cliente
 * @see ItemVenta
 * @since 25/06/2022
 */

@Getter
@Setter
@Entity 
@Data
@Table(name = "venta")
public class Venta implements Serializable {

	/**
	 *  Identificador único
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * Fecha en la que se realizó la venta
	 */
	@Column
	private LocalDate fecha;

	/**
	 * Cliente al que se le asigna esta venta
	 *
	 * @see Cliente
	 */
	@ManyToOne
	Cliente cliente;

	/**
	 * Contructor vacío
	 */
	public Venta(){
		super();
	}

	/**
	 * Contructor con Cliente
	 *
	 * @param cliente al cual se le masigna esta venta
	 * @param fecha LocalDate fecha en la que se realiza una compra
	 * @see Cliente
	 */
	public Venta (Cliente cliente,LocalDate fecha){
		this.fecha = fecha;
		this.cliente = cliente;
	}

	/**
	 * Lista de items de venta.
	 *
	 * @see ItemVenta
	 */
	@OneToMany (cascade = CascadeType.REMOVE)
	private List<ItemVenta> items;

}
