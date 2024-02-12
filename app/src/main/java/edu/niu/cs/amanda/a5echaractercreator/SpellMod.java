package edu.niu.cs.amanda.a5echaractercreator;

public class SpellMod
	{
	private int spellModID, classLvlReq, totLvlReq;
	private String spellID;

	public SpellMod(int spellModID, int classLvlReq, int totLvlReq, String spellID)
		{
		this.spellModID = spellModID;
		this.classLvlReq = classLvlReq;
		this.totLvlReq = totLvlReq;
		this.spellID = spellID;
		}

	public int getSpellModID()
		{
		return spellModID;
		}

	public int getClassLvlReq()
		{
		return classLvlReq;
		}

	public int getTotLvlReq()
		{
		return totLvlReq;
		}

	public String getSpellID()
		{
		return spellID;
		}
	}
