package com.maria.loginsignup.loginsignup;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter implements OnClickListener {


    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    ListModel tempValues=null;
    int i=0;


    public CustomAdapter(Activity a, ArrayList d,Resources resLocal) {


        activity = a;
        data=d;
        res = resLocal;


        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    public int getCount() {

        if(data.size()<=0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{

        public TextView text;
        public TextView text1;
        public TextView textWide;
        public ImageView image;

    }


    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){

            vi = inflater.inflate(R.layout.car_item ,null);

            holder = new ViewHolder();
            holder.text = (TextView) vi.findViewById(R.id.tvModel);
            holder.text1=(TextView)vi.findViewById(R.id.tvYear);
            holder.image=(ImageView)vi.findViewById(R.id.imgLogo);

            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

        if(data.size()<=0)
        {
            holder.text.setText("No Data");

        }
        else
        {

            tempValues=null;
            tempValues = ( ListModel ) data.get( position );



            holder.text.setText( tempValues.getModel() );
            holder.text1.setText( tempValues.getYear() );
            holder.image.setImageResource(
                    res.getIdentifier(
                            "com.example.Carwatch:drawable/"+tempValues.getImage()
                            ,null,null));



            vi.setOnClickListener(new OnItemClickListener( position ));
        }
        return vi;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }


    private class OnItemClickListener  implements OnClickListener{
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {


            CarListActivity sct = (CarListActivity)activity;

            sct.onItemClick(mPosition);
        }
    }
}
