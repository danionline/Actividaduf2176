package com.ipartek.formacion.modelo.pojo;

public class Empleado {
	
	private int codigo;
	private String nombre;
	private String nif;
	private String ape1;
	private String ape2;
	private int codigodepartamento;
	private Departamento departamento;
	
	public Empleado() {
		super();
		this.codigo = 0;
		this.nombre = "";
		this.ape1 = "";
		this.ape2 = "";
		this.codigodepartamento=0;
		this.departamento = new Departamento();
	}

	public int getCodigodepartamento() {
		return codigodepartamento;
	}

	public void setCodigodepartamento(int codigodepartamento) {
		this.codigodepartamento = codigodepartamento;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", nombre=" + nombre + ", nif=" + nif + ", ape1=" + ape1 + ", ape2="
				+ ape2 + ", departamento=" + departamento + "]";
	}
	

}
