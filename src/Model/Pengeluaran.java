package Model;

/**
 *
 * @author Saku Mahasiswa Team
 */
public class Pengeluaran extends Transfer{
    private Kategori kategori;
    private String nama;
    private double saldo;
    
    public Pengeluaran(Kategori kategori,  String nama, double saldo) {
        super( nama, saldo);
        this.kategori = kategori;
    }

    public Kategori getKategori() {
        return kategori;
    }
}
