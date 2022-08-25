# Desafio-Dell

Desafio proposto pelo IT Academy 17 (Programa de estágio da Dell).

*Author:* Gabriela Dellamora Paim

*Version:* V.1 - 2022.08.24

*Operational System:* Linux Ubuntu 22.04.1 LTS

## Etapa 2 - Apresentação
 
[OneDrive](https://brpucrs-my.sharepoint.com/:f:/g/personal/g_paim02_edu_pucrs_br/EvuyxIH-ly9IjLM1bjcByXUBFvwiOyjbFMyRe7kFtIyFLw?e=8YpW97)

Este projeto simula um sistema de reserva de passagens de ônibus, sendo todos os veículos da linha 160 (Porto Alegre -> Florianópolis, com parada na cidade de Criciúma) e com **46 assentos**. 

Rota | Horário | Valor
--------|---------|-----
Porto Alegre -> Florianópolis |  06 horas | R$: 19.45
Porto Alegre -> Florianópolis | 16 horas |  R$: 23.50
Porto Alegre -> Criciúma |  06 horas | R$: 12.90
Porto Alegre -> Criciúma | 16 horas | R$: 15.90
Criciúma -> Florianópolis | 10 horas | R$: 07.30
Criciúma -> Florianópolis | 20 horas |  R$: 10.30

O sistema **DEVERÁ** iniciar mostrando o mapa de assentos na tela (em modo texto), com cerca de **30% dos assentos já ocupados** sendo metade deles passageiros de **Porto Alegre à Florianópolis e a outra metade de Porto Alegre à Criciúma**, não importando se as reservas serão manuais, fixas ou aleatórias.


## Funcionalidades necessárias

#### 1. [seat map visualizer] **ADD LINK**
Representar em modo texto o estado de cada assento (occupied/available)
1. Para o horário das 6h
2. Para o horário das 10h
3. Para o horário das 16h
4. Para o horário das 20h

#### 2. [ticket booking] **ADD LINK**
Permitir que o usuário escolha um assento livre para o horário que deseja. O programa deverá solicitar o **identificador do assento (INT).** Caso disponível, o programa deve assinalar o assento como **occupied**. Caso contrário, deverá **exibir uma mensagem ao usuário e retornar ao menu.**
1. Uma passagem para a rota Porto Alegre -> Florianópolis
2. Uma passagem para a rota Porto alegre -> Criciúma
3. Uma passagem para a rota Criciúma -> Florianópolis

#### 3. [release booking] **ADD LINK**
O programa deverá solicitar o identificador do assento e liberá-lo.

#### 4. [find free seats] **ADD LINK**
Solicitar ao usuário quantos assentos ele gostaria de reservar em um determinado horário. Nessa etapa, é necessário que seja mais de um assento e localizar a primeira sequência de assentos (assentos lado a lado) que estiver disponível e marcá-los como ocupados (para o usuário). Caso não haja uma sequência disponível, exibir uma mensagem ao usuário.

#### 5. [statistic data] **ADD LINK**
Exibir o mapa de assento da rota e apresentar as seguintes informações: número de assentos total, número de assentos disponíveis, número de assentos reservados e total acumulado em reservas.
1. Uma passagem para a rota Porto Alegre -> Florianópolis
2. Uma passagem para a rota Porto alegre -> Criciúma
3. Uma passagem para a rota Criciúma -> Florianópolis

#### 6. [break]
Permitir que usuário saia do programa/finalize o programa.

#### Observações do processo seletivo:
1. Sugere-se o desenvolvimento de um programa na linguagem e na interface de sua preferência, podendo ser gráfica ou textual/console, com um menu com as opções enumeradas nos requisitos;
2. Deve-se escrever o código que realiza as funções requeridas e armazena os dados lidos em memória (do jeito que quiser);
3. Não é necessário gravar dados em nenhum formato, nem usar sistemas de banco de dados;
4. O programa **deverá lidar com dados de entrada inválidos** e informar uma mensagem adequada caso ocorram;
5. Para facilitar, não é necessário lidar com acentuação de palavras;
6. Na escrita do relatório, **apresente comentários sobre como você realizou os testes e a autoavaliação**.

#### Observações da programadora:
O objetivo atual é construir uma lógica para inserção do código para um site e um aplicativo. A principio, a decisão inicial será fazer o código das atividades do projeto em *Python3*. Caso haja tempo para a HUD do projeto, tem-se com objetivo o criar com *JavaScript*.
O programa será desenvolvido da mesma forma que proposto: a *main* conterá todos tópicos contidos na "**Etapa 2 - Apresentação**", enquanto as funcionalidades serão separadas da mesma forma que os tópicos na "**Funcionalidades Necessárias**", em arquivos diferentes.

Todo projeto será desenvolvido usando as seguintes ferramentas:
- GitHub
- Git
- Jupyter Notebook / Jupyter Lab


**Anotações:**

Aprofundar programação orientada a objetos.
Aprender a criar projetos em python.



## *Main*
Linguagem: Python3

Na *main*, vou fazer uso dos métodos criados para cada uma das funcionalidades necessárias (cada uma em um arquivo diferente).
Todas variáveis serão inseridas neste código. O objetivo da apresentação dos assentos será fazer apresentação de 5 colunas, sendo a mediana vazia para simular o corredor. (a lógica é: index começa em zero, portanto as duas primeiras colunas da esquerda sempre serão ímpares, então se "index % 2 !=0, imprimir o corredor") a letra "O" significará assento livre, enquanto a letra "X" significará assento ocupado.

**LEMBRANDO QUE**

O programa deve OBRIGATORIAMENTE apresentar 30% dos assentos já ocupados, sendo metade desses com destino à Florianópolis e a outra metade para Criciúma.
A primeira versão do programa selecionará os assentos ocupados de forma fixa, para evitar desperdício de tempo em assets detalhistas.

__Pseudocódigo:__
```
STRING ocupacao[45(+1)] => X,O,O,X..O
INT assentos[45(+1)] => 1,2,3,4..,46
for (int i(=0)  < (array.length)/4 i++)#printar 4x na mesma coluna, portanto dividir lenght por 4{
 print(ocupacao[i])
 i++
 print(ocupacao[i])
  if ( i%2 != 0){
  print("|##|")
  }
}
print(/n)  
for (int i(=0)  < (array.length)/4 i++)#printar 4x na mesma coluna, portanto dividir lenght por 4{
 print(ocupacao[i])
 i++
 print(ocupacao[i])
  if ( i%2 != 0){
  print("|##|")
  }
}

#TA ERRADO! PRECISO IMPRIMIR 2 2 x 2 2 // 1 1 x 1 1 E TA IMPRIMINDO 1 1 x 1 1 // 1 1 x 1 1 ....(46x) 2 2 x 2 2 // 2 2 x 2 2...(46x)
 #aqui estou imprimindo o onibus, para visualização do usuário.
 #Criar um método para essa impressão e importar ele para main
 ```
