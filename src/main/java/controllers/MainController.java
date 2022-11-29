
package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import model.Artists;
import model.Arts;
import model.Associates;
import model.Authentication;
import model.BooleansTests;
import model.ConnectionDB;
import model.IdsArtsArtist;
import model.NamesArtsArtist;
import model.Searcher;

@WebServlet(urlPatterns =
{ "/main", "/artistregister", "/selectartistedit", "/editartist", "/deleteartist", "/deleteart", "/artregister",
		"/artist", "/searchartist", "/addart", "/artedit", "/art", "/searcharts", "/addartist", "/removeassociate",
		"/tests", "/arteditselect", "/artistsearch", "/userauthenticate", "/users", "/useradd", "/useredit",
		"/userremove", "/userselect"
})

public class MainController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	ConnectionDB dao = new ConnectionDB();

	Artists artist = new Artists();

	Arts art = new Arts();

	Associates associated = new Associates();

	Searcher searcherMain = new Searcher();

	Authentication authentication = new Authentication();

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

		if (action.equals("/artistsearch"))
		{
			selectAll(request, response);

		} else if (action.equals("/main"))
		{
			response.sendRedirect("home.jsp");

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
			selectArtRegister(request, response);

		} else if (action.equals("/art"))
		{
			art(request, response);

		} else if (action.equals("/arteditselect"))
		{
			selectArtEdit(request, response);

		} else if (action.equals("/searcharts"))
		{
			searchArts(request, response);

		} else if (action.equals("/removeassociate"))
		{
			removeAssociate(request, response);

		} else if (action.equals("/addartist"))
		{
			selectArtsArtist(request, response);

		} else if (action.equals("/addartist"))
		{
			selectArtsArtist(request, response);

		} else if (action.equals("/users"))
		{
			users(request, response);

		} else if (action.equals("/userremove"))
		{
			userDelete(request, response);

		} else if (action.equals("/userselect"))
		{
			userSelect(request, response);

		} else
		{
			response.sendRedirect("index.html");
		}
	}

	//

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();

		if (action.equals(""))
		{

		} else if (action.equals("/artistregister"))
		{
			addArtist(request, response);

		} else if (action.equals("/editartist"))
		{
			editArtist(request, response);

		} else if (action.equals("/artregister"))
		{
			addArt(request, response);

		} else if (action.equals("/artedit"))
		{
			artEdit(request, response);

		} else if (action.equals("/userauthenticate"))
		{
			userAuthenticate(request, response);

		} else if (action.equals("/useradd"))
		{
			userAdd(request, response);

		} else if (action.equals("/useredit"))
		{
			userEdit(request, response);

		} else
		{
			response.sendRedirect("index.html");
		}

	}

	//

	protected void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ArrayList<Artists> listArtistsAllOrderName = dao.listArtistsAllOrderNameDb();
		request.setAttribute("listArtistsAllOrderName", listArtistsAllOrderName);

		RequestDispatcher rd = request.getRequestDispatcher("artistsearch.jsp");

		rd.forward(request, response);
	}

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

		String associatesOn = request.getParameter("associates");

		String checkedArtsIds[] = (request.getParameterValues("checkallidsarts") == null) ? new String[] {}
				: request.getParameterValues("checkallidsarts");

		ArrayList<Artists> listAllArtistsId = dao.listAllArtistsOrderIdDescDb();

		associated.setIdArtist(Long.parseLong(listAllArtistsId.get(0).getIdArtist()));
		artist.setIdArtist(listAllArtistsId.get(0).getIdArtist());

		ArrayList<NamesArtsArtist> checkNamesArts = new ArrayList<>();

		if (associatesOn.equals("YES") && checkedArtsIds.length >= 1)
		{

			for (int i = 0; i < checkedArtsIds.length; i++)
			{
				dao.AddArtsExtrasAssociatesForArtistDb(associated, Integer.parseInt(checkedArtsIds[i]));
				dao.checkNamesArtsDb(checkNamesArts, Integer.parseInt(checkedArtsIds[i]));
			}
		}

		request.setAttribute("associatesOn", associatesOn);

		request.setAttribute("checkedIds", checkedArtsIds);

		request.setAttribute("checkedNames", checkNamesArts);

		response.sendRedirect("artist?idartist=" + artist.getIdArtist());
	}

	//

	protected void selectArtistEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String idArtist = request.getParameter("idartist");

		artist.setIdArtist(idArtist);

		dao.selectArtistDb(artist);

		ArrayList<Arts> listAllArts = dao.listArtsAllOrderIdDescDb();

		ArrayList<IdsArtsArtist> listAllIdsArtsByIdArtist = dao.listAllIdsArtsForIdArtistDb(idArtist);

		ArrayList<NamesArtsArtist> listAllArtsNamesByIdArtist = new ArrayList<>();

		for (int i = 0; i < listAllIdsArtsByIdArtist.size(); i++)
		{
			dao.listAllArtsNamesForIdArtistDb(listAllArtsNamesByIdArtist, listAllIdsArtsByIdArtist.get(i).getIdArt());
		}

		String nomeDaVez;

		for (int i = 0; i < listAllArtsNamesByIdArtist.size(); i++)
		{
			nomeDaVez = listAllArtsNamesByIdArtist.get(i).getNameArt();

			for (int x = 0; x < listAllArts.size(); x++)
			{

				if (listAllArts.get(x).getName().equals(nomeDaVez))
				{
					listAllArts.remove(x);
				}
			}
		}

		ArrayList<Artists> listArtistsAllOrderName = dao.listArtistsAllOrderNameDb();

		for (int i = 0; i < listArtistsAllOrderName.size(); i++)
		{

			if (listArtistsAllOrderName.get(i).getEmail().equals(artist.getEmail()))
			{
				listArtistsAllOrderName.remove(i);
			}
		}

		request.setAttribute("listArtistsAllOrderName", listArtistsAllOrderName);

		request.setAttribute("listAllIdsArtsByIdArtist", listAllIdsArtsByIdArtist);

		request.setAttribute("listAllArts", listAllArts);

		request.setAttribute("listAllArtsNamesByIdArtist", listAllArtsNamesByIdArtist);

		request.setAttribute("artist", artist);

		RequestDispatcher rd = request.getRequestDispatcher("artistedit.jsp");

		rd.forward(request, response);
	}

	//

	protected void selectArtEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		String idArt = request.getParameter("idart");

		String artistName = (request.getParameter("artistname") == null) ? "" : request.getParameter("artistname");

		art.setIdart(Long.parseLong(idArt));

		artist.setNome(artistName);

		ArrayList<Arts> listArtByIdArt = dao.listArtByIdArtDb(art);

		ArrayList<Artists> listAllArtistsOrderIdDesc = dao.listAllArtistsOrderIdDescDb();

		ArrayList<IdsArtsArtist> listIdsArtistByIdArt = new ArrayList<>();

		dao.listIdsArtistByIdArtDb(listIdsArtistByIdArt, idArt, (long) -1);

		ArrayList<NamesArtsArtist> listNamesArtistByIdArtist = new ArrayList<>();

		for (int i = 0; i < listIdsArtistByIdArt.size(); i++)
		{
			dao.listNamesArtistByIdArtistDb(listNamesArtistByIdArtist,
					listIdsArtistByIdArt.get(i).getIdArt().toString());
		}

		String nomeDaVez;

		for (int i = 0; i < listNamesArtistByIdArtist.size(); i++)
		{
			nomeDaVez = listNamesArtistByIdArtist.get(i).getNameArt();

			for (int x = 0; x < listAllArtistsOrderIdDesc.size(); x++)
			{

				if (listAllArtistsOrderIdDesc.get(x).getNome().equals(nomeDaVez))
				{
					listAllArtistsOrderIdDesc.remove(x);
				}
			}
		}

		String dateType;

		String publicationDate = (listArtByIdArt.get(0).getDataDePublicacao() == null)
				|| (listArtByIdArt.get(0).getDataDePublicacao() == "null")
				|| (listArtByIdArt.get(0).getDataDePublicacao() == "") ? "" : "publicationDate";
		;

		String exposureDate = (listArtByIdArt.get(0).getDataDeExposicao() == null)
				|| (listArtByIdArt.get(0).getDataDeExposicao() == "null")
				|| (listArtByIdArt.get(0).getDataDeExposicao() == "") ? "" : "exposureDate";

		if (publicationDate.equals("publicationDate"))
		{
			dateType = "publicationDate";

		} else if (exposureDate.equals("exposureDate"))
		{
			dateType = "exposureDate";
		} else
		{
			dateType = "";
		}

		request.setAttribute("listArtByIdArt", listArtByIdArt);

		request.setAttribute("listAllArtistsOrderIdDesc", listAllArtistsOrderIdDesc);

		request.setAttribute("listIdsArtistByIdArt", listIdsArtistByIdArt);

		request.setAttribute("listNamesArtistByIdArtist", listNamesArtistByIdArtist);

		request.setAttribute("artistName", artistName);

		request.setAttribute("dateType", dateType);

		RequestDispatcher rd = request.getRequestDispatcher("artedit.jsp");

		rd.forward(request, response);
	}

	//

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

		associated.setIdArtist(Long.parseLong(artist.getIdArtist()));

		String associatesOn = request.getParameter("associates");

		String associatesedit = request.getParameter("associatesedit");

		String addArtsIdsCheck[] = (request.getParameterValues("addartsidscheck") == null) ? new String[] {}
				: request.getParameterValues("addartsidscheck");

		ArrayList<IdsArtsArtist> listAllIdsArtsForIdArtist = dao.listAllIdsArtsForIdArtistDb(artist.getIdArtist());

		String editArtsIdsCheck[] = (request.getParameterValues("editartsidscheck") == null) ? new String[] {}
				: request.getParameterValues("editartsidscheck");

		for (int i = 0; i < editArtsIdsCheck.length; i++)
		{

			for (int x = 0; x < listAllIdsArtsForIdArtist.size(); x++)
			{

				if (editArtsIdsCheck[i].equals(listAllIdsArtsForIdArtist.get(x).getIdArt().toString()))
				{
					listAllIdsArtsForIdArtist.remove(x);
				}
			}
		}

		ArrayList<IdsArtsArtist> listIdsArtistByIdArt = new ArrayList<>();

		for (int i = 0; i < listAllIdsArtsForIdArtist.size(); i++)
		{
			dao.listIdsArtistByIdArtDb(listIdsArtistByIdArt, "", listAllIdsArtsForIdArtist.get(i).getIdArt());
		}

		if (associatesedit.equals("YES"))
		{

			for (int i = 0; i < listAllIdsArtsForIdArtist.size(); i++)
			{
				dao.removeAssociatesArtistExtrasDb(associated, listAllIdsArtsForIdArtist.get(i).getIdArt());
			}
		}

		ArrayList<IdsArtsArtist> listFinalIdsArtistByIdArt = new ArrayList<>();

		for (int x = 0; x < listAllIdsArtsForIdArtist.size(); x++)
		{
			dao.listIdsArtistByIdArtDb(listFinalIdsArtistByIdArt, "", listAllIdsArtsForIdArtist.get(x).getIdArt());

			if (listFinalIdsArtistByIdArt.size() == 0)
			{
				dao.deleteArtForIdLongDb(listAllIdsArtsForIdArtist.get(x).getIdArt());
			}

			for (int i = 0; i < listFinalIdsArtistByIdArt.size(); i++)
			{
				listFinalIdsArtistByIdArt.remove(i);
			}

		}

		if (associatesOn.equals("YES") && addArtsIdsCheck.length >= 1)
		{

			for (int i = 0; i < addArtsIdsCheck.length; i++)
			{
				dao.AddArtsExtrasAssociatesForArtistDb(associated, Integer.parseInt(addArtsIdsCheck[i]));
			}
		}

		response.sendRedirect("artist?idartist=" + artist.getIdArtist());
	}

	//

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

		ArrayList<IdsArtsArtist> listIdsArtsByIdArtistOrderIdDesc = dao.listIdsArtsByIdArtistOrderIdDescDb(idArtist);

		ArrayList<Arts> listArtAllByIdArtOrderIdDesc = new ArrayList<>();

		ArrayList<IdsArtsArtist> listIdsArtistByIdArt = new ArrayList<>();

		for (int i = 0; i < listIdsArtsByIdArtistOrderIdDesc.size(); i++)
		{
			dao.listArtAllByIdArtOrderIdDescDb(listArtAllByIdArtOrderIdDesc,
					listIdsArtsByIdArtistOrderIdDesc.get(i).getIdArt());

			dao.listIdsArtistByIdArtDb(listIdsArtistByIdArt, "", listIdsArtsByIdArtistOrderIdDesc.get(i).getIdArt());
		}

		ArrayList<Artists> listArtistAllByIdArtist = new ArrayList<>();

		for (int i = 0; i < listIdsArtistByIdArt.size(); i++)
		{
			dao.listArtistAllByIdArtistDb(listArtistAllByIdArtist, "", listIdsArtistByIdArt.get(i).getIdArt());
		}

		request.setAttribute("listAllArtsArtist", listArtAllByIdArtOrderIdDesc);

		request.setAttribute("listArtistAllByIdArtist", listArtistAllByIdArtist);

		request.setAttribute("listIdsArtsByIdArtistOrderIdDesc", listIdsArtsByIdArtistOrderIdDesc);

		RequestDispatcher rd = request.getRequestDispatcher("artist.jsp");

		rd.forward(request, response);
	}

	//

	protected void deleteArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String idArtist = request.getParameter("idartist");

		artist.setIdArtist(idArtist);

		dao.deleteArtistDb(artist);

		response.sendRedirect("artistsearch");
	}

	//

	protected void deleteArt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Long idArt = Long.parseLong(request.getParameter("idart"));

		art.setIdart(idArt);

		dao.deleteArtDb(art);

		response.sendRedirect("searcharts");
	}

	//

	protected void searchArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String searchArtist = (request.getParameter("text") == null) ? "" : request.getParameter("text");

		searcherMain.setSeacher(searchArtist);

		ArrayList<Artists> listArtistsAllOrderName = dao.setSeacherArtistDb(searcherMain);

		request.setAttribute("listArtistsAllOrderName", listArtistsAllOrderName);

		request.setAttribute("searchArtist", searchArtist);

		RequestDispatcher rd = request.getRequestDispatcher("artistsearch.jsp");

		rd.forward(request, response);

	}

	//

	protected void addArt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String associatesOn = request.getParameter("associates");

		String checkedIds[] = (request.getParameterValues("checkallids") == null) ? new String[] {}
				: request.getParameterValues("checkallids");

		art.setName(request.getParameter("name"));
		art.setDescription(request.getParameter("description"));
		art.setDataDePublicacao(request.getParameter("publicationdate"));
		art.setDataDeExposicao(request.getParameter("exposuredate"));

		String dateType = request.getParameter("datetype");

		dao.addArtDb(art, dateType);

		associated.setIdArtist(Long.parseLong(artist.getIdArtist()));

		ArrayList<Arts> listAllArts = dao.listArtsAllOrderIdDescDb();

		associated.setIdArt(listAllArts.get(0).getIdart());
		art.setIdart(listAllArts.get(0).getIdart());

		dao.addAssociates(associated);

		ArrayList<NamesArtsArtist> checkNamesArtist = new ArrayList<>();

		if (associatesOn.equals("YES") && checkedIds.length >= 1)
		{

			for (int i = 0; i < checkedIds.length; i++)
			{
				dao.addAssociatesArtsExtrasDb(associated, Integer.parseInt(checkedIds[i]));
				dao.listNamesArtistByIdArtistDb(checkNamesArtist, checkedIds[i]);
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
		request.setAttribute("checkedNames", checkNamesArtist);
		response.sendRedirect("artist?idartist=" + artist.getIdArtist());
	}

	//

	protected void selectArtRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ArrayList<Artists> listArtistsAllOrderName = dao.listArtistsAllOrderNameDb();

		request.setAttribute("listArtistsAllOrderName", listArtistsAllOrderName);

		request.setAttribute("artistName", artist.getNome());

		RequestDispatcher rd = request.getRequestDispatcher("artregister.jsp");

		rd.forward(request, response);
	}

	//

	protected void artEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		art.setName(request.getParameter("name"));
		art.setDescription(request.getParameter("description"));
		art.setDataDePublicacao(request.getParameter("publicationdate"));
		art.setDataDeExposicao(request.getParameter("exposuredate"));

		String dateType = request.getParameter("datetype");

		dao.editArtDb(art, dateType);

		associated.setIdArt(art.getIdart());

		String associatesOn = request.getParameter("associates");

		String associatesedit = request.getParameter("associatesedit");

		String addArtistsIdsCheck[] = (request.getParameterValues("newidartistchecked") == null) ? new String[] {}
				: request.getParameterValues("newidartistchecked");

		String editArtistsIdsCheck[] = (request.getParameterValues("editartistsidscheck") == null) ? new String[] {}
				: request.getParameterValues("editartistsidscheck");

		ArrayList<IdsArtsArtist> listIdsArtistByIdArt = new ArrayList<>();

		dao.listIdsArtistByIdArtDb(listIdsArtistByIdArt, "", art.getIdart());

		for (int i = 0; i < editArtistsIdsCheck.length; i++)
		{

			for (int x = 0; x < listIdsArtistByIdArt.size(); x++)
			{

				if (editArtistsIdsCheck[i].equals(listIdsArtistByIdArt.get(x).getIdArt().toString()))
				{
					listIdsArtistByIdArt.remove(x);
				}
			}
		}

		ArrayList<IdsArtsArtist> newListIdsArtistByIdArt = new ArrayList<>();
		dao.listIdsArtistByIdArtDb(newListIdsArtistByIdArt, "", associated.getIdArt());

		if (associatesedit.equals("YES"))
		{

			for (int i = 0; i < listIdsArtistByIdArt.size(); i++)
			{
				dao.removeAssociatesArtsExtrasDb(art, listIdsArtistByIdArt.get(i).getIdArt());
			}
		}

		if (associatesOn.equals("YES") && addArtistsIdsCheck.length >= 1)
		{

			for (int i = 0; i < addArtistsIdsCheck.length; i++)
			{
				dao.AddArtistsExtrasAssociatesForArtDb(associated, Integer.parseInt(addArtistsIdsCheck[i]));
			}
		}

		ArrayList<Arts> listArt = dao.listArtByIdArtDb(art);

		ArrayList<IdsArtsArtist> idsArtistsForIdArt = new ArrayList<>();

		dao.listIdsArtistByIdArtDb(idsArtistsForIdArt, "", art.getIdart());

		ArrayList<Artists> listAllArtistForIdArtist = new ArrayList<>();

		for (int i = 0; i < idsArtistsForIdArt.size(); i++)
		{
			dao.listArtistAllByIdArtistDb(listAllArtistForIdArtist, "", idsArtistsForIdArt.get(i).getIdArt());
		}

		ArrayList<IdsArtsArtist> listFinalIdsArtistByIdArt = new ArrayList<>();
		dao.listIdsArtistByIdArtDb(listFinalIdsArtistByIdArt, "", associated.getIdArt());

		if (listFinalIdsArtistByIdArt.size() <= 0)
		{
			dao.deleteArtForIdLongDb(art.getIdart());
			response.sendRedirect("searcharts");
		} else
		{
			request.setAttribute("Art", listArt);

			request.setAttribute("listAllArtistForIdArtist", listAllArtistForIdArtist);

			request.setAttribute("name", artist.getNome());

			RequestDispatcher rd = request.getRequestDispatcher("art.jsp");

			rd.forward(request, response);
		}
	}

	protected void art(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String idArt = request.getParameter("idart");

		art.setIdart(Long.parseLong(idArt));

		ArrayList<Arts> listArt = dao.listArtByIdArtDb(art);

		ArrayList<IdsArtsArtist> idsArtistsForIdArt = new ArrayList<>();

		dao.listIdsArtistByIdArtDb(idsArtistsForIdArt, idArt, (long) -1);

		ArrayList<Artists> listAllArtistForIdArtist = new ArrayList<>();

		for (int i = 0; i < idsArtistsForIdArt.size(); i++)
		{
			dao.listArtistAllByIdArtistDb(listAllArtistForIdArtist, "", idsArtistsForIdArt.get(i).getIdArt());
		}

		request.setAttribute("Art", listArt);

		request.setAttribute("listAllArtistForIdArtist", listAllArtistForIdArtist);

		request.setAttribute("name", artist.getNome());

		RequestDispatcher rd = request.getRequestDispatcher("art.jsp");

		rd.forward(request, response);
	}

	//

	protected void searchArts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		String searchOption = (request.getParameter("option") == null) ? "name" : request.getParameter("option");

		String searchArt = (request.getParameter("text") == null) ? "" : request.getParameter("text");

		searcherMain.setSeacher(searchArt);

		ArrayList<Arts> listAllArts = new ArrayList<>();

		if (searchOption.equals("name"))
		{
			listAllArts = dao.setSeacherArtNameDb(searcherMain);

		} else if (searchOption.equals("description"))
		{
			listAllArts = dao.setSeacherArtDescriptionDb(searcherMain);
		} else
		{

		}
		request.setAttribute("listAllArts", listAllArts);

		request.setAttribute("searchArt", searchArt);

		request.setAttribute("searchOption", searchOption);

		RequestDispatcher rd = request.getRequestDispatcher("artsearch.jsp");

		rd.forward(request, response);
	}

	//

	protected void selectArtsArtist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		ArrayList<Arts> listArtsAllOrderName = dao.listArtsAllOrderNameDb();

		ArrayList<Artists> listArtistsAllOrderName = dao.listArtistsAllOrderNameDb();

		request.setAttribute("listArtsAllOrderName", listArtsAllOrderName);

		request.setAttribute("listArtistsAllOrderName", listArtistsAllOrderName);

		RequestDispatcher rd = request.getRequestDispatcher("artistregister.jsp");

		rd.forward(request, response);
	}

	//

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

	protected void userAuthenticate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String login = request.getParameter("userlogin");
		String password = request.getParameter("userpassword");
		boolean pass = false;

		ArrayList<Authentication> listAllUsers = dao.listAllUsersDb();

		for (int i = 0; i < listAllUsers.size(); i++)
		{

			if (login.equals(listAllUsers.get(i).getUserLogin())
					&& password.equals(listAllUsers.get(i).getUserPassword()))
			{
				pass = true;
			}
		}

		if (pass == true)
		{
			response.sendRedirect("main");
		} else
		{
			JOptionPane.showMessageDialog(null, "Invalid login or passaword!", "Please, try again.",
					JOptionPane.WARNING_MESSAGE);

			response.sendRedirect("index.html");
		}

	}

	//

	protected void userAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		long userId = Long.parseLong(request.getParameter("userid"));
		String userLogin = request.getParameter("userlogin");
		String userPassword = request.getParameter("userpassword");

		authentication.setUserId(userId);
		authentication.setUserLogin(userLogin);
		authentication.setUserPassword(userPassword);

		dao.userAddDb(authentication);

		response.sendRedirect("users");
	}

	//

	protected void userEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		long userId = Long.parseLong(request.getParameter("userid"));
		String userLogin = request.getParameter("userlogin");
		String userPassword = request.getParameter("userpassword");

		authentication.setUserId(userId);
		authentication.setUserLogin(userLogin);
		authentication.setUserPassword(userPassword);

		dao.userEditDb(authentication);

		response.sendRedirect("users");
	}

	//

	protected void userDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		int idUser = Integer.parseInt(request.getParameter("userid"));
		String userLogin = request.getParameter("userlogin");
		String userPassword = request.getParameter("userpassword");

		ArrayList<Authentication> listAllUsers = dao.listAllUsersDb();

		if (listAllUsers.size() <= 1)
		{
			JOptionPane.showMessageDialog(null, "You cannot delete the last registered user!", "Please, try to edit..",
					JOptionPane.WARNING_MESSAGE);

			response.sendRedirect(
					"userselect?userid=" + idUser + "&userlogin=" + userLogin + "&userpassword=" + userPassword);

		} else
		{
			dao.userDeleteDb(idUser);
			response.sendRedirect("users");
		}

	}

	//

	protected void users(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		ArrayList<Authentication> listAllUsers = dao.listAllUsersDb();

		request.setAttribute("listAllUsers", listAllUsers);

		RequestDispatcher rd = request.getRequestDispatcher("users.jsp");

		rd.forward(request, response);
	}

	//

	protected void userSelect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		long userId = Long.parseLong(request.getParameter("userid"));
		String userLogin = request.getParameter("userlogin");
		String userPassword = request.getParameter("userpassword");

		authentication.setUserId(userId);
		authentication.setUserLogin(userLogin);
		authentication.setUserPassword(userPassword);

		ArrayList<Authentication> listAllUsers = dao.listAllUsersDb();

		request.setAttribute("listAllUsers", listAllUsers);

		request.setAttribute("authentication", authentication);

		RequestDispatcher rd = request.getRequestDispatcher("useredit.jsp");

		rd.forward(request, response);
	}
}