package solutions.HLO

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HelloSolutionTest {

    @Test
    fun `Says Hello`() {
        assert(HelloSolution.hello("Rowan") == "Hello Rowan")
    }

}