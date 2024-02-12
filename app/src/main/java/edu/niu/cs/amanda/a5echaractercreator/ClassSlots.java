package edu.niu.cs.amanda.a5echaractercreator;

public class ClassSlots
	{
	private String className, extra;
	private int level, cantrips, known, first, second, third, fourth, fifth, sixth, seventh,
			eighth, ninth;

	public ClassSlots(String className, int level, String extra, int cantrips, int known, int first,
					  int second, int third, int fourth, int fifth, int sixth, int seventh, int eighth,
					  int ninth)
		{
		setClassName(className);
		setLevel(level);
		setExtra(extra);
		setCantrips(cantrips);
		setKnown(known);
		setFirst(first);
		setSecond(second);
		setThird(third);
		setFourth(fourth);
		setFifth(fifth);
		setSixth(sixth);
		setSeventh(seventh);
		setEighth(eighth);
		setNinth(ninth);
		}//end constructor

	public String getClassName()
		{
		return className;
		}

	public void setClassName(String className)
		{
		this.className = className;
		}

	public int getLevel()
		{
		return level;
		}

	public void setLevel(int level)
		{
		this.level = level;
		}

	public String getExtra()
		{
		return extra;
		}

	public void setExtra(String extra)
		{
		this.extra = extra;
		}

	public int getCantrips()
		{
		return cantrips;
		}

	public void setCantrips(int cantrips)
		{
		this.cantrips = cantrips;
		}

	public int getKnown()
		{
		return known;
		}

	public void setKnown(int known)
		{
		this.known = known;
		}

	public int getFirst()
		{
		return first;
		}

	public void setFirst(int first)
		{
		this.first = first;
		}

	public int getSecond()
		{
		return second;
		}

	public void setSecond(int second)
		{
		this.second = second;
		}

	public int getThird()
		{
		return third;
		}

	public void setThird(int third)
		{
		this.third = third;
		}

	public int getFourth()
		{
		return fourth;
		}

	public void setFourth(int fourth)
		{
		this.fourth = fourth;
		}

	public int getFifth()
		{
		return fifth;
		}

	public void setFifth(int fifth)
		{
		this.fifth = fifth;
		}

	public int getSixth()
		{
		return sixth;
		}

	public void setSixth(int sixth)
		{
		this.sixth = sixth;
		}

	public int getSeventh()
		{
		return seventh;
		}

	public void setSeventh(int seventh)
		{
		this.seventh = seventh;
		}

	public int getEighth()
		{
		return eighth;
		}

	public void setEighth(int eighth)
		{
		this.eighth = eighth;
		}

	public int getNinth()
		{
		return ninth;
		}

	public void setNinth(int ninth)
		{
		this.ninth = ninth;
		}
	}
