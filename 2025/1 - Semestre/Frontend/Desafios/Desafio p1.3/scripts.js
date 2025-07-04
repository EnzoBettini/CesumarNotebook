let nomeProduto=document.getElementById("nomeProduto");
let valorProduto=document.getElementById("valorProduto");
let nomeProduto1=document.getElementById("nomeProduto1");
let valorProduto1=document.getElementById("valorProduto1");
let botaoAdd=document.getElementById("botaoAdd");
let botaoAdd2=document.getElementById("botaoAdd2");
let display=document.getElementById("display");
let listaProdutos=[
    { id: 1, nome: "Camiseta", valor: 49.90 },
    { id: 2, nome: "Calça Jeans", valor: 119.90 },
    { id: 3, nome: "Tênis", valor: 199.90 }
  ];
let idSoma=3;
let disabVar=0;

desabilitar();

adicionarInicio();

  function adicionarInicio(){
    listaProdutos.forEach((produto)=>{
        let htmlNovo=`
        <tr id='Idproduto-${produto.id}'>
            <td>${produto.id}</td>
            <td>${produto.nome}</td>
            <td>${produto.valor}</td>
            <td><button class='btn btn-danger' id='botaoRm-${produto.id}' onclick='excluir(${produto.id})'>Excluir</button></td>
            <td><button class='btn btn-warning' id='botaoEdit-${produto.id}' onclick='editar(${produto.id})'>Editar</button></td>
        `;
        display.querySelector("tbody").innerHTML+=htmlNovo;
    })
  }

  function adicionarProduto(){
    idSoma++;
    listaProdutos.push({id: idSoma, nome: nomeProduto.value, valor: valorProduto.value});

    let htmlNovo=`
    <tr id='Idproduto-${idSoma}'>
        <td>${idSoma}</td>
        <td>${nomeProduto.value}</td>
        <td>${valorProduto.value}</td>
        <td><button class='btn btn-danger' id='botaoRm-${idSoma}' onclick='excluir(${idSoma})'>Excluir</button></td>
        <td><button class='btn btn-warning' id='botaoEdit-${idSoma}' onclick='editar(${idSoma})'>Editar</button></td>
    </tr>
        `;
        display.querySelector("tbody").innerHTML+=htmlNovo;
    nomeProduto.value="";
    valorProduto.value="";
  }

  botaoAdd.addEventListener("click", (event)=>{
    event.preventDefault();
    adicionarProduto();
  })

  function excluir(idExcluir){
    listaProdutos.forEach((produto, index)=>{
        if(produto.id===idExcluir){
            listaProdutos.splice(index, 1);
            let remocao=display.querySelector(`#Idproduto-${produto.id}`)
            remocao.remove();
        }
    })
  }

  function editar(idEditar){
    disabVar=1;
    desabilitar();
    botaoAdd2.addEventListener("click", (event)=>{
        event.preventDefault();
        excluir(idEditar);
        listaProdutos.push({id: idEditar, nome: nomeProduto.value, valor: valorProduto.value});

        let htmlNovo=`
        <tr id='Idproduto-${idEditar}'>
            <td>${idEditar}</td>
            <td>${nomeProduto1.value}</td>
            <td>${valorProduto1.value}</td>
            <td><button class='btn btn-danger' id='botaoRm-${idEditar}' onclick='excluir(${idEditar})'>Excluir</button></td>
            <td><button class='btn btn-warning' id='botaoEdit-${idEditar}' onclick='editar(${idEditar})'>Editar</button></td>
        </tr>
            `;
            display.querySelector("tbody").innerHTML+=htmlNovo;
        nomeProduto1.value="";
        valorProduto1.value="";
    })
  }

  function desabilitar(){
    if(disabVar===0){
        nomeProduto1.disabled=true;
        valorProduto1.disabled=true;
    }else{
        nomeProduto1.disabled=false;
        valorProduto1.disabled=false;
    }
  }