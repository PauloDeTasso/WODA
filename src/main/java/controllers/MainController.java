
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
{ "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report", "/regartist", "/artregister"
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

		} else if (action.equals("/artregister"))
		{
			response.sendRedirect("artregister.html");

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

	// Novo Contato - /insert:

	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// Teste de recebimento dos dados do formulario.

		/*-
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("gender"));
		System.out.println(request.getParameter("birthday"));
		System.out.println(request.getParameter("nationality"));
		System.out.println(request.getParameter("cpf"));
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

	// Editar Contato /select:

	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		String idcon = request.getParameter("idcon");

		// RECEBER UM PARAMETRO (?) NA REQUISIÇÃO (ID DO CONTATO A SER EDITADO):

		/*-
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String nationality = request.getParameter("nationality");
		String cpf = request.getParameter("cpf");
		*/

		// SETAR A VARIAVEL JAVABEANS:

		contato.setIdcon(idcon);
		/*-
		contato.setNome(name);
		contato.setEmail(email);
		contato.setSexo(gender);
		contato.setDatadenascimento(birthday);
		contato.setNacionalidade(nationality);
		contato.setCpf(cpf);
		*/
		// EXECUTA O METODO selecionarContato()

		dao.selecionarContato(contato);

		// TESTE DE RECEBIMENTO:

		System.out.println(contato.getIdcon());
		System.out.println(contato.getNome());
		System.out.println(contato.getEmail());
		System.out.println(contato.getSexo());
		System.out.println(contato.getDatadenascimento());
		System.out.println(contato.getNacionalidade());
		System.out.println(contato.getCpf());
		System.out.println(contato.getImageartist());

		/*-
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("name"));
		contato.setEmail(request.getParameter("email"));
		contato.setSexo(request.getParameter("gender"));
		contato.setDatadenascimento(request.getParameter("birthday"));
		contato.setNacionalidade(request.getParameter("nationality"));
		contato.setCpf(request.getParameter("cpf"));
		*/

		// SETA OS VALORES NO FORMULARIO EDITAR - USANTO O ATRIBUTO "NAME HTML"
		// DA PAGINA EDITAR.JSP:

		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("name", contato.getNome());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("gender", contato.getSexo());
		request.setAttribute("birthday", contato.getDatadenascimento());
		request.setAttribute("nationality", contato.getNacionalidade());
		request.setAttribute("cpf", contato.getCpf());

		// ENCAMINHAR A REQUISIÇÃO PARA A PAGINA EDITAR.JSP:

		RequestDispatcher rd = request.getRequestDispatcher("artistedit.jsp");

		rd.forward(request, response);

		//

		// response.sendRedirect("artistedit.jsp"); }
	}

	// EDITAR CONTATO /update:

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		// TESTE DE RECEBIMENTO:
		System.out.println(request.getParameter("idartist"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("gender"));
		System.out.println(request.getParameter("birthday"));
		System.out.println(request.getParameter("nationality"));
		System.out.println(request.getParameter("cpf"));

		// SETAR AS VARIAVEIS NO JAVABEANS:

		contato.setIdcon(request.getParameter("idartist"));
		contato.setNome(request.getParameter("name"));
		contato.setEmail(request.getParameter("email"));
		contato.setSexo(request.getParameter("gender"));
		contato.setDatadenascimento(request.getParameter("birthday"));
		contato.setNacionalidade(request.getParameter("nationality"));
		contato.setCpf(request.getParameter("cpf"));

		// EXECUTAR O METODO ALTERAR CONTATO:

		dao.alterarContato(contato);

		// REDIRECIONAR PARA O DOCUMENTO AGENDA.JSP - UTILIZANDO A REQUISIÇÃO 'MAIN'
		// IRAR ABRIR AGENDA.JSP JÁ ATUALIZADO COM O BANCO:

		response.sendRedirect("main");

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
