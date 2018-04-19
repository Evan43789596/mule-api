/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import java.util.ArrayList;
import java.util.List;

import org.mule.runtime.api.artifact.sintax.ComponentDefinition;
import org.mule.runtime.api.component.location.ComponentLocation;

public abstract class Component implements HasParameters {

  List<Parameter> parameters;
  ComponentLocation componentLocation;
  ComponentDefinition componentDefinition;

  public ComponentLocation getComponentLocation() {
    return componentLocation;
  }

  public ComponentDefinition getComponentDefinition() {
    return componentDefinition;
  }

  @Override
  public List<Parameter> getParameters() {
    return parameters;
  }

  public static abstract class ComponentBuilder<T extends ComponentBuilder, BuilderType extends Component> {

    private List<Parameter> parameters = new ArrayList<>();
    private ComponentLocation componentLocation;
    private ComponentDefinition componentDefinition;

    protected abstract BuilderType newInstance();

    public T withParameters(List<Parameter> parameters) {
      this.parameters.addAll(parameters);
      return (T) this;
    }

    public T withComponentLocation(ComponentLocation componentLocation) {
      this.componentLocation = componentLocation;
      return (T) this;
    }

    public T withComponentDefinition(ComponentDefinition componentDefinition) {
      this.componentDefinition = componentDefinition;
      return (T) this;
    }

    public BuilderType build() {
      BuilderType instance = newInstance();
      instance.parameters = this.parameters;
      instance.componentLocation = this.componentLocation;
      instance.componentDefinition = this.componentDefinition;
      return instance;
    }

  }


}
