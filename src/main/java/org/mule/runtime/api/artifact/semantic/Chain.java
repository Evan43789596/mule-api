/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import java.util.ArrayList;
import java.util.List;

public class Chain extends ComplexComponent {

  List<ProcessorComponent> processorComponents;

  public List<ProcessorComponent> getProcessorComponents() {
    return processorComponents;
  }

  public static abstract class ChainBuilder extends Component.ComponentBuilder<ChainBuilder, Chain> {

    List<ProcessorComponent> processorComponents = new ArrayList<>();

    public ChainBuilder setProcessorComponents(List<ProcessorComponent> processorComponents) {
      this.processorComponents.addAll(processorComponents);
      return this;
    }

    public Chain build() {
      Chain chain = super.build();
      return chain;
    }
  }

}
