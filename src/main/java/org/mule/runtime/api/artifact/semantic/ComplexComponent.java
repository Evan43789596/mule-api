/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Optional;

public abstract class ComplexComponent extends ProcessorComponent {

  Chain chain;
  List<Route> routes = emptyList();

  ComplexComponent() {}

  public Optional<Chain> getChain() {
    return Optional.of(chain);
  }

  public List<Route> getRoutes() {
    return routes;
  }

  public static abstract class ComplexComponentBuilder<T extends ComplexComponentBuilder, BuilderType extends ComplexComponent>
      extends Component.ComponentBuilder<T, BuilderType> {

    private Chain chain;
    private List<Route> routes = emptyList();

    public ComplexComponentBuilder withChain(Chain chain) {
      this.chain = chain;
      return this;
    }

    public ComplexComponentBuilder withRoutes(List<Route> routes) {
      this.routes = routes;
      return this;
    }

    public BuilderType build() {
      BuilderType complexComponent = super.build();
      complexComponent.chain = this.chain;
      complexComponent.routes = this.routes;
      return complexComponent;
    }
  }
}
