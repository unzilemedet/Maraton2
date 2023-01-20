package com.bilgeadam.veritabani;

import java.sql.PreparedStatement;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

   
        //main.create(sirket);
        //main.read();
        //main.delete(3);
        //main.update(sirket);
        //main.readById(5);
   
    }

    DB db = new DB();
    List<Object> list = new ArrayList<>();
    Sirket sirket;
    public void create(Sirket sirket){
        String sql = "insert into sirket(sirketİsmi,sirketSahibi,unvan,faaliyetAlani,kurulusYili) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, sirket.getSirketİsmi());
            preparedStatement.setString(2, sirket.getSirketSahibi());
            preparedStatement.setString(3, sirket.getUnvan());
            preparedStatement.setString(4, sirket.getFaaliyetAlani());
            preparedStatement.setInt(5, sirket.getKurulusYili());
            preparedStatement.executeUpdate();
         
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void read(){
        try {
            String sql = "select * from sirket";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String sirketİsmi = rs.getString("sirketİsmi");
                String sirketSahibi = rs.getString("sirketSahibi");
                String unvan = rs.getString("unvan");
                String faaliyetAlani= rs.getString("faaliyetAlani");
                int kurulusYili = rs.getInt("faaliyetAlani");
         

                Sirket sirket = new Sirket(id, sirketİsmi, sirketSahibi, unvan,faaliyetAlani,kurulusYili);
                list.add(sirket);
            }
        list.forEach(System.out::println);
            
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    List<Object> ls = new ArrayList<>();
    Calisan calisan;
    public void create(Calisan calisan){
        String sql = "insert into calisan(int yas, int maas, String departman, int calısanId) values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, calisan.getYas());
            preparedStatement.setInt(2, calisan.getMaas());
            preparedStatement.setString(3, calisan.getDepartman());
            preparedStatement.setInt(4,calisan.getCalısanId());
        
           preparedStatement.executeUpdate();
         
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void read(){
        try {
            String sql = "select c.id,c.isim,c.yas,c.maas,c.departman,s.sirketİsmi,s.id as 'sirketId' from calisan asc\n"+
       " inner join sirket as s on c.sirketId=sid" ;
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String isim= rs.getString("isim");
               int yas = rs.getInt("yas");
                int maas = rs.getInt("maas");
                String departman= rs.getString("departman");
                int sirketId = rs.getInt("sirketİsmi");
         

              calisan = new Calisan(id, isim, yas, maas,departman,new Sirket(sirketId,sirketİsmi));
                list.add(calisan);
            }
        list.forEach(System.out::println);
            
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void delete(int id){
        try{
            String sql = "delete from calisan where id=?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            read();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void update(Calisan calisan){
        String sql = "update calisan set yas = ?, maas = ?, departman = ? where id = ?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, calisan.getYas());
            preparedStatement.setInt(2, calisan.getMaas());
            preparedStatement.setString(3, calisan.getDepartman());
            preparedStatement.setInt(4, calisan.getCalısanId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

            read();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


 
}
