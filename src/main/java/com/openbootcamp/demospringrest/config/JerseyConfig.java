package com.openbootcamp.demospringrest.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

//indicamos donde se va a ejecutar la aplicación, que sería en la raiz principal "/"
@ApplicationPath("/")
@Component                  // le indicamos que es un componente.

// Creamos una clase para configurar jersey que es una clase hija de ResourceConfig
public class JerseyConfig extends ResourceConfig {


    /*
    Constructor para indicar donde están nuestros controladores utilizando para ello
    la función heredada de package */
    public JerseyConfig(){
        this.packages("com.openbootcamp.demospringrest.controllers");
    }
}
