
package model;

import java.io.Serializable;

public class Arts implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long idart;

	private String name;

	private String description;

	private String dataDePublicacao;

	private String dataDeExposicao;

	private String idartist;

	private Object image;

	// CONTRUTORES:

	public Arts()
	{
		super();
	}

	public Arts(long idart, String name, String description, String dataDePublicacao, String dataDeExposicao,
			String idartist)
	{
		super();
		this.idart = idart;
		this.name = name;
		this.description = description;
		this.dataDePublicacao = dataDePublicacao;
		this.dataDeExposicao = dataDeExposicao;
		this.idartist = idartist;
	}

	public long getIdart()
	{
		return idart;
	}

	public void setIdart(long idart)
	{
		this.idart = idart;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDataDePublicacao()
	{
		return dataDePublicacao;
	}

	public void setDataDePublicacao(String dataDePublicacao)
	{
		this.dataDePublicacao = dataDePublicacao;
	}

	public String getDataDeExposicao()
	{
		return dataDeExposicao;
	}

	public void setDataDeExposicao(String dataDeExposicao)
	{
		this.dataDeExposicao = dataDeExposicao;
	}

	public String getIdartist()
	{
		return idartist;
	}

	public void setIdartist(String idartist)
	{
		this.idartist = idartist;
	}
}