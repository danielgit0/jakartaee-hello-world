package org.eclipse.jakarta.hello;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.Set;
import org.eclipse.jakarta.hello.hello.HelloWorldResourceImpl;

@ApplicationPath("rest")
public class HelloApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    return Set.of(HelloWorldResourceImpl.class);
  }
}
