/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import org.mule.runtime.api.meta.model.nested.NestedChainModel;

public class ChainAst extends ComplexComponentAst {

  private NestedChainModel chainModel;

  public NestedChainModel getChainModel() {
    return chainModel;
  }

  public static ChainAstBuilder builder() {
    return new ChainAstBuilder();
  }

  public static class ChainAstBuilder extends ComplexComponentAstBuilder<ChainAstBuilder, ChainAst> {

    private NestedChainModel chainModel;

    public ChainAstBuilder withModel(NestedChainModel chainModel) {
      this.chainModel = chainModel;
      return this;
    }

    @Override
    protected ChainAst newInstance() {
      return new ChainAst();
    }

    public ChainAst build() {
      ChainAst chain = super.build();
      chain.chainModel = this.chainModel;
      return chain;
    }
  }

}
