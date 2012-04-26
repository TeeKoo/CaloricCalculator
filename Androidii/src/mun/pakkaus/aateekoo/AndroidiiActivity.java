package mun.pakkaus.aateekoo;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class AndroidiiActivity extends Activity {
	String vast;
	EditText tx, kiloE, pituusE, ikaE;
	TextView counter;
	Spinner spin;
	String gender;
	
   /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //---the button is wired to an event handler---
        Button btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(btnListener);
        counter = (TextView) findViewById(R.id.textView6);
        
        //Creating a spinner and adding two items to it.
        spin = (Spinner) findViewById(R.id.spinner1);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new SpinnerListener());
    }
    
    //---create an anonymous class to act as a button click listener---
    public OnClickListener btnListener = new OnClickListener()
    {
     
    	
        public void onClick(View v)
        {   
        	
        	int kilo = 0, pituus = 0, ika = 0, vastaus = 0;
        	String test1, test2, test3;
        	test1 = getString(R.id.editText1);
        	test2 = getString(R.id.EditText02);
        	test3 = getString(R.id.EditText01);
        	
        	try {
				if (test1 != "" && test2 != "" && test3 != "") {
					kiloE = (EditText) findViewById(R.id.editText1);
					kilo = Integer.parseInt(kiloE.getText().toString().trim());
					ikaE = (EditText) findViewById(R.id.EditText01);
					ika = Integer.parseInt(ikaE.getText().toString().trim());
					pituusE = (EditText) findViewById(R.id.EditText02);
					pituus = Integer.parseInt(pituusE.getText().toString().trim());
					
					if(gender.contains("Male"))
						vastaus = (int) Math.round(1.2 * (66 + (13.7 * kilo) + (5 * pituus) - (6.8 * ika)));
					
					if(gender.contains("Female"))
						vastaus = (int) Math.round(1.2*(655 + (9.6 * kilo) + (1.8 * pituus) - (4.7 * ika)));
					
					vast = vastaus + " kcal/day";
					counter.setText(vast);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

        }
        
       
        
        	
    };
    
    
    //spinner listener for values male and female
    public class SpinnerListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            gender = parent.getItemAtPosition(pos).toString();
        }



		public void onItemSelected1(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}


    }
    
}