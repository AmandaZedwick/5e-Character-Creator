package edu.niu.cs.amanda.a5echaractercreator;

public class StartEquip
	{
	private int startEquipID, quantity;
	private String name, description, category;

	public StartEquip(int startEquipID, int quantity, String name, String description, String category)
		{
		this.startEquipID = startEquipID;
		this.quantity = quantity;
		this.name = name;
		this.description = description;
		this.category = category;
		}

	public int getStartEquipID()
		{
		return startEquipID;
		}

	public int getQuantity()
		{
		return quantity;
		}

	public String getName()
		{
		return name;
		}

	public String getDescription()
		{
		return description;
		}

	public String getCategory()
		{
		return category;
		}
	}
