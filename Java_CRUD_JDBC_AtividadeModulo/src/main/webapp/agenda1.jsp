<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JbDestinos"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<JbDestinos> lista = (ArrayList<JbDestinos>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Destinos</title>
<link rel="icon" href="imagens/hacker1.png">
<link rel="stylesheet" href="style1.css">
</head>
<body>
	<h1>Lista de Destinos</h1>
	<a href="novo1.html" class="Botao1">Novo Destino</a>
	<a href="report1" class="Botao2">Relatório</a>
	<a href="index.html" class="Botao1">Voltar</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Cidade</th>
				<th>Estado</th>
				<th>País</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId_destino()%></td>
				<td><%=lista.get(i).getCidade()%></td>
				<td><%=lista.get(i).getEstado()%></td>
				<td><%=lista.get(i).getPaís()%></td>
				<td>
					<a href="select1?id_destino=<%=lista.get(i).getId_destino()%>"
					class="Botao1">Editar</a>
					<a href="javascript: confirmar1(<%=lista.get(i).getId_destino()%>)"
					class="Botao2">Excluir</a>					
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador1.js"></script>
</body>
</html>