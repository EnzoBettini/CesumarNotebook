#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void addNum(int **ptr) {
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 4; j++) {
            ptr[i][j] = (rand() % 101) + 100;  
        }
    }
}

int main() {
    int **mat;
    srand(time(NULL));

    mat = malloc(5 * sizeof(int*));
    if (mat == NULL) {
        printf("Erro ao alocar memória para linhas.\n");
        return 1;
    }

    for (int i = 0; i < 5; i++) {
        mat[i] = malloc(4 * sizeof(int));
        if (mat[i] == NULL) {
            printf("Erro ao alocar memória para colunas da linha %d.\n", i);
            return 1;
        }
    }

    addNum(mat);

    printf("Matriz 5x4 com valores entre 100 e 200:\n");
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 4; j++) {
            printf("%d\t", *(*(mat+1)+j));
        }
        printf("\n");
    }

    for (int i = 0; i < 5; i++) {
        free(mat[i]);
    }
    free(mat);

    return 0;
}
