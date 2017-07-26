	/**
3.	 * 题目：在m行n列的方格中，一个机器人从(0,0)开始移动，每一次可以向左、向右、向上、向下移动一格，
4.	 *     但不能进入行坐标和列坐标的数位之和大于k的格子。
5.	 *     如，k为18时，可进入(35,37)，因为3+5+3+7=18。
6.	 *     不能进入(35,38)，因为3+5+3+8=19>18。
7.	 *     求该机器人能够到达多少个格子？
8.	 * 备注：
9.	 * 	         机器人不能进入行坐标和列坐标的数位之和大于k的格子，意味着不能通过，后面即使有行坐标和列坐标的数位之和大于k的格子,也可能无法访问！
10.	 *     （图1）以下为当threshold为9,rows为15，cols为15的情况下，机器人可以到达的格子的情况！
11.	 *      对比（图2），可以看到因为机器人无法通过行坐标和列坐标的数位之和大于k的格子，导致了右下角部分不能到达！！
12.			+ + + + + + + + + + + + + + + 
13.			+ + + + + + + + + - + + + + + 
14.			+ + + + + + + + - - + + + + + 
15.			+ + + + + + + - - - + + + + + 
16.			+ + + + + + - - - - + + + + + 
17.			+ + + + + - - - - - + + + + - 
18.			+ + + + - - - - - - + + + - - 
19.			+ + + - - - - - - - + + - - - 
20.			+ + - - - - - - - - + - - - - 
21.			+ - - - - - - - - - - - - - - 
22.			+ + + + + + + + + - - - - - - 
23.			+ + + + + + + + - - - - - - - 
24.			+ + + + + + + - - - - - - - - 
25.			+ + + + + + - - - - - - - - - 
26.			+ + + + + - - - - - - - - - -
27.			（图2）以下为当threshold为9,rows为15，cols为15的情况下，行坐标和列坐标的数位之和<=threshold的情况！
28.			+ + + + + + + + + + + + + + + 
29.			+ + + + + + + + + - + + + + + 
30.			+ + + + + + + + - - + + + + + 
31.			+ + + + + + + - - - + + + + + 
32.			+ + + + + + - - - - + + + + + 
33.			+ + + + + - - - - - + + + + - 
34.			+ + + + - - - - - - + + + - - 
35.			+ + + - - - - - - - + + - - - 
36.			+ + - - - - - - - - + - - - - 
37.			+ - - - - - - - - - - - - - - 
38.			+ + + + + + + + + - + + + + + 
39.			+ + + + + + + + - - + + + + + 
40.			+ + + + + + + - - - + + + + + 
41.			+ + + + + + - - - - + + + + + 
42.			+ + + + + - - - - - + + + + - 
43.	 */


public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] visited = new int[rows][cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }
    
    public int movingCountCore(int k, int rows, int cols, int i, int j, int[][] visited){
        if(i < 0 || i >= rows || j < 0 || j >= cols || digitSum(i) + digitSum(j) > k || visited[i][j] == 1)
            return 0;
        visited[i][j] = 1;
        return movingCountCore(k, rows, cols, i + 1, j, visited)
            + movingCountCore(k, rows, cols, i - 1, j, visited)
            + movingCountCore(k, rows, cols, i, j + 1, visited)
            + movingCountCore(k, rows, cols, i, j - 1, visited)
            + 1;
    }
    
    public int digitSum(int a){
        int sum = 0;
        while(a != 0){
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
    
}