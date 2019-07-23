package com.questgraves.gifthelper;

import com.questgraves.gifthelper.GiftDbAdapter.GiftDbHelper;
import com.google.ads.*;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Class that is logic for the form layout by same name in res>layout>detailform.xml
 * that the user uses the provided text-boxes to add data to the database.
 * 
 * @author Quest Graves - AuroraQuest Software April 2011 *last updated January 2012
 *
 */

public class DetailForm extends Activity 
{
	 
	
	public final static String ID_EXTRA = "com.quest.gifthelper._ID";
	EditText name, birthday, importantDates, favColor, favMusician, favSong,
		favMovie, favBooks, favFoods, favRestaurant, favAnimal, favPet, favWord, favTvShows, favHistFigs, favHobbies, favCollectibles, 
		coatSize, shirtSize, pantSize, shoeSize, sockType, ringSizes, undergarmentSize, other, height, weight, hairColor, eyeColor, heritage, personality,
		openlyWants, likes, dislikes,  notes = null;
	
	RadioGroup friendType = null;
	 
	String contactId = null;
	
	GiftDbHelper helper = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_form);
		
		
		
		
		 
		 AdView avDetail_1 = (AdView)this.findViewById(R.id.adViewDetail_1);
		 avDetail_1.loadAd(new AdRequest());
	     
		 AdView avDetail_2 = (AdView)this.findViewById(R.id.adViewDetail_2);
		 avDetail_2.loadAd(new AdRequest());
		 
		 AdView avDetail_3 = (AdView)this.findViewById(R.id.adViewDetail_3);
		 avDetail_3.loadAd(new AdRequest());
		 
        helper = new GiftDbHelper(this);
    //Identifiers    
        name = (EditText)findViewById(R.id.name);
        birthday = (EditText)findViewById(R.id.birthday);
        importantDates = (EditText)findViewById(R.id.importantDates);
    //favorites    
        favColor = (EditText)findViewById(R.id.favColor);
        favMusician = (EditText)findViewById(R.id.favMusician);
        favSong = (EditText)findViewById(R.id.favSong);
        favMovie = (EditText)findViewById(R.id.favMovie);
        favBooks = (EditText)findViewById(R.id.favBooks);
        favFoods = (EditText)findViewById(R.id.favFoods);
        favRestaurant = (EditText)findViewById(R.id.favRestaurant);
        favAnimal = (EditText)findViewById(R.id.favAnimal);
        favPet = (EditText)findViewById(R.id.favPets);
        favWord = (EditText)findViewById(R.id.favWord);
        favTvShows = (EditText)findViewById(R.id.favTvShows);
        favHistFigs = (EditText)findViewById(R.id.favHistFigs);
        favHobbies = (EditText)findViewById(R.id.favHobbies);
        favCollectibles = (EditText)findViewById(R.id.favCollectibles);
    //Clothing     
        coatSize = (EditText)findViewById(R.id.coatSize);
        shirtSize = (EditText)findViewById(R.id.shirtSize);
        pantSize = (EditText)findViewById(R.id.pantSize);
        shoeSize = (EditText)findViewById(R.id.shoeSize);
        sockType = (EditText)findViewById(R.id.sockType);
        ringSizes = (EditText)findViewById(R.id.ringSizes);
        undergarmentSize = (EditText)findViewById(R.id.undergarmentSize);
        other = (EditText)findViewById(R.id.other);
   //Physical     
        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        hairColor = (EditText)findViewById(R.id.hairColor);
        eyeColor = (EditText)findViewById(R.id.eyeColor);
        heritage = (EditText)findViewById(R.id.heritage);
        personality = (EditText)findViewById(R.id.personality);
        openlyWants = (EditText)findViewById(R.id.openlyWants);
   //Miscellaneous      
        likes = (EditText)findViewById(R.id.likes);
        dislikes = (EditText)findViewById(R.id.dislikes);
        notes = (EditText)findViewById(R.id.notes);
        friendType = (RadioGroup)findViewById(R.id.friendType);
      
        
        Button save = (Button)findViewById(R.id.save_button);
        				save.setOnClickListener(onSave);
        				 
        contactId = getIntent().getStringExtra(GiftHelper.ID_EXTRA);
        			  
        if (contactId != null){
        	load();
        }
	}
 
