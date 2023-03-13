package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Curso;
import models.Materia;


public class ControladorMateria {
	private static Connection conn = null;
	
	
	public static List<Materia> cargarMaterias(int id) {
		List<Materia> lc = new ArrayList<Materia>();
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.materia where curso_id = " + id);
			ResultSet rs = ps.executeQuery();
			Materia m = null;
			while (rs.next()) {
				m = new Materia();
				m.setId(rs.getInt(1));
				m.setNombre(rs.getString(2));
				m.setAcronimo(rs.getString(3));
				Curso c = new Curso(); 
				c.setId(rs.getInt(4));
				m.setCurso(c);
				m.setAprobado(rs.getBoolean("aprobado"));
				m.setFecha(rs.getDate("fecha"));
				m.setContrasenia(rs.getString("contrasenia"));
				lc.add(m);

				
			}
			rs.close();
			ps.close();
			conn.close();
			return lc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

	public static Materia guardar(Materia mat) {
		try {

			if (mat.getId() != 0) {
				update(mat);
				return null;
			} else {
				return guardarNuevo(mat);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		

	}

	/**
	 * 
	 */
	private static Materia guardarNuevo(Materia mat) {
		try {

			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"insert into centroeducativo.materia set id = ?, nombre = ?, acronimo = ?, curso_id = ?");

			ps.setInt(1, nextId());

			ps.setString(2, mat.getNombre());
			ps.setString(3, mat.getAcronimo());
			ps.setInt(4, mat.getCurso().getId());

			ps.executeUpdate();

			ps.close();
			conn.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mat;

	}

	/**
	 * 
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public static void update(Materia mat) throws NumberFormatException, SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update centroeducativo.materia set nombre = ?, acronimo = ?, curso_id = ? where id =" + mat.getId());

		ps.setString(1, mat.getNombre());
		ps.setString(2, mat.getAcronimo());
		ps.setInt(3, mat.getCurso().getId());

		ps.executeUpdate();

		ps.close();
		conn.close();

	}

	public static void delete(Materia mat) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("delete from centroeducativo.materia where id = " + mat.getId());
			int conf = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar el registro?");
			if (conf == JOptionPane.YES_OPTION) {
				ps.executeUpdate();
			}

			ps.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Materia cargarAnteriorRegistro(Materia mat) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.materia where id < " + mat.getId() + " order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			Materia m = new Materia();
			if (rs.next()) {

				m.setId(rs.getInt(1));

				m.setNombre(rs.getString(2));
				m.setAcronimo(rs.getString(3));
				Curso c = new Curso();
				c.setId(rs.getInt(4));
				m.setCurso(c);

				rs.close();
				ps.close();
				conn.close();
				return m;

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Materia cargarSiguienteRegistro(Materia mat) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.materia where id > " + mat.getId() + " order by id limit 1");
			ResultSet rs = ps.executeQuery();
			Materia m = new Materia();
			if (rs.next()) {

				m.setId(rs.getInt(1));

				m.setNombre(rs.getString(2));
				m.setAcronimo(rs.getString(3));
				Curso c = new Curso();
				c.setId(rs.getInt(4));
				m.setCurso(c);

				rs.close();
				ps.close();
				conn.close();
				return m;

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Materia cargarUltimoRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Materia mat = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.materia order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				mat = new Materia();
				mat.setId(rs.getInt(1));
				mat.setNombre(rs.getString(2));
				mat.setAcronimo(rs.getString(3));
				Curso c = new Curso();
				c.setId(rs.getInt(4));
				mat.setCurso(c);

				rs.close();
				ps.close();
				conn.close();
				return mat;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Materia cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Materia mat = null;
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.materia order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				mat = new Materia();
				mat.setId(rs.getInt(1));
				mat.setNombre(rs.getString(2));
				mat.setAcronimo(rs.getString(3));
				Curso c = new Curso();
				c.setId(rs.getInt(4));
				mat.setCurso(c);

				rs.close();
				ps.close();
				conn.close();
				return mat;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static int nextId() throws SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.materia");
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return rs.getInt(1) + 1;

		}
		ps.close();
		rs.close();
		conn.close();
		return 1;

	}

	public static List<Materia> findAll() {
		List<Materia> lc = new ArrayList<Materia>();
		Materia ma = cargarPrimerRegistro();
		do {
			lc.add(ma);
			ma = cargarSiguienteRegistro(ma);
		} while (ma != null);
		return lc;
	}

}
