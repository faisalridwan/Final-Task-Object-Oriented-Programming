/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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

public class ControllerHistoriEvent extends MouseAdapter implements ActionListener{
    private ViewHistoriEvent view;
    private Database db;
    String username = ControllerLogIn.username;
    String namaEvent = ControllerEvent.namaEvent;
    public ControllerHistoriEvent(){
            view = new ViewHistoriEvent();
            view.addActionListener(this);
            db = new Database();
            view.setVisible(true);
            loadTable();
            view.setVisible(true); 
            db.loadHistoriEvent(username,namaEvent);
            view.setLblUsername(ControllerLogIn.username);
            view.setLblNamaEvent(ControllerEvent.namaEvent);
            loadTable();
            String username = view.getLblUsername();
    }
    
    public void loadTable(){
            DefaultTableModel model  = new DefaultTableModel(new String[]{"Kategori",
                "Judul",
                "Kategori Pengeluaran",
                "Pukul",
                "Tanggal",
                "Besar Pemasukan",
                "Besar Pengeluaran",
                "Sisa Budget"
            },0);
            ArrayList<HistoriEvent> he = db.getHistoriEvent();
            for (HistoriEvent e : he){
                model.addRow(new Object[]{e.getKategoriEvent(),e.getNamaPemaPeng(),
                    e.getKategoriPengeluaranE(),
                    e.getJam(),
                    e.getTanggal(),
                    e.getPemasukanEvent(),
                    e.getPengeluaranEvent(),
                    e.getSisaBudget()
                });
            }
            view.setTHistoriE(model);
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnBack())){
            view.dispose();
            new ControllerMenuEvent();
        }
    }
}
