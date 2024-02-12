package edu.niu.cs.amanda.a5echaractercreator;

public class Count
	{
	private int countID, min, addition;
	private String name, resetTrigger, source, tableSrc;
	private double sourceMult;

	public Count(int countID, int min, int addition, String name, String resetTrigger, String source, String tableSrc, double sourceMult)
		{
		this.countID = countID;
		this.min = min;
		this.addition = addition;
		this.name = name;
		this.resetTrigger = resetTrigger;
		this.source = source;
		this.tableSrc = tableSrc;
		this.sourceMult = sourceMult;
		}

	public int getCountID()
		{
		return countID;
		}

	public int getMin()
		{
		return min;
		}

	public int getAddition()
		{
		return addition;
		}

	public String getName()
		{
		return name;
		}

	public String getResetTrigger()
		{
		return resetTrigger;
		}

	public String getSource()
		{
		return source;
		}

	public String getTableSrc()
		{
		return tableSrc;
		}

	public double getSourceMult()
		{
		return sourceMult;
		}
	}
