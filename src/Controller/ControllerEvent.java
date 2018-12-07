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
import javafx.scene.control.ComboBox;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Faisal Ridwan
 */
public class ControllerEvent extends MouseAdapter implements ActionListener {
    private ViewEvent view;
    private Database db;
    public static String namaEvent;
    
    public ControllerEvent(){
        view = new ViewEvent();
        db = new Database();
        db.loadEvent(ControllerLogIn.username);
        view.addMouseAdapter(this);
        view.addActionListener(this);
        view.setVisible(true); 
        loadTableNamaEvent();
        
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
            new ControllerHome();
        }else if(source.equals(view.getBtnLogOut())){
             db.clearDataArray();
            view.dispose();
            new ControllerLogIn();
        }else if(source.equals(view.getBtnDeleteEvent())){
            btnDeleteEventActionPerfomed();
        }else if(source.equals(view.getBtnAddEvent())){
            btnAddEventActionPerfomed();
        }else if(source.equals(view.getBtnUbah())){
            btnUbahEventActionPerfomed();
        }
    }
    
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        
        if (source.equals(view.getTbDaftarEvent())){
            int i = view.getDaftarEvent();
            
            String nama = view.getTbDaftarEvent().getModel().getValueAt(i, 0).toString(); 
            
            view.setTfUbahNama(nama);
        }
    }
    
    public void btnAddEventActionPerfomed(){
        String username = view.getLblUsername();
        String nama = view.getTfNamaEvent();
        if (nama.isEmpty()){
                view.showMessage("Anda Belum memasukkan Nama Event", "Error", 0);
        }else if(db.cekDuplikatNamaEvent(username,nama)){
                view.showMessage("Nama Event sudah ada", "Error", 0);
        }else{
            db.masukEvent(username, nama);
            loadTableNamaEvent();
            view.showMessage("Event berhasil dibuat", "Succes", 1);
            
            view.dispose();
           new ControllerEvent();
        }   
    }
    
    
    public void btnDeleteEventActionPerfomed(){
        String username = view.getLblUsername();
        String nama = view.getTfUbahNama();
        if (nama.isEmpty()){
                view.showMessage("Anda Belum memasukkan Nama Event", "Error", 0);
        }else if(db.cekDuplikatNamaEvent(username,nama)){
                db.deleteNama(username,nama);
                db.deletePemasukanEvent(username, nama);
                db.deletePengeluaranEvent(username, nama);
                db.deleteHistoriEvent(username, nama);
                view.showMessage("Delete Nama Event Benar", "Success", 1);
                view.dispose();
                new ControllerEvent();
        }else{
            view.showMessage("Nama Event Belum Terdaftar", "Error", 0);
            view.dispose();
            new ControllerEvent();
        }
    }
    
    public void btnUbahEventActionPerfomed(){
        String username = view.getLblUsername();
        String nama = view.getTfUbahNama();
        if (nama.isEmpty()){
            view.showMessage("Anda Belum memasukkan Nama Event", "Error", 0);
        }else if (db.cekDuplikatNamaEvent(username, nama)){
                namaEvent = nama;
                view.showMessage("Nama Event Benar", "Success", 1);
                view.dispose();
                new ControllerMenuEvent();
        }else{
            view.showMessage("Nama Event Belum Terdaftar", "Error", 0);
            view.dispose();
            new ControllerEvent();
        }
    }
    
    public void loadTableNamaEvent(){
        String username = view.getLblUsername();
        String nama = view.getTfNamaEvent();
        DefaultTableModel model = new DefaultTableModel(new String[]{" Daftar Nama Event yang Terdaftar"}, 0);
        ArrayList<Event> event = db.getEvent();
        for (Event e : event){
                model.addRow(new Object[]{e.getNamaEvent()});
            }
        view.setTbDaftarEvent(model);
    }
    
    
    
}
