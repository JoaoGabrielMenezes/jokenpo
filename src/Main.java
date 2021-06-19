import java.io.IOException;
import java.util.Scanner;
/**
 * @author joao menezes
 */
public class Main {

        private static Scanner sc;
        private static String name,anim,data,player_choice;
        private static String[] rival = {"Jorge","Joao","Lucas","Marcos","Luis","Pedro","Carla","Mariana","Ligia","Rafaela","Gabriela"};
        private static String[] bot = {"pedra","papel","tesoura"};
        private static int arrayPlayer,arrayRival,pontosRival,pontosPlayer;
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";

    public static void title() throws InterruptedException, IOException {
        System.out.println("=========================");
        System.out.println("seja bem vindo ao JOKENPO");
        System.out.println("=========================");
        Thread.sleep(1000);
    }    

    public static void clear() throws InterruptedException, IOException{
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }else{
            Runtime.getRuntime().exec("clear");
        }
    }

    private static void loading() throws IOException, InterruptedException {
        anim = "|/-\\";
        for (int i = 0 ; i < 101 ; i++) {
            data = "\r" + anim.charAt(i % anim.length()) + " " + i;
            System.out.write(data.getBytes());
            Thread.sleep(10);
        }
    }

    public static void _init_() throws InterruptedException, IOException {
        title();
        System.out.print("\nOla qual o seu nome: ");
        name = sc.next();
        System.out.println("Seja bem vindo "+ANSI_GREEN+name+ANSI_RESET+"\n");
        arrayRival = (int) (Math.random() * rival.length);
        System.out.println(ANSI_RED+rival[arrayRival]+ANSI_RESET+" Sera seu(a) oponente");
        Thread.sleep(15);
        loading();
        game();
    }

    private static void game() throws InterruptedException, IOException {
       System.out.println("\nDigite\n- Pedra\n- Papel\n- Tesoura\n- Sair");
       player_choice = sc.next();
       player_choice.toLowerCase();
       arrayPlayer = (int) (Math.random() * bot.length);

       if (player_choice.equals("pedra") && arrayPlayer == 1 || player_choice.equals("papel") && arrayPlayer == 2 || player_choice.equals("tesoura") && arrayPlayer == 0) {
            pontosRival++;
            System.out.println(name+ANSI_RED+" perdeu voce escolheu " + player_choice.toUpperCase()+" e "+ANSI_RESET+ANSI_YELLOW+rival[arrayRival]+" ecolheu "+bot[arrayPlayer].toUpperCase()+ANSI_RESET+" total de pontos "+name+" = "+pontosPlayer+" e "+rival[arrayRival]+" = "+pontosRival);
            Thread.sleep(1500);
            game();
        }else if(player_choice.equals("pedra") && arrayPlayer == 2 || player_choice.equals("papel") && arrayPlayer == 0 || player_choice.equals("tesoura") && arrayPlayer == 1 ){
            pontosPlayer++;
            System.out.println(name+ANSI_GREEN+" ganhou voce escolheu "+ player_choice.toUpperCase()+" e "+ANSI_RESET+ANSI_YELLOW+rival[arrayRival]+" ecolheu "+bot[arrayPlayer].toUpperCase()+ANSI_RESET+" total de pontos "+name+" = "+pontosPlayer+" e "+rival[arrayRival]+" = "+pontosRival);
            Thread.sleep(1500);
            game();
        }else if(player_choice.equals("pedra")  && arrayPlayer == 0 || player_choice.equals("papel")  && arrayPlayer == 1 || player_choice.equals("tesoura")  && arrayPlayer == 2){
            System.out.println(ANSI_YELLOW+"EMPATE ambos escolheram "+ANSI_RESET+ player_choice.toUpperCase());
            Thread.sleep(1500);
            game();
        }else if(player_choice.toLowerCase().equals("sair")){
            clear();
            System.out.println("\tTotal-de-pontos\n"+name.toUpperCase()+" = "+pontosPlayer+"\n"+rival[arrayRival].toUpperCase()+" = "+pontosRival+ANSI_GREEN+"\nObrigador por jogarem voltem sempre"+ANSI_RESET);
            System.exit(0);
        }else{
            System.out.println(name +ANSI_RED+" escolha um opcao valida !!!"+ANSI_RESET);
            Thread.sleep(1000);
            clear();
            game();
        }
    }
    
    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        _init_();
    }
}