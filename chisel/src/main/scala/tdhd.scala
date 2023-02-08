package tdhd

object PopCountBroken {
  def apply(n : BigInt) : BigInt = {
    1
  }
}

object PopCountDreadful {
  def apply(n : BigInt) : BigInt = {
    0
  }
}

object PopCountTroll {
  def apply(n : BigInt) : BigInt = {
    var sum : BigInt = 0
    for { i <- 0 until 8 } {
      if ((n & (BigInt(1)<<i)) != BigInt(0)) {
        sum += 1
      }
    }
    sum
  }
}

object PopCountTrolla {
  def apply(n : BigInt) : BigInt = {
    ((0 until 8) map {i => if ((n & (BigInt(1)<<i)) != BigInt(0)) 1 else 0}).foldLeft(0){_ + _}
  }
}

object PopCountTrollb {
  def apply(n : BigInt) : BigInt = {
    (0 until 8).foldLeft(0) {case (s, i) => s + (if ((n & (BigInt(1)<<i)) != BigInt(0)) 1 else 0)}
  }
}

object PopCountAcceptable0 {
  def apply(n : BigInt) : BigInt = {
    var sum : BigInt = 0
    var x = n
    while (x != BigInt(0)) {
      if ((x & BigInt(1)) != BigInt(0)) {
        sum += 1
      }
      x = x >> 1
    }
    sum
  }
}



object PopCountAcceptable {
  def apply(n : BigInt) : BigInt = {
    var sum : BigInt = 0
    var x = n
    while (x != BigInt(0)) {
      // 01010000
      // 01001111
      // -------- &
      // 01000000
      x = (x - 1) & x
      sum += 1
    }
    sum
  }
}


object PopCount {
  def apply(n : BigInt) : BigInt = {
    val n1 = (n & BigInt("01010101", 2)) + ((n & BigInt("10101010", 2)) >> 1)
    val n2 = (n1 & BigInt("00110011", 2)) + ((n1 & BigInt("11001100", 2)) >> 2)
    (n2 & BigInt("00000111", 2)) + ((n2 & BigInt("01110000", 2)) >> 4)
  }
}
