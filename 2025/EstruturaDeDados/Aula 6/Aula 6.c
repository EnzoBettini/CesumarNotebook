#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() { 
    int **mat, i, j;
    
    srand(time(NULL));

    // Correção: Alocação correta para um array de 3 ponteiros para inteiros
    mat = malloc(3 * sizeof(int *));
    
    // Correção: Loop correto para alocar memória para 3 linhas
    for (i = 0; i < 4; i++) {
        mat[i] = malloc(4 * sizeof(int)); // Cada linha armazena 4 inteiros
    }

    // Preenchendo a matriz com valores aleatórios
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 4; j++) {
            mat[i][j] = rand() % 100;  
        }
    }

    // Imprimindo a matriz
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 4; j++) {
            printf("%d ", mat[i][j]);
        }
        printf("\n");
    }

    // Liberando memória
    for (i = 0; i < 3; i++) {
        free(mat[i]);
    }
    free(mat);

    return 0;
}
