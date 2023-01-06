<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="http://www.yoqian.cn/wp-content/themes/adams/style.css?v1.2.5" type="text/css" rel="stylesheet">
    <link href="http://www.yoqian.cn/wp-content/themes/adams/static/caomei1.2.8/style.css?v1.2.5" type="text/css" rel="stylesheet">
    <title>冒泡排序（Bubble Sort）</title>
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
<link rel='next' title='选择排序（Selection Sort）' href='http://www.yoqian.cn/?p=41' />
<link rel="canonical" href="http://www.yoqian.cn/?p=25" />
<link rel='shortlink' href='http://www.yoqian.cn/?p=25' />
   
</head>
<body>
<!-- Header -->
<header>
    <section class="container" style="padding-top: 12px;">
        <hgroup itemscope itemtype="https://schema.org/WPHeader">
            <h1 class="fullname" style="margin: 0;font-size: 1.5rem;font-weight:bold;color:#434a54;display:inline-block;position:relative;z-index:1;" >冒泡排序（Bubble Sort）</h1>
        </hgroup>
    </section>
</header>    <!-- Content -->
    <section class="container main-load">
        <article class="post_article" itemscope itemtype="https://schema.org/Article">
        
<p>冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。</p>



<p><strong>1.1 算法描述</strong></p>



<ul><li>比较相邻的元素。如果第一个比第二个大，就交换它们两个；</li><li>对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；</li><li>针对所有的元素重复以上的步骤，除了最后一个；</li><li>重复步骤1~3，直到排序完成。</li></ul>



<p>1.2 动图演示</p>



<figure class="wp-block-image"><img src="http://5b0988e595225.cdn.sohucs.com/images/20181009/e9011afacb434ea09c8a156dc9983bfb.gif" alt=""/></figure>



<p></p>



<p> 代码实现（javascript）</p>



<pre class="wp-block-code" /><code class="prettyprint" >function bubbleSort(arr) {
    var len = arr.length;
    for (var i = 0; i &lt; len - 1; i++) {
        for (var j = 0; j &lt; len - 1 - i; j++) {
            if (arr[j] &gt; arr[j+1]) {        // 相邻元素两两对比
                var temp = arr[j+1];        // 元素交换
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}
</code>

