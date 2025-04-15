let nomeProduto=document.getElementById("nomeProduto");
let valorProduto=document.getElementById("valorProduto");
let qntProduto=document.getElementById("qntProduto");
let botaoAdd=document.getElementById("botaoAdd");
let botaoRm=document.getElementById("botaoRm");
let display=document.getElementById("display");
let removerProdutoNome=document.getElementById("removerProdutoNome");
let listaProduto=[];
let idProduto=0;

function adicionarProduto(){
    listaProduto.push({id: (idProduto+1), nome: nomeProduto.value, valor: valorProduto.value, quantidade: qntProduto.value});
    let novoHtml= 
    "<tr>"+
        "<td>"+ (idProduto+1) + "</td>"+
        "<td>"+ nomeProduto.value + "</td>"+
        "<td>"+ valorProduto.value + "</td>"+
        "<td>"+ qntProduto.value + "</td>"+
    "<tr>";

    display.querySelector("tbody").innerHTML+=novoHtml;

    nomeProduto.value="";
    valorProduto.value="";
    qntProduto.value="";
    return;
}

function removerProduto(){
    listaProduto.forEach((produto, index)=>{
        if(produto.nome===removerProdutoNome.value){
            listaProduto.splice(index, 1);
            let remocao =display.querySelectorAll("tr")
            remocao[index+1].remove();
            removerProdutoNome.value=""
            return;
        }
    })
}


botaoAdd.addEventListener("click", (event)=>{
    event.preventDefault();
    adicionarProduto();
})

botaoRm.addEventListener("click", (event)=>{
    event.preventDefault();
    removerProduto();
})