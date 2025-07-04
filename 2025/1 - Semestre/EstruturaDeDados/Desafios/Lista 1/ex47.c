#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>

void mostrar(int *ptr){
    int i;
    for(i=0; i<5; i++){
        printf("O elemento %d do vetor é %d e seu endereço %p\n\n", i+1, ptr[i], &ptr[i]);
    }
}

int main()
{
    int *vet1, *vet2;
    vet1=malloc(5*sizeof(int));
    vet2=calloc(5,sizeof(int));

    mostrar(vet1);
    mostrar(vet2);

    free(vet1);
    free(vet2);



    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
