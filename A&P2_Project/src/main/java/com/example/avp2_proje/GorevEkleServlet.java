package com.example.avp2_proje;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "GorevEkleServlet", value = "/gorevEkle")
public class GorevEkleServlet extends HttpServlet {
    private GorevVeri gorevVeri = new GorevVeri();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            String gorevAdi = request.getParameter("gorevAdi");
            String gorevAciklamasi = request.getParameter("gorevAciklamasi");
            String gelenBaslamaTarihi = request.getParameter("baslamaTarihi");
            String gelenBitisTarihi = request.getParameter("bitisTarihi");
            String onemi = request.getParameter("onemi");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate baslamaTarihi = LocalDate.parse(gelenBaslamaTarihi, formatter);
            LocalDate bitisTarihi = LocalDate.parse(gelenBitisTarihi, formatter);

            Gorev gorev = new Gorev(gorevAdi, gorevAciklamasi, Date.valueOf(baslamaTarihi), Date.valueOf(bitisTarihi), onemi);
            gorevVeri.gorevEkle(gorev);

            response.sendRedirect(request.getContextPath() + "/index");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void destroy() {
    }
}