#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>

int main() {
    int *ptr, *comp;
    srand(time(NULL));

    ptr = malloc(10 * sizeof(int));

    for (int i = 0; i < 10; i++) {
        ptr[i] = rand() % 101;
        printf(" %d ", ptr[i]);
    }

    comp = ptr; // salva o endereço original

    printf("\n\nEndereco atribuido comp (antes do realloc): %p", comp);
    printf("\nEndereco de ptr (antes do realloc): %p", ptr);

    ptr = realloc(ptr, 1 * sizeof(int));

    printf("\n\nEndereco atribuido comp (depois do realloc): %p", comp);
    printf("\nEndereco de ptr (depois do realloc): %p", ptr);

    comp==ptr ? printf("\nNao foi alterado") : printf("\nfoi alterado");

    getch();
    free(ptr);
    return 0;
}
