package com.baladika.tgcpokemon.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PokemonCardData {
    private int page;
    private int pageSize;
    private int count;
    private int totalCount;


    @SerializedName("data")
    private Data DataCardDetail;

    public Data getDataCardDetail() {
        return DataCardDetail;
    }

    public void setDataCardDetail(Data dataCardDetail) {
        DataCardDetail = dataCardDetail;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


}
