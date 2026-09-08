package org.eclipse.jakarta.hello.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URL;
import org.eclipse.jakarta.hello.HelloApplication;
import org.eclipse.jakarta.hello.hello.service.Hello;
import org.eclipse.jakarta.hello.hello.service.HelloService;
import org.eclipse.jakarta.hello.hello.service.HelloServiceImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ArquillianExtension.class)
@RunAsClient
class HelloWorldResourceIT {

  @Deployment
  public static WebArchive createDeployment() {
    return ShrinkWrap.create(WebArchive.class, "jakartaee-hello-world.war")
        .addClasses(
            HelloApplication.class,
            HelloWorldResource.class,
            HelloService.class,
            HelloServiceImpl.class,
            Hello.class)
        .addAsWebInfResource("WEB-INF/beans.xml", "beans.xml");
  }

  @ArquillianResource private URL baseURL;

  @Test
  void hello_defaultName_returnsWorld() {
    try (Client client = ClientBuilder.newClient()) {
      Response response =
          client.target(baseURL + "rest/hello").request(MediaType.APPLICATION_JSON).get();

      assertEquals(200, response.getStatus());
      String body = response.readEntity(String.class);
      assertTrue(body.contains("world"), "Expected response to contain world but got: " + body);
    }
  }

  @Test
  void hello_withName_returnsName() {
    try (Client client = ClientBuilder.newClient()) {
      Response response =
          client
              .target(baseURL + "rest/hello")
              .queryParam("name", "Alice")
              .request(MediaType.APPLICATION_JSON)
              .get();

      assertEquals(200, response.getStatus());
      String body = response.readEntity(String.class);
      assertTrue(body.contains("Alice"), "Expected response to contain Alice but got: " + body);
    }
  }
}
