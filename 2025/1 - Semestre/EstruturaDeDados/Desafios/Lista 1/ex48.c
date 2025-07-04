#include <stdio.h>
#include <stdlib.h>
#include <curses.h> // só se você for usar funções da ncurses

int main()
{
    int size;
    void *ptr;

    printf("Qual o tamanho do vetor float você deseja: \n");
    scanf("%d", &size);

    ptr = malloc(size * sizeof(float));
    if(ptr == NULL){
        printf("Erro ao alocar memória\n");
        return 1;
    }

    printf("O tamanho em bytes alocado é de: %lu bytes\n", size * sizeof(float));

    free(ptr);

    return 0;
}
