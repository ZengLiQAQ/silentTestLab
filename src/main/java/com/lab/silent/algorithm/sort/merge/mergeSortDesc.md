<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="http://www.yoqian.cn/wp-content/themes/adams/style.css?v1.2.5" type="text/css" rel="stylesheet">
    <link href="http://www.yoqian.cn/wp-content/themes/adams/static/caomei1.2.8/style.css?v1.2.5" type="text/css" rel="stylesheet">
    <title>归并排序（Merge Sort）</title>
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
<link rel='prev' title='希尔排序（Shell Sort）' href='http://www.yoqian.cn/?p=48' />
<link rel='next' title='快速排序（Quick Sort）' href='http://www.yoqian.cn/?p=52' />
<link rel="canonical" href="http://www.yoqian.cn/?p=50" />
<link rel='shortlink' href='http://www.yoqian.cn/?p=50' />
    
<script>
    if(localStorage.adams_color_style) $('head').append("<style class='diy-color-style'>" + localStorage.adams_color_style + "</style>");
    if(localStorage.adams_font_style) $('head').append("<style class='diy-font-style'>" + localStorage.adams_font_style + "</style>");
</script>
</head>
<body>
<!-- Header -->
<header>
    <section class="container" style="padding-top: 12px;">
        <hgroup itemscope itemtype="https://schema.org/WPHeader">
            <h1 class="fullname" style="margin: 0;font-size: 1.5rem;font-weight:bold;color:#434a54;display:inline-block;position:relative;z-index:1;" >归并排序（Merge Sort）</h1>
        </hgroup>
    </section>
</header>    <!-- Content -->
    <section class="container main-load">
        <article class="post_article" itemscope itemtype="https://schema.org/Article">
        
<p>归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。</p>



<p><strong>1 算法描述</strong></p>



<ul><li>把长度为n的输入序列分成两个长度为n/2的子序列；</li><li>对这两个子序列分别采用归并排序；</li><li>将两个排序好的子序列合并成一个最终的排序序列。</li></ul>

<p><strong>2 动图演示</strong></p>

<figure class="wp-block-image"><img src="http://5b0988e595225.cdn.sohucs.com/images/20181009/19840a8b80d6465dbe2026157435ad2c.gif" alt=""/></figure>

<p><strong>3 算法分析</strong></p>

<p>归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(nlogn）的时间复杂度。代价是需要额外的内存空间。</p>
        </article>
    </section>