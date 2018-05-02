/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.sintax;

import org.mule.runtime.api.component.ComponentIdentifier;

public class ParameterIdentifierDefinition {

  private ComponentIdentifier componentIdentifier;
  private SourceCodeLocation sourceCodeLocation;

  public ComponentIdentifier getComponentIdentifier() {
    return componentIdentifier;
  }

  public SourceCodeLocation getSourceCodeLocation() {
    return sourceCodeLocation;
  }

  @Override
  public String toString() {
    return "{\"ParameterIdentifierDefinition\":{"
        + "\"componentIdentifier\":" + componentIdentifier
        + ", \"sourceCodeLocation\":" + sourceCodeLocation
        + "}}";
  }

  public static ParameterIdentifierDefinitionBuilder builder() {
    return new ParameterIdentifierDefinitionBuilder();
  }

  public static final class ParameterIdentifierDefinitionBuilder {

    private ComponentIdentifier componentIdentifier;
    private SourceCodeLocation sourceCodeLocation;

    private ParameterIdentifierDefinitionBuilder() {}


    public ParameterIdentifierDefinitionBuilder withComponentIdentifier(ComponentIdentifier componentIdentifier) {
      this.componentIdentifier = componentIdentifier;
      return this;
    }

    public ParameterIdentifierDefinitionBuilder withSourceCodeLocation(SourceCodeLocation sourceCodeLocation) {
      this.sourceCodeLocation = sourceCodeLocation;
      return this;
    }

    public ParameterIdentifierDefinition build() {
      ParameterIdentifierDefinition parameterIdentifierDefinition = new ParameterIdentifierDefinition();
      parameterIdentifierDefinition.sourceCodeLocation = this.sourceCodeLocation;
      parameterIdentifierDefinition.componentIdentifier = this.componentIdentifier;
      return parameterIdentifierDefinition;
    }
  }
}
