#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>
#include <time.h>

void atribuir(int *ptr, int tamanho){
    int i;
    for(i=0; i<tamanho; i++){
        ptr[i]=(rand() % 31)+20;
    } 
}

void mostrar(int *ptr, int tamanho){
    int i;
    for(i=0; i<tamanho; i++){
        printf("\nO elemento %d do vetor é: %d\n", i+1, *(ptr+i));
    } 
}

int main()
{
    int *vet, tam;
    srand(time(NULL));

    tam=10;

    vet=malloc(tam*sizeof(int));
    if(vet==NULL){
        printf("Erro na alocação");
        return 1;
    }

    atribuir(vet, tam);
    mostrar(vet, tam);

    tam=15;

    vet=realloc(vet, tam*sizeof(int));

    atribuir(vet, tam);
    mostrar(vet, tam);

    free (vet);


    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
