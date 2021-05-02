package test.support;

public abstract class SkippedTest extends Test {
  public boolean skipped() {
    return true;
  }
}
