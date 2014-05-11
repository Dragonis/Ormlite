package com.test.ormlite;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	DatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			doNoteDataStuff();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void doNoteDataStuff() throws SQLException{
		dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
		RuntimeExceptionDao<Note, Integer> noteDao = dbHelper.getNoteRuntimeExceptionDao();
		
		noteDao.create(new Note("note1", "note1 text"));
		noteDao.create(new Note("note2", "note2 text"));
		noteDao.create(new Note("note3", "note3 text"));
		
		List<Note> notes = noteDao.queryForAll();
		Log.d("Demo", notes.toString());
		notes = noteDao.queryForEq("id", 1);
		Log.d("Demo", notes.toString());
		
		OpenHelperManager.releaseHelper();
	}
}
