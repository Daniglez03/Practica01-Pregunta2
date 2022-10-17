import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();
        ArrayList<Process> lista = new ArrayList<>();
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("notepad.exe");

        try {
            Process process = null;

            for (int i = 0; i < entrada; i++) {
                process = pb.start();
                System.out.println("Hora inicio de proceso "+(i+1)+" : " + LocalTime.now());
                lista.add(process);
            }
            process.waitFor(500, TimeUnit.MILLISECONDS);
            for (int i = 0; i < lista.size(); i++) {
                Process process1 = lista.get(i);
                process1.destroyForcibly();
                System.out.println("Hora de finalización de proceso "+(i+1)+" : " + LocalTime.now());
            }
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
