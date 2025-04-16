#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

int main()
{
    int n1, *ptr;

    printf("Digite o valor da variavel n1: \n");
    scanf("%d", &n1);
    ptr = &n1;

    printf("\n%d %p\n", n1, &n1);
    printf("\n%p\n", &n1);
    printf("\n%d\n", ptr);
    printf("\n%p\n", &ptr);
    printf("\n%d\n", *ptr);
    printf("\n%d\n", &*ptr);
    printf("\n%d\n", sizeof(n1));
    printf("\n%d\n", sizeof(ptr));
    printf("\n%d\n", sizeof(*ptr));

    getch();
    return 0;
}