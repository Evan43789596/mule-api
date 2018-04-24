/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.artifact.sintax.ParameterValueDefinition;

public class Value extends Component {

  private ParameterValueDefinition parameterValueDefinition;

  public ParameterValueDefinition getParameterValueDefinition() {
    return parameterValueDefinition;
  }

  public static ValueBuilder builder() {
    return new ValueBuilder();
  }

  public static class ValueBuilder {

    private ParameterValueDefinition parameterValueDefinition;

    public ValueBuilder withParameterValueDefinition(ParameterValueDefinition parameterValueDefinition) {
      this.parameterValueDefinition = parameterValueDefinition;
      return this;
    }

    public Value build() {
      Value value = new Value();
      value.parameterValueDefinition = this.parameterValueDefinition;
      return value;
    }

  }

}
