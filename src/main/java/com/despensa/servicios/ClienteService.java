package com.despensa.servicios;

import com.despensa.model.Cliente;
import com.despensa.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


/**
 * Clase encargada de ofrecer servicios concernientes a la entidad Cliente.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Cliente
 * @since 25/06/2022
 */
@Service
public class ClienteService implements BaseService<Cliente>{

    /**
     * Bean(instancia única) del repositorio de Cliente.
     *
     * @see ClienteRepository
     */
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    @Transactional
    public List findAll() throws Exception {
        try{
            return (List<Cliente>) clienteRepository.findAll();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente findById(Long id) throws Exception {
        try{
            Optional<Cliente> entityOpcional = clienteRepository.findById(id);
            return entityOpcional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cliente save(Cliente entity) throws Exception {
        try{
            return clienteRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cliente update(Long id, Cliente entity) throws Exception {
        try{
            Optional<Cliente> entityOpcional = clienteRepository.findById(id);
            Cliente cliente = entityOpcional.get();
            cliente = clienteRepository.save(entity);
            return cliente;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try{
            if(clienteRepository.existsById(id)){
                clienteRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
