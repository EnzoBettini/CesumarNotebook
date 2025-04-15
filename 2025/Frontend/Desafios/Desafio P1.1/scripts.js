let nomeProduto=document.getElementById("nomeProduto");
let valorProduto=document.getElementById("valorProduto");
let qntProduto=document.getElementById("qntProduto");
let botaoAdd=document.getElementById("botaoAdd");
let botaoRm=document.getElementById("botaoRm");
let display=document.getElementById("display");
let removerProdutoNome=document.getElementById("removerProdutoNome");
let listaProduto=[];
let idProduto=0;

 atualizarEstadoBotaoRemover()

function adicionarProduto(){
   
    idProduto++;

    listaProduto.push({id: idProduto, nome: nomeProduto.value, valor: valorProduto.value, quantidade: qntProduto.value});
    
    let novoHtml = 
    "<tr id='produto-" + idProduto + "'>" +  
        "<td>" + idProduto + "</td>" +
        "<td>" + nomeProduto.value + "</td>" +
        "<td>" + valorProduto.value + "</td>" +
        "<td>" + qntProduto.value + "</td>" +
    "</tr>";

 /*
 let novoHtml = `
    <tr id='produto-${idProduto}'>
        <td>${idProduto}</td>
        <td>${nomeProduto.value}</td>
        <td>${valorProduto.value}</td>
        <td>${qntProduto.value}</td>
    </tr>
`;
*/

    display.querySelector("tbody").innerHTML += novoHtml;

   
    nomeProduto.value = "";
    valorProduto.value = "";
    qntProduto.value = "";
}

function removerProduto() {
    listaProduto.forEach((produto, index) => {
        if(produto.nome === removerProdutoNome.value){
            listaProduto.splice(index, 1);
            let linha = display.querySelector(`#produto-${produto.id}`);
            if (linha) linha.remove(); 
            removerProdutoNome.value = "";
            return;
        }
    });
}

function atualizarEstadoBotaoRemover() {
    if (listaProduto.length === 0) {
        removerProdutoNome.disabled = true;
        botaoRm.disabled = true;
    } else {
        removerProdutoNome.disabled = false;
        botaoRm.disabled = false;
    }
}


botaoAdd.addEventListener("click", (event)=>{
    event.preventDefault();
    adicionarProduto();
})

botaoRm.addEventListener("click", (event)=>{
    event.preventDefault();
    removerProduto();
})
