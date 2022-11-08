
package model;

public class Artists
{
	private String idcon;

	private String nome;

	private String sexo;

	private String email;

	private String datadenascimento;

	private String nacionalidade;

	private String cpf;

	// CONTRUTORES:

	public Artists()
	{
		super();
	}

	public Artists(String idcon, String nome, String sexo, String email, String datadenascimento, String nacionalidade,
			String cpf)
	{
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.datadenascimento = datadenascimento;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
	}

	// GETS E SETS:

	public String getIdcon()
	{
		return idcon;
	}

	public void setIdcon(String idcon)
	{
		this.idcon = idcon;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getSexo()
	{
		return sexo;
	}

	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getDatadenascimento()
	{
		return datadenascimento;
	}

	public void setDatadenascimento(String datadenascimento)
	{
		this.datadenascimento = datadenascimento;
		/*-
		 DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(datadenascimento, formato);
		
		System.out.println(data);
		
		this.datadenascimento = formato.format(data);
		 */
	}

	public String getNacionalidade()
	{
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade)
	{
		this.nacionalidade = nacionalidade;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
}
