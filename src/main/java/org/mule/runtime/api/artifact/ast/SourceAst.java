/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import org.mule.runtime.api.meta.model.source.SourceModel;

public class SourceAst extends ComponentAst {

  private SourceModel model;
  private SourceResponseAst errorResponse;
  private SourceResponseAst successResponse;

  public SourceModel getModel() {
    return model;
  }

  public Optional<SourceResponseAst> getErrorResponse() {
    return ofNullable(errorResponse);
  }

  public Optional<SourceResponseAst> getSuccessResponse() {
    return ofNullable(successResponse);
  }

  public static SourceAstBuilder builder() {
    return new SourceAstBuilder();
  }

  public static class SourceAstBuilder extends ComponentAstBuilder<SourceAstBuilder, SourceAst> {

    private SourceModel model;
    private SourceResponseAst errorResponse;
    private SourceResponseAst successResponse;

    private SourceAstBuilder() {}

    protected SourceAst newInstance() {
      return new SourceAst();
    }

    public SourceAstBuilder withModel(SourceModel sourceModel) {
      this.model = sourceModel;
      return this;
    }

    public SourceAstBuilder withErrorResponse(SourceResponseAst errorResponse) {
      this.errorResponse = errorResponse;
      return this;
    }

    public SourceAstBuilder withSuccessResponse(SourceResponseAst successResponse) {
      this.successResponse = successResponse;
      return this;
    }

    public SourceAst build() {
      SourceAst source = super.build();
      source.model = this.model;
      source.errorResponse = this.errorResponse;
      source.successResponse = this.successResponse;
      return source;
    }
  }
}
