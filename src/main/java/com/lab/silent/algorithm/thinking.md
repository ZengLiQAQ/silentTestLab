算法一：分治法
基本概念
1.把一个复杂的问题分成两个或更多的相同或相似的子问题，再把子问题分成更小的子问题……直到最后子问题可以简单的直接求解，原问题的解即子问题的解的合并。

2.分治策略是对于一个规模为n的问题，若该问题可以容易地解决（比如说规模n较小）则直接解决，否则将其分解为k个规模较小的子问题，这些子问题互相独立且与原问题形式相同，递归地解这些子问题，然后将各子问题的解合并得到原问题的解。
适用情况
1)该问题的规模缩小到一定的程度就可以容易地解决

2)该问题可以分解为若干个规模较小的相同问题，即该问题具有最优子结构性质。

3)利用该问题分解出的子问题的解可以合并为该问题的解；

4) 该问题所分解出的各个子问题是相互独立的，即子问题之间不包含公共的子子问题。
分治法的复杂性分析
一个分治法将规模为n的问题分成k个规模为n／m的子问题去解。设分解阀值n0=1，且adhoc解规模为1的问题耗费1个单位时间。再设将原问题分解为k个子问题以及用merge将k个子问题的解合并为原问题的解需用f(n)个单位时间。用T(n)表示该分治法解规模为|P|=n的问题所需的计算时间，则有：

T（n）= k T(n/m)+f(n)

通过迭代法求得方程的解：

递归方程及其解只给出n等于m的方幂时T(n)的值，但是如果认为T(n)足够平滑，那么由n等于m的方幂时T(n)的值可以估计T(n)的增长速度。通常假定T(n)是单调上升的，从而当                  mi≤n<mi+1时，T(mi)≤T(n)<T(mi+1)。
分治法例题：合并排序和快速排序
public class 分治_合并排序 {
	/**
	 * 函数说明：在数组被拆分以后进行合并
	 */
	static void Merge(int a[], int left, int middle, int rigth) {
		//定义左端数组大小
		int n1 = middle - left+1;
		int n2 = rigth - middle;
		
		//初始化数组，分配内存
		int bejin[] = new int[n1];
		int end[] = new int[n2];
		
		//数组赋值
		for(int i = 0; i < n1; i++)
			bejin[i] = a[left + i];
			
		for(int i = 0; i < n2; i++) 
			end[i] = a[middle+1+i];
		
		//用key做原数组索引，没调用一次函数重新给原数组付一次值
		int i = 0, j = 0, key;
		for(key = left; key <= rigth; key++){
			
			if(n1>i&&n2>j&&i < n1 && bejin[i] <= end[j])
				a[key] = bejin[i++];
			else if(n1>i&&n2>j&&j < n2 && bejin[i] >= end[j])
				a[key] = end[j++];	
			else if(i == n1 && j < n2)
				a[key] = end[j++];
			else if(j == n2 && i < n1)
				a[key] = bejin[i++];	
		}
	}
	/**
	 * 差分数组区间，不断分支
	 */
	static void MergeSort(int a[],int left,int rigth) {
		int middle=0;
		if(left<rigth) {
			middle =(rigth+left)/2;
			MergeSort(a, left, middle);
			MergeSort(a, middle+1, rigth);
			Merge(a, left, middle, rigth);
		}
	}
	public static void main(String[] args) {
		int a[]= {85,3,52,9,7,1,5,4};
		MergeSort(a, 0,7); 
		for(int i=0;i<8;i++) {
			System.out.print(" "+a[i]);
		}
		
	}
}

