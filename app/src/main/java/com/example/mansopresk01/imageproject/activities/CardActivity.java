package com.example.mansopresk01.imageproject.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mansopresk01.imageproject.Model.DocumentRspnc;
import com.example.mansopresk01.imageproject.Model.PanCardRspnc;
import com.example.mansopresk01.imageproject.Model.RestInterface;
import com.example.mansopresk01.imageproject.R;
import com.example.mansopresk01.imageproject.adapters.CardAdapter;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CardActivity extends AppCompatActivity {
    String url = "https://s3.ap-south-1.amazonaws.com";
    CardAdapter cardAdapter;
    RecyclerView cardRcy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_doc);
        setTitle("My Documents");
        cardRcy = (RecyclerView) findViewById(R.id.myrecyclerview);
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(url).build();
        RestInterface restInterface = adapter.create(RestInterface.class);
        restInterface.getCardReport(new Callback<PanCardRspnc>() {

            @Override
            public void success(PanCardRspnc documentRspnc, Response response) {
                Toast.makeText(CardActivity.this, "success", Toast.LENGTH_LONG).show();

                CardAdapter cardAdapter=new CardAdapter(documentRspnc.getDocuments(),CardActivity.this);
                cardRcy.setAdapter(cardAdapter);
                LinearLayoutManager llm = new LinearLayoutManager(CardActivity.this);
                cardRcy.setLayoutManager(llm);
                cardRcy.setHasFixedSize(true);
            }

            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(CardActivity.this, "Data Retrieving failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
