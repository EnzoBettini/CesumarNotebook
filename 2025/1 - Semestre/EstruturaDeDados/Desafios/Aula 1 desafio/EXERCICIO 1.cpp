#include <stdio.h>
#include <stdlib.h>

int main(){
	float valortotal, soma, media;
	short int pessoas=0;
	
	do{
		printf("Digite o valor a ser doado!\n");
		scanf("%f", &soma);
		valortotal=valortotal+soma;
		pessoas++;
	} while(pessoas<100 && valortotal<7500);
	media=valortotal/pessoas;
	if(valortotal>=7500){
		printf("O valor total doado e de %.2f feito por %i pessoas\n", valortotal, pessoas);
		printf("a media de valor doado por pessoa e: %.2f\n", media);
	}else{
		printf("O valor arrecadado e menor que 7500 reais! Numero maximo de 100 pessoas atingido!\n");
		printf("a media de valor doado por pessoa e: %.2f\n", media);
	}
	return 0;
}
