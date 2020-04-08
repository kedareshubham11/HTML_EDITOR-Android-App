package com.example.htmleditor;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final int PICK_IMAGE = 100;
	private static final int PICK_VIDEO=100;
	Uri imageURI,videoURI;
EditText e1;
Button write,read;
TextView filecon;
String abc ="";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       e1 = (EditText)findViewById(R.id.editText1);
      e1.addTextChangedListener(new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			//e1.setText("<html><head><link rel=\"stylesheet\" media=\"screen and (-webkit-device-pixel-ratio:1.5)\" href=\"hdpi.css\"/></head><body>");
			String filename = "Fileaditya";
	        String filecontent = e1.getText().toString();
	        FileOperations fop = new FileOperations();
	        fop.write(filename, filecontent);
	        if(fop.write(filename, filecontent)){
	      	  String url ="file:///storage/sdcard/Fileaditya.html";
	      	  
	      	
		        WebView view = (WebView)findViewById(R.id.webView1);
		     //view.loadData(e1.getText().toString(), "text/html", null);
		        view.getSettings().setJavaScriptEnabled(true);
		        view.loadUrl(url);
	        }else{
	          Toast.makeText(getApplicationContext(), "I/O error", Toast.LENGTH_SHORT).show();
	 
	        }	  
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
		
			
		}
	});
     
      }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.main, menu);
       return super.onCreateOptionsMenu(menu);
    }
	private void openGallery() {
		
		
		Intent gallery = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
		startActivityForResult(gallery, PICK_IMAGE); 
		abc="abcd";
				
		}
	private void openGallery1() {
		
		
		 Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
		startActivityForResult(i, PICK_VIDEO); 
		abc="abcde";
				
		}
	
	
   
	protected void onActivityResult(int requestCode, int resultCode, Intent data )
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(abc.equals("abcd"))
		{
		if(resultCode == RESULT_OK && requestCode == PICK_IMAGE)
		{
			imageURI = data.getData();
			e1.setText(e1.getText().toString()+"<img src="+imageURI+" />");
		}
		}
		if(abc.equals("abcde"))
		{
		if(resultCode == RESULT_OK && requestCode == PICK_VIDEO)
		{
			imageURI = data.getData();
			e1.setText(e1.getText().toString()+"<audio controls><source src="+imageURI+" type=\"audio/ogg\"><source src="+imageURI+" type=\"audio/mpeg\">Your browser does not support the audio element.</audio>");
		}
		}
		
	}
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bold:
            	e1.setText(e1.getText().toString()+"<strong>yourtexthere</strong>"); 
            	return true;
            case R.id.bullets:
            	e1.setText(e1.getText().toString()+"<ul><li>yourtexthere1</li><li>yourtexthere2</li><li>yourtexthere3</li></ul>"); 
            	return true;
            case R.id.center:
            	e1.setText(e1.getText().toString()+"<center>yourtexthere</center>"); 
            	return true;
            case R.id.italic:
            	e1.setText(e1.getText().toString()+"<i>yourtexthere</i>"); 
            	return true;
            case R.id.marquee:
            	e1.setText(e1.getText().toString()+"<marquee>yourtexthere</marquee>"); 
            	return true;
            case R.id.nextline:
            	e1.setText(e1.getText().toString()+"<br>"); 
            	return true;
            case R.id.para:
            	e1.setText(e1.getText().toString()+"<p>your text here</p>"); 
            	return true;
            case R.id.underline:
            	e1.setText(e1.getText().toString()+"<u>yourtexthere</u>"); 
            	return true;
            case R.id.heading:
            	e1.setText(e1.getText().toString()+"<h1>yourtexthere</h1>"); 
            	return true;
            case R.id.image:
            	openGallery();
            	return true;
            case R.id.Input:
            	e1.setText(e1.getText().toString()+"<input type=\"text\" placeholder=\"Enter Emailid\"/>"); 
            	return true;
            case R.id.Audio:
            	openGallery1();
            	return true;
           
            
               
        }
        return super.onOptionsItemSelected(item);
    }

	
		
 public	void btnclear(View v)
 {
	 if(v.getId() == R.id.button1)
	 {
		 e1.setText("");
	 }
}
 


}
