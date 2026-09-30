public abstract class personagem {

    private String Nome;
    private int VidaMax;
    private int vida;

    public personagem(String nome, int vidaMax, int vida) {
        Nome = nome;
        VidaMax = vidaMax;
        this.vida = vida;
    }

    public String getNome() {
        return Nome;
    }

    public int getVidaMax() {
        return VidaMax;
    }

    public int getVida() {
        return vida;
    }
    public void RecebendoDano(int dano){
        vida -= dano;
        if (vida < 0){
            vida = 0;
        }
        IO.println(" " + Nome + " perdeu " + dano + "de vida! (vida:" + vida + ")");
    }
    public void curar(int quantidade){
        vida = Math.min(VidaMax, vida + quantidade);
    }
public boolean estaVivo(){
        return vida > 0;
}
}
