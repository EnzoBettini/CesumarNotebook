#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>

void copiar(char *vet1, char *vet2){
    int i;
    for(i=0; i<sizeof(vet1); i++){
        vet2[i]=vet1[i];
    }
};

int main()
{
    char nome[50], copia[50];
    printf("Digite o nome: \n");
    fgets(nome, sizeof(nome), stdin);

    copiar(nome, copia);

    printf("String original: %s\n", nome);
    printf("String copia: %s\n", copia);

    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
