/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import org.mule.runtime.api.artifact.sintax.SourceCodeLocation;
import org.mule.runtime.api.component.ComponentIdentifier;

public class ParameterIdentifierAst {

  private ComponentIdentifier identifier;
  private SourceCodeLocation sourceCodeLocation;

  public SourceCodeLocation getSourceCodeLocation() {
    return sourceCodeLocation;
  }

  public ComponentIdentifier getIdentifier() {
    return identifier;
  }

  public static ParameterIdentifierAstBuilder builder() {
    return new ParameterIdentifierAstBuilder();
  }

  public static final class ParameterIdentifierAstBuilder {

    private ComponentIdentifier identifier;
    private SourceCodeLocation sourceCodeLocation;

    private ParameterIdentifierAstBuilder() {}

    public ParameterIdentifierAstBuilder withIdentifier(ComponentIdentifier identifier) {
      this.identifier = identifier;
      return this;
    }

    public ParameterIdentifierAstBuilder withSourceCodeLocation(SourceCodeLocation sourceCodeLocation) {
      this.sourceCodeLocation = sourceCodeLocation;
      return this;
    }

    public ParameterIdentifierAst build() {
      ParameterIdentifierAst parameterIdentifierAst = new ParameterIdentifierAst();
      parameterIdentifierAst.sourceCodeLocation = this.sourceCodeLocation;
      parameterIdentifierAst.identifier = this.identifier;
      return parameterIdentifierAst;
    }
  }
}
