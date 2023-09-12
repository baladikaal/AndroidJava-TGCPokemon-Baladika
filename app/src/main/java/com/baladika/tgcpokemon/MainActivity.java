package com.baladika.tgcpokemon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import  androidx.appcompat.widget.SearchView;
import android.widget.TextView;

import com.baladika.tgcpokemon.base.BaseParam;
import com.baladika.tgcpokemon.component.CardAdapter;
import com.baladika.tgcpokemon.page.main.MainInteractor;
import com.baladika.tgcpokemon.page.main.MainPresenter;
import com.baladika.tgcpokemon.page.main.MainView;
import com.baladika.tgcpokemon.response.Data;
import com.baladika.tgcpokemon.response.PokemonCards;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private int page= 1;
    private int pageSize = 20;
    private int getTotalCount;
    private String name;
    private CardAdapter adapter;
    private RecyclerView recyclerView;
    private MainPresenter mainPresenter;
    private ProgressDialog progressDialog;
    private Button btnNext;
    private Button btnBack;
    private TextView pageNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBack =  findViewById(R.id.btnBack);
        btnNext =  findViewById(R.id.btnNext);
        pageNow =  findViewById(R.id.pageNow);
        recyclerView = findViewById(R.id.rvCardList);

        mainPresenter = new MainInteractor(this);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading..");

        progressDialog.show();

        mainPresenter.getPokemonCards(BaseParam.API_KEY, name, page, pageSize);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (page <= getTotalCount){
                    progressDialog.show();
                    page += 1;
                    pageSize += 20;
                    pageNow.setText(String.valueOf(page));
                    mainPresenter.getPokemonCards(BaseParam.API_KEY, name, page, pageSize);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (page > 1) {
                    progressDialog.show();
                    page -= 1;
                    pageSize -= 20;
                    pageNow.setText(String.valueOf(page));
                    mainPresenter.getPokemonCards(BaseParam.API_KEY, name, page, pageSize);
                }
            }
        });


    }

    private void getAdapter(List<Data> cardDataList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CardAdapter(cardDataList, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onLoad(List<Data> cardDataList) {

        getAdapter(cardDataList);
        progressDialog.dismiss();
    }

    @Override
    public void onTotalCount(int totalCount) {
        getTotalCount = totalCount;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem menuItem= menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Cari nama card...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    name = null;
                } else {
                    progressDialog.show();
                    name = BaseParam.NAME + newText;
                }
                mainPresenter.getPokemonCards(BaseParam.API_KEY, name, page, pageSize);


                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}