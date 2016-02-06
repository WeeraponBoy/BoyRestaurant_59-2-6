package onzonsoft.weeraphon.boy.boyrestaurant;

import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;

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

        //Syn JSON to SQLite
        synJSONtoSQLite();


    }   //Main Method

    private void synJSONtoSQLite() {

        //เปลี่ยน Policy ให้เชื่อมต่อได้(เพราะเป็นนโยบายของ Google)
        StrictMode.ThreadPolicy myThreadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(myThreadPolicy);

        int intTable = 1;
        String tag = "Restaurant";

        while (intTable<=2) {

            //1. การสร้าง Input Stream(การโหลดไป ประมวลผลไป)
            InputStream objInputStream = null;
            String strURLuser = "http://swiftcodingthai.com/6feb/php_get_data_boy.php";
            String strURLfood = "http://swiftcodingthai.com/6feb/php_get_data_food.php";

            try {

            } catch (Exception e) {
                Log.d(tag, "InputStream ==>" + e.toString());
            }

            //2. ก่ารสร้าง JSON String(เอาส่งที่โหลดมาเปลี่ยนเป็นสตริง)

            //3. การ Update SQLite(เอาสตริงที่โหลดมาเปลี่ยนเป็น Slqite)

            intTable += 1;

        }   //while

    }   //Syn JSON to SQLite

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
