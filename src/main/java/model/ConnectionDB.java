
package model;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectionDB
{

	public static String UrlImagemArtistaAtual1;

	public static String UrlImagemArtistaAtual2;

	public static String UrlImagemArtistaAtual3;

	public static String UrlImagemArtistaAtual4;

	public static Path UrlImagemArtistaAtual5;

	// MODELO DE CONEXÃO:

	// PARAMETROS:

	private String driver = "com.mysql.cj.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/dbartists?useTimezone=true&serverTimezone=UTC";

	private String user = "root";

	private String password = "root";

	// Metodo de conexão:

	public ByteArrayInputStream imageArtistDB(ByteArrayInputStream stream)
	{
		return stream;
	}

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

	// Teste de conexão:
	/*
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */

	/* CRUD CREATE - /insert */

	public void inserirContato(Artists contato) throws FileNotFoundException
	{
		String create;

		if (contato.getNacionalidade().equals("Brasil"))
		{

			try
			{
				create = "insert into artists (nome,email,sexo,datadenascimento,nacionalidade,cpf) values (?,?,?,?,?,?)";

				// Abrir a conexao:
				Connection con = conectar();

				// Preparar a query para a execução no banco de dados:
				PreparedStatement pst = con.prepareStatement(create);

				// Substituir os paramentos (?) pelo conteudo da variaveis do Javabeans:
				pst.setString(1, contato.getNome());
				pst.setString(2, contato.getEmail());
				pst.setString(3, contato.getSexo());
				pst.setString(4, contato.getDatadenascimento(""));
				pst.setString(5, contato.getNacionalidade());
				pst.setString(6, contato.getCpf());

				// ADICIONA UM "INT" INTEIRO A QUERY '?' 3:
				// ps.setInt(3, contato.getTelefone());

				// Executar a query
				pst.executeUpdate();

				// Encerrar a conexao com o banco:
				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}

		} else
		{

			try
			{
				create = "insert into artists (nome,email,sexo,datadenascimento,nacionalidade) values (?,?,?,?,?)";

				// Abrir a conexao:
				Connection con = conectar();

				// Preparar a query para a execução no banco de dados:
				PreparedStatement pst = con.prepareStatement(create);

				// Substituir os paramentos (?) pelo conteudo da variaveis do Javabeans:
				pst.setString(1, contato.getNome());
				pst.setString(2, contato.getEmail());
				pst.setString(3, contato.getSexo());
				pst.setString(4, contato.getDatadenascimento(""));
				pst.setString(5, contato.getNacionalidade());

				// Executar a query
				pst.executeUpdate();

				// Encerrar a conexao com o banco:
				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}

		}

	}

	// CRUD READ - /main:

	public ArrayList<Artists> listarContatos()
	{

		// CRIANDO UM OBJETO PARA ACESSAR A CLASSE JAVABEANS:
		ArrayList<Artists> contatos = new ArrayList<>();

		// ATRIBUINDO A QUERY A VARIAVEL READ:

		String read = "select * from artists order by nome";

		try
		{
			// Abrir a conexao:

			Connection con = conectar();

			// Preparar a query para a execução no banco de dados:

			PreparedStatement pst = con.prepareStatement(read);

			// EXECUTA A QUERY:

			ResultSet rs = pst.executeQuery();

			// LAÇO SERA EXECUTADO ENQUANTO HOUVER CONTATOS:

			while (rs.next())
			{
				// VARIAVEIS DE APOIO QUE RECEBEM OS DADOS DO BANCO:

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
					cpf = "Don't have!";
				}

				// ARMAZENAR NO ARRAYLIST

				contatos.add(new Artists(idArtist, nome, email, sexo, datadenascimento, nacionalidade, cpf));
			}

			pst.close();

			// FECHA CONEXÃO DO BANCO:
			con.close();

			return contatos;

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}

	}

	// CRUD UPDATE:

	// SELECIONAR CONTATO:

	public void selecionarContato(Artists contato)
	{
		String read2 = "select * from artists where idartist = ?";

		try
		{
			// Abrir a conexao:

			Connection con = conectar();

			// Preparar a query para a execução no banco de dados:

			PreparedStatement pst = con.prepareStatement(read2);

			// SUBSTITUIR A INTERROGAÇÃO (?) DA QUERY ACIMA - READ2 -
			// PELO ID SETADO NA REQUISIÇÃO NA CLASSE CONTROLE:

			pst.setString(1, contato.getIdArtist());

			// EXECUTA A QUERY:

			ResultSet rs = pst.executeQuery();

			// ENQUANTO TIVER DADOS

			while (rs.next())
			{
				// SETAR AS VARIAVEIS JAVABEANS:

				contato.setIdArtist(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setEmail(rs.getString(3));
				contato.setSexo(rs.getString(4));
				contato.setDatadenascimento(rs.getString(5));
				contato.setNacionalidade(rs.getString(6));
				contato.setCpf(rs.getString(7));
			}
			// FECHA A CONEXAO COM O BANCO:

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}

	}

	// ALTERAR CONTATO:

	public void alterarContato(Artists contato)
	{

		if (contato.getNacionalidade().equals("Brasil"))
		{
			String update = "update artists set nome=?, email=?, sexo=?, datadenascimento=?, nacionalidade=?, cpf=? where idartist=?";

			try
			{
				// Abrir a conexao:

				Connection con = conectar();

				// Preparar a query para a execução no banco de dados:

				PreparedStatement pst = con.prepareStatement(update);

				// SUBSTITUIR AS INTERROGAÇÕES (?) DA QUERY - CREATE -
				// PELAS VARIAVEIS DO OBJETO DE INSTACIA 'CONTATO' DA CLASE JAVABEANS
				// PASSADA COMO ATRIBUTO DESSE METODO:

				pst.setString(1, contato.getNome());
				pst.setString(2, contato.getEmail());
				pst.setString(3, contato.getSexo());
				pst.setString(4, contato.getDatadenascimento());
				pst.setString(5, contato.getNacionalidade());
				pst.setString(6, contato.getCpf());
				pst.setString(7, contato.getIdArtist());

				// EXECUTA A QUERY:

				pst.executeUpdate();

				// FEICHA A CONEXAO COM O BANCO:

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}
		} else
		{
			String update = "update artists set nome=?, email=?, sexo=?, datadenascimento=?, nacionalidade=? where idartist=?";

			try
			{
				// Abrir a conexao:

				Connection con = conectar();

				// Preparar a query para a execução no banco de dados:

				PreparedStatement pst = con.prepareStatement(update);

				// SUBSTITUIR AS INTERROGAÇÕES (?) DA QUERY - CREATE -
				// PELAS VARIAVEIS DO OBJETO DE INSTACIA 'CONTATO' DA CLASE JAVABEANS
				// PASSADA COMO ATRIBUTO DESSE METODO:

				pst.setString(1, contato.getNome());
				pst.setString(2, contato.getEmail());
				pst.setString(3, contato.getSexo());
				pst.setString(4, contato.getDatadenascimento());
				pst.setString(5, contato.getNacionalidade());
				pst.setString(6, contato.getIdArtist());

				// EXECUTA A QUERY:

				pst.executeUpdate();

				// FEICHA A CONEXAO COM O BANCO:

				con.close();

			} catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}

	/* CRUD DELETE */

	// REMOVER CONTATO - /delete:

	public void deletarContato(Artists contato)
	{

		String delete = "delete from artists where idartist = ?";

		try
		{
			// Abrir a conexao:

			Connection con = conectar();

			// Preparar a query para a execução no banco de dados:

			PreparedStatement pst = con.prepareStatement(delete);

			// SUBSTITUIR A INTERROGAÇÃO (?) DA QUERY ACIMA - READ2 -
			// PELO ID SETADO NA REQUISIÇÃO NA CLASSE CONTROLE:

			pst.setString(1, contato.getIdArtist());

			// EXECUTA A QUERY:

			pst.executeUpdate();

			// FECHA A CONEXAO COM O BANCO:

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	//
	/*-
	
	public void gravarImagem( String urlImagem ) throws Exception 
	{
		System.out.println("urlImagemmmmm = " + urlImagem);
		
		File file = new File( urlImagem );
	
		if(file.exist())
		{
	    
			BufferedImage img = ImageIO.read( file );
	    
			ByteArrayOutputStream b = new ByteArrayOutputStream();
			
			ImageIO.write( img, "jpg", b );
	    
			byte[] imgArray = b.toByteArray();
	    
			String sql = "INSERT INTO tb_imagens VALUES( NULL, ? )";  
			
			
			//
			
			// Abrir a conexao:
	
						Connection con = conectar();
	
						// Preparar a query para a execução no banco de dados:
	
						PreparedStatement pst = con.prepareStatement(sql);
	
						// SUBSTITUIR A INTERROGAÇÃO (?) DA QUERY ACIMA - READ2 -
						// PELO ID SETADO NA REQUISIÇÃO NA CLASSE CONTROLE:
	
						pst.setString(1, contato.getIdArtist());
	
						// EXECUTA A QUERY:
	
						pst.executeUpdate();
	
						// FECHA A CONEXAO COM O BANCO:
	
						con.close();
			
			/*-
			
			PreparedStatement stm = ConnectionFactory.getConexao().prepareStatement(sql);          
			
			stm.setBytes( 1, imgArray );          
			
			stm.executeUpdate();          
			
			stm.close();
	
	
	
		}else
		{
	   
			//lançar alguma mensagem para o usuário
	
		}
	}
	*/

	///////////////

	public void criarTxt()
	{

		try
		{
			File myObj = new File("filename.txt");

			if (myObj.createNewFile())
			{
				System.out.println("File created: " + myObj.getName());

			} else
			{
				System.out.println("File already exists.");
			}

		} catch (IOException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	//

	public File criarImagem(String nome)
	{
		File imagemArtist = new File(nome);

		try
		{

			if (imagemArtist.createNewFile())
			{
				System.out.println("Arquivo criado: " + imagemArtist.getName());

			} else
			{
				System.out.println("O arquivo não foi criado!");
			}

			return imagemArtist;

		} catch (IOException e)
		{
			System.out.println("Erro!");
			e.printStackTrace();
		}
		return imagemArtist;
	}

	//

	public void salvarTxt()
	{

		try
		{
			FileWriter myWriter = new FileWriter("filename.txt");

			myWriter.write("Files in Java might be tricky, but it is fun enough!");

			myWriter.close();

			System.out.println("Successfully wrote to the file.");

		} catch (IOException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	//

	public void lerTxt()
	{

		try
		{
			File myObj = new File("filename.txt");

			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine())
			{
				String data = myReader.nextLine();
				System.out.println(data);
			}

			myReader.close();

		} catch (FileNotFoundException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	//

	public void infoTxt(File myObj)
	{
		// File myObj = new File("filename.txt");

		if (myObj.exists())
		{
			System.out.println("File name: " + myObj.getName());
			System.out.println("Absolute path: " + myObj.getAbsolutePath());
			System.out.println("Writeable: " + myObj.canWrite());
			System.out.println("Readable " + myObj.canRead());
			System.out.println("File size in bytes " + myObj.length());
		} else
		{
			System.out.println("The file does not exist.");
		}
	}

	//

	public void deleteTxt()
	{
		File myObj = new File("filename.txt");

		if (myObj.delete())
		{
			System.out.println("Deleted the file: " + myObj.getName());

		} else
		{
			System.out.println("Failed to delete the file.");
		}
	}

	//

	public void deletePasta()
	{
		File myObj = new File("C:\\Users\\MyName\\Test");

		if (myObj.delete())
		{
			System.out.println("Deleted the folder: " + myObj.getName());
		} else
		{
			System.out.println("Failed to delete the folder.");
		}
	}

	//

	//
	/*-
		public Icon loadIcon(long id) throws SQLException, IOException, ClassNotFoundException
		{
	
			try (Connection connection = getConnection())
			{
				String query = "select img from t1 where id = ?";
	
				try (PreparedStatement statement = connection.prepareStatement(query))
				{
					statement.setLong(1, id);
	
					try (ResultSet rs = statement.executeQuery())
					{
	
						if (rs.next())
						{
							Blob blob = rs.getBlob("img");
	
							try (ObjectInputStream is = new ObjectInputStream(blob.getBinaryStream()))
							{
								return (Icon) is.readObject();
							}
						}
	
						return null;
					}
				}
			}
		}
	*/
	//

}
