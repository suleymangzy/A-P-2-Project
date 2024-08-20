package com.example.avp2_proje;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "GorevSilServlet", value = "/gorevSil")
public class GorevSilServlet extends HttpServlet {
    private GorevVeri gorevVeri=new GorevVeri();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try{
            String id= request.getParameter("id");
            gorevVeri.gorevSil(Integer.parseInt(id));
            response.sendRedirect(request.getContextPath()+"/index");
        }catch (Exception ex){
            System.out.println("HATA"+ex);
            throw new RuntimeException();
        }
    }
    public void destroy() {
    }
}