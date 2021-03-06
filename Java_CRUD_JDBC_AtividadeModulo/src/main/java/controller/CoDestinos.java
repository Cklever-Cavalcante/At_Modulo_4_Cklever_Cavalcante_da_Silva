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

import model.DAODestinos;
import model.JbDestinos;

/**
 * Servlet implementation class CoClientes
 */
@WebServlet(urlPatterns = {"/CoDestinos", "/main1", "/insert1", "/select1", "/update1", "/delete1", "/report1" })
public class CoDestinos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Criando objeto de DAO
       DAODestinos dao = new DAODestinos();
       
       /** Objeto contato. */
   	JbDestinos contato = new JbDestinos();
     /**
     * @see HttpServlet#HttpServlet()
     */
    public CoDestinos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main1")) {
			contatos(request, response);
		} else if (action.equals("/insert1")) {
			adicionarContato(request, response);
		} else if (action.equals("/select1")) {
			listarContato(request, response);
		} else if (action.equals("/update1")) {
			editarContato(request, response);
		} else if (action.equals("/delete1")) {
			removerContato(request, response);
		} else if (action.equals("/report1")) {
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
		ArrayList<JbDestinos> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda1.jsp");
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
		contato.setCidade(request.getParameter("cidade"));
		contato.setEstado(request.getParameter("estado"));
		contato.setPa?s(request.getParameter("pa?s"));
		dao.inserirContato(contato);
		response.sendRedirect("main1");
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
		contato.setId_destino(request.getParameter("id_destino"));
		dao.selecionarContato(contato);
		request.setAttribute("id_destino", contato.getId_destino());
		request.setAttribute("cidade", contato.getCidade());
		request.setAttribute("estado", contato.getEstado());
		request.setAttribute("pa?s", contato.getPa?s());
		RequestDispatcher rd = request.getRequestDispatcher("editar1.jsp");
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
		contato.setId_destino(request.getParameter("id_destino"));
		contato.setCidade(request.getParameter("cidade"));
		contato.setEstado(request.getParameter("estado"));
		contato.setPa?s(request.getParameter("pa?s"));
		dao.alterarContato(contato);
		response.sendRedirect("main1");
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
		contato.setId_destino(request.getParameter("id_destino"));
		dao.deletarContato(contato);
		response.sendRedirect("main1");
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
			documento.add(new Paragraph("Lista de Destinos:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("Cidade"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Estado"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Pa?s"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			ArrayList<JbDestinos> lista = dao.listarContatos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getCidade());
				tabela.addCell(lista.get(i).getEstado());
				tabela.addCell(lista.get(i).getPa?s());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}

}