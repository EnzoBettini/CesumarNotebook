const display = document.getElementById("display");

function mostrarElemento(input){
    display.value += input;
}

function cleardisplay(){
display.value = "";
}

function calculate(){
    display.value = eval(display.value);
}