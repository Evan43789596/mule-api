/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.sintax;

import java.util.ArrayList;
import java.util.List;

public class ArtifactDefinition {

  private List<ComponentDefinition> rootDefinitions;

  public List<ComponentDefinition> getRootDefinitions() {
    return rootDefinitions;
  }

  public static ArtifactDefinitionBuilder builder() {
    return new ArtifactDefinitionBuilder();
  }

  public static final class ArtifactDefinitionBuilder {

    private List<ComponentDefinition> rootDefinitions = new ArrayList<>();

    private ArtifactDefinitionBuilder() {}

    public ArtifactDefinitionBuilder withRootDefinitions(List<ComponentDefinition> globalDefinitions) {
      this.rootDefinitions = globalDefinitions;
      return this;
    }

    public ArtifactDefinitionBuilder withRootDefinition(ComponentDefinition globalDefinition) {
      this.rootDefinitions.add(globalDefinition);
      return this;
    }

    public ArtifactDefinition build() {
      ArtifactDefinition artifactDefinition = new ArtifactDefinition();
      artifactDefinition.rootDefinitions = this.rootDefinitions;
      return artifactDefinition;
    }
  }
}
