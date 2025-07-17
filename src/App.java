import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);

    public static String[] opcoes(){
        String[] opcoes = {"pedra", "papel", "tesoura"};
        return opcoes;
    }

    public static String jogadaJogador(){
        System.out.printf("Informe sua jogada: ");
        String jogada = input.nextLine();

        return jogada;
    }

    // Looping de repetição caso o jogador forneça uma jogada inválida
    public static String validacaoJogada(String jogada){

        while (!jogada.equals("pedra") && !jogada.equals("papel") && !jogada.equals("tesoura")) {
            System.out.printf("Jogada inválida! Informe sua jogada: ");
            jogada = input.nextLine();
        }

        return jogada;
    }

    public static String jogadaMaquina(String[] opcoes){

        Random random = new Random();
        int jogadaMaquina = random.nextInt(opcoes.length); // Gera um número entre 0 e 2 (tamanho do array - 1)
        String maquina = opcoes[jogadaMaquina]; // Escolhe uma opção aleatória do array

        return maquina;
    }

    public static void vencedor(String jogada, String maquina){

        if(jogada.equals(maquina)){
            System.out.println("Empate");
        }
        else if(jogada.equals("pedra") && maquina.equals("tesoura") || jogada.equals("tesoura") && maquina.equals("papel") || jogada.equals("papel") && maquina.equals("pedra")){
            System.out.println("Você venceu!!");
        }
        else{
            System.out.println("Máquina venceu!");
        }
    }

    public static void main (String[] args){
        System.out.printf("=-=-=-JOGO DA VELHA-=-=-=\n");
        
        String[] opcoes = opcoes();
        String jogada = jogadaJogador();
        String novaJogada = validacaoJogada(jogada);
        String maquina = jogadaMaquina(opcoes);

        System.out.printf("Escolha jogador: %s\n", novaJogada);
        System.out.printf("Escolha máquina: %s\n", maquina);

        vencedor(novaJogada, maquina);

    }
}
