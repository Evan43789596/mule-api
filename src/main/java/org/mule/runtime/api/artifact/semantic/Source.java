/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import java.util.Optional;

import org.mule.runtime.api.meta.model.source.SourceModel;

public class Source extends Component {

  private SourceModel model;
  private SourceResponse errorResponse;
  private SourceResponse successResponse;

  public SourceModel getModel() {
    return model;
  }

  public Optional<SourceResponse> getErrorResponse() {
    return Optional.of(errorResponse);
  }

  public Optional<SourceResponse> getSuccessResponse() {
    return Optional.of(successResponse);
  }

  public static Source.SourceBuilder builder() {
    return new Source.SourceBuilder();
  }

  public static class SourceBuilder extends Component.ComponentBuilder<Source.SourceBuilder, Source> {

    private SourceModel model;
    private SourceResponse errorResponse;
    private SourceResponse successResponse;

    private SourceBuilder() {}

    protected Source newInstance() {
      return new Source();
    }

    public Source.SourceBuilder withModel(SourceModel sourceModel) {
      this.model = sourceModel;
      return this;
    }

    public Source.SourceBuilder withErrorResponse(SourceResponse errorResponse) {
      this.errorResponse = errorResponse;
      return this;
    }

    public Source.SourceBuilder withSuccessResponse(SourceResponse successResponse) {
      this.successResponse = successResponse;
      return this;
    }

    public Source build() {
      Source source = super.build();
      source.model = this.model;
      source.errorResponse = this.errorResponse;
      source.successResponse = this.successResponse;
      return source;
    }
  }
}
