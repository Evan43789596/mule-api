/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.time;

import org.mule.api.annotation.NoImplement;

import java.util.function.Supplier;

/**
 * A {@link Supplier} which provides a unified time in milliseconds.
 *
 * @since 4.0
 */
@NoImplement
public interface TimeSupplier extends Supplier<Long> {

  /**
   * Returns {@link System#currentTimeMillis()}
   *
   * @return the current time in milliseconds
   */
  @Override
  Long get();
}
