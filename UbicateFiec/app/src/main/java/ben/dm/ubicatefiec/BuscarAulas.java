package ben.dm.ubicatefiec;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class BuscarAulas extends FragmentActivity implements GoogleMap.OnMapClickListener {

    private final LatLng ESPOL = new LatLng(-2.146363, -79.965443);
    private final LatLng FIEC  = new LatLng(-2.144820, -79.967392);
    private final LatLng FIMCP = new LatLng(-2.144250, -79.966269);//Facultad de Ingenieria Mecánica y Ciencias de la Producción
    private final LatLng FICT  = new LatLng(-2.145522, -79.965385);//Facultad de Ingeniería en Ciencias de la Tierra
    private final LatLng FCSH = new LatLng(-2.147697, -79.968625);//Facultad de Ciencias Sociales y Humanísticas
    private final LatLng CELEX = new LatLng(-2.148666, -79.967652);
    private final LatLng FCNM = new LatLng(-2.148589, -79.967203);//FACULTAD DE CIENCIAS NATURALES Y MATEMÁTICAS
    private final LatLng FIMCBOR = new LatLng(-2.147144, -79.963019); //FACULTAD DE INGENIERÍA MARÍTIMA, CIENCIAS BIOLÓGICAS, OCEÁNICAS Y RECURSOS NATURALES
    private final LatLng EDCOM = new LatLng(-2.143585, -79.962236); //ESCUELA DE DISEÑO Y COMUNICACIÓN VISUAL
    private final LatLng BIBLIO = new LatLng(-2.147176, -79.966108);//Biblioteca Central de Ingeniería
    private final LatLng RECTORADO = new LatLng(-2.147652, -79.964449);
    private final LatLng AULASFIEC = new LatLng(-2.145455, -79.965948);


    private GoogleMap mapa;
    private Spinner spnFiltro;
    private ClsAulas oAulas;
    private Button btnBuscar;
    private boolean controlador=false;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_buscar_aulas);
        mapa = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(ESPOL, 15));
        mapa.setMyLocationEnabled(true);
        mapa.getUiSettings().setZoomControlsEnabled(false);
        mapa.getUiSettings().setCompassEnabled(true);

        //Se crean las facultades
       /*
        crearFacultades(FIEC, "FIEC","FACULTAD DE INGENIERÍA EN ELECTRICIDAD Y COMPUTACIÓN");
        crearFacultades(FIMCP, "FIMCP","FACULTAD DE INGENIERÍA EN MECÁNICA Y CIENCIAS DE LA PRODUCCIÓN");
        crearFacultades(FICT, "FICT","FACULTAD DE INGENIERÍA EN CIENCIAS DE LA TIERRA");
        crearFacultades(FCSH, "FCSH","FACULTAD DE CIENCIAS SOCIALES Y HUMANÍSTICAS");
        crearFacultades(CELEX, "CELEX","CELEX");
        crearFacultades(FCNM, "FCNM","FACULTAD DE CIENCIAS NATURALES Y MATEMÁTICAS");
        crearFacultades(FIMCBOR, "FIMCBOR","FACULTAD DE INGENIERÍA MARÍTIMA, CIENCIAS BIOLÓGICAS, OCEÁNICAS Y RECURSOS NATURALES");
        crearFacultades(EDCOM, "EDCOM","ESCUELA DE DISEÑO Y COMUNICACIÓN VISUAL");
        crearFacultades(RECTORADO, "RECTORADO","RECTORADO ESPOL");
        crearFacultades(BIBLIO, "BIBLIOTECA","BIBLIOTECA CENTRAL DE INGENIERÍA");
        crearFacultades(AULASFIEC, "AULAS FIEC","AULAS FIEC");

*/
        mapa.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                getAlerta(marker.getTitle(), marker.getSnippet());
            }
        });


        //==========================================================================================
        //==========================================================================================
        spnFiltro=(Spinner)findViewById(R.id.spnFacultades);
        btnBuscar=(Button)findViewById(R.id.btnBuscarA);
        oAulas= new ClsAulas();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, oAulas.getAulas());
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFiltro.setAdapter(adaptador);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearRecorridoControlador();
            }
        });
        mapa.setOnMapClickListener(this);


    }

    private void getRutas(LatLng inicio, LatLng fin){
        PolylineOptions lineas = new PolylineOptions()
                .add(inicio)
                .add(fin);
        lineas.width(1);
        lineas.color(Color.RED);

        mapa.addPolyline(lineas);
    }

    private void getAlerta(String key, String detalle){

        AlertDialog.Builder oAlerta = new AlertDialog.Builder(this);
        oAlerta.setTitle(detalle);//oAlerta.setMessage(mensaje);
        LayoutInflater inflater = getLayoutInflater();
        //oAlerta.setView(inflater.inflate(R.layout.facultad, null));
        LayoutInflater oInflater = getLayoutInflater();
        switch (key) {
            case "FIEC":
                oAlerta.setView( oInflater.inflate(R.layout.fiec, null));
                break;
            case "FIMCP":
                oAlerta.setView(inflater.inflate(R.layout.edcom, null));
                break;
            case "FICT":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "FCSH":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "CELEX":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "FCNM":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "FIMCBOR":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "EDCOM":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "RECTORADO":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "BIBLIOTECA":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;

            default:
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;

        }
        oAlerta.setCancelable(false);
        oAlerta.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        oAlerta.show();
    }

    public void crearFacultades(LatLng position, String titulo, String info){
        mapa.addMarker(new MarkerOptions()
                .position(position)
                .title(titulo)
                .snippet(info)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))//.icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_compass))//
                .anchor(0.5f, 0.5f));
    }

    public void crearRecorrido(LatLng destino){
        if (mapa.getMyLocation() != null) {
            mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(mapa.getMyLocation().getLatitude(), mapa.getMyLocation().getLongitude()), 15));

            mapa.addMarker(new MarkerOptions().position(new LatLng(mapa.getMyLocation().getLatitude(), mapa.getMyLocation().getLongitude()))
                    .title("My Localización")
                    .snippet("Puedes tocar la pantalla para actualiza tu posición")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))//.icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_compass))//
                    .anchor(0.5f, 0.5f));

            getRutas(new LatLng(mapa.getMyLocation().getLatitude(), mapa.getMyLocation().getLongitude()), destino);


        }
    }

    public void crearRecorridoControlador(){
        try {
            String key = spnFiltro.getSelectedItem().toString();
            String key2 = key.substring(1, 6);
            mapa.clear();
            switch (key2) {
                case "FIEC)":

                    crearRecorrido(FIEC);
                    crearFacultades(FIEC, "FIEC","FACULTAD DE INGENIERÍA EN ELECTRICIDAD Y COMPUTACIÓN");
                    break;
                case "FIMCP":

                    crearRecorrido(FIMCP);
                    crearFacultades(FIMCP, "FIMCP","FACULTAD DE INGENIERÍA EN MECÁNICA Y CIENCIAS DE LA PRODUCCIÓN");
                    break;
                case "FICT)":
                    crearRecorrido(FICT);
                    crearFacultades(FICT, "FICT","FACULTAD DE INGENIERÍA EN CIENCIAS DE LA TIERRA");
                    break;
                case "FCSH)":
                    crearRecorrido(FCSH);
                    crearFacultades(FCSH, "FCSH","FACULTAD DE CIENCIAS SOCIALES Y HUMANÍSTICAS");
                    break;
                case "CELEX":
                    crearRecorrido(CELEX);
                    crearFacultades(CELEX, "CELEX","CELEX");
                    break;
                case "FCNM)":
                    crearRecorrido(FCNM);
                    crearFacultades(FCNM, "FCNM","FACULTAD DE CIENCIAS NATURALES Y MATEMÁTICAS");
                    break;
                case "FIMCB":
                    crearRecorrido(FIMCBOR);
                    crearFacultades(FIMCBOR, "FIMCBOR","FACULTAD DE INGENIERÍA MARÍTIMA, CIENCIAS BIOLÓGICAS, OCEÁNICAS Y RECURSOS NATURALES");
                    break;
                case "EDCOM":

                    crearRecorrido(EDCOM);
                    crearFacultades(EDCOM, "EDCOM","ESCUELA DE DISEÑO Y COMUNICACIÓN VISUAL");
                    break;
                case "ECTOR":
                    crearRecorrido(RECTORADO);
                    crearFacultades(RECTORADO, "RECTORADO","RECTORADO ESPOL");
                    break;
                case "IBLIO":
                    crearRecorrido(BIBLIO);
                    crearFacultades(BIBLIO, "BIBLIOTECA","BIBLIOTECA CENTRAL DE INGENIERÍA");
                    break;

                default:
                    break;

            }
        }catch (Exception e){}
    }

    @Override
    public void onMapClick(LatLng puntoPulsado) {
        crearRecorridoControlador();
       // mapa.addMarker(new MarkerOptions().position(puntoPulsado).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
    }



}