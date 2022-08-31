
/**
 * Escreva uma descrição da classe Usuario aqui.
 * 
 * @author Gabriela Dellamora Paim;
 * @version 30.08.22;
 */
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Usuario{
    NumberFormat formatter = new DecimalFormat("R$:0.00");
    Scanner in = new Scanner(System.in);
    
    
    private int assento;
    private int passageiros;
    private char cidadeI;
    private char cidadeF;
    private double pagamento;
    //armazenamentos do usuário
    Usuario(){
        int assento;
        char cidadeI;
        char cidadeF;
        double pagamento;
    }
    Usuario(int assento, int passageiros, char cidadeI, char cidadeF, double pagamento){
        this.assento = assento;
        this.passageiros = passageiros;
        this.cidadeI = cidadeI;
        this.cidadeF = cidadeF;
        this.pagamento = pagamento;
    }
    public double precoTotal(String local, String destino, int horario, int passageiros){
        //apresenta valor total que o usuário deve pagar
        double preco = -1;
        if (local == "Porto Alegre"){
            if (destino == "Florianópolis"){
                if (horario == 1){
                    preco = 19.46;
                }
                else{
                    preco = 23.50;
                }
            }
            else{ 
                if (horario == 1){
                    preco = 12.90;
                }
                else{
                    preco = 15.90;
                }
            }   
        }
        else{
            if(horario == 1){
                preco = 07.30;
            }
            else{
                preco = 10.30;
            }
        }
        preco *= passageiros;
        return preco;
    }
    
    public void printInfo(String local, int passageiros, String destino, int horario){
        //confirmação pré compra
        System.out.println("Finalizamos o processo! Por favor, confirme as informações abaixo:");
        System.out.println("Sua viagem vai começar em " + local +".");
        System.out.println("Sua viagem vai terminar em " + destino + ".");
        System.out.println("Você vai comprar " + passageiros + " passagens.");
        System.out.println("O valor total será da sua compra será: " + formatter.format(precoTotal(local, destino, horario, passageiros)));
        boolean confirma = confirmaUser();
        System.out.println(confirma);
    }
    public boolean confirmaUser(){
        System.out.println("Você confirma essa compra? Digite 1 para confirmar. Digite 2 para negar.");
        int resposta = in.nextInt(); 
        boolean confirma;
        while (resposta != 1 && resposta != 2){
            System.out.println("Forneça um valor válido");
            resposta = in.nextInt();
        }
        //se 
        if (resposta == 1){
            confirma = true;
            
        }
        else 
            confirma = false;
        return confirma;
    }
}  