/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import org.mule.runtime.api.meta.model.operation.OperationModel;

public class OperationAst extends ProcessorComponentAst {

  private OperationModel operationModel;

  public OperationModel getOperationModel() {
    return operationModel;
  }

  public static OperationAstBuilder builder() {
    return new OperationAstBuilder();
  }

  public static class OperationAstBuilder extends ComponentAstBuilder<OperationAstBuilder, OperationAst> {

    private OperationModel operationModel;

    private OperationAstBuilder() {}

    protected OperationAst newInstance() {
      return new OperationAst();
    }

    public OperationAstBuilder withOperationModel(OperationModel operationModel) {
      this.operationModel = operationModel;
      return this;
    }

    public OperationAst build() {
      OperationAst operation = super.build();
      operation.operationModel = operationModel;
      return operation;
    }
  }


}
