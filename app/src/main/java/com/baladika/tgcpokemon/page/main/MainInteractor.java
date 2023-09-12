package com.baladika.tgcpokemon.page.main;

import android.util.Log;

import com.baladika.tgcpokemon.api.ApiService;
import com.baladika.tgcpokemon.module.AppModule;
import com.baladika.tgcpokemon.response.PokemonCards;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractor implements MainPresenter{


    private MainView mainView;

    public MainInteractor(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void getPokemonCards(String authorization, String name, int page, int pageSize) {
        ApiService service = AppModule.getRetrofit().create(ApiService.class);
        Call<PokemonCards> call =service.getCard(authorization, name, page, pageSize);
        call.enqueue(new Callback<PokemonCards>() {
            @Override
            public void onResponse(Call<PokemonCards> call, Response<PokemonCards> response) {
                Log.d("GetData",""+response);

               if (response.isSuccessful()){
                   mainView.onLoad(response.body().getDataCard());
                   int totalCount = response.body().getTotalCount();
                   mainView.onTotalCount(totalCount);
               }
            }

            @Override
            public void onFailure(Call<PokemonCards> call, Throwable t) {

            }
        });

    }

}
