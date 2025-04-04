let pessoas = [];

function adicionarPessoa() {
    let nome = document.getElementById("nome").value;
    let idade = document.getElementById("idade").value;

    pessoas.push({ nome: nome, idade: idade });

    console.log(pessoas);

    document.getElementById("nome").value="";
    document.getElementById("idade").value="";
}



function verificarCampos() {
    let nome = document.getElementById("nome").value.trim(); // Adiciona trim() para remover espaços em branco
    let idade = document.getElementById("idade").value.trim();

    if (nome === "" || idade === "") {
        alert("Por favor, preencha todos os campos antes de continuar.");
        return; // Impede a execução da função adicionarPessoa
    }

    adicionarPessoa();
}



function listarPessoas() {
    let verificarNome = document.getElementById("nome2").value;
    let nomeEncontrado = false;

    if(pessoas.length === 0) {
        alert("não existem pessoas cadastradas");
        return;
    }

    pessoas.forEach(function(pessoa, index){ //esse function DEVE existir ou ser substítuido por => 
        if(pessoa.nome === verificarNome) {
            alert("nome ja esta na lista e seu index é: " + (index +1));
            nomeEncontrado = true;
            return;
        }
    })

    if (!nomeEncontrado) { 
        alert("nome não encontrado");
    }
}



function removerPessoa() {
    let verificarNome = document.getElementById("nome2").value;
    let nomeEncontrado = false;

    pessoas.forEach(function(pessoa, index){
        if(pessoa.nome === verificarNome) {
            pessoas.splice(index, 1);
            alert("nome removido com sucesso");
            nomeEncontrado = true;
            document.getElementById("nome2").value = ""; // Limpa o campo de entrada após a remoção
            return;
        }
    })

    if (!nomeEncontrado) { 
        alert("nome não encontrado");
    }
}



function verificarRemoção(funcao) {
    let nome = document.getElementById("nome2").value.trim(); 

    if (nome === "") {
        alert("Por favor, preencha todos os campos antes de continuar.");
        return; 
    }

    if(funcao === 0){
        listarPessoas();
    }
    
    if(funcao === 1){
        removerPessoa();
    }
}

   