package com.despensa.servicios;

import com.despensa.model.Producto;
import com.despensa.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Clase encargada de ofrecer servicios concernientes a la entidad producto.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Producto
 * @since 25/06/2022
 */
@Service
public class ProductoService implements BaseService<Producto>{

    /**
     * Bean(instancia única) del repositorio de Producto.
     *
     * @see ProductoRepository
     */
    @Autowired
    private ProductoRepository productoRepository;
    @Override
    @Transactional
    public List<Producto> findAll() throws Exception {
        try{
            return (List<Producto>) productoRepository.findAll();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto findById(Long id) throws Exception {
        try{
            Optional<Producto> entityOpcional = productoRepository.findById(id);
            return entityOpcional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto save(Producto entity) throws Exception {
        try{
            return productoRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto entity) throws Exception {
        try{
            Optional<Producto> entityOpcional = productoRepository.findById(id);
            Producto producto = entityOpcional.get();
            producto = productoRepository.save(entity);
            return producto;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(productoRepository.existsById(id)){
                productoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
