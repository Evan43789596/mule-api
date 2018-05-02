/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import org.mule.runtime.api.meta.model.config.ConfigurationModel;

public class ConfigurationAst extends ComponentAst {

  public static ConfigurationAstBuilder builder() {
    return new ConfigurationAstBuilder();
  }

  private ConfigurationModel model;
  private ConnectionProviderAst connectionProvider;

  public ConfigurationModel getModel() {
    return model;
  }

  public Optional<ConnectionProviderAst> getConnectionProvider() {
    return ofNullable(connectionProvider);
  }

  public static class ConfigurationAstBuilder
      extends ComponentAstBuilder<ConfigurationAstBuilder, ConfigurationAst> {

    private ConfigurationModel model;
    private ConnectionProviderAst connectionProvider;

    public ConfigurationAstBuilder withModel(ConfigurationModel model) {
      this.model = model;
      return this;
    }


    public ConfigurationAstBuilder withConnectionProvider(ConnectionProviderAst connectionProvider) {
      this.connectionProvider = connectionProvider;
      return this;
    }

    @Override
    protected ConfigurationAst newInstance() {
      return new ConfigurationAst();
    }

    public ConfigurationAst build() {
      ConfigurationAst configuration = super.build();
      configuration.model = this.model;
      configuration.connectionProvider = this.connectionProvider;
      return configuration;
    }
  }

}
