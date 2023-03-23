package OOP;

import java.util.Arrays;

class Main {

  public static void main(String[] args) {
    Enemy enemy = new Enemy();
    Vampire vampire = new Vampire();
    Werewolf werewolf = new Werewolf();


    //Abstract:
    enemy.talk();
    enemy.noise();

    //Inheritance:
    System.out.println(" ");
    vampire.noise();
    werewolf.noise();


    // encapsulation
    System.out.println(" ");
    System.out.println("enemy health: " + enemy.getHealth());
    System.out.println("vampire health: " + vampire.getHealth());
    werewolf.setHealth(20);
    System.out.println("werewolf health: " + werewolf.getHealth());


    //polymorphism:
    System.out.println(" ");
    vampire.talk();
    werewolf.talk();

    System.out.println("Array: ");
    Enemy enemyVampire = new Vampire();
    Enemy[] enemies = new Enemy[] {enemy, vampire, werewolf, enemyVampire};
    Arrays.stream(enemies).forEach(Enemy::talk);


  }
}
