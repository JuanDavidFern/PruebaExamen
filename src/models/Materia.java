package models;

import java.sql.Date;

public class Materia {
	private int id;
	private String nombre;
	private String acronimo;
	private Curso curso;
	private boolean aprobado;
	private Date fecha;
	private String contrasenia;

	public Materia() {
		super();
	}




	public Materia(int id, String nombre, String acronimo, Curso curso, boolean aprobado, Date fecha,
			String contrasenia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.curso = curso;
		this.aprobado = aprobado;
		this.fecha = fecha;
		this.contrasenia = contrasenia;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getAcronimo() {
		return acronimo;
	}




	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}




	public Curso getCurso() {
		return curso;
	}




	public void setCurso(Curso curso) {
		this.curso = curso;
	}




	public boolean isAprobado() {
		return aprobado;
	}




	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}




	public Date getFecha() {
		return fecha;
	}




	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}




	public String getContrasenia() {
		return contrasenia;
	}




	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}




	@Override
	public String toString() {
		return "Materia nombre=" + nombre + ", acronimo=" + acronimo + ", curso=" + curso
				+ ", aprobado=" + aprobado + ", fecha=" + fecha;
	}




	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.id == ((Materia)obj).id;
	}


}
