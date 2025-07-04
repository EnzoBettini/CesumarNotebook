#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

typedef struct
{
    char nome[50];
    int idade;
} pessoa;

void mostrar(pessoa *pFunc)
{
    printf("Nome da pessoa: %s", pFunc->nome);
    printf("Idade da pessoa: %d", pFunc->idade);
}

int main()
{
    pessoa p, *ptr;
    ptr = &p;
    printf("Digite o nome da pessoa: \n");
    fgets(p.nome, 49, stdin);
    printf("Digite a idade da pessoa: \n");
    scanf("%d", &p.idade);

    mostrar(ptr);

    getch();
    return 0;
}