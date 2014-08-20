package com.example.addressbooksample;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "MyDBName.db";
	public static final String TABLE_NAME = "contacts";
	   public static final String CONTACTS_COLUMN_NAME = "name";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("create table contacts");
		sql.append("(id integer primary key, name text,phone text,email text, street text,place text)");

		db.execSQL(sql.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS contacts");
		onCreate(db);
	}

	public boolean insertContact(String name, String phone, String email,
			String street, String place) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", name);
		contentValues.put("phone", phone);
		contentValues.put("email", email);
		contentValues.put("street", street);
		contentValues.put("place", place);

		db.insert(TABLE_NAME, null, contentValues);
		return true;
	}

	public Cursor getData(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		String sql = String.format("select * from %s where id = %d",
				TABLE_NAME, id);
		Cursor res = db.rawQuery(sql, null);
		return res;
	}

	public int getNumberOfRows() {
		SQLiteDatabase db = this.getWritableDatabase();
		int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
		return numRows;
	}

	public boolean updateContact(Integer id, String name, String phone,
			String email, String street, String place) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", name);
		contentValues.put("phone", phone);
		contentValues.put("email", email);
		contentValues.put("street", street);
		contentValues.put("place", place);

		db.update(TABLE_NAME, contentValues, "id = ?", new String[]{Integer.toString(id)});
		return true;
	}
	
	public Integer deleteContact(Integer id){
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(TABLE_NAME, "id = ?", new String[]{Integer.toString(id)});
	}
	
	public ArrayList<String> getAllContacts(){
		SQLiteDatabase db = this.getWritableDatabase();
		String sql = String.format("SELECT * FROM %s", TABLE_NAME);
		Cursor res = db.rawQuery(sql, null);
		ArrayList<String> contacts = new ArrayList<String>();
		
		res.moveToFirst();
		while(res.isAfterLast()){
			contacts.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
			res.moveToNext();
		}
		return contacts;
	}
}
