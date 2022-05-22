# Test Writeup for M5

## Kewal Kalsi

### testPlayerMoneyIncrease()   
This test creates a player, application instance, tower, and enemy instance. It
simulates a tower attacking the enemy, in this case a Spiral Notebook Enemy by 
attacking it once with a total damage of 1 over the notebook's final health. This
test then ensures that the enemy has died and the player that was created has received
his hard earned money. 

### testEnemyDeactivate  
Upon the creation and defeat of enemies, they must be both activated and deactivated. While
these enemies have tasks they complete on activation and deactivation, this test ensures that
the activation and deactivation process is done correctly. It does so by creating an instance of a player and 
enemy class. If the enemy is then properly activated and deactivated, the test passes. 

## Ethan Tong

### testMoveSpeed()
This test compares the movement speeds of all enemy types, regardless of 
difficulty. The weakest enemy, the spiral notebook, has the fastest movement 
speed while the stronget enemy, the Chegg boss, has the slowest movement 
speed. Movement speed should decrease with enemy strength in this order: 
SpiralNotebook, Textbook, GroupMe, KhanAcademy, StackOverflow, YouTube, 
Chegg.

Once initializing the enemies, SpiralNotebook speed is compared with 
Textbook speed, then Textbook speed is compared with GroupMe speed, then 
GroupMe speed is compared with KhanAcademy speed, then KhanAcademy speed 
is compared with StackOverflow speed, then StackOverflow speed is compared 
with YouTube, then YouTube speed is compared with Chegg speed. If the test 
finishes running, then movement speed decreases with successive enemy.

### testLoseHealth()
This test confirms that all enemies lose health when they take damage. For 
simplicity's sake, a TA tower is used as the tower for attacking enemies, 
since all towers can attack.

Once initializing the enemies, each enemy's health before and after getting 
attacked is compared such that health before should be greater than health 
after. If the test finishes running, then all enemies can successfully lose 
health when they take damage.

## Max Ho

### testTowerFactory()
This test tests the behavior of the TowerFactory class, and its ability
to instantiate new objects of different types extending from the Tower
class. Three towers are made using the TowerFactory.createTower() method,
with parameters of different tower types. These classes should be different.

Upon initializing the towers, the classes are compared to the object name
to make sure they are different classes, and not generic Towers. The test
is successful if different unique objects are created.

### testEnemyDamage()
This test simulates a game that starts with a sample Chegg enemy damaging
the monument. Upon Chegg attacking Joe Biden, our sample player, the health
of the monument is compared to the health before the attack, and this is done
twice to assure robustness. If the test finishes, the attacks reducing the
monument health is successful, leading the losing condition to be able to
be satisfied.

## Luke Walter

### testEnemyFactory()
This test tests the behavior of the EnemyFactory class, and its ability
to instantiate new objects of different types extending from the Enemy
class. The test uses the factory to initialize every type of enemy and 
ensures that they are the correct ones. It also ensures that the method
for initializing an array of enemies is working properly by ensuring that
each index is the correct enemy variant as defined in the parameters.

### testPathFactory()
This test tests the behavior of the PathFactory class, and its ability
to instantiate a preset array of Vector2 objects. Each preset is tested
against a test array containing the correct values, where each 
individual index in the two arrays is compared to check for equality.
