package org.eclipse.jakarta.hello.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.jakarta.hello.hello.service.Hello;
import org.eclipse.jakarta.hello.hello.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HelloWorldResourceTest {

  @Mock private HelloService helloService;

  private HelloWorldResource resource;

  @BeforeEach
  void setUp() {
    resource = new HelloWorldResource(helloService);
  }

  @Test
  void hello_withName_delegatesToService() {
    Hello expected = new Hello("Alice");
    when(helloService.hello("Alice")).thenReturn(expected);

    Hello result = resource.hello("Alice");

    assertEquals(expected, result);
    verify(helloService).hello("Alice");
  }

  @Test
  void hello_withNullName_defaultsToWorld() {
    Hello expected = new Hello("world");
    when(helloService.hello("world")).thenReturn(expected);

    Hello result = resource.hello(null);

    assertEquals(expected, result);
    verify(helloService).hello("world");
  }

  @Test
  void hello_withBlankName_defaultsToWorld() {
    Hello expected = new Hello("world");
    when(helloService.hello("world")).thenReturn(expected);

    Hello result = resource.hello("   ");

    assertEquals(expected, result);
    verify(helloService).hello("world");
  }
}
