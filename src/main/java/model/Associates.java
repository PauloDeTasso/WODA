
package model;

import java.io.Serializable;

public class Associates implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long idAssociated;

	private long idArtist;

	private long idArt;

	//

	public Associates()
	{
		super();
	}

	public Associates(long idAssociated, long idArtist, long idArt)
	{
		super();
		this.idAssociated = idAssociated;
		this.idArtist = idArtist;
		this.idArt = idArt;
	}

	//

	public long getIdAssociated()
	{
		return idAssociated;
	}

	public void setIdAssociated(long idAssociated)
	{
		this.idAssociated = idAssociated;
	}

	public long getIdArtist()
	{
		return idArtist;
	}

	public void setIdArtist(long idArtist)
	{
		this.idArtist = idArtist;
	}

	public long getIdArt()
	{
		return idArt;
	}

	public void setIdArt(long idArt)
	{
		this.idArt = idArt;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
}
