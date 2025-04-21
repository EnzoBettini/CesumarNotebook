// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <locale.h>
// #include <ctype.h>

// /* 
// Professor o exercício já era grande portanto na hora de alocar eu não fiz a parte dos ifs pra verificar se foi possível alocar ou não (if(vet) {])
// */

// //----------STRUCT----------
// typedef struct {
//     int idkey;
//    char *nome;
//    char *cidade;
//    char *endereco;
//    char sexo;
//    char *cpf;
//    char *rg;
//    char *email;
// } Pessoa;
// //----------STRUCT----------

// //----------VAR GLOBAIS----------
// int qnt = 0, i; 
// Pessoa *pessoa;
// //----------VAR GLOBAIS----------

// //----------FUNÇÕES----------
// void limpa();
// void adicionar();
// void editar();
// void remover();
// void consulta();
// void menu();
// void erroRemover();
// void continuaRemover();
// //----------FUNÇÕES----------

// //----------MAIN----------
// int main() {
//     
//     pessoa = malloc(1 * sizeof(Pessoa));
//     
//    menu();
//    for (i = 0; i < qnt; i++) {
//        free(pessoa[i].nome);
//        free(pessoa[i].cidade);
//        free(pessoa[i].endereco);
//        free(pessoa[i].email);
//    }
//    free(pessoa);
//    return 0;
// }
// //----------MAIN----------

// void menu() { 
//     limpa();
//    int qtd = 0;             
//    int op;

//    do {
//        printf("\n--------------- Cadastro de Pessoas ---------------\n");
//        printf("1 - Inclusao\n");
//        printf("2 - Alterar\n");
//        printf("3 - Exclusao\n");
//        printf("4 - Consulta\n");
//        printf("0 - Sair\n");
//        printf("--------------- Cadastro de Pessoas ---------------\n");
//        printf("Escolha uma opcao: ");
//        scanf("%d", &op);
//        getchar();

//        switch(op) {
//            case 1:
//                adicionar();
//                break;
//            case 2:
//                editar();
//                break;
//            case 3:
//                remover();
//                break;
//            case 4:
//                consulta();
//                break;
//            case 0:
//                printf("Saindo...\n");
//                break;
//            default:
//                printf("Opção inválida!\n");
//        }
//    } while(op != 0);
// }

// void limpa() {
//     system("cls");
// }

// //----------ADICIONAR----------
// void adicionar() {
//   char tmp[250]; 
//   int tam;
  
//   pessoa = realloc(pessoa, (qnt + 1) * sizeof(Pessoa));
//   fflush(stdin);
//   limpa();
//   printf("--------------- Cadastro de Pessoas ---------------\n");
//   printf("Digite o nome:");
//   gets(tmp);
//   tam = strlen(tmp);
//   pessoa[qnt].idkey = qnt;
//   pessoa[qnt].nome = malloc((tam + 1) * sizeof(char));
//   strcpy(pessoa[qnt].nome, tmp); 
//   fflush(stdin);
//   printf("Digite seu endereço:");
//   gets(tmp);
//   tam = strlen(tmp);
//   pessoa[qnt].endereco = malloc((tam + 1) * sizeof(char));
//   strcpy(pessoa[qnt].endereco, tmp); 
//   fflush(stdin);
  
//   printf("Digite sua cidade:");
//   gets(tmp);
//   tam = strlen(tmp);
//   pessoa[qnt].cidade = malloc((tam + 1) * sizeof(char));
//   strcpy(pessoa[qnt].cidade, tmp); 
//   fflush(stdin);
  
//   char sexoE;
//     do {
//         printf("Digite o Sexo (M ou F): ");
//         scanf(" %c", &sexoE);
//           fflush(stdin);
//     } while (sexoE != 'M' && sexoE != 'F');

//     pessoa[qnt].sexo = sexoE;

  
//   printf("Digite seu CPF:");
//   gets(tmp);
//   tam = strlen(tmp);
//   pessoa[qnt].cpf = malloc((tam + 1) * sizeof(char));
//   strcpy(pessoa[qnt].cpf, tmp); 
//   fflush(stdin);
  
//   printf("Digite seu RG:");
//   gets(tmp);
//   tam = strlen(tmp);
//   pessoa[qnt].rg = malloc((tam + 1) * sizeof(char));
//   strcpy(pessoa[qnt].rg, tmp); 
//   fflush(stdin);
  
//   printf("Digite seu email:");
//   gets(tmp);
//   tam = strlen(tmp);
//   pessoa[qnt].email = malloc((tam + 1) * sizeof(char));
//   strcpy(pessoa[qnt].email, tmp); 
//   fflush(stdin);
//   printf("--------------- Cadastro de Pessoas ---------------\n");
  
//     printf("IDKEY: %d | %s foi inserido com Sucesso! Aperte ENTER para voltar pro MENU!", pessoa[qnt].idkey, pessoa[qnt].nome);
//     getchar();
//     qnt++;
//     limpa();
//     fflush(stdin);
// }    

