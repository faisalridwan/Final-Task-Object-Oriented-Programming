package Controller;

import Database.Database;
import Model.*;
import View.ViewLogin;
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
public class ControllerLogIn extends MouseAdapter implements ActionListener {
    private ViewLogin view;
    private Database db;
    private Pengguna p;
    public static String username ;
        
    public ControllerLogIn(){
        view = new ViewLogin();
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true);
        
       }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        // Button Exit
        if (source.equals(view.getBtnExitLogin())) {
            System.exit(0);
        }
        // Button Log In
        else if (source.equals(view.getBtnLogIn())){
            btnLoginActionPerformed();
            
        }
        // Button Forget
        else if (source.equals(view.getBtnForget())){
                view.dispose();
                new ControllerForget();
        }
        // Button Sign In
        else if (source.equals(view.getBtnSignIn())){
                view.dispose();
                new ControllerSignIn();
                
        }
    }
    
    public void  btnLoginActionPerformed(){
       String username = view.getTfUsername();
        String password = view.getTfPassword();
        if (username.isEmpty() && password.isEmpty()){
            view.showMessage("Anda Belum memasukkan Username dan Password", "Error", 0);
        }else if (username.isEmpty() ){
                view.showMessage("Anda Belum memasukkan Username", "Error", 0);
        }else if ( password.isEmpty() ){
                view.showMessage("Anda Belum memasukkan Password", "Error", 0);
        }else{
            if (!db.cekDuplikatUsername(username)){
                view.showMessage("Username Salah atau Belum Terdaftar","Error", 0);
            }else{
                if(!db.cekDuplikatPassword(username,password)){
                view.showMessage("Password Salah atau Belum Terdaftar","Error", 0);
                }else {
                    ControllerLogIn.username = username;
                    view.dispose();
                    new ControllerHome();
                }
            }
        }  
    }  
}
