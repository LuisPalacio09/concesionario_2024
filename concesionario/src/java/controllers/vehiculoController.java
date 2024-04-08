/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.crud.VehiculoJpaController;
import models.entities.Vehiculo;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "vehiculoController", urlPatterns = {"/vehiculo"})
public class vehiculoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        recuperarAccion(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void recuperarAccion(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String accion = request.getParameter("accion");
        switch (accion) {
            case "Guardar":
                agregarVehiculo(request, response);
                break;
            default:
                response.sendRedirect("error.jsp?msg=Accion incorrecta");
                break;
        }

    }

    private void agregarVehiculo(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Integer id_vehiculo = Integer.valueOf(request.getParameter("id"));
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        Integer cilindrada = Integer.valueOf(request.getParameter("cilindrada"));
        Float precio = Float.valueOf(request.getParameter("precio"));

        Vehiculo v = new Vehiculo();

        v.setIDVehiculo(id_vehiculo);
        v.setMarca(marca);
        v.setModelo(modelo);
        v.setCilindrada(cilindrada);
        v.setPrecio(precio);
        EntityManagerFactory conBD = Persistence.createEntityManagerFactory("concesionarioPU");
        VehiculoJpaController vehiculoCrud = new VehiculoJpaController(conBD);

        try {
            vehiculoCrud.create(v);
            response.sendRedirect(request.getContextPath() + "/vehiculo/guardar.jsp?msj=Prueba EXITOSA");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/vehiculo/guardar.jsp?msj=Prueba EXITOSA");

        }
    }

}
