'use strict'
let url = "http://localhost:9000/itemVenta/productoMasVendido";

let btnGet = document.getElementById("btnGet");
btnGet.addEventListener("click", mostrarTabla());

async function mostrarTabla(){

    let tabla= document.getElementById("contenido");
    try {
        let r= await fetch (url);
        let json= await r.json();
            tabla.innerHTML += `
            <tr id="fila">
                <td>${json.nombre}</td>
                <td>${json.cantidad}</td>
            </tr>`
    }
    catch(e){
        console.log(e);
    }
}