
# lista
lista_nomes = ["lira", "jorge", "gi", "renan"]
lista_nomes.append("julia") # adiciona informação em uma lista
print(lista_nomes)

primeiro_item = lista_nomes[0]
print(primeiro_item)


# dicionario python
# role = quem enviou a mensagem = "função"
# content = texto da mensagem = "conteudo"
mensagem = {"role": "user", "content": "Coe galera"}
# dicionario = {chave: valor, chave: valor}
# 1 elemento -> dicionario[chave] -> valor

texto_mensagem = mensagem["role"]
print(texto_mensagem)

# lista + dicionario
lista_mensagens = [
    {"role": "user", "content": "Coe galera"}, 
    {"role": "assistant", "content": "Resposta da IA"}, 
    {"role": "user", "content": "Tamo junto"}
    ]

lista_mensagens.append(
    {"role": "assistant", "content": "Eu desisto de você"}
)

print(lista_mensagens)

# exibir todos os itens de uma lista
for nome in lista_nomes:
    print(nome)

for mensagem in lista_mensagens:
    print(mensagem)