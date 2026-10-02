import Armas.ListadeArmas;
import personagens.Inimigo;
import personagens.SapoPrincipal;

void main() {
    Scanner teclado = new Scanner(System.in);

    IO.println("                                Seja bem-vindo ao \n" +
            "        ======================= LarpFrog Ultimate =======================\n" +
            "         Onde você irá lutar contra os vandalistas que roubaram os livros \n" +
            "        que você queria ler para parar de larpar em casa só jogando. Mas,\n" +
            "        quando chega à biblioteca da sua cidade todos os livros foram roubados!\n" +
            "        Agora sua missão é recuperá-los para poder ler em paz o que quiser e salvar a\n" +
            "                            biblioteca da sua cidade.\n" +
            "        =========================== BOA SORTE ===========================");


    SapoPrincipal sapo = new SapoPrincipal("Sapo da chuva", 100, 100);

    for (int wave = 1; wave <= 5; wave++) {
        IO.println("\n=== Wave " + wave + " ===");
        Inimigo inimigo = new Inimigo("Vandalista " + wave, 30, 30);

        lutar(sapo, inimigo, 8, teclado);

        if (!sapo.estaVivo()) {
            IO.println("Você perdeu...");
            return;
        }

        IO.println("Você venceu a wave " + wave + "!");
        sapo.curar(20);
        IO.println("Pressione Enter para a próxima wave...");
        teclado.nextLine();
    }

    IO.println("\n=== BOSS ===");
    Inimigo boss = new Inimigo("Chefe dos Vandalistas", 150, 150);   // <- esta linha precisa existir

    lutar(sapo, boss, 15, teclado);

    if (sapo.estaVivo()) {
        IO.println("Você derrotou o boss e recuperou os livros!");
    } else {
        IO.println("O boss venceu...");
    }
}

void lutar(SapoPrincipal sapo, Inimigo inimigo, int danoInimigo, Scanner teclado) {
    while (sapo.estaVivo() && inimigo.estaVivo()) {
        IO.println("\nSua vida: " + sapo.getVida() + " | " + inimigo.getNome() + ": " + inimigo.getVida());
        IO.println("Escolha seu ataque:");
        for (int i = 0; i < ListadeArmas.lista.size(); i++) {
            IO.println((i + 1) + " - " + ListadeArmas.lista.get(i).getNome());
        }
        IO.println((ListadeArmas.lista.size() + 1) + " - Curar (" + sapo.getCurasRestantes() + " restantes)");

        int escolha = teclado.nextInt();
        teclado.nextLine();

        if (escolha < 1 || escolha > ListadeArmas.lista.size() + 1) {
            IO.println("Escolha inválida!");
            continue;
        }

        if (escolha == ListadeArmas.lista.size() + 1) {
            // opção de cura
            if (sapo.usarCura()) {
                IO.println("Você se curou! (vida: " + sapo.getVida() + ")");
            } else {
                IO.println("Você não tem mais curas!");
                continue; // não perde o turno
            }
        } else {
            // opção de ataque
            sapo.setArmaAtual(ListadeArmas.lista.get(escolha - 1));
            inimigo.RecebendoDano(sapo.getArmaAtual().atacar());
        }

        // turno do inimigo
        if (inimigo.estaVivo()) {
            sapo.RecebendoDano(danoInimigo);
        }
    }
}
