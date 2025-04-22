#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
//#include <curses.h>
#include <time.h>

void adicionarElemento(int **matr, int lin, int col, int *contador){
    int i,j;
    for(i=0; i<lin; i++){
        for(j=0; j<col; j++){
            *(*(matr+i)+j)=*contador;
            (*contador)++;
        }
    }
}

void mostrar(int **matr, int lin, int col){
    int i,j;
    for(i=0; i<lin; i++){
        for(j=0; j<col; j++){
            printf(" %d ", *(*(matr+i)+j));
        }
        printf("\n");
    }
    printf("\n\n\n");
}

int main()
{
    srand(time(NULL));
    int **mat;
    int linha=3;
    int coluna=5;
    int cont=1;
    mat=malloc(linha*sizeof(int*));
    for(int i=0; i<3; i++){
        mat[i]=malloc(coluna*sizeof(int));
    }

    adicionarElemento(mat, linha, coluna, &cont);
    mostrar(mat, linha, coluna);

    linha=5;

    mat=realloc(mat, linha*sizeof(int*));
    for(int i=3; i<linha; i++){
        mat[i]=malloc(coluna*sizeof(int));
    }

    adicionarElemento(&mat[3], 2, coluna, &cont);
    mostrar(mat, linha, coluna);



    for(int i=0; i<5; i++){
        free(mat[i]);
    }
    free(mat);
    

     return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
