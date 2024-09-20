public class StopWatch {
  private long start;
  private long stop;
  private boolean running = false;

  /*public StopWatch(boolean running) {
    this.running = false;
  }*/

  public void startTime() {
    start = System.currentTimeMillis();
    running = true;
    System.out.println("The timer has started");
  }

  public void stopTime() {
    stop = System.currentTimeMillis();
    running = false;
    long elapsedMilli = stop - start;
    long elapsed = elapsedMilli / 60000;
    double bill = elapsed * 2.11;
    System.out.println("The timer has stopped");
    System.out.println("The elapsed time is " + elapsed + " minutes");
    System.out.println("The bill is $" + bill);
  }
}