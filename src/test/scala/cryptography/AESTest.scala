package cryptography

import org.scalatest.funsuite.AnyFunSuite
import java.util.Base64

class AESTest extends AnyFunSuite {
  val aesObj = new AES

  test("AES encryption and decryption should work correctly") {
    val plaintext = "Hello, this is Akanksha Singh"
    val key = aesObj.generateKey()
    val ciphertext = aesObj.encrypt(plaintext, Base64.getDecoder.decode(key))
    val decryptedPlaintext = aesObj.decrypt(ciphertext, Base64.getDecoder.decode(key))
    assert(decryptedPlaintext == plaintext)
  }

  test("return different ciphertexts for same plaintext") {
    val plaintext = "This is another important message"
    val keyOne = aesObj.generateKey()
    val keyTwo = aesObj.generateKey()

    val ciphertext1 = aesObj.encrypt(plaintext, Base64.getDecoder.decode(keyOne))
    val ciphertext2 = aesObj.encrypt(plaintext, Base64.getDecoder.decode(keyTwo))
    assert(ciphertext1 != ciphertext2)
  }

  test("encrypt and decrypt correctly") {
    val plaintext = "This is a secret message"
    val key = aesObj.generateKey()

    val ciphertext = aesObj.encrypt(plaintext, Base64.getDecoder.decode(key))
    assert(ciphertext != plaintext)

    val decryptedText = aesObj.decrypt(ciphertext, Base64.getDecoder.decode(key))
    assert(decryptedText == plaintext)
  }

}
