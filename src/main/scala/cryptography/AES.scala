package cryptography

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

class AES {

  def encrypt(plaintext: String, key: Array[Byte]): String = {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val secretKey = new SecretKeySpec(key, "AES")
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    val encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"))
    Base64.getEncoder.encodeToString(encryptedBytes)
  }

  def decrypt(ciphertext: String, key: Array[Byte]): String = {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val secretKey = new SecretKeySpec(key, "AES")
    cipher.init(Cipher.DECRYPT_MODE, secretKey)
    val ciphertextBytes = Base64.getDecoder.decode(ciphertext)
    val decryptedBytes = cipher.doFinal(ciphertextBytes)
    new String(decryptedBytes, "UTF-8")
  }

  def generateKey(): String = {
    val key = Array.ofDim[Byte](16)
    val secureRandom = new java.security.SecureRandom()
    secureRandom.nextBytes(key)
    Base64.getEncoder.encodeToString(key)
  }

}
