/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import org.mule.runtime.api.meta.model.nested.NestedRouteModel;

public class RouteAst extends ComplexComponentAst {

  private NestedRouteModel model;

  public NestedRouteModel getModel() {
    return model;
  }

  public static RouteAstBuilder builder() {
    return new RouteAstBuilder();
  }

  public static class RouteAstBuilder extends ComplexComponentAstBuilder<RouteAstBuilder, RouteAst> {

    private NestedRouteModel model;

    private RouteAstBuilder() {}

    public RouteAstBuilder withModel(NestedRouteModel routeModel) {
      this.model = routeModel;
      return this;
    }

    @Override
    public RouteAst newInstance() {
      return new RouteAst();
    }

    @Override
    public RouteAst build() {
      RouteAst route = super.build();
      route.model = this.model;
      return route;
    }
  }

}
