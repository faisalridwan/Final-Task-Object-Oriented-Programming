package Model;

/**
 *
 * @author Saku Mahasiswa Team
 */
public class Transfer {
    
    private String nama;
    private double saldo;

    public Transfer( String nama, double saldo) {
        
        setNama(nama);
        this.saldo = saldo;
    }

    public String getNama() {
        return nama;
    }


    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getSaldo() {
        return saldo;
    }  
    
}
