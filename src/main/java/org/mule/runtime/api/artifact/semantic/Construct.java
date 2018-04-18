/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.meta.model.construct.ConstructModel;

public class Construct extends ComplexComponent {

  private ConstructModel model;

  public ConstructModel getModel() {
    return model;
  }

  public static ConstructBuilder builder() {
    return new ConstructBuilder();
  }

  public static class ConstructBuilder extends ComplexComponent.ComplexComponentBuilder<ConstructBuilder, Construct> {

    private ConstructModel model;

    private ConstructBuilder() {}

    public ConstructBuilder withModel(ConstructModel constructModel) {
      this.model = constructModel;
      return this;
    }

    @Override
    protected Construct newInstance() {
      return new Construct();
    }

    @Override
    public Construct build() {
      Construct construct = super.build();
      construct.model = this.model;
      return construct;
    }
  }

}
