#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int numeroPessoa;
    char *nome;
    char *endereco;
    char *cidade;
    char *sexo;
    int cpf;
    int rg;
    char *email;
} cadastroPessoa;

void cadastrarPessoa(cadastroPessoa *pessoaCadastro, int *id, int qnt) {
    char tmpChar[100];
    int tmpNum;

    for (int j = 0; j < qnt; j++) {
        int i = *id;

        printf("Digite o nome da pessoa: ");
        fgets(tmpChar, sizeof(tmpChar), stdin);
        fflush(stdin);
        pessoaCadastro[i].nome = malloc(strlen(tmpChar) + 1);
        strcpy(pessoaCadastro[i].nome, tmpChar);

        printf("Digite o endereco da pessoa: ");
        fgets(tmpChar, sizeof(tmpChar), stdin);
        fflush(stdin);
        pessoaCadastro[i].endereco = malloc(strlen(tmpChar) + 1);
        strcpy(pessoaCadastro[i].endereco, tmpChar);

        printf("Digite a cidade da pessoa: ");
        fgets(tmpChar, sizeof(tmpChar), stdin);
        fflush(stdin);
        pessoaCadastro[i].cidade = malloc(strlen(tmpChar) + 1);
        strcpy(pessoaCadastro[i].cidade, tmpChar);

        printf("Digite o sexo da pessoa: ");
        fgets(tmpChar, sizeof(tmpChar), stdin);
        fflush(stdin);
        pessoaCadastro[i].sexo = malloc(strlen(tmpChar) + 1);
        strcpy(pessoaCadastro[i].sexo, tmpChar);

        printf("Digite o CPF da pessoa: ");
        scanf("%d", &tmpNum);
        fflush(stdin);
        pessoaCadastro[i].cpf = tmpNum;

        printf("Digite o RG da pessoa: ");
        scanf("%d", &tmpNum);
        fflush(stdin);
        pessoaCadastro[i].rg = tmpNum;

        printf("Digite o e-mail da pessoa: ");
        fgets(tmpChar, sizeof(tmpChar), stdin);
        fflush(stdin);
        pessoaCadastro[i].email = malloc(strlen(tmpChar) + 1);
        strcpy(pessoaCadastro[i].email, tmpChar);

        pessoaCadastro[i].numeroPessoa = i;

        (*id)++;
    }
}

void excluirPessoa(cadastroPessoa *pessoaCadastro, int id) {
    free(pessoaCadastro[id].nome);
    free(pessoaCadastro[id].endereco);
    free(pessoaCadastro[id].cidade);
    free(pessoaCadastro[id].sexo);
    free(pessoaCadastro[id].email);

    pessoaCadastro[id].nome = NULL;
}

void editarPessoa(cadastroPessoa *pessoaCadastro, int id) {
    char tmpChar[100];
    int tmpNum;

    free(pessoaCadastro[id].nome);
    free(pessoaCadastro[id].endereco);
    free(pessoaCadastro[id].cidade);
    free(pessoaCadastro[id].sexo);
    free(pessoaCadastro[id].email);

    printf("Digite o nome da pessoa: ");
    fgets(tmpChar, sizeof(tmpChar), stdin);
    fflush(stdin);
    pessoaCadastro[id].nome = malloc(strlen(tmpChar) + 1);
    strcpy(pessoaCadastro[id].nome, tmpChar);

    printf("Digite o endereco da pessoa: ");
    fgets(tmpChar, sizeof(tmpChar), stdin);
    fflush(stdin);
    pessoaCadastro[id].endereco = malloc(strlen(tmpChar) + 1);
    strcpy(pessoaCadastro[id].endereco, tmpChar);

    printf("Digite a cidade da pessoa: ");
    fgets(tmpChar, sizeof(tmpChar), stdin);
    fflush(stdin);
    pessoaCadastro[id].cidade = malloc(strlen(tmpChar) + 1);
    strcpy(pessoaCadastro[id].cidade, tmpChar);

    printf("Digite o sexo da pessoa: ");
    fgets(tmpChar, sizeof(tmpChar), stdin);
    fflush(stdin);
    pessoaCadastro[id].sexo = malloc(strlen(tmpChar) + 1);
    strcpy(pessoaCadastro[id].sexo, tmpChar);

    printf("Digite o CPF da pessoa: ");
    scanf("%d", &tmpNum);
    fflush(stdin);
    pessoaCadastro[id].cpf = tmpNum;

    printf("Digite o RG da pessoa: ");
    scanf("%d", &tmpNum);
    fflush(stdin);
    pessoaCadastro[id].rg = tmpNum;

    printf("Digite o e-mail da pessoa: ");
    fgets(tmpChar, sizeof(tmpChar), stdin);
    fflush(stdin);
    pessoaCadastro[id].email = malloc(strlen(tmpChar) + 1);
    strcpy(pessoaCadastro[id].email, tmpChar);
}

void consultarRegistros(cadastroPessoa *pessoaCadastro, int total) {
    for (int i = 0; i < total; i++) {
        if (pessoaCadastro[i].nome != NULL) {
            printf("\nID: %d", pessoaCadastro[i].numeroPessoa);
            printf("Nome: %s", pessoaCadastro[i].nome);
            printf("Endereco: %s", pessoaCadastro[i].endereco);
            printf("Cidade: %s", pessoaCadastro[i].cidade);
            printf("Sexo: %s", pessoaCadastro[i].sexo);
            printf("CPF: %d\n", pessoaCadastro[i].cpf);
            printf("RG: %d\n", pessoaCadastro[i].rg);
            printf("Email: %s\n", pessoaCadastro[i].email);
        }
    }
}

int main() {
    cadastroPessoa *pessoa = NULL;
    int contador = 0;
    int capacidade = 0;
    int opcao;

    do {
        printf("\n 1 - Adicionar\n 2 - Excluir\n 3 - Editar\n 4 - Consultar\n 0 - Sair\n Opcao: ");
        scanf("%d", &opcao);
        fflush(stdin);

        switch (opcao) {
            case 1:
                if (contador >= capacidade) {
                    capacidade += 5;
                    pessoa = realloc(pessoa, capacidade * sizeof(cadastroPessoa));
                }
                cadastrarPessoa(pessoa, &contador, 1);
                break;
            case 2:
                printf("Digite o ID da pessoa para excluir: ");
                int idDel;
                scanf("%d", &idDel);
                fflush(stdin);
                excluirPessoa(pessoa, idDel);
                break;
            case 3:
                printf("Digite o ID da pessoa para editar: ");
                int idEdit;
                scanf("%d", &idEdit);
                fflush(stdin);
                editarPessoa(pessoa, idEdit);
                break;
            case 4:
                consultarRegistros(pessoa, contador);
                break;
        }
    } while (opcao != 0);

    for (int i = 0; i < contador; i++) {
        if (pessoa[i].nome != NULL) {
            free(pessoa[i].nome);
            free(pessoa[i].endereco);
            free(pessoa[i].cidade);
            free(pessoa[i].sexo);
            free(pessoa[i].email);
        }
    }
    free(pessoa);

    return 0;
}

//PROFESSOR USEI O CHAT PARA FORMATAR ESSE CÓDIGO, TAVA MUITO GRANDE E EU ESTAVA ME PERDENDO