import java.util.Random;
import java.util.Scanner;

class Personagem{
    String nomeClasse;
    int vida;
    int danoBase;

    public Personagem(String nomeClasse, int vida, int danoBase){
        this.nomeClasse = nomeClasse;
        this.vida = vida;
        this.danoBase = danoBase;
    }
    public int atacar(){
        Random rand = new Random();
        int minimo = danoBase - 5;
        int maximo = danoBase + 5;
        return rand.nextInt(maximo - minimo + 1) + minimo;
    }
}

public class RPG{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Bem vindo ao jogo medieval");
        System.out.println("Escolha a sua Classe");
        System.out.println("1- Guerreiro (vida: 100, Dano: 15 + 3)");
        System.out.println("2- Arqueiro (vida: 50, Dano: 15 + 3)");
        System.out.println("3- Mago (vida: 70, Dano: 15 + 7)");
        System.out.println("4- Assassino (vida: 60, Dano: 15 + 25)");
        System.out.println("5- Tanque (vida: 250, Dano: 15 - 5)");
        System.out.println("6- Bardo (vida: 10, Dano: 15 - 10)");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        Personagem jogador;
        switch (escolha){
            case 1:
                jogador = new Personagem("Guerreiro", 100, 15 + 3);
                break;
            case 2:
                jogador = new Personagem("Arqueiro", 50, 15 + 3);
                break;
            case 3:
                jogador = new Personagem("Mago", 70, 15 + 7);
                break;
            case 4:
                jogador = new Personagem("Assassino", 60, 15 + 25);
                break;
            case 5:
                jogador = new Personagem("Tanque", 250, 15 - 5);
                break;
            case 6:
                jogador = new Personagem("Bardo", 10, 15 - 10);
                break;
            default: 
                System.out.println("Escolha inválida");
                jogador = new Personagem("Bardo", 10, 15 - 10);
        }
    }
}