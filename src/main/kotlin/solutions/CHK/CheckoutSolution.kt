package solutions.CHK

object CheckoutSolution {

    private val pricing = mapOf(
        "A" to 50,
        "B" to 30,
        "C" to 20,
        "D" to 15
    )

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


