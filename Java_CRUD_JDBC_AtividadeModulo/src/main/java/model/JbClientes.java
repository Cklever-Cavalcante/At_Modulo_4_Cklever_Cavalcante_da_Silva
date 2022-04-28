package model;

public class JbClientes {
		
	private String nome;
	private String telefone;
	private String cidade_reside;
	private String id_cliente;
	private String uf_reside;
	private String email;
	private String pa�s_reside;
	private String id_pacote;
	
	public JbClientes() {
		super();
	}
	
	public JbClientes(String nome, String telefone, String cidade_reside, String id_cliente, String uf_reside,
			String email, String pa�s_reside, String id_pacote) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.cidade_reside = cidade_reside;
		this.id_cliente = id_cliente;
		this.uf_reside = uf_reside;
		this.email = email;
		this.pa�s_reside = pa�s_reside;
		this.id_pacote = id_pacote;
	}

	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade_reside() {
		return cidade_reside;
	}
	public void setCidade_reside(String cidade_reside) {
		this.cidade_reside = cidade_reside;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getUf_reside() {
		return uf_reside;
	}
	public void setUf_reside(String uf_reside) {
		this.uf_reside = uf_reside;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPa�s_reside() {
		return pa�s_reside;
	}
	public void setPa�s_reside(String pa�s_reside) {
		this.pa�s_reside = pa�s_reside;
	}
	public String getId_pacote() {
		return id_pacote;
	}
	public void setId_pacote(String id_pacote) {
		this.id_pacote = id_pacote;
	}

}
