package com.example.cats.webservices;

import com.example.cats.clases.Breeds;
import com.example.cats.clases.ResponseVote;
import com.example.cats.clases.SendVote;
import com.example.cats.clases.Vote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface WebServiceClient {
    String BASE_URL = "https://api.thecatapi.com/v1/";
        String TOKE ="x-api-key: ef638324-19b1-468e-95f0-8922f0e42d69";

    @Headers(TOKE)
    @GET("breeds")
    Call<List<Breeds>> sacarRaza();

    @Headers({TOKE, "Content-Type: application/json"})
    @POST("votes")
    Call<ResponseVote> enviarVoto(@Body SendVote sendVote); //A que clase se lo quiero enviar

    @Headers({TOKE, "Content-Type: application/json"})
    @POST("votes")
    Call<List<Vote>> getVotes(); //A que clase se lo quiero enviar

}
