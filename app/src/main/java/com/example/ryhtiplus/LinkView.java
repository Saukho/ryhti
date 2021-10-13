package com.example.ryhtiplus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class LinkView extends AppCompatActivity implements View.OnClickListener {
    private Button linkView;
    private Button linkView1;
    private Button linkView2;

    /**
     * @author roman, pavel, mihail, sami
     * @param savedInstanceState
     */
    //napit linkkeihin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_view);

        linkView = (Button) findViewById(R.id.linkView);
        linkView.setOnClickListener(this);
        linkView1 = (Button) findViewById(R.id.linkView1);
        linkView1.setOnClickListener(this);
        linkView2 = (Button) findViewById(R.id.linkView2);
        linkView2.setOnClickListener(this);

    }

    /**
     * @set
     * @param url
     */
    //linkit sivuistoille
    public void clicked_btn(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    /**
     *
     * @param view
     */
            public void onClick (View view){
                switch (view.getId()) {
                    case R.id.linkView:
                        clicked_btn("https://askelterveyteen.com/nain-korjaat-ryhtiasi-liikkumalla/");
                        break;
                    case R.id.linkView1:
                        clicked_btn("https://kotiliesi.fi/terveys/hyvinvointi/ryhti-paremmaksi-pienilla-teoilla-ota-3-liikkeen-minitreeni-osaksi-aamurutiinejasi/");
                        break;
                    case R.id.linkView2:
                        clicked_btn("https://www.youtube.com/watch?v=flHbOg8ayoI");
                        break;
                }
            }

    }