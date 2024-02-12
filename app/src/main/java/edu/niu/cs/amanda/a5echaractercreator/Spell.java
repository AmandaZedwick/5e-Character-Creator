package edu.niu.cs.amanda.a5echaractercreator;

public class Spell
	{
	private String name, castingTime, range, components, duration, school, save, effectDamage, description, classes;
	private int level;

	//constructor
	public Spell(String name, String castingTime, String range, String components, String duration, String school,
				 String save, String effectDamage, String description, String classes, int level)
		{
		setName(name);
		setCastingTime(castingTime);
		setRange(range);
		setComponents(components);
		setDuration(duration);
		setSchool(school);
		setSave(save);
		setEffectDamage(effectDamage);
		setDescription(description);
		setClasses(classes);
		setLevel(level);
		}//end constructor

	public String getName()
		{
		return name;
		}//end getName

	public void setName(String newName)
		{
		name = newName;
		}//end setName

	public String getRange()
		{
		return range;
		}//end getRange

	public void setRange(String newRange)
		{
		range = newRange;
		}//end setRange

	public String getCastingTime()
		{
		return castingTime;
		}//end getCastingTime

	public void setCastingTime(String castingTime)
		{
		this.castingTime = castingTime;
		}//end setCastingTime

	public String getComponents()
		{
		return components;
		}//end getComponents

	public void setComponents(String components)
		{
		this.components = components;
		}//end setComponents

	public String getDuration()
		{
		return duration;
		}//end getDuration

	public void setDuration(String duration)
		{
		this.duration = duration;
		}//end setDuration

	public String getSchool()
		{
		return school;
		}//end getSchool

	public void setSchool(String school)
		{
		this.school = school;
		}//end setSchool

	public String getSave()
		{
		return save;
		}//end getSave

	public void setSave(String save)
		{
		this.save = save;
		}//end setSave

	public String getEffectDamage()
		{
		return effectDamage;
		}//end getEffectDamage

	public void setEffectDamage(String effectDamage)
		{
		this.effectDamage = effectDamage;
		}//end setEffectDamage

	public String getDescription()
		{
		return description;
		}//end getDescription

	public void setDescription(String description)
		{
		this.description = description;
		}//end setDescription

	public String getClasses()
		{
		return classes;
		}//end getClasses

	public void setClasses(String classes)
		{
		this.classes = classes;
		}//get setClasses

	public int getLevel()
		{
		return level;
		}//end getLevel

	public void setLevel(int level)
		{
		if (level < 0)
			{
			level = 0;
			}//end if
		this.level = level;
		}//end setLevel

	public String spellToString()
		{
		String spellDesc = description;

		String spellDescFull;

		if (level == 0)
			{
			spellDescFull = school + " Cantrip\nCasting Time: " + castingTime + "\nRange/Area: " +
					range + "\nComponents: " + components + "\nDuration: " + duration + "\nAttack/Save: " +
					save + "\nDamage/Effect: " + effectDamage + "\n\n" + spellDesc + "\n\n\n" + "Classes: " + classes;
			}
		else
			{
			spellDescFull = "Level " + level + " " + school + " Spell\nCasting Time: " + castingTime + "\nRange/Area: " +
					range + "\nComponents: " + components + "\nDuration: " + duration + "\nAttack/Save: " +
					save + "\nDamage/Effect: " + effectDamage + "\n\n" + spellDesc + "\n\n\n" + "Classes: " + classes;
			}

		return spellDescFull;
		}//end spellToString
	}
