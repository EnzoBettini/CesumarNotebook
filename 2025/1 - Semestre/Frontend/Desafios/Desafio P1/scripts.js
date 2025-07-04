let inputNome = document.getElementById("nomeProduto");
let inputNomeRemover = document.getElementById("nomeProdutoRemover");
let idNomeRemover = document.getElementById("idProdutoRemover");
let inputPreco = document.getElementById("precoProduto");
let inputQuant = document.getElementById("quantProduto");
let botaoEnviar = document.getElementById("botaoEnviar");
let botaoRemover = document.getElementById("botaoRemover");
let display = document.getElementById("display");
let listaProdutos = [];
let idLista;
let controlarRemocao;


function adicionarProduto() {
    idLista++;
    listaProdutos.push({id: idLista, nome: inputNome.value.trim(), preco: inputPreco.value.trim(), quantidade: inputQuant.value.trim() });

    let novaLinha = 
        "<tr>" +
            "<th>" + idLista + "</th>" +
            "<td>" + inputNome.value + "</td>" +
            "<td>" + inputPreco.value + "</td>" +
            "<td>" + inputQuant.value + "</td>" +
        "</tr>";

    display.querySelector("tbody").innerHTML += novaLinha;

    inputNome.value = "";
    inputPreco.value = "";
    inputQuant.value = "";
    idLista+=1;
}

function removerProduto() {
    if (controlarRemocao === 0) {
        // Remover por nome
        listaProdutos.forEach((produto, index) => {
            if (produto.nome === inputNomeRemover.value) {
                listaProdutos.splice(index, 1);
                inputNomeRemover.value = "";
                let remocao = display.querySelectorAll("tr");
                // Atualizando o índice no DOM para remover a linha correta
                remocao[index + 1].remove(); // +1 para ignorar o cabeçalho
                return;
            }
        });
    } else if (controlarRemocao === 1) {
        // Remover por ID
        listaProdutos.forEach((produto, index) => {
            if (produto.id === parseInt(idNomeRemover.value)) { // Garantir que o ID seja um número
                listaProdutos.splice(index, 1);
                let remocao = display.querySelectorAll("tr");
                // Atualizando o índice no DOM para remover a linha correta
                remocao[index + 1].remove(); // +1 para ignorar o cabeçalho
                inputNomeRemover.value = "";
                return;
            }
        });
    }
}

botaoEnviar.addEventListener("click", (event) => {
    event.preventDefault();
    adicionarProduto();
});

botaoRemover.addEventListener("click", (event) => {
    event.preventDefault();
    removerProduto();
})

let radioId = document.getElementById("tipoRemocaoId");
let radioNome = document.getElementById("tipoRemocaoNome");
let inputIdRemover = document.getElementById("idProdutoRemover");

function bloquearCampos() {
    if (radioId.checked) {
        inputNomeRemover.disabled = true;  
        inputIdRemover.disabled = false;
        controlarRemocao=1;
    } else if (radioNome.checked) {
        inputNomeRemover.disabled = false;  
        inputIdRemover.disabled = true;
        controlarRemocao=0;    
    }
}

radioId.addEventListener("change", bloquearCampos);
radioNome.addEventListener("change", bloquearCampos);

bloquearCampos();

