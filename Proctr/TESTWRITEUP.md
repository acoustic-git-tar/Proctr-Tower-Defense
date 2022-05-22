# Test Writeup

## Kewal Kalsi
### testPlayerStartingMoney()
This test confirms that the player will start with a different
amount of money on all three of the difficulties. It does so
by initializing three different player objects, one for each 
of the three basic difficulties: Closed Notes, Open Notes, 
and Cheat sheet. The base starting money values for each of 
these difficulties should be initialized as follows:  

| Difficulty   | Starting Money |
|:------------:|:--------------:|
| Closed Notes |      500       |
| Cheat Sheet  |      400       |
| Open Notes   |      300       |     

Once initializing the players, it checks the easy level's 
starting money with the money of the other two difficulties
and repeats this process for the last two difficulties. If 
the test successfully finishes running, it means that all
three difficulties had different starting money values. This test shows 
that the starting money differs across all difficulties
### testPlayerStartingHealth()
This test confirms that the player will start with a different
amount of health(GPA) on all three difficulty levels. It does so
by initializing three different player objects, one for each
of the three basic difficulties: Closed Notes, Open Notes,
and Cheat sheet. The base health values for each of
these difficulties should be initialized as follows:

| Difficulty   | Starting Health |
|:------------:|:---------------:|
| Closed Notes |       2.0       |
| Cheat Sheet  |       3.0       |
| Open Notes   |       3.5       |     

Once initializing the players, it checks the easy level's
starting health with the health of the other two difficulties
and repeats this process for the last two difficulties. If
the test successfully finishes running, it means that all
three difficulties had different starting health values. This test shows
that the starting GPAs differ across all three difficulties.
## Ethan Tong 
### testLockdownBrowserPurchaseCost()
This test confirms that the Lockdown Brower tower costs differently
across all three difficulties. It does so by initializing three 
different Lockdown Brower tower objects, one for each of the 
difficulties. Purchase costs are as follows:

| Difficulty   | Purchase Cost |
|:------------:|:-------------:|
| Closed Notes |       50      |
| Cheat Sheet  |       75      |
| Open Notes   |      100      |

Once initializing the towers, it compares the Closed Notes cost with 
the Cheat Sheet cost, the Cheat Sheet's cost with the Open Notes 
cost, and the Closed Notes cost with the Open Notes cost. Finally it 
verifies if each purchase cost matches the values above. If the test 
finishes running, it means the tower increases in cost with 
difficulty.

### testBuzzcardPurchaseCost()
This test confirms that the Buzzcard tower costs differently across 
all three difficulties. It does so by initializing three different 
Buzzcard tower objects, one for each of the difficulties. Purchase 
costs are as follows:

| Difficulty   | Purchase Cost |
|:------------:|:-------------:|
| Closed Notes |       60      |
| Cheat Sheet  |       80      |
| Open Notes   |      120      |

Once initializing the towers, it compares the Closed Notes cost with 
the Cheat Sheet cost, the Cheat Sheet's cost with the Open Notes 
cost, and the Closed Notes cost with the Open Notes cost. Finally it 
verifies if each purchase cost matches the values above. If the test 
finishes running, it means the tower increases in cost with 
difficulty.

### testTAPurchaseCost()
This test confirms that the TA tower costs differently across all 
three difficulties. It does so by initializing three different TA 
tower objects, one for each of the difficulties. Purchase costs are 
as follows:

| Difficulty   | Purchase Cost |
|:------------:|:-------------:|
| Closed Notes |      100      |
| Cheat Sheet  |      120      |
| Open Notes   |      150      |

Once initializing the towers, it compares the Closed Notes cost with 
the Cheat Sheet cost, the Cheat Sheet's cost with the Open Notes 
cost, and the Closed Notes cost with the Open Notes cost. Finally it 
verifies if each purchase cost matches the values above. If the test 
finishes running, it means the tower increases in cost with 
difficulty.

## Luke Walter 

### testLockdownBrowserPurchaseCost()
This test ensures that the sell cost for the Lockdown Browser
tower is set correctly for each difficulty level in the game.
Additionally, it checks if each sell cost is lower than the
respective purchase cost and if the sell costs are set correctly
relatively to each other.

| Difficulty | Sell Cost |
|:----------:|:---------:|
| Easy       | 40        |
| Medium     | 60        |
| Hard       | 50        |

### testBuzzcardPurchaseCost()
This test ensures that the sell cost for the Buzzcard
tower is set correctly for each difficulty level in the game.
Additionally, it checks if each sell cost is lower than the
respective purchase cost and if the sell costs are set correctly
relatively to each other.

| Difficulty | Sell Cost |
|:----------:|:---------:|
| Easy       | 50        |
| Medium     | 60        |
| Hard       | 80        |

### testTAPurchaseCost()
This test ensures that the sell cost for the TA
tower is set correctly for each difficulty level in the game.
Additionally, it checks if each sell cost is lower than the
respective purchase cost and if the sell costs are set correctly
relatively to each other.

| Difficulty | Sell Cost |
|:----------:|:---------:|
| Easy       | 90        |
| Medium     | 100       |
| Hard       | 75        |


## Max Ho   
### testOutOfMoney()

This test tests the functionality of inability to purchase
towers when money is too low. Upon initializing the player "Joe Biden,"
Joe purchases enough towers to be rendered low on money. On the final purchase,
a handled IllegalArgument is thrown, showing that buying a tower will result in
an exception. The money count is as follows:
| Tower Purchase| Money Remaining |
|:------------:|:-------------:|
| Before        |     300      |
| Buzzcard      |      180     |
| TA            |      30      |
| Lockdown Bwsr. |      N/A      |

On the last iteration, purchasing a tower is impossible.
### testEarnMoney()

This test focuses on the preliminary next round functionality.
After purchasing a normal amount of towers and completing the next
round, the player should earn a set amount of income to be able to buy
more towers for the rounds to come. 
