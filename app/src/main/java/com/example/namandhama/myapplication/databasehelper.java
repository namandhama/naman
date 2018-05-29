package com.example.namandhama.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class databasehelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME="notes";
    private static final int DATABASE_VERSION=2;
    private Dao <Note,Integer> noteDao=null;
    private RuntimeExceptionDao<Note,Integer> noteRunTimeDao=null;






    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,Note.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,Note.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Dao<Note, Integer> getDao() {
        if(noteDao==null) {
            try {
                noteDao = getDao(Note.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return noteDao;
    }

    public RuntimeExceptionDao<Note, Integer> getRunTimeDao() {

        if(noteRunTimeDao==null) {
            noteRunTimeDao =getRuntimeExceptionDao(Note.class);

        }
        return noteRunTimeDao;
    }
}
