#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

int main(){
    double x = 22, *ptr = &x;
    char nome[] = {"enzo"}, *ptr2 = nome; // Correção aqui

    printf(" %d ", sizeof(x) + sizeof(ptr));
    printf(" %d ", sizeof(x) + sizeof(*ptr));

    getch();
    return 0;
}
