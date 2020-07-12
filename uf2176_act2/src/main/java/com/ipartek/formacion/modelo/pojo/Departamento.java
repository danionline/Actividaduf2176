package com.ipartek.formacion.modelo.pojo;

public class Departamento {
	
	private int codigo;
	private String nombre;
	private float presupuesto;
	private float gasto;
	
	public Departamento() {
		super();
		this.codigo = 0;
		this.nombre = "";
		this.presupuesto = 0;
		this.gasto = 0;
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

	public float getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public float getGasto() {
		return gasto;
	}

	public void setGasto(float gasto) {
		this.gasto = gasto;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", gasto="
				+ gasto + "]";
	}

}
