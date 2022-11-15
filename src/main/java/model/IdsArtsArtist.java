
package model;

import java.io.Serializable;

public class IdsArtsArtist implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long idArt;

	public IdsArtsArtist()
	{
		super();
	}

	public IdsArtsArtist(Long idArt)
	{
		super();
		this.idArt = idArt;
	}

	public Long getIdArt()
	{
		return idArt;
	}

	public void setIdArt(Long idArt)
	{
		this.idArt = idArt;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
}
