package com.example.mobilenative;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Adapter2 extends ArrayAdapter<Model>{

    private ArrayList<Model> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtMessage;
        TextView txtImg;
        ImageView img;
    }

    public Adapter2(ArrayList<Model> data, Context context) {
        super(context, R.layout.content2, data);
        this.dataSet = data;
        this.mContext=context;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Model model = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.content2, parent, false);
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

        viewHolder.txtName.setText(model.getName());
        viewHolder.txtMessage.setText(model.getMessage());
        viewHolder.img.setImageResource(model.getImg());
//        viewHolder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext(), R.style.dialog);
//                View diaView1 = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.activity_dialog, null);
//                TextView textLorem;
//                ImageView ImageProfile;
////                textLorem = (TextView) diaView1.findViewById(R.id.text_lorem);
//                ImageProfile = (ImageView) diaView1.findViewById(R.id.pop_up_image);
////                textLorem.setText(model.getMessage());
//                ImageProfile.setImageResource(model.getImg());
//                builder.setView(diaView1);
//                builder.setCancelable(true);
//                builder.show();
//            }
//        });
        viewHolder.img.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
