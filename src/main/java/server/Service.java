package server;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Service {

    public static void main(String[] args) {
        startServer();

    }

    public static HttpServer startServer() {
        URI uri = URI.create("http://localhost:8080");
        ResourceConfig config = new ResourceConfig().packages("server/resource");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);

        return server;
    }

}
