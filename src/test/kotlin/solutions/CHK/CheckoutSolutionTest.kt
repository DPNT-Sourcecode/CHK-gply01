package solutions.CHK

import org.junit.jupiter.api.Test
import solutions.CHK.CheckoutSolution.checkout

class CheckoutSolutionTest {

    @Test
    fun `Free Fs with 3 or more`() {
        assert(checkout("FFF") == 20)
    }

    @Test
    fun `Free Bs with 2 Es`() {
        assert(checkout("EEEBB") == 150)
    }

    @Test
    fun `Contains invalid`() {
        assert(checkout("AAAB3") == -1)
    }

    @Test
    fun `A Special`() {
        assert(checkout("AAA") == 130)
    }

    @Test
    fun `A Special 2`() {
        assert(checkout("AAAAA") == 200)
    }

    @Test
    fun `A Special Complicated`() {
        /**
         * 5A = 200
         * 3A = 130
         * 1A = 50
         * = 380
         */
        assert(checkout("AAAAAAAAA") == 380)
    }

    @Test
    fun `B Special`() {
        assert(checkout("BB") == 45)
    }

    @Test
    fun `One B`() {
        assert(checkout("B") == 30)
    }

}