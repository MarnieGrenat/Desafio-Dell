
/**
 * Representar em modo texto o estado de cada assento (occupied/available)
 * Para o horário das 6h
 * Para o horário das 10h
 * Para o horário das 16h
 * Para o horário das 20h
 * 
 * Nome dos métodos: **ATUALIZAR NO GIT + JAVADOC
 * 
 * Onibus();
 * getOcupacao() / setOcupacao(String[] ocupacao);
 * getAssentos() / setAssentos(int[] assentos);
 * busVisualizer(int[] assentos, String[] ocupacao);
 * 
 * 
 * @author Gabriela Dellamora Paim 
 * @version 2022.08.31
 */
import java.util.Random;
import java.util.Scanner;
public class Onibus{
    Random ran = new Random();
    Scanner in = new Scanner(System.in);
    
    
    private String[] ocupacao = new String[46]; //Se o assento está ocupado ou não
    private int[] assentos = new int[46]; //quais são os assentos 
    private String valor = "O";
    private int j = 0;
    private int[] dCriciuma = new int[46]; //onde é armazenado os viajantes de x para criciuma
    private int[] dFlorianopolis = new int[46]; // onde é armazenado os viajantes de x para florianopolis
    private int[] vPorto = new int[46]; // onde é armazenado os viajantes de porto alegre para x;
    private int[] vCriciuma = new int[46]; // onde é armazenado os viajantes de criciuma para x;
    
    
    
    
    
    
    //constructor não receberá parametros, já que os onibus são padronizados com 46 assentos
    Onibus(){
        int[] assentos = new int[45];
        String[] ocupacao = new String[45];
        int[] dCriciuma = new int[45];
        int[] dFlorianopolis = new int[45];
        int[] vPorto = new int[45];
        int[] vCriciuma = new int[45];
        setAssentos(assentos);
        setOcupacao(ocupacao);
    }
    //getters e setters
    public String[] getOcupacao(){
        return ocupacao;
    }
    public int[] getAssentos(){
        return assentos;
    }
    
    
    
    /*
     * @param: String[] ocupacao
     */
    public void setOcupacao(String[] ocupacao){
        //trocando os valores null por "O";
        for (int i = 0; i < ocupacao.length; i++){
            valor = "O";
            ocupacao[i] = valor;
        }
    }
    
    
    /*
     * //randomiza os assentos ocupados.
     * @param: String[] ocupacao
     */
    public void ranOcupacao(String[] ocupacao){
        int j = 0;
        while (j < 14){
            if (j <=8){
                int oc = ran.nextInt(45);
                ocupacao[oc] = "X";
                dCriciuma[oc] = 1;
                j++;
            }
            else {
                int oc = ran.nextInt(45);
                ocupacao[oc] = "X";
                dFlorianopolis[oc] = 1;
                j++;
            }
        } 
    }

    /*
     * @param: int[] assentos
     */
    public void setAssentos(int[] assentos){
        int j = 1;
        for (int i = 0; i<46; i++){
            assentos[i] = j; //começa em 1
            j++;
        }
    }
    
    public void busVisualizer(){
        //serve para visualizar graficamente o onibus.
        for (int i = 0; i <= 46; i++){
            String[] ocupacao = getOcupacao();
            int[] assentos = getAssentos();
            int index = i;
            if(i == 44 || i == 45){
              System.out.println("|"+ ocupacao[index++]+ " "+ ocupacao[index++]+ "|##|"+ "Área do|");
              index = i;
              System.out.println("|"+ assentos[index++] + " "+ assentos[index++]+ "|##|"+ "lavabo|");
              break;
            }
            else{
            index = i;
            System.out.println("|"+ ocupacao[index++]+ " "+ ocupacao[index++]+ "|##|"+ ocupacao[index++]+ " "+  ocupacao[index++]+ "|");
            //nao faço ideia do porque funcionou o index++ no valor inicial da array.
            index = i;
            System.out.println("|"+ assentos[index++] + " "+ assentos[index++]+ "|##|"+ assentos[index++]+ " "+  assentos[index++]+ "|");
            }
            i = index-1;
        }
    }
    
    /*
     * @param: int index
     */
    public void testOcupacao(int assentoEscolhido){
        //serve para testar se o assento está ocupado ou não (e se é válido)
        boolean testador = false;
        //testando se o assento é válido
        while (testador == false){
            if (assentoEscolhido > 46 && assentoEscolhido < 1){
                 System.out.println("o assento " + assentoEscolhido + " não existe. Por favor, escolha outro assento.");
                 assentoEscolhido = in.nextInt();
            }
            
            //Testar para checar se o assento não está ocupado
            else if (ocupacao[(assentoEscolhido-1)] == "X"){
                System.out.println ("O assento escolhido já está ocupado. Por favor, escolha outro assento.");
                testador = false;
                assentoEscolhido = in.nextInt();
            }
            else 
                testador =true;
        }   
    }
    
