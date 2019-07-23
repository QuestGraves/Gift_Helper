package com.questgraves.gifthelper;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.questgraves.gifthelper.GiftDbAdapter.GiftDbHelper;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup; 
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;

/** GiftHelper is a class created to display a list of contacts the user can select from, add information
 * about, to in turn make better decisions while buying gifts. While tied to the SQLite database this view is only 
 * concerned with displaying the name of the contact along with a graphic representing the type of relation the person
 * is to the user.
 * @author  Quest Graves - AuroraQuest Software April 2011 *last updated January 2012
*/

public class GiftHelper extends ListActivity {
	
	public final static String ID_EXTRA = "com.quest.gifthelper._ID";
	private static final CharSequence message = "To get started, add a contact by pressing menu";
	Cursor model = null;
	GetterAdapter adapter = null;
    GiftDbHelper helper = null;
	public static final String ROW_ID = GiftDbAdapter.KEY_ID;
	private static final int DELETE_ID = R.id.delete ;
	protected static final String TAG = null;
	private GiftDbAdapter gDbHelper;
	

	
	@SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
      
        helper = new GiftDbHelper(this);
        model = helper.getAll();
        startManagingCursor(model);
        adapter = new GetterAdapter(model);
        setListAdapter(adapter);
        registerForContextMenu(getListView());
        gDbHelper = new GiftDbAdapter(this);
        gDbHelper.open();
        

        
        
        AdView avGHelper_1 = (AdView)this.findViewById(R.id.adViewGHelper_1);
		 avGHelper_1.loadAd(new AdRequest());
      
    }
	
		//Display toast at startup to inform how to add contacts
		public boolean displayToast() {
			Toast.makeText(this, message, Toast.LENGTH_LONG).show();
				return true;
	
	}

		//when clicking on a contact in the list, display the info stored in the database
		@Override
		public void onListItemClick(ListView list, View view, int position, long id) {
			
			Intent i = new Intent(GiftHelper.this, ContactView.class);
		
			i.putExtra(ID_EXTRA, String.valueOf(id));
			startActivity(i);
	}
	
 
		
		//Build Option Menu by inflating xml
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			new MenuInflater(this).inflate(R.menu.option, menu);
			return(super.onCreateOptionsMenu(menu));
		}
		
		//Method for menu item selected
		public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		    case R.id.add:
		    	startActivity(new Intent(GiftHelper.this, DetailForm.class));
		        return true;
		    case R.id.home:
		    	startActivity(new Intent(GiftHelper.this, Portal.class));
		        return true;
		    default:
			return(super.onOptionsItemSelected(item));
		}
	}

	    @Override
	    public void onCreateContextMenu(ContextMenu menu, View v,
	            ContextMenuInfo menuInfo) {
	        super.onCreateContextMenu(menu, v, menuInfo);
	        menu.add(0, DELETE_ID, 0, R.string.delete);
	    }

	    @Override
	    public boolean onContextItemSelected(MenuItem item) {
	    	switch(item.getItemId()) {
	            case DELETE_ID:
	                AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	                gDbHelper.deleteRecord(info.id);
	                refreshList();
	                return true;
	        }
	        return super.onContextItemSelected(item);
	    }
	    //method to populate listView. need to update to include icon
	  public void refreshList() {
	       
	            // Get all of the rows from the database and create the item list
	        	Cursor model = gDbHelper.reFetch();
	            startManagingCursor(model);

	            // Create an array to specify the fields we want to display in the list (only TITLE)
	            String[] from = new String[]{GiftDbAdapter.KEY_NAME};

	            // and an array of the fields we want to bind those fields to (in this case just text1)
	            int[] to = new int[]{R.id.title};

	            // Now create a simple cursor adapter and set it to display
	            SimpleCursorAdapter gAdapter = 
	                new SimpleCursorAdapter(this, R.layout.row, model, from, to);
	            setListAdapter(gAdapter);
	        
	        }
	    
	  
	    
	    // Custom Adapter for custom row logic
	    class GetterAdapter extends CursorAdapter {
	    	
	    	GetterAdapter(Cursor c) {
	    		super(GiftHelper.this, c);
	    	}

		@Override
		public void bindView(View row, Context ctxt, Cursor c) {
			GiftHolder holder = (GiftHolder)row.getTag();
			
			
				holder.populateFrom(c, helper);
		
			
			}

		
		@Override
		public View newView(Context ctxt, Cursor c, ViewGroup parent) {
			LayoutInflater inflater = getLayoutInflater();
			View row = inflater.inflate(R.layout.row, parent, false);
			GiftHolder holder = new GiftHolder(row);
			
			row.setTag(holder);
			
			return(row);
		
	}
}
	    //Encapsulation class to hold name used in ListView
	    static class GiftHolder {
				private TextView name = null;
					GiftHolder(View row) {
					name = (TextView)row.findViewById(R.id.title);
	}
	
					
			        void populateFrom(Cursor c, GiftDbHelper helper)  {
					name.setText(helper.getName(c));
			        
	  }
				
 }

//new experimental!!!!!!!
/**	    //Alert Dialog to Import Contacts from Contacts App
	    public void showAlert(View view) {
	    	new AlertDialog.Builder(this)
	    	.setTitle("Import Request")
	    	.setMessage("Would you like to import your contacts from your phones contact list?")
	    	.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
	    		public void onClick(DialogInterface dialogYes, int positiveButton ){
	    			//query "contacts" to add name column to listView
	    			getContacts();
	    			Log.d(TAG,"contacts got...now what to do?");
	    	
	    	static class AlertHolder {
	    		private TextView name = null;
	    		AlertHolder(View row) {
	    			name = (TextView)row.finViewById(R.id.tot=)
	    		}
	    	}
	    			
	    			
	    			
	    		}
	    	})
	    	.setNegativeButton("Not Now", new DialogInterface.OnClickListener() {	
	    		public void onClick(DialogInterface dialogNo, int negativeButton ){
	    			//show toast to help add new contact
	    			displayToast();
	    		}
	    	})
	    	.show();
	    }
	    
	    /**
	     * Obtains the contact list for the currently selected account.
	     *
	     * @return A cursor for for accessing the contact list.
	     */
	    private Cursor getContacts()
	    {
	        // Run query
	        Uri uri = ContactsContract.Contacts.CONTENT_URI;
	        String[] projection = new String[] {
	                ContactsContract.Contacts._ID,
	                ContactsContract.Contacts.DISPLAY_NAME
	        };
	        String selection = ContactsContract.Contacts.IN_VISIBLE_GROUP;
	        String[] selectionArgs = null;
	        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME ;

	        return managedQuery(uri, projection, selection, selectionArgs, sortOrder);
	    }
 //end experimental code block
   
	@Override
	public void onDestroy() {
		super.onDestroy();
		model.close();
		helper.close();
		gDbHelper.close();
	}
	
	
	
}