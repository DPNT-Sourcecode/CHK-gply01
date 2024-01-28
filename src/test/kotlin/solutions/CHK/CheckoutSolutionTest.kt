package solutions.CHK

import org.junit.jupiter.api.Test

class CheckoutSolutionTest {

    @Test
    fun `Free Bs with 2 Es`() {
        assert(CheckoutSolution.checkout("EEEBB") == 150)
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
    fun `A Special 2`() {
        assert(CheckoutSolution.checkout("AAAAA") == 200)
    }

    @Test
    fun `A Special Complicated`() {
        /**
         * 5A = 200
         * 3A = 130
         * 1A = 50
         * = 380
         */
        assert(CheckoutSolution.checkout("AAAAAAAAA") == 380)
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
