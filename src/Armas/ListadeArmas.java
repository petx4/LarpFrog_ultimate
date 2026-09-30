package Armas;

import java.util.ArrayList;

public class ListadeArmas {
    public static ArrayList <Arma> lista = new ArrayList<>();

    static {
        lista.add(new Arma("Lingua de veneno",10));
        lista.add(new Arma("Pulo duplo", 14));
        lista.add(new Arma("Bomba de hidrogenio bebê", 20));
        lista.add(new Arma("PreFire do newton", 9));
}}
