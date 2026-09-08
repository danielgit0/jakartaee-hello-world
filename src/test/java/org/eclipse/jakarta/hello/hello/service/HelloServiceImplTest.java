package org.eclipse.jakarta.hello.hello.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HelloServiceImplTest {

  private HelloServiceImpl helloService;

  @BeforeEach
  void setUp() {
    helloService = new HelloServiceImpl();
  }

  @Test
  void hello_returnsHelloWithGivenName() {
    Hello result = helloService.hello("Alice");
    assertNotNull(result);
    assertEquals("Alice", result.getHello());
  }

  @Test
  void hello_returnsHelloWithAnotherName() {
    Hello result = helloService.hello("world");
    assertNotNull(result);
    assertEquals("world", result.getHello());
  }
}
