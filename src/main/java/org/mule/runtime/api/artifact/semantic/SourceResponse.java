/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import java.util.ArrayList;
import java.util.List;

import org.mule.runtime.api.artifact.sintax.ComponentDefinition;
import org.mule.runtime.api.meta.model.source.SourceCallbackModel;

public class SourceResponse {

  private List<Parameter> parameters;
  private ComponentDefinition componentDefinition;
  private SourceCallbackModel model;

  public List<Parameter> getParameters() {
    return parameters;
  }

  public ComponentDefinition getComponentDefinition() {
    return componentDefinition;
  }

  public SourceCallbackModel getModel() {
    return model;
  }

  public static SourceResponseBuilder builder() {
    return new SourceResponseBuilder();
  }

  public static class SourceResponseBuilder {

    private List<Parameter> parameters = new ArrayList<>();
    private ComponentDefinition componentDefinition;
    private SourceCallbackModel model;

    public SourceResponseBuilder withParameters(List<Parameter> parameters) {
      this.parameters.addAll(parameters);
      return this;
    }

    public SourceResponseBuilder withComponentDefinition(ComponentDefinition componentDefinition) {
      this.componentDefinition = componentDefinition;
      return this;
    }

    public SourceResponseBuilder withModel(SourceCallbackModel model) {
      this.model = model;
      return this;
    }

    public SourceResponse build() {
      SourceResponse instance = new SourceResponse();
      instance.parameters = this.parameters;
      instance.componentDefinition = this.componentDefinition;
      instance.model = this.model;
      return instance;
    }


  }

}
