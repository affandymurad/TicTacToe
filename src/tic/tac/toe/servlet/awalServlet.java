package tic.tac.toe.servlet;

import tic.tac.toe.Morpion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="awalServlet")
public class awalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        prosesPermintaan(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        prosesPermintaan(request, response);
    }

    protected void prosesPermintaan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pemain = request.getParameter("Pemain");
        String ubin = request.getParameter("Ubin");
        boolean pemainPertama = pemain != null;

        Morpion morpion = (Morpion) request.getSession(true).getAttribute("morpionBean");
        morpion.setPemainAwal(pemainPertama, ubin);
        morpion.mulaiMain();

        request.getRequestDispatcher("/morpion.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Process initial form response.";
    }
}


