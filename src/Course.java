public class Course {
    Barrier[] course = new Barrier[3];


    public Course(Barrier b1, Barrier b2, Barrier b3) {
        course[0] = b1;
        course[1] = b2;
        course[2] = b3;
    }


    public void doIt(Team t) {
        System.out.println("\nTeam \"" + t.nameTeam + "\":\n");

        for (Competitor com : t.getTeammates()) {

            for (Barrier b : course) {
                b.doIt(com);
            }
        }
    }
}