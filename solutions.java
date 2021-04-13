
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
	public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }
	public int tribonacci(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 1, d;
        while (n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
	public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int boxes = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                boxes += box[0] * box[1];
                truckSize -= box[0];
            }else {
                boxes += truckSize * box[1];
                return boxes;
            }
        }
        return boxes;
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int remainder = numBottles % numExchange;
            numBottles /= numExchange;
            ans += numBottles;
            numBottles += remainder;
        }
        return ans;
    }
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        for (int i=0; i<=nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    return Count(board, i, j);
                }
            }
        }
        return 0;
    }
    public int Count(char[][] board, int row, int col) {
        int res = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d: directions) {
            for (int i = row, j = col; i >= 0 && i < 8 && j >= 0 && j < 8; i = i + d[0], j = j + d[1]) {
                if (board[i][j] == 'p') {
                    res++;
                    break;
                } else if (board[i][j] == 'B') {
                    break;
                }
            }
        }
        return res;
    }
    public String tictactoe(int[][] moves) {
        int[][] row = new int[2][3], col = new int[2][3];
        int[] d1 = new int[2], d2 = new int[2];
        for (int i = 0; i < moves.length; ++i) {
            int r = moves[i][0], c = moves[i][1], id = i % 2;
            if (++row[id][r] == 3 || ++col[id][c] == 3 || r == c && ++d1[id] == 3 || r + c == 2 && ++d2[id] == 3) 
                return id == 0 ? "A" : "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";        
    }
    public int maxProduct(int[] nums) {
        int max = 0;
        int a = 0;
        int b = 0;
        for (int i=0; i<nums.length; i++) {
            a = nums[i]-1;
            for (int j=0; j<nums.length; j++) {
                if (i != j) {
                    b = nums[j]-1;
                    max = Math.max(max, a*b);
                }
            }
        }
        return max;
    }
    public int numDifferentIntegers(String word) {
        String[] arr= word.split("\\D");
        Set<String> s = new HashSet<>();
        for(String str:arr){
            str=str.trim();
            if(!str.equals("")){
                str = str.replaceAll("^0*","");
                s.add(str);
            }
        }
        return s.size();
    }
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
            p1--;
            p2--;    
        }
        
        if (carry != 0)
            res.append(carry);
        
        return res.reverse().toString();
    }
}
