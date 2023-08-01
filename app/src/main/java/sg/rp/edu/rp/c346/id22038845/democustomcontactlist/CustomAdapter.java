package sg.rp.edu.rp.c346.id22038845.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;

    public CustomAdapter(Context context, int resource, ArrayList<Contact> objects){
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        contactList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent, false);

        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvNum = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);

        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode());
        tvNum.setText(currentItem.getPhoneNum() + "");

        //https://www.pexels.com/photo/photo-of-man-skateboarding-2118464/
        String male = "https://images.pexels.com/photos/2118464/pexels-photo-2118464.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2";
        //https://www.pexels.com/photo/women-s-white-framed-sunglasses-2690323/
        String female = "https://images.pexels.com/photos/2690323/pexels-photo-2690323.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2";

        if(currentItem.getGender()=='M'){
            Picasso.with(parent_context).load(male).resize(300,300).into(ivGender);
            //^picasso if use in mainactivity it is: this instead of parent_context.
            //ivGender.setImageResource(R.drawable.male);
        }else{
            Picasso.with(parent_context).load(female).resize(300,300).into(ivGender);
            //ivGender.setImageResource(R.drawable.female);
        }

        return rowView;
    }
}
