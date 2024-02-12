package edu.niu.cs.amanda.a5echaractercreator;

public class NumChoice
	{
	private int numChoiceID, numChoice, lvlReq;

	public NumChoice(int numChoiceID, int numChoice, int lvlReq)
		{
		this.numChoiceID = numChoiceID;
		this.numChoice = numChoice;
		this.lvlReq = lvlReq;
		}

	public int getNumChoiceID()
		{
		return numChoiceID;
		}

	public int getNumChoice()
		{
		return numChoice;
		}

	public int getLvlReq()
		{
		return lvlReq;
		}
	}
