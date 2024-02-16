class Horse {
  String name;
  Horse(String name) {
    this.name = name;
  }
  void talk() {
    System.out.println("Howdy, I am " + this.name); 
  }
}

class Unicorn extends Horse {
  Unicorn(String name) {
    super(name); 
    super.talk();
  }
  void talk() {
    System.out.println("Bonjour... je m'appelle " + this.name); 
  }
  void sing() {
    System.out.println("La la la..."); 
  }
}

class Program {
  public static void main(String[] args) {
    Horse a = new Horse("Leslie"); 
    Horse b = new Unicorn("Alex"); // Howdy I am Alex
    a.talk(); // Howdy I am Leslie
    b.talk(); // French greeting Alex
    // b.sing(); 
  } 
}
