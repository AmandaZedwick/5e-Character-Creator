package edu.niu.cs.amanda.a5echaractercreator;

public class Background
	{
	private String name, description, equipment, equipIDs;
	private int featureID;

	public Background(String name, String description, String equipment, String equipIDs, int featureID)
		{
		this.name = name;
		this.description = description;
		this.equipment = equipment;
		this.equipIDs = equipIDs;
		this.featureID = featureID;
		}

	public String getName()
		{
		return name;
		}

	public String getDescription()
		{
		return description;
		}

	public String getEquipment()
		{
		return equipment;
		}

	public String getEquipIDs()
		{
		return equipIDs;
		}

	public int getFeatureID()
		{
		return featureID;
		}
	}
