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
 *
 * @author Faisal Ridwan
 */
public class ControllerForget extends MouseAdapter implements ActionListener {
    private ViewForget view;
    private Database db;
        
    public ControllerForget(){
        view = new ViewForget();
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true);
        
       }

    @Override
    public void actionPerformed(ActionEvent ae) {
                Object source = ae.getSource();
        // Button Exit
        if (source.equals(view.getBtnExit())) {
            System.exit(0);
            
        }else if (source.equals(view.getBtnSignIn())){
                view.dispose();
                new ControllerLogIn();
        }else if (source.equals(view.getBtnForget())){
            btnForgetActionPerformed();
        }
    }
    
    public void btnForgetActionPerformed(){
        String username = view.getTfUsernameForget();
            
        if (username.isEmpty()){
            view.showMessage("Anda Belum memasukkan Username ", "Error", 0);
        }else if (!db.cekDuplikatUsername(username)){
                view.showMessage("Username Salah atau Belum terdaftar", "Error", 0);
        }else{
            db.forgetPassword(username);
            view.showMessage("Password telah di ubah menjadi \n    password anda sekarang: passwordBaru", "Success", 1);
            view.dispose();
            new ControllerLogIn();
        } 
    }

}
