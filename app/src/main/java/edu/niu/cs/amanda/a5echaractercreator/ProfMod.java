package edu.niu.cs.amanda.a5echaractercreator;

public class ProfMod
	{
	private int profID, expert, modifier, priority;
	private String name, type;

	public ProfMod(int profID, int expert, int modifier, int priority, String name, String type)
		{
		this.profID = profID;
		this.expert = expert;
		this.modifier = modifier;
		this.priority = priority;
		this.name = name;
		this.type = type;
		}

	public int getProfID()
		{
		return profID;
		}

	public int getExpert()
		{
		return expert;
		}

	public int getModifier()
		{
		return modifier;
		}

	public int getPriority()
		{
		return priority;
		}

	public String getName()
		{
		return name;
		}

	public String getType()
		{
		return type;
		}
	}
