
package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artists;
import model.ConnectionDB;

@WebServlet(urlPatterns =
{ "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report", "/regartist"
})

public class MainController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	ConnectionDB dao = new ConnectionDB();

	Artists contato = new Artists();

	public MainController()
	{
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main"))
		{
			contatos(request, response);

			// response.sendRedirect("home.html");

		} else if (action.equals("/insert"))
		{
			adicionarContato(request, response);

		} else if (action.equals("/select"))
		{
			listarContato(request, response);

		} else if (action.equals("/update"))
		{
			editarContato(request, response);

		} else if (action.equals("/delete"))
		{
			removerContato(request, response);

		} else if (action.equals("/report"))
		{
			// gerarRelatorio(request, response);

		} else
		{
			response.sendRedirect("index.html");
		}

		/* //Teste de conexão: dao.testeConexao(); */
	}

	// Listar Contatos:

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		// response.sendRedirect("agenda.jsp");

		// Criando um objeto para receber os dados JavaBeans

		ArrayList<Artists> lista = dao.listarContatos();

		// TESTE DE RECEBIMENTO DA LISTA:
		/*-
		 * 
		for (int i = 0; i < lista.size(); i++)
		{
			System.out.println(lista.get(i).getIdcon());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getEmail());
			System.out.println(lista.get(i).getSexo());
			System.out.println(lista.get(i).getDatadenascimento());
			System.out.println(lista.get(i).getNacionalidade());
			System.out.println(lista.get(i).getCpf());
		}
		*/

		// ENCAMINHAR A LISTA AO DOCUMENTO AGENDA.JSP:

		// SETAR UM ATRIBUTO DO DOCUMENTO JSP COM A LISTA

		request.setAttribute("contatos", lista);

		// DESPACHAR A LISTA AO DOCUMENTO AGENDA.JSP:

		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");

		// ENCAMINHA O OBJETO LISTA AO DOCUMENTO

		rd.forward(request, response);
	}

	// Novo Contato:

	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		/*
		 * //Teste de recebimento dos dados do formulario.
		 * 
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("fone"));
		 * System.out.println(request.getParameter("email"));
		 */

		// Setar as variaveis JavaBeans:
		contato.setNome(request.getParameter("name"));
		contato.setEmail(request.getParameter("email"));
		contato.setSexo(request.getParameter("gender"));
		contato.setDatadenascimento(request.getParameter("birthday"));
		contato.setNacionalidade(request.getParameter("nationality"));
		contato.setCpf(request.getParameter("cpf"));

		// Invocar o método inserirContato passando o objeto contato

		dao.inserirContato(contato);

		// Redirecionar para o documento agenda.jsp
		response.sendRedirect("main");

	}

	// Editar Contato:

	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		/*-
		//RECEBER UM PARAMETRO (?) NA REQUISIÇÃO (ID DO CONTATO A SER EDITADO):
		
		String idcon = request.getParameter("idcon");
		
		//SETAR A VARIAVEL JAVABEANS:
		
		contato.setIdcon(idcon);
		
		// EXECUTA O METODO selecionarContato()
		
		dao.selecionarContato(contato);
		
		/*
		 * //TESTE DE RECEBIMENTO:
		 * 
		 * System.out.println(contato.getIdcon());
		 * System.out.println(contato.getNome());
		 * System.out.println(contato.getFone());
		 * System.out.println(contato.getEmail());
		 */
		/*-
				//SETA OS VALORES NO FORMULARIO EDITAR - USANTO O ATRIBUTO "NAME HTML"
				//DA PAGINA EDITAR.JSP:
		
				request.setAttribute("idcon", contato.getIdcon());
				request.setAttribute("nome", contato.getNome());
				request.setAttribute("fone", contato.getFone());
				request.setAttribute("email", contato.getEmail());
		
				//ENCAMINHAR A REQUISIÇÃO PARA A PAGINA EDITAR.JSP:
		
				RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		
				rd.forward(request, response);
		
				//
		
				//response.sendRedirect("editar.jsp");
				*/
	}

	// EDITAR CONTATO:

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		/*
		 * //TESTE DE RECEBIMENTO: System.out.println(request.getParameter("idcon"));
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("fone"));
		 * System.out.println(request.getParameter("email"));
		 */
		/*-
				
				//SETAR AS VARIAVEIS NO JAVABEANS:
		
				contato.setIdcon(request.getParameter("idcon"));
				contato.setNome(request.getParameter("nome"));
				contato.setFone(request.getParameter("fone"));
				contato.setEmail(request.getParameter("email"));
		
				//EXECUTAR O METODO ALTERAR CONTATO:
		
				dao.alterarContato(contato);
		
				//REDIRECIONAR PARA O DOCUMENTO AGENDA.JSP - UTILIZANDO A REQUISIÇÃO 'MAIN'
				//IRAR ABRIR AGENDA.JSP JÁ ATUALIZADO COM O BANCO:
		
				response.sendRedirect("main");
				*/
	}

	// REMOVER CONTATO:

	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// RECEBIMENTO DO ID DO CONTATO A SER EXCLUIDO:

		String idcon = request.getParameter("idcon");

		/*
		 * //TESTE DE RECEBIMENTO: System.out.println(idcon);
		 */

		// SETAR A VARIAVEL 'IDCON' NO JAVABEANS:

		contato.setIdcon(idcon);

		// EXECUTAR O METDO deletarContato()

		dao.deletarContato(contato);

		// REDIRECIONAR PARA O DOCUMENTO AGENDA.JSP - UTILIZANDO A REQUISIÇÃO 'MAIN'
		// IRAR ABRIR AGENDA.JSP JÁ ATUALIZADO COM O BANCO:

		response.sendRedirect("main");

	}

}

//OBS.: PARA GERAR O JAVA DOC É SO CLICAR COM O BOTAO DIREITO MOUSE NA ULTIMA LINHA
//DE CADA ARQUIVO .JAVA E GERAR!
