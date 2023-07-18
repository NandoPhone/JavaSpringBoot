// Call the dataTables jQuery plugin
$(document).ready(function() {

});
async function registrarUsuario() {
    let  datos={};
    datos.nombre= document.getElementById('txtNombre').value;
    datos.apellido= document.getElementById('txtApellido').value;
    datos.email= document.getElementById('txtEmail').value;
    datos.password= document.getElementById('txtPassword').value;

    let RPassword= document.getElementById('txtrepetirPassword').value;
    if (RPassword!=datos.password){
    alert('Contraseñas no Coinciden.');
    return;
    }

    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'Application/json'
        },
        body: JSON.stringify(datos)
    });
    window.location.href='login.html'

}

