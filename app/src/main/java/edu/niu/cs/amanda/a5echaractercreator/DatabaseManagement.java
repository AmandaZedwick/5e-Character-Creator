package edu.niu.cs.amanda.a5echaractercreator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManagement extends SQLiteOpenHelper
	{

	private final static int DATABASE_VERSION = 101;
	private static final String DATABASE_NAME = "dndDatabase";

	//constructor
	public DatabaseManagement(Context context)
		{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}//end DatabaseManager

	@Override
	public void onCreate(SQLiteDatabase database)
		{
		database.execSQL("create table armors ( armorName text primary key, stealthDis integer, baseAC integer, addDex integer, dexMax integer, type text, strMax integer)");
		database.execSQL("create table backgrounds ( bgdName text primary key, description text, equipIDs text, equipSummary text, featureID integer)");
		database.execSQL("create table classes ( subclass text primary key, class text,lvlReq integer, hitDie integer, equipIDs text, equipment text, featureIDs text, description text)");
		database.execSQL("create table races ( subrace text primary key, race text, abscIncrease text, lifespan integer, size text, speed integer, profIDs text, featureIDs text, description text)");
		database.execSQL("create table choices ( choiceID integer primary key, featureIDs text, searchID integer, searchTable text, displayName text, displayDesc bit, choiceCat text, choiceNum integer, futureUpgrades text, priority integer)");
		database.execSQL("create table features (featureID integer primary key, name text, description text, countInfo text, spellsGiven text, defenses text, bonusTables text, acMods text, speed text, passives text, equippable bit, saveDC text, numChoices integer, choiceLim text, abscInc text, profIDs text, category text)");
		database.execSQL("create table spells ( spellName text primary key, level integer, castTime text, range text, components text, duration text, school text, save text, effect text, description text, classList text)");
		database.execSQL("create table weapons ( weaponName text primary key, numDice integer, damageDie integer, altDamageDie integer, damageType text, category text, range text, featureIDs text, features text)");
		database.execSQL("create table futureUpgrades ( futUpID integer primary key, featureID integer, sourceTable text, choiceCategory text, lvlReq integer)");
		database.execSQL("create table numChoices ( numChoiceID integer primary key, numChoices integer, lvlReq integer)");
		database.execSQL("create table acMods ( acModID integer primary key, base integer, priority integer, armorPreReq text, categoryPreReq text, dexPreReq integer, abscMod text, addition integer, stealthDis bit)");
		database.execSQL("create table defenses ( defenseID integer primary key, name text, category text)");
		database.execSQL("create table countInfo ( countID integer primary key, name text, resetTrigger text, source text, sourceMult decimal(2,1), tableSrc text, min integer, addition integer)");
		database.execSQL("create table abscMods ( abscModID integer primary key, ability text, addition integer, max integer)");
		database.execSQL("create table speedMods ( speedModID integer primary key, type text, base integer, addition integer, equalWalk bit, lvlReq integer, negateBy text, preReq text)");
		database.execSQL("create table profMods ( profID integer primary key, name text, type text, expert integer, modifier integer, priority integer)");
		database.execSQL("create table passiveMods ( passiveID integer primary key, advDisMod integer, addition integer, abscBonus text, base integer, category text)");
		database.execSQL("create table startEquip ( startEquipID integer primary key, name text, quantity integer, description text, category text)");
		database.execSQL("create table sheets ( charID integer primary key autoincrement, name text, race text, subclass text, classLvl integer, subclass2 text, classLvl2 integer, inspiration bit, backgroundID text, hp integer, maxHP integer, tempHP integer, exhaustionLvl integer, deleteStatus bit)");
		database.execSQL("create table classSlots ( className text, level integer, extra integer, cantrips integer, known integer, first integer, second integer, third integer, fourth integer, fifth integer, sixth integer, seventh integer, eighth integer, ninth integer, primary key (className, level), foreign key ( level ) references sheets ( level ))");
		database.execSQL("create table spellMods ( spellModID integer primary key, spellID text, classLvlReq integer, totLvlReq integer, foreign key ( spellID ) references spells (spellName))");
		database.execSQL("create table charNotes ( noteID integer primary key autoincrement, charID integer, contents text, mainCategory text, secondaryCategory text, foreign key ( charID ) references sheets ( charID ))");
		database.execSQL("create table charSpells ( charSpellID integer primary key autoincrement, charID integer, spellName text, sourceFeature integer, lvlGained integer, foreign key ( charID ) references sheets ( charID ), foreign key ( spellName ) references spells ( spellName ), foreign key ( sourceFeature ) references features ( featureID))");
		database.execSQL("create table charAbilities ( charID integer, name text, value integer, primary key ( charID, name ), foreign key ( charID ) references sheets ( charID ))");
		database.execSQL("create table charAtks ( atkID integer primary key autoincrement, charID integer, name text, range text, numDice integer, damageDie integer, damageType text, absc text, addition integer, foreign key ( charID ) references sheets ( charID ))");
		database.execSQL("create table charMods ( featureID integer, charID integer, lvlGained integer, classSource text, choiceID integer, isUpgrade bit, equipped bit, attuned bit, foreign key ( charID ) references sheets ( charID ), foreign key ( choiceID ) references choices ( choiceID ), foreign key ( featureID ) references features ( featureID ), foreign key ( classSource ) references classes ( subclass ), primary key ( charID, featureID ))");
		database.execSQL("create table charInventory ( invID integer primary key autoincrement, charID integer, name text, quantity integer, description text, category text, equippable bit, attunement bit, equipped bit, attuned bit, foreign key ( charID ) references sheets ( charID ))");
		database.execSQL("create table charProfs ( charID integer, profID integer, foreign key ( charID ) references sheets ( charID ), foreign key ( profID ) references profMods ( profID ), primary key ( charID, profID ))");
		database.execSQL("create table charSpellSlots ( charID integer, level integer, category text, foreign key ( charID ) references sheets ( charID ), primary key ( charID, level ))");
		}

	@Override
	public void onUpgrade(SQLiteDatabase database, int i, int i1)
		{
		database.execSQL("drop table if exists armors");
		database.execSQL("drop table if exists backgrounds");
		database.execSQL("drop table if exists classes");
		database.execSQL("drop table if exists classSlots");
		database.execSQL("drop table if exists races");
		database.execSQL("drop table if exists choices");
		database.execSQL("drop table if exists features");
		database.execSQL("drop table if exists spells");
		database.execSQL("drop table if exists weapons");
		database.execSQL("drop table if exists futureUpgrades");
		database.execSQL("drop table if exists numChoices");
		database.execSQL("drop table if exists spellMods");
		database.execSQL("drop table if exists abscMods");
		database.execSQL("drop table if exists speedMods");
		database.execSQL("drop table if exists acMods");
		database.execSQL("drop table if exists defenses");
		database.execSQL("drop table if exists countInfo");
		database.execSQL("drop table if exists profMods");
		database.execSQL("drop table if exists passiveMods");
		database.execSQL("drop table if exists startEquip");
		database.execSQL("drop table if exists sheets");
		database.execSQL("drop table if exists charNotes");
		database.execSQL("drop table if exists charProfs");
		database.execSQL("drop table if exists charInventory");
		database.execSQL("drop table if exists charMods");
		database.execSQL("drop table if exists charAtks");
		database.execSQL("drop table if exists charAbilities");
		database.execSQL("drop table if exists charSpells");
		database.execSQL("drop table if exists charSpellSlots");

		onCreate(database);
		}
	public void insertAbscMod(ABSCmod mod)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{mod.getAbility()};

		database.execSQL("insert into abscMods values ( " + mod.getModID() + ", ?, " + mod.getAddition()
				+ ", " + mod.getMax() + " )", selectionArgs);

		database.close();
		}

	public void insertACMod(ACmod acMod)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{acMod.getArmorPreReq(), acMod.getCategoryPreReq(), acMod.getAbscMod()};

		database.execSQL("insert into acMods values ( " + acMod.getModID() + ", " + acMod.getBase() + ", " + acMod.getPriority()
				+ ", ?, ?, " + acMod.getDexPreReq() + ", ?, " + acMod.getAddition() + ", " + acMod.getStealthDis()
				+ " )", selectionArgs);

		database.close();
		}

	public void insertArmor(Armor armor)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{armor.getName(), armor.getType()};

		database.execSQL("insert into armors values ( ?, " + armor.getStealth() + ", " + armor.getAc() +
						", " + armor.getAddDex() + ", " + armor.getDexMax() + ", ?, " + armor.getStrength() + " )",
				selectionArgs);

		database.close();
		}

	public void insertBackground(Background background)
		{
		SQLiteDatabase database = getWritableDatabase();

		String [] selectionArgs = new String[]{background.getName(), background.getDescription(),
				background.getEquipIDs(), background.getEquipment()};

		database.execSQL("insert into backgrounds values ( ?, ?, ?, ?, " + background.getFeatureID() + " )", selectionArgs);

		database.close();
		}

	public void insertChoice(Choice choice)
		{
		SQLiteDatabase database = getWritableDatabase();

		String [] selectionArgs = new String[]{choice.getFeatureIDs(), choice.getSearchTable(),
				choice.getDisplayName(), choice.getChoiceCat(), choice.getFutureUpgrades()};

		database.execSQL("insert into choices values ( " + choice.getChoiceID() + ", ?, " + choice.getSearchID() +
						", ?, ?, " + choice.getDisplayDesc() + ", ?, " + choice.getChoiceNum() + ", ?, " + choice.getPriority() +
						" )",
				selectionArgs);

		database.close();
		}

	public void insertClass(Classes newClass)
		{
		SQLiteDatabase database = getWritableDatabase();

		String [] selectionArgs = new String[]{newClass.getSubclass(), newClass.getClassName(),
				newClass.getEquipment(), newClass.getEquipIDs(), newClass.getFeatureIDs(), newClass.getDescription()};

		database.execSQL("insert into classes values ( ?, ?, " + newClass.getLvlReq() + ", " + newClass.getHitDie() +
				", ?, ?, ?, ? )", selectionArgs);

		database.close();
		}

	public void insertClassSlots(ClassSlots classSlots)
		{
		SQLiteDatabase database = getWritableDatabase();

		String [] selectionArgs = new String[]{classSlots.getClassName()};

		database.execSQL("insert into classSlots values ( ?, " + classSlots.getLevel() + ", " + classSlots.getExtra() +
				", " + classSlots.getCantrips() + ", " + classSlots.getKnown() + ", " + classSlots.getFirst() + ", " +
				classSlots.getSecond() + ", " + classSlots.getThird() + ", " + classSlots.getFourth() + ", " +
				classSlots.getFifth() + ", " + classSlots.getSixth() + ", " + classSlots.getSeventh() + ", " +
				classSlots.getEighth() + ", " + classSlots.getNinth() + " )", selectionArgs);

		database.close();
		}

	public void insertCount(Count count)
		{
		SQLiteDatabase database = getWritableDatabase();

		String [] selectionArgs = new String[]{count.getName(), count.getResetTrigger(), count.getSource(), count.getTableSrc()};

		database.execSQL("insert into countInfo values ( " + count.getCountID() + ", ?, ?, ?, " + count.getSourceMult()
				+ ", ?, " + count.getMin() + ", " + count.getAddition() + " )", selectionArgs);

		database.close();
		}

	public void insertDefense(Defense newDefense)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{newDefense.getName(), newDefense.getCategory()};

		database.execSQL("insert into defenses values ( " + newDefense.getDefenseID() + ", ?, ? )", selectionArgs);

		database.close();
		}

	public void insertFeature(Feature newFeature)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{newFeature.getName(), newFeature.getDescription(), newFeature.getCountInfo(),
		newFeature.getSpellsGiven(), newFeature.getDefenses(), newFeature.getBonusTables(), newFeature.getAcMods(),
		newFeature.getSpeed(), newFeature.getPassives(), newFeature.getSaveDC(), newFeature.getChoiceLim(),
		newFeature.getAbscInc(), newFeature.getProfIDs(), newFeature.getCategory()};

		database.execSQL("insert into features values ( " + newFeature.getFeatureID() + ", ?, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ newFeature.getEquip() + ", ?, " + newFeature.getNumChoices() + ", ?, ?, ?, ? )", selectionArgs);

		database.close();
		}

	public void insertFutureUpgrade(FutureUpgrade futureUpgrade)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{futureUpgrade.getSourceTable(), futureUpgrade.getChoiceCategory()};

		database.execSQL("insert into futureUpgrades values ( " + futureUpgrade.getFutUpID() + ", " + futureUpgrade.getFeatureID() +
				", ?, ?, " + futureUpgrade.getLvlReq() + " )", selectionArgs);

		database.close();
		}

	public void insertNumChoice(NumChoice numChoice)
		{
		SQLiteDatabase database = getWritableDatabase();

		database.execSQL("insert into numChoices values ( " + numChoice.getNumChoiceID() + ", " + numChoice.getNumChoice() +
				", " + numChoice.getLvlReq() + " )");

		database.close();
		}

	public void insertPassive(Passives passives)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{passives.getAbscBonus(), passives.getCategory()};

		database.execSQL("insert into passiveMods values ( " + passives.getPassiveID() + ", " + passives.getAdvDisMod() +
				", " + passives.getAddition() + ", ?, " + passives.getBase() + ", ? )", selectionArgs);

		database.close();
		}

	public void insertProf(ProfMod prof)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{prof.getName(), prof.getType()};

		database.execSQL("insert into profMods values ( " + prof.getProfID() + ", ?, ?, " + prof.getExpert() +
				", " + prof.getModifier() + ", " + prof.getPriority() + " )", selectionArgs);

		database.close();
		}

	public void insertRace(Race race)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{race.getSubrace(), race.getRace(), race.getAbscIncrease(),
		race.getSize(), race.getProfIDs(), race.getFeatureIDs(), race.getDescription()};

		database.execSQL("insert into races values ( ?, ?, ?, " + race.getLifespan() + ", ?, " +
				race.getSpeed() + ", ?, ?, ? )", selectionArgs);

		database.close();
		}

	public void insertSpeedMod(SpeedMod speedMod)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{speedMod.getType(), speedMod.getNegateBy(), speedMod.getPreReq()};

		database.execSQL("insert into speedMods values ( " + speedMod.getId() + ", ?, " + speedMod.getBase() +
				", " + speedMod.getAddition() + ", " + speedMod.getEqualWalk() + ", " + speedMod.getLvlReq() +
				", ?, ? )", selectionArgs);

		database.close();
		}

	public void insertSpellMod(SpellMod spellMod)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{spellMod.getSpellID()};

		database.execSQL("insert into spellMods values ( " + spellMod.getSpellModID() + ", ?, " + spellMod.getClassLvlReq() +
				", " + spellMod.getTotLvlReq() + " )", selectionArgs);

		database.close();
		}

	public void insertSpell(Spell spell)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{spell.getName(), spell.getCastingTime(), spell.getRange(),
		spell.getComponents(), spell.getDuration(), spell.getSchool(), spell.getSave(), spell.getEffectDamage(),
		spell.getDescription(), spell.getClasses()};

		database.execSQL("insert into spells values( ?, " + spell.getLevel() + ", ?, ?, ?, ?, ?, ?, ?, ?, ? )", selectionArgs);

		database.close();
		}

	public void insertStartEquip(StartEquip startEquip)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{startEquip.getName(), startEquip.getDescription(), startEquip.getCategory()};

		database.execSQL("insert into startEquip values( " + startEquip.getStartEquipID() + ", ?, " +
				startEquip.getQuantity() + ", ?, ? )", selectionArgs);

		database.close();
		}

	public void insertWeapon(Weapon weapon)
		{
		SQLiteDatabase database = getWritableDatabase();

		String[] selectionArgs = new String[]{weapon.getName(), weapon.getDamageType(), weapon.getCategory(),
		weapon.getRange(), weapon.getFeatureIDs(), weapon.getFeatures()};

		database.execSQL("insert into weapons values ( ?, " + weapon.getNumDice() + ", " + weapon.getDamageDie() +
				", " + weapon.getAltDamageDie() + ", ?, ?, ?, ?, ? )", selectionArgs);

		database.close();
		}

	public ArrayList<ABSCmod> getAbscMods()
		{
		SQLiteDatabase database = getWritableDatabase();

		Cursor cursor = database.rawQuery("select * from abscMods", null);
		ArrayList<ABSCmod> abscMods = new ArrayList<>();

		while(cursor.moveToNext())
			{
			ABSCmod mod = new ABSCmod(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getString(3));

			abscMods.add(mod);
			}

		cursor.close();
		database.close();
		return abscMods;
		}
	}
