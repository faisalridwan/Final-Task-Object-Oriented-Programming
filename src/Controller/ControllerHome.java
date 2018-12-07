/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *4
 * @author Faisal Ridwan
 */
public class ControllerHome extends MouseAdapter implements ActionListener {
    private ViewHome view;
    private Database db;
    private ArrayList<Pengguna> p;
    
    public ControllerHome() {
        view = new ViewHome();
        db = new Database();
        
        Pengguna pengguna = new Pengguna();
        view.addActionListener(this);
        view.setVisible(true);
       
        view.setLblUsername(ControllerLogIn.username);
        int saldo = db.getDataSaldo(ControllerLogIn.username);
        view.setLblSaldo(saldo);
        
        pengguna = db.getProfile(ControllerLogIn.username);
        view.setTfGantiNama(pengguna.getNama());
        view.setTfGantiTanggalLahir(pengguna.getTanggalLahir());
        view.setTfGantiPhoneNumber(pengguna.getPhoneNumber());
        view.setTfGantiAddress(pengguna.getAddress());
        
        view.setTfUsernameProfile(ControllerLogIn.username);
        view.setTfUsernamePassword(ControllerLogIn.username);
        view.getTfGantiNama();   
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        // Button Harian
        if (source.equals(view.getBtnHarian())) {
            view.dispose();
            new ControllerMenuHarian();
        }
        // Button Event
        else if (source.equals(view.getBtnEvent())){
            view.dispose();
            new ControllerEvent();
        //Button Log out
        }else if (source.equals(view.getBtnLogOut())){
                db.clearDataArray();
                view.dispose();
                new ControllerLogIn();
        }else if (source.equals(view.getBtnGantiProfile())){
                btnGantiProfileActionPerformed();
                
                
            
        }else if (source.equals(view.getBtnGantiPass())){
               btnGantiPassActionPerformed(); 
            
        }
    
        
    }   
    
    public void btnGantiPassActionPerformed(){
        String username = view.getTfUsernamePassword();
        String passLama = view.getTfGantiPassLama();
        String passBaru = view.getTfGantiPassBaru();
        String passBaruKonfirmasi = view.getTfGantiPassKonfirmasi();

        if( !db.cekDuplikatPassword(username, passLama)){
            view.showMessage("Password Lama Salah", "Error", 0);
        }else if(!passBaru.equals(passBaruKonfirmasi)){
                view.showMessage("Password baru belum sama dengan konfirmasi", "Error", 0);
        }else{
            db.gantiPassword(username, passBaru);
            view.showMessage("Password berhasil di ganti", "Success", 1);
            view.dispose();
            new ControllerHome();
        }
    }
    
    public void btnGantiProfileActionPerformed(){
            String username = view.getTfUsernameProfile();
                String nama = view.getTfGantiNama();
                String tanggalLahir = view.getTfGantiTanggalLahir();
                String phoneNumber = view.getTfGantiPhoneNumber();
                String address = view.getTfGantiAddress();
                
                db.gantiProfile(username, nama,tanggalLahir,phoneNumber,address);
                view.showMessage("Profile berhasil di ganti", "Success", 1);
                view.dispose();
                new ControllerHome();
    }
}
