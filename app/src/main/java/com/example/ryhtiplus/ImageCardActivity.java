package com.example.ryhtiplus;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Saukh
 */
public class ImageCardActivity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState
     * @get nimi,kuva ja teksti niiden indeksin perusteella
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_card);
        TextView cardHeader = findViewById(R.id.cardHeader);
        TextView cardText = findViewById(R.id.cardText);
        ImageView imageView = findViewById(R.id.imageView);
        int cardInd = Integer.parseInt(getIntent().getStringExtra(ListActivity.EXTRA));

        cardHeader.setText(CardData.getInstance().getCards().get(cardInd).getCardName());
        cardText.setText(CardData.getInstance().getCards().get(cardInd).getCardText());
        imageView.setImageResource(CardData.getInstance().getCards().get(cardInd).getImage());

    }
}