//left off here fix!
    public void load() {
       
      Cursor c = helper.getById(contactId);		
		
       c.moveToFirst();
    //Identifiers
		name.setText(helper.getName(c));
		birthday.setText(helper.getBirthday(c));
		importantDates.setText(helper.getImportantDates(c));
	//Favorites
		favColor.setText(helper.getFavColor(c));
		favMusician.setText(helper.getFavMusician(c));
		favSong.setText(helper.getFavSong(c));
		favMovie.setText(helper.getFavMovie(c));
		favBooks.setText(helper.getFavBooks(c));
		favFoods.setText(helper.getFavFoods(c));
		favRestaurant.setText(helper.getFavRestaurant(c));
		favAnimal.setText(helper.getFavAnimal(c));
		favPet.setText(helper.getFavPet(c));
		favWord.setText(helper.getFavWord(c));
		favTvShows.setText(helper.getFavTvShows(c));
		favHistFigs.setText(helper.getFavHistFigs(c));
		favHobbies.setText(helper.getfavHobbies(c));
		favCollectibles.setText(helper.getfavCollectibles(c));
	//clothing
		coatSize.setText(helper.getCoatSize(c));
		shirtSize.setText(helper.getShirtSize(c));
		pantSize.setText(helper.getPantSize(c));
		shoeSize.setText(helper.getShoeSize(c));
		sockType.setText(helper.getSockType(c));
		ringSizes.setText(helper.getRingSizes(c));
		undergarmentSize.setText(helper.getUndergarmentSize(c));
		other.setText(helper.getOther(c));
	//Physical
		height.setText(helper.getHeight(c));
		weight.setText(helper.getWeight(c));
		hairColor.setText(helper.getHairColor(c));
		eyeColor.setText(helper.getEyeColor(c));
		heritage.setText(helper.getHeritage(c));
		personality.setText(helper.getPersonality(c));
		openlyWants.setText(helper.getOpenlyWants(c));
	//Miscellaneous 	
		likes.setText(helper.getLikes(c));
		dislikes.setText(helper.getDislikes(c));
		notes.setText(helper.getNotes(c));
		
		if (helper.getFriendType(c).equals("family")) {
			friendType.check(R.id.family);
		}
		else if (helper.getFriendType(c).equals("lover")) {
			friendType.check(R.id.lover);
		}
		else if (helper.getFriendType(c).equals("closeFriend")) {
			friendType.check(R.id.closeFriend);
		}
		else if (helper.getFriendType(c).equals("friend")) {
			friendType.check(R.id.friend);
		}
		else {
			friendType.check(R.id.coWorker);
		}
		c.close();
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		helper.close();
	}

 //Build Option Menu by inflating xml
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.save, menu);
		return(super.onCreateOptionsMenu(menu));
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		String type = null;
			
			//Switch for the Radio Group to set a Friend Type
			switch (friendType.getCheckedRadioButtonId()){
				case R.id.family:
					type = "family";
					break;
					
				case R.id.lover:
					type = "lover";
					break;
				case R.id.closeFriend:
					type = "closeFriend";
					break;
				case R.id.friend:
					type = "friend";
					break;
				case R.id.coWorker:
					type = "coWorker";
					break;
			}
			
			if (contactId == null) {
				helper.insert( contactId, name.getText().toString(), birthday.getText().toString(),
						importantDates.getText().toString(), type, favColor.getText().toString(),
						favMusician.getText().toString(), favSong.getText().toString(),
						favMovie.getText().toString(), favBooks.getText().toString(),
						favFoods.getText().toString(), favRestaurant.getText().toString(),
						favAnimal.getText().toString(), favPet.getText().toString(),
						favWord.getText().toString(), favTvShows.getText().toString(),
						favHistFigs.getText().toString(), favHobbies.getText().toString(),
						favCollectibles.getText().toString(), coatSize.getText().toString(),
						shirtSize.getText().toString(), pantSize.getText().toString(),
						shoeSize.getText().toString(), sockType.getText().toString(),
						ringSizes.getText().toString(), undergarmentSize.getText().toString(),
						other.getText().toString(), height.getText().toString(),
						weight.getText().toString(), hairColor.getText().toString(),
						eyeColor.getText().toString(), heritage.getText().toString(),
						personality.getText().toString(), openlyWants.getText().toString(),
						likes.getText().toString(), dislikes.getText().toString(),
						notes.getText().toString());
			
			}
			else {
				helper.update( contactId, name.getText().toString(), birthday.getText().toString(),
						importantDates.getText().toString(), type, favColor.getText().toString(),
						favMusician.getText().toString(), favSong.getText().toString(),
						favMovie.getText().toString(), favBooks.getText().toString(),
						favFoods.getText().toString(), favRestaurant.getText().toString(),
						favAnimal.getText().toString(), favPet.getText().toString(),
						favWord.getText().toString(), favTvShows.getText().toString(),
						favHistFigs.getText().toString(), favHobbies.getText().toString(),
						favCollectibles.getText().toString(), coatSize.getText().toString(),
						shirtSize.getText().toString(), pantSize.getText().toString(),
						shoeSize.getText().toString(), sockType.getText().toString(),
						ringSizes.getText().toString(), undergarmentSize.getText().toString(),
						other.getText().toString(), height.getText().toString(),
						weight.getText().toString(), hairColor.getText().toString(),
						eyeColor.getText().toString(), heritage.getText().toString(),
						personality.getText().toString(), openlyWants.getText().toString(),
						likes.getText().toString(), dislikes.getText().toString(),
						notes.getText().toString());
			}
			Intent i = new Intent(DetailForm.this, GiftHelper.class);
			startActivity(i);
			finish();
			return true;
		}
		
	

	
 //Save button clickListener
    public View.OnClickListener onSave = new View.OnClickListener() {
		public void onClick(View v) {
			String type = null;
			
			//Switch for the Radio Group to set a Friend Type
			switch (friendType.getCheckedRadioButtonId()){
				case R.id.family:
					type = "family";
					break;
					
				case R.id.lover:
					type = "lover";
					break;
				case R.id.closeFriend:
					type = "closeFriend";
					break;
				case R.id.friend:
					type = "friend";
					break;
				case R.id.coWorker:
					type = "coWorker";
					break;
			}
			
			if (contactId == null) {
				helper.insert(contactId, name.getText().toString(), birthday.getText().toString(),
						importantDates.getText().toString(), type, favColor.getText().toString(),
						favMusician.getText().toString(), favSong.getText().toString(),
						favMovie.getText().toString(), favBooks.getText().toString(),
						favFoods.getText().toString(), favRestaurant.getText().toString(),
						favAnimal.getText().toString(), favPet.getText().toString(),
						favWord.getText().toString(), favTvShows.getText().toString(),
						favHistFigs.getText().toString(), favHobbies.getText().toString(),
						favCollectibles.getText().toString(), coatSize.getText().toString(),
						shirtSize.getText().toString(), pantSize.getText().toString(),
						shoeSize.getText().toString(), sockType.getText().toString(),
						ringSizes.getText().toString(), undergarmentSize.getText().toString(),
						other.getText().toString(), height.getText().toString(),
						weight.getText().toString(), hairColor.getText().toString(),
						eyeColor.getText().toString(), heritage.getText().toString(),
						personality.getText().toString(), openlyWants.getText().toString(),
						likes.getText().toString(), dislikes.getText().toString(),
						notes.getText().toString());
			
			}
			else {
				helper.update( contactId, name.getText().toString(), birthday.getText().toString(),
						importantDates.getText().toString(), type, favColor.getText().toString(),
						favMusician.getText().toString(), favSong.getText().toString(),
						favMovie.getText().toString(), favBooks.getText().toString(),
						favFoods.getText().toString(), favRestaurant.getText().toString(),
						favAnimal.getText().toString(), favPet.getText().toString(),
						favWord.getText().toString(), favTvShows.getText().toString(),
						favHistFigs.getText().toString(), favHobbies.getText().toString(),
						favCollectibles.getText().toString(), coatSize.getText().toString(),
						shirtSize.getText().toString(), pantSize.getText().toString(),
						shoeSize.getText().toString(), sockType.getText().toString(),
						ringSizes.getText().toString(), undergarmentSize.getText().toString(),
						other.getText().toString(), height.getText().toString(),
						weight.getText().toString(), hairColor.getText().toString(),
						eyeColor.getText().toString(), heritage.getText().toString(),
						personality.getText().toString(), openlyWants.getText().toString(),
						likes.getText().toString(), dislikes.getText().toString(),
						notes.getText().toString());
			}
			Intent i = new Intent(DetailForm.this, GiftHelper.class);
			startActivity(i);
			finish();
		}
    };

}