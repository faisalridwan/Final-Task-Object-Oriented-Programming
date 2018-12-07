package Controller;

import Database.Database;
import Model.*;
import View.*;
import java.awt.HeadlessException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Faisal Ridwan
 */
public class ControllerHarianPengeluaran extends MouseAdapter implements ActionListener  {
        private ViewHarianPengeluaran view;
    private Database db;
    
    public ControllerHarianPengeluaran(){
       view = new ViewHarianPengeluaran();
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true); 
        
        int saldo = db.getDataSaldo(ControllerLogIn.username);
        view.setLblSaldo(saldo);
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        
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
        else if (source.equals(view.getBtnSubmitPengeluaranH())){
            //proses tambah budget
            btnPengeluaranHActionPerformed();
        }
    }
    public void btnPengeluaranHActionPerformed(){
            
        String username = view.getLblUsername();
        String nama = view.getTfNamaPengeluaran();
        String tanggal = view.getLblTanggal();
        String jam = view.getLblJam();
        String kategori = view.getTfKategori();
        int besarPengeluaran = view.getTfBesarPengeluaran();
        int saldoLama = view.getLblSaldo();
        int updateSaldo = 0;
        int zero = 0;
        String Pemasukan = "Pengeluaran";
        updateSaldo =  saldoLama - besarPengeluaran ;
        String no = Integer.toString(besarPengeluaran);
        if (besarPengeluaran > saldoLama){
                view.showMessage("Budget tidak Mencukupi", "Error", zero);
        }else{
            if (nama.isEmpty()){
                view.showMessage("Anda Belum memasukkan Nama Pengeluaran ", "Error", 0);
            }else if (no.isEmpty()){
                    view.showMessage("Anda Belum memasukkan Besar Pengeluaran", "Error", 0);
            }else{
                db.masukDataPengeluaranHarian(username, nama, updateSaldo, tanggal, jam, kategori);
                db.masukHistoriHarian(username, nama, tanggal, jam, Pemasukan,kategori, zero,besarPengeluaran,updateSaldo);
                db.masukSaldo(username, updateSaldo);
                view.showMessage("Saldo berhasil berkurang", "Success", 1);
                view.dispose();
                new ControllerMenuHarian();
            }
        } 
        }
}
