/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

//TODO refactor with Configuration to create a single abstract class
public class ParameterComponentAst extends ComponentAst {

  public static ParameterComponentAstBuilder builder() {
    return new ParameterComponentAstBuilder();
  }

  public static class ParameterComponentAstBuilder
      extends ComponentAstBuilder<ParameterComponentAstBuilder, ParameterComponentAst> {

    @Override
    protected ParameterComponentAst newInstance() {
      return new ParameterComponentAst();
    }

    public ParameterComponentAst build() {
      ParameterComponentAst connectionProvider = super.build();
      return connectionProvider;
    }
  }

}
