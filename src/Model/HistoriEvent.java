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
public class HistoriEvent {
    String username;
    String kategoriEvent;
    String namaEvent;
    String namaPemaPeng;
    String kategoriPengeluaranE;
    String tanggal;
    String jam;
    int pemasukanEvent;
    int pengeluaranEvent;
    int sisaBudget;

    public HistoriEvent() {
    }

    public HistoriEvent(String username, String kategoriEvent, String namaEvent, String namaPemaPeng, String kategoriPengeluaranE, String tanggal, String jam, int pemasukanEvent, int pengeluaranEvent, int sisaBudget) {
        this.username = username;
        this.kategoriEvent = kategoriEvent;
        this.namaEvent = namaEvent;
        this.namaPemaPeng = namaPemaPeng;
        this.kategoriPengeluaranE = kategoriPengeluaranE;
        this.tanggal = tanggal;
        this.jam = jam;
        this.pemasukanEvent = pemasukanEvent;
        this.pengeluaranEvent = pengeluaranEvent;
        this.sisaBudget = sisaBudget;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamaPemaPeng() {
        return namaPemaPeng;
    }

    public void setNamaPemaPeng(String namaPemaPeng) {
        this.namaPemaPeng = namaPemaPeng;
    }

    public String getKategoriEvent() {
        return kategoriEvent;
    }

    public void setKategoriEvent(String kategoriEvent) {
        this.kategoriEvent = kategoriEvent;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    public String getKategoriPengeluaranE() {
        return kategoriPengeluaranE;
    }

    public void setKategoriPengeluaranE(String kategoriPengeluaranE) {
        this.kategoriPengeluaranE = kategoriPengeluaranE;
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

    public int getPemasukanEvent() {
        return pemasukanEvent;
    }

    public void setPemasukanEvent(int pemasukanEvent) {
        this.pemasukanEvent = pemasukanEvent;
    }

    public int getPengeluaranEvent() {
        return pengeluaranEvent;
    }

    public void setPengeluaranEvent(int pengeluaranEvent) {
        this.pengeluaranEvent = pengeluaranEvent;
    }

    public int getSisaBudget() {
        return sisaBudget;
    }

    public void setSisaBudget(int sisaBudget) {
        this.sisaBudget = sisaBudget;
    }
    
}
