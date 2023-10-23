import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
За многие годы заточения узник замка Иф проделал в стене прямоугольное отверстие размером D × E.
Замок Иф сложен из кирпичей, размером A × B × C.
Определите, сможет ли узник выбрасывать кирпичи в море через это отверстие, 
если стороны кирпича должны быть параллельны сторонам отверстия.
 */
public class PrisonerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sideA = Integer.parseInt(reader.readLine());
        int sideB = Integer.parseInt(reader.readLine());
        int sideC = Integer.parseInt(reader.readLine());
        int blockSideD = Integer.parseInt(reader.readLine());
        int blockSideE = Integer.parseInt(reader.readLine());
        Side a = new Side(sideA);
        Side b = new Side(sideB);
        Side c = new Side(sideC);
        a.next = b;
        a.previous = c;
        b.next = c;
        b.previous = a;
        c.next = a;
        c.previous = b;
        Side temp = a;
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            if (blockSideD >= temp.getValue()) {
                if (blockSideE >= temp.next.getValue() ||
                        blockSideE >= temp.previous.getValue()) {
                    flag = true;
                }
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static class Side {
        int value;
        Side next;
        Side previous;

        public Side(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
