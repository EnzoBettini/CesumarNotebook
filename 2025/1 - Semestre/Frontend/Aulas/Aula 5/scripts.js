let exemplojson ={
    "nome": "Hugo",
    "idade": 30,
    "filhos": [
        {"nome": "pedro"},
        {"nome": "bianca"},
    ]
}

console.log(exemplojson.nome);
console.log(exemplojson.idade);
console.log(exemplojson.filhos[1].nome);
console.log(exemplojson.filhos[0].nome);


document.getElementById("display").textContent = exemplojson.nome //textcontent usamos para mostrar o conteudo de um elemento html, o innerhtml mostra o conteudo e o html que esta dentro dele.

exemplojson.filhos.map(function(filho){
console.log(filho.nome);
})

exemplojson.filhos.map((filho) => {
    console.log(filho.nome);
});


exemplojson.filhos.map(function(item){
    let htmlAntigo = document.getElementById("lista").innerHTML;
    novoHtml = htmlAntigo + "<li>" + item.nome + "</li>";
    document.getElementById("lista").innerHTML = novoHtml;
})




let exemplojson2 = [
    {
        "nome": "Hugo",
        "idade": 30,
        "filhos": [
            {"nome": "Pedro"},
            {"nome": "Bianca"}
        ]
    },
    {
        "nome": "Ana",
        "idade": 25,
        "filhos": [
            {"nome": "Lucas"},
            {"nome": "Sophia"}
        ]
    }
];

function criarTable() {
    let tabela = document.getElementById("tabela");
    let novoHtml = "<thead><tr><th>Nome</th><th>Filhos</th></tr></thead><tbody>";

    exemplojson2.forEach(function(item) {
        
        let filhos = item.filhos.map(function(filho) {
            return filho.nome; //tem que ter o return pois map não altera o array original, ele cria um novo array com os valores retornados
        }).join(", ");  
        
        novoHtml += `<tr><td>${item.nome}</td><td>${filhos}</td></tr>`;
    });

    novoHtml += "</tbody>";
    tabela.innerHTML = novoHtml;
}

criarTable();


exemplojson2.forEach(function(pessoa) {
    pessoa.filhos.forEach(function(filho) {
        console.log(filho.nome);
    });
});

console.log(exemplojson2[1].filhos[0].nome); // Isso mostraria "Lucas"