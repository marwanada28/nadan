package model;
import java.util.Scanner;

public abstract class Mahasiswa {
    protected String nim;
    protected String nama;
    protected int nilai;

    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }

    public abstract String getGrade();

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public int getNilai() {
        return nilai;
    }
}
