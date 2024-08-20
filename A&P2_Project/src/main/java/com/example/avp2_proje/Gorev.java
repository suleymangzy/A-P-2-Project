package com.example.avp2_proje;

import java.util.Date;

public class Gorev {
    private int id;
    private String gorevAdi;
    private String gorevAciklamasi;
    private Date baslamaTarihi;
    private Date bitisTarihi;

    private String onemi;

    public Gorev(int id, String gorevAdi, String gorevAciklamasi, Date baslamaTarihi, Date bitisTarihi, String onemi) {
        this.id = id;
        this.gorevAdi = gorevAdi;
        this.gorevAciklamasi = gorevAciklamasi;
        this.baslamaTarihi = baslamaTarihi;
        this.bitisTarihi = bitisTarihi;
        this.onemi = onemi;
    }

    public Gorev(String gorevAdi, String gorevAciklamasi, Date baslamaTarihi, Date bitisTarihi, String onemi) {
        this.gorevAdi = gorevAdi;
        this.gorevAciklamasi = gorevAciklamasi;
        this.baslamaTarihi = baslamaTarihi;
        this.bitisTarihi = bitisTarihi;
        this.onemi = onemi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGorevAdi() {
        return gorevAdi;
    }



    public String getGorevAciklamasi() {
        return gorevAciklamasi;
    }



    public Date getBaslamaTarihi() {
        return baslamaTarihi;
    }



    public Date getBitisTarihi() {
        return bitisTarihi;
    }



    public String getOnemi() {
        return onemi;
    }


}
