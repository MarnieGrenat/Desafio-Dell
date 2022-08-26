/*
 * Na main, vou fazer uso dos métodos criados para cada uma das funcionalidades necessárias (cada uma em um arquivo.
 * diferente). Todas variáveis serão inseridas neste código. O objetivo da apresentação dos assentos será fazer
 * apresentação de 5 colunas, sendo a mediana vazia para simular o corredor. (a lógica é: index começa em zero, portanto
 * as duas primeiras colunas da esquerda sempre serão ímpares, então se "index % 2 !=0, imprimir o corredor") a letra "O"
 * significará assento livre, enquanto a letra "X" significará assento ocupado.
 * 
 * Author: Gabriela Dellamora Paim
 * Version: 2022.08.26
 */
import java.util.Scanner;
import java.util.Locale;
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args){
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(System.in);
        private char[] ocupacao;
        private int[] assentos;

        
        
        //adsicionando valores à array ocupacao
        for (int i = 0; i<ocupacao.length; i++){
            String valor = "X";
            ocupacao[i] = valor;
            if (i > 13){ // 14 valores
                valor =  "O";
            }
        }

        int[] assentos = new int[] assentos[45];
        for (int i = 0; i<assentos.length; i++){
            assentos[i] = i++; //começa em 1
        }
        for (int i = 0; i < ocupacao.length; i++){
            int index = i;
            System.out.print(ocupacao[index]);
            index++;
            System.out.print(ocupacao[index]);
            if (i%2 != 0){
                System.out.print("|##|");
            }
            index = i;
            index++;
            System.out.print(assentos[index]);
            index++;
            System.out.print(assentos[index]);
            System.out.println();
            System.out.print(assentos[index]);
            index++;
            System.out.print(assentos[index]);
            if (index%2 != 0){
                System.out.print("|##|");
            }
            index++;
            System.out.print(assentos[index]);
            index++;
            System.out.print(assentos[index]);
            System.out.println();
            i = index;
        }

    }    
}
