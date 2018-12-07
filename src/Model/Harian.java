package Model;

/**
 *
 * @author Saku Mahasiswa Team
 */
import java.util.*;

public class Harian {
    private Date tanggal;
    private List<Pemasukan> listPemasukan = new ArrayList<>();
    private List<Pengeluaran> listPengeluaran =  new ArrayList<>();

    public Harian(Date tanggal) {
        setTanggal(tanggal);
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public List<Pemasukan> getListPemasukan() {
        return listPemasukan;
    }

    public List<Pengeluaran> getListPengeluaran() {
        return listPengeluaran;
    }
    public void addPengeluaran(Kategori kategori, String nama, double saldo){
        Pengeluaran p = new Pengeluaran(kategori,  nama, saldo);
        listPengeluaran.add(p);
    }
    public void addPemasukan( String nama, double saldo){     
        Pemasukan p = new Pemasukan( nama, saldo);
        listPemasukan.add(p);
    }       
}
