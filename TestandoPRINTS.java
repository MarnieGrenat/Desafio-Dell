
/**
 * Escreva uma descrição da classe TestandoPRINTS aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TestandoPRINTS
{
    public static void main (String[] args){
        NumberFormat formatter = new DecimalFormat("R$:#0.00");
        double x = 1/3;
        System.out.println(formatter.format(x));
                
    }
}
