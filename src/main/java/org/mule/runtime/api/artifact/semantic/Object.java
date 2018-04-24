/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

import org.mule.metadata.api.model.ObjectType;

//TODO parameters of this kind of objects are not propertly represented in the semantics. We need those parameters.
public class Object extends Component {

  private ObjectType objectType;

  public ObjectType getObjectType() {
    return objectType;
  }

  public static ObjectBuilder builder() {
    return new ObjectBuilder();
  }

  public static class ObjectBuilder extends ComponentBuilder<ObjectBuilder, Object> {

    private ObjectType objectType;

    public ObjectBuilder withObjectType(ObjectType objectType) {
      this.objectType = objectType;
      return this;
    }

    protected Object newInstance() {
      return new Object();
    }

    public Object build() {
      Object instance = super.build();
      instance.objectType = this.objectType;
      return instance;
    }

  }


}
