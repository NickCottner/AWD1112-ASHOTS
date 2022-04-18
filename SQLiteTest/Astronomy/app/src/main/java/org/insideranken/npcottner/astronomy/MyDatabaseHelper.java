package org.insideranken.npcottner.astronomy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;

    private static final String DATABASE_NAME = "Astronomy.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "my_astronomy_library";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "constellation_name";
    public static final String COLUMN_FAMILY = "constellation_family";
    public static final String COLUMN_LATITUDE = "constellation_latitude";
    public static final String COLUMN_MONTH = "constellation_month";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " + COLUMN_FAMILY + " TEXT, " +
                        COLUMN_LATITUDE + " TEXT, " + COLUMN_MONTH + "TEXT );";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    void AddConstellation(String name, String family, String latitude, String month)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_FAMILY, family);
        cv.put(COLUMN_LATITUDE, latitude);
        cv.put(COLUMN_MONTH, month);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1)
        {
            Toast.makeText(context, "Failed To Add Constellation", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Successfully Added Constellation", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData()
    {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null)
        {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    void updateData(String row_id, String name, String family, String latitude, String month)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_FAMILY, family);
        cv.put(COLUMN_LATITUDE, latitude);
        cv.put(COLUMN_MONTH, month);

        long result = db.update(TABLE_NAME,cv,"_id=?", new String[]{row_id});
        if (result == -1)
        {
            Toast.makeText(context, "Update Failed!",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context, "Update Successful!", Toast.LENGTH_LONG).show();
        }
    }
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}
