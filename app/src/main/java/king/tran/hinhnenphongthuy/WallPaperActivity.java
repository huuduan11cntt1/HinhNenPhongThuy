package king.tran.hinhnenphongthuy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.IOException;

public class WallPaperActivity extends AppCompatActivity {

    private ImageView fullImage;
    private Button apply;
    private static  final  String TAG = "PDF_ADAPTER_TAG_G";
    DisplayMetrics displayMetrics;
    int width, height;
    Bitmap bitmap,bitmap2;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_paper);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-5382625544778444/7260676170");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        fullImage= findViewById(R.id.fullImage);
        apply= findViewById(R.id.apply);
        Glide.with(this).load(getIntent().getStringExtra("images")).into(fullImage);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setBackground();
               Toast.makeText(WallPaperActivity.this,"Cài đặt hoàn tất !!!",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setBackground(){
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
        bitmap = ((BitmapDrawable)fullImage.getDrawable()).getBitmap();
        bitmap2 = Bitmap.createScaledBitmap(bitmap,width,height,true);


        WallpaperManager manager = WallpaperManager.getInstance(this);
        manager.setWallpaperOffsetSteps(1,1);
        manager.suggestDesiredDimensions(width,height);
       // bitmap2 = Bitmap.createScaledBitmap(bitmap,manager.getDesiredMinimumWidth(),manager.getDesiredMinimumHeight(),true);
        try {

            manager.setBitmap(bitmap2);
           /* if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N )  {
                manager.setBitmap(bitmap2,null,true,WallpaperManager.FLAG_SYSTEM);

            }*/

        } catch (IOException e) {
            Toast.makeText(this,"Erro"+e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

}