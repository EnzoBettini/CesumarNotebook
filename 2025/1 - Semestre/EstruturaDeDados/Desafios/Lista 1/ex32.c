#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>

int main()
{
    int a, *b, **c, ***d;
    b = &a;
    c = &b;
    d = &c;

    printf("informe um valor: \n");
    scanf("%d", &a);

    printf("o quadruplo de %d é: %d", a, ***d * 4);

    getch();
    return 0;
}