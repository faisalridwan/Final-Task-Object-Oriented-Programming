package Model;

/**
 *
 * @author Saku Mahasiswa Team
 */
import java.util.*;
public class Event{
    private String username;
    private Date tanggalMulai;
    private Date tanggalSelesai;
    private String namaEvent;
    private double budget;
    private boolean status;
    private List<Pemasukan> listPemasukan = new ArrayList<>();
    private List<Pengeluaran> listPengeluaran = new ArrayList<>();

    public Event(String username, Date tanggalMulai, Date tanggalSelesai, String namaEvent, double budget, boolean status) {
        setUsername(username);
        setTanggalMulai(tanggalMulai);
        setTanggalSelesai(tanggalSelesai);
        setNamaEvent(namaEvent);
        setBudget(budget);
        setStatus(status);
    }

    public Event(String username, Date tanggalMulai,String namaEvent, double budget) {
        setUsername(username);
        setTanggalMulai(tanggalMulai);
        setNamaEvent(namaEvent);
        setBudget(budget);
    }
    
    public Event(String username,String namaEvent){
        setUsername(username);
        setNamaEvent(namaEvent);
    }
    

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus(){
        return status;
    }

    public List<Pemasukan> getListPemasukan() {
        return listPemasukan;
    }

    public List<Pengeluaran> getListPengeluaran() {
        return listPengeluaran;
    }
    
    public void addPengeluaran(Kategori kategori, String username, double saldo){
        Pengeluaran p = new Pengeluaran(kategori, username, saldo);
        listPengeluaran.add(p);
    }
    public void addPemasukan(String username, double saldo){     
        Pemasukan p = new Pemasukan(username, saldo);
        listPemasukan.add(p);
    }
    
}
