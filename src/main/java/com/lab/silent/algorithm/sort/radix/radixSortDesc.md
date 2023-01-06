<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="http://www.yoqian.cn/wp-content/themes/adams/style.css?v1.2.5" type="text/css" rel="stylesheet">
    <link href="http://www.yoqian.cn/wp-content/themes/adams/static/caomei1.2.8/style.css?v1.2.5" type="text/css" rel="stylesheet">
    <title>基数排序（Radix Sort）</title>
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
<link rel='prev' title='桶排序（Bucket Sort）' href='http://www.yoqian.cn/?p=58' />
<link rel='next' title='程序员高手必会的十大编程算法' href='http://www.yoqian.cn/?p=64' />
<link rel="canonical" href="http://www.yoqian.cn/?p=60" />
<link rel='shortlink' href='http://www.yoqian.cn/?p=60' />
    
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
            <h1 class="fullname" style="margin: 0;font-size: 1.5rem;font-weight:bold;color:#434a54;display:inline-block;position:relative;z-index:1;" >基数排序（Radix Sort）</h1>
        </hgroup>
    </section>
</header>    <!-- Content -->
    <section class="container main-load">
        <article class="post_article" itemscope itemtype="https://schema.org/Article">
        
<p>基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。</p>



<p><strong>1 算法描述</strong></p>



<ul><li>取得数组中的最大数，并取得位数；</li><li>arr为原始数组，从最低位开始取每个位组成radix数组；</li><li>对radix进行计数排序（利用计数排序适用于小范围数的特点）；</li></ul>



<p><strong>2 动图演示</strong></p>



<figure class="wp-block-image"><img src="http://5b0988e595225.cdn.sohucs.com/images/20181009/5092611170d3423d89f7075d33104b6a.gif" alt=""/></figure>




<p><strong>3 算法分析</strong></p>



<p>基数排序基于分别排序，分别收集，所以是稳定的。但基数排序的性能比桶排序要略差，每一次关键字的桶分配都需要O(n)的时间复杂度，而且分配之后得到新的关键字序列又需要O(n)的时间复杂度。假如待排数据可以分为d个关键字，则基数排序的时间复杂度将是O(d*2n) ，当然d要远远小于n，因此基本上还是线性级别的。</p>



<p>基数排序的空间复杂度为O(n+k)，其中k为桶的数量。一般来说n&gt;&gt;k，因此额外空间需要大概n个左右。</p>
</article>
</section>