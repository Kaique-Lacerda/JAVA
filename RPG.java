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
        System.out.println("5- Tanque (vida: 250, Dano: 15 + 5000)");
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
                jogador = new Personagem("Tanque", 250, 15 + 5000);
                break;
            case 6:
                jogador = new Personagem("Bardo", 10, 15 - 10);
                break;
            default: 
                System.out.println("Escolha inválida");
                jogador = new Personagem("Bardo", 10, 15 - 10);
        }

        Personagem inimigo = new Personagem("Goblin", 100, 15 + 1);
        Personagem inimigo2 = new Personagem("Orc", 150, 15 + 3);
        Personagem inimigo3 = new Personagem("Troll", 200, 15 + 5);
        Personagem inimigo4 = new Personagem("Dragão", 300, 15 + 10);

        while (jogador.vida > 0 && inimigo.vida > 0){
            System.out.println("Sua vida: " + jogador.vida);
            System.out.println("Vida do inimigo: " + inimigo.vida);
            System.out.println("Escolha sua ação:");
            System.out.println("1- Atacar");
            System.out.println("2- Fugir");

            int acao = scanner.nextInt();
            scanner.nextLine();
            if (acao == 1){
                int danoCausado = jogador.atacar();
                inimigo.vida -= danoCausado;
                System.out.println("Você causou " + danoCausado + " de dano ao inimigo.");

                if (inimigo.vida > 0){
                    int danoRecebido = inimigo.atacar();
                    jogador.vida -= danoRecebido;
                    System.out.println("O inimigo causou " + danoRecebido + " de dano a você.");
                } else {
                    System.out.println("Você derrotou o inimigo!");
                }
            } else if (acao == 2){
                System.out.println("Você fugiu da batalha.");
                break;
            } else {
                System.out.println("Ação inválida.");
            }
        }
        if (jogador.vida <= 0){
            System.out.println("Você foi derrotado.");
        } else if (inimigo.vida <= 0){
            System.out.println("Você venceu a batalha!");
            System.out.println("Um novo inimigo aparece: Orc!");
            inimigo = inimigo2;
            while (jogador.vida > 0 && inimigo.vida > 0){
                System.out.println("Sua vida: " + jogador.vida);
                System.out.println("Vida do inimigo: " + inimigo.vida);
                System.out.println("Escolha sua ação:");
                System.out.println("1- Atacar");
                System.out.println("2- Fugir");
                int acao = scanner.nextInt();
                scanner.nextLine();
                if (acao == 1){
                    int danoCausado = jogador.atacar();
                    inimigo.vida -= danoCausado;
                    System.out.println("Você causou " + danoCausado + " de dano ao inimigo.");  
                    if (inimigo.vida > 0){
                        int danoRecebido = inimigo.atacar();
                        jogador.vida -= danoRecebido;
                        System.out.println("O inimigo causou " + danoRecebido + " de dano a você.");
                    } else {
                        System.out.println("Você derrotou o inimigo!");
                    }
                } else if (acao == 2){
                    System.out.println("Você fugiu da batalha.");
                    break;
                } else {
                    System.out.println("Ação inválida.");
                }
            }
            if (jogador.vida <= 0){
                System.out.println("Você foi derrotado.");
            } else if (inimigo.vida <= 0){
                System.out.println("Você venceu a batalha!");
                System.out.println("Um novo inimigo aparece: Troll!");
                inimigo = inimigo3;
                while (jogador.vida > 0 && inimigo.vida > 0){
                    System.out.println("Sua vida: " + jogador.vida);
                    System.out.println("Vida do inimigo: " + inimigo.vida);
                    System.out.println("Escolha sua ação:");
                    System.out.println("1- Atacar");
                    System.out.println("2- Fugir");
                    int acao = scanner.nextInt();
                    scanner.nextLine();
                    if (acao == 1){
                        int danoCausado = jogador.atacar();
                        inimigo.vida -= danoCausado;
                        System.out.println("Você causou " + danoCausado + " de dano ao inimigo.");  
                        if (inimigo.vida > 0){
                            int danoRecebido = inimigo.atacar();
                            jogador.vida -= danoRecebido;
                            System.out.println("O inimigo causou " + danoRecebido + " de dano a você.");
                        } else {
                            System.out.println("Você derrotou o inimigo!");
                        }
                    } else if (acao == 2){
                        System.out.println("Você fugiu da batalha.");
                        break;
                    } else {
                        System.out.println("Ação inválida.");
                    }
                }
                if (jogador.vida <= 0){
                    System.out.println("Você foi derrotado.");
                } else if (inimigo.vida <= 0){
                    System.out.println("Você venceu a batalha!");
                    System.out.println("Um novo inimigo aparece: Dragão!");
                    inimigo = inimigo4;
                    while (jogador.vida > 0 && inimigo.vida > 0){
                        System.out.println("Sua vida: " + jogador.vida);
                        System.out.println("Vida do inimigo: " + inimigo.vida);
                        System.out.println("Escolha sua ação:");
                        System.out.println("1- Atacar");
                        System.out.println("2- Fugir");
                        int acao = scanner.nextInt();
                        scanner.nextLine();
                        if (acao == 1){
                            int danoCausado = jogador.atacar();
                            inimigo.vida -= danoCausado;
                            System.out.println("Você causou " + danoCausado + " de dano ao inimigo.");  
                            if (inimigo.vida > 0){
                                int danoRecebido = inimigo.atacar();
                                jogador.vida -= danoRecebido;
                                System.out.println("O inimigo causou " + danoRecebido + " de dano a você.");
                            } else {
                                System.out.println("Você derrotou o inimigo!");
                            }
                        }
                        else if (acao == 2){
                            System.out.println("Você fugiu da batalha.");
                            break;
                        } else {
                            System.out.println("Ação inválida.");
                        }
                    }
                    if (jogador.vida <= 0){
                        System.out.println("Você foi derrotado.");
                    } else if (inimigo.vida <= 0){
                        System.out.println("Você venceu a batalha final! Parabéns!");
                    }
                }
            }
        }
    }
}