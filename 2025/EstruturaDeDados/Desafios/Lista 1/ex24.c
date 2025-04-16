#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

int main()
{
    char palavras[4][10];

    for (int i = 0; i < 4; i++)
    {
        printf("digite a palavra %d\n", i + 1);
        fgets(palavras[i], sizeof(palavras[i]), stdin); // caso queira o tamanho da palavra sem o caracter nulo seria strlen(palavras[i])
    }
    printf("\n%d\n", sizeof(palavras));
    for (int i = 0; i < 4; i++)
    {
        printf("\n%d\n", sizeof(palavras[i]));
    }
    printf("\n%p\n", &palavras);
    for (int i = 0; i < 4; i++)
    {
        printf("\n%p\n", &palavras[i]);
    }

    getch();
    return 0;
}