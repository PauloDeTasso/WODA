
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
import model.BooleansTests;
import model.ConnectionDB;
import model.IdsArtsArtist;
import model.NamesArtsArtist;
import model.Searcher;

@WebServlet(urlPatterns =
{ "/main", "/artistregister", "/selectartistedit", "/editartist", "/deleteartist", "/deleteart", "/artregister",
		"/artist", "/searchartist", "/addart", "/artedit", "/art", "/searcharts", "/addartist", "/removeassociate",
		"/tests"
})

public class MainController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	ConnectionDB dao = new ConnectionDB();

	Artists artist = new Artists();

	Arts art = new Arts();

	Associates associated = new Associates();

	Searcher searcherMain = new Searcher();

	NamesArtsArtist nameArtsArtist = new NamesArtsArtist();

	BooleansTests decision = new BooleansTests();

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

		} else if (action.equals("/searcharts"))
		{
			searchArts(request, response);

		} else if (action.equals("/removeassociate"))
		{
			removeAssociate(request, response);

		} else if (action.equals("/addartist"))
		{
			selectArtsArtist(request, response);

		} else if (action.equals("/tests"))
		{
			tests(request, response);

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

		} else if (action.equals("/artregister"))
		{
			addArt(request, response);

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
		ArrayList<Artists> listAllArtists = dao.selectAllArtistsNameDb();
		request.setAttribute("listAllArtists", listAllArtists);

		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");

		rd.forward(request, response);
	}

	// ADD ARTIST - /artistregister:

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

		//
		String associatesOn = request.getParameter("associates");

		String checkedArtsIds[] = (request.getParameterValues("checkallidsarts") == null) ? new String[] {}
				: request.getParameterValues("checkallidsarts");

		// SETAR ID DO ARTISTA DA NOVA ARTE NA CLASSE PROPRIEDADE:
		// associated.setIdArtist(Long.parseLong(artist.getIdArtist()));

		// FORMA UM OBJETO COM TODAS AS ARTES CADASTRADAS
		ArrayList<Artists> listAllArtistsId = dao.listAllArtistsIdDb();

		// PEGA A ULTIMA ID DO ARTISTA CADASTRADO NO BANCO E SETA NA CLASSE DE
		// PROPRIEDADES:
		associated.setIdArtist(Long.parseLong(listAllArtistsId.get(0).getIdArtist()));
		artist.setIdArtist(listAllArtistsId.get(0).getIdArtist());

		// SELECIONA TODAS AS ARTES PELO NOME:
		ArrayList<NamesArtsArtist> checkNamesArts = new ArrayList<>();

		// CADASTRA A PROPRIEDADE DA NOVA ARTE PARA O ARTISTAS EXTRAS:
		for (int i = 0; i < checkedArtsIds.length; i++)
		{
			dao.addAssociatesArtistExtrasDb(associated, Integer.parseInt(checkedArtsIds[i]));
			dao.checkNamesArtsDb(checkNamesArts, Integer.parseInt(checkedArtsIds[i]));
		}

		// CADASTRA A PROPRIEDADE DA NOVA ARTE PARA O ARTISTA PRINCIPAL
		// dao.addAssociates(associated);

		request.setAttribute("associatesOn", associatesOn);

		request.setAttribute("checkedIds", checkedArtsIds);

		request.setAttribute("checkedNames", checkNamesArts);

		//

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

		//
		ArrayList<Arts> listAllArts = dao.listAllArtsOrderIdDb();

		//

		ArrayList<IdsArtsArtist> listAllIdsArtsForIdArtist = dao.listAllIdsArtsForIdArtistDb(idArtist);

		request.setAttribute("listAllIdsArtsForIdArtist", listAllIdsArtsForIdArtist);

		//

		ArrayList<NamesArtsArtist> listAllArtsNamesForIdArtist = new ArrayList<>();

		for (int i = 0; i < listAllIdsArtsForIdArtist.size(); i++)
		{
			dao.listAllArtsNamesForIdArtistDb(listAllArtsNamesForIdArtist, listAllIdsArtsForIdArtist.get(i).getIdArt());
		}
		/*-
				for (int i = 0; i < listAllArtsNamesForIdArtist.size(); i++)
				{
					System.out.println("listAllArtsNamesForIdArtist");
					System.out.println(listAllArtsNamesForIdArtist.get(i).getNameArt());
					System.out.println("------");
				}
		
				for (int i = 0; i < listAllArts.size(); i++)
				{
					System.out.println("listAllArts");
					System.out.println(listAllArts.get(i).getName());
					System.out.println("------");
				}
		*/
		// request.setAttribute("listAllArtsNamesForIdArtist",
		// listAllArtsNamesForIdArtist);

		//

		String nomeDaVez;

		//

		for (int i = 0; i < listAllArtsNamesForIdArtist.size(); i++)
		{
			nomeDaVez = listAllArtsNamesForIdArtist.get(i).getNameArt();

			for (int i2 = 0; i2 < listAllArts.size(); i2++)
			{

				if (listAllArts.get(i2).getName().equals(nomeDaVez))
				{
					listAllArts.remove(i2);
				}
			}
		}

		request.setAttribute("listAllArts", listAllArts);

		request.setAttribute("listAllIdsArtsForIdArtist", listAllIdsArtsForIdArtist);

		request.setAttribute("listAllArtsNamesForIdArtist", listAllArtsNamesForIdArtist);

		////////
		// ArrayList<Arts> listAllArtsForName = dao.listAllArtsForName();

		// request.setAttribute("listAllArtsForName", listAllArtsForName);

		//

		// dao.listArtsOfArtistForID(idArtist);

		//

		///////
		/*-
			
		*/
		//

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
		// EDITA ARTISTA:
		artist.setIdArtist(request.getParameter("idartist"));
		artist.setNome(request.getParameter("name"));
		artist.setEmail(request.getParameter("email"));
		artist.setSexo(request.getParameter("gender"));
		artist.setDatadenascimento(request.getParameter("birthday"));
		artist.setNacionalidade(request.getParameter("nationality"));
		artist.setCpf(request.getParameter("cpf"));

		dao.editArtistDb(artist);

		// EDITA ASSOCIADOS:

		// SETAR ID DO ARTISTA DA NOVA ARTE NA CLASSE PROPRIEDADE:
		associated.setIdArtist(Long.parseLong(artist.getIdArtist()));

		String associatesOn = request.getParameter("associates");

		String associatesedit = request.getParameter("associatesedit");

		String checkedArtsIds[] = (request.getParameterValues("checkallids") == null) ? new String[] {}
				: request.getParameterValues("checkallids");

		String checkallidsedit[] = (request.getParameterValues("checkallidsedit") == null) ? new String[] {}
				: request.getParameterValues("checkallidsedit");

		String nameDaVez;

		ArrayList<IdsArtsArtist> listIdsArtsForIdArtist = dao.listIdsArtsByIdArtistOrderIdDescDb(artist.getIdArtist());

		if (associatesedit.equals("YES"))
		{

			for (int i = 0; i < checkallidsedit.length; i++)
			{
				nameDaVez = checkallidsedit[i];

				for (int x = 0; x < listIdsArtsForIdArtist.size(); x++)
				{

					if (listIdsArtsForIdArtist.get(x).getIdArt().toString().equals(nameDaVez))
					{
						listIdsArtsForIdArtist.remove(x);
					}
				}
			}

			// REMOVE A PROPRIEDADE DAS ARTES NÃO SELECIONADAS:
			for (int i = 0; i < listIdsArtsForIdArtist.size(); i++)
			{
				dao.removeAssociatesArtistExtrasDb(associated, listIdsArtsForIdArtist.get(i).getIdArt());
			}
		}

		// FORMA UM OBJETO COM TODAS AS ARTES CADASTRADAS
		// ArrayList<Artists> listAllArtistsId = dao.listAllArtistsIdDb();

		// PEGA A ULTIMA ID DO ARTISTA CADASTRADO NO BANCO E SETA NA CLASSE DE
		// PROPRIEDADES:
		// associated.setIdArtist(Long.parseLong(listAllArtistsId.get(0).getIdArtist()));
		// artist.setIdArtist(listAllArtistsId.get(0).getIdArtist());

		// SELECIONA TODAS AS ARTES PELO NOME:
		// ArrayList<NamesArtsArtist> checkNamesArts = new ArrayList<>();

		// CADASTRA A PROPRIEDADE DA NOVA ARTE PARA O ARTISTAS EXTRAS:
		for (int i = 0; i < checkedArtsIds.length; i++)
		{
			dao.addAssociatesArtistExtrasDb(associated, Integer.parseInt(checkedArtsIds[i]));
			// dao.checkNamesArtsDb(checkNamesArts, Integer.parseInt(checkedArtsIds[i]));
		}

		// CADASTRA A PROPRIEDADE DA NOVA ARTE PARA O ARTISTA PRINCIPAL
		// dao.addAssociates(associated);

		// request.setAttribute("associatesOn", associatesOn);

		// request.setAttribute("checkedIds", checkedArtsIds);

		// request.setAttribute("checkedNames", checkNamesArts);

		//

		response.sendRedirect("main");
	}

	//

	// selectArtist - /artist:

	protected void selectArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String idArtist = request.getParameter("idartist");

		artist.setIdArtist(idArtist);

		dao.selectArtistDb(artist);

		request.setAttribute("idArtist", artist.getIdArtist());
		request.setAttribute("name", artist.getNome());
		request.setAttribute("email", artist.getEmail());
		request.setAttribute("gender", artist.getSexo());
		request.setAttribute("birthday", artist.getDatadenascimento("br"));
		request.setAttribute("nationality", artist.getNacionalidade());
		request.setAttribute("cpf", (artist.getCpf() == null ? "Don't have!" : artist.getCpf()));

		// SELECIONA TODAS OS IDS DAS ARTES PELO ID DO ARTISTA:
		ArrayList<IdsArtsArtist> listIdsArtsByIdArtistOrderIdDesc = dao.listIdsArtsByIdArtistOrderIdDescDb(idArtist);

		// SELECIONA TODAS AS ARTES PELO ID DE CADA ART
		ArrayList<Arts> listArtAllByIdArtOrderIdDesc = new ArrayList<>();

		// SELECIONA TODOS OS ID DOS ARTISTAS PELO O ID DE ARTE:
		ArrayList<IdsArtsArtist> listIdsArtistByIdArt = new ArrayList<>();

		for (int i = 0; i < listIdsArtsByIdArtistOrderIdDesc.size(); i++)
		{
			dao.listArtAllByIdArtOrderIdDescDb(listArtAllByIdArtOrderIdDesc,
					listIdsArtsByIdArtistOrderIdDesc.get(i).getIdArt());

			dao.listIdsArtistByIdArtDb(listIdsArtistByIdArt, "", listIdsArtsByIdArtistOrderIdDesc.get(i).getIdArt());
		}

		// SELECIONA TODOS OS ARTISTAS PELO ID DE CADA ARTISTA:
		ArrayList<Artists> listArtistAllByIdArtist = new ArrayList<>();

		for (int i = 0; i < listIdsArtistByIdArt.size(); i++)
		{
			dao.listArtistAllByIdArtistDb(listArtistAllByIdArtist, "", listIdsArtistByIdArt.get(i).getIdArt());
		}

		//

		request.setAttribute("listAllArtsArtist", listArtAllByIdArtOrderIdDesc);

		request.setAttribute("listArtistAllByIdArtist", listArtistAllByIdArtist);

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

		response.sendRedirect("searcharts");
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

		String associatesOn = request.getParameter("associates");

		String checkedIds[] = (request.getParameterValues("checkallids") == null) ? new String[] {}
				: request.getParameterValues("checkallids");

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

		// FORMA UM OBJETO COM TODAS AS ARTES CADASTRADAS
		ArrayList<Arts> listAllArts = dao.listAllArtsOrderIdDb();

		// PEGA A ULTIMA ID DA ARTE CADASTRADA NO BANCO E SETA NA CLASSE DE PROPRIEDADE
		associated.setIdArt(listAllArts.get(0).getIdart());
		art.setIdart(listAllArts.get(0).getIdart());

		// CADASTRA A PROPRIEDADE DA NOVA ARTE PARA O ARTISTA PRINCIPAL
		dao.addAssociates(associated);

		// SELECIONA TODAS AS ARTES PELO NOME:
		ArrayList<NamesArtsArtist> checkNamesArtist = new ArrayList<>();

		// CADASTRA A PROPRIEDADE DA NOVA ARTE PARA O ARTISTAS EXTRAS:
		for (int i = 0; i < checkedIds.length; i++)
		{
			dao.addAssociatesArtsExtrasDb(associated, Integer.parseInt(checkedIds[i]));
			dao.listNamesArtistByIdArtistDb(checkNamesArtist, checkedIds[i]);
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

		request.setAttribute("checkedNames", checkNamesArtist);

		RequestDispatcher rd = request.getRequestDispatcher("artregistered.jsp");

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
		ArrayList<Artists> listAllArtists = dao.selectAllArtistsNameDb();

		request.setAttribute("listAllArtists", listAllArtists);

		request.setAttribute("artistName", artist.getNome());

		RequestDispatcher rd = request.getRequestDispatcher("artregister.jsp");

		rd.forward(request, response);
	}

	//

	//

	protected void artEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ArrayList<Artists> listAllArtist = dao.selectAllArtistsNameDb();

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

		ArrayList<IdsArtsArtist> idsArtistsForIdArt = new ArrayList<>();

		dao.listIdsArtistByIdArtDb(idsArtistsForIdArt, idArt, (long) -1);

		ArrayList<Artists> listAllArtistForIdArtist = new ArrayList<>();

		for (int i = 0; i < idsArtistsForIdArt.size(); i++)
		{
			dao.listArtistAllByIdArtistDb(listAllArtistForIdArtist, "", idsArtistsForIdArt.get(i).getIdArt());
		}

		request.setAttribute("Art", listArt);

		request.setAttribute("listAllArtistForIdArtist", listAllArtistForIdArtist);

		RequestDispatcher rd = request.getRequestDispatcher("art.jsp");

		rd.forward(request, response);
	}

	//

	// SEARCH ART : /searcharts

	protected void searchArts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String searchArt = (request.getParameter("text") == null) ? "" : request.getParameter("text");

		searcherMain.setSeacher(searchArt);

		ArrayList<Arts> listAllArts = dao.setSeacherArtDb(searcherMain);

		/*-
		ArrayList<IdsArtsArtist> listIdsArtistForIdArt = new ArrayList<>();
		
		for (int i = 0; i < listAllArts.size(); i++)
		{
			dao.listIdsArtistForIdArtDb(listIdsArtistForIdArt, listAllArts.get(i).getIdart());
			System.out.println("ID ARTS SEARCHER: " + " - (i)=" + i + listAllArts.get(i).getIdart());
		}
		 */
		/*-
		ArrayList<IdsArtsArtist> listIdsArtistForIdArt = new ArrayList<>();
		
		for (int i = 0; i < listAllArts.size(); i++)
		{
			dao.listIdsArtistForIdArtDb(listIdsArtistForIdArt, listAllArts.get(i).getIdart());
			System.out.println("ID ARTS SEARCHER: " + " - (i)=" + i + listAllArts.get(i).getIdart());
		}
		
		ArrayList<Artists> listAllArtistForId = new ArrayList<>();
		
		for (int i = 0; i < listIdsArtistForIdArt.size(); i++)
		{
			dao.listAllArtistForIdDb(listAllArtistForId, listIdsArtistForIdArt.get(i).getIdArt());
			System.out.println("ID ARTISTS: " + " - (i)=" + i + listIdsArtistForIdArt.get(i).getIdArt());
		
		}
		
		for (int i = 0; i < listAllArtistForId.size(); i++)
		{
			System.out.println(listAllArtistForId.get(i).getIdArtist());
			System.out.println(listAllArtistForId.get(i).getNome());
			System.out.println(listAllArtistForId.get(i).getEmail());
			System.out.println(listAllArtistForId.get(i).getSexo());
			System.out.println(listAllArtistForId.get(i).getNacionalidade());
			System.out.println(listAllArtistForId.get(i).getDatadenascimento());
			System.out.println(listAllArtistForId.get(i).getCpf());
		}
		
		request.setAttribute("listAllArtistForId", listAllArtistForId);
		*/

		request.setAttribute("listAllArts", listAllArts);

		request.setAttribute("searchArt", searchArt);

		RequestDispatcher rd = request.getRequestDispatcher("artsearch.jsp");

		rd.forward(request, response);
	}

	//

	// ADD ARTIST FORM : /addartist

	protected void selectArtsArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		ArrayList<Arts> listAllArtsOrderName = dao.listArtsAllOrderNameDb();

		request.setAttribute("listAllArtsOrderName", listAllArtsOrderName);

		RequestDispatcher rd = request.getRequestDispatcher("artistregister.jsp");

		rd.forward(request, response);
	}

	//

	// removeAssociate : /removeAssociate

	protected void removeAssociate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String idArtist = request.getParameter("idartist");
		String idArt = request.getParameter("idart");

		dao.removeAssociateDb(idArtist, idArt);

		boolean delete = true;

		delete = dao.listAssociateDb(idArt);

		if (delete == true)
		{
			dao.deleteArtForIdDb(idArt);
		}

		response.sendRedirect("artist?idartist=" + idArtist);
	}

	//

	// removeAssociate : /removeAssociate

	protected void tests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter("id");
		System.out.println("entrada: " + id);

		boolean delete = true;

		delete = dao.tests(id);

		System.out.println("Fora delete: " + delete);

	}
	/*-
	//
	// throw
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
	 */
}

//OBS.: PARA GERAR O JAVA DOC É SO CLICAR COM O BOTAO DIREITO MOUSE NA ULTIMA LINHA
//DE CADA ARQUIVO .JAVA E GERAR!
