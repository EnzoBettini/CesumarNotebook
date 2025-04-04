let pessoas = [];

function adicionarPessoa() {
    let nome = document.getElementById("nome").value;
    let idade = document.getElementById("idade").value;

    pessoas.push({ nome: nome, idade: idade });

    console.log(pessoas);
    document.getElementById("nome").value="";
    document.getElementById("idade").value="";
}

function listarPessoas() {
    let verificarNome = document.getElementById("nome2").value;
    pessoas.forEach(function(pessoa, index){
        if(pessoa.nome === verificarNome) {
            alert("nome ja esta na lista e seu index é: " + (index +1));
            return;
        }
        alert("nome não encontrado");
    })
}

function removerPessoa() {
    let verificarNome = document.getElementById("nome2").value;
    pessoas.forEach(function(pessoa, index){
        if(pessoa.nome === verificarNome) {
            pessoas.splice(index, 1);
            alert("nome removido com sucesso");
        }
    })
}


   