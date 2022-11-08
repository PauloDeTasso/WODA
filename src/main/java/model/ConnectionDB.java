
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnectionDB
{

	// MODELO DE CONEXÃO:

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

	// Teste de conexão:
	/*
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */

	/* CRUD CREATE */

	public void inserirContato(Artists contato)
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
				pst.setString(4, contato.getDatadenascimento());
				pst.setString(5, contato.getNacionalidade());
				pst.setString(6, contato.getCpf());

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
				pst.setString(4, contato.getDatadenascimento());
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

	// CRUD READ:

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

				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String sexo = rs.getString(4);
				String datadenascimento = rs.getString(5);
				String nacionalidade = rs.getString(6);
				String cpf = rs.getString(7);

				// ARMAZENAR NO ARRAYLIST

				contatos.add(new Artists(idcon, nome, email, sexo, datadenascimento, nacionalidade, cpf));
			}

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
		/*-
		String read2 = "select * from contatos where idcon = ?";
		
		try
		{
			//Abrir a conexao:
		
			Connection con = conectar();
		
			//Preparar a query para a execução no banco de dados:
		
			PreparedStatement pst = con.prepareStatement(read2);
		
			//SUBSTITUIR A INTERROGAÇÃO (?) DA QUERY ACIMA - READ2 -
			//PELO ID SETADO NA REQUISIÇÃO NA CLASSE CONTROLE:
		
			pst.setString(1, contato.getIdcon());
		
			//EXECUTA A QUERY:
		
			ResultSet rs = pst.executeQuery();
		
			//ENQUANTO TIVER DADOS
		
			while (rs.next())
			{
				//SETAR AS VARIAVEIS JAVABEANS:
		
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
		
			//FEICHA A CONEXAO COM O BANCO:
		
			con.close();
		
		} catch (Exception e)
		{
			System.out.println(e);
		}
		*/
	}

	// ALTERAR CONTATO:

	public void alterarContato(Artists contato)
	{
		/*-
		String update = "update contatos set nome=?, fone=?, email=? where idcon=?";
		
		try
		{
			//Abrir a conexao:
		
			Connection con = conectar();
		
			//Preparar a query para a execução no banco de dados:
		
			PreparedStatement pst = con.prepareStatement(update);
		
			//SUBSTITUIR AS INTERROGAÇÕES (?) DA QUERY - CREATE -
			//PELAS VARIAVEIS DO OBJETO DE INSTACIA 'CONTATO' DA CLASE JAVABEANS
			//PASSADA COMO ATRIBUTO DESSE METODO:
		
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
		
			//EXECUTA A QUERY:
		
			pst.executeUpdate();
		
			//FEICHA A CONEXAO COM O BANCO:
		
			con.close();
		
		} catch (Exception e)
		{
			System.out.println(e);
		}
		*/
	}

	/* CRUD DELETE */

	// REMOVER CONTATO:

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

			pst.setString(1, contato.getIdcon());

			// EXECUTA A QUERY:

			pst.executeUpdate();

			// FECHA A CONEXAO COM O BANCO:

			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
