#include <stdio.h>
#include <stdlib.h>

int main(){
short int input, sum;
	do{
		printf("Digite um numero entre 20 e 5\n");
		scanf("%i", &input);
	}while (input<5 || input>20);
	sum=input;
	for(short int x=0; x<=input; x++){
		printf("%i    %i\n", x, sum);
		sum--;
	}
	
	
	
	return 0;
}
