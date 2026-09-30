import Armas.Arma;

class SapoPrincipal extends personagem{

    private Arma armaAtual;

    public SapoPrincipal(String nome, int vidaMax, int vida) {
        super(nome, vidaMax, vida);
    }

    public void setArmaAtual(Arma arma){
        this.armaAtual = arma;
    }

    public Arma getArmaAtual() {
        return armaAtual;
    }
}
