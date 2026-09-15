package org.eclipse.jakarta.hello.hello.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.jakarta.generated.hello.model.Hello;

@ApplicationScoped
public class HelloServiceImpl implements HelloService {

  @Override
  public Hello hello(String name) {
    Hello hello = new Hello();
    hello.setMessage(name);
    return hello;
  }
}
