package ben.dm.ubicatefiec;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class EntradaMenu extends Activity {
    private Button btnFacultad, btnAulas, btnCreditos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_menu);

        btnAulas=(Button)findViewById(R.id.btnBuscarAulas);
        btnFacultad=(Button)findViewById(R.id.btnBuscarF);
        btnCreditos=(Button)findViewById(R.id.btnCreditos);

        btnAulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EntradaMenu.this, BuscarAulas.class);
                startActivity(i);
            }
        });
        btnFacultad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EntradaMenu.this, BuscarFacultad.class);
                startActivity(i);
            }
        });
        btnCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EntradaMenu.this, Credito.class);
                startActivity(i);
            }
        });
    }



}
