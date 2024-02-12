package edu.niu.cs.amanda.a5echaractercreator;

public class Item
	{
	private int invID, charID, quantity, equippable, attunement, equipped, attuned;
	private String name, description, category;

	public Item(int invID, int charID, int quantity, int equippable, int attunement, int equipped, int attuned, String name, String description, String category)
		{
		this.invID = invID;
		this.charID = charID;
		this.quantity = quantity;
		this.equippable = equippable;
		this.attunement = attunement;
		this.equipped = equipped;
		this.attuned = attuned;
		this.name = name;
		this.description = description;
		this.category = category;
		}

	public int getInvID()
		{
		return invID;
		}

	public int getCharID()
		{
		return charID;
		}

	public int getQuantity()
		{
		return quantity;
		}

	public int getEquippable()
		{
		return equippable;
		}

	public int getAttunement()
		{
		return attunement;
		}

	public int getEquipped()
		{
		return equipped;
		}

	public int getAttuned()
		{
		return attuned;
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
