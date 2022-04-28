/**
 * Confirmar a exclusao de um contato
 * 
 * 
 * @param id_destino
 */

function confirmar1(id_destino) {
	let resposta = confirm("Confirma a exclusão?")
	if (resposta === true) {
		window.location.href = "delete1?id_destino=" + id_destino
	}
}