/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import org.mule.metadata.api.model.ObjectType;

//TODO parameters of this kind of objects are not propertly represented in the semantics. We need those parameters.
public class ObjectAst extends ComponentAst {

  private ObjectType objectType;

  public ObjectType getObjectType() {
    return objectType;
  }

  @Override
  public String toString() {
    return "{\"Object\":"
        + super.toString()
        + ", \"objectType\":" + objectType
        + "}";
  }

  public static ObjectAstBuilder builder() {
    return new ObjectAstBuilder();
  }

  public static class ObjectAstBuilder extends ComponentAstBuilder<ObjectAstBuilder, ObjectAst> {

    private ObjectType objectType;

    public ObjectAstBuilder withObjectType(ObjectType objectType) {
      this.objectType = objectType;
      return this;
    }

    protected ObjectAst newInstance() {
      return new ObjectAst();
    }

    public ObjectAst build() {
      ObjectAst instance = super.build();
      instance.objectType = this.objectType;
      return instance;
    }

  }


}
