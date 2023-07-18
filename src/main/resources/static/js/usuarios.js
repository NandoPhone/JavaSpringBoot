// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});
async function cargarUsuarios() {
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'Application/json'
    }
  });
  const usuarios = await request.json();

  let listadoHtml='';


  for (let usuario of usuarios){

    let btnEliminar= '<a href="#" onclick="eliminarusuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let telefono=usuario.telefono==null ?'':usuario.telefono;
    let usuarioHtml= '<tr><td>'+usuario.id+'</td><td> '+usuario.nombre+' '+usuario.apellido+'</td><td>'+usuario.email
        +'</td><td>'+telefono
        +'</td><td>'+btnEliminar+'</td></tr>';
    listadoHtml += usuarioHtml;
  }
  console.log(usuarios);

  document.querySelector('#usuarios tbody').outerHTML=listadoHtml;

}

async function eliminarusuario(id){
  if (!confirm("¿Esta Seguro de Eliminar Usuario?")){
    return;
  }
  const request = await fetch('api/usuarios/'+id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'Application/json'
    }
  });

  location.reload();
}
