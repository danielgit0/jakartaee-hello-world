package org.eclipse.jakarta.hello.hello.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloServiceImpl implements HelloService {

  private HelloService helloService;

  @Override
  public Hello hello(String name) {
    return new Hello(name);
  }
}
