package solutions.CHK

object CheckoutSolution {

    private val valid = listOf('A', 'B', 'C', 'D', 'E')

    fun checkout(skus: String): Int {

        if (skus.count { it !in valid } != 0) return -1

        return Skus(totalSoFar = 0, skus = skus.toMutableList())
            .consumeE()
            .consumeA()
            .consumeB()
            .consumeC()
            .consumeD()
            .totalSoFar
    }


}

data class Skus(var totalSoFar: Int, val skus: MutableList<Char>) {

    fun consumeA(): Skus {
        val value = specialDeal(3, 130, 50, countSku('A'))
        skus.removeIf { it == 'A' }
        totalSoFar += value
        return this
    }

    fun consumeB(): Skus {
        val value = specialDeal(2, 45, 30, countSku('B'))
        skus.removeIf { it == 'B' }
        totalSoFar += value
        return this
    }

    fun consumeC(): Skus {
        totalSoFar += countSku('C') * 20
        skus.removeIf { it == 'C' }
        return this
    }

    fun consumeD(): Skus {
        totalSoFar += countSku('D') * 15
        skus.removeIf { it == 'D' }
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

    private fun countSku(char: Char) = this.skus.count { it == char }

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




