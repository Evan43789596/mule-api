/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import org.mule.runtime.api.artifact.sintax.SourceCodeLocation;
import org.mule.runtime.api.meta.model.parameter.ParameterModel;

public class ParameterAst {

  private ParameterValueAst value;
  private ParameterModel model;
  private SourceCodeLocation sourceCodeLocation;
  private ParameterIdentifierAst parameterIdentifier;

  public ParameterValueAst getValue() {
    return value;
  }

  public ParameterModel getModel() {
    return model;
  }

  public SourceCodeLocation getSourceCodeLocation() {
    return sourceCodeLocation;
  }

  public ParameterIdentifierAst getParameterIdentifier() {
    return parameterIdentifier;
  }

  @Override
  public String toString() {
    return "{\"ParameterAst\":{"
        + "\"value\":" + value
        + ", \"model\":" + model
        + ", \"sourceCodeLocation\":" + sourceCodeLocation
        + ", \"parameterIdentifier\":" + parameterIdentifier
        + "}}";
  }

  public static ParameterBuilder builder() {
    return new ParameterBuilder();
  }

  public static final class ParameterBuilder {

    private ParameterValueAst value;
    private ParameterModel model;
    private SourceCodeLocation sourceCodeLocation;
    private ParameterIdentifierAst parameterIdentifier;

    private ParameterBuilder() {}

    public ParameterBuilder withValue(ParameterValueAst value) {
      this.value = value;
      return this;
    }

    public ParameterBuilder withModel(ParameterModel parameterModel) {
      this.model = parameterModel;
      return this;
    }

    public ParameterBuilder withSourceCodeLocation(SourceCodeLocation sourceCodeLocation) {
      this.sourceCodeLocation = sourceCodeLocation;
      return this;
    }

    public ParameterBuilder withParameterIdentifier(ParameterIdentifierAst parameterIdentifier) {
      this.parameterIdentifier = parameterIdentifier;
      return this;
    }

    public ParameterAst build() {
      ParameterAst parameter = new ParameterAst();
      parameter.model = this.model;
      parameter.value = this.value;
      parameter.sourceCodeLocation = this.sourceCodeLocation;
      parameter.parameterIdentifier = this.parameterIdentifier;
      return parameter;
    }
  }
}
