/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import static com.google.common.collect.ImmutableList.copyOf;
import static java.util.Optional.ofNullable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.mule.runtime.api.artifact.sintax.SourceCodeLocation;
import org.mule.runtime.api.component.ComponentIdentifier;
import org.mule.runtime.api.component.location.ComponentLocation;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

//TODO remove HasParameters from this component
public abstract class ComponentAst implements HasParametersAst {

  ComponentIdentifier componentIdentifier;
  Multimap<ComponentIdentifier, ParameterAst> parametersMap = ArrayListMultimap.create();
  ComponentLocation componentLocation;
  SourceCodeLocation sourceCodeLocation;

  public ComponentLocation getComponentLocation() {
    return componentLocation;
  }

  public SourceCodeLocation getSourceCodeLocation() {
    return sourceCodeLocation;
  }

  public ComponentIdentifier getComponentIdentifier() {
    return componentIdentifier;
  }

  public Optional<ParameterAst> getParameter(ComponentIdentifier componentIdentifier) {
    Collection<ParameterAst> values = parametersMap.get(componentIdentifier);
    return ofNullable(values.isEmpty() ? null : values.iterator().next());
  }

  public List<ParameterAst> getParameters(ComponentIdentifier componentIdentifier) {
    return (List<ParameterAst>) parametersMap.get(componentIdentifier);
  }

  @Override
  public List<ParameterAst> getParameters() {
    return copyOf(parametersMap.values());
  }

  public static abstract class ComponentAstBuilder<T extends ComponentAstBuilder, BuilderType extends ComponentAst> {

    private Multimap<ComponentIdentifier, ParameterAst> parametersMap = ArrayListMultimap.create();
    private ComponentLocation componentLocation;
    private SourceCodeLocation sourceCodeLocation;
    private ComponentIdentifier componentIdentifier;

    protected abstract BuilderType newInstance();

    public T withParameters(List<ParameterAst> parameters) {
      parameters.stream().forEach(parameterAst -> {
        parametersMap.put(parameterAst.getParameterIdentifier().getIdentifier(), parameterAst);
      });
      return (T) this;
    }

    public T withComponentLocation(ComponentLocation componentLocation) {
      this.componentLocation = componentLocation;
      return (T) this;
    }

    public T withSourceCodeLocation(SourceCodeLocation sourceCodeLocation) {
      this.sourceCodeLocation = sourceCodeLocation;
      return (T) this;
    }

    public T withComponentIdentifier(ComponentIdentifier componentIdentifier) {
      this.componentIdentifier = componentIdentifier;
      return (T) this;
    }

    public BuilderType build() {
      BuilderType instance = newInstance();
      instance.parametersMap = this.parametersMap;
      instance.sourceCodeLocation = this.sourceCodeLocation;
      instance.componentIdentifier = this.componentIdentifier;
      return instance;
    }

  }


}
