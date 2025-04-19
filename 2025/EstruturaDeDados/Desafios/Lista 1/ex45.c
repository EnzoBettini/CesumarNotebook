#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>

int main()
{
    float *ptr;
    ptr=malloc(3*sizeof(float));

    for(int i=0; i<3; i++){
        printf("Digite o numero %d\n", i+1);
        scanf("%f", &ptr[i]);
    }

    for(int i=0; i<3; i++){
        printf("número %f\n", ptr[i]);
    }

    free(ptr);

    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
