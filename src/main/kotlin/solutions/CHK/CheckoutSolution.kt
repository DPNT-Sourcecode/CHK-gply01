package solutions.CHK

object CheckoutSolution {

    private val valid = listOf('A', 'B', 'C', 'D', 'E')

    fun checkout(skus: String): Int {

        if (skus.count { it !in valid } != 0) return -1

        val aCount = skus.count { it == 'A' }
        val bCount = skus.count { it == 'B' }
        val cCount = skus.count { it == 'C' }
        val dCount = skus.count { it == 'D' }
        val eCount = skus.count { it == 'E' }

        return getPrice('A', aCount)  +
                getPrice('B', bCount) +
                getPrice('C', cCount) +
                getPrice('D', dCount) +
                getPrice('E', eCount)
    }

    fun getPrice(sku: Char, number: Int = 1): Int {
        return when (sku) {
            'A' ->  specialDeal(3, 130, 50, number)
            'B' -> specialDeal(2, 45, 30, number)
            'C' -> 20 * number
            'D' -> 15 * number
//            'E' -> specialDeal()
            else -> throw IllegalArgumentException()
        }
    }

    fun specialDeal(dealCount: Int, forMoney: Int, usualPrice: Int, itemCount: Int): Int {
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