public class 分治_快速排序 {
	/**
	 *交换函数，i，j为数组索引
	 */
	static void swap(int A[], int i, int j)
	{
	    int temp = A[i];
	    A[i] = A[j];
	    A[j] = temp;
	}
	/**
	 * 选取一个关键字(key)作为枢轴，一般取整组记录的第一个数/最后一个，这里采用选取序列最后一个数为枢轴。
	 * 设置两个变量left = 0;right = N - 1;
	 * 从left一直向后走，直到找到一个大于key的值，right从后至前，直至找到一个小于key的值，然后交换这两个数。
	 * 重复第三步，一直往后找，直到left和right相遇，这时将key放置left的位置即可。
	 * @return
	 */
	static int PartSort(int[] array,int left,int right)
	{
	    int key = array[right];//定义基准 
	    int count=right;//保存rigth值
	    while(left < right)//防止数组越界
	    {
	        while(left < right && array[left] <= key)
	        {
	            ++left;
	        }
	        while(left < right && array[right] >= key)
	        {
	            --right;
	        }
	        swap(array,left,right);
	    }
	    swap(array,right,count);
	    return right;
	}
	/**
	 *分治思想，递归调用
	 */
	static void QuickSort(int array[],int left,int right)
	{
	    if(left >= right)//表示已经完成一个组
	    {
	        return;
	    }
	    int index = PartSort(array,left,right);//枢轴的位置
	    QuickSort(array,left,index - 1);
	    QuickSort(array,index + 1,right);
	}
	public static void main(String[] args) {
		int a[]= {1,5,-5,54,15,67,16,23};
		QuickSort(a,0,7);
		for(int i=0;i<a.length;i++) {
			System.out.print(" "+a[i]);
		}
	    System.out.print("\n");
	}
}
算法心得
作为分治法里很典型的一种算法，合并排序和快速排序充分展现了分治法的思想，分而治之，在此次编程使用此方法中，给我的体会是程序简单分为两部分，第一部分，不断“拆”，缩小子问题规模，达到最优子结构。然后合并，在合并过程中，应为子问题足够小，容易计算，再者不断合并子问题答案，最终求出问题解。

算法二：贪心算法

一、基本概念：

所谓贪心算法是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的仅是在某种意义上的局部最优解。

贪心算法没有固定的算法框架，算法设计的关键是贪心策略的选择。必须注意的是，贪心算法不是对所有问题都能得到整体最优解，选择的贪心策略必须具备无后效性，即某个状态以后的过程不会影响以前的状态，只与当前状态有关。

所以对所采用的贪心策略一定要仔细分析其是否满足无后效性。

二、贪心算法的基本思路：

1.建立数学模型来描述问题。

2.把求解的问题分成若干个子问题。

3.对每一子问题求解，得到子问题的局部最优解。

4.把子问题的解局部最优解合成原来解问题的一个解。

三、贪心算法适用的问题

贪心策略适用的前提是：局部最优策略能导致产生全局最优解。

实际上，贪心算法适用的情况很少。一般，对一个问题分析是否适用于贪心算法，可以先选择该问题下的几个实际数据进行分析，就可做出判断。

四、贪心算法的实现框架

从问题的某一初始解出发；

while （能朝给定总目标前进一步）

{ 

利用可行的决策，求出可行解的一个解元素；

}

由所有解元素组合成问题的一个可行解； 

五、贪心策略的选择

因为用贪心算法只能通过解局部最优解的策略来达到全局最优解，因此，一定要注意判断问题是否适合采用贪心算法策略，找到的解是否一定是问题的最优解。
贪心策略例题：prim算法
import java.util.*;
public class 贪心算法_prim算法 {
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) {
		//定义无向图矩阵
		int[][] map = new int[][] {
				{ 0, 1, 6, 2},
				{ 1, 0, 3, 2},
				{ 6, 3, 0, 1},
				{ 2, 2, 1, 0}
				};
		prim(map, map.length);
	}
	public static void prim(int[][] graph, int n){
			//定义节点名字
	        char[] c = new char[]{'A','B','C','D'};        
	        int[] lowcost = new int[n];  //到新集合的最小权 
	        int[] mid= new int[n];//存取前驱结点
            List<Character> list=new ArrayList<Character>();//用来存储加入结点的顺序
	        int i, j, min, minid , sum = 0;
	        //初始化辅助数组
	        for(i=1;i<n;i++)
	        {
	        	lowcost[i]=graph[0][i];
	        	mid[i]=0;
	        }
	        list.add(c[0]);
            //一共需要加入n-1个点
	        for(i=1;i<n;i++)
	        {
	        	 min=MAX;
	        	 minid=0;
	        	 //每次找到距离集合最近的点
	        	 for(j=1;j<n;j++)
	        	 {
	        		 if(lowcost[j]!=0&&lowcost[j]<min)
	        		 {
	        			 min=lowcost[j];
	        			 minid=j;
	        		 }
	        	 }
	        	 if(minid==0) return;
	        	 list.add(c[minid]);
	        	 lowcost[minid]=0;
	        	 sum+=min;
	        	 System.out.println(c[mid[minid]] + "到" + c[minid] + " 权值：" + min);
	        	 //加入该点后，更新其它点到集合的距离
	        	 for(j=1;j<n;j++)
	        	 {
	        		 if(lowcost[j]!=0&&lowcost[j]>graph[minid][j])
	        		 {
	        			 lowcost[j]=graph[minid][j];
	        			 mid[j]=minid;	 
	        		 }
	        	 }
	        	 System.out.print("\n");
	        }
	        System.out.println("sum:" + sum);
	    }
}

