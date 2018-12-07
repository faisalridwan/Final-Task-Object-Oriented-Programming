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

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.event.*;
import java.text.DateFormat;
import java.time.Duration;
import java.util.*;
import java.time.*;
import java.time.format.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Faisal Ridwan
 */
public class ControllerEventPemasukan extends MouseAdapter implements ActionListener {
    private ViewEventPemasukan view;
    private Database db;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    
    public ControllerEventPemasukan(){
       view = new ViewEventPemasukan();
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true); 
        
        int saldo = db.getDataSaldo(ControllerLogIn.username);
        view.setLblSaldo(saldo);
        
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
        }
        else if (source.equals(view.getBtnLogOut())){
            db.clearDataArray();
            view.dispose();
            new ControllerLogIn();
        } 
        else if (source.equals(view.getBtnSubmitPemasukanE())){
            //proses tambah budget
            btnPemasukanEActionPerformed();
        } 
        
    }

    
    public void btnPemasukanEActionPerformed(){
            
            String username = view.getLblUsername();
            String nama = view.getTfNamaEvent();
            String tanggal = view.getLblTanggal();
            String namaEvent = view.getLblNamaEvent();
            String jam = view.getLblJam();
            int besarBudget = view.getTfBesarBudget();
            int budgetLama = view.getLblBudget();
            int updateBudget = 0;
            int zero = 0;
            updateBudget = besarBudget + budgetLama;
            String kosong = "-";
            String pemasukan = "Pemasukan";
            String no = Integer.toString(besarBudget);
            
            if (nama.isEmpty()){
                view.showMessage("Anda Belum memasukkan Nama Event ", "Error", 0);
            }else if (no.isEmpty()){
                view.showMessage("Anda Belum memasukkan Besar Budget", "Error", 0);
            }else{
                db.masukHistoriEvent(username,pemasukan, namaEvent,nama,kosong,  tanggal, jam,besarBudget,zero,updateBudget);
                db.masukDataPemasukanEvent(username,namaEvent, nama, besarBudget, tanggal,jam);
                db.masukBudget(username, updateBudget,namaEvent);

                view.showMessage("Budget berhasil ditambah", "Success", 1);
                view.dispose();
                new ControllerMenuEvent();
            }
            
        }
}
