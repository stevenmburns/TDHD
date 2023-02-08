package tdhd

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import org.scalacheck.{Properties, Gen, Prop}


class PopCountSoftwareTest extends AnyFreeSpec {
  "Popcount with value 255 should return 8" in {
    assert(PopCount(255) == 8)
  }
  "Popcount with value 7 should return 3" in {
    assert(PopCount(7) == 3)
  }
  "Popcount with value 0 should return 0" in {
    assert(PopCount(0) == 0)
  }
  "Popcount with value 0x55 should return 4" in {
    assert(PopCount(BigInt("55", 16)) == 4)
  }
}

class PopCountSoftwareTest1 extends AnyFreeSpec {
  "Popcount with value 0 should return 0" in {
    assert(PopCountBroken(0) == 0)
  }
}

class PopCountSoftwareTest2 extends AnyFreeSpec {
  "Popcount with value 0 should return 0" in {
    assert(PopCountDreadful(0) == 0)
  }
}

class PopCountSoftwareTest3 extends AnyFreeSpec {
  "Popcount with value 0 should return 0" in {
    assert(PopCountDreadful(0) == 0)
  }
  "Popcount with value 255 should return 8" in {
    assert(PopCountDreadful(255) == 8)
  }
}

class PopCountSoftwareTest4 extends AnyFreeSpec {
  "Popcount with value 0 should return 0" in {
    assert(PopCountTroll(0) == 0)
  }
  "Popcount with value 255 should return 8" in {
    assert(PopCountTroll(255) == 8)
  }
}

class PopCountSoftwareTest4a extends AnyFreeSpec {
  "Popcount with value 0 should return 0" in {
    assert(PopCountTrolla(0) == 0)
  }
  "Popcount with value 255 should return 8" in {
    assert(PopCountTrolla(255) == 8)
  }
}

class PopCountSoftwareTester(func: BigInt => BigInt) extends AnyFreeSpec {
  "Popcount with value 0 should return 0" in {
    assert(func(0) == 0)
  }
  "Popcount with value 255 should return 8" in {
    assert(func(255) == 8)
  }
}

class PopCountExhaustiveSoftwareTester(func: BigInt => BigInt) extends AnyFreeSpec {
  "Popcount should work for all values in the range [0,256)" in {
    for { i <- BigInt(0) until 256 } {
      assert(func(i) == i.bitCount)
    }
  }
}

class PopCountSoftwareTest_Troll extends PopCountSoftwareTester(PopCountTroll.apply)

class PopCountSoftwareTest_Trolla extends PopCountSoftwareTester(PopCountTrolla.apply)

class PopCountSoftwareTest_Acceptable0 extends PopCountSoftwareTester(PopCountAcceptable0.apply)

class PopCountSoftwareTest_Acceptable extends PopCountSoftwareTester(PopCountAcceptable.apply)


class PopCountExhaustiveSoftwareTest_Acceptable0 extends PopCountExhaustiveSoftwareTester(PopCountAcceptable.apply)

class PopCountSpec extends Properties("Popcount") {
  val smallInteger = Gen.choose(0, 256)
  property("count") = Prop.forAllNoShrink(smallInteger) { a:Int =>
    val i = BigInt(a)
    PopCount(i) == i.bitCount
  }
}
