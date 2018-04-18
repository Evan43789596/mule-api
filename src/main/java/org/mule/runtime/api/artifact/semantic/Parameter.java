/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.artifact.sintax.ParameterDefinition;
import org.mule.runtime.api.meta.model.parameter.ParameterModel;

public class Parameter {

  private ParameterDefinition parameterDefinition;
  private ParameterValue value;
  private ParameterModel model;

  public ParameterValue getValue() {
    return value;
  }

  public ParameterModel getModel() {
    return model;
  }

  public ParameterDefinition getParameterDefinition() {
    return parameterDefinition;
  }

  public static ParameterBuilder builder() {
    return new ParameterBuilder();
  }

  public static final class ParameterBuilder {

    private ParameterDefinition parameterDefinition;
    private ParameterValue value;
    private ParameterModel model;

    private ParameterBuilder() {}

    public ParameterBuilder withValue(ParameterValue value) {
      this.value = value;
      return this;
    }

    public ParameterBuilder withModel(ParameterModel parameterModel) {
      this.model = parameterModel;
      return this;
    }

    public ParameterBuilder withParameterDefinition(ParameterDefinition parameterDefinition) {
      this.parameterDefinition = parameterDefinition;
      return this;
    }

    public Parameter build() {
      Parameter parameter = new Parameter();
      parameter.model = this.model;
      parameter.value = this.value;
      parameter.parameterDefinition = this.parameterDefinition;
      return parameter;
    }
  }
}
