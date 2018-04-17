/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.sintax;

public class ParameterValueDefinition {

  private SourceCodeLocation sourceCodeLocation;
  private String rawValue;

  public SourceCodeLocation getSourceCodeLocation() {
    return sourceCodeLocation;
  }

  public String getRawValue() {
    return rawValue;
  }

  public static ValueDefinitionBuilder builder() {
    return new ValueDefinitionBuilder();
  }

  public static final class ValueDefinitionBuilder {

    private SourceCodeLocation sourceCodeLocation;
    private String rawValue;

    private ValueDefinitionBuilder() {}

    public ValueDefinitionBuilder withSourceCodeLocation(SourceCodeLocation sourceCodeLocation) {
      this.sourceCodeLocation = sourceCodeLocation;
      return this;
    }

    public ValueDefinitionBuilder withRawValue(String rawValue) {
      this.rawValue = rawValue;
      return this;
    }

    public ParameterValueDefinition build() {
      ParameterValueDefinition parameterValueDefinition = new ParameterValueDefinition();
      parameterValueDefinition.sourceCodeLocation = this.sourceCodeLocation;
      parameterValueDefinition.rawValue = this.rawValue;
      return parameterValueDefinition;
    }
  }
}
