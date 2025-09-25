import java.util.Random;
import java.util.Scanner;
class Personagem{
    String nomeClasse;
    int vida;
    int vidaMaxima;
    int danoBase;
    double taxaCritica = 0.15; // 15% de chance padrão

    public Personagem(String nomeClasse, int vida, int danoBase){
        this.nomeClasse = nomeClasse;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.danoBase = danoBase;
    }
    public int atacar(){
        Random rand = new Random();
        int minimo = Math.max(1, danoBase - 15); // RNG mais imprevisível
        int maximo = danoBase + 15;
        int dano = rand.nextInt(maximo - minimo + 1) + minimo;
        if (rand.nextDouble() < taxaCritica) {
            System.out.println("CRÍTICO!");
            dano = (int)(dano * 1.7);
        }
        return dano;
    }
    public void curar(int valor) {
        this.vida = Math.min(this.vida + valor, this.vidaMaxima);
    }
    public void aumentarVidaMaxima(int valor) {
        this.vidaMaxima += valor;
        this.vida = this.vidaMaxima;
    }
}
public class RPG{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int pocaoCura = 3;
        final int curaPorPocao = 30;
        Personagem jogador = null;
        while (true) {
            // Menu principal seguro
            String menuEscolha = "";
            while (true) {
                System.out.println("\n╔══════════════════════════════════════════════════════════╗");
                System.out.println("║                  RPG MEDIEVAL TERMINAL                   ║");
                System.out.println("╠══════════════════════════════════════════════════════════╣");
                System.out.println("║ 1 - Jogar                                                ║");
                System.out.println("║ 2 - Créditos                                             ║");
                System.out.println("║ 3 - Sair                                                 ║");
                System.out.println("╚══════════════════════════════════════════════════════════╝");
                System.out.print("Escolha uma opção: ");
                menuEscolha = scanner.nextLine();
                if (menuEscolha.equals("1") || menuEscolha.equals("2") || menuEscolha.equals("3")) {
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.\n");
                }
            }
            if (menuEscolha.equals("1")) {
                // Introdução única com delays
                try { Thread.sleep(700); } catch (InterruptedException e) { }
                System.out.println("\nUma lenda antiga ecoa pelo reino...");
                try { Thread.sleep(1200); } catch (InterruptedException e) { }
                System.out.println("Dizem que nas sombras das florestas, um mal desperta.");
                try { Thread.sleep(1200); } catch (InterruptedException e) { }
                System.out.println("Monstros ameaçam vilarejos e um dragão aterroriza a todos.");
                try { Thread.sleep(1200); } catch (InterruptedException e) { }
                System.out.println("A esperança repousa sobre os ombros de um novo herói...");
                try { Thread.sleep(1200); } catch (InterruptedException e) { }
                System.out.println("Será você capaz de restaurar a paz em Eldoria?\n");
                try { Thread.sleep(900); } catch (InterruptedException e) { }
                // Escolha de classe segura
                int escolha = 0;
                while (true) {
                    System.out.println("Em um momento de paz, um novo humano nasce.\nVocê deseja ser:");
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.println("║ Escolha a sua Classe:                                    ║");
                    System.out.println("║ 1- Guerreiro   (vida: 120, Dano: 18)                     ║");
                    System.out.println("║ 2- Arqueiro    (vida:  80, Dano: 20)                     ║");
                    System.out.println("║ 3- Mago        (vida:  70, Dano: 25)                     ║");
                    System.out.println("║ 4- Assassino   (vida:  50, Dano: 30)                     ║");
                    System.out.println("║ 5- Tanque      (vida: 200, Dano: 12)                     ║");
                    System.out.println("║ 6- Bardo       (vida:  40, Dano: 10)                     ║");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    System.out.print("Digite o número da classe desejada: ");
                    String entradaClasse = scanner.nextLine();
                    try {
                        escolha = Integer.parseInt(entradaClasse);
                    } catch (NumberFormatException e) {
                        System.out.println("Escolha inválida. Digite um número de 1 a 6.\n");
                        continue;
                    }
                    if (escolha >= 1 && escolha <= 6) {
                        break;
                    } else {
                        System.out.println("Escolha inválida. Digite um número de 1 a 6.\n");
                    }
                }
                switch (escolha){
                    case 1:
                        jogador = new Personagem("Guerreiro", 120, 18);
                        break;
                    case 2:
                        jogador = new Personagem("Arqueiro", 80, 20);
                        break;
                    case 3:
                        jogador = new Personagem("Mago", 70, 25);
                        break;
                    case 4:
                        jogador = new Personagem("Assassino", 50, 30);
                        break;
                    case 5:
                        jogador = new Personagem("Tanque", 200, 12);
                        break;
                    case 6:
                        jogador = new Personagem("Bardo", 40, 10);
                        break;
                    default:
                        System.out.println("Escolha inválida");
                        jogador = new Personagem("Bardo", 40, 10);
                }
                // Mini história e falas antes da primeira luta
                try { Thread.sleep(900); } catch (InterruptedException e) { }
                System.out.println("\nVocê acorda em uma clareira, o som de pássaros ecoa ao longe...");
                try { Thread.sleep(1200); } catch (InterruptedException e) { }
                System.out.println("╔════════════════════════════════════════════╗");
                System.out.println("║ Um velho camponês se aproxima:             ║");
                System.out.println("║    - Por favor, herói, monstros estão      ║");
                System.out.println("║      atacando nossa vila!                  ║");
                System.out.println("╚════════════════════════════════════════════╝");
                try { Thread.sleep(1500); } catch (InterruptedException e) { }
                System.out.println("— Você sente o peso da responsabilidade e parte em direção à floresta...");
                try { Thread.sleep(1200); } catch (InterruptedException e) { }
                System.out.println("— O vento sopra forte. Você ouve passos pesados entre as árvores...");
                try { Thread.sleep(1200); } catch (InterruptedException e) { }
                System.out.println("— Prepare-se! Um inimigo se aproxima!\n");
                try { Thread.sleep(1000); } catch (InterruptedException e) { }
                break;
            } else if (menuEscolha.equals("2")) {
                System.out.println("\n╔══════════════════════════════════════════════════════════╗");
                System.out.println("║ Créditos:                                                ║");
                System.out.println("║ Jogo criado por Kaique Lacerda                           ║");
                System.out.println("║ GitHub: Kaique-Lacerda                                   ║");
                System.out.println("╚══════════════════════════════════════════════════════════╝\n");
                System.out.println("Pressione ENTER para voltar ao menu...");
                scanner.nextLine();
            } else if (menuEscolha.equals("3")) {
                System.out.println("Saindo do jogo. Até logo!");
                System.exit(0);
            } else {
                System.out.println("Opção inválida. Tente novamente.\n");
            }
        }

