/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ControllerLogIn.username;
import Database.Database;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.PrintGraphics;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MSI
 */
public class ControllerHistoriHarian extends MouseAdapter implements ActionListener {
    private ViewHistoriHarian view;
    private Database db;
    String username = ControllerLogIn.username;
    
    public ControllerHistoriHarian(){
        view = new ViewHistoriHarian(); 
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true); 
        db.loadHistoriHarian(username);
        view.setLblUsername(ControllerLogIn.username);
        loadTable();
        String username = view.getLblUsername();
            
            
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnBack())){
            view.dispose();
            new ControllerMenuHarian();
        }
    }
 
    public void loadTable(){
        DefaultTableModel model  = new DefaultTableModel(new String[]{"Kategori",
            "Nama",
            "Kategori Pengeluaran",
            "Pukul",
            "Tanggal",
            "Pemasukan",
            "Pengeluaran",
            "Sisa Saldo"
        },0);
        ArrayList<HistoriHarian> hh = db.getHistoriHarian();
        for (HistoriHarian h : hh){
                model.addRow(new Object[]{
                    h.getKategoriHarian(),
                    h.getNama(),
                    h.getKategoriPengeluaranH(),
                    h.getJam(), 
                    h.getTanggal(),
                    h.getPemasukan(),
                    h.getPengeluaran(),
                    h.getSisaSaldo()
                });   
        }
        view.setTHistoriH(model);
    }
}
