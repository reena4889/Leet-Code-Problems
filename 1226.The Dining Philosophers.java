import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    private Semaphore[] forks;

    public DiningPhilosophers() {
        forks = new Semaphore[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // Prevent deadlock by controlling fork acquisition order
        if (philosopher % 2 == 0) {
            forks[leftFork]. acquire();
            forks[rightFork]. acquire();
        } else {
            forks[rightFork]. acquire();
            forks[leftFork]. acquire();
        }

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putRightFork.run();
        putLeftFork.run();

        forks[leftFork].release();
        forks[rightFork].release();
    }
}
