package mnnit.harshitshah.mymanager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
public class DBhelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="mydata.db";
    public static final String TYPE ="type";
    public static final String TABLE_NAME="details";
    public static final String EXPENSE="expense";
    public static final String NOTE="note";
    public static final String FLAG="flag";
    public static final String DATE="date";
    public DBhelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table details " + "(type TEXT,flag TEXT,expense INTEGER,note TEXT,date TEXT)");
        //db.execSQL("insert into details VALUES('food',10,'hello');");
        Log.d("created", "created");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS details ");
        onCreate(db);
    }
    public boolean insertnote(String type,Integer expense,String note,String flag,String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("type",type);
        cv.put("expense",expense);
        cv.put("note", note);
        cv.put("flag", flag);
        cv.put("date", date);
        db.insert("details", null, cv);
        return true;
    }
    public boolean deletetable()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM details");
        return true;
    }
    public ArrayList getdetails_type()
    {
        Log.d("ok", "ok");
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from details",null);
        result.moveToFirst();
        int i=0;
        while(result.isAfterLast()==false)
        {
           // type[i++]=result.getString(result.getColumnIndex("type"));
            //description[i++]=result.getString(result.getColumnIndex("note"));
            //expense[i++]=result.getInt(result.getColumnIndex("expense"));
            //String text=("  "+result.getString(result.getColumnIndex("type"))).toUpperCase()+"\n"+result.getString(result.getColumnIndex("flag"))+"Rs:"+result.getString(result.getColumnIndex("expense"))+"\n"+result.getString(result.getColumnIndex("note"));
            array_list.add(result.getString(result.getColumnIndex("type")));
            result.moveToNext();
        }
       // final TransactionsAdapter tadapter = new TransactionsAdapter(frag4.class,type,description,expense);
        return array_list;
    }
    public ArrayList getdetails_expense()
    {
        Log.d("ok","ok");
        ArrayList<Integer> array_list = new ArrayList<Integer>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from details",null);
        result.moveToFirst();
        int i=0;
        while(result.isAfterLast()==false)
        {
            array_list.add(result.getInt(result.getColumnIndex("expense")));
            result.moveToNext();
        }
        return array_list;
    }
    public ArrayList getdetails_note()
    {
        Log.d("ok","ok");
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from details",null);
        result.moveToFirst();
        int i=0;
        while(result.isAfterLast()==false)
        {

            array_list.add(result.getString(result.getColumnIndex("note")));
            result.moveToNext();
        }
        // final TransactionsAdapter tadapter = new TransactionsAdapter(frag4.class,type,description,expense);
        return array_list;
    }
    public ArrayList getdetails_date()
    {
        Log.d("ok","ok");
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from details",null);
        result.moveToFirst();
        int i=0;
        while(result.isAfterLast()==false)
        {
            // type[i++]=result.getString(result.getColumnIndex("type"));
            //description[i++]=result.getString(result.getColumnIndex("note"));
            //expense[i++]=result.getInt(result.getColumnIndex("expense"));
            //String text=("  "+result.getString(result.getColumnIndex("type"))).toUpperCase()+"\n"+result.getString(result.getColumnIndex("flag"))+"Rs:"+result.getString(result.getColumnIndex("expense"))+"\n"+result.getString(result.getColumnIndex("note"));
            array_list.add(result.getString(result.getColumnIndex("date")));
            result.moveToNext();
        }
        // final TransactionsAdapter tadapter = new TransactionsAdapter(frag4.class,type,description,expense);
        return array_list;
    }
    public ArrayList getdetails_flag()
    {
        Log.d("ok","ok");
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from details",null);
        result.moveToFirst();
        int i=0;
        while(result.isAfterLast()==false)
        {
            // type[i++]=result.getString(result.getColumnIndex("type"));
            //description[i++]=result.getString(result.getColumnIndex("note"));
            //expense[i++]=result.getInt(result.getColumnIndex("expense"));
            //String text=("  "+result.getString(result.getColumnIndex("type"))).toUpperCase()+"\n"+result.getString(result.getColumnIndex("flag"))+"Rs:"+result.getString(result.getColumnIndex("expense"))+"\n"+result.getString(result.getColumnIndex("note"));
            array_list.add(result.getString(result.getColumnIndex("flag")));
            result.moveToNext();
        }
        // final TransactionsAdapter tadapter = new TransactionsAdapter(frag4.class,type,description,expense);
        return array_list;
    }
}
