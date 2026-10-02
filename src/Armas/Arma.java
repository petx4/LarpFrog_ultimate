package Armas;

public class Arma {
    private String nome;

    private int dano;
    private int danoMax;

    public Arma(String nome, int dano, int danoMax) {
        this.nome = nome;
        this.dano = dano;
        this.dano = danoMax;
    }

    public int atacar(){
return dano + (int)(Math.random()* (danoMax - dano + 1));

    }

    public String getNome() {
        return nome;
    }



}