package com.example.ryhtiplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    /**
     * @author roman, pavel, mihail, sami
     * @param savedInstanceState
     */

    // napit linkkeihin
    // harjoituskorttien arraylist tallennus

    private ListView listViewCard;

    private ArrayList<String> cards;

    public static final String EXTRA = "cardInd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listViewCard = findViewById(R.id.listViewCards);

        listViewCard.setAdapter(new ArrayAdapter<Card>(
                this,
                R.layout.layout_listview_info,
                CardData.getInstance().getCards()
        ));

        listViewCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(ListActivity.this, ImageCardActivity.class);
                nextActivity.putExtra(EXTRA, ""+i);
                startActivity(nextActivity);

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
