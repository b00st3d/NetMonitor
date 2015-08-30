package NetMon;

/**
 * @author Daniel
 */
public class NetMon {

    public static void main(String[] args) {
        SysTray tray = new SysTray();
        MainLoop main = new MainLoop();
        Daemon daemon = new Daemon();

        daemon.init(main);
        tray.init(main, daemon);

        ReturningValues rv = Daemon.userInput();  //get start values for user input.

        tray.buildIcon(rv.getRemoteHost());
        daemon.start(rv.getRemoteHost());
    }

    public static void timeout(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
    }
}
