function validarCampos() {
    var elemento = document.getElementById("q");
    
    if (elemento == null) {
        alert("O elemento de busca não existe");
        return false;
    } 
    if (elemento.value == null || elemento.value.length == 0) {
        alert("Preencha o elemento de busca");
        return false;
    }
        return true;
   }