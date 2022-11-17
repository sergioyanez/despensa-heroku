'use strict'
let url = "http://demo-despensa.herokuapp.com/itemVenta";

let btnGet = document.getElementById("btnGet");
btnGet.addEventListener("click", mostrarTabla());

document.querySelector("#btnAdd").addEventListener("click", async function (e) {

    let cantidad = document.querySelector("#cantidad").value;
    let venta = document.querySelector("#venta").value;
    let producto = document.querySelector("#producto").value;
    let tabla= document.getElementById("contenido");

    let jsonIT = {
        "cantidad": cantidad,
        "venta": {
            "id": venta,
        },
        "producto": {
            "id": producto,
        },
    }

    try{
        let respuesta = await fetch(url,{
            "method":"POST",
            "headers": {"Content-Type": "application/json"},
            "body":JSON.stringify(jsonIT)
        });
        let json = await respuesta.json();
        tabla.innerHTML=" ";
        mostrarTabla();
    }
    catch(e){
        console.log(e);
    }
});

async function mostrarTabla(){

    let tabla= document.getElementById("contenido");
    try {
        let r= await fetch (url);
        let json= await r.json();
        for (let data of json){
            tabla.innerHTML += `
            <tr id="fila">
                <td>${data.cantidad}</td>
                <td>${data.venta.id}</td>
                <td>${data.producto.nombre}</td>
                <td><button class="btn btn-warning" data="${data.id}" id="editar">Editar</button></td>
                <td><button class="btn btn-danger" data="${data.id}" id="eliminar" >Eliminar</button}</td>
            </tr>`
        }
        eliminar()
        editar()
    }
    catch(e){
        console.log(e);
    }
}

function eliminar(){

    let btnsDelete = document.querySelectorAll("#eliminar");
    let tabla = document.querySelector("#contenido");
    for (let i=0; i<btnsDelete.length;i++){
        let btnEliminar = btnsDelete[i];
        let id = btnEliminar.getAttribute("data");
        btnEliminar.addEventListener("click", function(){
            fetch(url + "/" + id,{
                "method" : "DELETE"
            })
            tabla.innerHTML=" ";
            mostrarTabla();
        })
    }
}

async function editar(){
    let btnsEdit = document.querySelectorAll("#editar");
    let tabla = document.querySelector("#contenido");
    for (let i=0; i<btnsEdit.length;i++){
        let btnEditar = btnsEdit[i];
        let id = btnEditar.getAttribute("data");
        btnEditar.addEventListener("click", async function(respuesta){
            let tabla = document.querySelector("#contenido");
            let cantidad = document.querySelector("#cantidad").value;
            let venta = document.querySelector("#venta").value;
            let producto = document.querySelector("#producto").value;
            let jsonIT = {
                "cantidad": cantidad,
                "venta": {
                    "id":venta,
                },
                "producto": {
                    "id": producto,
                },
            }
            tabla.innerHTML=" ";
            try {
                let respuesta = await fetch(url + "/" + id,{
                    "method" : "PUT",
                    "headers": {"Content-Type": "application/json"},
                    "body":JSON.stringify(jsonIT)
                });
                let json = await respuesta.json();
                mostrarTabla();
            }
            catch(e){
                console.log(e);
            }
        });
    }}