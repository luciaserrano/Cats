package com.example.cats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.cats.clases.Breeds;
import com.example.cats.webservices.WebServiceClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterMain adapter;
    private StaggeredGridLayoutManager layoutManager;
    private WebServiceClient webServiceClient;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

        FloatingActionButton list_votesB = findViewById(R.id.list_votesB);

        list_votesB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ListaVote.class);
                startActivity(i);
            }
        });

        setupView();
        initRetrofit(); //generar la clase retrofit
        lanzarPerticion(); //LLamar al metodo cliente
    }
    private void setupView() {
        recyclerView = findViewById(R.id.recycler);
        adapter = new AdapterMain(this);
        layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout= findViewById(R.id.swiperefreshlayout); //
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Realiza este código cuando hace el gesto de actualizar
//                lanzarPerticion();
                simularCarga();
            }
        });
    }
    private void simularCarga(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 6000);
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

    private void lanzarPerticion() {

        Call<List<Breeds>> peticion = webServiceClient.sacarRaza();
        peticion.enqueue(new Callback<List<Breeds>>() {
            @Override
            public void onResponse(Call<List<Breeds>> call, Response<List<Breeds>> response) {

                swipeRefreshLayout.setRefreshing(false);// para que pare de refrescar
                swipeRefreshLayout.setColorSchemeResources(R.color.design_default_color_primary_variant,R.color.design_default_color_secondary_variant);

                if (response.isSuccessful()) {
                    int code = response.code();

                    List<Breeds> listado = response.body();
                    adapter.setLista(listado);
                    //sacar lista de razas

                } else {
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Breeds>> call, Throwable t) {
                Log.d("RETROFIT", "Error: " + t.getMessage());
            }
        });
    }
    private void showErrorMessage() {
        Toast.makeText(this, "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        MenuItem search = menu.findItem(R.id.item_search); //Saca el item del menu
        MenuItem searchItem = menu.findItem(R.id.item_search); //Se saca el menu item
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { //Cuando se le da el boton a buscar
                adapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {  //Cada vez que el usuario escriba
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}