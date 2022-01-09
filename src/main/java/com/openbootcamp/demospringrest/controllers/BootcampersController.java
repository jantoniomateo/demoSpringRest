package com.openbootcamp.demospringrest.controllers;

import com.openbootcamp.demospringrest.models.Bootcamper;
import com.openbootcamp.demospringrest.services.BootcamperService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component      //le indicamos que es un componente.
@Path("/")      //le indicamos la ruta donde se ejecutará.
public class BootcampersController {
    private final BootcamperService bootcamperService;    // Creamos una variable de tipo BootcamperService.

    //Debemos crear un constructor donde incluimos como argumento todos los servicios que tengamos
    //en este caso como solo ahi un servicio, tenemos solo una variable para ese servicio e incluimos
    //solo ese servicio dentro del constructor.

    public BootcampersController (BootcamperService bootcamperservice){
        this.bootcamperService = bootcamperservice;  //inicializamos la variable.

        //como no tenemos datos ahora mismo, vamos a incluir algunos datos directamente.
        this.bootcamperService.add(new Bootcamper("Juan", Math.random()));
        this.bootcamperService.add(new Bootcamper("Luis", Math.random()));
        this.bootcamperService.add(new Bootcamper("Enrique", Math.random()));
        this.bootcamperService.add(new Bootcamper("Roberto", Math.random()));

    }

    //vamos a hacer que la web nos devuelva información de todos los bootcampers
    @GET                            //le indicamos que queremos información.
    @Path("/bootcampers")          //le indicamos la ruta desde donde se solicita.
    @Produces("application/json")   //le indicamos que la información no la de en formato json.
    public List<Bootcamper> listarTodos (){
        return bootcamperService.getBootcampers();
    }

    //vamos a hacer que desde la web podamos crear un usuario bootcamper.
    @POST                           //le indicamos que vamos a enviar información.
    @Path("/bootcampers")           //le indicamos la ruta donde se ejecuta.
    @Produces("application/json")   //le indicamos tipo de formato que va a ejecutar.
    @Consumes("application/json")   //le indicamos a nuestro método en qué formato recibe la información
    public Response meterBootcamper (Bootcamper bootcamper){
        bootcamperService.add(bootcamper);
        //Como los datos que se devuelve son del tipo response, debemos indicar a nuestro
        //navegador que el bootcamper se ha creado y en el recurso correspondiente /bootcampers/usuario.

        return Response.created(
                URI.create("/bootcampers/" + bootcamper.getNombre())
        ).build();

    }

    //vamos a hacer que desde la web nos envíe información solo de un bootcamper.
    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public Bootcamper listarUno (@PathParam("nombre") String nombre){
        return bootcamperService.get(nombre);
    }

}
