package com.example.mansopresk01.imageproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.mansopresk01.imageproject.Model.DocumentRspnc;
import com.example.mansopresk01.imageproject.R;
import com.example.mansopresk01.imageproject.adapters.DocumentAdapter;
import com.example.mansopresk01.imageproject.helpers.ItemClickSupport;
import com.example.mansopresk01.imageproject.Model.RestInterface;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RecyclerDocActivity extends AppCompatActivity {

    String url = "https://s3.ap-south-1.amazonaws.com";
    RecyclerView myRecyclerView;
    static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_doc);
        setTitle("Repository");
        myRecyclerView = (RecyclerView) findViewById(R.id.myrecyclerview);

        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(url).build();

        RestInterface restInterface = adapter.create(RestInterface.class);

        restInterface.getDocReport(new Callback<DocumentRspnc>() {

            @Override
            public void success(DocumentRspnc documentRspnc, Response response) {
                Toast.makeText(RecyclerDocActivity.this, "success", Toast.LENGTH_LONG).show();

                //DocumentAdapter recylerAdapter=new DocumentAdapter(documentRspnc.getCategoriesList(),RecyclerDocActivity.this);
                DocumentAdapter recylerAdapter = new DocumentAdapter(documentRspnc.getCategoriesList(), RecyclerDocActivity.this);
                myRecyclerView.setAdapter(recylerAdapter);
                LinearLayoutManager llm = new LinearLayoutManager(RecyclerDocActivity.this);
                myRecyclerView.setLayoutManager(llm);
                myRecyclerView.setHasFixedSize(true);

                ItemClickSupport.addTo(myRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                        Intent i = new Intent(RecyclerDocActivity.this, CardActivity.class);
                        startActivity(i);

                    }
                });

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(RecyclerDocActivity.this, "Data Retrieving failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}