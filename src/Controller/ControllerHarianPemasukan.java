package Controller;

import Database.Database;
import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Faisal Ridwan
 */
public class ControllerHarianPemasukan extends MouseAdapter implements ActionListener {
    private ViewHarianPemasukan view;
    private Database db;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    
    public ControllerHarianPemasukan(){
       view = new ViewHarianPemasukan();
       Pengguna pengguna = new Pengguna();
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true); 
        int saldo = db.getDataSaldo(ControllerLogIn.username);
        view.setLblSaldo(saldo);
        Date date = new Date();
        view.setLblJam(timeFormat.format(date));
        view.setLblTanggal(dateFormat.format(date));
        view.setLblUsername(ControllerLogIn.username);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnBack())){
            view.dispose();
            new ControllerMenuHarian();
        }else if (source.equals(view.getBtnLogOut())){
            db.clearDataArray();
            view.dispose();
            new ControllerLogIn();
        } 
        else if (source.equals(view.getBtnSubmitPemasukanH())){
            //proses tambah budget
            btnPemasukanHActionPerformed();
            
        } 
    }
        public void btnPemasukanHActionPerformed(){
            
            String username = view.getLblUsername();
            String nama = view.getTfNamaPemasukan();
            String tanggal = view.getLblTanggal();
            String jam = view.getLblJam();
            int besarPemasukan = view.getTfBesarPemasukan();
            int saldoLama = view.getLblSaldo();
            int updateSaldo = 0;
            int zero = 0;
            String kosong = "-";
            String Pemasukan = "Pemasukan";
            updateSaldo = besarPemasukan + saldoLama;
            String no = Integer.toString(besarPemasukan);
            
            if (nama.isEmpty()){
                view.showMessage("Anda Belum memasukkan Nama Pemasukan", "Error", 0);
            }else if (no.isEmpty()){
                view.showMessage("Anda Belum memasukkan Besar Pemasukan", "Error", 0);
            }else{
                db.masukHistoriHarian(username, nama, tanggal, jam, Pemasukan,kosong, besarPemasukan,zero,updateSaldo);
                db.masukDataPemasukanHarian(username,nama,besarPemasukan,tanggal,jam);
                db.masukSaldo(username, updateSaldo);
                view.showMessage("Saldo berhasil ditambah", "Success", 1);
                view.dispose();
                new ControllerMenuHarian();
            }
            
        }
}
