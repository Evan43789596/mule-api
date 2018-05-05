/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

public class InternalDslOperationAst extends ComponentAst {

  public static InternalDslOperationAstBuilder builder() {
    return new InternalDslOperationAstBuilder();
  }

  public static class InternalDslOperationAstBuilder
      extends ComponentAstBuilder<InternalDslOperationAst.InternalDslOperationAstBuilder, InternalDslOperationAst> {

    @Override
    protected InternalDslOperationAst newInstance() {
      return new InternalDslOperationAst();
    }

    public InternalDslOperationAst build() {
      InternalDslOperationAst internalDslOperationAst = super.build();
      return internalDslOperationAst;
    }
  }

}
