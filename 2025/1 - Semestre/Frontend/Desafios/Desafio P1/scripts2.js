let display2 = document.getElementById("display2");
let nomeTabela=document.getElementById("nomeTabela");
let botao=document.getElementById("botao");

let listaProdutos2 = [
    {id: 1, nome: "Produto A", preco: "10.00", quantidade: "5"},
    {id: 2, nome: "Produto B", preco: "15.50", quantidade: "3"},
    {id: 3, nome: "Produto C", preco: "7.99", quantidade: "10"},
    {id: 4, nome: "Produto D", preco: "25.00", quantidade: "2"}
];

function tabelarPagina2(){
    listaProdutos2.forEach((produto)=>{
        let htmlNovo = "<tr>" +
        "<td>" + produto.id + "</td>" +
        "<td>" + produto.nome + "</td>" +
        "<td>" + produto.preco + "</td>" +
        "<td>" + produto.quantidade + "</td>" +
        "</tr>";
        display2.querySelector("tbody").innerHTML += htmlNovo;
    })
}

tabelarPagina2();

function removerProduto2(){
    listaProdutos2.forEach((produto,index)=>{
        if(produto.nome===nomeTabela.value){
            listaProdutos2.splice(index,1);
            let remocao = display2.querySelectorAll("tr");
            remocao[index+1].remove();
        }
    })
}

botao.addEventListener("click", ()=>{
    removerProduto2();
})

