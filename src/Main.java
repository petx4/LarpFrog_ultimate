import Armas.ListadeArmas;

void main() {
    SapoPrincipal sapo = new SapoPrincipal();

    sapo.setArmaAtual(ListadeArmas.lista.get(2));

    for (int i = 0; i < ListadeArmas.lista.size(); i++) {
        System.out.println((i + 1) + " - " + ListadeArmas.lista.get(i).getNome());
    }

    // 3. jogador escolhe e o sapo equipa
    int escolha = teclado.nextInt();
    sapo.setArmaAtual(ListadeArmas.lista.get(escolha - 1));
}

