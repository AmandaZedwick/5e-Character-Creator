package edu.niu.cs.amanda.a5echaractercreator;

public class SpeedMod
	{
	private int id, base, addition, lvlReq, equalWalk;
	private String type, negateBy, preReq;

	public SpeedMod(int id, int base, int addition, int lvlReq, int equalWalk, String type, String negateBy, String preReq)
		{
		this.id = id;
		this.base = base;
		this.addition = addition;
		this.lvlReq = lvlReq;
		this.equalWalk = equalWalk;
		this.type = type;
		this.negateBy = negateBy;
		this.preReq = preReq;
		}

	public int getId()
		{
		return id;
		}

	public int getBase()
		{
		return base;
		}

	public int getAddition()
		{
		return addition;
		}

	public int getLvlReq()
		{
		return lvlReq;
		}

	public int getEqualWalk()
		{
		return equalWalk;
		}

	public String getType()
		{
		return type;
		}

	public String getNegateBy()
		{
		return negateBy;
		}

	public String getPreReq()
		{
		return preReq;
		}
	}
