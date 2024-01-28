package solutions.CHK

object CheckoutSolution {

    fun checkout(skus: String): Int {
        val aCount = skus.filter { it == 'A' }
        val bCount = skus.filter { it == 'B' }
        val cCount = skus.filter { it == 'C' }
        val dCount = skus.filter { it == 'D' }
    }

    fun getPrice(sku: String, number: Int = 1): Int {
        return when (sku) {
            "A" -> 50
            "B" -> 30
            "C" -> 20
            "D" -> 15
            else -> throw IllegalArgumentException()
        }
    }
}



