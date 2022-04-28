<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JbPacotes"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<JbPacotes> lista = (ArrayList<JbPacotes>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Pacotes</title>
<link rel="icon" href="imagens/hacker1.png">
<link rel="stylesheet" href="style1.css">
</head>
<body>
	<h1>Lista de Pacotes</h1>
	<a href="novo2.html" class="Botao1">Novo Pacote</a>
	<a href="report2" class="Botao2">Relatório</a>
	<a href="index.html" class="Botao1">Voltar</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Acompanhantes</th>
				<th>Hospedagem</th>
				<th>Preço</th>
				<th>Data ida</th>
				<th>Data volta</th>
				<th>Pacote</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId_pacote()%></td>
				<td><%=lista.get(i).getNum_acompanhantes()%></td>
				<td><%=lista.get(i).getHospedagem_sim_nao()%></td>
				<td><%=lista.get(i).getPreco()%></td>
				<td><%=lista.get(i).getData_ida()%></td>
				<td><%=lista.get(i).getData_volta()%></td>
				<td><%=lista.get(i).getNome_pacote()%></td>
				<td>
					<a href="select2?id_pacote=<%=lista.get(i).getId_pacote()%>"
					class="Botao1">Editar</a>
					<a href="javascript: confirmar2(<%=lista.get(i).getId_pacote()%>)"
					class="Botao2">Excluir</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador2.js"></script>
</body>
</html>