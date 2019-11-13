/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import Model.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Saku Mahasiswa Team
 */
public class Database {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ArrayList<Pengguna> pengguna = new ArrayList<>();
    private ArrayList<Harian> harian = new ArrayList<>();
    private ArrayList<Event> event = new ArrayList<>();
    private ArrayList<HistoriHarian> historiharian = new ArrayList<>();
    private ArrayList<HistoriEvent> historievent = new ArrayList<>();
    
    public Database() {
        loadPengguna();
    }
    
    public void clearDataArray(){
        pengguna.clear();
        harian.clear();
        event.clear();
    }
    
    public void connect(){
        try {
            String url = "jdbc:mysql://localhost/db_sakumahasiswa";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException ex ) {
            JOptionPane.showConfirmDialog(null, "Belum ada Koneksi !\nSilahkan Aktifkan XAMPP\nLalu START Ulang");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void disconnect(){
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean manipulate(String query){
        boolean cek = false;
        try {
            int rows = stmt.executeUpdate(query);
            if (rows > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }
    
    public void loadPengguna() {
        connect();
        try {
            String query = "SELECT * FROM pengguna";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                pengguna.add(new Pengguna(rs.getString("username"), 
                    rs.getString("password"), 
                    rs.getString("nama"), 
                    rs.getString("tanggalLahir"), 
                    rs.getString("phoneNumber"), 
                    rs.getString("address"), 
                    rs.getInt("saldo"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public void loadHistoriHarian(String username) {
        connect();
        try {
            String query = "SELECT * FROM historiharian where username = '"+username+"';";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                historiharian.add(new HistoriHarian(rs.getString("username"), 
                    rs.getString("nama"), 
                    rs.getString("tanggal"), 
                    rs.getString("jam"), 
                    rs.getString("kategoriHarian"), 
                    rs.getString("kategoriPengeluaranH"),
                    rs.getInt("pemasukan"),
                    rs.getInt("pengeluaran"),
                    rs.getInt("sisaSaldo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public void loadHistoriEvent(String username,String namaEvent) {
        connect();
        try {
            String query = "SELECT * FROM historievent where namaEvent = '"+namaEvent+"' AND username ='"+username+"';";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                historievent.add(new HistoriEvent(rs.getString("username"), 
                    rs.getString("kategoriEvent"), 
                    rs.getString("namaEvent"), 
                    rs.getString("namaPemaPengEvent"), 
                    rs.getString("kategoriPengeluaranE"), 
                    rs.getString("tanggal"),
                    rs.getString("jam"),
                    rs.getInt("pemasukanEvent"),
                    rs.getInt("pengeluaranEvent"),
                    rs.getInt("sisaBudget")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }       
        disconnect();
    }
    
    public void loadEvent(String username) {
        connect();
        try {
            String query = "SELECT * FROM event";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                if(rs.getString("username").equals(username)){
                event.add(new Event(rs.getString("username"),  
                        rs.getString("namaEvent")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public ArrayList<Pengguna> getPengguna() {
        return pengguna;
    }
    
    public ArrayList<HistoriHarian> getHistoriHarian(){
        return historiharian;
    }
    
    public ArrayList<HistoriEvent> getHistoriEvent(){
        return historievent;
    }
    
    public ArrayList<Event> getEvent(){
        return event;
    }
    
    public void addPengguna(Pengguna p) {
        connect();
        String query = "INSERT INTO pengguna VALUES (";
            query += "'" + p.getUsername() + "',";
            query += "'" + p.getPassword() + "',";
            query += "'" + p.getNama() + "',";
            query += "'" + p.getTanggalLahir() + "',";
            query += "'" + p.getPhoneNumber() + "',";
            query += "'" + p.getAddress() + "',";
            query += "" + "0" + "";
            query += ")";
        if (manipulate(query)) pengguna.add(p);
        disconnect();
    }
     
    public boolean cekDuplikatUsername(String username){
        boolean cek = false;
        for (Pengguna pgn : pengguna) {
            if (pgn.getUsername().equals(username)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public boolean cekDuplikatNamaEvent(String username,String namaEvent){
        boolean cek = false;
        for (Event e : event) {
            if (e.getNamaEvent().equals(namaEvent) && e.getUsername().equals(username)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    public boolean cekDuplikatPassword(String username,String password){
        boolean cek = false;
        for (Pengguna pgn : pengguna) {
            if (pgn.getPassword().equals(password) && pgn.getUsername().equals(username)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public Pengguna getProfile(String username) {
        Pengguna p = new Pengguna();
        for (Pengguna pgn : pengguna) {
            if (pgn.getUsername().equals(username)){
                p = pgn;
                break;
            }
        }
        return p;
    }
    
    public void updatePengguna(Pengguna p) {
        connect();
        String query = "UPDATE pengguna SET";
        query += " username='" + p.getUsername() + "',";
        query += " nama='" + p.getNama() + "',";
        query += " tanggal lahir='" + p.getTanggalLahir() + "',";
        query += " nomor telepon='" + p.getPhoneNumber() + "',";
        query += " alamat='" + p.getAddress() + "',";
        query += " WHERE password='" + p.getPassword() + "';";
        if (manipulate(query)){
            for (Pengguna pgn : pengguna) {
                if (pgn.getPassword().equals(p.getPassword())){
                    pgn.setUsername(p.getUsername());
                    pgn.setNama(p.getNama());
                    pgn.setTanggalLahir(p.getTanggalLahir());
                    pgn.setPhoneNumber(p.getPhoneNumber());
                    pgn.setAddress(p.getAddress());
                    break;
                }
            }
        }
        disconnect();
    }
    
    public int getDataSaldo(String username){
        connect();
        int saldo = 0;
        try {
            String query = "SELECT saldo FROM pengguna where username='"+username+"';";
            rs = stmt.executeQuery(query);

            while (rs.next()){
                saldo = rs.getInt("saldo");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return saldo;
    }
    
    public int getDataBudget(String username, String namaEvent){
        connect();
        int budget = 0;
        try {
            String query = "SELECT budget FROM event where username='"+username+"' AND namaEvent = '"+namaEvent+"';";
            rs = stmt.executeQuery(query);

            while (rs.next()){
                budget = rs.getInt("budget");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return budget;
    }
    
    public void forgetPassword(String username){
        connect();
        String query = "UPDATE pengguna SET password = 'passwordBaru' WHERE username ='"+username+"';";
        manipulate(query);
        disconnect();
        
    }
    
    public void gantiPassword(String username,String pass) {
        connect();
        String query = "UPDATE pengguna SET password = '"+pass+"' WHERE username ='"+username+"';";
        manipulate(query);
        disconnect();
        
    }
    
    public void gantiProfile(String username,String nama,String tanggalLahir,String phoneNumber,String address) {
        connect();
        String query = "UPDATE pengguna SET "
                + "nama = '"+nama+"', "
                + "tanggalLahir ='"+tanggalLahir+"', "
                + "phoneNumber ='"+phoneNumber+"', "
                + "address = '"+address+"'"
                + " WHERE username ='"+username+"';";
        manipulate(query);
        disconnect();
    }
    public void masukEvent(String username, String namaEvent){
        connect();
        String query = "INSERT INTO event (username,namaEvent,budget) VALUES "
                + "('"
                + ""+username+"','"
                + ""+namaEvent+"',"
                + ""+0+""
                + ");";
        manipulate(query);
        disconnect();
    }
    
    //HARIAN
    public void masukSaldo(String username, int saldo){   
        connect();
        String query = "UPDATE pengguna SET saldo = "+saldo+" WHERE username ='"+username+"';";
        manipulate(query);
        disconnect();
    }
    

    public void masukDataPemasukanHarian(String username,String namaPemasukan,int besarPemasukan,String tanggal,String jam){
        connect();
        String query = "INSERT INTO pemasukanharian (username,namaPemasukan,besarPemasukan,tanggalPemasukan,jamPemasukan) VALUES "
                + "('"
                + ""+username+"','"
                + ""+namaPemasukan+" ','"
                + ""+besarPemasukan+"','"
                + ""+tanggal+"','"
                + ""+jam+"'"
                + ");";
        manipulate(query);
        disconnect();
    }

    public void masukDataPengeluaranHarian(String username,String namaPengeluaran,int besarPengeluaran,String tanggal,String jam,String kategori){
        connect();
        String query = "INSERT INTO pengeluaranharian (username,namaPengeluaran,besarPengeluaran,tanggalPengeluaran,jamPengeluaran,kategoriPengeluaranH) VALUES "
                + "('"
                + ""+username+"','"
                + ""+namaPengeluaran+"','"
                + ""+besarPengeluaran+"','"
                + ""+tanggal+"','"
                + ""+jam+"','"
                + ""+kategori+"'"
                + ");";
        manipulate(query);
        disconnect();

    }

    public void masukHistoriHarian(String username,String nama,String tanggal,String jam, String kategoriHarian,String kategoriPengeluaran,int pemasukan,int pengeluaran,int sisaSaldo){
        connect();
        String query = "INSERT INTO historiharian (username,nama,tanggal,jam,kategoriHarian,kategoriPengeluaranH,pemasukan,pengeluaran,sisaSaldo) VALUES "
                + "('"
                + ""+username+" ','"
                + ""+nama+"','"
                + ""+tanggal+"','"
                + ""+jam+"','"
                + ""+kategoriHarian+"','"
                + ""+kategoriPengeluaran+"','"
                + ""+pemasukan+"','"
                + ""+pengeluaran+"','"
                + ""+sisaSaldo+""
                + "');";
        manipulate(query);
        disconnect();
    }
    
    // EVENT
    public void masukBudget(String username, int budget,String namaEvent){   
        connect();
        String query = "UPDATE event SET budget = "+budget+" WHERE username ='"+username+"' AND namaEvent ='"+namaEvent+"';";
        manipulate(query);
        disconnect();
    }
    
    public void masukDataPemasukanEvent(String username,String namaEvent, String namaPemasukan,int budget,String tanggal,String jam){
        connect();
        String query = "INSERT INTO pemasukanevent (username,namaEvent,namaPemasukanEvent,budget,tanggalPemasukan, jamPemasukan) VALUES "
                + "('"
                + ""+username+"','"
                + ""+namaEvent+" ','"
                + ""+namaPemasukan+" ','"
                + ""+budget+"','"
                + ""+tanggal+"','"
                + ""+jam+"'"
                + ");";
        manipulate(query);
        disconnect();
    }

    public void masukDataPengeluaranEvent(String username,String namaEvent, String namaPengeluaran,int besar,String kategori,String tanggal,String jam){

        connect();
        String query = "INSERT INTO pengeluaranevent (username,namaEvent,namaPengeluaranEvent,besarPengeluaran,kategoriPengeluaranEvent,tglPengeluaranEvent,jamPengeluaran) VALUES "
                + "('"
                + ""+username+"','"
                 + ""+namaEvent+"','"
                + ""+namaPengeluaran+"','"
                + ""+besar+"','"
                + ""+kategori+"','"
                + ""+tanggal+"','"
                + ""+jam+"'"
                + ");";
        manipulate(query);
        disconnect();
        
    }
    
    public void masukHistoriEvent(String username, String kategoriEvent,String namaEvent,String nama,String kategoriPengeluaranEvent,String tanggal,String jam,int pemasukan,int pengeluaran,int sisaBudget){
        connect();
        String query = "INSERT INTO historievent (username,kategoriEvent,namaEvent,namaPemaPengEvent,kategoriPengeluaranE,tanggal,jam,pemasukanEvent,pengeluaranEvent,sisaBudget) VALUES "
                + "('"
                + ""+username+" ','"
                + ""+kategoriEvent+"','"
                + ""+namaEvent+"','"
                + ""+nama+"','"
                + ""+kategoriPengeluaranEvent+"','"
                + ""+tanggal+"','"
                + ""+jam+"',"
                + ""+pemasukan+","
                + ""+pengeluaran+","
                + ""+sisaBudget+""
                + ");";
       manipulate(query);        
        disconnect();
    }
        
    public void deleteNama( String username,String namaEvent){
        connect();
        String query = "DELETE FROM event WHERE namaEvent = '"+namaEvent+"' AND username ='"+username+"';";
        manipulate(query);
        disconnect();
    }
    public void deletePemasukanEvent(String username,String namaEvent){
        connect();
        String query = "DELETE FROM pemasukanevent WHERE namaEvent = '"+namaEvent+"' AND username ='"+username+"';";
        manipulate(query);
        disconnect();
    }
    public void deletePengeluaranEvent( String username,String namaEvent){
        connect();
        String query = "DELETE FROM pengeluaranevent WHERE namaEvent = '"+namaEvent+"' AND username ='"+username+"';";
        manipulate(query);
        disconnect();
    }
    
    public void deleteHistoriEvent( String username,String namaEvent){
        connect();
        String query = "DELETE FROM historievent WHERE namaEvent = '"+namaEvent+"' AND username ='"+username+"';";
        manipulate(query);
        disconnect();
    }
}
