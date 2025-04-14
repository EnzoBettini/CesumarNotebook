let pessoas = [];

let nomes = document.getElementById("nome");
let idades = document.getElementById("idade");
let verificar = document.getElementById("nome2");
let botaoEnvio = document.getElementById("envio");
let botaoChecar = document.getElementById("checar");
let botaoRemover = document.getElementById("remover");
let lista = document.getElementById("lista");

function adicionarDados() {
    pessoas.push({ nome: nomes.value, idade: idades.value });
    let htmlAntigo = lista.innerHTML;
    let novoHtml = `${htmlAntigo}<li><b>${nomes.value}</b><ul>idade: ${idades.value}</ul></li>`;
    lista.innerHTML = novoHtml;
    nomes.value = "";
    idades.value = "";
}

botaoEnvio.addEventListener("click", () => {
    adicionarDados();
});


botaoChecar.addEventListener("click", () => {
    pessoas.forEach((pessoa, index) =>{
        if(pessoa.nome === verificar.value){
            alert(`O nome ${verificar.value} já está na lista e seu índice é: ${index + 1}`);
            verificar.value = "";
            return;
        }
    })
});

botaoRemover.addEventListener("click", () => {
    pessoas.forEach((pessoa, index) =>{
        if(pessoa.nome === verificar.value){
            alert(`O nome ${verificar.value} foi removido com sucesso!`);
            pessoas.splice(index, 1);
            let items = lista.querySelectorAll("li"); 
            items[index].remove(); 
            verificar.value = "";
            return;
        }
    })
});