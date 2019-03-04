package com.example.mobileproject;

import android.os.AsyncTask;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.net.URL;
import java.util.HashMap;
import java.util.function.Consumer;


public class DownloadBitmap extends AsyncTask<String,Void, Bitmap> {
    private ImageView imageView;
    private Consumer<ImageView> callback;
    private static HashMap<String, Bitmap> cache = new HashMap<>();

    public DownloadBitmap(ImageView imageView, Consumer<ImageView> callback){
        this.imageView = imageView;
        this.callback = callback;
    }

    protected Bitmap doInBackground(String... url){
        try{
            if(cache.containsKey(url[0])) {
                return cache.get(url[0]);
            }
            Bitmap bmp = BitmapFactory.decodeStream(new URL(url[0]).openStream());
            cache.put(url[0], bmp);
            return bmp;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Bitmap result){
        if(result != null) {
            imageView.setImageBitmap(result);
            callback.accept(imageView);
        }
    }
}
