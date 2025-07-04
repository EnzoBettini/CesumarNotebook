#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>

void inverter(char *str, int tamanho){
    char tmp;
    int i, fim;
    fim=tamanho-1;
    for(i=0; i<tamanho/2; i++){
        tmp=str[i];
        str[i]=str[fim];
        str[fim]=tmp;
        fim--;
    }
};

int main()
{

    char nome[50];
    int tam;
    printf("Digite seu nome: ");
    fgets(nome, 49, stdin);
    tam=strlen(nome);

    inverter(nome, tam);

    printf("Nome invertido: %s\n", nome);

    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
