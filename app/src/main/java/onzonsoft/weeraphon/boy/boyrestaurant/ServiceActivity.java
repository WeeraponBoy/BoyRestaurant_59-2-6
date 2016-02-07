package onzonsoft.weeraphon.boy.boyrestaurant;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    private TextView shownameTextView;
    private Spinner deskSpinner;
    private ListView foodListView;
    private String officerString,deskString, foodString,amountString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //bind widjet
        bindWidjet();

        //Show View
        showView();

        //Show Desk
        showDesk();

        //Show Food
        showMenuFood();


    }//Main Method

    private void showMenuFood() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM " + MyManage.food_TABLE, null);

        int intCount = objCursor.getCount();
        String[] foodStrings = new String[intCount];
        String[] priceStrings = new String[intCount];
        String[] sourceStrings = new String[intCount];

        objCursor.moveToFirst();
        for (int i = 0; i < intCount; i++) {
            foodStrings[i] = objCursor.getString(objCursor.getColumnIndex(MyManage.column_food));
            priceStrings[i] = objCursor.getString(objCursor.getColumnIndex(MyManage.column_price));
            sourceStrings[i] = objCursor.getString(objCursor.getColumnIndex(MyManage.column_source));


            objCursor.moveToNext();

        }
        objCursor.close();

        MyAdapter objMyAdapter = new MyAdapter(ServiceActivity.this,foodStrings,priceStrings,sourceStrings);
        foodListView.setAdapter(objMyAdapter);

    }

    private void showDesk() {
        final String[] showDeskStrings = {"โต๊ะที่ 1","โต๊ะที่ 2","โต๊ะที่ 3","โต๊ะที่ 4",
                "โต๊ะที่ 5","โต๊ะที่ 6","โต๊ะที่ 7","โต๊ะที่ 8","โต๊ะที่ 9","โต๊ะที่ 10"};
        ArrayAdapter<String> deskAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, showDeskStrings);
        deskSpinner.setAdapter(deskAdapter);
        deskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                deskString = showDeskStrings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                deskString = showDeskStrings[0];
            }
        });
    }

    private void showView() {

        //รับค่าจาก Intent
        officerString = getIntent().getStringExtra("Name");
        shownameTextView.setText(officerString);

    }

    private void bindWidjet() {

        shownameTextView = (TextView) findViewById(R.id.textView2);
        deskSpinner = (Spinner) findViewById(R.id.spinner);
        foodListView = (ListView) findViewById(R.id.listView);

    }

}   //Main Class
