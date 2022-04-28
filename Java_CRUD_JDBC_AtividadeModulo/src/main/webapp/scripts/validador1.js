/**
 * Validar campos obrigatorios
 * 
 * 
 */
function validar1() {
	let cidade = frmContato.cidade.value
	let estado = frmContato.estado.value
	let país = frmContato.país.value
	if (cidade === "") {
		alert('Preencha o campo Cidade')
		frmContato.cidade.focus()
		return false
	} else if (estado === "") {
		alert('Preencha o campo Estado')
		frmContato.estado.focus()
		return false
	} else if (país === "") {
		alert('Preencha o campo País')
		frmContato.país.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}