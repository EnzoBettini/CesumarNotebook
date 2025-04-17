#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

void mostrar(int *vet)
{
    int i;
    for (i = 0; i < 5; i++)
    {
        printf("numero %d: %d\n", i + 1, *(vet + i));
    }
}

int main()
{
    int numeros[5];

    for (int i = 0; i < 5; i++)
    {
        printf("digite o numero %d: \n", i + 1);
        scanf("%d", &numeros[i]);
    }

    mostrar(numeros);

    getch();
    return 0;
}