'use strict'
let url = "http://demo-despensa.herokuapp.com/itemVenta/reporteMontoClientes";

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
                <td>${data.nombre}</td>
                <td>${data.monto}</td>
            </tr>`
        }
    }
    catch(e){
        console.log(e);
    }
}