算法心得
Prim算法是贪婪策略的一种很好的体现，在实现prim算法中，认识到，贪婪策略是在做当先选择的情况下，先行囊括所有的选择储存好，在根据贪婪策略，选出最符合的步骤进行下去。虽然贪婪策略比较迅捷，应为它不需要预算所有情况（类似回溯），但应为每次所求只是局部最优解，所以结果不一定是最优解，算法准确性在与贪婪策略的选取好坏，所以也具有一定的局限性！

算法三：动态规划算法

一、基本概念

    动态规划过程是：每次决策依赖于当前状态，又随即引起状态的转移。一个决策序列就是在变化的状态中产生出来的，所以，这种多阶段最优化决策解决问题的过程就称为动态规划。

二、基本思想与策略

    基本思想与分治法类似，也是将待求解的问题分解为若干个子问题（阶段），按顺序求解子阶段，前一子问题的解，为后一子问题的求解提供了有用的信息。在求解任一子问题时，列出各种可能的局部解，通过决策保留那些有可能达到最优的局部解，丢弃其他局部解。依次解决各子问题，最后一个子问题就是初始问题的解。

    由于动态规划解决的问题多数有重叠子问题这个特点，为减少重复计算，对每一个子问题只解一次，将其不同阶段的不同状态保存在一个二维数组中。

    与分治法最大的差别是：适合于用动态规划法求解的问题，经分解后得到的子问题往往不是互相独立的（即下一个子阶段的求解是建立在上一个子阶段的解的基础上，进行进一步的求解）。

三、适用的情况

能采用动态规划求解的问题的一般要具有3个性质：

    (1) 最优化原理：如果问题的最优解所包含的子问题的解也是最优的，就称该问题具有最优子结构，即满足最优化原理。

    (2) 无后效性：即某阶段状态一旦确定，就不受这个状态以后决策的影响。也就是说，某状态以后的过程不会影响以前的状态，只与当前状态有关。

   （3）有重叠子问题：即子问题之间是不独立的，一个子问题在下一阶段决策中可能被多次使用到。（该性质并不是动态规划适用的必要条件，但是如果没有这条性质，动态规划算法同其他算法相比就不具备优势）

三、算法实例：背包问题

public class 动态规划_背包问题 {
public static void main(String[] args) {
	//物品价值,重量,和背包承重
	int v[]={0,8,10,6,3,7,2};
	int w[]={0,4,6,2,2,5,1};
	int c=12;
	
	//定义二位数组动态规划背包价值和重量
	int m[][]=new int[v.length][c+1];
	for (int i = 1; i <v.length; i++) {
		for (int j = 1; j <=c; j++) {
			if(j>=w[i])
				m[i][j]=m[i-1][j-w[i]]+v[i]>m[i-1][j]?m[i-1][j-w[i]]+v[i]:m[i-1][j];
			else
				m[i][j]=m[i-1][j];
		}
	}
	int max=0;
	for (int i = 0; i <v.length; i++) {
		for (int j = 0; j <=c; j++) {
			if(m[i][j]>max)
				max=m[i][j];
		}
	}
	System.out.println(max);
}
}

四、算法心得

