package model;

public class JbDestinos {
	 
	 private String id_destino;
   	 private String cidade;
	 private String estado;
	 private String pa�s;
	 private String id_pacote;
	 
	public JbDestinos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JbDestinos(String id_destino, String cidade, String estado, String pa�s, String id_pacote) {
		super();
		this.id_destino = id_destino;
		this.cidade = cidade;
		this.estado = estado;
		this.pa�s = pa�s;
		this.id_pacote = id_pacote;
	}

	public String getId_destino() {
		return id_destino;
	}
	public void setId_destino(String id_destino) {
		this.id_destino = id_destino;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPa�s() {
		return pa�s;
	}
	public void setPa�s(String pa�s) {
		this.pa�s = pa�s;
	}
	public String getId_pacote() {
		return id_pacote;
	}
	public void setId_pacote(String id_pacote) {
		this.id_pacote = id_pacote;
	}

}
