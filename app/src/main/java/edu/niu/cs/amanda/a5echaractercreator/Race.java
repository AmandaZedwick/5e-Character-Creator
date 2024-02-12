package edu.niu.cs.amanda.a5echaractercreator;

public class Race
	{
	private String subrace, race, abscIncrease, size, profIDs, featureIDs, description, speed;
	private int lifespan;

	public Race(String subrace, String race, String abscIncrease, String size, String profIDs, String featureIDs, String description, int lifespan, String speed)
		{
		this.subrace = subrace;
		this.race = race;
		this.abscIncrease = abscIncrease;
		this.size = size;
		this.profIDs = profIDs;
		this.featureIDs = featureIDs;
		this.description = description;
		this.lifespan = lifespan;
		this.speed = speed;
		}

	public String getSubrace()
		{
		return subrace;
		}

	public String getRace()
		{
		return race;
		}

	public String getAbscIncrease()
		{
		return abscIncrease;
		}

	public String getSize()
		{
		return size;
		}

	public String getProfIDs()
		{
		return profIDs;
		}

	public String getFeatureIDs()
		{
		return featureIDs;
		}

	public String getDescription()
		{
		return description;
		}

	public int getLifespan()
		{
		return lifespan;
		}

	public String getSpeed()
		{
		return speed;
		}
	}
