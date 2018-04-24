/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.artifact.sintax.ParameterValueDefinition;
import org.mule.runtime.api.component.location.BaseLocation;

public class SimpleParameterValue extends ParameterValue {

  private ParameterValueDefinition parameterValueDefinition;

  public ParameterValueDefinition getParameterValueDefinition() {
    return parameterValueDefinition;
  }

  public static SimpleParameterValueBuilder builder() {
    return new SimpleParameterValueBuilder();
  }

  public static final class SimpleParameterValueBuilder {

    private ParameterValueDefinition parameterValueDefinition;
    private BaseLocation location;

    private SimpleParameterValueBuilder() {}

    public SimpleParameterValueBuilder withParameterValueDefinition(ParameterValueDefinition parameterValueDefinition) {
      this.parameterValueDefinition = parameterValueDefinition;
      return this;
    }

    public SimpleParameterValueBuilder withLocation(BaseLocation location) {
      this.location = location;
      return this;
    }

    public SimpleParameterValue build() {
      SimpleParameterValue parameterValue = new SimpleParameterValue();
      parameterValue.parameterValueDefinition = this.parameterValueDefinition;
      parameterValue.location = this.location;
      return parameterValue;
    }
  }

}
