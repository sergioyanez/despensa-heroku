package com.despensa.servicios;

import com.despensa.dto.ProductoMasVendido;
import com.despensa.dto.ReporteClientesMonto;
import com.despensa.model.ItemVenta;
import com.despensa.repository.ItemVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Clase encargada de ofrecer servicios concernientes a la entidad item de venta.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see ItemVenta
 * @since 25/06/2022
 */
@Service
public class ItemVentaService implements BaseService<ItemVenta> {
    /**
     * Variable usada para limitar regla de negocio.
     */
    private final static int MAX =  3;

    /**
     * Bean(instancia única) del repositorio de ItemVenta.
     *
     * @see ItemVentaRepository
     */
    @Autowired
    private ItemVentaRepository itemVentaRepository;

    @Override
    @Transactional
    public List findAll() throws Exception {
        try{
            return (List<ItemVenta>) itemVentaRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ItemVenta findById(Long id) throws Exception {
        try{
            Optional<ItemVenta> entityOpcional = itemVentaRepository.findById(id);
            return entityOpcional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ItemVenta save(ItemVenta entity) throws Exception {
        try{
            if(entity.getCantidad()<=MAX){
                return (ItemVenta) itemVentaRepository.save(entity);
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception("No es posible comprar más de tres unidades por producto");
        }
    }

    @Override
    public ItemVenta update(Long id, ItemVenta entity) throws Exception {
        try{
            Optional<ItemVenta> entityOpcional = itemVentaRepository.findById(id);
            ItemVenta itemVenta = entityOpcional.get();
            itemVenta = itemVentaRepository.save(entity);
            return itemVenta;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try{
            if(itemVentaRepository.existsById(id)){
                itemVentaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Servicio encargado de retornar un reporte con los clientes y sus montos totales
     *
     * @return Listado de clientes y sus respectivos montos.
     * @see ReporteClientesMonto
     * @see ItemVentaRepository#getVentaProductosDelCliente
     */
    public List<ReporteClientesMonto>reporteEjercicio3(){
        return this.itemVentaRepository.getVentaProductosDelCliente();
    }

    /**
     * Servicio encargado de retornar un reporte con el listado de productos más vendidos ordenados descendentemente.
     *
     * @return Listado de productos más vendidos.
     * @see ProductoMasVendido
     * @see ItemVentaRepository#getProductoMasVendido
     */
    public List<ProductoMasVendido>getProductoMasVendido(){
        return this.itemVentaRepository.getProductoMasVendido();
    }

}
