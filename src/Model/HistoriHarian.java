/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MSI
 */
public class HistoriHarian {
    private String username;
    private String nama;
    private String tanggal;
    private String jam;
    private String kategoriHarian;
    private String kategoriPengeluaranH;
    private int pemasukan;
    private int pengeluaran;
    private int sisaSaldo;
    
    public HistoriHarian(String username, String nama, String tanggal, String jam, String kategoriHarian, String kategoriPengeluaranH, int pemasukan, int pengeluaran, int sisaSaldo){
        this.username = username;
        this.nama = nama;
        this.tanggal = tanggal;
        this.jam = jam;
        this.kategoriHarian = kategoriHarian;
        this.kategoriPengeluaranH = kategoriPengeluaranH;
        this.pemasukan = pemasukan;
        this.pengeluaran = pengeluaran;
        this.sisaSaldo = sisaSaldo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getKategoriHarian() {
        return kategoriHarian;
    }

    public void setKategoriHarian(String kategoriHarian) {
        this.kategoriHarian = kategoriHarian;
    }

    public String getKategoriPengeluaranH() {
        return kategoriPengeluaranH;
    }

    public void setKategoriPengeluaranH(String kategoriPengeluaranH) {
        this.kategoriPengeluaranH = kategoriPengeluaranH;
    }

    public int getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(int pemasukan) {
        this.pemasukan = pemasukan;
    }

    public int getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(int pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public int getSisaSaldo() {
        return sisaSaldo;
    }

    public void setSisaSaldo(int sisaSaldo) {
        this.sisaSaldo = sisaSaldo;
    }
    
}
