
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnectionDB
{
	private String driver = "com.mysql.cj.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/dbartists?useTimezone=true&serverTimezone=UTC";

	private String user = "root";

	private String password = "root";

	//

	private Connection conectar()
	{
		Connection con = null;

		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	//

	public void addArtistDb(Artists artist)
	{
		String query;

		if (artist.getNacionalidade().equals("Brasil"))
		{

			try
			{
				query = "insert into artists (nome,email,sexo,datadenascimento,nacionalidade,cpf) values (?,?,?,?,?,?)";

				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, artist.getNome());
				pst.setString(2, artist.getEmail());
				pst.setString(3, artist.getSexo());
				pst.setString(4, artist.getDatadenascimento());
				pst.setString(5, artist.getNacionalidade());
				pst.setString(6, artist.getCpf());

				pst.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}

		} else
		{

			try
			{

				query = "insert into artists (nome,email,sexo,datadenascimento,nacionalidade) values (?,?,?,?,?)";

				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, artist.getNome());
				pst.setString(2, artist.getEmail());
				pst.setString(3, artist.getSexo());
				pst.setString(4, artist.getDatadenascimento());
				pst.setString(5, artist.getNacionalidade());

				pst.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}

	//

	public ArrayList<Artists> listArtistsAllOrderNameDb()
	{
		ArrayList<Artists> listAllArtists = new ArrayList<>();

		String query = "select * from artists order by nome";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				String idArtist = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String sexo = rs.getString(4);
				String datadenascimento = rs.getString(5);
				String nacionalidade = rs.getString(6);

				String cpf;

				if (nacionalidade.equals("Brasil"))
				{
					cpf = rs.getString(7);
				} else
				{
					cpf = rs.getString(7);
					cpf = null;
				}

				listAllArtists.add(new Artists(idArtist, nome, email, sexo, datadenascimento, nacionalidade, cpf));
			}

			pst.close();

			con.close();

			return listAllArtists;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	//

	public void listArtistAllByIdArtistDb(ArrayList<Artists> listAllArtistForIdArtist, String IdArtistString,
			Long IdArtistLong)
	{
		String query = "select * from artists where idartist = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			if (IdArtistString != "")
			{
				pst.setString(1, IdArtistString);

			} else if (IdArtistLong != -1)
			{
				pst.setLong(1, IdArtistLong);

			} else
			{
				pst.setInt(1, 0);
			}

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				String idArtist = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String sexo = rs.getString(4);
				String datadenascimento = rs.getString(5);
				String nacionalidade = rs.getString(6);

				String cpf;

				if (nacionalidade.equals("Brasil"))
				{
					cpf = rs.getString(7);
				} else
				{
					cpf = rs.getString(7);
					cpf = null;
				}

				listAllArtistForIdArtist
						.add(new Artists(idArtist, nome, email, sexo, datadenascimento, nacionalidade, cpf));
			}

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public ArrayList<Arts> listAllArtsForName()
	{
		ArrayList<Arts> listAllArts = new ArrayList<>();

		String query = "select * from arts order by nome";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				Long idArt = rs.getLong(1);
				String nome = rs.getString(2);
				String description = rs.getString(3);
				String dataDePublicacao = rs.getString(4);
				String dataDeExposicao = rs.getString(5);

				listAllArts.add(new Arts(idArt, nome, description, dataDePublicacao, dataDeExposicao));
			}

			pst.close();

			con.close();

			return listAllArts;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	//

	public void selectArtistDb(Artists artist)
	{
		String query = "select * from artists where idartist = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, artist.getIdArtist());

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				artist.setIdArtist(rs.getString(1));
				artist.setNome(rs.getString(2));
				artist.setEmail(rs.getString(3));
				artist.setSexo(rs.getString(4));
				artist.setDatadenascimento(rs.getString(5));
				artist.setNacionalidade(rs.getString(6));
				artist.setCpf(rs.getString(7));
			}

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void editArtistDb(Artists artist)
	{

		if (artist.getNacionalidade().equals("Brasil"))
		{
			String query = "update artists set nome=?, email=?, sexo=?, datadenascimento=?, nacionalidade=?, cpf=? where idartist=?";

			try
			{
				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, artist.getNome());
				pst.setString(2, artist.getEmail());
				pst.setString(3, artist.getSexo());
				pst.setString(4, artist.getDatadenascimento());
				pst.setString(5, artist.getNacionalidade());
				pst.setString(6, artist.getCpf());
				pst.setString(7, artist.getIdArtist());

				pst.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}

		} else
		{
			String query = "update artists set nome=?, email=?, sexo=?, datadenascimento=?, nacionalidade=? where idartist=?";

			try
			{
				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, artist.getNome());
				pst.setString(2, artist.getEmail());
				pst.setString(3, artist.getSexo());
				pst.setString(4, artist.getDatadenascimento());
				pst.setString(5, artist.getNacionalidade());
				pst.setString(6, artist.getIdArtist());

				pst.executeUpdate();

				String query2 = "update artists set cpf = null where idartist = ?";

				PreparedStatement pst2 = con.prepareStatement(query2);

				pst2.setString(1, artist.getIdArtist());

				pst2.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}

	//

	public void editArtDb(Arts art)
	{
		String query = "update arts set nome=?, descricao=?, datadepublicacao=?, datadeexposicao=? where idart=?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, art.getName());
			pst.setString(2, art.getDescription());

			if (art.getDataDeExposicao().equals(""))
			{
				pst.setString(4, null);
			} else
			{
				pst.setString(4, art.getDataDeExposicao());
			}

			if (art.getDataDePublicacao().equals(""))
			{
				pst.setString(3, null);
			} else
			{
				pst.setString(3, art.getDataDePublicacao());
			}

			pst.setLong(5, art.getIdart());

			pst.executeUpdate();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void deleteArtistDb(Artists contato)
	{
		String query = "delete from artists where idartist = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, contato.getIdArtist());

			pst.executeUpdate();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void deleteArtDb(Arts art)
	{
		String query = "delete from properties where idartfk = ?";

		String query2 = "delete from arts where idart = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setLong(1, art.getIdart());

			pst.executeUpdate();

			PreparedStatement pst2 = con.prepareStatement(query2);

			pst2.setLong(1, art.getIdart());

			pst2.executeUpdate();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void deleteArtForIdDb(String idArt)
	{
		String query = "delete from arts where idart = ?";

		try
		{
			Connection con = conectar();

			//

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, idArt);

			pst.executeUpdate();

			//

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void deleteArtForIdLongDb(long idArt)
	{
		String query = "delete from arts where idart = ?";

		try
		{
			Connection con = conectar();

			//

			PreparedStatement pst = con.prepareStatement(query);

			pst.setLong(1, idArt);

			pst.executeUpdate();

			//

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public ArrayList<Artists> setSeacherArtistDb(Searcher searcherMain)
	{
		ArrayList<Artists> contatos = new ArrayList<>();

		String query = "select * from artists where nome like ? order by nome asc";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, "%" + searcherMain.getSeacher() + "%");

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				String idArtist = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String sexo = rs.getString(4);
				String datadenascimento = rs.getString(5);
				String nacionalidade = rs.getString(6);
				String cpf;

				if (nacionalidade.equals("Brasil"))
				{
					cpf = rs.getString(7);
				} else
				{
					cpf = rs.getString(7);
					cpf = null;
				}

				contatos.add(new Artists(idArtist, nome, email, sexo, datadenascimento, nacionalidade, cpf));
			}

			pst.close();

			con.close();

			return contatos;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	//

	public ArrayList<Arts> setSeacherArtNameDb(Searcher searcherMain)
	{
		ArrayList<Arts> listAllArts = new ArrayList<>();

		String query = "select * from arts where nome like ? order by nome asc";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, "%" + searcherMain.getSeacher() + "%");

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				Long idArt = rs.getLong(1);
				String nome = rs.getString(2);
				String description = rs.getString(3);
				String dataDePublicacao = rs.getString(4);
				String dataDeExposicao = rs.getString(5);

				listAllArts.add(new Arts(idArt, nome, description, dataDeExposicao, dataDePublicacao));

			}

			pst.close();

			con.close();

			return listAllArts;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	//

	public ArrayList<Arts> setSeacherArtDescriptionDb(Searcher searcherMain)
	{
		ArrayList<Arts> listAllArts = new ArrayList<>();

		String query = "select * from arts where descricao like ? order by descricao asc";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, "%" + searcherMain.getSeacher() + "%");

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				Long idArt = rs.getLong(1);
				String nome = rs.getString(2);
				String description = rs.getString(3);
				String dataDePublicacao = rs.getString(4);
				String dataDeExposicao = rs.getString(5);

				listAllArts.add(new Arts(idArt, nome, description, dataDeExposicao, dataDePublicacao));

			}

			pst.close();

			con.close();

			return listAllArts;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	//

	public void addArtDb(Arts art, String dateType)
	{
		String query;

		if (dateType.equals("exposureDate"))
		{
			query = "insert into arts (nome,descricao,datadeexposicao) values (?,?,?)";

			try
			{
				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, art.getName());
				pst.setString(2, art.getDescription());
				pst.setString(3, art.getDataDeExposicao());

				pst.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}

		} else if (dateType.equals("publicationDate"))
		{
			query = "insert into arts (nome,descricao,datadepublicacao) values (?,?,?)";

			try
			{
				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, art.getName());
				pst.setString(2, art.getDescription());
				pst.setString(3, art.getDataDePublicacao());

				pst.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}

		} else
		{
			System.out.println("ART NO ADD!");
		}
	}

	//

	public void editArtDb(Arts art, String dateType)
	{
		String query;

		if (dateType.equals("exposureDate"))
		{
			query = "update arts set nome=?, descricao=?, datadepublicacao=?, datadeexposicao=? where idart=?";

			try
			{
				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, art.getName());
				pst.setString(2, art.getDescription());
				pst.setString(3, null);
				pst.setString(4, art.getDataDeExposicao());
				pst.setLong(5, art.getIdart());

				pst.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}

		} else if (dateType.equals("publicationDate"))
		{
			query = "update arts set nome=?, descricao=?, datadepublicacao=?, datadeexposicao=? where idart=?";

			try
			{
				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, art.getName());
				pst.setString(2, art.getDescription());
				pst.setString(3, art.getDataDePublicacao());
				pst.setString(4, null);
				pst.setLong(5, art.getIdart());

				pst.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}

		} else
		{
			System.out.println("ART NO ADD!");
		}
	}

	//

	public void addAssociates(Associates associated)
	{
		String query = "insert into properties (idartistfk,idartfk) values (?,?)";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setLong(1, associated.getIdArtist());
			pst.setLong(2, associated.getIdArt());

			pst.executeUpdate();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public ArrayList<Arts> listArtsAllOrderIdDescDb()
	{
		ArrayList<Arts> listAllArts = new ArrayList<>();

		String query = "select * from arts order by idart desc";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{

				Long idArt = rs.getLong(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				String dataDePublicacao = rs.getString(4);
				String dataDeExposicao = rs.getString(4);

				listAllArts.add(new Arts(idArt, name, description, dataDeExposicao, dataDePublicacao));

			}

			pst.close();

			con.close();

			return listAllArts;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}

	}

	//

	public ArrayList<Artists> listAllArtistsOrderIdDescDb()
	{
		ArrayList<Artists> listAllArtists = new ArrayList<>();

		String query = "select * from artists order by idartist desc";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				String idArtist = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String sexo = rs.getString(4);
				String datadenascimento = rs.getString(5);
				String nacionalidade = rs.getString(6);

				String cpf;

				if (nacionalidade.equals("Brasil"))
				{
					cpf = rs.getString(7);
				} else
				{
					cpf = rs.getString(7);
					cpf = null;
				}

				listAllArtists.add(new Artists(idArtist, nome, email, sexo, datadenascimento, nacionalidade, cpf));
			}

			pst.close();

			con.close();

			return listAllArtists;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}

	}

	//

	public ArrayList<IdsArtsArtist> listIdsArtsByIdArtistOrderIdDescDb(String idArtist)
	{
		ArrayList<IdsArtsArtist> listIdsArtsArtist = new ArrayList<>();

		String query = "select idartfk from properties where idartistfk = ? order by idartfk desc";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, idArtist);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				Long idArtFk = rs.getLong(1);

				listIdsArtsArtist.add(new IdsArtsArtist(idArtFk));
			}

			pst.close();

			con.close();

			return listIdsArtsArtist;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	//

	public void listArtAllByIdArtOrderIdDescDb(ArrayList<Arts> listAllArtsArtist, Long idArtArtist)
	{
		String query = "select * from arts where idart = ? order by idart desc";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setLong(1, idArtArtist);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				Long idArt = rs.getLong(1);
				String nome = rs.getString(2);
				String description = rs.getString(3);
				String dataDePublicacao = rs.getString(4);
				String dataDeExposicao = rs.getString(5);

				listAllArtsArtist.add(new Arts(idArt, nome, description, dataDeExposicao, dataDePublicacao));
			}

			pst.close();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public ArrayList<NamesArtsArtist> listNamesArtsArtistDb(String checkedIds[])
	{
		ArrayList<NamesArtsArtist> listNamesArtsArtist = new ArrayList<>();

		String query = "select idartfk from properties where idartistfk = ? order by idartfk desc";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, "");

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				String nameArt = rs.getString(1);

				listNamesArtsArtist.add(new NamesArtsArtist(nameArt));
			}

			pst.close();

			con.close();

			return listNamesArtsArtist;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}

	}

	//

	public void listNamesArtistByIdArtistDb(ArrayList<NamesArtsArtist> listNamesArtistByIdArtist, String idArtist)
	{
		String query = "select nome from artists where idartist = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, idArtist);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				String nome = rs.getString(1);

				listNamesArtistByIdArtist.add(new NamesArtsArtist(nome));
			}

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void checkNamesArtsDb(ArrayList<NamesArtsArtist> checkNamesArts, int checked)
	{
		String query = "select nome from arts where idart = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, checked);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				String nome = rs.getString(1);

				checkNamesArts.add(new NamesArtsArtist(nome));
			}

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void addAssociatesArtsExtrasDb(Associates associated, int checked)
	{
		String query = "insert into properties (idartistfk,idartfk) values (?,?)";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setLong(1, checked);
			pst.setLong(2, associated.getIdArt());

			pst.executeUpdate();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void AddArtsExtrasAssociatesForArtistDb(Associates associated, int checked)
	{
		String query = "insert into properties (idartistfk,idartfk) values (?,?)";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setLong(1, associated.getIdArtist());
			pst.setLong(2, checked);

			pst.executeUpdate();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void AddArtistsExtrasAssociatesForArtDb(Associates associated, int checked)
	{
		String query = "insert into properties (idartistfk,idartfk) values (?,?)";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, checked);
			pst.setLong(2, associated.getIdArt());

			pst.executeUpdate();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void removeAssociatesArtistExtrasDb(Associates associated, Long checked)
	{
		String query = "delete from properties where idartistfk = ? and idartfk like ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setLong(1, associated.getIdArtist());
			pst.setLong(2, checked);

			pst.executeUpdate();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void removeAssociatesArtsExtrasDb(Arts idArt, Long checked)
	{
		String query = "delete from properties where idartfk = ? and idartistfk like ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setLong(1, idArt.getIdart());
			pst.setLong(2, checked);

			pst.executeUpdate();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public ArrayList<Arts> listArtByIdArtDb(Arts art)
	{
		ArrayList<Arts> listArt = new ArrayList<>();

		String query = "select * from arts where idart=?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setLong(1, art.getIdart());

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				Long idArt = rs.getLong(1);
				String nome = rs.getString(2);
				String description = rs.getString(3);
				String dataDePublicacao = rs.getString(4);
				String dataDeExposicao = rs.getString(5);

				listArt.add(new Arts(idArt, nome, description, dataDeExposicao, dataDePublicacao));
			}

			pst.close();

			con.close();

			return listArt;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}

	}

	//

	public ArrayList<Arts> listArtsAllOrderNameDb()
	{
		ArrayList<Arts> listAllArtsNames = new ArrayList<>();

		String query = "select * from arts order by nome asc";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{

				Long idArt = rs.getLong(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				String dataDePublicacao = rs.getString(4);
				String dataDeExposicao = rs.getString(4);

				listAllArtsNames.add(new Arts(idArt, name, description, dataDeExposicao, dataDePublicacao));

			}

			pst.close();

			con.close();

			return listAllArtsNames;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	//

	public ArrayList<IdsArtsArtist> listAllIdsArtsForIdArtistDb(String idArtist)
	{
		ArrayList<IdsArtsArtist> listAllIdsArtsForIdArtist = new ArrayList<>();

		String query = "select idartfk from properties where idartistfk = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, idArtist);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				Long idArt = rs.getLong(1);

				listAllIdsArtsForIdArtist.add(new IdsArtsArtist(idArt));
			}

			pst.close();

			con.close();

			return listAllIdsArtsForIdArtist;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	//

	public void listAllArtsNamesForIdArtistDb(ArrayList<NamesArtsArtist> listAllArtsNamesForIdArtist, Long idArtist)
	{

		String query = "select nome from arts where idart = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setLong(1, idArtist);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				String name = rs.getString(1);

				listAllArtsNamesForIdArtist.add(new NamesArtsArtist(name));
			}

			pst.close();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void removeAssociateDb(String idArtist, String idArt)
	{

		String query = "delete from properties where idartistfk = ? and idartfk like ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, idArtist);
			pst.setString(2, idArt);

			pst.executeUpdate();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public boolean listAssociateDb(String idArt)
	{

		// String idString;
		boolean delete = true;

		String query = "select idartistfk from properties where idartfk = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, idArt);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				// idString = rs.getString(1);

				delete = false;

			}

			con.close();

			return delete;

		} catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	//

	public void listIdsArtistByIdArtDb(ArrayList<IdsArtsArtist> listIdsArtistByIdArt, String idArtString,
			Long idArtLong)
	{
		String query = "select idartistfk from properties where idartfk = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			if (idArtString != "")
			{
				pst.setString(1, idArtString);

			} else if (idArtLong != -1)
			{
				pst.setLong(1, idArtLong);

			} else
			{
				pst.setInt(1, 0);
			}

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				Long idArtists = rs.getLong(1);

				listIdsArtistByIdArt.add(new IdsArtsArtist(idArtists));
			}

			pst.close();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public ArrayList<Authentication> listAllUsersDb()
	{
		ArrayList<Authentication> listAllUsers = new ArrayList<>();

		String query = "select userId, userLogin, userPassword from authenticate";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next())
			{
				Long userId = rs.getLong(1);
				String userLogin = rs.getString(2);
				String userPassword = rs.getString(3);

				listAllUsers.add(new Authentication(userId, userLogin, userPassword));
			}

			pst.close();

			con.close();

			return listAllUsers;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	//

	public void userAddDb(Authentication authentication)
	{
		String query = "insert into authenticate (userId,userLogin,userPassword) values (?,?,?)";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, (int) authentication.getUserId());
			pst.setString(2, authentication.getUserLogin());
			pst.setString(3, authentication.getUserPassword());

			pst.executeUpdate();

			pst.close();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void userEditDb(Authentication authentication)
	{
		String query = "update authenticate set userLogin=?, userPassword=? where userId=?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, authentication.getUserLogin());
			pst.setString(2, authentication.getUserPassword());
			pst.setInt(3, (int) authentication.getUserId());

			pst.executeUpdate();

			pst.close();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//

	public void userDeleteDb(int userId)
	{
		String query = "delete from authenticate where userId = ?";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, userId);

			pst.executeUpdate();

			pst.close();

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
