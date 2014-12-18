package cl.telematica.tareamultimedios;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainListView extends Activity {
	// Declare Variables
		JSONObject jsonobject;
		JSONArray jsonarray;
		ListView listview;
		ListViewAdapter adapter;
		ProgressDialog mProgressDialog;
		ArrayList<HashMap<String, String>> arraylist;
		static String TITLE = "title";
		static String IMAGE = "image";
		static String POINTS = "points";
		static String LINK = "link";
		
	 
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			// Get the view from listview_main.xml
			setContentView(R.layout.listview_main);
			// Execute DownloadJSON AsyncTask
			new DownloadJSON().execute();
		}
	 
		// DownloadJSON AsyncTask
		private class DownloadJSON extends AsyncTask<Void, Void, Void> {
	 
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				// Create a progressdialog
				mProgressDialog = new ProgressDialog(MainListView.this);
				// Set progressdialog title
				mProgressDialog.setTitle("Android JSON Parse");
				// Set progressdialog message
				mProgressDialog.setMessage("Loading...");
				mProgressDialog.setIndeterminate(false);
				// Show progressdialog
				mProgressDialog.show();
			}
	 
			@Override
			protected Void doInBackground(Void... params) {
				// Create an array
				arraylist = new ArrayList<HashMap<String, String>>();
				// Retrieve JSON Objects from the given URL address
				jsonarray = JSONfunctions
						.getJSONfromURL("http://www.mocky.io/v2/5440667984d353f103f697c0");
	 
				try {
	 
					for (int i = 0; i < jsonarray.length(); i++) {
						HashMap<String, String> map = new HashMap<String, String>();
						jsonobject = jsonarray.getJSONObject(i);
						// Retrive JSON Objects
						map.put("title", jsonobject.getString("title"));
						map.put("image", jsonobject.getString("image"));
						map.put("points", jsonobject.getString("points"));
						map.put("link", jsonobject.getString("link"));
						// Set the JSON Objects into the array
						arraylist.add(map);
					}
				} catch (JSONException e) {
					Log.e("Error", e.getMessage());
					e.printStackTrace();
				}
				return null;
			}
	 
			@Override
			protected void onPostExecute(Void args) {
				// Locate the listview in listview_main.xml
				listview = (ListView) findViewById(R.id.listview);
				// Pass the results into ListViewAdapter.java
				adapter = new ListViewAdapter(MainListView.this, arraylist);
				// Set the adapter to the ListView
				listview.setAdapter(adapter);
				// Close the progressdialog
				mProgressDialog.dismiss();
			}
		}

}