        // Monstros agora serão sorteados aleatoriamente
        Personagem[] listaMonstros = {
            new Personagem("Goblin", 60, 12),
            new Personagem("Orc", 100, 18),
            new Personagem("Troll", 150, 22)
        };
        Personagem dragao = new Personagem("Dragão", 220, 30);
        int monstrosDerrotados = 0;
        int moedas = 0;
        int mercadorApareceu = 0;

        // Loop de batalhas aleatórias
        while (true) {
            if (monstrosDerrotados < 15) {
                int idx = rand.nextInt(listaMonstros.length);
                Personagem inimigo = new Personagem(listaMonstros[idx].nomeClasse, listaMonstros[idx].vida, listaMonstros[idx].danoBase);
                System.out.println("Um inimigo aparece: " + inimigo.nomeClasse + "!");
                try { Thread.sleep(1000); } catch (InterruptedException e) { }
                pocaoCura = 3;
                while (jogador.vida > 0 && inimigo.vida > 0){
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    String[] visual = inimigoVisual(inimigo.nomeClasse).split("\\n");
                    String[] info = {
                        "Monstro: " + inimigo.nomeClasse,
                        "",
                        "Sua vida: " + jogador.vida,
                        "Vida do monstro: " + inimigo.vida,
                        "Poções: " + pocaoCura,
                        "",
                        "Escolha sua ação:",
                        "1- Atacar",
                        "2- Fugir",
                        "3- Usar poção de cura",
                        "",
                        "Quest: Derrote 15 monstros",
                        "Progresso: " + monstrosDerrotados + "/15"
                    };
                    int infoWidth = 40;
                    int visualWidth = 21;
                    String border = "╔" + "═".repeat(infoWidth) + "╦" + "═".repeat(visualWidth) + "╗";
                    String borderBottom = "╚" + "═".repeat(infoWidth) + "╩" + "═".repeat(visualWidth) + "╝";
                    System.out.println(border);
                    int maxLines = Math.max(info.length, visual.length);
                    for (int i = 0; i < maxLines; i++) {
                        String infoLine;
                        if (i < info.length) {
                            if (info[i].isEmpty()) {
                                infoLine = "║" + " ".repeat(infoWidth);
                            } else {
                                infoLine = String.format("║%-" + infoWidth + "s", info[i].strip());
                            }
                        } else {
                            infoLine = "║" + " ".repeat(infoWidth);
                        }
                        String visualContent = i < visual.length ? visual[i] : "";
                        // Garante que o visual tenha sempre o mesmo comprimento
                        if (visualContent.length() < visualWidth) {
                            int padding = visualWidth - visualContent.length();
                            int padLeft = padding / 2;
                            int padRight = padding - padLeft;
                            visualContent = " ".repeat(padLeft) + visualContent + " ".repeat(padRight);
                        } else if (visualContent.length() > visualWidth) {
                            visualContent = visualContent.substring(0, visualWidth);
                        }
                        String visualLine = "║" + visualContent + "║";
                        System.out.println(infoLine + visualLine);
                    }
                    System.out.println(borderBottom);
                    // Substituir escolha de ação de batalha por:
                    String acaoStr = "";
                    int acao = 0;
                    while (true) {
                        System.out.print("Escolha sua ação: ");
                        acaoStr = scanner.nextLine();
                        try {
                            acao = Integer.parseInt(acaoStr);
                        } catch (NumberFormatException e) {
                            System.out.println("Opção inválida. Digite 1, 2 ou 3.\n");
                            continue;
                        }
                        if (acao >= 1 && acao <= 3) {
                            break;
                        } else {
                            System.out.println("Opção inválida. Digite 1, 2 ou 3.\n");
                        }
                    }
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
                    } else if (acao == 3){
                        if (pocaoCura > 0) {
                            jogador.curar(curaPorPocao);
                            pocaoCura--;
                            System.out.println("Você usou uma poção e recuperou " + curaPorPocao + " de vida!");
                        } else {
                            System.out.println("Você não tem mais poções!");
                        }
                    } else {
                        System.out.println("Ação inválida.");
                    }
                }
                if (jogador.vida <= 0){
                    System.out.println("Você foi derrotado.");
                    break;
                } else if (inimigo.vida <= 0){
                    monstrosDerrotados++;
                    // Sistema de moedas por dificuldade
                    int moedasGanhas = 0;
                    switch (inimigo.nomeClasse) {
                        case "Goblin":
                            moedasGanhas = rand.nextInt(3) + 1; // 1 a 3
                            break;
                        case "Orc":
                            moedasGanhas = rand.nextInt(4) + 3; // 3 a 6
                            break;
                        case "Troll":
                            moedasGanhas = rand.nextInt(5) + 6; // 6 a 10
                            break;
                        case "Dragão":
                            moedasGanhas = rand.nextInt(11) + 15; // 15 a 25
                            break;
                    }
                    moedas += moedasGanhas;
                    System.out.println("Você ganhou " + moedasGanhas + " moedas! Total: " + moedas);
                    // Chance crescente de mercador
                    int chanceMercador = Math.min(10 + (monstrosDerrotados - 1) * 3, 40); // começa em 10%, sobe 3% por monstro, máximo 40%
                    boolean mercadorForcado = false;
                    // Garante pelo menos 2 aparições
                    if (monstrosDerrotados >= 14 && mercadorApareceu < 2) {
                        mercadorForcado = true;
                    }
                    if (mercadorForcado || rand.nextInt(100) < chanceMercador) {
                        mercadorApareceu++;
                        System.out.println("\nUm mercador misterioso aparece!\n");
                        boolean mercadorAtivo = true;
                        while (mercadorAtivo) {
                            System.out.println("╔════════════════════════════════════════════╗");
                            System.out.println("║ Mercador: O que deseja, aventureiro?    ║");
                            System.out.println("║ 1 - Comprar poção (5 moedas)              ║");
                            System.out.println("║ 2 - Comprar espada melhor (15 moedas)     ║");
                            System.out.println("║ 3 - comprar Armadura (12 moedas)          ║");
                            System.out.println("║ 4 - Conversar                             ║");
                            System.out.println("║ 5 - Sair                                  ║");
                            System.out.println("╚════════════════════════════════════════════╝");
                            // Substituir escolha do mercador por:
                            String escolhaMercador = "";
                            while (true) {
                                System.out.print("Escolha: ");
                                escolhaMercador = scanner.nextLine();
                                if (escolhaMercador.matches("[1-5]")) {
                                    break;
                                } else {
                                    System.out.println("Opção inválida. Digite um número de 1 a 5.\n");
                                }
                            }
                            if (escolhaMercador.equals("1")) {
                                if (moedas >= 5) {
                                    moedas -= 5;
                                    pocaoCura++;
                                    System.out.println("Você comprou uma poção! Agora possui " + pocaoCura + " poções.");
                                } else {
                                    System.out.println("Você não tem moedas suficientes.");
                                }
                            } else if (escolhaMercador.equals("2")) {
                                if (moedas >= 15) {
                                    moedas -= 15;
                                    jogador.danoBase += 7;
                                    System.out.println("Seu dano base aumentou! Agora é " + jogador.danoBase + ".");
                                } else {
                                    System.out.println("Você não tem moedas suficientes.");
                                }
                            } else if (escolhaMercador.equals("3")) {
                                if (moedas >= 12) {
                                    moedas -= 12;
                                    jogador.aumentarVidaMaxima(25);
                                    System.out.println("Sua vida máxima aumentou! Agora é " + jogador.vidaMaxima + ". Vida atual: " + jogador.vida);
                                } else {
                                    System.out.println("Você não tem moedas suficientes.");
                                }
                            } else if (escolhaMercador.equals("4")) {
                                System.out.println("Mercador: 'Dizem que um velho sábio vaga por essas terras... Fique atento!'");
                            } else if (escolhaMercador.equals("5")) {
                                System.out.println("Você se despede do mercador.");
                                mercadorAtivo = false;
                            } else {
                                System.out.println("Opção inválida.");
                            }
                        }
                        try { Thread.sleep(1000); } catch (InterruptedException e) { }
                    }
                    // Chance de encontrar o Velho Sábio após derrotar um monstro
                    if (rand.nextInt(100) < 20) { // 20% de chance
                        System.out.println("\nVocê encontra um Velho Sábio pelo caminho!");
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║  Velho Sábio:                             ║");
                        System.out.println("║  - A sabedoria é a maior                  ║");
                        System.out.println("║    arma de um herói.                        ║");
                        System.out.println("╚════════════════════════════════════════════╝");
                        int bonus = rand.nextInt(2);
                        if (bonus == 0) {
                            jogador.curar(15);
                            System.out.println("O Velho Sábio cura 15 pontos de sua vida!");
                        } else {
                            pocaoCura++;
                            System.out.println("O Velho Sábio lhe entrega uma poção de cura!");
                        }
                        System.out.println("Você agradece e segue sua jornada.\n");
                        try { Thread.sleep(1200); } catch (InterruptedException e) { }
                    }
                }
            } else {
                System.out.println("O Dragão aparece! Prepare-se para a batalha final!");
                pocaoCura = 3;
                try { Thread.sleep(1000); } catch (InterruptedException e) { }
                Personagem inimigo = new Personagem(dragao.nomeClasse, dragao.vida, dragao.danoBase);
                while (jogador.vida > 0 && inimigo.vida > 0){
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    String[] visual = inimigoVisual(inimigo.nomeClasse).split("\\n");
                    String[] info = {
                        "Monstro: " + inimigo.nomeClasse,
                        "",
                        "Sua vida: " + jogador.vida,
                        "Vida do monstro: " + inimigo.vida,
                        "Poções: " + pocaoCura + "   (Batalha final)",
                        "",
                        "Escolha sua ação:",
                        "1- Atacar",
                        "2- Fugir",
                        "3- Usar poção de cura",
                        "",
                        "BATALHA FINAL!"
                    };
                    int infoWidth = 40;
                    int visualWidth = 21;
                    String border = "╔" + "═".repeat(infoWidth) + "╦" + "═".repeat(visualWidth) + "╗";
                    String borderBottom = "╚" + "═".repeat(infoWidth) + "╩" + "═".repeat(visualWidth) + "╝";
                    System.out.println(border);
                    int maxLines = Math.max(info.length, visual.length);
                    for (int i = 0; i < maxLines; i++) {
                        String infoLine;
                        if (i < info.length) {
                            if (info[i].isEmpty()) {
                                infoLine = "║" + " ".repeat(infoWidth);
                            } else {
                                infoLine = String.format("║%-" + infoWidth + "s", info[i].strip());
                            }
                        } else {
                            infoLine = "║" + " ".repeat(infoWidth);
                        }
                        String visualContent = i < visual.length ? visual[i] : "";
                        if (visualContent.length() < visualWidth) {
                            int padding = visualWidth - visualContent.length();
                            int padLeft = padding / 2;
                            int padRight = padding - padLeft;
                            visualContent = " ".repeat(padLeft) + visualContent + " ".repeat(padRight);
                        } else if (visualContent.length() > visualWidth) {
                            visualContent = visualContent.substring(0, visualWidth);
                        }
                        String visualLine = "║" + visualContent + "║";
                        System.out.println(infoLine + visualLine);
                    }
                    System.out.println(borderBottom);
                    int acao = scanner.nextInt();
                    scanner.nextLine();
                    if (acao == 1){
                        int danoCausado = jogador.atacar();
                        inimigo.vida -= danoCausado;
                        System.out.println("Você causou " + danoCausado + " de dano ao Dragão.");
                        if (inimigo.vida > 0){
                            int danoRecebido = inimigo.atacar();
                            jogador.vida -= danoRecebido;
                            System.out.println("O Dragão causou " + danoRecebido + " de dano a você.");
                        } else {
                            System.out.println("Você derrotou o Dragão!");
                            System.out.println("Parabéns! Você venceu o RPG Medieval!");
                            System.exit(0);
                        }
                    } else if (acao == 2){
                        System.out.println("Você não pode fugir da batalha final!");
                    } else if (acao == 3){
                        if (pocaoCura > 0) {
                            jogador.curar(curaPorPocao);
                            pocaoCura--;
                            System.out.println("Você usou uma poção e recuperou " + curaPorPocao + " de vida!");
                        } else {
                            System.out.println("Você não tem mais poções!");
                        }
                    } else {
                        System.out.println("Ação inválida.");
                    }
                }
                }
            }
    // Fim do método main

    // Função para retornar o visual do monstro
}

