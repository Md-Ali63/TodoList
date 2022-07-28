package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addbutton;
    private EditText editText;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addbutton = findViewById(R.id.addButtonId);
        editText = findViewById(R.id.editTextId);
        listView = findViewById(R.id.listViewId);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();

            }
        });

        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.activity_main,arrayList);
        listView.setAdapter(arrayAdapter);
        setUpListViewListner();

    }

    private void setUpListViewListner() {

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context,"Item removed",Toast.LENGTH_LONG).show();

                arrayList.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem() {
        String inputText = editText.getText().toString();

        if(!inputText.equals("")){
            arrayAdapter.add(inputText);
            editText.setText("");
        }else{
            Toast.makeText(getApplicationContext(),"Cant enter a empty list", Toast.LENGTH_LONG).show();
        }
    }
}