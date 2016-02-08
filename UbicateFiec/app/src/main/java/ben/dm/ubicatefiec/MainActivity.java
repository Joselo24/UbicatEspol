package ben.dm.ubicatefiec;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.widget.ProgressBar;



public class MainActivity   extends Activity {

    private ProgressBar prbWelcome;
    public static final int segundos = 6;
    public static final int milisegundos = segundos * 1000;
    public static final int delay = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        prbWelcome=(ProgressBar)findViewById(R.id.prbLoading);

        prbWelcome.setMax(segundos - delay);
        new CountDownTimer(milisegundos, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {
                prbWelcome.setProgress((int) ((milisegundos - millisUntilFinished) / 1000));

            }
            @Override
            public void onFinish() {
                Intent i = new Intent(MainActivity.this, EntradaMenu.class);
                startActivity(i);
                finish();
            }
        }.start();
    }

}
