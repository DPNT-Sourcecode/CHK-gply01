package solutions.CHK

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckoutSolutionTest {

    @Test
    fun `A Special`() {
        assert(CheckoutSolution.checkout("AAA") == 130)
    }

}