
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
import model.Arts;
import model.ConnectionDB;
import model.Searcher;

@WebServlet(urlPatterns =
{ "/main", "/insert", "/select", "/update", "/delete", "/artregister", "/artist", "/searcher"
})

//

public class MainController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	ConnectionDB dao = new ConnectionDB();

	Artists contato = new Artists();

	Arts art = new Arts();

	Searcher searcherMain = new Searcher();

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
			addArt(request, response);

		} else if (action.equals("/artist"))
		{
			listarArtista(request, response);

		} else if (action.equals("/searcher"))
		{
			searcher(request, response);

		} else
		{
			response.sendRedirect("index.html");
		}

		/* //Teste de conexão: dao.testeConexao(); */
	}

	// Listar Contatos - /main:

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		/*-
		ServletContext contexto = request.getServletContext();
		String path = contexto.getRealPath("");
		System.out.println(path);
		*/

		// String path = this.getServletContext().getRealPath("");

		// response.sendRedirect("agenda.jsp");

		// Criando um objeto para receber os dados JavaBeans

		ArrayList<Artists> lista = dao.listarContatos();

		// TESTE DE RECEBIMENTO DA LISTA:
		/*-
		 * 
		for (int i = 0; i < lista.size(); i++)
		{
			System.out.println(lista.get(i).getIdArtist());
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

		String idArtist = request.getParameter("idArtist");

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

		contato.setIdArtist(idArtist);
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
		/*-
				System.out.println("selecionarContato: ");
				System.out.println(contato.getIdArtist());
				System.out.println(contato.getNome());
				System.out.println(contato.getEmail());
				System.out.println(contato.getSexo());
				System.out.println(contato.getDatadenascimento());
				System.out.println(contato.getNacionalidade());
				System.out.println(contato.getCpf());
		*/
		/*-
		contato.setIdArtist(request.getParameter("idArtist"));
		contato.setNome(request.getParameter("name"));
		contato.setEmail(request.getParameter("email"));
		contato.setSexo(request.getParameter("gender"));
		contato.setDatadenascimento(request.getParameter("birthday"));
		contato.setNacionalidade(request.getParameter("nationality"));
		contato.setCpf(request.getParameter("cpf"));
		*/

		// SETA OS VALORES NO FORMULARIO EDITAR - USANTO O ATRIBUTO "NAME HTML"
		// DA PAGINA EDITAR.JSP:

		request.setAttribute("idArtist", contato.getIdArtist());
		request.setAttribute("name", contato.getNome());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("gender", contato.getSexo());
		request.setAttribute("birthday", contato.getDatadenascimento());
		request.setAttribute("nationality", contato.getNacionalidade());
		request.setAttribute("cpf", contato.getCpf());

		// ENCAMINHAR A REQUISIÇÃO PARA A PAGINA EDITAR.JSP:

		RequestDispatcher rd = request.getRequestDispatcher("artistedit.jsp");

		rd.forward(request, response);
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

		contato.setIdArtist(request.getParameter("idartist"));
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

	//

	// Artist Window - /select:

	protected void listarArtista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		String idArtist = request.getParameter("idArtist");

		// RECEBER UM PARAMETRO (?) NA REQUISIÇÃO (ID DO CONTATO A SER EDITADO):

		// SETAR A VARIAVEL JAVABEANS:

		contato.setIdArtist(idArtist);

		// EXECUTA O METODO selecionarContato()

		dao.selecionarContato(contato);

		// TESTE DE RECEBIMENTO:

		// SETA OS VALORES NO FORMULARIO EDITAR - USANTO O ATRIBUTO "NAME HTML"
		// DA PAGINA EDITAR.JSP:

		request.setAttribute("idArtist", contato.getIdArtist());
		request.setAttribute("name", contato.getNome());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("gender", contato.getSexo());
		request.setAttribute("birthday", contato.getDatadenascimento("br"));
		request.setAttribute("nationality", contato.getNacionalidade());
		request.setAttribute("cpf", contato.getCpf());

		// ENCAMINHAR A REQUISIÇÃO PARA A PAGINA EDITAR.JSP:

		RequestDispatcher rd = request.getRequestDispatcher("artist.jsp");
		rd.forward(request, response);
	}

	// REMOVER CONTATO - /delete:

	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// RECEBIMENTO DO ID DO CONTATO A SER EXCLUIDO:

		String idArtist = request.getParameter("idArtist");

		/*
		 * //TESTE DE RECEBIMENTO: System.out.println(idArtist);
		 */

		// SETAR A VARIAVEL 'IDCON' NO JAVABEANS:

		contato.setIdArtist(idArtist);

		// EXECUTAR O METDO deletarContato()

		dao.deletarContato(contato);

		// REDIRECIONAR PARA O DOCUMENTO AGENDA.JSP - UTILIZANDO A REQUISIÇÃO 'MAIN'
		// IRAR ABRIR AGENDA.JSP JÁ ATUALIZADO COM O BANCO:

		response.sendRedirect("main");

	}

	//

	// Search - /search:

	protected void searcher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// RECEBIMENTO DO ID DO CONTATO A SER EXCLUIDO:

		String searcher = request.getParameter("text");
		// SETAR A VARIAVEL 'IDCON' NO JAVABEANS:

		searcherMain.setSeacher(searcher);

		// EXECUTAR O METDO deletarContato()

		ArrayList<Artists> lista = dao.searcher(searcherMain);

		// ENCAMINHAR A LISTA AO DOCUMENTO AGENDA.JSP:

		// SETAR UM ATRIBUTO DO DOCUMENTO JSP COM A LISTA

		request.setAttribute("contatos", lista);

		request.setAttribute("searcher", searcher);

		// DESPACHAR A LISTA AO DOCUMENTO AGENDA.JSP:

		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");

		// ENCAMINHA O OBJETO LISTA AO DOCUMENTO

		rd.forward(request, response);

		// REDIRECIONAR PARA O DOCUMENTO AGENDA.JSP - UTILIZANDO A REQUISIÇÃO 'MAIN'
		// IRAR ABRIR AGENDA.JSP JÁ ATUALIZADO COM O BANCO:

		// response.sendRedirect("main");
	}

	// ADD ART - /artregister:

	protected void addArt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		art.setName(request.getParameter("name"));
		art.setDescription(request.getParameter("description"));
		art.setDataDePublicacao(request.getParameter("publicationdate"));

		System.out.println("publicationdate: " + request.getParameter("publicationdate"));

		art.setDataDeExposicao(request.getParameter("exposuredate"));

		System.out.println("exposuredate: " + request.getParameter("exposuredate"));

		art.setIdartist(request.getParameter("idartist"));

		// Invocar o método inserirContato passando o objeto contato

		dao.inserirArt(art);

		request.setAttribute("name", art.getName());
		request.setAttribute("description", art.getDescription());
		request.setAttribute("publicationdate", art.getDataDePublicacao());

		System.out.println("setAttribute art.getDataDePublicacao(): " + art.getDataDePublicacao());
		System.out.println("setAttribute art.getDataDeExposicao(): " + art.getDataDeExposicao());

		request.setAttribute("exposuredate", art.getDataDeExposicao());
		request.setAttribute("idartist", art.getIdartist());

		// DESPACHAR A LISTA AO DOCUMENTO AGENDA.JSP:

		RequestDispatcher rd = request.getRequestDispatcher("art.jsp");

		// ENCAMINHA O OBJETO LISTA AO DOCUMENTO

		rd.forward(request, response);
	}
}

//OBS.: PARA GERAR O JAVA DOC É SO CLICAR COM O BOTAO DIREITO MOUSE NA ULTIMA LINHA
//DE CADA ARQUIVO .JAVA E GERAR!
