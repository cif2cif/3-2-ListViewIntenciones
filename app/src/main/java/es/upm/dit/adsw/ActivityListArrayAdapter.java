package es.upm.dit.adsw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityListArrayAdapter extends AppCompatActivity {
    private static final String TAG = ActivityListArrayAdapter.class.getName();
    private List<String> listItems;
    private int opcionAdded = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        listItems = new ArrayList<String>();
        rellenaLista();
        ListView miListView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        miListView.setAdapter(adapter);
        miListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = "Seleccionado " + parent.getAdapter().getItem(position);
                Log.d(TAG, msg);
                Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = "Opción " + ++opcionAdded;
                Log.d(TAG, newItem);
                adapter.add(newItem);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void rellenaLista() {
        String[] items = {"Llamar por teléfono", "Listar contactos", "Ver contacto", "Editar contacto", "Ver web",
                "Enviar un correo", "Escoger un contacto"};
        for (String item : items) {
            listItems.add(item);
        }
    }
}
