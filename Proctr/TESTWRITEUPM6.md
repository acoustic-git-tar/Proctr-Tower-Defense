# Test Writeup for M5

## Kewal Kalsi

### testNoChangeInDPS()       
This test creates an instance of all three tower types. It then applies both a damage and range
upgrade to each tower. After applying each upgrade, there is a check to see if the actual dps 
value has changed. Only the physical damage and range should change. Therefore, this test ensures
that after upgrading the tower, the tower damage and range changes but not the dps (The dps in
this case is not the damage of the tower, but rather the rate at which it attacks).

### testProperLevelIncrease()    
This test creates an instance of all three tower types and applies both upgrade types to 
each tower. Once an upgrade is applied to a tower, no matter the upgrade, the level should increase
by one. This test checks that, after an upgrade is applied, the level is increased properly to ensure
proper tracking of data for each tower. 

## Ethan Tong

### testSellCostUpgradeWithRange()
This test creates an instance of all three tower types and applies a range upgrade to each tower. Once an 
upgrade is applied to a tower, each tower should have an increased sell cost than before. The test compares 
each tower's sell cost before with the sell cost after.

### testSellCostUpgradeWithDamage()
This test creates an instance of all three tower types and applies a damage upgrade to each tower. Once an 
upgrade is applied to a tower, each tower should have an increased sell cost than before. The test compares 
each tower's sell cost before with the sell cost after.

## Max Ho

### testUpgradeMoneyCost()
This test simulates the player upgrading the towers 5 times, and tracking the amount of money decreased.
When the player upgrades a tower in the application, money is deducted from their balance in order to show 
as payment. This is simulated through deducting money for a simple test instead of showing a tower to 
click. Once the upgrades are applied, the final money the player has is then compared to the initial amount. 


### testBossHealthSuperiority() 
This test shows that the boss tower, Chegg, is separate from the others. The test first creates multiple 
different enemies and then compares all of their healths to the Chegg enemy, which is our final boss.
The expected output is that all enemies have a lower health pool than the final boss does, signifying that
the final boss is much harder to defeat than any other one of the enemies.


## Luke Walter

### testRangeUpgrade()    
This test creates an instance of all three tower types and applies a range upgrade to each tower. After a 
range upgrade is applied to a tower, the range should increase. The test checks that the tower does in fact
have its range increased after each upgrade. Therefore, this test enforces that the range upgrade is functional
and properly increases the range. 

### testDamageUpgrade()    
This test creates an instance of all three tower types and applies a damage upgrade to each tower. After a 
damage upgrade is applied to a tower, the damage should increase, but the dps(speed at which the tower attacks)
should stay the same. The test checks that the damage does increase. Therefore, this test enforces that the damage 
upgrade does work and the damage of each tower does increase properly.
