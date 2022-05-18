public class Main {

    public static void main(String[] args) {
        Course c = new Course(new Cross(30), new Water(3), new Wall(5));
        Team team = new Team("Team",
                new Human("Аня", 50, 3, 5),
                new Human("Петя", 75, 40, 17),
                new Human("Вася", 20, 7, 28),
                new Human("Ваня", 55, 45, 9));
        c.doIt(team);

        System.out.println("Выиграли: ");
        team.passedTheDistance();

        System.out.println("\nРезультаты: ");
        team.showResults();
    }
}