#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>

typedef struct{
    int codigo;
    char *nome;
    float preco;
}Produtos;

void cadastro(int tam, Produtos *ptr){
    int i;
    char tmp[100];

    for(i=0; i<tam; i++){
        printf("Digite o código do produto %d\n", i+1);
        scanf("%d", &ptr[i].codigo);

        printf("Digite o nome do produto: \n");
        fflush(stdin);
        fgets(tmp, sizeof(tmp), stdin);
        fflush(stdin);

        ptr[i].nome = malloc((strlen(tmp) + 1) * sizeof(char));
        strcpy(ptr[i].nome, tmp);

        printf("Digite o valor do produto %d\n", i+1);
        scanf("%f", &ptr[i].preco);
        fflush(stdin);
    }
}

void mostrar(Produtos *ptr, int tam){
    int i;

    for(i=0; i<tam; i++){
    printf("\n\n\nProduto %d\n", i+1);
    printf("Codigo: %d", ptr[i].codigo);
    printf("Codigo: %s", ptr[i].nome);
    printf("Codigo: %.2f", ptr[i].preco);
    free(ptr[i].nome);
    }
}

int main()
{
    Produtos *produto;
    int n;
    printf("Digite a quantidade de itens a serem cadastrados: \n");
    scanf("%d", &n);

    produto=malloc(n*sizeof(Produtos));

    cadastro(n, produto);
    mostrar(produto, n);

    free(produto);

    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
