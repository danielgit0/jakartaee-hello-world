package org.eclipse.jakarta.hello.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.jakarta.generated.hello.model.Hello;
import org.eclipse.jakarta.hello.hello.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HelloWorldResourceImplTest {

  @Mock private HelloService helloService;

  private HelloWorldResourceImpl resource;

  @BeforeEach
  void setUp() {
    resource = new HelloWorldResourceImpl(helloService);
  }

  @Test
  void hello_withName_delegatesToService() {
    Hello expected = new Hello();
    expected.setMessage("Alice");
    when(helloService.hello("Alice")).thenReturn(expected);

    Hello result = resource.helloGet("Alice");

    assertEquals(expected, result);
    verify(helloService).hello("Alice");
  }

  @Test
  void hello_withNullName_defaultsToWorld() {
    Hello expected = new Hello();
    expected.setMessage("world");
    when(helloService.hello("world")).thenReturn(expected);

    Hello result = resource.helloGet(null);

    assertEquals(expected, result);
    verify(helloService).hello("world");
  }

  @Test
  void hello_withBlankName_defaultsToWorld() {
    Hello expected = new Hello();
    expected.setMessage("world");
    when(helloService.hello("world")).thenReturn(expected);

    Hello result = resource.helloGet("   ");

    assertEquals(expected, result);
    verify(helloService).hello("world");
  }
}
