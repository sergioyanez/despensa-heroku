package com.despensa.utils;

import com.despensa.model.Cliente;
import com.despensa.model.ItemVenta;
import com.despensa.model.Producto;
import com.despensa.model.Venta;
import com.despensa.servicios.ClienteService;
import com.despensa.servicios.ItemVentaService;
import com.despensa.servicios.ProductoService;
import com.despensa.servicios.VentaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.stream.IntStream;

/**
 * Clase encargada de la generación de datos para el llenado de la base de datos con datos de muestra.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail,.com
 * @version 1.0
 * @since 25/06/2022
 */
@Configuration
public class CargaDeDatos {
    /**
     * Variable auxiliar
     */
    long ID =1;

    /**
     * Bean con la lógica de la inserción de datos generados(mock) pra el llenado de la base de datos.
     *
     * @param clientes Servicio clientes
     * @param productos Servicio producto
     * @param ventas Servicio venta
     * @param itemsVenta Servicio itemVenta
     * @return Línea de comando a ejecutar por Spring
     */
    @Bean
    public CommandLineRunner cargaDB(ClienteService clientes, ProductoService productos, VentaService ventas, ItemVentaService itemsVenta){
        return args-> {
            //Se insertan 10 productos
            IntStream.range(0, 10).forEach(i -> {
                Producto p = new Producto("Producto " + i, 10 + i * 2, 100 + i * 5);
                try {
                    productos.save(p);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            //Se insertan 10 clientes
            IntStream.range(0, 10).forEach(i -> {
                Cliente c = new Cliente("Cliente " + i, "Apellido " + i);
                try {
                    clientes.save(c);
                    ID ++;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            ID = 11;
            //Se insertan 10 ventas
            IntStream.range(0, 10).forEach(i -> {
                LocalDate     f1= LocalDate.of(2022,8,10);
                LocalDate     f2 = LocalDate.of(2022,7,23);
                LocalDate     f3 = LocalDate.of(2022,9,9);
                try {
                    Venta v = new Venta (clientes.findById(ID),f1);
                    ventas.save(v);
                    if((ID+2)<20){
                        v = new Venta (clientes.findById(ID+1),f2);
                        ventas.save(v);
                        v = new Venta (clientes.findById(ID+2),f3);
                        ventas.save(v);
                    }
                    ID++;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            ID = 21;
            //Se insertan 10 itemsVenta
            IntStream.range(0, 10).forEach(i -> {
                long id = i + 1;
                LocalDate date = LocalDate.of(2020, 1, 8);
                ItemVenta item = null;
                try {
                    item = new ItemVenta(productos.findById(ID-20), ventas.findById(ID),  1);
                    itemsVenta.save(item);
                    if((ID-18)<10){
                        item = new ItemVenta(productos.findById(ID-19), ventas.findById(ID),  2);
                        itemsVenta.save(item);
                        item = new ItemVenta(productos.findById(ID-18), ventas.findById(ID),  3);
                        itemsVenta.save(item);
                    }
                    ID++;

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        };
    }
}
