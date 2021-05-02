package test.tests.Crypto;

import crypto.RSAPublicKey;
import test.support.Test;
import test.support.TestFailureException;
import crypto.RSA;

public class RSAPublicKeyContext {
  public static class RSAPublicKeyFingerprintTest extends Test {
    public String label() {
      return "Can get a fingerprint for a public key";
    }

    public void test() throws TestFailureException {
      RSAPublicKey public_key = new RSAPublicKey(0x10001, new byte[] {(byte)0x66, (byte)0x77, (byte)0x88});
      expect(public_key.fingerprint, 0xD7FB3D3B0178C2BCL);
    }
  }
}
