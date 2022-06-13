public class Team {

    String nameTeam;

    Competitor[] partner = new Competitor[4];

    // Формируем команду
    public Team(String nameTeam, Competitor com1, Competitor com2, Competitor com3, Competitor com4) {
        this.nameTeam = nameTeam;

        partner[0] = com1;
        partner[1] = com2;
        partner[2] = com3;
        partner[3] = com4;

    }

    // Вывод информации кто прошел дистанцию
    public void passedTheDistance() {
        for (Competitor com : partner) {
            // Если участник onDistance == true, выводим его
            if (com.isOnDistance()) {
                com.info();
            }
        }
    }

    // Вывод информации о членах команды
    public void showResults() {
        for (Competitor com : partner) {
            com.info();
        }
    }

    // геттер участников команды
    public Competitor[] getTeammates() {
        return partner;
    }
}