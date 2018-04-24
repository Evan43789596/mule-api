/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.artifact.sintax.ComponentDefinition;
import org.mule.runtime.api.component.location.BaseLocation;

public class ComplexParameterValue extends ParameterValue {

  private ComponentDefinition componentDefinition;
  private Component component;

  public ComponentDefinition getComponentDefinition() {
    return componentDefinition;
  }

  public Component getComponent() {
    return component;
  }

  public static ComplexParameterValueBuilder builder() {
    return new ComplexParameterValueBuilder();
  }

  public static final class ComplexParameterValueBuilder {

    private ComponentDefinition componentDefinition;
    private BaseLocation location;
    private Component component;

    private ComplexParameterValueBuilder() {}

    public ComplexParameterValueBuilder withComponentDefinition(ComponentDefinition componentDefinition) {
      this.componentDefinition = componentDefinition;
      return this;
    }

    public ComplexParameterValueBuilder withLocation(BaseLocation location) {
      this.location = location;
      return this;
    }

    public ComplexParameterValueBuilder withComponent(Component component) {
      this.component = component;
      return this;
    }

    public ComplexParameterValue build() {
      ComplexParameterValue parameterValue = new ComplexParameterValue();
      parameterValue.componentDefinition = this.componentDefinition;
      parameterValue.component = this.component;
      parameterValue.location = this.location;
      return parameterValue;
    }
  }



}
