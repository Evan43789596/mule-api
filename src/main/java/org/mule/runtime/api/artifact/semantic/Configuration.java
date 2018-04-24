/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import static java.util.Optional.of;

import java.util.Optional;

import org.mule.runtime.api.meta.model.config.ConfigurationModel;

public class Configuration extends Component {

  public static ConfigurationBuilder builder() {
    return new ConfigurationBuilder();
  }

  private ConfigurationModel model;
  private ConnectionProvider connectionProvider;

  public ConfigurationModel getModel() {
    return model;
  }

  public Optional<ConnectionProvider> getConnectionProvider() {
    return of(connectionProvider);
  }

  public static class ConfigurationBuilder
      extends Component.ComponentBuilder<ConfigurationBuilder, Configuration> {

    private ConfigurationModel model;
    private ConnectionProvider connectionProvider;

    public ConfigurationBuilder withModel(ConfigurationModel model) {
      this.model = model;
      return this;
    }


    public ConfigurationBuilder withConnectionProvider(ConnectionProvider connectionProvider) {
      this.connectionProvider = connectionProvider;
      return this;
    }

    @Override
    protected Configuration newInstance() {
      return new Configuration();
    }

    public Configuration build() {
      Configuration configuration = super.build();
      configuration.model = this.model;
      configuration.connectionProvider = this.connectionProvider;
      return configuration;
    }
  }

}
