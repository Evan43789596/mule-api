/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import java.util.List;
import java.util.Optional;

import org.mule.runtime.api.artifact.sintax.ArtifactDefinition;

public class Artifact {

  private Optional<ArtifactDefinition> artifactDefinition;
  private List<Component> globalComponents;

  public static ArtifactBuilder builder() {
    return new ArtifactBuilder();
  }

  public static final class ArtifactBuilder {

    private Optional<ArtifactDefinition> artifactDefinition;
    private List<Component> globalComponents;

    private ArtifactBuilder() {}

    public ArtifactBuilder withArtifactDefinition(Optional<ArtifactDefinition> artifactDefinition) {
      this.artifactDefinition = artifactDefinition;
      return this;
    }

    public ArtifactBuilder withGlobalComponents(List<Component> globalComponents) {
      this.globalComponents = globalComponents;
      return this;
    }

    public Artifact build() {
      Artifact artifact = new Artifact();
      artifact.artifactDefinition = this.artifactDefinition;
      artifact.globalComponents = this.globalComponents;
      return artifact;
    }
  }
}
