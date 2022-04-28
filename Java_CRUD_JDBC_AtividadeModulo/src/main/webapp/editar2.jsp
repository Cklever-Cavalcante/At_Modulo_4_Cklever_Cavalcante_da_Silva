<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Pacote</title>
<link rel="icon" href="imagens/hacker1.png">
<link rel="stylesheet" href="style1.css">
</head>
<body>
	<h1>Editar Pacote</h1>
	<form name="frmContato" action="update2">
		<table>
			<tr>
				<td><h6>ID</h6><input type="text" name="id_pacote" id="caixa3" readonly
					value="<%out.print(request.getAttribute("id_pacote"));%>"></td>
			</tr>
			<tr>
				<td><h6>N° Acompanhantes</h6><input type="text" name="num_acompanhantes" class="Caixa1"
					value="<%out.print(request.getAttribute("num_acompanhantes"));%>"></td>
			</tr>
			<tr>
				<td><h6>Hospedagem?</h6><input type="text" name="hospedagem_sim_nao" class="Caixa2"
					value="<%out.print(request.getAttribute("hospedagem_sim_nao"));%>"></td>
			</tr>
			<tr>
				<td><h6>Preço</h6><input type="text" name="preco" class="Caixa1"
					value="<%out.print(request.getAttribute("preco"));%>"></td>
			</tr>
			<tr>
				<td><h6>Data Ida</h6><input type="text" name="data_ida" class="Caixa1"
					value="<%out.print(request.getAttribute("data_ida"));%>"></td>
			</tr>
			<tr>
				<td><h6>Data Volta</h6><input type="text" name="data_volta" class="Caixa1"
					value="<%out.print(request.getAttribute("data_volta"));%>"></td>
			</tr>
			<tr>
				<td><h6>Nome Pacote</h6><input type="text" name="nome_pacote" class="Caixa1"
					value="<%out.print(request.getAttribute("nome_pacote"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
		<a href="main2" class="Botao1">Voltar</a>
	</form>
	<script src="scripts/validador2.js"></script>
</body>
</html>