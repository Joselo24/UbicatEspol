package ben.dm.ubicatefiec;

import java.util.ArrayList;

/**
 * Created by Benito on 02/02/2016.
 */
public class ClsAulas {
    private String aulaEdcom[];
    private String aulaFiec[];
    private ArrayList listAulas, listFacultadesP, listFacultadesD;

    public ClsAulas() {
        listAulas = new ArrayList<String>();
        listFacultadesP = new ArrayList<String>();
        listFacultadesD = new ArrayList<String>();




    }
    public ArrayList<String> getAulas() {
        listAulas.add("Destino");
        listAulas.add("RECTORADO");
        listAulas.add("BIBLIOTECA");

        listAulas.add("(FIEC) Lab - Redes Eléctricas");
        listAulas.add("(FIEC) Lab - Robotica");
        listAulas.add("(FIEC) Lab - Sistema Potencia");
        listAulas.add("(FIEC) Lab - Electrónica A");
        listAulas.add("(FIEC) Lab - Electrónica B");
        listAulas.add("(FIEC) COM1");
        listAulas.add("(FIEC) COM2");
        listAulas.add("(FIEC) COM3");
        listAulas.add("(FIEC) Lab - Cisco");
        listAulas.add("(FIEC) Lab - Multimedia");

        listAulas.add("(EDCOM) B-204 Aula");
        listAulas.add("(EDCOM) B-208 Aula");
        listAulas.add("(EDCOM) B-301 Taller Pictóricas");
        listAulas.add("(EDCOM) B-302 Taller Serigrafía");
        listAulas.add("(EDCOM) B-303 Taller Aerografía");
        listAulas.add("(EDCOM) B-304 Taller Dibujo Artístico");
        listAulas.add("(EDCOM) B-306 Taller Dibujo Técnico");
        listAulas.add("(EDCOM) C-107 Taller Fotografía");
        listAulas.add("(EDCOM) C-201 Lab-Mac");
        listAulas.add("(EDCOM) C-206 Lab-Pc");

        listAulas.add("(FICT) Sala de Conferencias");
        listAulas.add("(FICT) Teledetección");
        listAulas.add("(FICT) B-301 Fotogeología");
        listAulas.add("(FICT) Lab - Geofísica");
        listAulas.add("(FICT) Lab - Petrografía");
        listAulas.add("(FICT) Sala de Dibujo");
        listAulas.add("(FICT) AA07 Area de Minas");
        listAulas.add("(FICT) AA17 ");
        listAulas.add("(FICT) Lab - de Computación");
        listAulas.add("(FICT) Aula Satelital");

        listAulas.add("(FIMCP) Aula de Materiales");
        listAulas.add("(FIMCP) 18B - 103");
        listAulas.add("(FIMCP) Lab - Bramotología");
        listAulas.add("(FIMCP) Lab - Fitopatología");
        listAulas.add("(FIMCP) Lab - Metrología");
        listAulas.add("(FIMCP) Lab - Microbiología");
        listAulas.add("(FIMCP) Lab - Operaciones Unitarias");
        listAulas.add("(FIMCP) Lab - Suelos y Nutrición");
        listAulas.add("(FIMCP) Lab - Practicas");
        listAulas.add("(FIMCP) LBTF Termofluidos");

        listAulas.add("(CELEX) 31C101");
        listAulas.add("(CELEX) 31C102");
        listAulas.add("(CELEX) 31C103");
        listAulas.add("(CELEX) 31C201");
        listAulas.add("(CELEX) 31C202");
        listAulas.add("(CELEX) 31C203");
        listAulas.add("(CELEX) 31E101 Lab");
        listAulas.add("(CELEX) 31E102 Lab");
        listAulas.add("(CELEX) 31E201");
        listAulas.add("(CELEX) 31E202");

        listAulas.add("(FCNM) 31B203");
        listAulas.add("(FCNM) 31B300");
        listAulas.add("(FCNM) 31B301");
        listAulas.add("(FCNM) 31B302");
        listAulas.add("(FCNM) 31B303");
        listAulas.add("(FCNM) BA11");
        listAulas.add("(FCNM) BA12");
        listAulas.add("(FCNM) BA13");
        listAulas.add("(FCNM) BA14");
        listAulas.add("(FCNM) BA15");

        listAulas.add("(FIMCBOR) B-109");
        listAulas.add("(FIMCBOR) B-110");
        listAulas.add("(FIMCBOR) B-111");
        listAulas.add("(FIMCBOR) B-112");
        listAulas.add("(FIMCBOR) C-101 Rondalla y Ballet");
        listAulas.add("(FIMCBOR) Lab - Computo");
        listAulas.add("(FIMCBOR) Lab - A y B");
        listAulas.add("(FIMCBOR) BA13");
        listAulas.add("(FIMCBOR) BA14");
        listAulas.add("(FIMCBOR) BA15");

        listAulas.add("(FCSH) IC-11");
        listAulas.add("(FCSH) IC-12");
        listAulas.add("(FCSH) IC-13");
        listAulas.add("(FCSH) IC-14");
        listAulas.add("(FCSH) IC-15");
        listAulas.add("(FCSH) IC-16");
        listAulas.add("(FCSH) IC-17");
        listAulas.add("(FCSH) IC-18");
        listAulas.add("(FCSH) IC-21");
        listAulas.add("(FCSH) IC-22");


        return listAulas;
    }

