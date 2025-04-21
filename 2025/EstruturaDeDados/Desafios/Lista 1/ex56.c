#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>

int main()
{
    char *nomes[5]; 
    char temp[100]; 
    int i;

    printf("Digite 5 nomes:\n");

    for(i = 0; i < 5; i++) {
        printf("Nome %d: ", i + 1);
        fgets(temp, 100, stdin);

        temp[strcspn(temp, "\n")] = '\0';

        nomes[i] = malloc(strlen(temp) + 1);
        if(nomes[i] == NULL) {
            printf("Erro na alocação de memória.\n");
            return 1;
        }

        strcpy(nomes[i], temp);
    }

    printf("\nEndereço do vetor principal: %p\n", *nomes);
    for(i = 0; i < 5; i++) {
        printf("Nome %d: %s\n", i + 1, nomes[i]);
        printf("Endereço de memória do nome %d: %p\n\n", i + 1, (void*)nomes[i]);
    }

    for(i = 0; i < 5; i++) {
        free(nomes[i]);
    }

    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
