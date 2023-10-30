package com.java.easybank_v4.controllers;

import com.java.easybank_v4.Entities.Agence;
import com.java.easybank_v4.Entities.Client;
import com.java.easybank_v4.Entities.DemanderCredit;
import com.java.easybank_v4.Entities.Simulation;
import com.java.easybank_v4.dao.Interfaces.DemandeI;
import com.java.easybank_v4.dao.implementation.DemandeDao;
import com.java.easybank_v4.services.DemandeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "demande", urlPatterns ={"/demande_test"} )
public class DemanderCreditServlet extends HttpServlet {
    private DemandeI demandeDao=new DemandeDao();
    private DemandeService demandeService= new DemandeService(demandeDao);
    double mensualite;
    @Override
    public void init() throws ServletException {
        DemanderCredit demande=new DemanderCredit();
        Simulation simulation= new Simulation();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String message="demande page";
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>"+ mensualite);
        out.println("</body></html>");
    }


}
