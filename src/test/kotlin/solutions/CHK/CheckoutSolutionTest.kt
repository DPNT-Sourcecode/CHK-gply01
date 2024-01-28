package solutions.CHK

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckoutSolutionTest {
    
    @Test
    fun `Free Bs with 2 Es`() {
        assert(CheckoutSolution.checkout("EEEB") == 130)
    }

    @Test
    fun `Contains invalid`() {
        assert(CheckoutSolution.checkout("AAAB3") == -1)
    }

    @Test
    fun `A Special`() {
        assert(CheckoutSolution.checkout("AAA") == 130)
    }

    @Test
    fun `B Special`() {
        assert(CheckoutSolution.checkout("BB") == 45)
    }

    @Test
    fun `One B`() {
        assert(CheckoutSolution.checkout("B") == 30)
    }

}
