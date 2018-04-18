/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

public class Route extends ComplexComponent {

  public static RouteBuilder builder() {
    return new RouteBuilder();
  }

  public static class RouteBuilder extends ComplexComponent.ComplexComponentBuilder<Route.RouteBuilder, Route> {

    private RouteBuilder() {}

    @Override
    public Route newInstance() {
      return new Route();
    }
  }

}
