package com.baladika.tgcpokemon.api;


import com.baladika.tgcpokemon.response.PokemonCards;
import com.baladika.tgcpokemon.response.PokemonCardData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("cards")
    Call<PokemonCards> getCard(@Header("Authorization") String authorization,
                               @Query("q") String name,
                               @Query("page") int page,
                               @Query("pageSize") int pageSize);

    @GET("cards/{id}")
    Call<PokemonCardData> getDataCard(@Header("Authorization") String authorization,
                                      @Path("id") String id);
}
