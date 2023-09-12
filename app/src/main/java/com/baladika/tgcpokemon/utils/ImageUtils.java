package com.baladika.tgcpokemon.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageUtils {

    public static void saveImageToFile(Context context, String cardImgURL, String fileName) {
        Glide.with(context)
                .asFile()
                .load(cardImgURL)
                .into(new SimpleTarget<File>() {
                    @Override
                    public void onResourceReady(@NonNull File resource, @Nullable Transition<? super File> transition) {
                        saveImageToStorage(context, resource, fileName);
                    }
                });
    }


    private static void saveImageToStorage(Context context, File imageFile, String fileName) {
        try {
            File externalDir = Environment.getExternalStorageDirectory();
            String appDirectoryName = "MyPokemonGalleryCard";
            File appDirectory = new File(externalDir, appDirectoryName);

            if (!appDirectory.exists()) {
                appDirectory.mkdirs();
            }

            File destinationFile = new File(appDirectory, fileName + ".jpg");

            // Load gambar ke dalam bitmap
            Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());

            // Kompresi gambar dengan kualitas 80%
            FileOutputStream fos = new FileOutputStream(destinationFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos);
            fos.flush();
            fos.close();

            Toast.makeText(context, "Berhasil menyimpan gambar "+appDirectory, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Gagal menyimpan gambar", Toast.LENGTH_SHORT).show();
        }
    }

}




