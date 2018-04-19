/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import java.util.List;

public abstract class ComplexComponent extends ProcessorComponent {

  List<Component> processorComponents;

  public List<Component> getProcessorComponents() {
    return processorComponents;
  }

  ComplexComponent() {}

  public static abstract class ComplexComponentBuilder<T extends ComplexComponentBuilder, BuilderType extends ComplexComponent>
      extends Component.ComponentBuilder<T, BuilderType> {

    List<Component> processorComponents;

    public ComplexComponentBuilder withProcessorComponents(List<Component> processorComponents) {
      this.processorComponents.addAll(processorComponents);
      return this;
    }

    public ComplexComponentBuilder withProcessorComponent(Component processorComponent) {
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
