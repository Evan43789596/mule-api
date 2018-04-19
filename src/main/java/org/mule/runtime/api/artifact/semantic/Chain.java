/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.meta.model.nested.NestedChainModel;

public class Chain extends ComplexComponent {

  private NestedChainModel chainModel;

  public NestedChainModel getChainModel() {
    return chainModel;
  }

  public static abstract class ChainBuilder extends Component.ComponentBuilder<ChainBuilder, Chain> {

    private NestedChainModel chainModel;

    public ChainBuilder withModel(NestedChainModel chainModel) {
      this.chainModel = chainModel;
      return this;
    }

    @Override
    protected Chain newInstance() {
      return new Chain();
    }

    public Chain build() {
      Chain chain = super.build();
      chain.chainModel = this.chainModel;
      return chain;
    }
  }

}
