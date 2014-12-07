package cl.telematica.tareamultimedios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
 
public class SingleItemView extends Activity {
	// Declare Variables
	String image;
	ImageLoader imageLoader = new ImageLoader(this);
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview);
 
		Intent i = getIntent();
		image = i.getStringExtra("image");
		
		// Locate the ImageView in singleitemview.xml
		ImageView imgflag = (ImageView) findViewById(R.id.image);
 
		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(image, imgflag);
	}
}