在此次编程中，运用动态内存算法解决背包问题，发先所需分配空间量比较大，在做背包容量小，物平少时还好。如果涉及数量打一是内存占用会比较严重，计算量也会大大提高。动态分配内存类似分治法，把问题分成多个子问题，一步步求解，且前面求出的子问题会对后面所求子问题有影响，不像是分治法的子问题都是独立的。并且时刻给与一个状态值，记录最优解，当所有子问题都解决完时，最优解也就会成为了问题的解了。重点主要在于对内存的分配，和子问题的计算。

算法四：回溯法

1、概念

回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。

回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。

许多复杂的，规模较大的问题都可以使用回溯法，有“通用解题方法”的美称。

2、基本思想

在包含问题的所有解的解空间树中，按照深度优先搜索的策略，从根结点出发深度探索解空间树。当探索到某一结点时，要先判断该结点是否包含问题的解，如果包含，就从该结点出发继续探索下去，如果该结点不包含问题的解，则逐层向其祖先结点回溯。（其实回溯法就是对隐式图的深度优先搜索算法）。

若用回溯法求问题的所有解时，要回溯到根，且根结点的所有可行的子树都要已被搜索遍才结束。

而若使用回溯法求任一个解时，只要搜索到问题的一个解就可以结束。

3、用回溯法解题的一般步骤：

（1）针对所给问题，确定问题的解空间：

首先应明确定义问题的解空间，问题的解空间应至少包含问题的一个（最优）解。

（2）确定结点的扩展搜索规则

（3）以深度优先方式搜索解空间，并在搜索过程中用剪枝函数避免无效搜索。

4、算法实例：求子集问题

public class 回溯法_求子集问题 {
	    private static int[] s = {2,2,3};  
	    private static int n = s.length;  
	    private static int[] x = new int[n];       
	    /** 
	     * 输出集合的子集 
	     * @param limit  决定选出特定条件的子集 
	     * 注：all为所有子集,num为限定元素数量的子集, 
	     *    sp为限定元素奇偶性相同，且和小于8。 
	     */  
	    public static void all_subset(String limit){  
	        switch(limit){  
	        case "all":backtrack(0);break;  
	        case "num":backtrack1(0);break;  
	        case "sp":backtrack2(0);break;  
	        }  
	    }        
	    /** 
	     * 回溯法求集合的所有子集，依次递归 
	     * 注：是否回溯的条件为精髓 
	     * @param t 
	     */  
	    private static void backtrack(int t){  
	        if(t >= n) 
	        	output(x);      
	        else  
	            for (int i = 0; i <= 1; i++) {  
	                x[t] = i;  
	                backtrack(t+1);  
	            }        
	    }  
	    /** 
	     * 回溯法求集合的所有(元素个数小于4)的子集，依次递归 
	     * @param t 
	     */  
	    private static void backtrack1(int t){  
	        if(t >= n)  
	            output(x);  
	        else  
	            for (int i = 0; i <= 1; i++) {  
	                x[t] = i;  
	                if(count(x, t) < 4)  
	                    backtrack1(t+1);  
	            }       
	    }  
	  
	    /** 
	     * (剪枝) 
	     * 限制条件：子集元素小于4,判断0~t之间已被选中的元素个数， 
	     *        因为此时t之后的元素还未被递归,即决定之后的元素 
	     *        是否应该被递归调用 
	     * @param x 
	     * @param t 
	     * @return 
	     */  
	    private static int count(int[] x, int t) {  
	        int num = 0;  
	        for (int i = 0; i <= t; i++) {  
	            if(x[i] == 1){  
	                num++;  
	            }  
	        }  
	        return num;  
	    }  
	    /** 
	     * 回溯法求集合中元素奇偶性相同，且和小于8的子集,依次递归 
	     * @param t 
	     */  
	    private static void backtrack2(int t){  
	        if(t >= n)  
	            output(x);  
	        else  
	            for (int i = 0; i <= 1; i++) {  
	                x[t] = i;  
	                if(legal(x, t))  
	                    backtrack2(t+1);  
	            }   
	    }  
	    /** 
	     * 对子集中元素奇偶性进行判断，还需元素的数组和小于8 
	     * @param x 
	     * @param t 
	     * @return 
	     */  
	    private static boolean legal(int[] x, int t) {  
	        boolean bRet = true;   //判断是否需要剪枝  
	        int part = 0;  //奇偶性判断的基准  
	          
	        for (int i = 0; i <= t; i++) {  //选择第一个元素作为奇偶性判断的基准  
	            if(x[i] == 1){  
	                part = i;  
	                break;  
	            }  
	        }    
	        for (int i = 0; i <= t; i++) {  
	            if(x[i] == 1){  
	                bRet &= ((s[part] - s[i]) % 2 == 0);  
	            }       
	        }  
	        int sum = 0;  
	        for(int i = 0; i <= t; i++){  
	            if(x[i] == 1)  
	                sum += s[i];  
	        }  
	        bRet &= (sum < 8);   
	        return bRet;  
	    }  
	    /** 
	     * 子集输出函数 
	     * @param x 
	     */  
	    private static void output(int[] x) {  
	        for (int i = 0; i < x.length; i++) {  
	            if(x[i] == 1){  
	                System.out.print(s[i]);  
	            }  
	        }  
	        System.out.println();     
	    }  
	  public static void main(String[] args) {
		  all_subset("all");
	}
} 

