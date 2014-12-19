package cl.telematica.tareamultimedios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ImagenesSQLiteHelper extends SQLiteOpenHelper {
	 
	private String sqlString = "CREATE TABLE imagenes (id INTEGER PRIMARY KEY, like TEXT)";
	 private static final int DATABASE_VERSION = 1;
	 private static final String DATABASE_NAME = "ImagenesDB";
	 public ImagenesSQLiteHelper(Context ctx){
	super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	 }
	 @Override
	 public void onCreate(SQLiteDatabase db){
	db.execSQL(sqlString);
	 }
	 @Override
	 public void onUpgrade(SQLiteDatabase db, int lastVersion, int newVersion){
	db.execSQL("DROP TABLE IF EXISTS imagenes");
	onCreate(db);
	 }
	 
	}
