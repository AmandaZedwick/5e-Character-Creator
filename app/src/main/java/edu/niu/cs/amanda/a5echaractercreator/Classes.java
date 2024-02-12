package edu.niu.cs.amanda.a5echaractercreator;

public class Classes
	{
	private String subclass, className, equipIDs, featureIDs, description, equipment;
	private int hitDie, lvlReq;

	public Classes(String subclass, String className, String equipIDs, String featureIDs, String description,
				   String equipment, int hitDie, int lvlReq)
		{
		this.subclass = subclass;
		this.className = className;
		this.equipIDs = equipIDs;
		this.featureIDs = featureIDs;
		this.description = description;
		this.equipment = equipment;
		this.hitDie = hitDie;
		this.lvlReq = lvlReq;
		}

	public String getSubclass()
		{
		return subclass;
		}

	public String getClassName()
		{
		return className;
		}

	public String getEquipIDs()
		{
		return equipIDs;
		}

	public String getFeatureIDs()
		{
		return featureIDs;
		}

	public String getDescription()
		{
		return description;
		}

	public String getEquipment()
		{
		return equipment;
		}

	public int getHitDie()
		{
		return hitDie;
		}

	public int getLvlReq()
		{
		return lvlReq;
		}
	}
