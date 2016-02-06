package onzonsoft.weeraphon.boy.boyrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by M_Boyd on 6/2/2559.
 */
public class MyManage {
    //ประกาศตัวแปร
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String user_Table = "userTABLE";
    public static final String food_Table = "foodTABLE";
    public static final String column_id = "_id";
    public static final String column_User = "User";
    public static final String column_Pass = "Password";
    public static final String column_Name = "Name";
    public static final String column_Food = "Food";
    public static final String column_Price = "Price";
    public static final String column_Source = "Source";


    public MyManage(Context context) {

        //สร้างและเชื่อมต่อฐานข้อมูล
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    } //Constructor

    public long addNewValue(int intTable,
                            String strColumn2,
                            String strColumn3,
                            String strColumn4) {

        ContentValues objContentValues = new ContentValues();
        long longReturn = 0;

        switch (intTable) {
            case 0:
                objContentValues.put(column_User,strColumn2);
                objContentValues.put(column_Pass,strColumn3);
                objContentValues.put(column_Name,strColumn4);
                writeSqLiteDatabase.insert(user_Table, null, objContentValues);

                break;
            case 1:
                objContentValues.put(column_Food,strColumn2);
                objContentValues.put(column_Price,strColumn3);
                objContentValues.put(column_Source,strColumn4);
                writeSqLiteDatabase.insert(food_Table, null, objContentValues);

                break;
        }   //Switch


        return longReturn;
    }


}   //คลาสหลัก

