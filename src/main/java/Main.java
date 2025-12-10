import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Set<String> builtins = Set.of("exit", "echo", "type");

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+");
            String command = parts[0];

            if (command.equals("exit")) {
                break;
            }

            else if (command.equals("echo")) {
                if (parts.length == 1) {
                    System.out.println("");
                } else {
                    System.out.println(input.substring(5));
                }
            }

            else if (command.equals("type")) {
                if (parts.length == 1) {
                    System.out.println("");
                } else {
                    String target = parts[1];
                    if (builtins.contains(target)) {
                        System.out.println(target + " is a shell builtin");
                    } else {
                        System.out.println(target + ": not found");
                    }
                }
            }

            else {
                System.out.println(command + ": command not found");
            }
        }
    }
}
