package com.openbootcamp.demospringrest.services;

import com.openbootcamp.demospringrest.models.Bootcamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service     //le indicamos que es un servicio.

public class BootcamperService {

    /*
    Creamos un Arraylist donde se va a recoger en memoria la información de los bootcampers y
    creamos una función para que devuelva los datos de ese arraylist.
     */
    private final List<Bootcamper> bootcampers = new ArrayList<>();

    public List<Bootcamper> getBootcampers() {
        return bootcampers;
    }
    // función para añadir un bootcamper al arralist
    public void add(Bootcamper bootcamper){
        bootcampers.add(bootcamper);
    }

    // función obtener los datos de un bootcamper concreto.
    public Bootcamper get (String nombre){
        for (Bootcamper bootcamper : bootcampers) {
            if (bootcamper.getNombre().equalsIgnoreCase(nombre)){
                return bootcamper;
            }
        }
        return null;
    }

}
