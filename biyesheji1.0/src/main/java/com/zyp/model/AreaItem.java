package com.zyp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable  
public class AreaItem implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6926684673233262885L;

	@Column(length=20)
	private String startArea;
	@Column(length=20)
	private String endArea;

	public String getStartArea()
	{
		return startArea;
	}

	public void setStartArea(String startArea)
	{
		this.startArea = startArea;
	}

	public String getEndArea()
	{
		return endArea;
	}

	public void setEndArea(String endArea)
	{
		this.endArea = endArea;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endArea == null) ? 0 : endArea.hashCode());
		result = prime * result + ((startArea == null) ? 0 : startArea.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaItem other = (AreaItem) obj;
		if (endArea == null)
		{
			if (other.endArea != null)
				return false;
		} else if (!endArea.equals(other.endArea))
			return false;
		if (startArea == null)
		{
			if (other.startArea != null)
				return false;
		} else if (!startArea.equals(other.startArea))
			return false;
		return true;
	}

	public AreaItem()
	{
		
	}
	
	
	
}
