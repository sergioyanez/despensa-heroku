package com.despensa.repository;

import com.despensa.dto.ProductoMasVendido;
import com.despensa.dto.ReporteClientesMonto;
import com.despensa.model.ItemVenta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio(bean) que maninipula a entidad ItemVenta.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 * @see RepoBase
 * @see ItemVenta
 */
@Repository("ItemVentaRepository")
public interface ItemVentaRepository extends RepoBase<ItemVenta, Long> {
    /**
     * Genera un reporte donde se indican los clientes y el monto total de sus compras.
     *
     * @return Una lista de reportes de clientes y sus respectivos montos
     * @see ReporteClientesMonto
     */
    @Modifying
    @Query("SELECT new ReporteClientesMonto(item.venta.cliente.nombre, SUM(item.cantidad*item.producto.precio)) "
            + "FROM ItemVenta AS item "
            + "GROUP BY item.venta.cliente.nombre")
    public List<ReporteClientesMonto> getVentaProductosDelCliente();

    /**
     * Genera un reporte con el listdao de productos más vendidos ordenados descendentemente de acuerdo a las cantidades vendidas.
     *
     * @return Listado de productos más vendidos.
     * @see ProductoMasVendido
     */
    @Modifying
    @Query("SELECT DISTINCT new ProductoMasVendido (item.producto.nombre, SUM(item.cantidad) as cantidad) "
            + "FROM ItemVenta AS item "
            + "GROUP BY item.producto.nombre "
            + "ORDER BY cantidad DESC ")
    public List<ProductoMasVendido>  getProductoMasVendido();


}

