package com.questgraves.gifthelper;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.questgraves.gifthelper.GiftDbAdapter.GiftDbHelper;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

/** The ContactView class uses an XML layout to display individual contact
 * info pulled from the GiftDbAdappter Cursor
 * @author Quest Graves - AuroraQuest Software April 2011 *last updated January 2012*/

public class ContactView extends Activity 
{	
	public final static String ID_EXTRA = "com.quest.gifthelper._ID";
	TextView nameDisplay, birthdayDisplay, importantDatesDisplay, typeDisplay, colorDisplay, musicDisplay, songDisplay, 
	movieDisplay, booksDisplay, foodsDisplay, restaurantDisplay, animalDisplay, petTypeDisplay, wordDisplay, tvShowsDisplay, histFigsDisplay,
	hobbiesDisplay, collectiblesDisplay, coatSizeDisplay, shirtSizeDisplay, pantSizeDisplay, shoeSizeDisplay, sockTypeDisplay, 
	ringSizesDisplay, undergarmentSizesDisplay,  otherDisplay, heightDisplay, weightDisplay, hairColorDisplay, eyeColorDisplay, heritageDisplay,
	personalityDisplay, openlyWantsDisplay, likesDisplay,  dislikesDisplay, notesDisplay;
	
	
	String tHelper = "this is to test new build environment";
	GiftDbHelper cHelper;
	Cursor cCursor;
	String contactId = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_view);
		this.setTheme(R.style.IcsText);
		
		AdView avDisplay_1 = (AdView)this.findViewById(R.id.adViewDisplay_1);
		 avDisplay_1.loadAd(new AdRequest());
		 
		 AdView avDisplay_2 = (AdView)this.findViewById(R.id.adViewDisplay_2);
		 avDisplay_2.loadAd(new AdRequest());
		
		 AdView avDisplay_3 = (AdView)this.findViewById(R.id.adViewDisplay_3);
		 avDisplay_3.loadAd(new AdRequest());
		 
			cHelper = new GiftDbHelper(this);
			
		    nameDisplay = (TextView)findViewById(R.id.name_display);
		    birthdayDisplay = (TextView)findViewById(R.id.birthday_display);
		    importantDatesDisplay = (TextView)findViewById(R.id.important_dates_display);
		    typeDisplay = (TextView)findViewById(R.id.type_display);
	        colorDisplay = (TextView)findViewById(R.id.color_display);
	        musicDisplay = (TextView)findViewById(R.id.music_display);
	        songDisplay = (TextView)findViewById(R.id.song_display);
	        movieDisplay = (TextView)findViewById(R.id.movie_display);
	        booksDisplay = (TextView)findViewById(R.id.books_display);
	        foodsDisplay = (TextView)findViewById(R.id.foods_display);
	        restaurantDisplay = (TextView)findViewById(R.id.restaurant_display);
	        animalDisplay = (TextView)findViewById(R.id.animal_display);
	        petTypeDisplay = (TextView)findViewById(R.id.pet_type_display);
	        wordDisplay = (TextView)findViewById(R.id.word_display);
	        tvShowsDisplay = (TextView)findViewById(R.id.tv_shows_display);
	        histFigsDisplay = (TextView)findViewById(R.id.hist_figs_display);
	        hobbiesDisplay = (TextView)findViewById(R.id.hobbies_display);
	        collectiblesDisplay = (TextView)findViewById(R.id.collectibles_display);
	        coatSizeDisplay = (TextView)findViewById(R.id.coat_size_display);
	        shirtSizeDisplay = (TextView)findViewById(R.id.shirt_size_display);
	        pantSizeDisplay = (TextView)findViewById(R.id.pant_size_display);
	        shoeSizeDisplay = (TextView)findViewById(R.id.shoe_size_display);
	        sockTypeDisplay = (TextView)findViewById(R.id.sock_type_display);
	        ringSizesDisplay = (TextView)findViewById(R.id.ring_sizes_display);
	        undergarmentSizesDisplay = (TextView)findViewById(R.id.undergarment_sizes_display);
	        otherDisplay = (TextView)findViewById(R.id.other_display);
	        
	        heightDisplay = (TextView)findViewById(R.id.height_display);
	        weightDisplay = (TextView)findViewById(R.id.weight_display);
	        hairColorDisplay = (TextView)findViewById(R.id.hair_color_display);
	        eyeColorDisplay = (TextView)findViewById(R.id.eye_color_display);
	        heritageDisplay = (TextView)findViewById(R.id.heritage_display);
	        personalityDisplay = (TextView)findViewById(R.id.personality_display);
	        openlyWantsDisplay = (TextView)findViewById(R.id.openly_wants_display);
	        
	        
	        likesDisplay = (TextView)findViewById(R.id.likes_display);
	        dislikesDisplay = (TextView)findViewById(R.id.dislikes_display);
	        notesDisplay = (TextView)findViewById(R.id.notes_display);
	        
	     
		
		
		contactId = getIntent().getStringExtra(GiftHelper.ID_EXTRA);
		if (contactId != null) {
			displayInfo();
		}
	
	}

	//loads an existing record for display 
	
	//haven't written getters and setters in dbAdapter class!!
	public void displayInfo(){
		 Cursor cCursor  = cHelper.getById(contactId);
		cCursor.moveToFirst();
		nameDisplay.setText(cHelper.getName(cCursor));
		birthdayDisplay.setText(cHelper.getBirthday(cCursor));
		importantDatesDisplay.setText(cHelper.getImportantDates(cCursor));
		colorDisplay.setText(cHelper.getFavColor(cCursor));
		musicDisplay.setText(cHelper.getFavMusician(cCursor));
		songDisplay.setText(cHelper.getFavSong(cCursor));
		movieDisplay.setText(cHelper.getFavMovie(cCursor));
		booksDisplay.setText(cHelper.getFavBooks(cCursor)); 
		foodsDisplay.setText(cHelper.getFavFoods(cCursor));
		restaurantDisplay.setText(cHelper.getFavRestaurant(cCursor));
		animalDisplay.setText(cHelper.getFavAnimal(cCursor));
		petTypeDisplay.setText(cHelper.getFavPet(cCursor)); 
		wordDisplay.setText(cHelper.getFavWord(cCursor));
		tvShowsDisplay.setText(cHelper.getFavTvShows(cCursor));
		histFigsDisplay.setText(cHelper.getFavHistFigs(cCursor));
		hobbiesDisplay.setText(cHelper.getfavHobbies(cCursor));
	    collectiblesDisplay.setText(cHelper.getfavCollectibles(cCursor));
		
	    coatSizeDisplay.setText(cHelper.getCoatSize(cCursor)); 
	    shirtSizeDisplay.setText(cHelper.getShirtSize(cCursor));
		pantSizeDisplay.setText(cHelper.getPantSize(cCursor));
		shoeSizeDisplay.setText(cHelper.getShoeSize(cCursor));
		sockTypeDisplay.setText(cHelper.getSockType(cCursor)); 
		ringSizesDisplay.setText(cHelper.getRingSizes(cCursor));
		undergarmentSizesDisplay.setText(cHelper.getUndergarmentSize(cCursor)); 
		otherDisplay.setText(cHelper.getOther(cCursor));
		
		heightDisplay.setText(cHelper.getHeight(cCursor)); 
		weightDisplay.setText(cHelper.getWeight(cCursor));
		hairColorDisplay.setText(cHelper.getHairColor(cCursor)); 
		eyeColorDisplay.setText(cHelper.getEyeColor(cCursor)); 
		heritageDisplay.setText(cHelper.getHeritage(cCursor)); 
		personalityDisplay.setText(cHelper.getPersonality(cCursor)); 
		openlyWantsDisplay.setText(cHelper.getOpenlyWants(cCursor)); 
		
		
		likesDisplay.setText(cHelper.getLikes(cCursor));
	    dislikesDisplay.setText(cHelper.getDislikes(cCursor));
		notesDisplay.setText(cHelper.getNotes(cCursor));
	
		
		if (cHelper.getFriendType(cCursor).equals("family")) {
			typeDisplay.setText("Family");
		}
		else if (cHelper.getFriendType(cCursor).equals("lover")) {
			typeDisplay.setText("Spouse/Lover");
		}
		else if (cHelper.getFriendType(cCursor).equals("closeFriend")) {
			typeDisplay.setText("Close Friend");
		}
		else if (cHelper.getFriendType(cCursor).equals("friend")) {
			typeDisplay.setText("Friend");
		}
		else {
			typeDisplay.setText("Co-Worker");
		}
		cHelper.close();
	}
	
	
	 
	//Build Option Menu by inflating xml
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.update_menu, menu);
		return(super.onCreateOptionsMenu(menu));
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()){
    	
		case R.id.menu_edit:
    		Intent i = new Intent(ContactView.this, DetailForm.class);
			i.putExtra(ID_EXTRA, contactId);
			startActivity(i);
		    return(true);
    	case R.id.menu_home:
			startActivity(new Intent(this, Portal.class));
			return(true);
		case R.id.menu_add:
			startActivity(new Intent(this, DetailForm.class));
			return(true);
		case R.id.menu_exit_app:
			finish();
			return(true);
		default:
			return(super.onOptionsItemSelected(item));
		
	  }
	}

  }