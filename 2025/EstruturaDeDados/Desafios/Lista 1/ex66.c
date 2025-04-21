

// PROFESSOR ESSE CODIGO FOI GERADO PELO GPT, FIZ ASSIM PQ NÃO TINHA IDEIA DE COMO RESOLVER MAS QUERIA SABER COMO RESOLVIA
// ENTAO JOGUEI PARAR GERAR PARA VER A RESOLUÇÃO, FAVOR DESCONSIDERAR, ESTOU DEIXANDO AQUI PARA ESTUDO PESSOAL



// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <curses.h>

// typedef struct {
//     int codigo;
//     char *nome;
//     float preco;
// } Produtos;

// // variáveis globais pra contar memória
// int memoriaHeap = 0;

// void cadastro(int tam, Produtos *ptr) {
//     int i;
//     char tmp[100];

//     memoriaHeap += tam * sizeof(Produtos); // memória do vetor de structs

//     for(i = 0; i < tam; i++) {
//         printf("Digite o código do produto %d\n", i+1);
//         scanf("%d", &ptr[i].codigo);

//         printf("Digite o nome do produto:\n");
//         fflush(stdin);
//         fgets(tmp, sizeof(tmp), stdin);
//         fflush(stdin);

//         tmp[strcspn(tmp, "\n")] = '\0'; // remove o '\n' do final

//         ptr[i].nome = malloc((strlen(tmp) + 1) * sizeof(char));
//         memoriaHeap += (strlen(tmp) + 1) * sizeof(char); // conta memória do nome

//         strcpy(ptr[i].nome, tmp);

//         printf("Digite o valor do produto %d\n", i+1);
//         scanf("%f", &ptr[i].preco);
//         fflush(stdin);
//     }
// }

// void mostrar(Produtos *ptr, int tam) {
//     int i;
//     for(i = 0; i < tam; i++) {
//         printf("\n\nProduto %d\n", i+1);
//         printf("Código: %d\n", ptr[i].codigo);
//         printf("Nome: %s\n", ptr[i].nome);
//         printf("Preço: %.2f\n", ptr[i].preco);
//         free(ptr[i].nome);
//     }
// }

// int main() {
//     Produtos *produto;
//     int n;

//     // estimativa de stack (produto pointer + n + tmp[100])
//     int memoriaStack = sizeof(produto) + sizeof(n) + 100 * sizeof(char);

//     printf("Digite a quantidade de itens a serem cadastrados:\n");
//     scanf("%d", &n);

//     produto = malloc(n * sizeof(Produtos)); // já conta no cadastro()

//     cadastro(n, produto);
//     mostrar(produto, n);

//     printf("\n\nMemória consumida:\n");
//     printf("Heap: %d bytes\n", memoriaHeap);
//     printf("Stack (estimado): %d bytes\n", memoriaStack);

//     free(produto);
//     return 0;
// }