// void editar() {
//     int idDigitado, tam;
//     char tmp[250], sexoE;
//    limpa();
//    printf("--------------- Editar Pessoas ---------------\n");
//    for(i = 0; i < qnt; i++)
//        printf("IDKEY: %d | Nome: %s\n", pessoa[i].idkey, pessoa[i].nome);
//    printf("Selecione o ID que deseja editar:");
//    scanf("%d", &idDigitado);
//    fflush(stdin);
   
//    printf("Novo Nome: ");
//    gets(tmp);
//    tam = strlen(tmp);
//    pessoa[idDigitado].nome = realloc(pessoa[idDigitado].nome, (tam + 1) * sizeof(char));
//    strcpy(pessoa[idDigitado].nome, tmp);
//    printf("Novo Cidade: ");
//    gets(tmp);
//    tam = strlen(tmp);
//    pessoa[idDigitado].cidade = realloc(pessoa[idDigitado].cidade, (tam + 1) * sizeof(char));
//    strcpy(pessoa[idDigitado].cidade, tmp);
//    printf("Novo Endereco: ");
//    gets(tmp);
//    tam = strlen(tmp);
//    pessoa[idDigitado].endereco = realloc(pessoa[idDigitado].endereco, (tam + 1) * sizeof(char));
//    strcpy(pessoa[idDigitado].endereco, tmp);
//     do {
//         printf("Novo Sexo (M ou F): ");
//         scanf(" %c", &sexoE);
//           fflush(stdin);
//     } while (sexoE != 'M' && sexoE != 'F');

//     pessoa[idDigitado].sexo = sexoE;
//    printf("Novo CPF: ");
//    gets(tmp);
//    tam = strlen(tmp);
//    pessoa[idDigitado].cpf = realloc(pessoa[idDigitado].cpf, (tam + 1) * sizeof(char));
//    strcpy(pessoa[idDigitado].cpf, tmp);
//    printf("Novo RG: ");
//    gets(tmp);
//    tam = strlen(tmp);
//    pessoa[idDigitado].rg = realloc(pessoa[idDigitado].rg, (tam + 1) * sizeof(char));
//    strcpy(pessoa[idDigitado].rg, tmp);
//    printf("Novo EMAIL: ");
//    gets(tmp);
//    tam = strlen(tmp);
//    pessoa[idDigitado].email = realloc(pessoa[idDigitado].email, (tam + 1) * sizeof(char));
//    strcpy(pessoa[idDigitado].email, tmp);
//     printf("--------------- Editar Pessoas ---------------\n");
//     printf("IDKEY: %d | Nome: %s foi ALTERADO com SUCESSO\n--APERTE ENTER PARA VOLTAR AO MENU--", pessoa[idDigitado].idkey, pessoa[idDigitado].nome);
//     getchar();
//     limpa();
// }

// void erroRemover() {
//     printf("--------------- ERROR ---------------\n");
//     printf("O ID INSERIDO NÃO EXISTE NO SISTEMA\n");
//     printf("PARA VOLTAR AO MENU INICIAR APERTE ENTER");
//    printf("--------------- ERROR ---------------\n");
//    getch()
//    limpa();
// }

// void continuaRemover() {
//     free(pessoa[idRemover].nome);
//    free(pessoa[idRemover].cidade);
//    free(pessoa[idRemover].endereco);
//    free(pessoa[idRemover].email);
   
//    for(i = idRemover; i < qnt-1; i++) {
//        pessoa[i] = pessoa[i+1];
//     }
//     
//     qnt--;
//     pessoa = realloc(pessoa, qnt*sizeof(Pessoa));
// }

// void remover() {
//    limpa();
//    int idRemover;
//    printf("--------------- Remover Pessoas ---------------\n");
//    for(i = 0; i < qnt; i++)
//        printf("IDKEY: %d | Nome: %s\n", pessoa[i].idkey, pessoa[i].nome);
//    printf("--------------- Remover Pessoas ---------------\n");
//    printf("Selecione o ID que deseja remover:");
//    scanf("%d", &idRemover);
   
//    idRemover < 0 || idRemover > qnt ? erroRemover() : continuaRemover();

// }

// void consulta() {
//     limpa();
//    for(i = 0; i < qnt; i++) {
//        printf("--------------- Lista de Pessoas ---------------\n");
//        printf("Idkey: %d\n", pessoa[i].idkey);
//        printf("Nome: %s\n", pessoa[i].nome);
//        printf("Endereco: %s\n", pessoa[i].endereco);
//        printf("Cidade: %s\n", pessoa[i].cidade);
//        pessoa[i].sexo == 'F' ? printf("Sexo: Feminino\n") : printf("Sexo: Masculino\n");
//        printf("CPF: %s\n", pessoa[i].cpf);
//        printf("RG: %s\n", pessoa[i].rg);
//        printf("Email: %s\n", pessoa[i].email);
//         printf("--------------- Lista de Pessoas ---------------\n");
//         printf("\n ...PROXIMO...\n");
//         getchar();
//     }
//     limpa();
// }