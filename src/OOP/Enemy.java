package OOP;

class Enemy {
  private int health;

  void talk() {
    System.out.println("I am your enemy");
  }

  void noise() {
    System.out.println("I am an Enemy and make many noises");
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int newHelth) {
    health = newHelth;
  }
}
