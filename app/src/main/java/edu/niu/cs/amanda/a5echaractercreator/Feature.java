package edu.niu.cs.amanda.a5echaractercreator;

public class Feature
	{
	private int featureID, equip, numChoices;
	private String name, description, countInfo, spellsGiven, defenses, bonusTables, acMods, speed, passives,
			saveDC, choiceLim, abscInc, profIDs, category;

	public Feature(int featureID, int equip, int numChoices, String name, String description, String countInfo, String spellsGiven, String defenses, String bonusTables, String acMods, String speed, String passives, String saveDC, String choiceLim, String abscInc, String profIDs, String category)
		{
		this.featureID = featureID;
		this.equip = equip;
		this.numChoices = numChoices;
		this.name = name;
		this.description = description;
		this.countInfo = countInfo;
		this.spellsGiven = spellsGiven;
		this.defenses = defenses;
		this.bonusTables = bonusTables;
		this.acMods = acMods;
		this.speed = speed;
		this.passives = passives;
		this.saveDC = saveDC;
		this.choiceLim = choiceLim;
		this.abscInc = abscInc;
		this.profIDs = profIDs;
		this.category = category;
		}

	public int getFeatureID()
		{
		return featureID;
		}

	public int getEquip()
		{
		return equip;
		}

	public int getNumChoices()
		{
		return numChoices;
		}

	public String getName()
		{
		return name;
		}

	public String getDescription()
		{
		return description;
		}

	public String getCountInfo()
		{
		return countInfo;
		}

	public String getSpellsGiven()
		{
		return spellsGiven;
		}

	public String getDefenses()
		{
		return defenses;
		}

	public String getBonusTables()
		{
		return bonusTables;
		}

	public String getAcMods()
		{
		return acMods;
		}

	public String getSpeed()
		{
		return speed;
		}

	public String getPassives()
		{
		return passives;
		}

	public String getSaveDC()
		{
		return saveDC;
		}

	public String getChoiceLim()
		{
		return choiceLim;
		}

	public String getAbscInc()
		{
		return abscInc;
		}

	public String getProfIDs()
		{
		return profIDs;
		}

	public String getCategory()
		{
		return category;
		}
	}
