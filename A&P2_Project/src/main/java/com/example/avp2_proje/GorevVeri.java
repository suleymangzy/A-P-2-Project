package com.example.avp2_proje;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GorevVeri {

    public List<Gorev>gorevleriGetir(){
        List<Gorev>gorrevler=new ArrayList<>();

        Connection baglanti= null;
        Statement ifade= null;
        ResultSet sonuc= null;

        try {
            baglanti= VeritabaniBaglanti.veritabaniBaslat();
            String sql ="SELECT * FROM gorev";
            ifade=baglanti.prepareStatement(sql);
            sonuc=ifade.executeQuery(sql);

            while (sonuc.next()){
                int id=sonuc.getInt("id");
                String gorevAdi= sonuc.getString("gorevAdi");
                String gorevAciklamasi= sonuc.getString("gorevAciklamasi");
                Date baslamaTarihi= sonuc.getDate("baslamaTarihi");
                Date bitisTarihi= sonuc.getDate("bitisTarihi");
                String onemi =sonuc.getString("onemi");

                Gorev gor1= new Gorev(id,gorevAdi,gorevAciklamasi,baslamaTarihi,bitisTarihi,onemi);
                gorrevler.add(gor1);
            }
            return  gorrevler;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            kapat(baglanti,ifade,sonuc);
        }
    }
    public void kapat(Connection baglanti,Statement ifade,ResultSet sonuc){
        if (sonuc!=null){
            try {
                sonuc.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }if (ifade!=null){
            try {
                ifade.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }if (baglanti!=null){
            try {
                baglanti.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void gorevEkle(Gorev gorev1){
        Connection baglanti=null;
        PreparedStatement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="INSERT INTO gorev (gorevAdi,gorevAciklamasi,baslamaTarihi,bitisTarihi,onemi) VALUES(?,?,?,?,?)";
            ifade=baglanti.prepareStatement(sql);
            ifade.setString(1, gorev1.getGorevAdi());
            ifade.setString(2,gorev1.getGorevAciklamasi());
            ifade.setDate(3, (Date) gorev1.getBaslamaTarihi());
            ifade.setDate(4, (Date) gorev1.getBitisTarihi());
            ifade.setString(5,gorev1.getOnemi());
            ifade.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void gorevSil(int id) {
        Connection baglanti = null;
        PreparedStatement ifade = null;
        ResultSet sonuc = null;


        try {
            baglanti = VeritabaniBaglanti.veritabaniBaslat();
            String sql = "DELETE FROM gorev WHERE id=?";
            ifade = baglanti.prepareStatement(sql);
            ifade.setInt(1, id);
            ifade.execute();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
