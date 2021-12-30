package com.example.cats.clases;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.cats.R;
import com.example.cats.webservices.WebServiceClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends AppCompatActivity {
    private Image imagen;
    private ImageView imageView;
    private FloatingActionButton boton;
    private Button like,not_like_it;
    private WebServiceClient webServiceClient;
    private Breeds breeds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.holder_layout);
        imageView = findViewById(R.id.imagenV);
        boton = findViewById(R.id.floatingActionButton);
        like = findViewById(R.id.like);
        not_like_it = findViewById(R.id.not_like_it);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vota(1);
                not_like_it.setEnabled(false);
                like.setEnabled(false);
            }
        });

        not_like_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vota(0);
                not_like_it.setEnabled(false);
                like.setEnabled(false);
            }
        });


        Bundle b = getIntent().getExtras(); //
        if (b != null && b.containsKey("datos")) {
            breeds = b.getParcelable("datos");

            imagen = breeds.getImage();
            if(imagen!=null) {
                Picasso.get().load(imagen.getUrl()).into(imageView);
            }

            String url = breeds.getWikipediaUrl();
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });

            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle(), breeds); //Pasarle los datos Parcelable
            ViewPager2 viewP = findViewById(R.id.viewPage);
            viewP.setAdapter(adapter);

            TabLayout tabLayout = findViewById(R.id.tabLayout);
            TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewP, new TabLayoutMediator.TabConfigurationStrategy() {
                @Override
                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                    if (position == 0) {
                        tab.setText("Information");
                    } else if (position == 1) {
                        tab.setText("Stats");
                    }
                }
            });
            mediator.attach();
        }
    }

    private void vota(int voto){

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY); // Para utlizar la librería
    OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor); // Para ver todos los logs

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(WebServiceClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClientBuilder.build()) //mensaje de lost
            .build();
            webServiceClient = retrofit.create(WebServiceClient.class); // Aqui están todos los métodos

            Image image = breeds.getImage();
            String id = image.getId();

        SendVote sendVote = new SendVote(id,"lucia",voto);
        Call<ResponseVote> call = webServiceClient.enviarVoto(sendVote);
        call.enqueue(new Callback<ResponseVote>() {
            @Override
            public void onResponse(Call<ResponseVote> call, Response<ResponseVote> response) {
                    ResponseVote responseVote = response.body();
                    if(voto==1){
                        Toast.makeText(SecondActivity.this, "Like", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SecondActivity.this, "Dislike", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(Call<ResponseVote> call, Throwable t) {

            }
        });
    }
}
