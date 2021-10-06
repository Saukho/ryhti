package com.example.ryhtiplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_card);
        TextView cardHeader = findViewById(R.id.cardHeader);
        TextView cardText = findViewById(R.id.cardText);
       // ImageView imageView = findViewById(R.id.imageView);
        int cardInd = Integer.parseInt(getIntent().getStringExtra(ListActivity.EXTRA));

        cardHeader.setText(CardData.getInstance().getCards().get(cardInd).getCardText());
        cardText.setText(CardData.getInstance().getCards().get(cardInd).getCardName());
       // cardHeader.setImageResources(CardData.getInstance().getCards().get(cardInd).getImage());

    }
}