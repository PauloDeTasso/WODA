
package model;

import java.io.Serializable;

public class Searcher implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String searcher;

	public Searcher()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Searcher(String searcher)
	{
		super();
		this.searcher = searcher;
	}

	public String getSeacher()
	{
		return searcher;
	}

	public void setSeacher(String searcher)
	{
		this.searcher = searcher;
	}

}
