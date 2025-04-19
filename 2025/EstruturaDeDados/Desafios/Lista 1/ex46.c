#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>
#include <time.h>

void addNum(int *str){
    int i;
    for(i=0; i<5; i++){
        str[i]=rand() % 100;
    }
};

void printNum(int *str) {
    printf("Valores randomizados:\n");
    for (int i = 0; i < 5; i++) {
        printf("%d ", str[i]);
    }
    printf("\n");
};

int main()
{
    srand(time(NULL));
    int *vet;
    vet=malloc(5*sizeof(int));

    addNum(vet);

    printNum(vet);

    free(vet);

    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
