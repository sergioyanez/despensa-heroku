'use strict'
let url = "http://localhost:9000/cliente";

let btnGet = document.getElementById("btnGet");
btnGet.addEventListener("click", mostrarTabla());

document.querySelector("#btnAdd").addEventListener("click", async function (e) {

    let nombre = document.querySelector("#nombre").value;
    let apellido = document.querySelector("#apellido").value;
    let tabla= document.getElementById("contenido");

    let jsonC =  {
            "nombre": nombre,
            "apellido": apellido,
        };

    try{
        let respuesta = await fetch(url,{
            "method":"POST",
            "headers": {"Content-Type": "application/json"},
            "body":JSON.stringify(jsonC)
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
                <td>${data.nombre}</td>
                <td>${data.apellido}</td>
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
            let nombre = document.querySelector("#nombre").value;
            let apellido = document.querySelector("#apellido").value;
            let jsonC = {
                    "id": id,
                    "nombre": nombre,
                    "apellido": apellido,
                }
                tabla.innerHTML=" ";
                try {
                    let respuesta = await fetch(url + "/" + id,{
                        "method" : "PUT",
                        "headers": {"Content-Type": "application/json"},
                        "body":JSON.stringify(jsonC)
                    });
                    let json = await respuesta.json();
                    mostrarTabla();
                }
                catch(e){
                    console.log(e);
                }
        });
    }}