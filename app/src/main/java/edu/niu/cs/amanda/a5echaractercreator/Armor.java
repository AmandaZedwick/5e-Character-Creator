package edu.niu.cs.amanda.a5echaractercreator;

public class Armor
	{
	private String name, type;
	private int stealth, ac, addDex, dexMax, strength;

	public Armor(String name, String type, int stealth, int ac, int addDex, int dexMax, int strength)
		{
		setName(name);
		setType(type);
		setStealth(stealth);
		setAc(ac);
		setAddDex(addDex);
		setDexMax(dexMax);
		setStrength(strength);
		}//end constructor

	public String getName()
		{
		return name;
		}

	public void setName(String name)
		{
		this.name = name;
		}

	public String getType()
		{
		return type;
		}

	public void setType(String type)
		{
		this.type = type;
		}

	public int getStealth()
		{
		return stealth;
		}

	public void setStealth(int stealth)
		{
		this.stealth = stealth;
		}

	public int getAc()
		{
		return ac;
		}

	public void setAc(int ac)
		{
		this.ac = ac;
		}

	public int getAddDex()
		{
		return addDex;
		}

	public void setAddDex(int addDex)
		{
		this.addDex = addDex;
		}

	public int getDexMax()
		{
		return dexMax;
		}

	public void setDexMax(int dexMax)
		{
		this.dexMax = dexMax;
		}

	public int getStrength()
		{
		return strength;
		}

	public void setStrength(int strength)
		{
		this.strength = strength;
		}
	}
