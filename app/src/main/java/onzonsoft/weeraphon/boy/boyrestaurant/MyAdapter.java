package onzonsoft.weeraphon.boy.boyrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by M_Boyd on 7/2/2559.
 */
public class MyAdapter extends BaseAdapter{

    private Context objContext;
    private String[] foodStrings,priceStrings,sourceStrings;

    public MyAdapter(Context objContext, String[] foodStrings, String[] priceStrings, String[] sourceStrings) {
        this.objContext = objContext;
        this.foodStrings = foodStrings;
        this.priceStrings = priceStrings;
        this.sourceStrings = sourceStrings;
    }   //Constructor


    @Override
    public int getCount() {
        return foodStrings.length; //นับรายการเอง
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);   //เปิด Service
        View objView1 = objLayoutInflater.inflate(R.layout.food_listview, viewGroup, false);

        TextView foodTextView = (TextView) objView1.findViewById(R.id.textView3);
        foodTextView.setText(foodStrings[i]);

        TextView priceTextView = (TextView) objView1.findViewById(R.id.textView4);
        priceTextView.setText(priceStrings[i]);

        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imageView);
        Picasso.with(objContext).load(sourceStrings[i]).resize(120,120).into(iconImageView);

        return objView1;
    }
}   //main class
