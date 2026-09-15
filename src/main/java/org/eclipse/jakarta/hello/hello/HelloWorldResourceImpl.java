package org.eclipse.jakarta.hello.hello;

import jakarta.inject.Inject;
import org.eclipse.jakarta.generated.hello.api.HelloWorldResource;
import org.eclipse.jakarta.generated.hello.model.Hello;
import org.eclipse.jakarta.hello.hello.service.HelloService;

public class HelloWorldResourceImpl implements HelloWorldResource {

  private final HelloService helloService;

  @Inject
  public HelloWorldResourceImpl(HelloService helloService) {
    this.helloService = helloService;
  }

  @Override
  public Hello helloGet(String name) {
    if (name == null || name.trim().isEmpty()) {
      name = "world";
    }

    return helloService.hello(name);
  }
}
