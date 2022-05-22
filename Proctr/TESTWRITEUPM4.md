# Test Writeup for M4

## Kewal Kalsi

### testEnemyMoveDuration
This test ensures that the three currently implemented anemies all
have a differing move speed. It does so by initializing the three types
of enemies and assigning their move speeds to respective variables. The
current expected values are as follows: 

|      Enemy      | Move Speed Timer |
|:---------------:|:----------------:|
| Spiral Notebook |      15000       |
|    Textbook     |      20000       |
|     GroupMe     |      30000       |



Then, the test compares each move speed timer with the times of the other two. 
If all of these comparisons return true, meaning that all move speed timers
are different, then the test has succesfully been completed.

### testGameOver
This test tests the monument health if it would be repeatedly struck by an enemy
object. It begins by creating a single groupMe enemy object, and repeatedly calls
the attack monument function while the value the GPA is less than a 4.0 
(meanning the game is still running). While the game is running, the called function
should always return true, so the test is calling that. Once the game ends, and the 
continueGame function is called, then the test correctly checks if the proper
error of ExceptionInInitializerError is thrown. If so, the test has succesfully ran.

## Ethan Tong

### testSpiralNotebookDamage()
This test confirms the Spiral Notebook enemy deals increasing damage across
increasing difficulty. It does so by initializing three different Spiral
Notebook enemy objects, one for each of the three difficulties. Damage
numbers are as follows:

| Difficulty   | Damage |
|:------------:|:------:|
| Closed Notes |   0.1  |
| Cheat Sheet  |  0.12  |
| Open Notes   |  0.14  |

Once initializing the enemies, it compares the Closed Notes damage with the
Cheat Sheet damage, the Cheat Sheet damage with the Open Notes damage, and 
the Closed Notes damage with the Open Notes damage. Finally it verifies if 
each damage number matches the values above. If the test finishes running,
it means the enemy increases in damage with difficulty.

### testTextbookDamage()
This test confirms the Textbook enemy deals increasing damage across
increasing difficulty. It does so by initializing three different Textbook
enemy objects, one for each of the three difficulties. Damage
numbers are as follows:

| Difficulty   | Damage |
|:------------:|:------:|
| Closed Notes |  0.15  |
| Cheat Sheet  |  0.18  |
| Open Notes   |  0.21  |

Once initializing the enemies, it compares the Closed Notes damage with the
Cheat Sheet damage, the Cheat Sheet damage with the Open Notes damage, and 
the Closed Notes damage with the Open Notes damage. Finally it verifies if 
each damage number matches the values above. If the test finishes running,
it means the enemy increases in damage with difficulty.

## Max Ho
### testSpiralNotebookHealth()

This tests the different variations of spiral notebook health as scaling with difficulty.
The test method gets the values of the health per difficulty and compares each of the
enemies across each difficulty, checking if they are not equal, and if the
health of closed notes < cheat sheet < open notes.
The health values for spiral notebooks are as follows:

| Difficulty    |     Health     |
| :----------:  | :------------: |
| Closed Notes  |       10       |
| Cheat Sheet   |       15       |
| Open Notes    |       20       |



### testTextbookHealth()

This tests the different variations of textbook health as scaling with difficulty.
The test method gets the values of the health per difficulty and compares each of the
enemies across each difficulty, checking if they are not equal, and if the
health of closed notes < cheat sheet < open notes.
The health values for spiral notebooks are as follows:

| Difficulty    |     Health     |
| :----------:  | :------------: |
| Closed Notes  |       20       |
| Cheat Sheet   |       30       |
| Open Notes    |       40       |

## Luke Walter

### testGroupMeDamage()
This test confirms that the damage values for the GroupMe enemy are set 
correctly. It checks that GroupMe enemies deal increasing damage across 
increasing difficulty by initializing a GroupMe enemy object for each 
difficulty level. This test ensures that the game is balanced in such a
way that enemies will kill the monument faster on higher difficulties.

| Difficulty   | Damage |
|:------------:|:------:|
| Closed Notes |  0.20  |
| Cheat Sheet  |  0.24  |
| Open Notes   |  0.28  |

### testGroupMeHealth()
This test confirms that the health values for the GroupMe enemy are set
correctly. It checks that GroupMe enemies have increasing health across
increasing difficulty by initializing a GroupMe enemy object for each
difficulty level. This test ensures that the game is balanced in such a
way that enemies will survive longer on higher difficulties.

| Difficulty   | Health |
|:------------:|:------:|
| Closed Notes |   30   |
| Cheat Sheet  |   45   |
| Open Notes   |   60   |