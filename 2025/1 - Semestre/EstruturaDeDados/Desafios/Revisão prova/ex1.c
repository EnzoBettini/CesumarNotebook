#include <stdio.h>
#include <conio.h>

int main(){
    int x=22, *p1, **p2, ***p3;
    p1=&x;
    p2=&p1;
    p3=&p2;

    printf("Valor de x: %d %d %d %d\n", x, *p1, **p2, ***p3);
    printf("Endereco de x: %p %p %p %p\n", &x, p1, *p2, **p3);
    printf("Endereco de p1: %p %p %p\n", &p1, p2, *p3);
    printf("Endereco de p2: %p %p\n", &p2, p3);
    printf("Endereco de p3: %p\n", &p3);
    getch();
    return 0;
}