public static String inimigoVisual(String nome) {
        switch (nome) {
            case "Goblin":
                return "░░░░░░░░░░░░░░░░░░░░░\n"
                     + "░░░░░░░░░░░░░░░░░░░░░\n"
                     + "░░░░░░░░░░░░░░░░░░░░░\n"
                     + "███░░░░░░░░░░░░░░████\n"
                     + "█░░████░█████░█████░█\n"
                     + "░█░▒░░██░░░░░█░░▒▒░██\n"
                     + "░██▒▒▒░░░░░░░░▒▒▒▒█░░\n"
                     + "░░██▒▒▐██░▐██░░▒██░░░\n"
                     + "░░░░█░░▀▀░░▀▀░░░░█░░░\n"
                     + "░░░░█░░░░░░░░░░░░█░░░\n"
                     + "░░░░█░░█▄▄▄▄▄█░░░█░░░\n"
                     + "░░░░██░░▀░█░▀░░░█░░░░\n"
                     + "░░░░░██░░░░░░░██░░░░░\n"
                     + "░░░░░░████████░░░░░░░\n"
                     + "░░░░░░░░░░░░░░░░░░░░░\n"
                     + "░░░░░░░░░░░░░░░░░░░░░";
            case "Orc":
                return "██░░░░░░█████░░░░░███\n"
                     + "█░█░░███░░░░░███░░█░█\n"
                     + "█░░██░░░░░░░░░░░██░░█\n"
                     + "█░█░░░░░░░░░░░░░░░█░█\n"
                     + "░█░░███░░░░░░░███░░█░\n"
                     + "░█░░█░██░░░░░██░█░░█░\n"
                     + "█░░░██░██░░░██░██░░░█\n"
                     + "█░░░░░███░░░███░░░░░█\n"
                     + "█░░█░░░░░░░░░░░░░█░░█\n"
                     + "█░█░█░░░█░░█░░░░█░█░█\n"
                     + "░██░█░░░░░░░░░░░█░██░\n"
                     + "░██░░█░███████░█░░██░\n"
                     + "░░██░░█░█░█░█░█░░██░░\n"
                     + "░░████░█░█░█░█░████░░\n"
                     + "░░░░█████████████░░░░\n"
                     + "░░░░░░░░░░░░░░░░░░░░░";
            case "Troll":
                return "░██░░░░▒▒▒███░░░░░██░\n"
                     + "█░█░░██░░░░░░█░░░░█░█\n"
                     + "█░░██▒░░░░░░░░█░░░█░█\n"
                     + "█░░░▒░░░░░░░░░░███░░█\n"
                     + "██░░▒▒░░░░▒▒▒▒▒░░░░░█\n"
                     + "░█▒░▒▒▒▒▒▒▒░░░▒░░░░░█\n"
                     + "░██▒▒░░▒▒░░░░░░░░░██░\n"
                     + "░░███░░░░░░░░░░░░██░░\n"
                     + "░░░░█▒█░░█▒██░████░░░\n"
                     + "░░░░██░░░███░░░░██░░░\n"
                     + "░░░░█░░░░░░░░░░█░░░░░\n"
                     + "░░░██░░░░██░░░░█░░░░░\n"
                     + "░░██▒████▒█░░░█░░░░░░\n"
                     + "░░░█░░░░░░░░░█░░░░░░░\n"
                     + "░░░░█░░░░░░░█░░░░░░░░\n"
                     + "░░░░░███████░░░░░░░░░";
            case "Dragão":
                return "(visual do dragão)";
            default:
                return "";
        }
    }
}