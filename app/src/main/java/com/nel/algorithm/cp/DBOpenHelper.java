package com.nel.algorithm.cp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Description :
 * CreateTime : 2018/5/21 15:57
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_TABLE = "peopleinfo";

    private static final  String DB_CREATE = "create table "+
            DB_TABLE+"("+People.KEY_ID+" integer primary key autoincrement, "+
            People.KEY_NAME+" text not null, "+People.KEY_AGE+" integer, "+
            People.KEY_HEIGHT+" float);";


    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);
    }
}
