package com.lab.silent.algorithm.solution;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class 字母异位词分组_leetCode_49 {

    /**
     * 理解 "字母异位词" :
     *   例: ["eat", "tea", "tan", "ate", "nat", "bat"]
     *      eat , tea, ate  构成的字母元素是一致的,所以组成一组
     * 核心解题思路:
     *      1.根据组成的字符分组即可
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        //按包含相同字符分组即可
        Map<String,List<String>> group = Arrays.stream(strs).collect(Collectors.groupingBy(t -> {
            String key = unionKey(t);
            return key;
        }));
        return new ArrayList<>(group.values());
    }


    /**
     * 按 unionCode排序分组即可
     * @param str
     * @return
     */
    public static String unionKey(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }


    public static void main(String[] args) {
        String[]  strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>>  result  =  groupAnagrams(strs);
        System.out.println(JSONObject.toJSONString(result));
    }
}
