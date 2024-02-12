package edu.niu.cs.amanda.a5echaractercreator;

public class Choice
	{
	private int choiceID, searchID, displayDesc, choiceNum, priority;
	private String searchTable, displayName, featureIDs, choiceCat, futureUpgrades;

	public Choice(int choiceID, int searchID, int displayDesc, int choiceNum, int priority, String searchTable, String displayName, String featureIDs, String choiceCat, String futureUpgrades)
		{
		this.choiceID = choiceID;
		this.searchID = searchID;
		this.displayDesc = displayDesc;
		this.choiceNum = choiceNum;
		this.priority = priority;
		this.searchTable = searchTable;
		this.displayName = displayName;
		this.featureIDs = featureIDs;
		this.choiceCat = choiceCat;
		this.futureUpgrades = futureUpgrades;
		}

	public int getChoiceID()
		{
		return choiceID;
		}

	public int getSearchID()
		{
		return searchID;
		}

	public int getDisplayDesc()
		{
		return displayDesc;
		}

	public int getChoiceNum()
		{
		return choiceNum;
		}

	public int getPriority()
		{
		return priority;
		}

	public String getSearchTable()
		{
		return searchTable;
		}

	public String getDisplayName()
		{
		return displayName;
		}

	public String getFeatureIDs()
		{
		return featureIDs;
		}

	public String getChoiceCat()
		{
		return choiceCat;
		}

	public String getFutureUpgrades()
		{
		return futureUpgrades;
		}
	}
