/**
 * Confirmar a exclusao de um contato
 * 
 * 
 * @param id_pacote
 */

function confirmar2(id_pacote) {
	let resposta = confirm("Confirma a exclusão?")
	if (resposta === true) {
		window.location.href = "delete2?id_pacote=" + id_pacote
	}
}