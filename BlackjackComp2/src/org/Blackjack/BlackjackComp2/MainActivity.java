package org.Blackjack.BlackjackComp2;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
    	
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
        // Do something in response to button
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    
    	//---CheckBox---
    	CheckBox checkBox = (CheckBox) findViewById(R.id.chkAutosave);
    	checkBox.setOnClickListener(new View.OnClickListener()
    	{
    		public void onClick(View v) {
    			if (((CheckBox)v).isChecked())
    				DisplayToast("CheckBox is Checked");
    			else 
    				DisplayToast("CheckBox is unchecked")
    		}
    	});
    	
    	//---RadioButton---
    	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rdbGp1);
    	radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
    	{
    		public void onCheckedChangeed(RadioGroup group, int checkedId) {
    			RadioButton rb1 = (RadioButton) findViewById(R.id.rdb1);
    			if (rb1.isChecked()) {
    				DisplayToast("Option 1 checked!")
    			} else {
    				DisplayToast("Option 2 checked!");
    			}
    		}
    	});
    	
    	//---ToggleButton---
    	ToggleButton toggleButton =
    			(ToggleButton) findViewById(R.id.toggle1);
    	toggleButton.setOnClickListener(new View.OnClickListener() 
    	{
    		public void onClick(View v) {
    			if (((ToggleButton)v).isChecked())
    				DisplayToast("Toggle button is On")
    			else
    				DisplayToast("Toggle button is Off");
    		}
    	});
    }
    
    private void DisplayToast(String msg)
    {
    	Toast.makeText(getBaseContext(), msg,
    			Toast.LENGTH_SHORT).show();
    }
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		})
    	
}
