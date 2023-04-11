package king.tran.hinhnenphongthuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ramotion.circlemenu.CircleMenuView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         CircleMenuView menu = findViewById(R.id.circle_menu);
        menu.setEventListener(new CircleMenuView.EventListener(){
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D","onMenuOpenAnimationStart");
            }
            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D","onMenuOpenAnimationEnd");
            }
            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D","onMenuCloseAnimationStart");
            }
            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D","onMenuCloseAnimationEnd");
            }


            // Click Button
            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {

            }
            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                if(index==0){
                    startActivity(new Intent(MainActivity.this,MenhKimActivity.class));

                } if(index==1){
                    startActivity(new Intent(MainActivity.this,MenhThoActivity.class));

                } if(index==2){
                    startActivity(new Intent(MainActivity.this,MenhThuyActivity.class));

                } if(index==3){
                    startActivity(new Intent(MainActivity.this,MenhMocActivity.class));

                } if(index==4){
                   startActivity(new Intent(MainActivity.this,MenhHoaActivity.class));
                }

            }
            @Override
            public boolean onButtonLongClick(@NonNull CircleMenuView view, int buttonIndex) {
                // Log.d("D","onButtonLongClick|index: "+buttonIndex);
                return false;

            }
            @Override
            public void onButtonLongClickAnimationStart(@NonNull CircleMenuView view, int buttonIndex) {
                // Log.d("D","onButtonLongClickAnimationStart|index: "+buttonIndex);


            }
            @Override
            public void onButtonLongClickAnimationEnd(@NonNull CircleMenuView view, int index) {


            }
        });

    }
}