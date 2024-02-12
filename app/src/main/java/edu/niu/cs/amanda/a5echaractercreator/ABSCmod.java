package edu.niu.cs.amanda.a5echaractercreator;

public class ABSCmod
	{
	private int modID, addition, max;
	private String ability;

	public ABSCmod(int modID, int addition, int max, String ability)
		{
		setModID(modID);
		setAddition(addition);
		setMax(max);
		setAbility(ability);
		}

	public int getModID()
		{
		return modID;
		}

	public void setModID(int modID)
		{
		this.modID = modID;
		}

	public int getAddition()
		{
		return addition;
		}

	public void setAddition(int addition)
		{
		this.addition = addition;
		}

	public int getMax()
		{
		return max;
		}

	public void setMax(int max)
		{
		this.max = max;
		}

	public String getAbility()
		{
		return ability;
		}

	public void setAbility(String ability)
		{
		this.ability = ability;
		}
	}
