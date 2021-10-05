package com.example.ryhtiplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ListView cardList;

    private ArrayList<String> cards;
    public static final String EXTRA = "cardInd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        cardList = findViewById(R.id.cardHeader);

        cardList.setAdapter(new ArrayAdapter<Card>(
                this,
                R.layout.activity_image_card,
                CardData.getInstance().getCards()
        ));

        cardList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(ListActivity.this, ImageCardActivity.class);
                nextActivity.putExtra(EXTRA, ""+i);
                startActivity(nextActivity);

            }
        });
    }
}