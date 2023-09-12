package com.baladika.tgcpokemon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baladika.tgcpokemon.base.BaseParam;
import com.baladika.tgcpokemon.page.detail.DetailInteractor;
import com.baladika.tgcpokemon.page.detail.DetailPresenter;
import com.baladika.tgcpokemon.page.detail.DetailView;
import com.baladika.tgcpokemon.response.PokemonCardData;
import com.baladika.tgcpokemon.utils.ImageUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailView {

    private String idCard;
    private String cardImgURL;

    private TextView nameCard;
    private TextView typeCard;
    private ImageView detailImage;
    private Button btnDownload;

    private DetailPresenter detailPresenter;
    private ProgressDialog progressDialog;

    private static final int REQUEST_STORAGE_PERMISSION = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        idCard = intent.getStringExtra(BaseParam.ID_CARD);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            } else {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_STORAGE_PERMISSION);
            }
        }

        nameCard =findViewById(R.id.detail_name);
        typeCard =findViewById(R.id.detail_type);
        detailImage =findViewById(R.id.detail_image);
        btnDownload =findViewById(R.id.btn_detail_download);

        detailPresenter = new DetailInteractor(this);

        progressDialog = new ProgressDialog(DetailActivity.this);
        progressDialog.setMessage("Loading..");

        progressDialog.show();


        detailPresenter.getDataCard(BaseParam.API_KEY,idCard);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUtils.saveImageToFile(DetailActivity.this,cardImgURL, nameCard.getText().toString());
            }
        });

    }

    @Override
    public void onLoad(PokemonCardData cardData) {
        List<String> types = cardData.getDataCardDetail().getTypes();
        String typesString = TextUtils.join(", ", types);

        nameCard.setText(cardData.getDataCardDetail().getName());
        typeCard.setText(typesString);
        cardImgURL = cardData.getDataCardDetail().getImages().getLarge();

        Glide.with(DetailActivity.this)
                .load(cardImgURL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(detailImage);

        progressDialog.dismiss();
    }



}