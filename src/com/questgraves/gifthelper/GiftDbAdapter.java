package com.questgraves.gifthelper;



import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.SQLException;
import android.content.ContentValues;

/**
 * GiftDbAdapter class is SQLite Db Helper class to create and interface with Java logic and xml layout
 * for the Gift Helper Donate app.
 * @author  Quest Graves - AuroraQuest Software April 2011 *last updated January 2012
 *
 */

public class GiftDbAdapter {
	 private static final String DATABASE_NAME = "giftHelperDb";
	 private static final String DATABASE_TABLE = "contacts";
	 private static final int SCHEMA_VERSION = 3;
	 public static final String KEY_ID = "_id";
	 public static final String KEY_NAME = "name";
	 public static final String KEY_TYPE = "friendType";

	    private GiftDbHelper gDbHelper;
	    private SQLiteDatabase gDb;
	    private final Context mCtx;	
	

	 public static class GiftDbHelper extends SQLiteOpenHelper {
		 
	 
		 GiftDbHelper(Context context) {
		     super(context, DATABASE_NAME, null, SCHEMA_VERSION);
	 }
	 
	 
	 @Override
	 public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE contacts (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,  birthday TEXT, " +
				"importantDates TEXT, friendType TEXT, favColor TEXT, favMusician TEXT, favSong TEXT, " +
				"favMovie TEXT, favBooks TEXT, favFoods TEXT, favRestaurant TEXT, favAnimal TEXT, favPet TEXT, favWord TEXT, favTvShows TEXT, favHistFigs TEXT, favHobbies TEXT, " +
				"favCollectibles TEXT, coatSize TEXT, shirtSize TEXT, pantSize TEXT, shoeSize TEXT, sockType TEXT, ringSizes TEXT, undergarmentSize TEXT, other TEXT, height TEXT, " +
				"weight TEXT, hairColor TEXT, eyeColor TEXT, heritage TEXT, personality TEXT, openlyWants TEXT, likes TEXT,  dislikes TEXT, notes TEXT);" ); 
	 }
	 
	 @Override
	 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("CREATE TEMPORARY TABLE contacts_backup (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,  birthday TEXT, " +
				"importantDates TEXT, friendType TEXT, favColor TEXT, favWord TEXT, favMusician TEXT, favSong TEXT, " +
				"favMovie TEXT, favFoods TEXT,  favRestaurant TEXT, favAnimal TEXT, favTvShows TEXT, favHistFigs TEXT, favHobbies TEXT, " +
				"favCollectibles TEXT, shirtSize TEXT, pantSize TEXT, shoeSize TEXT, other TEXT, likes TEXT, dislikes TEXT, notes TEXT);"); 
			
			db.execSQL("INSERT INTO contacts_backup SELECT _id, name, birthday, importantDates, friendType, favColor, " +
		 		"favWord, favMusician, favSong, favMovie, favFoods, favRestaurant, favAnimal, favTvShows, favHistFigs, favHobbies, " +
		 		"favCollectibles, shirtSize, pantSize, shoeSize, other, likes, dislikes, notes FROM contacts ");
			
			db.execSQL("DROP TABLE contacts");
			
			db.execSQL("CREATE TABLE contacts (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,  birthday TEXT, " +
					"importantDates TEXT, friendType TEXT, favColor TEXT, favMusician TEXT, favSong TEXT, " +
					"favMovie TEXT, favBooks TEXT, favFoods TEXT, favRestaurant TEXT, favAnimal TEXT, favPet TEXT, favWord TEXT, favTvShows TEXT, favHistFigs TEXT, favHobbies TEXT, " +
					"favCollectibles TEXT, coatSize TEXT, shirtSize TEXT, pantSize TEXT, shoeSize TEXT, sockType TEXT, ringSizes TEXT, undergarmentSize TEXT, other TEXT, height TEXT, " +
					"weight TEXT, hairColor TEXT, eyeColor TEXT, heritage TEXT, personality TEXT, openlyWants TEXT, likes TEXT,  dislikes TEXT, notes TEXT);" ); 
			
			db.execSQL("INSERT INTO contacts SELECT _id, name, birthday, importantDates, friendType, favColor," +
		 		"favMusician, favSong, favMovie, null, favFoods, favRestaurant, favAnimal, null, favWord, favTvShows, favHistFigs, favHobbies, " +
		 		"favCollectibles, null, shirtSize, pantSize, shoeSize, null, null, null, other, null, null, null, null, null, null, null, likes, dislikes, notes FROM contacts_backup ");
			
