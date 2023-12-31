# AOC2023

AoC 2023 in Kotlin

## Day 01 Trebuchet?!

Part 1 was pretty straight forward, but part 2 was a kicker: turns out Regex.matchAll() does not return overlapping
matches. So the edge case of
`threeight` would not find `["three", "eight"]`. Got that tip for a workaround from the Subreddit.

## Day 02: Cube Conundrum

Much easier than before, just parse the data correctly with Regex. Code is a little repetitive, but also easy to read.

## Day 03: Gear Ratios

Much harder again. Solved Part1 while scanning through the field and checking for parts around the numbers.
Literally edge case got me, where numbers may end on the last column -> the next digit is part of a different number.
For part 2 I scrapped the approach and tried to word with the indices of numbers and gears. I still think the code is
messy, there is surely an easier way.

## Day 04: Scratchcards

Parsing the input correctly is most of the work. Set-operations make this a breeze. Once both the formulas for
part 1 and part 2 was clear, the implementation wasn't difficult as well.

## Day 05: If You Give A Seed A Fertilizer

Parsing the input was a little tedious, but separate maps work fine. Part 1 was again straight forward, but for part 2
the search space blew up. Since I wanted to find a minimum, I implemented a reverse search, which is still
brute forcing but runs in ok time.

## Day 06: Wait for it

Brute force solution did work, but was a little slow, so my intuition was, that there closed form mathematical solution,
and of course, there was.

## Day 07: Camel Cards

A little exercise on being as verbose as possible, with a lot of `enum class` and `String` extension functions for
parsing.
Part 1 was therefore very fun and simple, once the foundation was layed out. Part 2 was a little frustrating at first,
because the change of ordering meant, that I needed two enumerations for the cards. But I figured it out, how to make
an interface of enumerations comparable.

## Day 08: Haunted Wasteland

Part 1 was straight forward, just follow the instructions. Part 2 could not be brute forced, so the key wa to remember,
that each ghost follows its own loop and the *least common multiple* of each loop length represents time it takes
until all loops sync up again.

# Day 09: Mirage Maintenance

Window-Function was key here.

# Day 10: Pipe Maze

First kind of maze problem, but the actual path was quite straight, since it was guaranteed
to be a single loop without branches. Finding the enclosed areas was more tricky, since a simple flood-fill
would not work, given the rules of the puzzle. So after another tip I implemented
the [nonzero-rule](https://en.wikipedia.org/wiki/Nonzero-rule).

# Day 11: Cosmic Expansion

It was quite clear, that I only wanted to model the Galaxies, not the space between. Then It was a matter of
updating the coordinates based on the expansion multiplier.

## Day 12: Hot Springs

Part 1 was a nice brute-force approach that fell flat for part 2. So I tried dynamic programming again and probably made
it more complicated than it needs to be. I experimented with just keeping track of the size of the current group
instead of a list of all groups, that would simplify the shenanigans I needed to do in the recursion part.
But the runtime was always too slow, until I finally just slapped some memoization on and reduced the time from
a REDACTED to under a second :)

# Day 13: Point of Incidence

This time, brute force did work, for finding the correct axis as well as permuting all possible smudge locations
for part 2 and finding all the possible reflection axis. The tricky part was to remember, that after cleaning the mirror
more than one axis could be viable.

# Day 14: Parabolic Reflector Dish

I think I found an okay way to simulate the result of the rolling rocks. I'm not sure, if an iterative approach would be
faster
than searching through the set of rocks first. Part 2 was easy this time, because I remembered my nemesis from last year
[2022 Day 17: Pyroclastic Flow](https://adventofcode.com/2022/day/17) where I couldn't figure out, how to detect the
repeating pattern. Now, I avenged my past self! I could speed up the process, if I would check after each tilt, if there
is an
repeating pattern.

# Day 15: Lens Library

Implementing the Hash-Function was easy, and then instantly recognized what data structure we would build. Just using a
HashMap from the standard library would have also worked, but I wanted to implement it myself.

# Day 16: The Floor Will Be Lava

Once again being very verbose while modeling the problem. Getting the path of the beam was a simple BFS-Algorithm and
then just brute-forcing part 2.

# Day 17: Clumsy Crucible

Path finding again, first I was pleased, I thought [Dijkstra](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)
would manage, but the state being a little more
complicated was an issue here. I came pretty close a few times, but in the end, I needed to look at some other solutions
to figure out, what state to save where. Kind of annoying having two starting points, since I saved the current
direction
in the state. Having access to a priority queue helped a lot, so the algo could finish early.

# Day 18: Lavaduct Lagoon

Part 1 is easy with [BFS-FloodFill](https://en.wikipedia.org/wiki/Flood_fill), for part 2 I reimplemented the solution
to use [shoelace](https://en.wikipedia.org/wiki/Shoelace_formula) algorithm
with [picks theorem](https://en.wikipedia.org/wiki/Pick%27s_theorem)
to calculate the area or number of coordinates in area. Separating the input parsing and the calculation of the solution
is probably not necessary, but that's the style I've been doing all this time.

# Day 19: Aplenty

Solved Part 1 in the most stupid way I could think of, somehow creating actual functions from the input
and storing them in a map, to actually call them. Learned a lot about funktional programming this way
and the code ist fast! Still working on part 2, though...

# Day 20: Pulse Propagation

Solved Part 1 naively, actually simulating the pulses between the modules. Learned a lot about the use of interfaces vs
abstract classes. For part 2, this is not enough. You actually need to look at the input and realize that these are
binary counters. Each conjunction at the output represents a binary number, with the input Flip-Flops as bits. Counting
number of button presses it takes, to make the value overflow is the solution. Just LCM the numbers together.

# Day 21: Step Counter

Part 1 could *almost* be solved by painting a big diamond, and excluding all unreachable tiles, but not quite. So simple
BFS did it again.

# Day 22: Sand Slabs

Another memory to last years Day 17...