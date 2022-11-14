
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
{ "/main", "/artistregister", "/selectartistedit", "/editartist", "/deleteArtist", "/artregister", "/artist",
		"/searcher"
})

public class MainController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	ConnectionDB dao = new ConnectionDB();

	Artists artist = new Artists();

	Arts art = new Arts();

	Searcher searcherMain = new Searcher();

	public MainController()
	{
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main"))
		{
			selectAllArtist(request, response);

			// response.sendRedirect("home.html");

		} else if (action.equals("/artistregister"))
		{
			addArtist(request, response);

		} else if (action.equals("/selectartistedit"))
		{
			selectArtistEdit(request, response);

		} else if (action.equals("/editartist"))
		{
			editArtist(request, response);

		} else if (action.equals("/deleteArtist"))
		{
			deleteArtist(request, response);

		} else if (action.equals("/artregister"))
		{
			addArt(request, response);

		} else if (action.equals("/artist"))
		{
			selectArtist(request, response);

		} else if (action.equals("/searcher"))
		{
			searcher(request, response);

		} else
		{
			response.sendRedirect("index.html");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();
		System.out.println(action);
		System.out.println("doPost");
	}

	//
	// selectAllArtist - /main:

	protected void selectAllArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ArrayList<Artists> listAllArtist = dao.selectAllArtistDb();

		request.setAttribute("listAllArtists", listAllArtist);

		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");

		rd.forward(request, response);
	}

	// Novo Contato - /artistregister:

	protected void addArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		artist.setNome(request.getParameter("name"));
		artist.setEmail(request.getParameter("email"));
		artist.setSexo(request.getParameter("gender"));
		artist.setDatadenascimento(request.getParameter("birthday"));
		artist.setNacionalidade(request.getParameter("nationality"));
		artist.setCpf(request.getParameter("cpf"));

		dao.addArtistDb(artist);

		response.sendRedirect("main");
	}

	//

	// Editar Contato /select:

	protected void selectArtistEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String idArtist = request.getParameter("idArtist");

		artist.setIdArtist(idArtist);

		dao.selectArtistDb(artist);

		request.setAttribute("idArtist", artist.getIdArtist());
		request.setAttribute("name", artist.getNome());
		request.setAttribute("email", artist.getEmail());
		request.setAttribute("gender", artist.getSexo());
		request.setAttribute("birthday", artist.getDatadenascimento("br"));
		request.setAttribute("nationality", artist.getNacionalidade());
		request.setAttribute("cpf", artist.getCpf());

		RequestDispatcher rd = request.getRequestDispatcher("artistedit.jsp");

		rd.forward(request, response);
	}

	// EDITAR CONTATO /editartist:

	protected void editArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		artist.setIdArtist(request.getParameter("idartist"));
		artist.setNome(request.getParameter("name"));
		artist.setEmail(request.getParameter("email"));
		artist.setSexo(request.getParameter("gender"));
		artist.setDatadenascimento(request.getParameter("birthday"));
		artist.setNacionalidade(request.getParameter("nationality"));
		artist.setCpf(request.getParameter("cpf"));

		dao.editArtistDb(artist);

		response.sendRedirect("main");
	}

	//

	// selectArtist - /artist:

	protected void selectArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		String idArtist = request.getParameter("idArtist");

		artist.setIdArtist(idArtist);

		dao.selectArtistDb(artist);

		request.setAttribute("idArtist", artist.getIdArtist());
		request.setAttribute("name", artist.getNome());
		request.setAttribute("email", artist.getEmail());
		request.setAttribute("gender", artist.getSexo());
		request.setAttribute("birthday", artist.getDatadenascimento("br"));
		request.setAttribute("nationality", artist.getNacionalidade());
		request.setAttribute("cpf", (artist.getCpf() == null ? "Don't have!" : artist.getCpf()));

		RequestDispatcher rd = request.getRequestDispatcher("artist.jsp");

		rd.forward(request, response);
	}

	// REMOVER CONTATO - /deleteArtist:

	protected void deleteArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String idArtist = request.getParameter("idArtist");

		artist.setIdArtist(idArtist);

		dao.deleteArtistDb(artist);

		response.sendRedirect("main");
	}

	//

	// Search - /search:

	protected void searcher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String searcher = request.getParameter("text");
		System.out.println(request.getParameter("text"));

		searcherMain.setSeacher(searcher);

		ArrayList<Artists> listAllArtist = dao.searcher(searcherMain);

		request.setAttribute("listAllArtists", listAllArtist);

		request.setAttribute("searcher", searcher);

		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");

		rd.forward(request, response);

	}

	//

	// ADD ART - /artregister:

	protected void addArt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		art.setName(request.getParameter("name"));
		art.setDescription(request.getParameter("description"));
		art.setDataDePublicacao(request.getParameter("publicationdate"));
		art.setDataDeExposicao(request.getParameter("exposuredate"));
		art.setIdartist(request.getParameter("idartist"));

		dao.inserirArt(art);

		request.setAttribute("name", art.getName());
		request.setAttribute("description", art.getDescription());
		request.setAttribute("publicationdate", art.getDataDePublicacao("br"));
		request.setAttribute("exposuredate", art.getDataDeExposicao("br"));
		request.setAttribute("idartist", art.getIdartist());

		RequestDispatcher rd = request.getRequestDispatcher("art.jsp");

		rd.forward(request, response);
	}
}

//OBS.: PARA GERAR O JAVA DOC É SO CLICAR COM O BOTAO DIREITO MOUSE NA ULTIMA LINHA
//DE CADA ARQUIVO .JAVA E GERAR!
