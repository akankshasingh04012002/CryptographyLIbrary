package cryptography

import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.Base64

class Hash {

  def hashing(message: String): String = {
    val digest = MessageDigest.getInstance("SHA-256")
    val hashBytes = digest.digest(message.getBytes(StandardCharsets.UTF_8))
    Base64.getEncoder.encodeToString(hashBytes)
  }
}
