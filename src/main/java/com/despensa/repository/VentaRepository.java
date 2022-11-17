package com.despensa.repository;

import com.despensa.dto.ReporteVentasPorDia;
import com.despensa.model.Venta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Repositorio(bean) que maninipula a entidad Venta.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see RepoBase
 * @see Venta
 * @since 25/06/2022
 */
@Repository("VentaRepository")
public interface VentaRepository extends RepoBase<Venta, Long> {

    /**
     * Genera un reporte de las ventas por día.
     *
     * @return Una lista de reportes de ventas por día.
     * @see ReporteVentasPorDia
     */
    @Modifying
    @Query("SELECT new ReporteVentasPorDia ( item.venta.fecha, "
            + "item.producto.nombre, "
            + "COUNT (item.venta.id) ) "
            + "FROM ItemVenta AS item "
            + "GROUP BY item.venta.fecha,item.producto.nombre "
            + "ORDER BY item.venta.fecha DESC ")
    public List<ReporteVentasPorDia> getVentasPorDia();

}
