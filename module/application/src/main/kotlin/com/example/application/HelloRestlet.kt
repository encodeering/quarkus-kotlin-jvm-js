package com.example.application

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path ("/hello")
class HelloRestlet {

    @GET
    fun hello () = "Hello from application module"

}
