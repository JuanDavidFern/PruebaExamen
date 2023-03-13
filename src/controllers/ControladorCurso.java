package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Curso;

public class ControladorCurso {
	private static Connection conn = null;

	public static Curso guardar(Curso curs) {
		try {

			if (curs.getId() != 0) {
				update(curs);
				return null;
			} else {
				return guardarNuevo(curs);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 */
	private static Curso guardarNuevo(Curso curs) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("insert into centroeducativo.curso set id = ?, descripcion = ? ");

			ps.setInt(1, nextId());

			ps.setString(2, curs.getDescri());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return curs;

	}

	/**
	 * 
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	private static void update(Curso curs) throws NumberFormatException, SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn
				.prepareStatement("update centroeducativo.curso set descripcion = ? where id =" + curs.getId());

		ps.setString(1, curs.getDescri());

		ps.executeUpdate();

		ps.close();
		conn.close();

	}

	/**
	 * 
	 */
	public static void delete(Curso curs) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("delete from centroeducativo.curso where id = " + curs.getId());
			int conf = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar el registro?");
			if (conf == JOptionPane.YES_OPTION) {
				ps.executeUpdate();
			}

			ps.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public static Curso cargarAnteriorRegistro(Curso curs) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.curso where id < " + curs.getId() + " order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			Curso c = new Curso();
			if (rs.next()) {

				c.setId(rs.getInt(1));
				c.setDescri(rs.getString(2));
				rs.close();
				ps.close();
				conn.close();
				return c;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 */
	public static Curso cargarSiguienteRegistro(Curso curs) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.curso where id > " + curs.getId() + " order by id limit 1");
			ResultSet rs = ps.executeQuery();
			Curso c = new Curso();
			if (rs.next()) {

				c.setId(rs.getInt(1));
				c.setDescri(rs.getString(2));

				rs.close();
				ps.close();
				conn.close();
				return c;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 */
	public static Curso cargarUltimoRegistro() {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Curso curs = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.curso order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				curs = new Curso();
				curs.setId(rs.getInt(1));
				curs.setDescri(rs.getString(2));

				
			}
			rs.close();
			ps.close();
			conn.close();
			return curs;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public static Curso cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Curso curs = null;
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.curso order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				curs = new Curso();
				curs.setId(rs.getInt(1));
				curs.setDescri(rs.getString(2));
			}
			rs.close();
			ps.close();
			conn.close();
			return curs;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 */
	public static int nextId() throws SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.curso");
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int maxid = rs.getInt(1) + 1;
			ps.close();
			rs.close();
			return maxid;

		}
		ps.close();
		rs.close();
		return 1;

	}


	public static List<Curso> findAll() {
		List<Curso> lc = new ArrayList<Curso>();
		Curso c = cargarPrimerRegistro();
		do {
			lc.add(c);
			c = cargarSiguienteRegistro(c);
		} while (c != null);
		return lc;
	}
}
