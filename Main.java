/*
 * Na main, vou fazer uso dos métodos criados para cada uma das funcionalidades necessárias (cada uma em um arquivo.
 * diferente). Todas variáveis serão inseridas neste código. O objetivo da apresentação dos assentos será fazer
 * apresentação de 5 colunas, sendo a mediana vazia para simular o corredor. (a lógica é: index começa em zero, portanto
 * as duas primeiras colunas da esquerda sempre serão ímpares, então se "index % 2 !=0, imprimir o corredor") a letra "O"
 * significará assento livre, enquanto a letra "X" significará assento ocupado.
 * 
 * 
 * Author: Gabriela Dellamora Paim
 * Version: 2022.08.30  
 */
import java.util.Scanner;
import java.util.Locale;
import java.util.Random;

public class Main {    
    public static void main(String[] args){
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(System.in);
        Random ran = new Random();
        Onibus b1 = new Onibus();//Declarando o onibus totalmente null;
        String destino;//Declarando destino para uso em método
        int index;
        String local;
        int destination;
        //settando onibus!
        b1.setAssentos(b1.getAssentos()); //gettando assentos (de 1 a 46);
        b1.setOcupacao(b1.getOcupacao()); //gettando ocupação (todos em "O")
        b1.ranOcupacao(b1.getOcupacao()); //randomizando ocupação
        
        //saudação ao usuário
        System.out.print("Muito bem-vindo(a) à Viação União Santa Cruz! \nDe onde você quer começar sua viagem? \nDigite 1 se você quer começar a viagem de Porto Alegre. Digite 2 caso a sua viagem comece em Criciúma \n");
        int usuario = in.nextInt();
        b1.localChecker(usuario);
        local = b1.localSetter(b1.consignor(usuario));
        
         
        

        //validar se a cidade inicial é válida e setta String local 
        //Descobrimos de onde o usuário vem. Agora precisamos descobrir para onde o usuário vai.
        //Checando se o destino e a cidade inicial não são ambas Criciuma. Além disso, vamos checar se os valores inseridos pelo usuário são válidos (1 ou 2).
        //Caso não, pedimos que o usuário insira valores válidos.
        if (local == "Criciúma"){
            destination = 1;
        }
        else{
            System.out.println("Sua viagem começará em " + local + "! Para onde você quer ir? Digite 1 para Florianópolis e 2 para Criciúma");
            destination = in.nextInt();
        }
        b1.checaDestino(destination, local);
        
        //se passar do checaDestino:
        destino = b1.setDestino(destination, local);
        b1.decideTabela(local, destino);
               
        
        System.out.println("Escolha uma das opções acima e escreva o digito correspondente");
        int horario = in.nextInt(); //receber a decisão do usuário
        while (horario != 1 && horario != 2){
            System.out.println("Por favor, escolha uma opção válida");
            horario = in.nextInt();
        }
        
        
        
        
        System.out.println("Estamos quase terminando a sua compra! \nPara finalizarmos: São quantos passageiros?");
        int passageiros = in.nextInt();
        while (passageiros > 15 || passageiros < 1){
            if (passageiros > 15)
            System.out.println("Não é possivel comprar " + passageiros +", por favor, escolha menos passagens ou compre separadamente");
            if (passageiros < 1)
            System.out.println("por favor, escolha um valor válido de passageiros");
            passageiros = in.nextInt();
        }
        
        
        b1.busVisualizer(); //imprimindo o ônibus para o usuário
        //agora preciso encontrar dentro da lista de ocupacao, algum assento com x espaços livres um atrás do outro. (x = passageiros).
        System.out.println();
        //b1.procuraPassagem(passageiros, b1.getOcupacao());
                
        
        System.out.println("Você pretende comprar " + passageiros + " passagens, certo? Vamos lá!");
        //Escolhas do usuário
        for (int i = 0 ; i < passageiros; i++){
            System.out.println("Escolha um assento para o passageiro "+ (i+1) +":");
            int assentoEscolhido = in.nextInt();
            //Testar para checar se o assento é válido
            b1.testOcupacao(assentoEscolhido);
        }
        Usuario user = new Usuario();
        user.printInfo(local, passageiros, destino, horario);
    }       
}
