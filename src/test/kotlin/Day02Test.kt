
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 02")
class Day02Test {

    private val solver = Day02()

    @Test
    @DisplayName("Part 1")
    fun day02_part01_example01() {
        val solution = solver.part1()
        assertEquals(8, solution)
    }
    
    @Test
    @DisplayName("Part 2")
    fun day02_part02_example01() {
        val solution = solver.part2()
        assertEquals(2286, solution)
    }

} 
        
