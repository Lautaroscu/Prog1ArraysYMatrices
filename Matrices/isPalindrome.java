
public class isPalindrome {
    public static void main(String[] args) {
        int[] head = { 1, 2, 1, 2, 2, 5, 2, 1, 2, 1 };
        System.out.println(isPalindrom(head));

    }

    public static boolean isPalindrom(int[] head) {
        for (int i = 0; i < head.length / 2; i++) {
            if (head[i] != head[head.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}