5、算法心得

回溯法是一种几乎万能的算法，无论面对规模大还是规模小的问题都有妙用，在此次求子集问题中，回溯法的妙用我认为有两点，一是它采用深度优先遍历算法，可以从根节点访问到所有子节点，也就有了剪枝的妙用，在进有行奇偶限制，求和限制时，可以很好的做到把这些“越界”的没必要的子节点及子节点后的孙子节点去掉，大大减少了时间的浪费性。二是，算法框架的简洁性，使使用者能非常清晰的明白代码进行的方式。

算法五：分支限界法

一、基本描述

    类似于回溯法，也是一种在问题的解空间树T上搜索问题解的算法。但在一般情况下，分支限界法与回溯法的求解目标不同。回溯法的求解目标是找出T中满足约束条件的所有解，而分支限界法的求解目标则是找出满足约束条件的一个解，或是在满足约束条件的解中找出使某一目标函数值达到极大或极小的解，即在某种意义下的最优解。

   （1）分支搜索算法

    所谓“分支”就是采用广度优先的策略，依次搜索E-结点的所有分支，也就是所有相邻结点，抛弃不满足约束条件的结点，其余结点加入活结点表。然后从表中选择一个结点作为下一个E-结点，继续搜索。

     选择下一个E-结点的方式不同，则会有几种不同的分支搜索方式。

   1）FIFO搜索

   2）LIFO搜索

   3）优先队列式搜索

（2）分支限界搜索算法 

二、分支限界法的一般过程

    由于求解目标不同，导致分支限界法与回溯法在解空间树T上的搜索方式也不相同。回溯法以深度优先的方式搜索解空间树T，而分支限界法则以广度优先或以最小耗费优先的方式搜索解空间树T。

    分支限界法的搜索策略是：在扩展结点处，先生成其所有的儿子结点（分支），然后再从当前的活结点表中选择下一个扩展对点。为了有效地选择下一扩展结点，以加速搜索的进程，在每一活结点处，计算一个函数值（限界），并根据这些已计算出的函数值，从当前活结点表中选择一个最有利的结点作为扩展结点，使搜索朝着解空间树上有最优解的分支推进，以便尽快地找出一个最优解。

    分支限界法常以广度优先或以最小耗费（最大效益）优先的方式搜索问题的解空间树。问题的解空间树是表示问题解空间的一棵有序树，常见的有子集树和排列树。在搜索问题的解空间树时，分支限界法与回溯法对当前扩展结点所使用的扩展方式不同。在分支限界法中，每一个活结点只有一次机会成为扩展结点。活结点一旦成为扩展结点，就一次性产生其所有儿子结点。在这些儿子结点中，那些导致不可行解或导致非最优解的儿子结点被舍弃，其余儿子结点被子加入活结点表中。此后，从活结点表中取下一结点成为当前扩展结点，并重复上述结点扩展过程。这个过程一直持续到找到所求的解或活结点表为空时为止。

