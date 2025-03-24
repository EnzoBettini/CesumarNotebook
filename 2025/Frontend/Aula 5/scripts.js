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


document.getElementById("display").textContent = exemplojson.nome

exemplojson.filhos.map(function(filho){
console.log(filho.nome);
})

exemplojson.filhos.map(function(item){
    let htmlAntigo = document.getElementById("lista").innerHTML;
    novoHtml = htmlAntigo + "<li>" + item.nome + "</li>";
    document.getElementById("lista").innerHTML = novoHtml;
})