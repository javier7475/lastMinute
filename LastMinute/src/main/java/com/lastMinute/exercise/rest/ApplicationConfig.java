package com.lastMinute.exercise.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("rest")
public class ApplicationConfig extends Application {
  public Set<Class<?>> getClasses() {
    Set<Class<?>> s = new HashSet<Class<?>>();
    s.add(FlightSearch.class);;
    return s;
  }

}
