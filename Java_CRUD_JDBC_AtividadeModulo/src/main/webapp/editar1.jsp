<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Destino</title>
<link rel="icon" href="imagens/hacker1.png">
<link rel="stylesheet" href="style1.css">
</head>
<body>
	<h1>Editar Destino</h1>
	<form name="frmContato" action="update1">
		<table>
			<tr>
				<td><h6>ID</h6><input type="text" name="id_destino" id="caixa3" readonly
					value="<%out.print(request.getAttribute("id_destino"));%>"></td>
			</tr>
			<tr>
				<td><h6>Cidade</h6><input type="text" name="cidade" class="Caixa1"
					value="<%out.print(request.getAttribute("cidade"));%>"></td>
			</tr>
			<tr>
				<td><h6>Estado</h6><input type="text" name="estado" class="Caixa2"
					value="<%out.print(request.getAttribute("estado"));%>"></td>
			</tr>
			<tr>
				<td><h6>País</h6><input type="text" name="país" class="Caixa1"
					value="<%out.print(request.getAttribute("país"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
		<a href="main1" class="Botao1">Voltar</a>
	</form>
	<script src="scripts/validador1.js"></script>
</body>
</html>