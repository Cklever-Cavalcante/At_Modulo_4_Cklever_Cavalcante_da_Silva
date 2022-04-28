<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Cliente</title>
<link rel="icon" href="imagens/hacker1.png">
<link rel="stylesheet" href="style1.css">
</head>
<body>
	<h1>Editar Cliente</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><h6>ID</h6><input type="text" name="id_cliente" id="caixa3" readonly
					value="<%out.print(request.getAttribute("id_cliente"));%>"></td>
			</tr>
			<tr>
				<td><h6>Nome</h6><input type="text" name="nome" class="Caixa1"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><h6>Telefone</h6><input type="text" name="telefone" class="Caixa2"
					value="<%out.print(request.getAttribute("telefone"));%>"></td>
			</tr>
			<tr>
				<td><h6>Cidade</h6><input type="text" name="cidade_reside" class="Caixa1"
					value="<%out.print(request.getAttribute("cidade_reside"));%>"></td>
			</tr>
			<tr>
				<td><h6>UF</h6><input type="text" name="uf_reside" class="Caixa1"
					value="<%out.print(request.getAttribute("uf_reside"));%>"></td>
			</tr>
			<tr>
				<td><h6>E-mail</h6><input type="text" name="email" class="Caixa1"
					value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><h6>País</h6><input type="text" name="país_reside" class="Caixa2"
					value="<%out.print(request.getAttribute("país_reside"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
		<a href="main" class="Botao1">Voltar</a>
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>