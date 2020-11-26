# Markdown 语法demo

## 标题
```markdown
# 一级标题
## 二级标题
### 三级标题
#### 四级标题
##### 五级标题
###### 六级标题 
```
注：# 和「一级标题」之间建议保留一个字符的空格，这是最标准的 Markdown 写法。

## 列表
```markdown
- 文本1
- 文本2
- 文本3
```

## 有序列表
```markdown
1. 文本1
2. 文本2
3. 文本3
```
注：-、1.和文本之间要保留一个字符的空格。

## 连接和图片
### 链接
在 Markdown 中，插入链接不需要其他按钮，你只需要使用 [显示文本](链接地址) 这样的语法即可，例如：
```markdown
[简书](http://www.jianshu.com)
```
### 图片
在 Markdown 中，插入图片不需要其他按钮，你只需要使用 ![](图片链接地址) 这样的语法即可，例如：
![图标](http://static.runoob.com/images/runoob-logo.png)
![图标](http://static.runoob.com/images/runoob-logo.png "RUNOOB")

```markdown
![](http://upload-images.jianshu.io/upload_images/259-0ad0d0bfc1c608b6.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
```

#### 设置图片的宽高
Markdown 还没有办法指定图片的高度与宽度，如果你需要的话，你可以使用普通的 <img> 标签。
```markdown
<img src="http://static.runoob.com/images/runoob-logo.png" width="50%">
```
<img src="http://static.runoob.com/images/runoob-logo.png" width="50%"><br><br>

### 相对路径图片
相对路径通常在表示图片、网页等位置时需要用到，相比于绝对路径更不容易出错。
如果图片与.md文件在同一目录下，那么相对路径这样表示
```markdown
![avatar](buildWebsites.jpg)
```
其中avatar表示图片未正常加载时所显示的内容，buildWebsites.jpg为文件名
其子路径这样表示:
```markdown
![avatar](1/buildWebsites.jpg)
```
其中1为文件夹名称

其父路径用“..”表示，例如
```markdown
![avatar](../buildWebsites.jpg)
```

我还发现markdown在写hexo网页时，相对路径既可以从当前位置起步识别，也可以从主题下的resource文件里开始匹配。
通过这些方式，你可以轻松的通过相对路径定位到图片的任意一个位置。


注: 插入图片的语法和链接的语法很像，只是前面多了一个 ！
## 引用
望引用的文字前面加上 > 就好了，例如:
```markdown
> 这是一个引用
```

## 粗体和斜体
```markdown
斜体: *xxx*,文字两边各一个*号
粗体: **xxxx** ,文字两边各两个*号
```
### 代码引用
#### 单行代码引用
`markDown`

#### 多行代码引用
```java
public class Test{
 public static void main(String[] args){
   System.out.println("Hello world!");
 }
}
```
## 表格

| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $16   |
| col 2 is      | centered      | $12   |
| zebra stripes | are neat      | $1    |

## Markdown 高级技巧
### 支持的 HTML 元素
> 不在 Markdown 涵盖范围之内的标签，都可以直接在文档里面用 HTML 撰写。

目前支持的 HTML 元素有：
```markdown
<kbd> <b> <i> <em> <sup> <sub> <br>
使用 <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+<kbd>Del</kbd> 重启电脑
```
使用 <kbd>`Ctrl`</kbd>+<kbd>`Alt`</kbd>+<kbd>`Del`</kbd> 重启电脑


### 转义
Markdown 使用了很多特殊符号来表示特定的意义，如果需要显示特定的符号则需要使用转义字符，Markdown 使用反斜杠转义特殊字符：
Markdown 支持以下这些符号前面加上反斜杠来帮助插入普通的符号：

```markdown
\   反斜线
`   反引号
*   星号
_   下划线
{}  花括号
[]  方括号
()  小括号
#   井字号
+   加号
-   减号
.   英文句点
!   感叹号
```