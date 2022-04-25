package com.kunai.flueeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kunai.flueeapp.model.Artist;
import com.kunai.flueeapp.model.SearchModelFluee;
import com.kunai.flueeapp.retrofit.APIUtils;
import com.kunai.flueeapp.retrofit.RetrofitBuilder;
import com.kunai.flueeapp.retrofit.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    EditText editTextQuery;
    Button buttonSearch;
    RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initMethod();

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myStar = editTextQuery.getText().toString().trim();

                retrofitInterface.myData(myStar).enqueue(new Callback<SearchModelFluee>() {
                    @Override
                    public void onResponse(Call<SearchModelFluee> call, Response<SearchModelFluee> response) {
                       List<Artist> artistList = response.body().getArtists();

                       if(artistList != null){
                           for (Artist artist : artistList){
                               String bio = artist.getStrBiographyEN();
                               String named = artist.getStrArtist();
                               String image = artist.getStrArtistThumb();

                               Log.e("Demo",""+bio);

                               Intent intent = new Intent(HomeActivity.this,StarDetailActivity.class);
                               intent.putExtra("star",myStar);
                               intent.putExtra("name",named);
                               intent.putExtra("bio",bio);
                               intent.putExtra("photo",image);
                               startActivity(intent);
                           }

                       }else {

                           Log.e("Star Error","Null starList");
                           Toast.makeText(HomeActivity.this, "Geçerli bir sanatçı giriniz.", Toast.LENGTH_SHORT).show();
                       }
                    /*
                       for (Artist aL : artistList){
                           String demo = aL.getStrBiographyEN();
                           Log.e("Demo",""+demo);
                       }

                     */
                    }

                    @Override
                    public void onFailure(Call<SearchModelFluee> call, Throwable t) {

                    }
                });
            }
        });


    }

    private void initMethod(){
        editTextQuery = findViewById(R.id.editTextQuery);
        buttonSearch = findViewById(R.id.buttonSearch);

        retrofitInterface = APIUtils.getFluueApp();
    }
}