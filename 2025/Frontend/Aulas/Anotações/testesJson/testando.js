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

exemplojson2.map(function(item) {
    let oldHtml = document.getElementById("display").innerHTML;
    let newHtml = oldHtml + "<h1>" + item.nome + " " + item.idade + "</h1>";
    document.getElementById("display").innerHTML = newHtml;

    let ulHtml = "<ul>";
    item.filhos.map(function(filho) {
        ulHtml += "<li>" + filho.nome + "</li>"; 
    });
    ulHtml += "</ul>";

    document.getElementById("display").innerHTML = document.getElementById("display").innerHTML + ulHtml;
});