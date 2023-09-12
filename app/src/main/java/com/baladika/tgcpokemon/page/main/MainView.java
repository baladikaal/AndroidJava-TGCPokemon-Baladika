package com.baladika.tgcpokemon.page.main;

import com.baladika.tgcpokemon.response.Data;

import java.util.List;

public interface MainView {
    void onLoad(List<Data> cardDataList);
    void onTotalCount(int totalCount);
}
