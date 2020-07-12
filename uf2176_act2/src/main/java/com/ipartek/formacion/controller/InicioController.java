package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.dao.impl.EmpleadoDAO;
import com.ipartek.formacion.modelo.pojo.Empleado;


/**
 * Servlet implementation class InicioController
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final EmpleadoDAO dao = EmpleadoDAO.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomb = request.getParameter("nombre");

		request.setAttribute("empleados", dao.listar(nomb));
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @param criterioBusqueda
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmpleadoDAO dao = EmpleadoDAO.getInstance();
		
		
		Empleado usu = new Empleado();



		try {
			
			String nomb = request.getParameter("nombre");
			String ape = request.getParameter("ape1");
			String apedos = request.getParameter("ape2");
			String cif = request.getParameter("cif");
			String depart = request.getParameter("dpt");
			int dpot= Integer.parseInt(depart);
			
			
			if ((nomb.length() >= 1 && nomb.length() <= 12) ) {

				
				usu.setNombre(nomb);
				usu.setApe1(ape);
				usu.setApe2(apedos);
				usu.setNif(cif);
				usu.setCodigodepartamento(dpot);
				
				
				dao.insertar(usu);

				
			}

		} catch (Exception e) {

			e.getMessage();
			e.printStackTrace();

		} finally {

			// enviar datos a la vista
		
			request.setAttribute("usu", usu);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} // finally

	}// doPost

	}
		
	
		

		
		


