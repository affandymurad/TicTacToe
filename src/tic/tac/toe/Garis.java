package tic.tac.toe;

public class Garis {
    private int indeks;
    private Morpion.Keadaan[] data;

    public Garis(Morpion.Keadaan[] data, int indeks) {
        this.indeks = indeks;
        this.data = data;
    }

    public int getIndeks() {
        return this.indeks;
    }

    public Morpion.Keadaan[] getData() {
        return this.data;
    }
}

