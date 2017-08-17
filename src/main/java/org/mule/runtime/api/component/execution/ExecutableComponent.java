/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.component.execution;

import org.mule.runtime.api.event.Event;
import org.mule.runtime.api.event.InputEvent;
import org.mule.runtime.api.meta.AnnotatedObject;

import java.util.concurrent.CompletableFuture;

/**
 * Component representable in the Mule configuration that allows to be executed programmatically
 * 
 * @since 1.0
 */
public interface ExecutableComponent extends AnnotatedObject {

  /**
   * Executes the component based on a {@link InputEvent} created programmatically be the user.
   *
   * @param inputEvent the input to execute the component
   * @return a {@link Event} with the content of the result
   */
  CompletableFuture<Event> execute(InputEvent inputEvent);

  /**
   * Executes the component based on a {@link Event} that may have been provided by another component execution.
   *
   * @param event the input to execute the component
   * @return a {@link Event} with the content of the result
   */
  CompletableFuture<Event> execute(Event event);

}