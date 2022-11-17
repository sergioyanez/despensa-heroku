package com.despensa.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad Cliente
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
@Table(name = "cliente")
public class Cliente implements Serializable {

	/**
	 * Identificador único
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * String nombre del cliente
	 */
	@Column
	private String nombre;

	/**
	 * String apellido del cliente
	 */
	@Column
	private String apellido;

	/**
	 * Constructor vacío
	 */
	public Cliente(){
		super();
	}

	/**
	 * Constructor con todos los atributos
	 * @param nombre del cliete
	 * @param apellido del cliente
	 */
	public Cliente( String nombre, String apellido) {
		this.nombre=nombre;
		this.apellido=apellido;
	}
}
