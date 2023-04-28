package cryptography

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HashTest extends AnyFlatSpec with Matchers {
  val obj = new Hash

  "The Hash function" should "SHA-256 hashing should work correctly" in {
    val inputString = "Hello, world!"
    val hashedString = obj.hashing(inputString)
    hashedString shouldBe "MV9b23bQeMQ7isAGTkoBZGErH853yGk0W/yUx1iU7dM="
  }

  it should "generate a unique hash for each input" in {
    val inputString1 = "password123"
    val inputString2 = "password456"
    val hashedString1 = obj.hashing(inputString1)
    val hashedString2 = obj.hashing(inputString2)
    hashedString1 should not equal hashedString2
  }

}
