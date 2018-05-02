/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import java.util.ArrayList;
import java.util.List;

import org.mule.runtime.api.artifact.sintax.ComponentDefinition;
import org.mule.runtime.api.artifact.sintax.SourceCodeLocation;
import org.mule.runtime.api.meta.model.source.SourceCallbackModel;

public class SourceResponseAst {

  private List<ParameterAst> parameters;
  private SourceCallbackModel model;
  private SourceCodeLocation sourceCodeLocation;

  public List<ParameterAst> getParameters() {
    return parameters;
  }

  public SourceCodeLocation getSourceCodeLocation() {
    return sourceCodeLocation;
  }

  public SourceCallbackModel getModel() {
    return model;
  }

  public static SourceResponseBuilder builder() {
    return new SourceResponseBuilder();
  }

  public static class SourceResponseBuilder {

    private List<ParameterAst> parameters = new ArrayList<>();
    private SourceCallbackModel model;
    private SourceCodeLocation sourceCodeLocation;

    public SourceResponseBuilder withParameters(List<ParameterAst> parameters) {
      this.parameters.addAll(parameters);
      return this;
    }

    public SourceResponseBuilder withSourceCodeLocation(SourceCodeLocation sourceCodeLocation) {
      this.sourceCodeLocation = sourceCodeLocation;
      return this;
    }

    public SourceResponseBuilder withModel(SourceCallbackModel model) {
      this.model = model;
      return this;
    }

    public SourceResponseAst build() {
      SourceResponseAst instance = new SourceResponseAst();
      instance.parameters = this.parameters;
      instance.model = this.model;
      instance.sourceCodeLocation = sourceCodeLocation;
      return instance;
    }


  }

}
