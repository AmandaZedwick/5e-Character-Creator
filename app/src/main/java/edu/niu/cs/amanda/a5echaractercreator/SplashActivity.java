package edu.niu.cs.amanda.a5echaractercreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity
	{
	DatabaseManagement dbManager;

	TextView loadingTV;
	Timer timer;

	//the index will keep track of where we are in loadText
	int index = 0;

	//set up loading texts
	String[] loadText = new String[]{ "Loading", "Loading.", "Loading..", "Loading..."};

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		dbManager = new DatabaseManagement(this);

		loadingTV = findViewById(R.id.loadTextView);

		//set up a timer to run at fixed intervals of 1 second as well as loading task
		timer = new Timer();

		TimerTask loadTask = new TimerTask()
			{
			@Override
			public void run()
				{
				runOnUiThread(() -> updateText());
				}
			};

		timer.scheduleAtFixedRate(loadTask, 0, 1000);

		//set up mainTask to be executed
		TimerTask mainTask;

		ArrayList<ABSCmod> checkList = dbManager.getAbscMods();

		if (checkList.size() == 0)
			{
			mainTask = new TimerTask()
				{
				@Override
				public void run()
					{
					insertInitialData();

					//finish splash screen execution
					finish();

					//go to main activity when finished
					startActivity(new Intent(SplashActivity.this, MainActivity.class));
					}//end run
				}; //end timerTask
			}
		else
			{
			mainTask = new TimerTask()
				{
				@Override
				public void run()
					{
					//finish splash activity to leave
					finish();

					//go to main activity when finished
					startActivity(new Intent(SplashActivity.this, MainActivity.class));
					}
				};
			}

		Timer display = new Timer();

		display.schedule(mainTask, 3000);
		}

	@Override
	public void onDestroy()
		{
		super.onDestroy();

		//cancel the timer when the activity finishes
		if (timer != null)
			{
			timer.cancel();
			timer.purge();
			}
		}

	public void updateText()
		{
		if (index < 3)
			{
			loadingTV.setText(loadText[index]);

			index = index + 1;
			}
		else
			{
			loadingTV.setText(loadText[index]);

			index = 0;
			}
		}

	public void insertInitialData()
		{
		//get an input stream
		InputStream myInput;

		AssetManager assetManager = getAssets();

		//open excel file name as databases.xls
		try
			{
			myInput = assetManager.open("databases.xls");
			}//end try
		catch (IOException e)
			{
			throw new RuntimeException(e);
			}//end catch

		// Create a POI File System object out of the database file
		POIFSFileSystem myFileSystem;
		try
			{
			myFileSystem = new POIFSFileSystem(myInput);
			}//end try
		catch (IOException e)
			{
			throw new RuntimeException(e);
			}//end catch

		// Create a workbook using the File System
		HSSFWorkbook myWorkBook;
		try
			{
			myWorkBook = new HSSFWorkbook(myFileSystem);
			}//end try
		catch (IOException e)
			{
			throw new RuntimeException(e);
			}//end catch

		//Get the sheets from the workbook
		HSSFSheet abscMods = myWorkBook.getSheetAt(0);
		HSSFSheet acMods = myWorkBook.getSheetAt(1);
		HSSFSheet armor = myWorkBook.getSheetAt(2);
		HSSFSheet backgrounds = myWorkBook.getSheetAt(3);
		HSSFSheet choices = myWorkBook.getSheetAt(4);
		HSSFSheet classes = myWorkBook.getSheetAt(5);
		HSSFSheet classSlots = myWorkBook.getSheetAt(6);
		HSSFSheet count = myWorkBook.getSheetAt(7);
		HSSFSheet defenses = myWorkBook.getSheetAt(8);
		HSSFSheet features = myWorkBook.getSheetAt(9);
		HSSFSheet futureUpgrades = myWorkBook.getSheetAt(10);
		HSSFSheet numChoices = myWorkBook.getSheetAt(11);
		HSSFSheet passiveMods = myWorkBook.getSheetAt(12);
		HSSFSheet profMods = myWorkBook.getSheetAt(13);
		HSSFSheet races = myWorkBook.getSheetAt(14);
		HSSFSheet speedMods = myWorkBook.getSheetAt(15);
		HSSFSheet spellMods = myWorkBook.getSheetAt(16);
		HSSFSheet spells = myWorkBook.getSheetAt(17);
		HSSFSheet startEquip = myWorkBook.getSheetAt(18);
		HSSFSheet weapons = myWorkBook.getSheetAt(19);


		//Get something to iterate through the cells.
		Iterator<Row> abscIter = abscMods.rowIterator();
		Iterator<Row> acIter = acMods.rowIterator();
		Iterator<Row> armorIter = armor.rowIterator();
		Iterator<Row> bgdIter = backgrounds.rowIterator();
		Iterator<Row> choiceIter = choices.rowIterator();
		Iterator<Row> classIter = classes.rowIterator();
		Iterator<Row> classSlIter = classSlots.rowIterator();
		Iterator<Row> countIter = count.rowIterator();
		Iterator<Row> defenseIter = defenses.rowIterator();
		Iterator<Row> featuresIter = features.rowIterator();
		Iterator<Row> futUpIter = futureUpgrades.rowIterator();
		Iterator<Row> numChoiceIter = numChoices.rowIterator();
		Iterator<Row> passiveIter = passiveMods.rowIterator();
		Iterator<Row> profIter = profMods.rowIterator();
		Iterator<Row> raceIter = races.rowIterator();
		Iterator<Row> speedIter = speedMods.rowIterator();
		Iterator<Row> spellModIter = spellMods.rowIterator();
		Iterator<Row> spellIter = spells.rowIterator();
		Iterator<Row> startEquipIter = startEquip.rowIterator();
		Iterator<Row> weaponIter = weapons.rowIterator();

		//fill abscMod table
		while (abscIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) abscIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			String ability = "";
			int abscID = 0, addition = 0, max = 0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 0:
						abscID = (int) Double.parseDouble(myCell.toString());
						break;
					case 1:
						ability = myCell.toString();
						break;
					case 2:
						addition = (int) Double.parseDouble(myCell.toString());
						break;
					case 3:
						max = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			//in cases where the id is empty, just leave
			if (abscID == 0)
				{
				break;
				}

			//make absc object
			ABSCmod absc = new ABSCmod(abscID, addition, max, ability);

			//insert it into the database
			dbManager.insertAbscMod(absc);
			}//end while -- armorDB should be filled

		//fill acMods
		while (acIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) acIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			int modID = 0, base = 0, priority = 0, dexPreReq = 0, addition = 0, stealthDis = 0;
			String armorPreReq = "";
			String categoryPreReq = "";
			String abscMod = "";

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 0:
						modID = (int) Double.parseDouble(myCell.toString());
						break;
					case 1:
						base = (int) Double.parseDouble(myCell.toString());
						break;
					case 2:
						priority = (int) Double.parseDouble(myCell.toString());
						break;
					case 3:
						armorPreReq = myCell.toString();
						break;
					case 4:
						categoryPreReq = myCell.toString();
						break;
					case 5:
						dexPreReq = (int) Double.parseDouble(myCell.toString());
						break;
					case 6:
						abscMod = myCell.toString();
						break;
					case 7:
						addition = (int) Double.parseDouble(myCell.toString());
						break;
					case 8:
						stealthDis = (int) Double.parseDouble(myCell.toString());
					}

				colNo++;
				}

			if (modID == 0)
				{
				break;
				}

			ACmod acMod = new ACmod(modID, base, priority, dexPreReq, addition, stealthDis, armorPreReq,
					categoryPreReq, abscMod);

			dbManager.insertACMod(acMod);
			}

		//fill armor
		while (armorIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) armorIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			String name = "", type = "";
			int stealth = 0, ac = 0, addDex = 0, dexMax = 0, strength = 0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 0:
						name = myCell.toString();
						break;
					case 1:
						stealth = (int) Double.parseDouble(myCell.toString());
						break;
					case 2:
						ac = (int) Double.parseDouble(myCell.toString());
						break;
					case 3:
						addDex = (int) Double.parseDouble(myCell.toString());
						break;
					case 4:
						dexMax = (int) Double.parseDouble(myCell.toString());
						break;
					case 5:
						type = myCell.toString();
						break;
					case 6:
						strength = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (name.isEmpty())
				{
				break;
				}

			//make armor object
			Armor newArmor = new Armor(name, type, stealth, ac, addDex, dexMax, strength);

			//insert it into the database
			dbManager.insertArmor(newArmor);
			}//end while -- armorDB should be filled

		//fill background
		while (bgdIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) bgdIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			String name = "", desc = "", equipIds = "", equipSum = "";
			int featureID = 0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 0:
						name = myCell.toString();
						break;
					case 1:
						desc = myCell.toString();
						break;
					case 2:
						equipIds = myCell.toString();
						break;
					case 3:
						equipSum = myCell.toString();
						break;
					case 4:
						if (myCell.toString().isEmpty())
							break;
						featureID = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (name.isEmpty())
				{
				break;
				}

			//make background object
			Background background = new Background(name, desc, equipSum, equipIds, featureID);

			//insert it into the database
			dbManager.insertBackground(background);
			}//end while -- backgrounds should be filled

		//fill choices
		while (choiceIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) choiceIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			String featureIDs = "", searchTable = "", displayName = "", choiceCat = "", futureUpgrade = "";
			int choiceID = 0, searchID = 0, displayDesc = 0, choiceNum = 0, priority = 0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						featureIDs = myCell.toString();
						break;
					case 2:
						searchID = (int) Double.parseDouble(myCell.toString());
						break;
					case 3:
						searchTable = myCell.toString();
						break;
					case 4:
						displayName = myCell.toString();
						break;
					case 5:
						displayDesc = (int) Double.parseDouble(myCell.toString());
						break;
					case 6:
						choiceCat = myCell.toString();
						break;
					case 7:
						choiceNum = (int) Double.parseDouble(myCell.toString());
						break;
					case 8:
						futureUpgrade = myCell.toString();
						break;
					case 9:
						priority = (int) Double.parseDouble(myCell.toString());
						break;
					case 0:
						if (myCell.toString().isEmpty())
							break;
						choiceID = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				if (choiceID == 0)
					{
					break;
					}

				//increase colNo
				colNo++;
				}

			Choice choice = new Choice(choiceID, searchID, displayDesc, choiceNum, priority, searchTable, displayName,
					featureIDs, choiceCat, futureUpgrade);

			dbManager.insertChoice(choice);
			}

		//fill class
		while (classIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) classIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			String subclass = "", className = "", equipSum = "", equipIDs = "", featureIDs = "", desc = "";
			int lvlReq = 0, hitDice = 0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						className = myCell.toString();
						break;
					case 2:
						lvlReq = (int) Double.parseDouble(myCell.toString());
						break;
					case 3:
						hitDice = (int) Double.parseDouble(myCell.toString());
						break;
					case 4:
						equipSum = myCell.toString();
						break;
					case 5:
						equipIDs = myCell.toString();
						break;
					case 6:
						featureIDs = myCell.toString();
						break;
					case 7:
						desc = myCell.toString();
						break;
					default:
						subclass = myCell.toString();
						if (subclass.isEmpty())
							break;
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (subclass.isEmpty())
				{
				break;
				}

			//make class object
			Classes newClass = new Classes(subclass, className, equipIDs, featureIDs, desc, equipSum, hitDice, lvlReq);

			//add it to the database
			dbManager.insertClass(newClass);
			}//end while -- classDB should be filled

		//fill classSlots
		while (classSlIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) classSlIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			String name = "", extra = "";
			int level = 0, cantrips = 0, known = 0, first = 0, second = 0, third = 0, fourth = 0,
					fifth = 0, sixth = 0, seventh = 0, eighth = 0, ninth = 0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						level = (int) Double.parseDouble(myCell.toString());
						break;
					case 2:
						extra = myCell.toString();
						break;
					case 3:
						cantrips = (int) Double.parseDouble(myCell.toString());
						break;
					case 4:
						known = (int) Double.parseDouble(myCell.toString());
						break;
					case 5:
						first = (int) Double.parseDouble(myCell.toString());
						break;
					case 6:
						second = (int) Double.parseDouble(myCell.toString());
						break;
					case 7:
						third = (int) Double.parseDouble(myCell.toString());
						break;
					case 8:
						fourth = (int) Double.parseDouble(myCell.toString());
						break;
					case 9:
						fifth = (int) Double.parseDouble(myCell.toString());
						break;
					case 10:
						sixth = (int) Double.parseDouble(myCell.toString());
						break;
					case 11:
						seventh = (int) Double.parseDouble(myCell.toString());
						break;
					case 12:
						eighth = (int) Double.parseDouble(myCell.toString());
						break;
					case 13:
						ninth = (int) Double.parseDouble(myCell.toString());
						break;
					default:
						name = myCell.toString();
						if (name.isEmpty())
							break;
						break;
					}//end switch

				if (name.isEmpty())
					{
					break;
					}

				//increase colNo
				colNo++;
				}//end while

			//make classSl object
			ClassSlots classSlot = new ClassSlots(name, level, extra, cantrips, known, first, second,
					third, fourth, fifth, sixth, seventh, eighth, ninth);

			//insert it into the database
			dbManager.insertClassSlots(classSlot);
			}//end while -- classSlDB should be filled

		//fill count
		while (countIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) countIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			String name = "", resetTrigger = "", source = "", tableSrc = "";
			int countID = 0, min = 0, addition = 0;
			double sourceMult = 0.0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 0:
						countID = (int) Double.parseDouble(myCell.toString());
						break;
					case 1:
						name = myCell.toString();
						break;
					case 2:
						resetTrigger = myCell.toString();
						break;
					case 3:
						source = myCell.toString();
						break;
					case 4:
						sourceMult = Double.parseDouble(myCell.toString());
						break;
					case 5:
						tableSrc = myCell.toString();
						break;
					case 6:
						min = (int) Double.parseDouble(myCell.toString());
						break;
					case 7:
						addition = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (name.isEmpty())
				{
				break;
				}

			//make feat object
			Count newCount = new Count(countID, min, addition, name, resetTrigger, source, tableSrc, sourceMult);

			//add it to the database
			dbManager.insertCount(newCount);
			}

		//fill defenses
		while (defenseIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) defenseIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			String name = "", category = "";
			int defenseID = 0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						name = myCell.toString();
						break;
					case 2:
						category = myCell.toString();
						break;
					default:
						if (myCell.toString().isEmpty())
							break;
						defenseID = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (defenseID == 0)
				{
				break;
				}

			Defense newDefense = new Defense(defenseID, name, category);

			dbManager.insertDefense(newDefense);
			}

		//fill features
		while (featuresIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) featuresIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			String name = "", description = "", countInfo = "", spellsGiven = "", defense = "", bonusTables = "",
					acMod = "", speed = "", passives = "", saveDC = "", choiceLim = "", abscInc = "", profIDs = "", category = "";
			int featureID = 0, equippable = 0, numChoice = 0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 0:
						featureID = (int) Double.parseDouble(myCell.toString());
						break;
					case 1:
						name = myCell.toString();
						break;
					case 2:
						description = myCell.toString();
						break;
					case 3:
						countInfo = myCell.toString();
						break;
					case 4:
						spellsGiven = myCell.toString();
						break;
					case 5:
						defense = myCell.toString();
						break;
					case 6:
						bonusTables = myCell.toString();
						break;
					case 7:
						acMod = myCell.toString();
						break;
					case 8:
						speed = myCell.toString();
						break;
					case 9:
						passives = myCell.toString();
						break;
					case 10:
						equippable = (int) Double.parseDouble(myCell.toString());
						break;
					case 11:
						saveDC = myCell.toString();
						break;
					case 12:
						numChoice = (int) Double.parseDouble(myCell.toString());
						break;
					case 13:
						choiceLim = myCell.toString();
						break;
					case 14:
						abscInc = myCell.toString();
						break;
					case 15:
						profIDs = myCell.toString();
						break;
					case 16:
						category = myCell.toString();
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (featureID == 0)
				{
				break;
				}

			Feature newFeature = new Feature(featureID, equippable, numChoice, name, description,
					countInfo, spellsGiven, defense, bonusTables, acMod, speed, passives, saveDC,
					choiceLim, abscInc, profIDs, category);

			dbManager.insertFeature(newFeature);
			}

		//fill future upgrades
		while (futUpIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) futUpIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			String sourceTbl = "", choiceCat = "";
			int featureID = 0, futUpID = 0, lvlReq = 0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						featureID = (int) Double.parseDouble(myCell.toString());
						break;
					case 2:
						sourceTbl = myCell.toString();
						break;
					case 3:
						choiceCat = myCell.toString();
						break;
					case 4:
						lvlReq = (int) Double.parseDouble(myCell.toString());
						break;
					default:
						if (myCell.toString().isEmpty())
							break;
						futUpID = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (futUpID == 0)
				{
				break;
				}

			FutureUpgrade futureUpgrade = new FutureUpgrade(futUpID, featureID, lvlReq, sourceTbl, choiceCat);

			dbManager.insertFutureUpgrade(futureUpgrade);
			}

		//full numChoices
		while (numChoiceIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) numChoiceIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			int numChoiceID = 0, numChoice = 0, lvlReq = 0;

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						numChoice = (int) Double.parseDouble(myCell.toString());
						break;
					case 2:
						lvlReq = (int) Double.parseDouble(myCell.toString());
						break;
					default:
						if (myCell.toString().isEmpty())
							break;
						numChoiceID = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (numChoiceID == 0)
				{
				break;
				}

			NumChoice newChoice = new NumChoice(numChoiceID, numChoice, lvlReq);

			dbManager.insertNumChoice(newChoice);
			}

		//fill passives
		while (passiveIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) passiveIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			int id = 0, advDis = 0, addition = 0, base = 0;
			String abscBonus = "", category = "";

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						advDis = (int) Double.parseDouble(myCell.toString());
						break;
					case 2:
						addition = (int) Double.parseDouble(myCell.toString());
						break;
					case 3:
						abscBonus = myCell.toString();
						break;
					case 4:
						base = (int) Double.parseDouble(myCell.toString());
						break;
					case 5:
						category = myCell.toString();
						break;
					default:
						if (myCell.toString().isEmpty())
							break;
						id = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (id == 0)
				{
				break;
				}

			Passives newPassive = new Passives(id, advDis, addition, base, abscBonus, category);

			dbManager.insertPassive(newPassive);
			}

		//fill proficiency mods
		while (profIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) profIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			int id = 0, expert = 0, mod = 0, priority = 0;
			String name = "", type = "";

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						name = myCell.toString();
						break;
					case 2:
						type = myCell.toString();
						break;
					case 3:
						expert = (int) Double.parseDouble(myCell.toString());
						break;
					case 4:
						mod = (int) Double.parseDouble(myCell.toString());
						break;
					case 5:
						priority = (int) Double.parseDouble(myCell.toString());
						break;
					default:
						if (myCell.toString().isEmpty())
							break;
						id = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (id == 0)
				{
				break;
				}

			ProfMod newProf = new ProfMod(id, expert, mod, priority, name, type);

			dbManager.insertProf(newProf);
			}

		//fill races
		while (raceIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) raceIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			int lifespan = 0;
			String subrace = "", race = "", abscIncrease = "", size = "", profIDs = "", featIDs = "",
					description = "", speed = "";

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						race = myCell.toString();
						break;
					case 2:
						abscIncrease = myCell.toString();
						break;
					case 3:
						lifespan = (int) Double.parseDouble(myCell.toString());
						break;
					case 4:
						size = myCell.toString();
						break;
					case 5:
						speed = myCell.toString();
						break;
					case 6:
						profIDs = myCell.toString();
						break;
					case 7:
						featIDs = myCell.toString();
						break;
					case 8:
						description = myCell.toString();
						break;
					default:
						subrace = myCell.toString();
						if (subrace.isEmpty())
							break;
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (subrace.isEmpty())
				{
				break;
				}

			Race newRace = new Race(subrace, race, abscIncrease, size, profIDs, featIDs, description,
					lifespan, speed);

			dbManager.insertRace(newRace);
			}

		//fill speed mods
		while (speedIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) speedIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			int id = 0, base = 0, addition = 0, equalWalk = 0, lvlReq = 0;
			String negateBy = "", type = "", preReq = "";

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						type = myCell.toString();
						break;
					case 2:
						base = (int) Double.parseDouble(myCell.toString());
						break;
					case 3:
						addition = (int) Double.parseDouble(myCell.toString());
						break;
					case 4:
						equalWalk = (int) Double.parseDouble(myCell.toString());
						break;
					case 5:
						lvlReq = (int) Double.parseDouble(myCell.toString());
						break;
					case 6:
						negateBy = myCell.toString();
						break;
					case 7:
						preReq = myCell.toString();
						break;
					default:
						if (myCell.toString().isEmpty())
							break;
						id = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (id == 0)
				{
				break;
				}

			SpeedMod speedMod = new SpeedMod(id, base, addition, lvlReq, equalWalk, type, negateBy, preReq);

			dbManager.insertSpeedMod(speedMod);
			}

		//fill spell mods
		while (spellModIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) spellModIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			int id = 0, classLvlReq = 0, totLvlReq = 0;
			String spellID = "";

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						spellID = myCell.toString();
						break;
					case 2:
						classLvlReq = (int) Double.parseDouble(myCell.toString());
						break;
					case 3:
						totLvlReq = (int) Double.parseDouble(myCell.toString());
						break;
					default:
						if (myCell.toString().isEmpty())
							break;
						id = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (id == 0)
				{
				break;
				}

			SpellMod spellMod = new SpellMod(id, classLvlReq, totLvlReq, spellID);

			dbManager.insertSpellMod(spellMod);
			}

		//fill spells
		while (spellIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) spellIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			int level = 0;
			String spell = "", castTime = "", range = "", components = "", duration = "", school = "",
					save = "", effect = "", description = "", classList = "";

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						level = (int) Double.parseDouble(myCell.toString());
						break;
					case 2:
						castTime = myCell.toString();
						break;
					case 3:
						range = myCell.toString();
						break;
					case 4:
						components = myCell.toString();
						break;
					case 5:
						duration = myCell.toString();
						break;
					case 6:
						school = myCell.toString();
						break;
					case 7:
						save = myCell.toString();
						break;
					case 8:
						effect = myCell.toString();
						break;
					case 9:
						description = myCell.toString();
						break;
					case 10:
						classList = myCell.toString();
						break;
					default:
						spell = myCell.toString();
						if (spell.isEmpty())
							break;
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (spell.equals(""))
				{
				break;
				}

			Spell newSpell = new Spell(spell, castTime, range, components, duration, school, save, effect,
					description, classList, level);

			dbManager.insertSpell(newSpell);
			}

		//fill start equipment
		while (startEquipIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) startEquipIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			int id = 0, qty = 0;
			String name = "", description = "", category = "";

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						name = myCell.toString();
						break;
					case 2:
						qty = (int) Double.parseDouble(myCell.toString());
						break;
					case 3:
						description = myCell.toString();
						break;
					case 4:
						category = myCell.toString();
						break;
					default:
						if (myCell.toString().isEmpty())
							break;
						id = (int) Double.parseDouble(myCell.toString());
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (id == 0)
				{
				break;
				}

			StartEquip newEquip = new StartEquip(id, qty, name, description, category);

			dbManager.insertStartEquip(newEquip);
			}

		//fill weapons
		while (weaponIter.hasNext())
			{
			HSSFRow myRow = (HSSFRow) weaponIter.next();

			Iterator<Cell> cellIterator = myRow.cellIterator();

			int colNo = 0;
			int numDice = 0, dmgDie = 0, altDmgDie = 0;
			String name = "", dmgType = "", category = "", range = "", featureIDs = "", featureNames = "";

			while (cellIterator.hasNext())
				{
				HSSFCell myCell = (HSSFCell) cellIterator.next();
				switch (colNo)
					{
					case 1:
						numDice = (int) Double.parseDouble(myCell.toString());
						break;
					case 2:
						dmgDie = (int) Double.parseDouble(myCell.toString());
						break;
					case 3:
						altDmgDie = (int) Double.parseDouble(myCell.toString());
						break;
					case 4:
						dmgType = myCell.toString();
						break;
					case 5:
						category = myCell.toString();
						break;
					case 6:
						range = myCell.toString();
						break;
					case 7:
						featureIDs = myCell.toString();
						break;
					case 8:
						featureNames = myCell.toString();
						break;
					default:
						name = myCell.toString();
						if (name.isEmpty())
							break;
						break;
					}//end switch

				//increase colNo
				colNo++;
				}//end while

			if (name.equals(""))
				{
				break;
				}

			Weapon weapon = new Weapon(name, dmgType, category, range, featureIDs, featureNames, numDice, dmgDie, altDmgDie);

			dbManager.insertWeapon(weapon);
			}
		}
	}