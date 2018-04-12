/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.semantic;

public interface SimpleParameterValue extends ParameterValue {

  boolean isLiteral();

  boolean isExpression();

  boolean isPlaceholder();

  boolean containsPlaceholder();

  String getRawValue();

}
