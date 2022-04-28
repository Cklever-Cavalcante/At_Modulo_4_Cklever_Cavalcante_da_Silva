/**
 * Validar campos obrigatorios
 * 
 * 
 */
function validar() {
	let nome = frmContato.nome.value
	let telefone = frmContato.telefone.value
	let cidade_reside = frmContato.cidade_reside.value
	let uf_reside = frmContato.uf_reside.value
	let email = frmContato.email.value
	let país_reside = frmContato.país_reside.value
	if (nome === "") {
		alert('Preencha o campo Nome')
		frmContato.nome.focus()
		return false
	} else if (telefone === "") {
		alert('Preencha o campo Telefone')
		frmContato.telefone.focus()
		return false
	} else if (cidade_reside === "") {
		alert('Preencha o campo Cidade')
		frmContato.cidade_reside.focus()
		return false
	} else if (uf_reside === "") {
		alert('Preencha o campo UF')
		frmContato.uf_reside.focus()
		return false
	} else if (email === "") {
		alert('Preencha o campo E-mail')
		frmContato.email.focus()
		return false
	} else if (país_reside === "") {
		alert('Preencha o campo País')
		frmContato.país_reside.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}