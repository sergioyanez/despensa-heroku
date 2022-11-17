'use strict'
let url = "http://localhost:9000/venta/ventasPorDia";

let btnGet = document.getElementById("btnGet");
btnGet.addEventListener("click", mostrarTabla());

async function mostrarTabla(){

    let tabla= document.getElementById("contenido");
    try {
        let r= await fetch (url);
        let json= await r.json();
        for (let data of json){
            tabla.innerHTML += `
            <tr id="fila">
                <td>${data.fecha}</td>
                <td>${data.nombreProducto}</td>
                <td>${data.cantidadVentas}</td>
            </tr>`
        }
    }
    catch(e){
        console.log(e);
    }
}