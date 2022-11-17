package com.despensa.repository;

import com.despensa.model.Producto;
import org.springframework.stereotype.Repository;

/**
 * Repositorio(bean) que maninipula a entidad Producto.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 * @see RepoBase
 * @see Producto
 */
@Repository("ProductoRepository")
public interface ProductoRepository extends RepoBase<Producto, Long> {}
