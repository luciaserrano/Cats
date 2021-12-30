package com.example.cats;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cats.clases.Vote;
import com.example.cats.webservices.WebServiceClient;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaVote extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterVote adapter;
    private LinearLayoutManager linearLayoutManager;
    private WebServiceClient webServiceClient;
    private List<Vote> listVote;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_votes);

        setupView();
        initRetrofit();
        lanzarPeticion();

    }
    private void initRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY); // Para utlizar la librería
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor); // Para ver todos los logs

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build()) //mensaje de lost
                .build();
        webServiceClient = retrofit.create(WebServiceClient.class); // Aqui están todos los métodos
    }
    private void setupView(){
        recyclerView = findViewById(R.id.recycler);
        adapter = new AdapterVote(this);
        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    private void lanzarPeticion() {
        Call<List<Vote>> peticion = webServiceClient.getVotes();
        peticion.enqueue(new Callback<List<Vote>>() {
            @Override
            public void onResponse(Call<List<Vote>> call, Response<List<Vote>> response) {
                if(response.isSuccessful()) {
                    int code = response.code();
                    adapter.setLista(response.body());
                }else{
                    Toast.makeText(ListaVote.this, "MAAAAAAAAAAAAAAAAAAAALLLLLLLLL", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Vote>> call, Throwable t) {
                Toast.makeText(ListaVote.this, "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
