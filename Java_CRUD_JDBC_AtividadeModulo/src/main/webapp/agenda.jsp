<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JbClientes"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<JbClientes> lista = (ArrayList<JbClientes>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Clientes</title>
<link rel="icon" href="imagens/hacker1.png">
<link rel="stylesheet" href="style1.css">
</head>
<body>
	<h1>Lista de Clientes</h1>
	<a href="novo.html" class="Botao1">Novo Cliente</a>
	<a href="report" class="Botao2">Relatório</a>
	<a href="index.html" class="Botao1">Voltar</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Cidade</th>
				<th>UF</th>
				<th>E-mail</th>
				<th>País</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId_cliente()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getTelefone()%></td>
				<td><%=lista.get(i).getCidade_reside()%></td>
				<td><%=lista.get(i).getUf_reside()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getPaís_reside()%></td>
				<td>
					<a href="select?id_cliente=<%=lista.get(i).getId_cliente()%>"
					class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getId_cliente()%>)"
					class="Botao2">Excluir</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>