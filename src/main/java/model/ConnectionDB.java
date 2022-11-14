
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnectionDB
{
	// PARAMETROS:

	private String driver = "com.mysql.cj.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/dbartists?useTimezone=true&serverTimezone=UTC";

	private String user = "root";

	private String password = "root";

	// Metodo de conexão:

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

	/* CRUD CREATE - /artistregister */

	public void addArtistDb(Artists artist)
	{
		String query;

		if (artist.getNacionalidade().equals("Brasil"))
		{

			try
			{
				System.out.println("Brasil");

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
				System.out.println("Não Brasil");

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

	// CRUD READ - /main:

	public ArrayList<Artists> selectAllArtistDb()
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

	// CRUD UPDATE:

	// SELECIONAR CONTATO:

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

	// ALTERAR CONTATO - /editartist:

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

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}

	/* CRUD DELETE */

	// REMOVER CONTATO - /delete:

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

	// SEARCHER - /searcher:

	public ArrayList<Artists> searcher(Searcher searcherMain)
	{
		ArrayList<Artists> contatos = new ArrayList<>();

		String query = "select * from artists where nome like ? order by nome asc";

		try
		{
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, searcherMain.getSeacher() + "%");

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

	///// INSERIR ART - /artregister:

	public void inserirArt(Arts art)
	{
		String query;

		System.out.println(art.getDataDePublicacao().equals(null));
		System.out.println(art.getDataDeExposicao().equals(null));

		if (art.getDataDePublicacao().equals(null))
		{
			query = "insert into arts (nome,descricao,datadeexposicao,idartist) values (?,?,?,?)";

			try
			{
				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, art.getName());
				pst.setString(2, art.getDescription());
				pst.setString(3, art.getDataDeExposicao());
				pst.setString(4, art.getIdartist());

				pst.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}

		} else if (art.getDataDeExposicao().equals(null))
		{
			query = "insert into arts (nome,descricao,datadepublicacao,idartist) values (?,?,?,?)";

			try
			{
				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, art.getName());
				pst.setString(2, art.getDescription());
				pst.setString(3, art.getDataDePublicacao());
				pst.setString(4, art.getIdartist());

				pst.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}

		} else
		{
			query = "insert into arts (nome,descricao,idartist) values (?,?,?)";

			try
			{
				Connection con = conectar();

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, art.getName());
				pst.setString(2, art.getDescription());
				pst.setString(3, art.getIdartist());

				pst.executeUpdate();

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
