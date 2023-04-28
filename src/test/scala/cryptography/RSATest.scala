package cryptography
import cryptography.RSA

import org.scalatest.funsuite.AnyFunSuite

class RSATest extends AnyFunSuite {
  val rsaOBject = new RSA

  test("RSA signing and verification should work correctly") {
    val message = "Hello Everyone"
    val (publicKey, privateKey) = rsaOBject.generateKeyPair()
    val signature = rsaOBject.sign(message, privateKey)
    val isVerified = rsaOBject.verify(message, signature, publicKey)
    assert(isVerified)
  }

}
