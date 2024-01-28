package solutions.CHK

//+------+-------+------------------------+
//| Item | Price | Special offers         |
//+------+-------+------------------------+
//| H    | 10    | 5H for 45, 10H for 80  |
//| K    | 80    | 2K for 150             |
//| N    | 40    | 3N get one M free      |
//| P    | 50    | 5P for 200             |
//| Q    | 30    | 3Q for 80              |
//| R    | 50    | 3R get one Q free      |
//| U    | 40    | 3U get one U free      |
//| V    | 50    | 2V for 90, 3V for 130  |
//+------+-------+------------------------+

object CheckoutSolution {

    private val valid = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

    fun checkout(skus: String): Int {

        if (skus.count { it !in valid } != 0) return -1

        return Skus(totalSoFar = 0, skus = skus.toMutableList())
            // SKUs without a deal involved
            .consumeSimpleItems()
            .consumeE()
            .consumeA()
            .consumeB()
            .consumeF()
            .totalSoFar
    }


}

data class Skus(var totalSoFar: Int, val skus: MutableList<Char>) {

    val simpleSkusToPrice = mapOf(
        'C' to 20,
        'D' to 15,
        'G' to 20,
        'I' to 35,
        'J' to 60,
        'L' to 90,
        'M' to 15,
        'O' to 10,
        'S' to 30,
        'T' to 20,
        'W' to 20,
        'X' to 90,
        'Y' to 10,
        'Z' to 50
    )

    fun consumeA(): Skus {
        val aCount = countSku('A')
        val firstDealCount = aCount / 5
        val secondDealCount = (aCount - (firstDealCount * 5)) / 3
        val leftOver = (aCount - (firstDealCount * 5) - secondDealCount * 3)
        skus.removeIf { it == 'A' }
        totalSoFar += (firstDealCount * 200) + (secondDealCount * 130) + (leftOver * 50)
        return this
    }

    fun consumeB(): Skus {
        val value = specialDeal(2, 45, 30, countSku('B'))
        skus.removeIf { it == 'B' }
        totalSoFar += value
        return this
    }

    fun consumeE(): Skus {
        val eCost = countSku('E') * 40
        totalSoFar += eCost
        val freeBs = countSku('E') / 2
        skus.removeIf { it == 'E' }
        for (i in 0 until freeBs ) {
            skus.remove('B')
        }
        return this
    }

    fun consumeF(): Skus {
        totalSoFar += freeSelfDeal('F', 3, 10)
        skus.removeIf { it == 'F' }
        return this
    }

    fun consumeSimpleItems(): Skus {
        simpleSkusToPrice.forEach { (sku, price) ->
            val count = skus.count { it == sku }
            totalSoFar += count * price
            skus.removeIf { it == sku }
        }
        return this
    }

    private fun countSku(char: Char) = this.skus.count { it == char }

    private fun freeSelfDeal(sku: Char, countForFree: Int, usualPrice: Int): Int {
        val count = countSku(sku)
        val free = count / countForFree
        return (count - free) * usualPrice
    }

    private fun specialDeal(dealCount: Int, forMoney: Int, usualPrice: Int, itemCount: Int): Int {
        var total = 0
        var items = itemCount
        while (items >= dealCount) {
            total += forMoney
            items -= dealCount
        }
        total += items * usualPrice
        return total
    }

}

