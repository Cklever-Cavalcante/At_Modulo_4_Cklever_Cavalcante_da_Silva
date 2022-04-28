/**
 * Validar campos obrigatorios
 * 
 * 
 */
function validar2() {
	let num_acompanhantes = frmContato.num_acompanhantes.value
	let hospedagem_sim_nao = frmContato.hospedagem_sim_nao.value
	let preco = frmContato.preco.value
	let data_ida = frmContato.data_ida.value
	let data_volta = frmContato.data_volta.value
	let nome_pacote = frmContato.nome_pacote.value
	if (num_acompanhantes === "") {
		alert('Preencha o campo Acompanhantes')
		frmContato.num_acompanhantes.focus()
		return false
	} else if (hospedagem_sim_nao === "") {
		alert('Preencha o campo Hospedagem')
		frmContato.hospedagem_sim_nao.focus()
		return false
	} else if (preco === "") {
		alert('Preencha o campo Preço')
		frmContato.preco.focus()
		return false
	} else if (data_ida === "") {
		alert('Preencha o campo Data ida')
		frmContato.data_ida.focus()
		return false
	} else if (data_volta === "") {
		alert('Preencha o campo Data volta')
		frmContato.data_volta.focus()
		return false
	} else if (nome_pacote === "") {
		alert('Preencha o campo Pacote')
		frmContato.nome_pacote.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}