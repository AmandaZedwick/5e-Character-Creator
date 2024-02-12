package edu.niu.cs.amanda.a5echaractercreator;

public class Sheet
	{
	private int charID, classLvl, classLvl2, inspiration, hp, maxHP, tempHP, exhaustionLvl, deleteStat;
	private String name, race, subclass, subclass2, backgroundID;

	public Sheet(int charID, int classLvl, int classLvl2, int inspiration, int hp, int maxHP, int tempHP, int exhaustionLvl, int deleteStat, String name, String race, String subclass, String subclass2, String backgroundID)
		{
		this.charID = charID;
		this.classLvl = classLvl;
		this.classLvl2 = classLvl2;
		this.inspiration = inspiration;
		this.hp = hp;
		this.maxHP = maxHP;
		this.tempHP = tempHP;
		this.exhaustionLvl = exhaustionLvl;
		this.deleteStat = deleteStat;
		this.name = name;
		this.race = race;
		this.subclass = subclass;
		this.subclass2 = subclass2;
		this.backgroundID = backgroundID;
		}

	public int getCharID()
		{
		return charID;
		}

	public int getClassLvl()
		{
		return classLvl;
		}

	public int getClassLvl2()
		{
		return classLvl2;
		}

	public int getInspiration()
		{
		return inspiration;
		}

	public int getHp()
		{
		return hp;
		}

	public int getMaxHP()
		{
		return maxHP;
		}

	public int getTempHP()
		{
		return tempHP;
		}

	public int getExhaustionLvl()
		{
		return exhaustionLvl;
		}

	public int getDeleteStat()
		{
		return deleteStat;
		}

	public String getName()
		{
		return name;
		}

	public String getRace()
		{
		return race;
		}

	public String getSubclass()
		{
		return subclass;
		}

	public String getSubclass2()
		{
		return subclass2;
		}

	public String getBackgroundID()
		{
		return backgroundID;
		}
	}
