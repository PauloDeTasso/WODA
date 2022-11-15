
package model;

import java.io.Serializable;

public class NamesArtsArtist implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String nameArt;

	public NamesArtsArtist()
	{
		super();
	}

	public NamesArtsArtist(String nameArt)
	{
		super();
		this.nameArt = nameArt;
	}

	public String getNameArt()
	{
		return nameArt;
	}

	public void setNameArt(String nameArt)
	{
		this.nameArt = nameArt;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
}
