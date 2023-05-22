import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String text = "(– b + (b2 – 4*a*c)^0.5) / 2*a     ";
        int len = text.length();
        int symLeft = 0, symRight = 0;
        int count = 0;
        Stack stack = new Stack<>();
        Stack symStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            stack.push(text.charAt(i));
        }
        for (int i = 0; i < len; i++) {
            if (stack.get(i).toString().equals("(")) {
                symStack.push("(");
                symLeft += 1;
            } else if (stack.get(i).toString().equals(")")) {
                symStack.push(")");
                symRight += 1;
            }
        }
        if (symLeft != symRight) {
            System.out.println("No Well");
        } else {
            int i = 0;
            while (symStack.size() != 0) {
                if (!symStack.get(i).equals(symStack.get(i + 1))) {
                    symLeft -= 1;
                    symRight -= 1;
                        symStack.remove(i);
                        symStack.remove(i);
                    i = 0;
                    continue;
                }
                i++;
            }

            if (symLeft == 0) {
                System.out.println("Well");
            } else {
                System.out.println("No Well");
            }
        }

    }
}