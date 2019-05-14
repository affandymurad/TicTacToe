package tic.tac.toe;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Morpion {
    private int UBIN;

    public enum Keadaan{
       HAMPA, X, O;
    }

    public enum Pemain{
        MANUSIA(Keadaan.X),
        KOMPUTER(Keadaan.O),
        KOSONG(Keadaan.HAMPA);

        private Keadaan keadaan;
        private Pemain(Keadaan keadaan){
            this.keadaan = keadaan;
        }
    }

    private boolean pemainPertama = true;
    private Keadaan[][] status;

    public Morpion() {}

    public List<Garis> getGarisUbin(){
        List<Garis> garises = new ArrayList<>();
        int indeks = 0;
        for (Keadaan[] data: this.status) {
            garises.add(new Garis(data, indeks));
            indeks++;
        }
        return garises;
    }

    public List<Sel> getStatusUbin(Garis garis){
        List<Sel> sels = new ArrayList<>();
        int indeks = 0;
        for (Keadaan keadaan: garis.getData()){
            sels.add(new Sel(keadaan, garis.getIndeks(), indeks));
            indeks++;
        }
        return sels;
    }

    public void setPemainAwal(boolean pemainPertama, String ubin) {
        UBIN = Integer.parseInt(ubin);
        this.pemainPertama = pemainPertama;
        this.status = new Keadaan[UBIN][UBIN];
    }

    public void mulaiMain(){
        for (int garis = 0; garis < UBIN; garis++) {
            for (int kolom = 0; kolom < UBIN; kolom++) {
                this.status[garis][kolom] = Keadaan.HAMPA;
            }
        }
        if (!this.pemainPertama) {
            this.giliran(Pemain.KOMPUTER, 1, 1);
        }
    }

    public void giliranManusia(int garis, int kolom) {
        this.giliran(Pemain.MANUSIA, garis, kolom);
    }

    public void giliranKomputer(){
        int garis = this.getAcakGarisKosong();
        int kolom = this.getAcakSelKosong(garis);
        this.giliran(Pemain.KOMPUTER, garis, kolom);
    }

    private void giliran(Pemain pemain, int garis, int kolom){
        if (this.status[garis][kolom] == Keadaan.HAMPA) {
            this.status[garis][kolom] = pemain.keadaan;
        }
    }

    private Pemain getPemain(Keadaan keadaan){
        for (Pemain pemain: Pemain.values()){
            if(pemain.keadaan.equals(keadaan)){
                return pemain;
            }
        }
        return null;
    }

    public Pemain getPemenang(){
    // menang secara baris
    for (int garis = 0; garis < UBIN; garis++){
        Keadaan keadaanGaris = this.status[garis][0];
        boolean menang = true;
        for (int kolom = 0; kolom < UBIN; kolom++) {
            if(!this.status[garis][kolom].equals(keadaanGaris)){
                menang = false;
                break;
            }
        }
        if (menang){
            return this.getPemain(keadaanGaris);
        }
    }

    //Menang secara kolom
    for (int kolom = 0; kolom < UBIN; kolom++){
        Keadaan keadaanKolom = this.status[0][kolom];
        boolean menang = true;
        for (int garis = 0; garis < UBIN; garis++){
            if (!this.status[garis][kolom].equals(keadaanKolom)){
                menang = false;
                break;
            }
        }
        if (menang){
            return this.getPemain(keadaanKolom);
        }
    }

    //menang secara diagonal
        Keadaan pDiagonal = this.status[0][0];
        Keadaan nDiagonal = this.status[0][UBIN - 1];
        boolean pMenang = true;
        boolean nMenang = true;
        for (int indeks = 0; indeks < UBIN; indeks++){
            if (!this.status[indeks][indeks].equals(pDiagonal)){
                pMenang = false;
            }
            if(!this.status[indeks][UBIN - 1 - indeks].equals(nDiagonal)){
                nMenang = false;
            }
        }
        if (pMenang){
            return this.getPemain(pDiagonal);
        } else if (nMenang){
            return this.getPemain(nDiagonal);
        } else {
            return Pemain.KOSONG;
        }
    }

    public boolean adaSelKosong(){
        for (int garis = 0; garis < UBIN; garis++) {
            for (int kolom = 0; kolom < UBIN; kolom++) {
                if (this.status[garis][kolom] == Keadaan.HAMPA) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final Random acak = new Random();

    private int getAcakGarisKosong() {
        if(!this.adaSelKosong()){
            return -1;
        }
        List<Integer> indekses = new ArrayList<>();
        int indeks = 0;
        for(Keadaan[] garis: this.status){
            boolean adaKosong = false;
            for (Keadaan sel: garis){
                if (sel == Keadaan.HAMPA){
                    adaKosong = true;
                    break;
                }
            }
            if (adaKosong){
                indekses.add(new Integer(indeks));
            }
            indeks++;
        }
        return indekses.get(acak.nextInt(indekses.size()));
    }

    private int getAcakSelKosong(int garis){
        if(!this.adaSelKosong()){
            return -1;
        }
        List<Integer> indekses = new ArrayList<>();
        int indeks = 0;
        for(Keadaan sel: this.status[garis]){
            if(sel == Keadaan.HAMPA){
                indekses.add(new Integer(indeks));
            }
            indeks++;
        }
        return indekses.get(acak.nextInt(indekses.size()));
    }


}
