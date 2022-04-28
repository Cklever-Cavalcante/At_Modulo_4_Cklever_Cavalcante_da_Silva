package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAODestinos {
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/agencia?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "Lacrimosa9-";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JbDestinos contato) {
		String create = "insert into destinos (cidade,estado,pa�s) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getCidade());
			pst.setString(2, contato.getEstado());
			pst.setString(3, contato.getPa�s());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JbDestinos> listarContatos() {
		ArrayList<JbDestinos> contatos = new ArrayList<>();
		String read = "select * from destinos order by cidade";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				String id_destino = rs.getString(1);
				String cidade = rs.getString(2);
				String estado = rs.getString(3);
				String pa�s = rs.getString(4);
				String id_pacote = rs.getString(5);
				contatos.add(new JbDestinos(id_destino, cidade, estado, pa�s, id_pacote ));
				//contatos.add(new JbClientes(nome,telefone,cidade_reside,uf_reside,email,pa�s_reside));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JbDestinos contato) {
		String read2 = "select * from destinos where id_destino = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getId_destino());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setCidade(rs.getString(1));
				contato.setEstado(rs.getString(2));
				contato.setPa�s(rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JbDestinos contato) {
		String update = "update destinos set cidade=?,estado=?,pa�s=? where id_destino=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getCidade());
			pst.setString(2, contato.getEstado());
			pst.setString(3, contato.getPa�s());
			pst.setString(4, contato.getId_destino());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JbDestinos contato) {
		String delete = "delete from destinos where id_destino=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getId_destino());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
