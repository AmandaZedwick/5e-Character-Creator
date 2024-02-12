package edu.niu.cs.amanda.a5echaractercreator;

public class Weapon
	{
	private String name, damageType, category, range, featureIDs, features;
	private int numDice, damageDie, altDamageDie;

	public Weapon(String name, String damageType, String category, String range, String featureIDs, String features, int numDice, int damageDie, int altDamageDie)
		{
		this.name = name;
		this.damageType = damageType;
		this.category = category;
		this.range = range;
		this.featureIDs = featureIDs;
		this.features = features;
		this.numDice = numDice;
		this.damageDie = damageDie;
		}

	public String getName()
		{
		return name;
		}

	public String getDamageType()
		{
		return damageType;
		}

	public String getCategory()
		{
		return category;
		}

	public String getRange()
		{
		return range;
		}

	public String getFeatureIDs()
		{
		return featureIDs;
		}

	public String getFeatures()
		{
		return features;
		}

	public int getNumDice()
		{
		return numDice;
		}

	public int getDamageDie()
		{
		return damageDie;
		}

	public int getAltDamageDie()
		{
		return altDamageDie;
		}
	}
