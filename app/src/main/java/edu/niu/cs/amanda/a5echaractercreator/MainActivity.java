package edu.niu.cs.amanda.a5echaractercreator;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
	{
	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		}//end onCreate

	public void startCreation(View view)
		{
		}//end startCreation

	public void selectCharacter(View view)
		{
		}//end selectCharacter

	public void getInfo(View view)
		{
		}//end getHelp

	public void getRules(View view)
		{
		//give basic rules about character creation, multiclassing
		}//end getRules

	public void recoverCharacter(View view)
		{
		///essentially a clone of viewCharacters, but with a button to re-add characters to the view
		//list and remove them from the "deleted" list
		}//end recoverCharacter
	}