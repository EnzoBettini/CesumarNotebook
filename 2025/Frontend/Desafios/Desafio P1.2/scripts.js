let nomeProduto=document.getElementById("nomeProduto");
let valorProduto=document.getElementById("valorProduto");
let qntProduto=document.getElementById("qntProduto");
let removerProduto=document.getElementById("removerProduto");
let displayTabela=document.getElementById("displayTabela");
let botaoAdd=document.getElementById("botaoAdd");
let botaoRm=document.getElementById("botaoRm");
let displayGeral=document.getElementById("displayGeral");
let listaProdutos=[];
let idProduto=0;

bloqueioInicial();


function addTable(){
    idProduto++;
    listaProdutos.push({id: idProduto, nome: nomeProduto.value, valor: valorProduto.value, quantidade: qntProduto.value})

    let novoHtml=`
    <tr id='idproduto-${idProduto}'>
        <td>${idProduto}</td>
        <td>${nomeProduto.value}</td>
        <td>${valorProduto.value}</td>
        <td>${qntProduto.value}</td>
    </tr>
    `;

    displayTabela.querySelector("tbody").innerHTML+=novoHtml;

    nomeProduto.value="";
    valorProduto.value="";
    qntProduto.value="";
    bloqueioInicial();
}

function removeTable(){
    listaProdutos.forEach((produto, index)=>{
        if(produto.nome===removerProduto.value){
            listaProdutos.splice(index, 1);
            let removerLinha=displayTabela.querySelector(`#idproduto-${produto.id}`);
            removerLinha.remove();
            removerProduto.value="";
        }
        
    })
}

botaoAdd.addEventListener("click", (event)=>{
    event.preventDefault();
    addTable();
})

botaoRm.addEventListener("click", (event)=>{
    event.preventDefault();
    removeTable();
})

function bloqueioInicial(){
    if(listaProdutos.length===0){
        removerProduto.disabled=true;
        botaoRm.disabled=true;
        displayGeral.style.display= "none";
    }
    else{
        removerProduto.disabled=false;
        botaoRm.disabled=false;
        displayGeral.style.display= "block";
    }
}