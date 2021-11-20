package com.example.alumnoproyecto;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GrupoAlumnos {
    private ArrayList<Alumno> listaAlumnos;
    private static GrupoAlumnos grupo = new GrupoAlumnos();
    private Context context;

    public void SerializableData() {
        String filename = "alumnos.txt";
        Log.e("SERIALIZABLE","Serializable class before try");
        try {
            File file = new File(context.getFilesDir(), filename);
            Log.e("SERIALIZABLE","Serializable file name" + file);
            FileOutputStream outputStream = new FileOutputStream(filename);
            Log.e("SERIALIZABLE","Serializable outputStream" + outputStream);
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            Log.e("SERIALIZABLE","Serializable ready to write object");
            for (int  i = 0 ; i<20; i++){
                Alumno alumno = new Alumno();
                alumno.setMatricula(i);
                alumno.setNombre("Alumno #" + i);
                alumno.setActivo(i%2==0);
                os.writeObject(alumno);
            }
            os.close();
            outputStream.close();
            Log.e("SERIALIZABLE","Serializable closed");
        } catch (Exception e) {
            Log.e("SERIALIZABLE","Serializable catch");
            e.printStackTrace();

        }
    }

    private void GrupoAlumnos(){
        SerializableData();
    }

    public static GrupoAlumnos getGrupo(){
        return grupo;
    }

    public ArrayList<Alumno> getListaAlumnos(){
        return listaAlumnos;
    }


    public Alumno getAlumno(int matricula){
        for(Alumno alumno: listaAlumnos){
            if(alumno.getMatricula() == matricula){
                return alumno;
            }
        }
        return null;
    }
}
