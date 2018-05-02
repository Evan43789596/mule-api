/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import org.mule.runtime.api.meta.model.construct.ConstructModel;

public class ConstructAst extends ComplexComponentAst {

  private ConstructModel model;

  public ConstructModel getModel() {
    return model;
  }

  public static ConstructAstBuilder builder() {
    return new ConstructAstBuilder();
  }

  public static class ConstructAstBuilder extends ComplexComponentAstBuilder<ConstructAstBuilder, ConstructAst> {

    private ConstructModel model;

    private ConstructAstBuilder() {}

    public ConstructAstBuilder withModel(ConstructModel constructModel) {
      this.model = constructModel;
      return this;
    }

    @Override
    protected ConstructAst newInstance() {
      return new ConstructAst();
    }

    @Override
    public ConstructAst build() {
      ConstructAst construct = super.build();
      construct.model = this.model;
      return construct;
    }
  }

}
