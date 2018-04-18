/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.meta.model.source.SourceModel;

public class Source extends Component {

  private SourceModel model;

  public SourceModel getModel() {
    return model;
  }

  public static Source.SourceBuilder builder() {
    return new Source.SourceBuilder();
  }

  public static class SourceBuilder extends Component.ComponentBuilder<Source.SourceBuilder, Source> {

    private SourceModel sourceModel;

    private SourceBuilder() {}

    protected Source newInstance() {
      return new Source();
    }

    public Source.SourceBuilder withSourceModel(SourceModel sourceModel) {
      this.sourceModel = sourceModel;
      return this;
    }

    public Source build() {
      Source source = super.build();
      source.model = sourceModel;
      return source;
    }
  }
}
