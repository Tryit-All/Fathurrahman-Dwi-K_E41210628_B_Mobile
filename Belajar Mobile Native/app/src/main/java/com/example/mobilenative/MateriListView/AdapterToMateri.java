package com.example.mobilenative.MateriListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;


import com.example.mobilenative.R;

import java.util.ArrayList;


public class AdapterToMateri extends ArrayAdapter<ModelTomateri>{

    private ArrayList<ModelTomateri> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtMessage;
        TextView txtImg;
        ImageView img;
    }

    public AdapterToMateri(ArrayList<ModelTomateri> data, Context context) {
        super(context, R.layout.content, data);
        this.dataSet = data;
        this.mContext=context;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ModelTomateri model = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.content, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtMessage = (TextView) convertView.findViewById(R.id.message);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
//        lastPosition = position;

        viewHolder.txtName.setText(model.getNames());
        viewHolder.txtMessage.setText(model.getMessages());
        viewHolder.img.setImageResource(model.getImgs());
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext(), R.style.dialog);
                View diaView1 = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.activity_dialog, null);
                TextView textLorem;
                ImageView ImageProfile;
//                textLorem = (TextView) diaView1.findViewById(R.id.text_lorem);
                ImageProfile = (ImageView) diaView1.findViewById(R.id.pop_up_image);
//                textLorem.setText(model.getMessage());
                ImageProfile.setImageResource(model.getImgs());
                builder.setView(diaView1);
                builder.setCancelable(true);
                builder.show();
            }
        });
        viewHolder.img.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
