import java.util.Date;

public class Playing {
    public static void main(String[] args) {
        Thread violin =new Thread(new Violin("Player"));
        violin.start();
    }

    public static class Violin implements MusicalInstrument{
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " starts playing");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " stop playing");
            return new Date();
        }

        @Override
        public void run() {
            Date x = startPlaying();
            sleepNSeconds(1);
            Date y = stopPlaying();
            System.out.println("Playing "+(y.getTime()-x.getTime())+" ms");
        }
    }

    public static int delay = 1000;

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        public static interface MusicalInstrument extends Runnable {
            Date startPlaying();

            Date stopPlaying();

    }
}