			db.execSQL("DROP TABLE contacts_backup");
			
			
	     }
	 

		
	 public Cursor getAll() {
		 return(getWritableDatabase().rawQuery("SELECT _id, name, birthday, importantDates, friendType, favColor, " +
		 		" favMusician, favSong, favMovie, favBooks, favFoods, favRestaurant, favAnimal, favPet, favWord, favTvShows, favHistFigs, favHobbies, " +
		 		"favCollectibles, coatSize, shirtSize, pantSize, shoeSize, sockType, ringSizes, undergarmentSize, other, height, weight, hairColor, eyeColor," +
		 		"heritage, personality, openlyWants, likes, dislikes, notes FROM contacts ORDER BY name", null));
	 }
	 

	
	 public void insert(String id, String name, String birthday, String importantDates, String friendType, String favColor, 
			 		    String favMusician, String favSong, String favMovie, String favBooks, String favFoods, 
			 			String favRestaurant, String favAnimal, String favPet, String favWord, String favTvShows, String favHistFigs, String favHobbies, 
			 			String favCollectibles, String coatSize, String shirtSize, String pantSize, String shoeSize, String sockType, String ringSizes, 
			 			String undergarmentSize, String other, String height, String weight, String hairColor, String eyeColor, String heritage, String personality,
			 			String openlyWants, String likes, String dislikes, String notes) {
		 
		 ContentValues cv = new ContentValues();
		 
		 cv.put("name", name);
		 cv.put("birthday", birthday);
		 cv.put("importantDates", importantDates);
		 cv.put("friendType", friendType);
		 cv.put("favColor", favColor);
		 cv.put("favMusician", favMusician);
		 cv.put("favSong", favSong);
		 cv.put("favMovie", favMovie);
		 cv.put("favBooks", favBooks);
		 cv.put("favFoods", favFoods);
		 cv.put("favRestaurant", favRestaurant);
		 cv.put("favAnimal", favAnimal);
		 cv.put("favPet", favPet);
		 cv.put("favWord", favWord);
		 cv.put("favTvShows", favTvShows);
		 cv.put("favHistFigs", favHistFigs);
		 cv.put("favHobbies", favHobbies);
		 cv.put("favCollectibles", favCollectibles);
		 cv.put("coatSize", coatSize);
		 cv.put("shirtSize", shirtSize);
		 cv.put("pantSize", pantSize);
		 cv.put("shoeSize", shoeSize);
		 cv.put("sockType", sockType);
		 cv.put("ringSizes", ringSizes);
		 cv.put("undergarmentSize", undergarmentSize);
		 cv.put("other", other);
		 cv.put("height", height);
		 cv.put("weight", weight);
		 cv.put("hairColor", hairColor);
		 cv.put("eyeColor", eyeColor);
		 cv.put("heritage", heritage);
		 cv.put("personality", personality);
		 cv.put("openlyWants", openlyWants);
		 cv.put("likes", likes);
		 cv.put("dislikes", dislikes);
		 cv.put("notes", notes);
		 
		 getWritableDatabase().insert("contacts", "name", cv);
		 
	 }


	 
	 public Cursor getById(String id) {
		 String[] args = {id};
		 
		 return(getWritableDatabase().rawQuery("SELECT _ID,  name, birthday, importantDates, friendType, favColor, " +
		 		"favMusician, favSong, favMovie, favBooks, favFoods, favRestaurant, favAnimal, favPet, favWord, favTvShows, favHistFigs, favHobbies, " +
		 		"favCollectibles, coatSize, shirtSize, pantSize, shoeSize, sockType, ringSizes, undergarmentSize, other, height, weight, hairColor, eyeColor," +
		 		"heritage, personality, openlyWants, likes, dislikes, notes FROM contacts WHERE _ID=?", args));
	 }

		public void update(String id, String name, String birthday, String importantDates, String friendType, String favColor, 
	 		    String favMusician, String favSong, String favMovie, String favBooks, String favFoods, 
	 			String favRestaurant, String favAnimal, String favPet, String favWord, String favTvShows, String favHistFigs, String favHobbies, 
	 			String favCollectibles, String coatSize, String shirtSize, String pantSize, String shoeSize, String sockType, String ringSizes, 
	 			String undergarmentSize, String other, String height, String weight, String hairColor, String eyeColor, String heritage, String personality,
	 			String openlyWants, String likes, String dislikes, String notes) {
			
			ContentValues cv = new ContentValues();
			String[] args = {id};
			
			 cv.put("name", name);
			 cv.put("birthday", birthday);
			 cv.put("importantDates", importantDates);
			 cv.put("friendType", friendType);
			 cv.put("favColor", favColor);
			 cv.put("favMusician", favMusician);
			 cv.put("favSong", favSong);
			 cv.put("favMovie", favMovie);
			 cv.put("favBooks", favBooks);
			 cv.put("favFoods", favFoods);
			 cv.put("favRestaurant", favRestaurant);
			 cv.put("favAnimal", favAnimal);
			 cv.put("favPet", favPet);
			 cv.put("favWord", favWord);
			 cv.put("favTvShows", favTvShows);
			 cv.put("favHistFigs", favHistFigs);
			 cv.put("favHobbies", favHobbies);
			 cv.put("favCollectibles", favCollectibles);
			 cv.put("coatSize", coatSize);
			 cv.put("shirtSize", shirtSize);
			 cv.put("pantSize", pantSize);
			 cv.put("shoeSize", shoeSize);
			 cv.put("sockType", sockType);
			 cv.put("ringSizes", ringSizes);
			 cv.put("undergarmentSize", undergarmentSize);
			 cv.put("other", other);
			 cv.put("height", height);
			 cv.put("weight", weight);
			 cv.put("hairColor", hairColor);
			 cv.put("eyeColor", eyeColor);
			 cv.put("heritage", heritage);
			 cv.put("personality", personality);
			 cv.put("openlyWants", openlyWants);
			 cv.put("likes", likes);
			 cv.put("dislikes", dislikes);
			 cv.put("notes", notes);
			 
			 getWritableDatabase().update("contacts", cv, "_ID=?",
					 args);
		}

		//getter methods to retrieve columns from a DB Cursor "cCursor"?
		public String get_Id(Cursor c) {
			return(c.getString(0));
		}
		public String getName(Cursor c) {
			return(c.getString(1));
		}
		public String getBirthday(Cursor c) {
			return(c.getString(2));
		}
		public String getImportantDates(Cursor c) {
			return(c.getString(3));
		}
		public String getFriendType(Cursor c) {
			return(c.getString(4));
		}
		public String getFavColor(Cursor c) {
			return(c.getString(5));
		}
		public String getFavMusician(Cursor c) {
			return(c.getString(6));
		}
		public String getFavSong(Cursor c) {
			return(c.getString(7));
		}
		public String getFavMovie(Cursor c) {
			return(c.getString(8));
		}
		public String getFavBooks(Cursor c) {
			return(c.getString(9));
		}
		public String getFavFoods(Cursor c) {
			return(c.getString(10));
		}
		public String getFavRestaurant(Cursor c) {
			return(c.getString(11));
		}
		public String getFavAnimal(Cursor c) {
			return(c.getString(12));	
		}
		public String getFavPet(Cursor c) {
			return(c.getString(13));
		}
		public String getFavWord(Cursor c) {
			return(c.getString(14));
		}
		public String getFavTvShows(Cursor c) {
			return(c.getString(15));
		}
		public String getFavHistFigs(Cursor c) {
			return(c.getString(16));
		}
		public String getfavHobbies(Cursor c) {
			return(c.getString(17));
		}
		public String getfavCollectibles(Cursor c) {
			return(c.getString(18));
		}
		public String getCoatSize(Cursor c) {
			return(c.getString(19));
		}
		public String getShirtSize(Cursor c) {
			return(c.getString(20));
		}
		public String getPantSize(Cursor c) {
			return(c.getString(21));
		}
		public String getShoeSize(Cursor c) {
			return(c.getString(22));
		}
		public String getSockType(Cursor c) {
			return(c.getString(23));
		}
		public String getRingSizes(Cursor c) {
			return(c.getString(24));
		}
		public String getUndergarmentSize(Cursor c) {
			return(c.getString(25));
		}
		public String getOther(Cursor c) {
			return(c.getString(26));
		}
		public String getHeight(Cursor c) {
			return(c.getString(27));
		}
		public String getWeight(Cursor c) {
			return(c.getString(28));
		}
		public String getHairColor(Cursor c) {
			return(c.getString(29));
		}
		public String getEyeColor(Cursor c) {
			return(c.getString(30));
		}
		public String getHeritage(Cursor c) {
			return(c.getString(31));
		}
		public String getPersonality(Cursor c) {
			return(c.getString(32));
		}
		public String getOpenlyWants(Cursor c) {
			return(c.getString(33));
		}
		public String getLikes(Cursor c) {
			return(c.getString(34));
		}
		public String getDislikes(Cursor c) {
			return(c.getString(35));
		}
		public String getNotes(Cursor c) {
			return(c.getString(36));
		}
		
	
		
	 }
	 
//new stuff
	 

	  public GiftDbAdapter(Context ctx) {
	        this.mCtx = ctx;
	    }
	   
	  
	   public GiftDbAdapter open() throws SQLException {
	        gDbHelper = new GiftDbHelper(mCtx);
	        gDb = gDbHelper.getWritableDatabase();
	        return this;
	    }

	    public void close() {
	        gDbHelper.close();
	    }
	   
	    public boolean deleteRecord(long rowId) {

	        return gDb.delete(DATABASE_TABLE, KEY_ID + "=" + rowId, null) > 0;
	    }
	    public Cursor reFetch() {

	        return gDb.query(DATABASE_TABLE, new String[] {KEY_ID, KEY_NAME, 
	                KEY_TYPE}, null, null, null, null, null);
	    }


	  
}