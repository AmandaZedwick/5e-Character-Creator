package edu.niu.cs.amanda.a5echaractercreator;

public class Defense
	{
	private int defenseID;
	private String name, category;

	public Defense(int defenseID, String name, String category)
		{
		this.defenseID = defenseID;
		this.name = name;
		this.category = category;
		}

	public int getDefenseID()
		{
		return defenseID;
		}

	public String getName()
		{
		return name;
		}

	public String getCategory()
		{
		return category;
		}

	}
