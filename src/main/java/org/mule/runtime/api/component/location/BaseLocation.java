/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.component.location;

import java.util.List;

import org.mule.runtime.api.component.TypedComponentIdentifier;

public interface BaseLocation {

  /**
   * @return the unique absolute path of the component in the application.
   */
  String getLocation();

  /**
   * @return the list of parts for the location. The location starts with the global element containing the component and
   *         continues with the next elements within the global element until the last part which is the component specific part.
   */
  List<LocationPart> getParts();

  /**
   * @return the {@link TypedComponentIdentifier} of the component associated with this location
   */
  TypedComponentIdentifier getComponentIdentifier();

}
