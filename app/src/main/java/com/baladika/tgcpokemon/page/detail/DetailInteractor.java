package com.baladika.tgcpokemon.page.detail;



import android.util.Log;

import com.baladika.tgcpokemon.api.ApiService;
import com.baladika.tgcpokemon.module.AppModule;
import com.baladika.tgcpokemon.response.PokemonCardData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailInteractor implements DetailPresenter{

    private DetailView detailView;

    public DetailInteractor(DetailView detailView) {
        this.detailView = detailView;
    }

    @Override
    public void getDataCard(String authorization, String id) {
        ApiService service = AppModule.getRetrofit().create(ApiService.class);
        Call<PokemonCardData> call = service.getDataCard(authorization, id);
        call.enqueue(new Callback<PokemonCardData>() {
            @Override
            public void onResponse(Call<PokemonCardData> call, Response<PokemonCardData> response) {
                Log.d("GetData detail",""+response);

                if (response.isSuccessful()){
                    detailView.onLoad(response.body());
                }
            }

            @Override
            public void onFailure(Call<PokemonCardData> call, Throwable t) {

            }
        });

    }
}
