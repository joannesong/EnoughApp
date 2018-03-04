package nyc.c4q.enough.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nyc.c4q.enough.data.ContactsContract.ContactEntries;
import nyc.c4q.enough.model.Contact;

import android.provider.*;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by c4q on 3/3/18.
 */

public class ContactsDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "contacts.db";

    private static final int DATABASE_VERSION = 2;

    private static ContactsDBHelper dbInstance;


    public static synchronized ContactsDBHelper getDbInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = new ContactsDBHelper(context.getApplicationContext());
        }
        return dbInstance;
    }

    private ContactsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_CONTACTS_TABLE = "CREATE TABLE " + ContactEntries.TABLE_NAME + " (" +
                ContactEntries._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ContactEntries.COLUMN_NAME + "TEXT NOT NULL, " +
                ContactEntries.COLUMN_CELL + "TEXT NOT NULL, " +
                "UNIQUE (" + ContactEntries.COLUMN_CELL + ") +" +
                " ON CONFLICT REPLACE );";
        db.execSQL(SQL_CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ContactEntries.TABLE_NAME);
        onCreate(db);
    }

    public void addContact(Contact contact) {
        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactEntries.COLUMN_NAME, contact.getContactName());
        contentValues.put(ContactEntries.COLUMN_CELL, contact.getContactNumber());

        db.insertOrThrow(ContactEntries.TABLE_NAME, null, contentValues);

        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public List<Contact> getContacts() {
        List<Contact> results = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + ContactEntries.TABLE_NAME, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    {
                        Contact contact = new Contact();
                        contact.setContactName(cursor.getString(cursor.getColumnIndex(ContactEntries.COLUMN_NAME)));
                        contact.setContactNumber(cursor.getString(cursor.getColumnIndex(ContactEntries.COLUMN_CELL)));
                        results.add(contact);
                    }
                } while (cursor.moveToNext());
            }
        }

        return results;
    }

    public void removeContact(Contact contact) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(ContactEntries.TABLE_NAME, ContactEntries.COLUMN_CELL + " =  ?", new String[]{contact.getContactNumber()});
    }


}
