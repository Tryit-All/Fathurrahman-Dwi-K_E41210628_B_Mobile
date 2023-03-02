package com.example.recycle_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class list_view extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayAdapter<CharSequence> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_view, container, false);
        listView = view.findViewById(R.id.listView);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.negara, android.R.layout.simple_expandable_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        listView = (ListView) findViewById(R.id.listView);
//        adapter = ArrayAdapter.createFromResource(this, R.array.negara, android.R.layout.simple_expandable_list_item_1);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(this);
    }

//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.negara, android.R.layout.simple_list_item_1);
//        setListAdapter(adapter);
//        getListView().setOnItemClickListener(this);
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_LONG).show();
        String[] mess = getResources().getStringArray(R.array.negara);
        Toast.makeText(getActivity(), "Negara : " + mess[position], Toast.LENGTH_SHORT).show();
    }


//    @Override
//    public boolean onCreatOptionMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.list, menu);
//        return true;
//    }

}