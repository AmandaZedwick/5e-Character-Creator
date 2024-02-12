package edu.niu.cs.amanda.a5echaractercreator;

public class ACmod
	{
	private int modID, base, priority, dexPreReq, addition, stealthDis;
	private String armorPreReq, categoryPreReq, abscMod;

	public ACmod(int modID, int base, int priority, int dexPreReq, int addition, int stealthDis, String armorPreReq, String categoryPreReq, String abscMod)
		{
		this.modID = modID;
		this.base = base;
		this.priority = priority;
		this.dexPreReq = dexPreReq;
		this.addition = addition;
		this.stealthDis = stealthDis;
		this.armorPreReq = armorPreReq;
		this.categoryPreReq = categoryPreReq;
		this.abscMod = abscMod;
		}

	public int getModID()
		{
		return modID;
		}

	public int getBase()
		{
		return base;
		}

	public int getPriority()
		{
		return priority;
		}

	public int getDexPreReq()
		{
		return dexPreReq;
		}

	public int getAddition()
		{
		return addition;
		}

	public int getStealthDis()
		{
		return stealthDis;
		}

	public String getArmorPreReq()
		{
		return armorPreReq;
		}

	public String getCategoryPreReq()
		{
		return categoryPreReq;
		}

	public String getAbscMod()
		{
		return abscMod;
		}
	}
