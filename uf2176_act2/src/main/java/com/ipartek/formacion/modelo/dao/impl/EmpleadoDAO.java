package com.ipartek.formacion.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Departamento;
import com.ipartek.formacion.modelo.pojo.Empleado;

public class EmpleadoDAO {

	private static EmpleadoDAO INSTANCE;
	String SQLINSERTAR = "INSERT INTO empleado (nombre , apellidouno,apellidodos ,cif,codidodepartamento ) VALUES(?,?,?,?,?);";

	private EmpleadoDAO() {
		super();
	}

	public static synchronized EmpleadoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EmpleadoDAO();
		}
		return INSTANCE;
	}

	/**
	 * Listado de empleados
	 * 
	 * @param criterioBusqueda String busca coincidencias por nombre, apellido1,
	 *                         apellido2 o CIF, si pasamos null o "" no busca lista
	 *                         todos
	 * @return
	 */
	public ArrayList<Empleado> listar(String criterioBusqueda) {
		// TODO realizar criterio busqueda
		ArrayList<Empleado> resultado = new ArrayList<Empleado>();
		String sql = "SELECT \n" + "	e.codigoempleado 'empleado_codigo',\n" + "	e.nombre 'empleado_nombre',\n"
				+ "	e.apellidouno,\n" + "	e.apellidodos,\n" + "	e.cif ,\n" + "	d.codigo 'departamenteo_codigo',\n"
				+ "	d.nombre 'departamenteo_nombre',\n" + "	d.presupuesto ,\n" + "	d.gastos \n"
				+ "FROM empleado e LEFT JOIN departamento d ON d.codigo  = e.codidodepartamento \n"
				+ "ORDER BY e.nombre ASC LIMIT 500; ";

		String SQLINSERTAR = "INSERT INTO empleado (nombre , apellidouno,apellidodos ,cif,codidodepartamento ) VALUES(?,?,?,?,?);";

		String sqlNOMBRE = "SELECT CONCAT(e.nombre, e.apellidouno ,e.apellidodos ,e.cif ), \n"
				+ "							e.codigoempleado 'empleado_codigo',e.nombre 'empleado_nombre',	e.apellidouno,e.apellidodos, e.cif ,\n"
				+ "							d.codigo 'departamenteo_codigo', \n"
				+ "							d.nombre 'departamenteo_nombre',\n"
				+ "							d.presupuesto ,\n" + "							d.gastos \n"
				+ "						FROM empleado e LEFT JOIN departamento d ON d.codigo  = e.codidodepartamento  \n"
				+ "						WHERE CONCAT(e.nombre, e.apellidouno ,e.apellidodos ,e.cif )  LIKE '%"
				+ criterioBusqueda + "%' \n" + "						ORDER BY e.nombre ASC LIMIT 500; \n";

		{

			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pst = con.prepareStatement(sqlNOMBRE);
					ResultSet rs = pst.executeQuery();) {

				Empleado emp = null;
				Departamento dep = null;
				while (rs.next()) {

					emp = new Empleado();
					dep = new Departamento();

					emp.setCodigo(rs.getInt("empleado_codigo"));
					emp.setNombre(rs.getString("empleado_nombre"));
					emp.setApe1(rs.getString("apellidouno"));
					emp.setApe2(rs.getString("apellidodos"));
					emp.setNif(rs.getString("cif"));

					dep.setCodigo(rs.getInt("departamenteo_codigo"));
					dep.setNombre(rs.getString("departamenteo_nombre"));
					dep.setGasto(rs.getFloat("gastos"));
					dep.setPresupuesto(rs.getFloat("presupuesto"));

					emp.setDepartamento(dep);

					resultado.add(emp);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return resultado;
		}

	}///LISTAR FINAL

	public Empleado insertar(Empleado empl) throws Exception {
		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pst = con.prepareStatement(SQLINSERTAR,PreparedStatement.RETURN_GENERATED_KEYS);

		) {
			
			pst.setString(1, empl.getNombre());
			pst.setString(2, empl.getApe1());
			pst.setString(3, empl.getApe2());
			pst.setString(4, empl.getNif());
			pst.setInt(5, empl.getCodigodepartamento());
			
			int affectRows = pst.executeUpdate();
			if (affectRows == 1) {
				try (ResultSet rsKeys = pst.getGeneratedKeys()) {

					if (rsKeys.next()) {
						int id = rsKeys.getInt(1);
						empl.setCodigo(id);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return empl;

	}///INSERTAR FINAL

}
