/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import java.util.List;

import org.mule.runtime.api.meta.model.nested.NestedRouteModel;

public class Route extends ComplexComponent {

  private NestedRouteModel model;

  public NestedRouteModel getModel() {
    return model;
  }

  public static RouteBuilder builder() {
    return new RouteBuilder();
  }

  public static class RouteBuilder extends ComplexComponent.ComplexComponentBuilder<Route.RouteBuilder, Route> {

    private NestedRouteModel model;

    private RouteBuilder() {}

    public RouteBuilder withModel(NestedRouteModel routeModel) {
      this.model = routeModel;
      return this;
    }

    public ComplexComponentBuilder withProcessorComponents(List<Component> processorComponents) {
      this.processorComponents.addAll(processorComponents);
      return this;
    }

    public ComplexComponentBuilder withProcessorComponent(Component processorComponent) {
      this.processorComponents.add(processorComponent);
      return this;
    }

    @Override
    public Route newInstance() {
      return new Route();
    }

    @Override
    public Route build() {
      Route route = super.build();
      route.model = this.model;
      return route;
    }
  }

}
