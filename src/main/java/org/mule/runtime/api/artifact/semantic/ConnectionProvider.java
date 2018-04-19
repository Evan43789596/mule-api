/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.meta.model.connection.ConnectionProviderModel;

//TODO refactor with Configuration to create a single abstract class
public class ConnectionProvider extends Component {

  public static ConfigurationBuilder builder() {
    return new ConfigurationBuilder();
  }

  private ConnectionProviderModel model;

  public ConnectionProviderModel getModel() {
    return model;
  }

  public static class ConfigurationBuilder
      extends ComponentBuilder<ConfigurationBuilder, ConnectionProvider> {

    private ConnectionProviderModel model;

    public ConfigurationBuilder withModel(ConnectionProviderModel model) {
      this.model = model;
      return this;
    }

    @Override
    protected ConnectionProvider newInstance() {
      return new ConnectionProvider();
    }

    public ConnectionProvider build() {
      ConnectionProvider connectionProvider = super.build();
      connectionProvider.model = this.model;
      return connectionProvider;
    }
  }

}
