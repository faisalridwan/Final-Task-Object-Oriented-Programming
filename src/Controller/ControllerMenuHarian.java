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
import java.text.DateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Faisal Ridwan
 */
public class ControllerMenuHarian extends MouseAdapter implements ActionListener{
    private ViewMenuHarian view;
    private Database db;
    
    public ControllerMenuHarian(){
       view = new ViewMenuHarian();
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
            new ControllerHome();
        }else if (source.equals(view.getBtnHistori())){
            db.clearDataArray();
            view.dispose();
            new ControllerHistoriHarian();}
        else if (source.equals(view.getBtnLogOut())){
            db.clearDataArray();
            view.dispose();
            new ControllerLogIn();
        }else if(source.equals(view.getBtnPemasukanH())){
            view.dispose();
            new ControllerHarianPemasukan();
        }else if(source.equals(view.getBtnPengeluaranH())){
            view.dispose();
            new ControllerHarianPengeluaran();
        }
    }
}
