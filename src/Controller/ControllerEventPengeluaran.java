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
public class ControllerEventPengeluaran  extends MouseAdapter implements ActionListener {
    private ViewEventPengeluaran view;
    private Database db;
    
    public ControllerEventPengeluaran(){
       view = new ViewEventPengeluaran();
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
        view.setLblNamaEvent(ControllerEvent.namaEvent);
        
        int budget = db.getDataBudget(ControllerLogIn.username,view.getLblNamaEvent());
        view.setLblBudget(budget);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnBack())){
            view.dispose();
            new ControllerMenuEvent();
        }else if (source.equals(view.getBtnLogOut())){
            db.clearDataArray();
            view.dispose();
            new ControllerLogIn();
        } 
        else if (source.equals(view.getBtnSubmitPengeluaranE())){
                btnPengeluaranEActionPerformed();
        } 
    }
    private void btnPengeluaranEActionPerformed() {
            String username = view.getLblUsername();
            String nama = view.getTfNamaPengeluaran();
            String namaEvent = view.getLblNamaEvent();
            String tanggal = view.getLblTanggal();
            String jam = view.getLblJam();
            String kategori = view.getTfKategori();
            int besarPengeluaran = view.getTfBesarPengeluaran();
            int budgetLama = view.getLblBudget();
            int updateBudget = 0;
            int zero = 0;
            updateBudget = budgetLama - besarPengeluaran  ;
            String pengeluaran = "Pengeluaran";
            String no = Integer.toString(besarPengeluaran);
            if (besarPengeluaran > budgetLama){
                view.showMessage("Budget tidak Mencukupi", "Error", zero);
            }else{

                if (nama.isEmpty()){
                    view.showMessage("Anda Belum memasukkan Nama Pengeluaran", "Error", 0);
                }else if (no.isEmpty()){
                    view.showMessage("Anda Belum memasukkan Besar Pengeluaran", "Error", 0);
                }else{
                    db.masukHistoriEvent(username,pengeluaran, namaEvent,nama,kategori,  tanggal, jam,zero,besarPengeluaran,updateBudget);
                    db.masukDataPengeluaranEvent(username, namaEvent,nama,besarPengeluaran,kategori, tanggal, jam);
                    db.masukBudget(username, updateBudget,namaEvent);
                    view.showMessage("Saldo berhasil berkurang", "Success", 1);
                    view.dispose();
                    new ControllerMenuEvent();
                }
            }
            
    }
            
}
