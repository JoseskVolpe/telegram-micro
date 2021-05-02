package test.tests.Support;

import support.IntegerPlus;
import test.support.Test;
import test.support.TestFailureException;

public class IntegerPlusContext {
  public static class RotateRightTest extends Test {
    public String label() {
      return "It can rotate an integer right";
    }
    public void test() throws TestFailureException {
      expect(IntegerPlus.rotateRight(32, 2), 8);
    }
  }
}
