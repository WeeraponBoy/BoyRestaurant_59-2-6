package onzonsoft.weeraphon.boy.boyrestaurant;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MyManage objMyManage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Request Database
        objMyManage = new MyManage(this);

        //ทดสอบเพิ่มข้อมูล
       // testAddValue();

        //Clean data
        cleanData();


    }   //Main Method

    private void cleanData() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE,null);
        objSqLiteDatabase.delete(MyManage.food_Table, null, null);
        objSqLiteDatabase.delete(MyManage.user_Table, null, null);
    }   //Clean data

    private void testAddValue() {

        for (int i = 0; i <= 1; i++) {
            objMyManage.addNewValue(i, "test1", "test2", "test3");
        }   //for

    }   //ทดสอบเพิ่มข้อมูล

}   //คลาสหลัก
