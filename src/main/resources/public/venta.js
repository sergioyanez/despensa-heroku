'use strict'
let url = "http://demo-despensa.herokuapp.com/venta";

let btnGet = document.getElementById("btnGet");
btnGet.addEventListener("click", mostrarTabla());

document.querySelector("#btnAdd").addEventListener("click", async function (e) {

    let cliente = document.querySelector("#cliente").value;
    let fecha = document.querySelector("#fecha").value;
    let tabla= document.getElementById("contenido");

    let jsonV = {
        "fecha": fecha,
        "cliente": {
            "id": cliente,
        },
    };

    try{
        let respuesta = await fetch(url,{
            "method":"POST",
            "headers": {"Content-Type": "application/json"},
            "body":JSON.stringify(jsonV)
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
                <td>${data.cliente.nombre}</td>
                <td>${data.fecha}</td>
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
            let cliente = document.querySelector("#cliente").value;
            let fecha = document.querySelector("#fecha").value;
            let jsonV = {
                "fecha": fecha,
                "cliente": {
                    "id": cliente,
                },
            };
            tabla.innerHTML=" ";
            try {
                let respuesta = await fetch(url + "/" + id,{
                    "method" : "PUT",
                    "headers": {"Content-Type": "application/json"},
                    "body":JSON.stringify(jsonV)
                });
                let json = await respuesta.json();
                mostrarTabla();
            }
            catch(e){
                console.log(e);
            }
        });
    }}