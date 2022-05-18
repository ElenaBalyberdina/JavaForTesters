public class Human implements Competitor {

    private String name;

    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;

    private boolean active;

    public Human(String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        this.name = name;
        this.active = true;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }


    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    @Override
    public void run(int dist) {
        if (dist <= getMaxRunDistance()) {
            System.out.println(getName() + " successfully ran");
        } else {
            System.out.println(getName() + " failed ran");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= getMaxSwimDistance()) {
            System.out.println(getName() + " successfully swam");
        } else {
            System.out.println(name + " failed swimming");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= getMaxJumpHeight()) {
            System.out.println(getName() + " successfully jump");
        } else {
            System.out.println(getName() + " failed jump");
            active = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(getName() + " " + active);
    }
}

