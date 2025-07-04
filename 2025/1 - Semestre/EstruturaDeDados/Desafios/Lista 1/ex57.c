#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>

int main()
{
    char ***mat, temp[12];
    int i, j;

    mat = malloc(3 * sizeof(char **));
    for (i = 0; i < 3; i++) {
        mat[i] = malloc(4 * sizeof(char *));
    }

    for (i = 0; i < 3; i++) {
        for (j = 0; j < 4; j++) {
            printf("Digite a string para posição [%d][%d]: ", i, j);
            fgets(temp, sizeof(temp), stdin);
            fflush(stdin);
            temp[strcspn(temp, "\n")] = '\0';
            mat[i][j] = malloc(strlen(temp) + 1);
            strcpy(mat[i][j], temp);
        }
    }

    printf("\nMatriz final:\n");
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 4; j++) {
            printf("%s\t", mat[i][j]);
        }
        printf("\n");
    }

    for (i = 0; i < 3; i++) {
        for (j = 0; j < 4; j++) {
            free(mat[i][j]);
        }
        free(mat[i]);
    }
    free(mat);
    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
