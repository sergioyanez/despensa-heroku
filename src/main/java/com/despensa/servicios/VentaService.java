package com.despensa.servicios;

import com.despensa.dto.ReporteVentasPorDia;
import com.despensa.model.Venta;
import com.despensa.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Clase encargada de ofrecer servicios concernientes a la entidad venta.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Venta
 * @since 25/06/2022
 */
@Service
public class VentaService implements BaseService<Venta>{

    /**
     * Bean(instancia única) del repositorio de Venta.
     *
     * @see VentaRepository
     */
    @Autowired
    private VentaRepository ventaRepository;
    @Override
    @Transactional
    public List findAll() throws Exception {
        try{
            return (List<Venta>) ventaRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Venta findById(Long id) throws Exception {
        try{
            Optional<Venta> entityOpcional = ventaRepository.findById(id);
            return entityOpcional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Venta save(Venta entity) throws Exception {
        try{
            return ventaRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Venta update(Long id, Venta entity) throws Exception {
        try{
            Optional<Venta> entityOpcional = ventaRepository.findById(id);
            Venta venta = entityOpcional.get();
            venta = ventaRepository.save(entity);
            return venta;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try{
            if(ventaRepository.existsById(id)){
                ventaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Servicio encargado de generar un reporte con las ventas por día.
     *
     * @return Reporte con las ventas por día.
     * @see ReporteVentasPorDia
     * @see VentaRepository#getVentasPorDia
     */
    public List<ReporteVentasPorDia>reporteEjercicio4(){
        return this.ventaRepository.getVentasPorDia();
    }

}
