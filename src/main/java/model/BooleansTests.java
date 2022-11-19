
package model;

import java.io.Serializable;

public class BooleansTests implements Serializable
{
	private static final long serialVersionUID = 1L;

	private boolean decision;

	public BooleansTests()
	{
		super();
	}

	public BooleansTests(boolean decision)
	{
		super();
		this.decision = decision;
	}

	public boolean isDecision()
	{
		return decision;
	}

	public void setDecision(boolean decision)
	{
		this.decision = decision;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
