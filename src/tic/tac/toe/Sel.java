package tic.tac.toe;

public class Sel {
    private Morpion.Keadaan keadaan;
    private int kolom;
    private int garis;

    public Sel(Morpion.Keadaan keadaan,int garis, int kolom) {
        this.keadaan = keadaan;
        this.kolom = kolom;
        this.garis = garis;
    }

    public Morpion.Keadaan getKeadaan() {
        return this.keadaan;
    }

    public int getKolom() {
        return this.kolom;
    }

    public int getGaris() {
        return this.garis;
    }
}
