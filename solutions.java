
public class solutions {
	public boolean halvesAreAlike(String s) {
        var vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int a = 0, b = 0;
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            a += vowels.contains(s.charAt(i)) ? 1 : 0;
            b += vowels.contains(s.charAt(j)) ? 1 : 0;
        }
        return a == b;
    }
	public char findTheDifference(String s, String t) {
        int charCode = t.charAt(s.length());
        for (int i = 0; i < s.length(); ++i) {
              charCode -= (int)s.charAt(i);
              charCode += (int)t.charAt(i); 
        }
        return (char)charCode;
    }
	public int dayOfYear(String date) {
        int result = 0;
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1])-1;
        int day = Integer.parseInt(parts[2]);
        while (month > 0) {
            if (month == 12 || month == 10 || month == 8) {
                result += 31;
            }
            else if (month == 11 || month == 9) {
                result += 30;
            }
            else if (month == 2) {
                if (year%4 == 0 && year%100 != 0) {
                    result += 29;
                }
                else {
                    result += 28;
                }
            }
            else if (month%2 == 0) {
                result += 30;
            }
            else if (month%2 != 0) {
                result += 31;
            }
            month--;
        }
        result += day;
        return result;
    }
	public int romanToInt(String s) {
        int sum=0;
        if (s.indexOf("IV")!=-1) {
            sum-=2;
        }
        if (s.indexOf("IX")!=-1) {
            sum-=2;
        }
        if (s.indexOf("XL")!=-1) {
            sum-=20;
        }
        if (s.indexOf("XC")!=-1) {
            sum-=20;
        }
        if (s.indexOf("CD")!=-1) {
            sum-=200;
        }
        if (s.indexOf("CM")!=-1) {
            sum-=200;
        }

        char c[] = s.toCharArray();
        int count=0;

        for(;count<=s.length()-1;count++){
           if(c[count]=='M') sum+=1000;
           if(c[count]=='D') sum+=500;
           if(c[count]=='C') sum+=100;
           if(c[count]=='L') sum+=50;
           if(c[count]=='X') sum+=10;
           if(c[count]=='V') sum+=5;
           if(c[count]=='I') sum+=1;

        }
        return sum;
    }
	public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
	public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
	public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            }
            else {
                ans += sumOfLeftLeaves(root.left);
            }
        }
        ans += sumOfLeftLeaves(root.right);

        return ans;
    }
	public ListNode middleNode(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        length = length/2;
        while (length > 0) {
            head = head.next;
            length--;
        }
        return head;
    }
}
