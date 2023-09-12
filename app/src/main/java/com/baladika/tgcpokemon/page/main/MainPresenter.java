package com.baladika.tgcpokemon.page.main;

public interface MainPresenter {
    void getPokemonCards(String authorization, String name, int page, int pageSize);
}
