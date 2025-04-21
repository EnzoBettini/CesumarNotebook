#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <conio.h>
#include <curses.h>

typedef struct{
    char *nome;
    int qntNotas;
    float *notas, soma;
} Alunos;

void armazenarAlunos(Alunos *ptr, int tam){
    int i, qTemp, n;
    char tmp [100];
    for(i=0; i<tam; i++){
        printf("Digite o nome do aluno %d: ", i+1);
        fflush(stdin);
        fgets(tmp, sizeof(tmp), stdin);
        fflush(stdin);
        ptr[i].nome=malloc((strlen(tmp)+1)*sizeof(char));
        strcpy(ptr[i].nome, tmp);

        printf("Digite a quantidade de notas a serem armazenadas: \n");
        scanf("%d", &ptr[i].qntNotas);

        ptr[i].notas=malloc(ptr[i].qntNotas*sizeof(float));
        for(n=0; n<ptr[i].qntNotas; n++){
            printf("Digite a nota %d: ", n+1);
            scanf("%f", &ptr[i].notas[n]);
            ptr[i].soma+=ptr[i].notas[n];
        }

    }
}

void mostrar(Alunos *ptr, int tam){
    int i;
    for(i=0; i<tam; i++){
        printf("\n\nNome aluno %d é %s", i+1, ptr[i].nome);
        printf("Média do aluno: %.2f", ptr[i].soma/ptr[i].qntNotas);
        free(ptr[i].nome);
        free(ptr[i].notas);
    }
}

int main()
{
    Alunos *turma;
    int qntAlunos;

    printf("Digite a quantidade de alunos:\n");
    scanf("%d", &qntAlunos);

    turma=malloc(qntAlunos*sizeof(Alunos));

    armazenarAlunos(turma, qntAlunos);
    mostrar(turma, qntAlunos);


    return 0;
}

//gcc ex32.c -o ex32 -lncurses para compilar no MACOS
