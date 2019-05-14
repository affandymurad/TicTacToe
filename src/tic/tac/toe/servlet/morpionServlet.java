package tic.tac.toe.servlet;

import tic.tac.toe.Morpion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import tic.tac.toe.Morpion.Pemain;

@WebServlet(name = "morpionServlet")
public class morpionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        prosesPermintaan(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        prosesPermintaan(request, response);
    }

    protected void prosesPermintaan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Morpion morpion = (Morpion) request.getSession(true).getAttribute("morpionBean");

        int line = Integer.parseInt(request.getParameter("Garis"));
        int col = Integer.parseInt(request.getParameter("Kolom"));

        morpion.giliranManusia(line, col);

        Pemain winner = morpion.getPemenang();
        switch(winner){
            case KOSONG:
                if(morpion.adaSelKosong()){
                    morpion.giliranKomputer();
                    switch(morpion.getPemenang()){
                        case KOSONG:
                            break;
                        case KOMPUTER:
                            request.setAttribute("pemenang", "Komputer");
                            break;
                        case MANUSIA:
                            request.setAttribute("pemenang", "Saya");
                            break;
                    }
                }
                break;
            case KOMPUTER:
                request.setAttribute("pemenang", "Komputer");
                break;
            case MANUSIA:
                request.setAttribute("pemenang", "Saya");
                break;
        }
        if(winner == Pemain.KOSONG && !morpion.adaSelKosong()){
            request.setAttribute("pemenang", "Seri");
        }
        request.getRequestDispatcher("/morpion.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Process initial form response.";
    }
}
