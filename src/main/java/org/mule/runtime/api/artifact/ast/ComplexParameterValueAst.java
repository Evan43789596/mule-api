/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import org.mule.runtime.api.artifact.sintax.SourceCodeLocation;
import org.mule.runtime.api.component.location.BaseLocation;

public class ComplexParameterValueAst extends ParameterValueAst {

  private ComponentAst component;
  private SourceCodeLocation sourceCodeLocation;

  public ComponentAst getComponent() {
    return component;
  }

  public SourceCodeLocation getSourceCodeLocation() {
    return sourceCodeLocation;
  }

  public static ComplexParameterValueBuilder builder() {
    return new ComplexParameterValueBuilder();
  }

  public static final class ComplexParameterValueBuilder {

    private BaseLocation location;
    private ComponentAst component;
    private SourceCodeLocation sourceCodeLocation;

    private ComplexParameterValueBuilder() {}

    public ComplexParameterValueBuilder withLocation(BaseLocation location) {
      this.location = location;
      return this;
    }

    public ComplexParameterValueBuilder withComponent(ComponentAst component) {
      this.component = component;
      return this;
    }

    public ComplexParameterValueBuilder withSourceCodeLocation(SourceCodeLocation sourceCodeLocation) {
      this.sourceCodeLocation = sourceCodeLocation;
      return this;
    }

    public ComplexParameterValueAst build() {
      ComplexParameterValueAst parameterValue = new ComplexParameterValueAst();
      parameterValue.component = this.component;
      parameterValue.location = this.location;
      parameterValue.sourceCodeLocation = this.sourceCodeLocation;
      return parameterValue;
    }
  }



}
