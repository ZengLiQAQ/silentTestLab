<!DOCTYPE html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="http://www.yoqian.cn/wp-content/themes/adams/style.css?v1.2.5" type="text/css" rel="stylesheet">
    <link href="http://www.yoqian.cn/wp-content/themes/adams/static/caomei1.2.8/style.css?v1.2.5" type="text/css" rel="stylesheet">
    <title>希尔排序（Shell Sort）</title>
<link rel='dns-prefetch' href='//cdn.staticfile.org' />
<link rel='dns-prefetch' href='//s.w.org' />
<link rel='stylesheet' id='wp-block-library-css'  href='http://www.yoqian.cn/wp-includes/css/dist/block-library/style.min.css?ver=5.2.3' type='text/css' media='all' />
<script type='text/javascript' src='//cdn.staticfile.org/jquery/3.1.1/jquery.min.js?ver=v1.2.5'></script>
<script type='text/javascript' src='http://www.yoqian.cn/wp-content/themes/adams/static/script.js?ver=v1.2.5'></script>
<script type='text/javascript' src='//cdn.staticfile.org/prettify/r298/prettify.js?ver=v1.2.5'></script>
<script type='text/javascript' src='//cdn.staticfile.org/instantclick/3.0.1/instantclick.min.js?ver=v1.2.5'></script>
<link rel='https://api.w.org/' href='http://www.yoqian.cn/index.php?rest_route=/' />
<link rel="EditURI" type="application/rsd+xml" title="RSD" href="http://www.yoqian.cn/xmlrpc.php?rsd" />
<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="http://www.yoqian.cn/wp-includes/wlwmanifest.xml" /> 
<link rel='prev' title='插入排序（Insertion Sort）' href='http://www.yoqian.cn/?p=46' />
<link rel='next' title='归并排序（Merge Sort）' href='http://www.yoqian.cn/?p=50' />
<link rel="canonical" href="http://www.yoqian.cn/?p=48" />
<link rel='shortlink' href='http://www.yoqian.cn/?p=48' />
    
  
</head>
<!-- Header -->
<header>
    <section class="container" style="padding-top: 12px;">
        <hgroup itemscope itemtype="https://schema.org/WPHeader">
            <h1 class="fullname" style="margin: 0;font-size: 1.5rem;font-weight:bold;color:#434a54;display:inline-block;position:relative;z-index:1;" >希尔排序（Shell Sort）</h1>
        </hgroup>
    </section>
</header> 
<p>1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。</p>



<p><strong>1 算法描述</strong></p>



<p>先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：</p>



<ul><li>选择一个增量序列t1，t2，…，tk，其中ti&gt;tj，tk=1；</li><li>按增量序列个数k，对序列进行k 趟排序；</li><li>每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。</li></ul>



<p><strong>2 动图演示</strong></p>



<figure class="wp-block-image"><img src="http://5b0988e595225.cdn.sohucs.com/images/20181009/90169f60317945fc8de16ef7267b09aa.gif" alt=""/></figure>

<p><strong>3 算法分析</strong></p>



<p>希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。动态定义间隔序列的算法是《算法（第4版）》的合著者Robert Sedgewick提出的。</p>
        </article>
    </section>
           
<div id="cnblogs_post_body" class="blogpost-body ">
    <p><span style="color: #000000;">　　希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。希尔排序也是一种<span style="color: #ff0000;">插入排序</span>，它是简单插入排序经过改进之后的一个更高效的版本，也称为<span style="color: #ff0000;">缩小增量排序，<span style="color: #000000;">同时</span></span>该算法是冲破O(n<sup>2</sup>）的第一批算法之一。本文会以图解的方式详细介绍希尔排序的基本思想及其代码实现。</span></p>
<h1>基本思想</h1>
<blockquote>
<p><span style="color: #000000;"><strong><span>　　希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。</span></strong></span></p>
</blockquote>
<p><span style="color: #000000;"><strong><span>　　</span></strong><span>简单插入排序很循规蹈矩，不管数组分布是怎么样的，依然一步一步的对元素进行比较，移动，插入，</span><span>比如[5,4,3,2,1,0]这种倒序序列，数组末端的0要回到首位置很是费劲，比较和移动元素均需n-1次。而希尔排序在数组中采用跳跃式分组的策略，通过某个增量将数组元素划分为若干组，然后分组进行插入排序，随后逐步缩小增量，继续按组进行插入排序操作，直至增量为1。希尔排序通过这种策略使得整个数组在初始阶段达到从宏观上看基本有序，小的基本在前，大的基本在后。然后缩小增量，到增量为1时，其实多数情况下只需微调即可，不会涉及过多的数据移动。</span></span></p>
<p><span style="color: #000000;"><span>　　我们来看下希尔排序的基本步骤，在此我们选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为<strong>增量序列</strong>。希尔排序的增量序列的选择与证明是个数学难题，我们选择的这个增量序列是比较常用的，也是希尔建议的增量，称为希尔增量，但其实这个增量序列不是最优的。此处我们做示例使用希尔增量。</span></span></p>
<p><img src="https://images2015.cnblogs.com/blog/1024555/201611/1024555-20161128110416068-1421707828.png" alt="" width="1161" height="1153"></p>
<p>　　在希尔排序的理解时，我们倾向于对于每一个分组，逐组进行处理，但在代码实现中，我们可以不用这么按部就班地处理完一组再调转回来处理下一组（这样还得加个for循环去处理分组）比如[5,4,3,2,1,0] ，首次增量设gap=length/2=3,则为3组[5,2] [4,1] [3,0]，实现时不用循环按组处理，我们可以从第gap个元素开始，逐个跨组处理。同时，在插入数据时，可以采用元素交换法寻找最终位置，也可以采用数组元素移动法寻觅。</p>
</div>