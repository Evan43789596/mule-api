/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.sintax;

public class ParameterDefinition {

  private SourceCodeLocation sourceCodeLocation;
  private ParameterIdentifierDefinition parameterIdentifierDefinition;
  private ParameterValueDefinition parameterValueDefinition;

  public ParameterValueDefinition getParameterValueDefinition() {
    return parameterValueDefinition;
  }

  public SourceCodeLocation getSourceCodeLocation() {
    return sourceCodeLocation;
  }

  public ParameterIdentifierDefinition getParameterIdentifierDefinition() {
    return parameterIdentifierDefinition;
  }

  @Override
  public String toString() {
    return "{\"ParameterDefinition\":{"
        + "\"sourceCodeLocation\":" + sourceCodeLocation
        + ", \"parameterIdentifierDefinition\":" + parameterIdentifierDefinition
        + ", \"parameterValueDefinition\":" + parameterValueDefinition
        + "}}";
  }

  public static ParameterDefinitionBuilder builder() {
    return new ParameterDefinitionBuilder();
  }

  public static final class ParameterDefinitionBuilder {

    private SourceCodeLocation sourceCodeLocation;
    private ParameterIdentifierDefinition parameterIdentifierDefinition;
    private ParameterValueDefinition parameterValueDefinition;

    private ParameterDefinitionBuilder() {}

    public ParameterDefinitionBuilder withSourceCodeLocation(SourceCodeLocation sourceCodeLocation) {
      this.sourceCodeLocation = sourceCodeLocation;
      return this;
    }

    public ParameterDefinitionBuilder withParameterIdentifierDefinition(ParameterIdentifierDefinition parameterIdentifierDefinition) {
      this.parameterIdentifierDefinition = parameterIdentifierDefinition;
      return this;
    }

    public ParameterDefinitionBuilder withParameterValueDefinition(ParameterValueDefinition parameterValueDefinition) {
      this.parameterValueDefinition = parameterValueDefinition;
      return this;
    }

    public ParameterDefinition build() {
      ParameterDefinition parameterDefinition = new ParameterDefinition();
      parameterDefinition.parameterIdentifierDefinition = this.parameterIdentifierDefinition;
      parameterDefinition.parameterValueDefinition = this.parameterValueDefinition;
      parameterDefinition.sourceCodeLocation = this.sourceCodeLocation;
      return parameterDefinition;
    }
  }
}
