// Captura o display onde os resultados serão mostrados
let displayText = document.getElementById("displayText");

// Captura todos os botões da calculadora
let buttons = document.querySelectorAll(".buttonsCalc");

let currentInput = "";  // O número que o usuário está digitando
let numCalc = 0;        // O valor atual para o cálculo
let operator = "=";     // O operador atual

// Função para calcular
function calculate(num1, num2, operator) {
    switch (operator) {
        case '+': return num1 + num2;
        case '-': return num1 - num2;
        case '*': return num1 * num2;
        case '/': return num1 / num2;
        case '=': return num2;  // Retorna o segundo número se o operador for igual
        default: return num1;
    }
}

// Adiciona o evento de clique para os botões
buttons.forEach(function(button) {
    button.addEventListener("click", function() {
        const value = button.textContent;

        if (value === 'C') {
            // Limpa tudo
            displayText.textContent = "";
            currentInput = "";
            numCalc = 0;
            operator = "=";  
        } else if (value === '=') {
            // Realiza o cálculo e exibe o resultado
            if (currentInput !== "") {
                numCalc = calculate(numCalc, parseFloat(currentInput), operator);
                displayText.textContent = numCalc;
                currentInput = "";  
            }
        } else if (["+", "-", "*", "/"].includes(value)) {
            // Armazena o operador e o número atual
            if (currentInput !== "") {
                numCalc = calculate(numCalc, parseFloat(currentInput), operator);
                displayText.textContent = numCalc;
                currentInput = "";  
            }
            operator = value;  // Atualiza o operador
        } else {
            // Adiciona o número ao display
            currentInput += value;
            displayText.textContent = currentInput;
        }
    });
});
