/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import java.util.ArrayList;
import java.util.List;

public abstract class ComplexComponentAst extends ProcessorComponentAst {

  List<ComponentAst> processorComponents;

  public List<ComponentAst> getProcessorComponents() {
    return processorComponents;
  }

  ComplexComponentAst() {}

  public static abstract class ComplexComponentAstBuilder<T extends ComplexComponentAstBuilder, BuilderType extends ComplexComponentAst>
      extends ComponentAstBuilder<T, BuilderType> {

    List<ComponentAst> processorComponents = new ArrayList<>();

    public ComplexComponentAstBuilder withProcessorComponents(List<ComponentAst> processorComponents) {
      this.processorComponents.addAll(processorComponents);
      return this;
    }

    public ComplexComponentAstBuilder withProcessorComponent(ComponentAst processorComponent) {
      this.processorComponents.add(processorComponent);
      return this;
    }

    public BuilderType build() {
      BuilderType complexComponent = super.build();
      complexComponent.processorComponents = this.processorComponents;
      return complexComponent;
    }
  }
}
