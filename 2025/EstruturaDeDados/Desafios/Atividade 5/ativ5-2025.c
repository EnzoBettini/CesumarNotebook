/*Desenvolva um programa em linguagem C que realize as seguintes operações:

Alocação Dinâmica de Memória:
-------------------------------------------
Crie um vetor dinâmico contendo 10 elementos numéricos (não repetidos) no 
intervalo de 10 a 100, utilizando a função malloc.
Os dados poderão ser gerados aleatóriamente, digitados ou via arquivo texto.
Exiba na tela o endereço de memória do vetor.
Exiba na tela o valor de cada elemento do vetor e seu respectivo 
endereço através da implementação de um procedimento 

Expansão do Vetor:
---------------------------
Redimensione o vetor para conter 15 elementos.
Gere valores aleatórios (entre 100 e 199 não repetidos), para os novos elementos.
Utilize o mesmo procedimento mencionado anteriormente para exibir 
os elementos atualizados, com seus respectivos valores e endereços de memória.

Redução do Vetor:
-------------------------
Reduza o tamanho do vetor para 8 elementos.
Apresente novamente os valores e endereços de memória dos elementos, 
conforme o procedimento já implementado.

Liberação de Memória:
-------------------------------
Certifique-se de liberar a memória alocada ao final da execução do programa, utilizando 
a função free.
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void imprime(int *v, int tot);
int existeElemento(int *v, int n, int fim); //0 nao existe - 1 existe
//-----------------------------------------
int main() {
  srand(time(NULL));
  int *vet, tam=10,tmp,x;
  //alocando 10 elementos 
  vet=malloc(10*sizeof(int));
  if (vet){
    for (x=0; x<tam; x++){
      do
        tmp=(rand()%91)+10;
      while (existeElemento(vet,tmp,x-1)==1);
      *(vet+x)=tmp;
    } 
    imprime(vet,tam);
    //realocando para 15
    tam=15;
    vet=realloc(vet,15*sizeof(int));
    if (vet){
      for (x=10; x<tam; x++){
        do
          tmp=(rand()%100)+100;
        while (existeElemento(vet,tmp,x-1)==1);
        *(vet+x)=tmp;
      }
      imprime(vet,tam); 
      tam=8;
      //realocando para 8
      vet=realloc(vet,8*sizeof(int));
      imprime(vet,tam);
    }
    else
      printf("erro ao alocar memoria\n");
  }
  else
    printf("Erro ao alocar memoria\n");
  system("pause");
  free(vet);
  return 0;
}
//------------------------------------------             
void imprime(int *v, int tot){
  int i;
  printf("Endereco de *v: %p\n",&*v);
  for (i=0; i<tot; i++){
    printf("%3d - %3d - %p \n",i,v[i],&v[i]);
  }
  printf("\n");
}
//------------------------------------------
int existeElemento(int *v, int n, int fim){
  int i;
  for (i=0; i<fim; i++)
    if (n==v[i]) 
      return 1;
  return 0;
}