三、回溯法和分支限界法的一些区别

    有一些问题其实无论用回溯法还是分支限界法都可以得到很好的解决，但是另外一些则不然。也许我们需要具体一些的分析——到底何时使用分支限界而何时使用回溯呢？

回溯法和分支限界法的一些区别：

   方法对解空间树的搜索方式 存储结点的常用数据结构结点存储特性常用应用

  回溯法深度优先搜索堆栈活结点的所有可行子结点被遍历后才被从栈中弹出找出满足约束条件的所有解

  分支限界法广度优先或最小消耗优先搜索队列、优先队列每个结点只有一次成为活结点的机会找出满足约束条件的一个解或特定意义下的最优解

import java.util.Collections;

import java.util.LinkedList;

public class 分支界限法_求最大承重问题 {
	LinkedList<HeapNode> heap;
	public static class BBnode{
		BBnode parent;//父结点
		boolean leftChild;//左儿子结点标志
		//构造方法
		public BBnode(BBnode par,boolean ch){
			parent=par;
			leftChild=ch;
		}
	}
	/**
	 * 输出函数，做调试用
	 * @param list
	 */
	public static void printReverse(LinkedList<HeapNode> list){
		for (int i=0;i<list.size();i++) {
			HeapNode aBnode=list.get(i);
			System.out.print("#"+aBnode.uweight+"#"+aBnode.level+" ");
        }
		
		}
	/*
	 * 最大优先队列中存储的活结点类型为HeapNode
	 */
	public static class HeapNode implements Comparable{
		BBnode liveNode;
		int uweight;//活结点优先级（上界）
		int level;//活结点在子集树种所处的层序号
		//构造函数
		public HeapNode(BBnode node,int up,int lev){
			liveNode=node;
			uweight=up;
			level=lev;
		}
		@Override
		public int compareTo(Object x) {//升序排列
			int xu=((HeapNode)x).uweight;
			if(uweight<xu) return -1;
			if(uweight==xu) return 0;
			return 1;
		}
		public boolean equals(Object x){
			return uweight==((HeapNode)x).uweight;
		}
	}
	public void addLiveNode(int up,int lev,BBnode par,boolean ch){
		//将活结点加入到表示活结点优先队列的最大堆H中
		BBnode b=new BBnode(par,ch);
		HeapNode node=new HeapNode(b,up,lev);
		heap.add(node);
		Collections.sort(heap);
	}
	public int maxLoading(int[] w,int c,int[] bestx){
		int count=0;
		//优先队列式分支限界法，返回最优重量，bestx返回最优解
		heap=new LinkedList<HeapNode>();
		int n=w.length-1;
		BBnode e=null;//当前扩展结点
		int i=1;//当前扩展结点所处的层
		int ew=0;//扩展结点所对应的载重量
		//定义剩余重量数组r
		int[] r=new int[n+1];
		for(int j=n-1;j>0;j--) {
			r[j]=r[j+1]+w[j+1];
		}
		//搜索子集空间树
		while(i!=n+1){
			//非叶结点
			//检查当前扩展结点的儿子结点
			if(ew+w[i]<=c){
				//左儿子结点为可行结点
				addLiveNode(ew+w[i]+r[i],i+1,e,true);
			}
			//右儿子结点总为可行结点
			addLiveNode(ew+r[i],i+1,e,false);
			//printReverse(heap);
			//取下一个结点
			HeapNode node=heap.pollLast();
			i=node.level;
			e=node.liveNode;
			ew=node.uweight-r[i-1];
		}
		
		//输出
		for(int j=0;j<n;j++){
			bestx[j]=(e.leftChild)?1:0;
			e=e.parent;
		}
		for(int j=n-1;j>=0;j--){
			System.out.print(bestx[j]+" ");
		}
		System.out.println();
		return ew;
	}
	public static void main(String[] args) {
		int n=4;
		int c=70;
		int w[]={0,26,60,22,18};//下标从1开始
		int[] bestx=new int[n+1];
		分支界限法_求最大承重问题 b=new 分支界限法_求最大承重问题();
		System.out.println("最优装载顺序为（1表示装入，0表示未装入）：");
		int ew=b.maxLoading(w, c, bestx);
		System.out.println("最优装载重量为："+ew);
	}
}

 