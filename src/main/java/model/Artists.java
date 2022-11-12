
package model;

import java.io.Serializable;

public class Artists implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String idArtist;

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

	public Artists(String idArtist, String nome, String sexo, String email, String datadenascimento,
			String nacionalidade, String cpf)
	{
		super();
		this.idArtist = idArtist;
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.datadenascimento = datadenascimento;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
	}

	// GETS E SETS:

	public String getIdArtist()
	{
		return idArtist;
	}

	public void setIdArtist(String idArtist)
	{
		this.idArtist = idArtist;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSexo()
	{
		return sexo;
	}

	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}

	public String getDatadenascimento(String formato)
	{

		if (formato.equals("br"))
		{
			String dia = this.datadenascimento.substring(8);
			String mes = this.datadenascimento.substring(5, 7);
			String ano = this.datadenascimento.substring(0, 4);

			String dataParaMysql = dia + "-" + mes + "-" + ano;

			return dataParaMysql;

		} else
		{
			return datadenascimento;
		}
	}

	public String getDatadenascimento()
	{
		return datadenascimento;
	}

	public void setDatadenascimento(String datadenascimento)
	{
		this.datadenascimento = datadenascimento;
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
		return cpf == null ? "Don't have!" : cpf;
	}

	public void setCpf(String cpf)
	{

		if (cpf.equals("undefined"))
		{
			this.cpf = "Don't have!";

		} else
		{
			this.cpf = cpf;
		}

	}

	//

	/*-
	 public String dataParaMysql(String data)
	    {
	        String dia = txtAniversario.getText().substring(0,2);
	        String mes = txtAniversario.getText().substring(3,5);
	        String ano = txtAniversario.getText().substring(6);   
	        String dataParaMysql = ano+"-"+mes+"-"+dia;    
	        
	        return dataParaMysql;
	        
	    }
	    
	    //Exemplo Contagem (substring):
	    //(83) 9.9845-4848
	    //(##) #.####-####
	    //0123456789012345
	    public String foneParaMysql(String fone)
	    {
	        String ddd = txtFone.getText().substring(1,3);
	        String nove = txtFone.getText().substring(5,6);
	        String numero1 = txtFone.getText().substring(7,11);   
	        String numero2 = txtFone.getText().substring(12);   
	        String foneParaMysql = ddd+nove+numero1+numero2;    
	        
	        return foneParaMysql;
	        
	    }
	*/
}
