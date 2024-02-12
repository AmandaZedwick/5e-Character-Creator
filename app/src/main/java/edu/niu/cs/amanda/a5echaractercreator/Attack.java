package edu.niu.cs.amanda.a5echaractercreator;

public class Attack
	{
	private int id;
	private String name, range, bonus, dmg, dmgType, description;

	public Attack(int id, String name, String range, String bonus, String dmg, String dmgType, String description)
		{
		setId(id);
		setName(name);
		setRange(range);
		setBonus(bonus);
		setDmg(dmg);
		setDmgType(dmgType);
		setDescription(description);
		}//end Attack

	public int getId()
		{
		return id;
		}

	public void setId(int id)
		{
		this.id = id;
		}

	public String getName()
		{
		return name;
		}

	public void setName(String name)
		{
		this.name = name;
		}

	public String getRange()
		{
		return range;
		}

	public void setRange(String range)
		{
		this.range = range;
		}

	public String getBonus()
		{
		return bonus;
		}

	public void setBonus(String bonus)
		{
		this.bonus = bonus;
		}

	public String getDmg()
		{
		return dmg;
		}

	public void setDmg(String dmg)
		{
		this.dmg = dmg;
		}

	public String getDmgType()
		{
		return dmgType;
		}

	public void setDmgType(String dmgType)
		{
		this.dmgType = dmgType;
		}

	public String getDescription()
		{
		return description;
		}

	public void setDescription(String description)
		{
		this.description = description;
		}

	public String attackToString()
		{

		return "Range: " + getRange() + "\nBonus: " + getBonus() + "\nDamage: " + getDmg()
				+ "\nDamage Type: " + getDmgType() + "\n\nDescription:\n\t" + getDescription();
		}
	}
