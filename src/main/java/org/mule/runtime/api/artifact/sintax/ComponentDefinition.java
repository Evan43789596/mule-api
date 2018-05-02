/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.sintax;

import static java.util.Optional.of;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mule.runtime.api.component.ComponentIdentifier;

public class ComponentDefinition {

  private SourceCodeLocation sourceCodeLocation;
  // TODO change to symbol identifier and create another identifier for the one in the config
  private ComponentIdentifier identifier;
  private ParameterValueDefinition parameterValueDefinition;
  private List<ParameterDefinition> parameterDefinitions;
  private List<ComponentDefinition> childComponentDefinitions;

  public SourceCodeLocation getSourceCodeLocation() {
    return sourceCodeLocation;
  }

  public List<ParameterDefinition> getParameterDefinitions() {
    return parameterDefinitions;
  }

  public List<ComponentDefinition> getChildComponentDefinitions() {
    return childComponentDefinitions;
  }

  public Optional<ParameterValueDefinition> getParameterValueDefinition() {
    return of(parameterValueDefinition);
  }

  public ComponentIdentifier getIdentifier() {
    return identifier;
  }

  @Override
  public String toString() {
    return "{\"ComponentDefinition\":{"
        + "\"sourceCodeLocation\":" + sourceCodeLocation
        + ", \"identifier\":" + identifier
        + ", \"parameterValueDefinition\": " + parameterValueDefinition
        + ", \"parameterDefinitions\": ["
        + parameterDefinitions.stream().map(ParameterDefinition::toString).reduce((a, b) -> a + " , " + b).orElse("")
        + "], \"childComponentDefinitions\": ["
        + childComponentDefinitions.stream().map(ComponentDefinition::toString).reduce((a, b) -> a + " , " + b).orElse("")
        + "]}}";
  }

  public static ComponentDefinitionBuilder builder() {
    return new ComponentDefinitionBuilder();
  }

  public static final class ComponentDefinitionBuilder {

    private ComponentIdentifier identifier;
    private SourceCodeLocation sourceCodeLocation;
    private ParameterValueDefinition parameterValueDefinition;
    private List<ParameterDefinition> parameterDefinitions = new ArrayList<>();
    private List<ComponentDefinition> childComponentDefinitions = new ArrayList<>();

    private ComponentDefinitionBuilder() {}

    public ComponentDefinitionBuilder withSourceCodeLocation(SourceCodeLocation sourceCodeLocation) {
      this.sourceCodeLocation = sourceCodeLocation;
      return this;
    }

    public ComponentDefinitionBuilder withIdentifier(ComponentIdentifier identifier) {
      this.identifier = identifier;
      return this;
    }

    public ComponentDefinitionBuilder withParameterValueDefinition(ParameterValueDefinition parameterValueDefinition) {
      this.parameterValueDefinition = parameterValueDefinition;
      return this;
    }

    public ComponentDefinitionBuilder withParameterDefinitions(List<ParameterDefinition> parameterDefinitions) {
      this.parameterDefinitions = parameterDefinitions;
      return this;
    }

    public ComponentDefinitionBuilder withParameterDefinition(ParameterDefinition parameterDefinition) {
      this.parameterDefinitions.add(parameterDefinition);
      return this;
    }

    public ComponentDefinitionBuilder withChildComponentDefinitions(List<ComponentDefinition> childComponentDefinitions) {
      this.childComponentDefinitions = childComponentDefinitions;
      return this;
    }

    public ComponentDefinitionBuilder withChildComponentDefinition(ComponentDefinition childComponentDefinition) {
      this.childComponentDefinitions.add(childComponentDefinition);
      return this;
    }

    public ComponentDefinition build() {
      ComponentDefinition componentDefinition = new ComponentDefinition();
      componentDefinition.identifier = this.identifier;
      componentDefinition.parameterDefinitions = this.parameterDefinitions;
      componentDefinition.childComponentDefinitions = this.childComponentDefinitions;
      componentDefinition.sourceCodeLocation = this.sourceCodeLocation;
      componentDefinition.parameterValueDefinition = this.parameterValueDefinition;
      return componentDefinition;
    }
  }
}
