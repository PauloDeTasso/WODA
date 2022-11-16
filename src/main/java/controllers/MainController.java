
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
import model.Associates;
import model.ConnectionDB;
import model.IdsArtsArtist;
import model.Searcher;

@WebServlet(urlPatterns =
{ "/main", "/artistregister", "/selectartistedit", "/editartist", "/deleteartist", "/deleteart", "/artregister",
		"/artist", "/searchartist", "/addart", "/artedit", "/art", "/searcharts"
})

public class MainController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	ConnectionDB dao = new ConnectionDB();

	Artists artist = new Artists();

	Arts art = new Arts();

	Associates associated = new Associates();

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
		System.out.println("doGet");

		if (action.equals("/main"))
		{
			selectAll(request, response);

			// response.sendRedirect("home.html");

		} else if (action.equals("/artistregister"))
		{
			addArtist(request, response);

		} else if (action.equals("/selectartistedit"))
		{
			selectArtistEdit(request, response);

		} else if (action.equals("/deleteartist"))
		{
			deleteArtist(request, response);

		} else if (action.equals("/deleteart"))
		{
			deleteArt(request, response);

		} else if (action.equals("/artregister"))
		{
			addArt(request, response);

		} else if (action.equals("/artist"))
		{
			selectArtist(request, response);

		} else if (action.equals("/searchartist"))
		{
			searchArtist(request, response);

		} else if (action.equals("/addart"))
		{
			artRegister(request, response);

		} else if (action.equals("/art"))
		{
			art(request, response);

		} else if (action.equals("/art"))
		{
			art(request, response);

		} else if (action.equals("/searcharts"))
		{
			searchArts(request, response);

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

		if (action.equals(""))
		{

		} else if (action.equals("/editartist"))
		{
			editArtist(request, response);

		} else
		{
			response.sendRedirect("index.html");
		}

	}

	//
	// selectAllArtist - /main:

	protected void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ArrayList<Artists> listAllArtists = dao.selectAllArtistsDb();
		request.setAttribute("listAllArtists", listAllArtists);

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

	// Editar Contato /selectartistedit:

	protected void selectArtistEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String idArtist = request.getParameter("idartist");

		artist.setIdArtist(idArtist);

		dao.selectArtistDb(artist);

		request.setAttribute("idArtist", artist.getIdArtist());
		request.setAttribute("name", artist.getNome());
		request.setAttribute("email", artist.getEmail());
		request.setAttribute("gender", artist.getSexo());
		request.setAttribute("birthday", artist.getDatadenascimento());
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

		// SELECIONAR TODOS OS ARTISTAS:
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

		// SELECIONAR TODAS AS ARTS:
		ArrayList<Arts> listAllArts = dao.listAllArtsDb();

		request.setAttribute("listAllArts", listAllArts);

		// SELECIONA TODAS AS ARTES PELO ID DO ARTISTA:
		ArrayList<IdsArtsArtist> listIdsArtsArtist = dao.listIdsArtsArtistDb(idArtist);

		//

		// ArrayList<Arts> listAllArtsArtist =
		// dao.listAllArtsArtistDb(listIdsArtsArtist);;

		ArrayList<Arts> listAllArtsArtist = new ArrayList<>();

		for (int i = 0; i < listIdsArtsArtist.size(); i++)
		{
			dao.addAllArtsArtist(listIdsArtsArtist.get(i).getIdArt(), listAllArtsArtist);
			/*-
						for (int i2 = 0; i2 < listIdsArtsArtist.size(); i++)
						{
							System.out.println("get(i) ALL:");
							System.out.println(listAllArtsArtist.get(i2).getIdart());
							System.out.println(listAllArtsArtist.get(i2).getName());
							System.out.println(listAllArtsArtist.get(i2).getDescription());
							System.out.println(listAllArtsArtist.get(i2).getDataDePublicacao());
							System.out.println(listAllArtsArtist.get(i2).getDataDeExposicao());
							System.out.println(" *--* ");
						}
			*/
		}

		request.setAttribute("listAllArtsArtist", listAllArtsArtist);

		// SELECIONA TODAS AS ARTES PELO NOME:
		// ArrayList<NamesArtsArtist> listNamesArtsArtist =
		// dao.listNamesArtsArtistDb(listIdsArtsArtist);

		//

		RequestDispatcher rd = request.getRequestDispatcher("artist.jsp");

		rd.forward(request, response);
	}

	//

	// DELETE ARTIST - /deleteArtist:

	protected void deleteArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String idArtist = request.getParameter("idartist");

		artist.setIdArtist(idArtist);

		dao.deleteArtistDb(artist);

		response.sendRedirect("main");
	}

	//

	// DELETE ART - /deleteArt:

	protected void deleteArt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Long idArt = Long.parseLong(request.getParameter("idart"));

		art.setIdart(idArt);

		dao.deleteArtDb(art);

		response.sendRedirect("main");
	}

	//

	// Search - /search:

	protected void searchArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String searchArtist = (request.getParameter("text") == null) ? "" : request.getParameter("text");

		searcherMain.setSeacher(searchArtist);

		ArrayList<Artists> listAllArtist = dao.setSeacherArtistDb(searcherMain);

		request.setAttribute("listAllArtists", listAllArtist);

		request.setAttribute("searchArtist", searchArtist);

		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");

		rd.forward(request, response);

	}

	//

	// ADD ART - /artregister:

	protected void addArt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// SETAR DADOS DA ART:
		art.setName(request.getParameter("name"));
		art.setDescription(request.getParameter("description"));
		art.setDataDePublicacao(request.getParameter("publicationdate"));
		art.setDataDeExposicao(request.getParameter("exposuredate"));

		// CADASTRAR NA TABELA ART DO BANCO

		String dateType = request.getParameter("datetype");

		dao.addArtDb(art, dateType);

		// SETAR ID DO ARTISTA DA NOVA ARTE NA CLASSE PROPRIEDADE:
		associated.setIdArtist(Long.parseLong(artist.getIdArtist()));

		// SETAR ID DO ARTISTA DA NOVA ARTE NA TABELA PROPRIEDADE:
		associated.setIdArtist(Long.parseLong(artist.getIdArtist()));

		// FORMA OBJETO COM TODAS AS ARTES CADASTRADAS
		ArrayList<Arts> listAllArts = dao.listAllArtsDb();

		// PEGA A ULTIMA ID DA ARTE CADASTRADA NO BANCO E SETA NA CLASSE DE PROPRIEDADE
		associated.setIdArt(listAllArts.get(0).getIdart());

		/*-
		for (int i = 0; i < listAllArts.size(); i++)
		{
			System.out.println(listAllArts.get(i).getIdart());
		}
		*/

		// CADASTRA A PROPRIEDADE DA NOVA ARTE PARA O ARTISTA PRINCIPAL
		dao.addAssociates(associated);

		// CADASTRA A PROPRIEDADE DA NOVA ARTE PARA O ARTISTAS EXTRAS

		String associatesOn = request.getParameter("associates");

		String checkedIds[] = request.getParameterValues("checkallids");

		String checkedNames[] = request.getParameterValues("checkallnames");

		if (associatesOn.equals("YES"))
		{

			for (int i = 0; i < checkedIds.length; i++)
			{
				dao.addAssociatesExtras(associated, Integer.parseInt(checkedIds[i]));
			}

		}

		request.setAttribute("idArt", art.getIdart());
		request.setAttribute("nameArt", art.getName());
		request.setAttribute("description", art.getDescription());
		request.setAttribute("publicationdate", art.getDataDePublicacao("br"));
		request.setAttribute("exposuredate", art.getDataDeExposicao("br"));

		request.setAttribute("idArtist", artist.getIdArtist());
		request.setAttribute("nameArtist", artist.getNome());

		request.setAttribute("associatesOn", associatesOn);

		request.setAttribute("checkedIds", checkedIds);
		request.setAttribute("checkedNames", checkedNames);

		RequestDispatcher rd = request.getRequestDispatcher("art.jsp");

		rd.forward(request, response);

		// rd.include(request, response);
		// USAR DENTRO DO JSP PARA O SERVLET
		// o método include passa para o servlet a solicitação e a resposta,
		// processa seu servlet e retorna para processar seu jsp após esse ponto
		// rd.include(request, response);

	}

	//

	// ART REGISTER - /addart:

	protected void artRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		/*-
		System.out.println(artist.getIdArtist());
		System.out.println(artist.getNome());
		System.out.println(artist.getEmail());
		System.out.println(artist.getSexo());
		System.out.println(artist.getDatadenascimento("br"));
		System.out.println(artist.getNacionalidade());
		System.out.println(artist.getCpf());
		*/
		// art.setName(request.getParameter("name"));

		// ArrayList<Associates> listAllArtist;

		// associated.setIdArtist(Long.parseLong(request.getParameter("id")));

		ArrayList<Artists> listAllArtist = dao.selectAllArtistsDb();

		request.setAttribute("listAllArtists", listAllArtist);

		request.setAttribute("artistName", artist.getNome());

		RequestDispatcher rd = request.getRequestDispatcher("artregister.jsp");

		rd.forward(request, response);
	}

	//

	//

	protected void artEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ArrayList<Artists> listAllArtist = dao.selectAllArtistsDb();

		request.setAttribute("listAllArtists", listAllArtist);

		request.setAttribute("artistName", artist.getNome());

		RequestDispatcher rd = request.getRequestDispatcher("artedit.jsp");

		rd.forward(request, response);
	}

	//

	//

	protected void art(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String idArt = request.getParameter("idart");

		art.setIdart(Long.parseLong(idArt));

		ArrayList<Arts> listArt = dao.selectArtDb(art);

		request.setAttribute("Art", listArt);

		RequestDispatcher rd = request.getRequestDispatcher("art.jsp");

		rd.forward(request, response);
	}

	//

	// SEARCH ART : /searcharts

	protected void searchArts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String searchArt = (request.getParameter("text") == null) ? "" : request.getParameter("text");

		System.out.println("searchArt: " + searchArt);

		searcherMain.setSeacher(searchArt);

		ArrayList<Arts> listAllArts = dao.setSeacherArtDb(searcherMain);

		request.setAttribute("listAllArts", listAllArts);

		request.setAttribute("searchArt", searchArt);

		RequestDispatcher rd = request.getRequestDispatcher("artsearch.jsp");

		rd.forward(request, response);
	}

	//

	public void teste()
	{
		String frase = null;
		String novaFrase = null;

		try
		{
			novaFrase = frase.toUpperCase();
		}

		catch (NullPointerException e)
		{
			System.out.println(
					"O frase inicial está nula, para solucional tal o problema, foi lhe atribuito um valor default.");
			frase = "Frase vazia";
		}

		finally
		{
			novaFrase = frase.toUpperCase();
		}
		System.out.println("Frase antiga: " + frase);
		System.out.println("Frase nova: " + novaFrase);
	};

}

//OBS.: PARA GERAR O JAVA DOC É SO CLICAR COM O BOTAO DIREITO MOUSE NA ULTIMA LINHA
//DE CADA ARQUIVO .JAVA E GERAR!
