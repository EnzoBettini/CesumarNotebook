#include <stdio.h>
#include <stdlib.h>

int main(){
short int input, i=0, j=0, conta;

	do{
		printf("Digite um numero entre 50 e 10\n");
		scanf("%i", &input);
	}while (input<10 || input>50);
	conta=input*2;
	do{
		printf("i = %i      j = %i\n", i, j);
		i++;
		j=j+5;
	}while(i<=input && j<=conta);
	
	
	
	return 0;
}
