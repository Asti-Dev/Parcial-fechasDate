package com.selvamonos.hibernate.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.selvamonos.hibernate.dao.TuristaDao;
import com.selvamonos.hibernate.model.Turista;


@WebServlet("/")
public class TuristaServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private TuristaDao turistaDao;
	 
	 public void init() {
		 turistaDao = new TuristaDao();
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	 doGet(request, response);
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        String action = request.getServletPath();

			        try {
			            switch (action) {
			                case "/new":
			                    showNewForm(request, response);
			                    break;
			                case "/insert":
			                    insertTurista(request, response);
			                    break;
			                case "/delete":
			                    deleteTurista(request, response);
			                    break;
			                case "/edit":
			                    showEditForm(request, response);
			                    break;
			                case "/update":
			                    updateTurista(request, response);
			                    break;
			                default:
			                    listTurista(request, response);
			                    break;
			            }
			        } catch (SQLException ex) {
			            throw new ServletException(ex);
			        }
			    }
	 private void listTurista(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Turista > listTurista = turistaDao.getAllTurista();
			        request.setAttribute("listTurista", listTurista);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("turista-list.jsp");
			        dispatcher.forward(request, response);
			    }

			    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        RequestDispatcher dispatcher = request.getRequestDispatcher("turista-form.jsp");
			        dispatcher.forward(request, response);
			    }

			    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        Turista existingTurista = turistaDao.getTurista(id);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("turista-form.jsp");
			        request.setAttribute("turista", existingTurista);
			        dispatcher.forward(request, response);

			    }

			    private void insertTurista(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String nombre = request.getParameter("nombre");
			        String apellido = request.getParameter("apellido");
			        String docIdentidad = request.getParameter("docIdentidad");
			        
			        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			        Date fecNacimiento=null;
					try {
						fecNacimiento = dateFormat.parse(request.getParameter("fecNacimiento"));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			      
			        String pais = request.getParameter("pais");
			        String ciudadVisita = request.getParameter("ciudadVisita");
			        String nomHospedaje = request.getParameter("nomHospedaje");
			        Double costoTour = Double.parseDouble(request.getParameter("costoTour"));
			        String email = request.getParameter("email");
			        Date fecInicio=null;
					try {
						fecInicio = dateFormat.parse(request.getParameter("fecInicio"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        Date fecFinal=null;
					try {
						fecFinal = dateFormat.parse(request.getParameter("fecFinal"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        Turista newTurista = new Turista( nombre, apellido, docIdentidad, fecNacimiento, pais, ciudadVisita, nomHospedaje, costoTour, email, fecInicio, fecFinal);
			        turistaDao.saveTurista(newTurista);
			        response.sendRedirect("list");
			    }

			    private void updateTurista(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        String nombre = request.getParameter("nombre");
			        String apellido = request.getParameter("apellido");
			        String docIdentidad = request.getParameter("docIdentidad");
			        
			        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			        Date fecNacimiento=null;
					try {
						fecNacimiento = dateFormat.parse(request.getParameter("fecNacimiento"));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			      
			        String pais = request.getParameter("pais");
			        String ciudadVisita = request.getParameter("ciudadVisita");
			        String nomHospedaje = request.getParameter("nomHospedaje");
			        Double costoTour = Double.parseDouble(request.getParameter("costoTour"));
			        String email = request.getParameter("email");
			        Date fecInicio=null;
					try {
						fecInicio = dateFormat.parse(request.getParameter("fecInicio"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        Date fecFinal=null;
					try {
						fecFinal = dateFormat.parse(request.getParameter("fecFinal"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        Turista turista = new Turista( nombre, apellido, docIdentidad, fecNacimiento, pais, ciudadVisita, nomHospedaje, costoTour, email, fecInicio, fecFinal);
			        turistaDao.updateTurista(turista);
			        response.sendRedirect("list");
			    }

			    private void deleteTurista(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        turistaDao.deleteTurista(id);
			        response.sendRedirect("list");
			    }
	 
	 
}
