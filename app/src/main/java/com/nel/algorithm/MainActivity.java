package com.nel.algorithm;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nel.algorithm.cp.People;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add();
        query();
    }

    private void add() {
        ContentValues values = new ContentValues();
        values.put(People.KEY_NAME, "nel");
        values.put(People.KEY_AGE, 28);
        values.put(People.KEY_HEIGHT, 180);
        getContentResolver().insert(People.CONTENT_URI, values);
    }

    private void query() {
        Cursor cursor = getContentResolver().query(People.CONTENT_URI, new String[]{People.KEY_ID, People.KEY_NAME, People.KEY_AGE, People.KEY_HEIGHT}, null, null, null);
        if (cursor == null) {
            return;
        }
        String msg= "";

        if (cursor.moveToFirst()) {
            do {
                msg += "ID: " + cursor.getString(cursor.getColumnIndex(People.KEY_ID)) + ",";
                msg += "姓名: " + cursor.getString(cursor.getColumnIndex(People.KEY_NAME)) + ",";
                msg += "年龄: " + cursor.getInt(cursor.getColumnIndex(People.KEY_AGE)) + ",";
                msg += "身高: " + cursor.getFloat(cursor.getColumnIndex(People.KEY_HEIGHT)) + ",";
            } while (cursor.moveToNext());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}
