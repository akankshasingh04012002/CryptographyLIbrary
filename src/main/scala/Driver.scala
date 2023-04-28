import cryptography.AES
import cryptography.RSA
import cryptography.Hash

import java.util.Base64

object Driver {

  def main(args: Array[String]): Unit = {
    val aes = new AES
    val hash = new Hash
    val rsa = new RSA
    val message = "THIS IS AKANKSHA SINGH"
    val aesKey = aes.generateKey()
    val aesCiphertext = aes.encrypt(message, Base64.getDecoder.decode(aesKey))
    val aesDecryptedPlaintext = aes.decrypt(aesCiphertext, Base64.getDecoder.decode(aesKey))
    val sha256Hash = hash.hashing(message)
    val (publicKey, privateKey) = rsa.generateKeyPair()
    val rsaSignature = rsa.sign(message, privateKey)
    val isVerified = rsa.verify(message, rsaSignature, publicKey)

    println("Message: " + message)
    println("AES key: " + aesKey)
    println("AES ciphertext: " + aesCiphertext)
    println("AES decrypted plaintext: " + aesDecryptedPlaintext)
    println("SHA-256 hash: " + sha256Hash)
    println("RSA public key: " + Base64.getEncoder.encodeToString(publicKey.getEncoded))
    println("RSA private key: " + Base64.getEncoder.encodeToString(privateKey.getEncoded))
    println("RSA signature: " + rsaSignature)
    println("RSA verification result: " + isVerified)
  }

}

