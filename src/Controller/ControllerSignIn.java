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
public class ControllerSignIn extends MouseAdapter implements ActionListener {
    private ViewSignIn view;
    private Database db;
    
    public ControllerSignIn(){
        view = new ViewSignIn();
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
        if (source.equals(view.getBtnSignUp())){
            btnSignUpActionPerformed();
        }else if (source.equals(view.getBtnLogIn())){
                view.dispose();
                new ControllerLogIn();
        }
    }
    
    public void btnSignUpActionPerformed(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String username = view.getTfUsername();
        String password = view.getTfPassword();
        String ulangPassword = view.getTfUlangPassword();
        String nama = view.getTfNama();
        String tanggalLahir = dateFormat.format(view.getDateTanggalLahir());
        String phoneNumber = view.getTfPhoneNumber();
        String address = view.getTfAddress();
        
        if(username.isEmpty() || password.isEmpty() || nama.isEmpty() || 
                tanggalLahir.isEmpty() || phoneNumber.isEmpty() ||
                address.isEmpty()){
            view.showMessage("Semua Data Masih Kosong ", "Error", 0);
        }else if (username.isEmpty()){
                view.showMessage("Username Masih Kosong ", "Error", 0);
        }else if (password.isEmpty()){
                view.showMessage("Password Masih Kosong ", "Error", 0);
        }else if (tanggalLahir.isEmpty()){
                view.showMessage("Tanggal Lahir Masih Kosong ", "Error", 0);
        }else if (phoneNumber.isEmpty()){
                view.showMessage("Nomor Hp Masih Kosong ", "Error", 0);
        }else if (address.isEmpty()){
                view.showMessage("Alamat Masih Kosong ", "Error", 0);
        }else{
            if (db.cekDuplikatUsername(username)){
                view.showMessage("Username Sudah Terdaftar", "Error", 0); 
            }else if ( !ulangPassword.equals(password) ){
                    view.showMessage("Password belum sama", "Error", 0); 
            }else {
                db.addPengguna(new Pengguna(username,password,nama,tanggalLahir,phoneNumber,address));
                view.reset();
                view.showMessage("Username Terdaftar", "Success", 1);
                view.dispose();
                new ControllerLogIn(); 
            }
        }
    }
    
}

