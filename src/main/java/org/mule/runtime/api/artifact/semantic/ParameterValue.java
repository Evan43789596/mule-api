/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.artifact.sintax.ParameterValueDefinition;
import org.mule.runtime.api.component.location.BaseLocation;

public class ParameterValue {

  private ParameterValueDefinition parameterValueDefinition;
  private BaseLocation location;

  public ParameterValueDefinition getParameterValueDefinition() {
    return parameterValueDefinition;
  }

  public BaseLocation getLocation() {
    return location;
  }

  public static ParameterValueBuilder builder() {
    return new ParameterValueBuilder();
  }

  public static final class ParameterValueBuilder {

    private ParameterValueDefinition parameterValueDefinition;
    private BaseLocation location;

    private ParameterValueBuilder() {}

    public ParameterValueBuilder withParameterValueDefinition(ParameterValueDefinition parameterValueDefinition) {
      this.parameterValueDefinition = parameterValueDefinition;
      return this;
    }

    public ParameterValueBuilder withLocation(BaseLocation location) {
      this.location = location;
      return this;
    }

    public ParameterValue build() {
      ParameterValue parameterValue = new ParameterValue();
      parameterValue.parameterValueDefinition = this.parameterValueDefinition;
      parameterValue.location = this.location;
      return parameterValue;
    }
  }
}
