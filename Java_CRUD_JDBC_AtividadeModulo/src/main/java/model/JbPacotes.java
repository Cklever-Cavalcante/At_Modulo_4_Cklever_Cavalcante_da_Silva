package model;

public class JbPacotes {
	  
	 private String id_pacote;
	 private String num_acompanhantes;
	 private String hospedagem_sim_nao;
	 private String preco;
	 private String data_ida;
	 private String data_volta;
	 private String nome_pacote;
	 private String id_cliente;
	 private String id_destino;
	 
	public JbPacotes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JbPacotes(String id_pacote, String num_acompanhantes, String hospedagem_sim_nao, String preco,
			String data_ida, String data_volta, String nome_pacote, String id_cliente, String id_destino) {
		super();
		this.id_pacote = id_pacote;
		this.num_acompanhantes = num_acompanhantes;
		this.hospedagem_sim_nao = hospedagem_sim_nao;
		this.preco = preco;
		this.data_ida = data_ida;
		this.data_volta = data_volta;
		this.nome_pacote = nome_pacote;
		this.id_cliente = id_cliente;
		this.id_destino = id_destino;
	}

	public String getId_pacote() {
		return id_pacote;
	}
	public void setId_pacote(String id_pacote) {
		this.id_pacote = id_pacote;
	}
	public String getNum_acompanhantes() {
		return num_acompanhantes;
	}
	public void setNum_acompanhantes(String num_acompanhantes) {
		this.num_acompanhantes = num_acompanhantes;
	}
	public String getHospedagem_sim_nao() {
		return hospedagem_sim_nao;
	}
	public void setHospedagem_sim_nao(String hospedagem_sim_nao) {
		this.hospedagem_sim_nao = hospedagem_sim_nao;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getData_ida() {
		return data_ida;
	}
	public void setData_ida(String data_ida) {
		this.data_ida = data_ida;
	}
	public String getData_volta() {
		return data_volta;
	}
	public void setData_volta(String data_volta) {
		this.data_volta = data_volta;
	}
	public String getNome_pacote() {
		return nome_pacote;
	}
	public void setNome_pacote(String nome_pacote) {
		this.nome_pacote = nome_pacote;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getId_destino() {
		return id_destino;
	}
	public void setId_destino(String id_destino) {
		this.id_destino = id_destino;
	}

}
