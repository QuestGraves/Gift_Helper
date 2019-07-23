package com.questgraves.gifthelper;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
 

@SuppressWarnings("deprecation")
public class Portal extends TabActivity implements OnClickListener 
{

	public final static String ID_EXTRA = "com.quest.gifthelper._ID";
	String contactId = null;

	public void onCreate(Bundle SavedInstanceState) {
		super.onCreate(SavedInstanceState); 
		setContentView(R.layout.portal);
		this.setTheme(R.style.IcsText);
		
	
		AdView avPortal = (AdView)this.findViewById(R.id.adViewPortal);
		avPortal.loadAd(new AdRequest());
	
		 
		
        //Initialize & Set up click listeners for buttons
        View contactButton = findViewById(R.id.contact_button);
        contactButton.setOnClickListener(this);
        View addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
       
		
        //Initialize the TabHost to load both tabs
        TabHost.TabSpec spec = getTabHost().newTabSpec("tag1");
		    
	        spec.setContent(R.id.portalTab_1);
	        spec.setIndicator("Help", getResources().getDrawable(R.drawable.ic_menu_help));
	    
	        getTabHost().addTab(spec);
	    
	        spec = getTabHost().newTabSpec("tag2");
	        spec.setContent(R.id.portalTab_2);
	        spec.setIndicator("Home", getResources().getDrawable(R.drawable.ic_menu_manage));
	    
	        getTabHost().addTab(spec);
	    
	        getTabHost().setCurrentTab(1);
	        
	        //Initialize contactID constant variable intent
	        contactId = getIntent().getStringExtra(GiftHelper.ID_EXTRA);
		
	}
	
	

	
	//Build Option Menu by inflating xml
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.help_add_menu, menu);
		return(super.onCreateOptionsMenu(menu));
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.help_add) {
			
			Intent i = new Intent(Portal.this, DetailForm.class);
			i.putExtra(ID_EXTRA, contactId);
			startActivity(i);
		
	}
		return(super.onOptionsItemSelected(item));
	}
	
	   public void onClick(View v){
	    	switch (v.getId()){
	    	case R.id.contact_button:
	    		Intent i = new Intent(this, GiftHelper.class);
	    		startActivity(i);
	    		break;
	    
	    	case R.id.add_button:
	    		Intent j = new Intent(this, DetailForm.class);
	    		startActivity(j);
	    		break;
	    		
	    	case R.id.exit_button:
	    		finish();
	    		break;
	    	  }
	       }
	
	}
