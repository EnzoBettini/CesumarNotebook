#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>
#include <time.h>

void atribuir(int *ptr, int tamanho){
    int i;
    for(i=0; i<tamanho; i++){
        ptr[i]=(rand() % 21)+10;
    } 
}

void mostrar(int *ptr, int tamanho){
    int i;
    for(i=0; i<tamanho; i++){
        printf("\nO elemento %d do vetor é: %d\n E seu endereço de memória é:  %p\n\n", i+1, *(ptr+i), (ptr+i));
    } 
}

int main()
{
    int *vet, tam;
    srand(time(NULL));

    tam=7;

    vet=malloc(tam*sizeof(int));
    if(vet==NULL){
        printf("Erro na alocação");
        return 1;
    }

    atribuir(vet, tam);
    mostrar(vet, tam);

    tam=5;

    vet=realloc(vet, tam*sizeof(int));
    if(vet==NULL){
        printf("Erro na realocação");
        return 1;
    }

    atribuir(vet, tam);
    mostrar(vet, tam);

    free (vet);


    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
