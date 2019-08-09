package com.example.braingames;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
    public database(Context context) {
        super(context, "braingame", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cop="Create table cquesr(id integer primary key autoincrement,ques text,op1 text,op2 text,op3 text,op4 text,ans text)";
      String tab="Create table register(email text,pass text,name text)";
      String ds="Create table dsaquesr(id integer primary key autoincrement,ques text,op1 text,op2 text,op3 text,op4 text,ans text)";
        String dbm="Create table dbmsquesr(id integer primary key autoincrement,ques text,op1 text,op2 text,op3 text,op4 text,ans text)";
        String ja="Create table javaquesr(id integer primary key autoincrement,ques text,op1 text,op2 text,op3 text,op4 text,ans text)";
        String lin="Create table linuxquesr(id integer primary key autoincrement,ques text,op1 text,op2 text,op3 text,op4 text,ans text)";
        db.execSQL(lin);
        db.execSQL(ja);
        db.execSQL(dbm);
        db.execSQL(cop);
        db.execSQL(ds);
      db.execSQL(tab);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS linuxquesr");
    }
    public void add_reg(String email,String pass,String nam)
    {
     SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("email",email);
        cv.put("pass",pass);
        cv.put("name",nam);
        db.insert("register",null,cv);
        db.close();
    }
    public Cursor all_data_reg(String m,String p)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String get="Select * from register where email='"+m+"' and pass='"+p+"'";
        Cursor c=db.rawQuery(get,null);
        return c;
    }
    public void add_c(String quess,String op11,String op22,String op33,String op44,String anss)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("ques",quess);
        cv.put("op1",op11);
        cv.put("op2",op22);
        cv.put("op3",op33);
        cv.put("op4",op44);
        cv.put("ans",anss);
        db.insert("cquesr",null,cv);
        db.close();
    }
    public void add_dsa(String quess,String op11,String op22,String op33,String op44,String anss)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("ques",quess);
        cv.put("op1",op11);
        cv.put("op2",op22);
        cv.put("op3",op33);
        cv.put("op4",op44);
        cv.put("ans",anss);
        db.insert("dsaquesr",null,cv);
        db.close();
    }
    public void add_dbms(String quess,String op11,String op22,String op33,String op44,String anss)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("ques",quess);
        cv.put("op1",op11);
        cv.put("op2",op22);
        cv.put("op3",op33);
        cv.put("op4",op44);
        cv.put("ans",anss);
        db.insert("dbmsquesr",null,cv);
        db.close();
    }
    public void add_java(String quess,String op11,String op22,String op33,String op44,String anss)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("ques",quess);
        cv.put("op1",op11);
        cv.put("op2",op22);
        cv.put("op3",op33);
        cv.put("op4",op44);
        cv.put("ans",anss);
        db.insert("javaquesr",null,cv);
        db.close();
    }
    public void add_linux(String quess,String op11,String op22,String op33,String op44,String anss)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("ques",quess);
        cv.put("op1",op11);
        cv.put("op2",op22);
        cv.put("op3",op33);
        cv.put("op4",op44);
        cv.put("ans",anss);
        db.insert("linuxquesr",null,cv);
        db.close();
    }
    public Cursor info_c(int i)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String get="Select * from cquesr where id="+i+"";
        Cursor cu=db.rawQuery(get,null);
        return cu;
    }
    public Cursor info_dsa(int i)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String get="Select * from dsaquesr where id="+i+"";
        Cursor cu=db.rawQuery(get,null);
        return cu;
    }
    public Cursor info_dbms(int i)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String get="Select * from dbmsquesr where id="+i+"";
        Cursor cu=db.rawQuery(get,null);
        return cu;
    }
    public Cursor info_java(int i)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String get="Select * from javaquesr where id="+i+"";
        Cursor cu=db.rawQuery(get,null);
        return cu;
    }
    public Cursor info_linux(int i)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String get="Select * from linuxquesr where id="+i+"";
        Cursor cu=db.rawQuery(get,null);
        return cu;
    }
}
