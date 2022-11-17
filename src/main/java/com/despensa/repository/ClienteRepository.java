package com.despensa.repository;

import com.despensa.model.Cliente;
import org.springframework.stereotype.Repository;

/**
 * Repositorio(bean) que maninipula a entidad Cliente.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 * @see RepoBase
 * @see Cliente
 */
@Repository("ClienteRepository")
public interface ClienteRepository extends RepoBase<Cliente, Long> {
}

