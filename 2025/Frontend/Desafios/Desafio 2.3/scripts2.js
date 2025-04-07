let displayText = document.getElementById("displayText");

let buttons = document.querySelectorAll(".buttonsCalc");

let inputAtual="";
let culcNum=0;
let operador="=";

function calcular(num1, num2, operador){
    switch(operador){
        case '+':
            return num1+num2;
        case '-':
            return num1-num2;
        case '*':
            return num1*num2;
        case '/':
            return num1/num2;
        case '=':
            return num2;
    }
}


buttons.forEach(function(button){
    button.addEventListener("click", function(){
        const valor = button.textContent;
        
        if (valor === 'C'){
            displayText.textContent="";
            inputAtual="";
            culcNum=0;
            operador="=";
        }
        else if (valor === '='){
            if (inputAtual !==""){
                culcNum = calcular(culcNum, parseFloat(inputAtual), operador);
                displayText.textContent=culcNum;
                inputAtual="";
            }
        }
        else if (["+", "-", "*", "/"].includes(valor)){
            if(inputAtual !==""){
                culcNum =calcular(culcNum, parseFloat(inputAtual), operador);
                displayText.textContent=culcNum;
                inputAtual="";
            }
            operador=valor; 
        }
        else{
            inputAtual+=valor;
            displayText.textContent=inputAtual;
        }
    })
})