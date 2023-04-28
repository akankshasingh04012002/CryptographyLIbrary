
package cryptography

import java.nio.charset.StandardCharsets
import java.security.{KeyPairGenerator, PrivateKey, PublicKey, Signature}
import java.util.Base64

class RSA {

  private val ALGORITHM = "RSA"

  def sign(message: String, privateKey: PrivateKey): String = {
    val signature = Signature.getInstance("SHA256withRSA")
    signature.initSign(privateKey)
    signature.update(message.getBytes(StandardCharsets.UTF_8))
    Base64.getEncoder.encodeToString(signature.sign())
  }

  def verify(message: String, signature: String, publicKey: PublicKey): Boolean = {
    val verifier = Signature.getInstance("SHA256withRSA")
    verifier.initVerify(publicKey)
    verifier.update(message.getBytes(StandardCharsets.UTF_8))
    verifier.verify(Base64.getDecoder.decode(signature))
  }

  def generateKeyPair(): (PublicKey, PrivateKey) = {
    val generator = KeyPairGenerator.getInstance(ALGORITHM)
    generator.initialize(2048)
    val keyPair = generator.generateKeyPair()
    (keyPair.getPublic, keyPair.getPrivate)
  }

}
