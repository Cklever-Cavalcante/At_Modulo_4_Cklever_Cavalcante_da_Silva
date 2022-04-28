/**
 * Confirmar a exclusao de um contato
 * 
 * 
 * @param id_cliente
 */

function confirmar(id_cliente) {
	let resposta = confirm("Confirma a exclusão?")
	if (resposta === true) {
		window.location.href = "delete?id_cliente=" + id_cliente
	}
}