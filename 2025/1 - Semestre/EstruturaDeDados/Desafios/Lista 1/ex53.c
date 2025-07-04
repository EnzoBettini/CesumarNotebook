#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void addNum(int *ptr, int tamanho){
    for(int i = 0; i < tamanho; i++){
        ptr[i] = rand() % 101;
    }
}

int main() {
    int *vet, *comp;
    int tam = 10;

    srand(time(NULL));

    vet = malloc(tam * sizeof(int));
    if (vet == NULL) {
        printf("Falha na alocação\n");
        return 1;
    }

    comp = vet;

    addNum(vet, tam);

    tam = 20;
    vet = realloc(vet, tam * sizeof(int));
    if (vet == NULL) {
        printf("Falha na realocação\n");
        return 1;
    }

    if (vet == comp) {
        printf("Alocação apenas expandida, mesmo endereço de memória.\n");
    } else {
        printf("Alocação mudou de lugar na memória.\n");
    }

    free(vet);
    return 0;
}
