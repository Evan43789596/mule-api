/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import org.mule.runtime.api.meta.model.connection.ConnectionProviderModel;

//TODO refactor with Configuration to create a single abstract class
public class ConnectionProviderAst extends ComponentAst {

  public static ConfigurationAstBuilder builder() {
    return new ConfigurationAstBuilder();
  }

  private ConnectionProviderModel model;

  public ConnectionProviderModel getModel() {
    return model;
  }

  public static class ConfigurationAstBuilder
      extends ComponentAstBuilder<ConfigurationAstBuilder, ConnectionProviderAst> {

    private ConnectionProviderModel model;

    public ConfigurationAstBuilder withModel(ConnectionProviderModel model) {
      this.model = model;
      return this;
    }

    @Override
    protected ConnectionProviderAst newInstance() {
      return new ConnectionProviderAst();
    }

    public ConnectionProviderAst build() {
      ConnectionProviderAst connectionProvider = super.build();
      connectionProvider.model = this.model;
      return connectionProvider;
    }
  }

}
