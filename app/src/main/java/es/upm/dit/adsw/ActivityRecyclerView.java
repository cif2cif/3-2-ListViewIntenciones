package es.upm.dit.adsw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ActivityRecyclerView extends AppCompatActivity {
    private static final String TAG = ActivityRecyclerView.class.getName();
    private List<Pais> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclycler_view);
        listItems = new ArrayList<Pais>();
        rellenaLista();
        final RecyclerView recView = (RecyclerView) findViewById(R.id.recView);
        final MiAdaptadorRV miAdaptadorRV = new MiAdaptadorRV(listItems);

        recView.setAdapter(miAdaptadorRV);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // Probar a poner este layout
        //recView.setLayoutManager(new GridLayoutManager(this, 2));

        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Shuffle");
                miAdaptadorRV.shuffle();
                miAdaptadorRV.notifyDataSetChanged();
            }
        });
    }


    private void rellenaLista() {
        listItems.add(new Pais("España", R.drawable.espanna, 504645, 34));
        listItems.add(new Pais("Portugal", R.drawable.portugal, 92391, 351));
        listItems.add(new Pais("Francia", R.drawable.francia, 675417, 33));
        listItems.add(new Pais("Alemania", R.drawable.alemania, 357168, 49));
        listItems.add(new Pais("Italia", R.drawable.italia, 301338, 39));
        listItems.add(new Pais("Grecia", R.drawable.grecia, 131990, 30));
        listItems.add(new Pais("Reino Unido", R.drawable.reinounido, 243610, 44));
    }
}
