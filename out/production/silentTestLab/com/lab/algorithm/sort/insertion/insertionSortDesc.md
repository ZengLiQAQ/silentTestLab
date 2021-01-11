<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="http://www.yoqian.cn/wp-content/themes/adams/style.css?v1.2.5" type="text/css" rel="stylesheet">
    <link href="http://www.yoqian.cn/wp-content/themes/adams/static/caomei1.2.8/style.css?v1.2.5" type="text/css" rel="stylesheet">
    <title>插入排序（Insertion Sort）</title>
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
<link rel='prev' title='选择排序（Selection Sort）' href='http://www.yoqian.cn/?p=41' />
<link rel='next' title='希尔排序（Shell Sort）' href='http://www.yoqian.cn/?p=48' />
<link rel="canonical" href="http://www.yoqian.cn/?p=46" />
<link rel='shortlink' href='http://www.yoqian.cn/?p=46' />
    
   
</head>
<body>
<!-- Header -->
<header>
    <section class="container" style="padding-top: 12px;">
        <hgroup itemscope itemtype="https://schema.org/WPHeader">
            <h1 class="fullname" style="margin: 0;font-size: 1.5rem;font-weight:bold;color:#434a54;display:inline-block;position:relative;z-index:1;" >插入排序（Insertion Sort）</h1>
        </hgroup>
    </section>
</header>    <!-- Content -->
    <section class="container main-load">
        <article class="post_article" itemscope itemtype="https://schema.org/Article">
        
<p>插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。</p>



<p><strong>1 算法描述</strong></p>



<p>一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：</p>



<ul><li>从第一个元素开始，该元素可以认为已经被排序；</li><li>取出下一个元素，在已经排序的元素序列中从后向前扫描；</li><li>如果该元素（已排序）大于新元素，将该元素移到下一位置；</li><li>重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；</li><li>将新元素插入到该位置后；</li><li>重复步骤2~5。</li></ul>



<p><strong>2 动图演示</strong></p>



<figure class="wp-block-image"><img src="http://5b0988e595225.cdn.sohucs.com/images/20181009/1167a023cbec4da0aa056ca481104d16.gif" alt=""/></figure>



<p>代码实现（javascript）</p>



<pre class="wp-block-code"><code class="prettyprint" >function insertionSort(arr) {
    var len = arr.length;
    var preIndex, current;
    for (var i = 1; i &lt; len; i++) {
        preIndex = i - 1;
        current = arr[i];
        while(preIndex &gt;= 0 &amp;&amp; arr[preIndex] &gt; current) {
            arr[preIndex+1] = arr[preIndex];
            preIndex--;
        }
        arr[preIndex+1] = current;
    }
    return arr;
}</code></pre>



<p><strong>3 算法分析</strong></p>



<p>插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。</p>
        </article>
    </section>