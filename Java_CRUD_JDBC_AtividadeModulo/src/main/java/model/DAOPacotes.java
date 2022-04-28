package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAOPacotes {
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
	public void inserirContato(JbPacotes contato) {
		String create = "insert into pacotes (num_acompanhantes,hospedagem_sim_nao,preco,data_ida,data_volta,nome_pacote) values (?,?,?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNum_acompanhantes());
			pst.setString(2, contato.getHospedagem_sim_nao());
			pst.setString(3, contato.getPreco());
			pst.setString(4, contato.getData_ida());
			pst.setString(5, contato.getData_volta());
			pst.setString(6, contato.getNome_pacote());
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
	public ArrayList<JbPacotes> listarContatos() {
		ArrayList<JbPacotes> contatos = new ArrayList<>();
		String read = "select * from pacotes order by nome_pacote";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id_pacote = rs.getString(1);
				String num_acompanhantes = rs.getString(2);
				String hospedagem_sim_nao = rs.getString(3);
				String preco = rs.getString(4);
				String data_ida = rs.getString(5);
				String data_volta = rs.getString(6);
				String nome_pacote = rs.getString(7);
				String id_cliente = rs.getString(8);
				String id_destino = rs.getString(9);
				contatos.add(new JbPacotes(id_pacote, num_acompanhantes, hospedagem_sim_nao, preco, data_ida, data_volta, nome_pacote, id_cliente, id_destino ));
				//contatos.add(new JbClientes(nome,telefone,cidade_reside,uf_reside,email,país_reside));
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
	public void selecionarContato(JbPacotes contato) {
		String read2 = "select * from pacotes where id_pacote = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getId_pacote());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setNum_acompanhantes(rs.getString(1));
				contato.setHospedagem_sim_nao(rs.getString(2));
				contato.setPreco(rs.getString(3));
				contato.setData_ida(rs.getString(4));
				contato.setData_volta(rs.getString(5));
				contato.setNome_pacote(rs.getString(6));
				contato.setId_pacote(rs.getString(7));
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
	public void alterarContato(JbPacotes contato) {
		String update = "update pacotes set num_acompanhantes=?,hospedagem_sim_nao=?,preco=?,data_ida=?,data_volta=?,nome_pacote=? where id_pacote=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNum_acompanhantes());
			pst.setString(2, contato.getHospedagem_sim_nao());
			pst.setString(3, contato.getPreco());
			pst.setString(4, contato.getData_ida());
			pst.setString(5, contato.getData_volta());
			pst.setString(6, contato.getNome_pacote());
			pst.setString(7, contato.getId_pacote());
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
	public void deletarContato(JbPacotes contato) {
		String delete = "delete from pacotes where id_pacote=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getId_pacote());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
