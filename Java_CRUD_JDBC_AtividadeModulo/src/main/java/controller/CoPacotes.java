package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAOPacotes;
import model.JbPacotes;

/**
 * Servlet implementation class CoClientes
 */
@WebServlet(urlPatterns = {"/CoPacotes", "/main2", "/insert2", "/select2", "/update2", "/delete2", "/report2" })
public class CoPacotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Criando objeto de DAO
       DAOPacotes dao = new DAOPacotes();
       
       /** Objeto contato. */
   	JbPacotes contato = new JbPacotes();
     /**
     * @see HttpServlet#HttpServlet()
     */
    public CoPacotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main2")) {
			contatos(request, response);
		} else if (action.equals("/insert2")) {
			adicionarContato(request, response);
		} else if (action.equals("/select2")) {
			listarContato(request, response);
		} else if (action.equals("/update2")) {
			editarContato(request, response);
		} else if (action.equals("/delete2")) {
			removerContato(request, response);
		} else if (action.equals("/report2")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	/**
	 * Contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JbPacotes> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda2.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	
	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setNum_acompanhantes(request.getParameter("num_acompanhantes"));
		contato.setHospedagem_sim_nao(request.getParameter("hospedagem_sim_nao"));
		contato.setPreco(request.getParameter("preco"));
		contato.setData_ida(request.getParameter("data_ida"));
		contato.setData_volta(request.getParameter("data_volta"));
		contato.setNome_pacote(request.getParameter("nome_pacote"));
		dao.inserirContato(contato);
		response.sendRedirect("main2");
	}

	/**
	 * Listar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */	
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId_pacote(request.getParameter("id_pacote"));
		dao.selecionarContato(contato);
		request.setAttribute("id_pacote", contato.getId_pacote());
		request.setAttribute("num_acompanhantes", contato.getNum_acompanhantes());
		request.setAttribute("hospedagem_sim_nao", contato.getHospedagem_sim_nao());
		request.setAttribute("preco", contato.getPreco());
		request.setAttribute("data_ida", contato.getData_ida());
		request.setAttribute("data_volta", contato.getData_volta());
		request.setAttribute("nome_pacote", contato.getNome_pacote());
		RequestDispatcher rd = request.getRequestDispatcher("editar2.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId_pacote(request.getParameter("id_pacote"));
		contato.setNum_acompanhantes(request.getParameter("num_acompanhantes"));
		contato.setHospedagem_sim_nao(request.getParameter("hospedagem_sim_nao"));
		contato.setPreco(request.getParameter("preco"));
		contato.setData_ida(request.getParameter("data_ida"));
		contato.setData_volta(request.getParameter("data_volta"));
		contato.setNome_pacote(request.getParameter("nome_pacote"));
		dao.alterarContato(contato);
		response.sendRedirect("main2");
	}

	/**
	 * Remover contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId_pacote(request.getParameter("id_pacote"));
		dao.deletarContato(contato);
		response.sendRedirect("main2");
	}

	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Pacotes:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(6);
			PdfPCell col1 = new PdfPCell(new Paragraph("Acompanhante:"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Hospedagem:"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Preço"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Data Ida"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Data Volta"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Nome do Pacote"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			ArrayList<JbPacotes> lista = dao.listarContatos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNum_acompanhantes());
				tabela.addCell(lista.get(i).getHospedagem_sim_nao());
				tabela.addCell(lista.get(i).getPreco());
				tabela.addCell(lista.get(i).getData_ida());
				tabela.addCell(lista.get(i).getData_volta());
				tabela.addCell(lista.get(i).getNome_pacote());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}

}