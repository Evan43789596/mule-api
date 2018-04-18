/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.meta.model.operation.OperationModel;

public class Operation extends ProcessorComponent {

  private OperationModel operationModel;

  public OperationModel getOperationModel() {
    return operationModel;
  }

  public static OperationBuilder builder() {
    return new OperationBuilder();
  }

  public static class OperationBuilder extends Component.ComponentBuilder<OperationBuilder, Operation> {

    private OperationModel operationModel;

    private OperationBuilder() {}

    protected Operation newInstance() {
      return new Operation();
    }

    public OperationBuilder withOperationModel(OperationModel operationModel) {
      this.operationModel = operationModel;
      return this;
    }

    public Operation build() {
      Operation operation = super.build();
      operation.operationModel = operationModel;
      return operation;
    }
  }


}
