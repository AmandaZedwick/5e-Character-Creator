package edu.niu.cs.amanda.a5echaractercreator;

public class FutureUpgrade
	{
	private int futUpID, featureID, lvlReq;
	private String sourceTable, choiceCategory;

	public FutureUpgrade(int futUpID, int featureID, int lvlReq, String sourceTable, String choiceCategory)
		{
		this.futUpID = futUpID;
		this.featureID = featureID;
		this.lvlReq = lvlReq;
		this.sourceTable = sourceTable;
		this.choiceCategory = choiceCategory;
		}

	public int getFutUpID()
		{
		return futUpID;
		}

	public int getFeatureID()
		{
		return featureID;
		}

	public int getLvlReq()
		{
		return lvlReq;
		}

	public String getSourceTable()
		{
		return sourceTable;
		}

	public String getChoiceCategory()
		{
		return choiceCategory;
		}
	}
