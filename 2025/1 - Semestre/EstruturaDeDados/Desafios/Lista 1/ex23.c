#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

void mostra(int k[], int tam)
{
    int i;
    for (i = 0; i < tam; i++)
    {
        printf("%d\n", k[i]);
    }
}

void altera(int *vetor, int tamanho)
{
    int i;
    for (i = 0; i < tamanho; i++)
    {
        vetor[i] *= 2;
    }
}

int main()
{
    int vet[] = {12, 15, 14, 45};
    int tam = sizeof(vet) / sizeof(int);
    mostra(vet, tam);
    altera(vet, tam);
    mostra(vet, tam);

    getch();
    return 0;
}