package edu.niu.cs.amanda.a5echaractercreator;

public class Passives
	{
	private int passiveID, advDisMod, addition, base;
	private String abscBonus, category;

	public Passives(int passiveID, int advDisMod, int addition, int base, String abscBonus, String category)
		{
		this.passiveID = passiveID;
		this.advDisMod = advDisMod;
		this.addition = addition;
		this.base = base;
		this.abscBonus = abscBonus;
		this.category = category;
		}

	public int getPassiveID()
		{
		return passiveID;
		}

	public int getAdvDisMod()
		{
		return advDisMod;
		}

	public int getAddition()
		{
		return addition;
		}

	public int getBase()
		{
		return base;
		}

	public String getAbscBonus()
		{
		return abscBonus;
		}

	public String getCategory()
		{
		return category;
		}
	}
