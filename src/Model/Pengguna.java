package Model;

/**
 *
 * @author Saku Mahasiswa Team
 */

import java.util.*;
public class Pengguna {
    public String username;
    private String password;
    private String nama;
    private String tanggalLahir;
    private String phoneNumber;
    private String address;
    private double saldo;
    private double budget;
    private List<Harian> listHarian = new ArrayList<>();
    private List<Event> listEvent = new ArrayList<>();

    public Pengguna() {
    }

    
    public Pengguna(String username, String password, String nama, String tanggalLahir, String phoneNumber, String address, double saldo) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.saldo = saldo;
    }
    public Pengguna(String username, String password, String nama, String tanggalLahir, String phoneNumber, String address ) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.phoneNumber = phoneNumber;
        this.address = address;
        
    }

    public Pengguna(String username, String password, String nama, String tanggalLahir, String phoneNumber, String address, double saldo, double budget) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.saldo = saldo;
        this.budget = budget;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    } 
    
    public void setTanggalLahir(String tanggalLahir){
        this.tanggalLahir = tanggalLahir;
    }
    
    public String getTanggalLahir(){
        return tanggalLahir;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;        
    }

    public List<Harian> getListHarian() {
        return listHarian;
    }

    public List<Event> getListEvent() {
        return listEvent;
    }
    
    public void addHarian(Date tanggal) {
        Harian h = new Harian(tanggal);
        listHarian.add(h);
    }
    
    public void addEvent(String id, Date tanggalMulai, Date tanggalSelesai, String namaEvent, double budget, boolean status) {
        Event e = new Event(id, tanggalMulai, tanggalSelesai, namaEvent, budget, status);
        listEvent.add(e);  
    }
    
    public void addEvent(String id, Date tanggalMulai,String namaEvent, double budget){
        Event e =  new Event(id, tanggalMulai, namaEvent, budget);
        listEvent.add(e);
    }
}
    
    

