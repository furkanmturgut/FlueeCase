package com.kunai.flueeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.kunai.flueeapp.adapter.RecyclerViewAdapter;
import com.kunai.flueeapp.model.Album;
import com.kunai.flueeapp.model.Artist;
import com.kunai.flueeapp.model.DiscographyModel;
import com.kunai.flueeapp.retrofit.APIUtils;
import com.kunai.flueeapp.retrofit.RetrofitInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarDetailActivity extends AppCompatActivity {
    CircleImageView imageStar;
    TextView textStarName,textBio;
    String bio,name,photo,star;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<Album> albumArrayList;
    RetrofitInterface retrofitInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_detail);

        initDetail();

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        bio = bundle.getString("bio");
        photo = bundle.getString("photo");
        star = bundle.getString("star");


        Log.e("Name :",""+star);

        textStarName.setText(""+name);
        textBio.setText(""+bio);


        Picasso.with(getApplicationContext()).load(photo).into(imageStar);

        //Photo Control
        if (photo == null){
            imageStar.setImageResource(R.drawable.flueelogo);
        }

        //RecyclerView Album Data Detail!

        retrofitInterface.discographyData(star).enqueue(new Callback<DiscographyModel>() {
            @Override
            public void onResponse(Call<DiscographyModel> call, Response<DiscographyModel> response) {
                albumArrayList =response.body().getAlbum();
             
                //Recycler View Procces
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerViewAdapter = new RecyclerViewAdapter(albumArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DiscographyModel> call, Throwable t) {
                Log.e("Error Album",""+t.getLocalizedMessage());
                Toast.makeText(StarDetailActivity.this, "Hatalı işlem!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initDetail() {
        imageStar = findViewById(R.id.imageStar);
        textBio = findViewById(R.id.textBio);
        textStarName = findViewById(R.id.textStarName);
        recyclerView = findViewById(R.id.recyclerView);
        albumArrayList = new ArrayList<>();
        retrofitInterface = APIUtils.getFluueApp();

    }
}
