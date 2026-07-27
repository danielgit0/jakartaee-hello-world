package org.eclipse.jakarta.hello.hello;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.jakarta.hello.hello.service.Hello;
import org.eclipse.jakarta.hello.hello.service.HelloService;

@Path("hello")
public class HelloWorldResource {
  private final HelloService helloService;

  @Inject
  public HelloWorldResource(HelloService helloService) {
    this.helloService = helloService;
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public Hello hello(@QueryParam("name") String name) {
    if ((name == null) || name.trim().isEmpty()) {
      name = "world";
    }

    return helloService.hello(name);
  }
}
