/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.sintax;

public class SourceCodeLocation {

  private int startLine;
  private int endLine;
  private int startColumn;
  private int endColumn;
  private String filename;

  public int getStartLine() {
    return startLine;
  }

  public int getEndLine() {
    return endLine;
  }

  public int getStartColumn() {
    return startColumn;
  }

  public int getEndColumn() {
    return endColumn;
  }

  public String getFilename() {
    return filename;
  }

  @Override
  public String toString() {
    return "{\"SourceCodeLocation\":{"
        + "\"startLine\":\"" + startLine + "\""
        + ", \"endLine\":\"" + endLine + "\""
        + ", \"startColumn\":\"" + startColumn + "\""
        + ", \"endColumn\":\"" + endColumn + "\""
        + ", \"filename\":\"" + filename + "\""
        + "}}";
  }

  public static SourceCodeLocationBuilder builder() {
    return new SourceCodeLocationBuilder();
  }

  public static final class SourceCodeLocationBuilder {

    private int startLine;
    private int endLine;
    private int startColumn;
    private int endColumn;
    private String filename;

    private SourceCodeLocationBuilder() {}



    public SourceCodeLocationBuilder withStartLine(int startLine) {
      this.startLine = startLine;
      return this;
    }

    public SourceCodeLocationBuilder withEndLine(int endLine) {
      this.endLine = endLine;
      return this;
    }

    public SourceCodeLocationBuilder withStartColumn(int startColumn) {
      this.startColumn = startColumn;
      return this;
    }

    public SourceCodeLocationBuilder withEndColumn(int endColumn) {
      this.endColumn = endColumn;
      return this;
    }

    public SourceCodeLocationBuilder withFilename(String filename) {
      this.filename = filename;
      return this;
    }

    public SourceCodeLocation build() {
      SourceCodeLocation sourceCodeLocation = new SourceCodeLocation();
      sourceCodeLocation.startLine = this.startLine;
      sourceCodeLocation.endLine = this.endLine;
      sourceCodeLocation.filename = this.filename;
      sourceCodeLocation.startColumn = this.startColumn;
      sourceCodeLocation.endColumn = this.endColumn;
      return sourceCodeLocation;
    }
  }
}