    /*
     * @param: int x
     * //Serve para validar se a cidade inicial é válida
     */
    public int consignor (int user){
        int usuario = user;
        if (user < 1 && user > 2){
            user = -1; // modificar pra exception caso de tempo
            while (usuario != 1 && usuario != 2 ){
            System.out.print("\nEntrada inválida. Por favor, escolha entre Porto Alegre (digito 1) e Criciúma (digito 2)");
            usuario = in.nextInt();
            }
        }
        return user;
    }
    
    public void localChecker(int user){
        while(user != 1 && user != 2){
            System.out.println("Opção inválida. Por favor, escolha entre Porto Alegre (digito 1) e Criciúma (digito 2)");
            user = in.nextInt();
        }      
    }
    
    public String localSetter(int user){
        String local = "XXX";
        if (user == 1){
            local = "Porto Alegre";
        }
        else if (user == 2) {
            local = "Criciúma";
        }
        else{
            System.out.println("Opção inválida. Por favor, escolha entre Porto Alegre (digito 1) e Criciuma (digito 2)");
        }
        return local;
    }
    
    public void checaDestino(int destino, String local){
        // user-proof
        if ((destino > 2 && destino < 1) && (local == "Criciúma" && destino == 2)){
            System.out.println("Escolha um destino válido. Digite 1 para passagens à Florianópolis. Digite 2 para passagens à Criciúma");
            destino = in.nextInt();
        }
    
    }
    public String setDestino(int destino, String local){
        String retorno;
        if (local == "Criciúma"){
            retorno = "Florianópolis";
        }
        else{
            if (destino == 2){
                retorno = "Criciúma";
            }
            else{
                retorno = "Florianópolis";
            }
        }
        return retorno;
    }

    public void decideTabela(String local, String destino){
        boolean retorno = true;
        if (destino == "Florianópolis"){
            if (local == "Porto Alegre"){
                System.out.println("Sua viagem será de " + local + " até Florianópolis! Esse destino tem os seguintes horários:");
                System.out.println();
                //imprime a tabela de horários e preços de POA até florianópolis
                tabelaPoaFlorianopolis();
            }
            if (local  == "Criciúma"){
                System.out.println("Sua viagem será de " + local + " até Florianopolis! Esse destino tem os seguintes horários:");
                System.out.println();
                //imprime a tabela de horários e preços de Criciuma até florianópolis
                tabelaCriFlorianopolis();
            }
        }
        
        else{
            //imprime a tabela de horários e preços de criciuma até Florianópolis
            System.out.println("Sua viagem será de " + local + " até Criciuma! Esse destino tem os seguintes horários:");
            tabelaPoaCriciuma();
        }
    }
    
    public void tabelaPoaFlorianopolis(){
        //imprime a tabela de preços Porto Alegre -> Florianópolis
        System.out.println(" _____________________________________________________ ");
        System.out.println("| Rota de viagem      | Horário | Valor    | Digito   |");
        System.out.println("|_____________________|_________|__________|__________|");
        System.out.println("| POA -> Florianópolis|  06:00  | R$:14,46 | Digito 1 |");
        System.out.println("| POA -> Florianópolis|  16:00  | R$:23,50 | Digito 2 |");
        System.out.println(" _____________________________________________________ ");
    }
    
    public void tabelaPoaCriciuma(){
        //imprime a tabela de preços POA -> Criciuma
        System.out.println(" ________________________________________________ ");
        System.out.println("| Rota de viagem | Horário | Valor    | Digito   |");
        System.out.println("|________________|_________|__________|__________|");
        System.out.println("| POA -> Criciúma|  06:00  | R$:12,90 | Digito 1 |");
        System.out.println("| POA -> Criciúma|  16:00  | R$:15,90 | Digito 2 |");
        System.out.println(" ________________________________________________ ");
    }
    
    public void tabelaCriFlorianopolis(){
        //imprime a tabela de preços Criciuma -> Florianópolis
        System.out.println(" __________________________________________________________ ");
        System.out.println("| Rota de viagem           | Horário | Valor    | Digito   |");
        System.out.println("|__________________________|_________|__________|_________ |");
        System.out.println("| Criciúma -> Florianópolis|  10:00  | R$:07,30 | Digito 1 |");
        System.out.println("| Criciúma -> Florianópolis|  20:00  | R$:10,30 | Digito 2 |");
        System.out.println(" __________________________________________________________ ");
        
    }
    
    //public void procuraPassagem(int passageiros, String[] ocupacao){}
}
