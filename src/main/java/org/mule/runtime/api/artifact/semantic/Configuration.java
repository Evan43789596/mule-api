/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.runtime.api.meta.model.config.ConfigurationModel;

public class Configuration extends Component {

  public static ConfigurationBuilder builder() {
    return new ConfigurationBuilder();
  }

  private ConfigurationModel model;

  public ConfigurationModel getModel() {
    return model;
  }

  public static class ConfigurationBuilder
      extends Component.ComponentBuilder<ConfigurationBuilder, Configuration> {

    private ConfigurationModel model;

    public ConfigurationBuilder withModel(ConfigurationModel model) {
      this.model = model;
      return this;
    }

    @Override
    protected Configuration newInstance() {
      return new Configuration();
    }

    public Configuration build() {
      Configuration complexComponent = super.build();
      complexComponent.model = this.model;
      return complexComponent;
    }
  }

}
