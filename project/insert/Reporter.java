import java.util.*;

public class Reporter implements Visitor { // 1
    public void visitNode(Node node) { // 2
        Displaux displaux = this.displaux(node);
        for (String line : displaux.lines)
            System.out.println( line );
    } // 1
    public Displaux displaux(Node node) { // 2
        if (node.right == null && node.left == null) { // 3
            String line = (node.color == Node.RED) ? "[" + node.key + "]" : node.key + "";
            int width = line.length();
            int height = 1;
            int middle = width / 2;
            ArrayList<String> lines = new ArrayList<String>();
            lines.add(line);
            return new Displaux( lines, width, height, middle );
        } // 2
        if (node.right == null) { // 3
            Displaux result = this.displaux(node.left);
            ArrayList<String> lines = result.lines;
            int n = result.width;
            int p = result.height;
            int x = result.middle;
            String s = (node.color == Node.RED) ? "[" + node.key + "]" : node.key + "";
            int u = s.length();
            String firstLine = f(x + 1, ' ') + f(n - x - 1, '_') + s;
            String secondLine = f(x, ' ') + "/" + f(n - x - 1 + u, ' ');
            ArrayList<String> shiftedLines = new ArrayList<String>();
            for (String line : lines)
                shiftedLines.add(line + f(u, ' '));
            shiftedLines.add(0, secondLine);
            shiftedLines.add(0, firstLine);
            return new Displaux(shiftedLines, n + u, p + 2, n + u / 2);
        } // 2
        // Only right child.
        if (node.left == null) { // 3
            Displaux result = this.displaux(node.right);
            ArrayList<String> lines = result.lines;
            int n = result.width;
            int p = result.height;
            int x = result.middle;
            String s = (node.color == Node.RED) ? "[" + node.key + "]" : node.key + "";
            int u = s.length();
            String firstLine = s + f(x, '_') + f(n - x, ' ');
            String secondLine = f(u + x, ' ') + "\\" + f(n - x - 1, ' ');
            ArrayList<String> shiftedLines = new ArrayList<String>();
            for (String line : lines)
                shiftedLines.add(f(u, ' ') + line);
            shiftedLines.add(0, secondLine);
            shiftedLines.add(0, firstLine);
            return new Displaux(shiftedLines, n + u, p + 2, u / 2);
        } // 2
        // Two children.
        Displaux result = this.displaux(node.left);
        ArrayList<String> left = result.lines;
        int n = result.width;
        int p = result.height;
        int x = result.middle;
        result = this.displaux(node.right);
        ArrayList<String> right = result.lines;
        int m = result.width;
        int q = result.height;
        int y = result.middle;
        String s = (node.color == Node.RED) ? "[" + node.key + "]" : node.key + "";
        int u = s.length();

        String firstLine = f(x + 1, ' ') + f(n - x - 1, '_') + s + f(y, '_') + f(m - y, ' ');
        String secondLine = f(x, ' ') + "/" + f(n - x - 1 + u + y, ' ') + "\\" + f(m - y - 1, ' ');

        if (p < q) { // 3
            for (int i = 0; i < q - p; i++)
                left.add(f(n, ' '));
        } else if (q < p) { // 3
            for (int i = 0; i < p - q; i++)
                right.add(f(m, ' '));
        } // 2

        ArrayList<String> lines = new ArrayList<String>();
        for (int count = 0; count < Math.min(left.size(), right.size()); count++)
            lines.add( left.get(count) + f(u, ' ') + right.get(count) );
        lines.add(0, secondLine);
        lines.add(0, firstLine);
        return new Displaux(lines, n + m + u, Math.max(p, q) + 2, n + u / 2);
    } // 1
    public String f(int length, char c) { // 2
        return new String(new char[length]).replace('\0', c);
    } // 1
    public ArrayList<String> g(int length, String s) { // 2
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < length; i++) { // 3
          result.add(s);
        } // 2
        return result;
    } // 1
} // 0
