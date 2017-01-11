/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.stream.bytes;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

public abstract class AbstractByteStreamingTestCase {

  protected static final int KB_256 = 256 * 1024;
  protected static final int MB_1 = 1024 * 1024;
  protected static final int MB_2 = MB_1 * 2;

  protected String data;

  public AbstractByteStreamingTestCase(int dataSize) {
    data = randomAlphanumeric(dataSize);
  }

  protected String toString(byte[] dest) throws IOException {
    return IOUtils.toString(dest, Charset.defaultCharset().name());
  }
}