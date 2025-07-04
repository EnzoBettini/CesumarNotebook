//PASSANDO PONTEIRO P FUNÇÃO

#include <stdio.h>
#include <stdlib.h>

void mostra(int *num){
printf("%d\n", *num);
*num=50;
}

int main(){
int idade =22;
mostra(&idade);
printf("%d\n", idade);

return 0;
}