    public String[] getEDCOM() {
        aulaEdcom[0]="B-101 (AULA-EDCOM)";
        aulaEdcom[1]="B-102 (AULA-EDCOM)";
        aulaEdcom[2]="B-103 (AULA-EDCOM)";
        aulaEdcom[3]="B-104 (AULA-EDCOM)";
        aulaEdcom[4]="B-105 (AULA-EDCOM)";
        aulaEdcom[5]="B-106 (AULA-EDCOM)";
        aulaEdcom[6]="B-201 (AULA-EDCOM)";
        aulaEdcom[7]="B-202 (AULA-EDCOM)";
        aulaEdcom[8]="B-203 (AULA-EDCOM)";
        aulaEdcom[9]="B-204 (AULA-EDCOM)";
        aulaEdcom[10]="B-205 (AULA-EDCOM)";

        return aulaEdcom;

    }
    public String[] getFiec() {//bloque 24 A
        aulaFiec[0]="A-101 (Fiec)";
        aulaFiec[1]="A-102 (Fiec)";
        aulaFiec[2]="A-103 (Fiec)";
        aulaFiec[3]="A-104 (Fiec)";
        aulaFiec[4]="A-105 (Fiec)";
        aulaFiec[5]="A-112 (Fiec)";
        aulaFiec[6]="A-201 (Fiec)";
        aulaFiec[7]="A-202 (Fiec)";
        aulaFiec[8]="A-203 (Fiec)";
        aulaFiec[9]="A-204 (Fiec)";
        aulaFiec[10]="A-205 (Fiec)";

        return aulaFiec;

    }
    public ArrayList<String> getFacultadesP() {
        listFacultadesP.add("Partida");
        listFacultadesP.add("RECTORADO");
        listFacultadesP.add("BIBLIOTECA");
        listFacultadesP.add("FIEC");
        listFacultadesP.add("FIMCP");
        listFacultadesP.add("FICT");
        listFacultadesP.add("FCSH");
        listFacultadesP.add("CELEX");
        listFacultadesP.add("FCNM");
        listFacultadesP.add("FIMCBOR");
        listFacultadesP.add("EDCOM");

        return listFacultadesP;
    }
    public ArrayList<String> getFacultadesD() {
        listFacultadesD.add("Destino");
        listFacultadesD.add("RECTORADO");
        listFacultadesD.add("BIBLIOTECA");
        listFacultadesD.add("FIEC");
        listFacultadesD.add("FIMCP");
        listFacultadesD.add("FICT");
        listFacultadesD.add("FCSH");
        listFacultadesD.add("CELEX");
        listFacultadesD.add("FCNM");
        listFacultadesD.add("FIMCBOR");
        listFacultadesD.add("EDCOM");

        return listFacultadesD;
    }


}
