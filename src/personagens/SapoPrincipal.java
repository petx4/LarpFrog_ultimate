package personagens;

import Armas.Arma;

public class SapoPrincipal extends personagem {

    private Arma armaAtual;
    private int curasRestantes = 3;

    public SapoPrincipal(String nome, int vidaMax, int vida) {
        super(nome, vidaMax, vida);
    }

    public void setArmaAtual(Arma arma){
        this.armaAtual = arma;
    }

    public Arma getArmaAtual() {
        return armaAtual;
    }

    public int getCurasRestantes() {
        return curasRestantes;
    }
    public boolean usarCura() {
        if (curasRestantes <= 0) {
            return false;
        }
        curasRestantes--;
        curar(20);
        return true;
    }
}
