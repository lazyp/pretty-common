package org.pretty.common.algorithm;

import java.util.LinkedList;

/**
 * AC 自动机匹配算法
 * @author hxl
 * @version 2012-07-26
 */
public class AutoMatonMatch {

    private static AMTrie amTrie = new AMTrie();

    /**
     * 创建一个ac自动机
     * @param data
     * @return
     */
    public static AutoMatonMatch createACMatch(String[] words) {
        amTrie.initTrie(words);
        makeFailPointerByBFS();
        return new AutoMatonMatch();
    }

    /**
     * 通过BFS算法构造失败指针
     */
    private static void makeFailPointerByBFS() {
        AMTrie.Node root = amTrie.getRootNode();
        LinkedList<AMTrie.Node> queue = new LinkedList<AMTrie.Node>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            AMTrie.Node frontNode = queue.getFirst();
            queue.removeFirst();
            for (int i = 0; i < AMTrie.childCount; ++i) {
                AMTrie.Node curNode = frontNode.next[i];
                if (curNode != null ) {
                    if (frontNode == root) {
                        curNode.failNext = root;
                    } else {
                        AMTrie.Node prevFailNode = frontNode.failNext;
                        do {
                            if (prevFailNode.next[i] != null) {
                                curNode.failNext = prevFailNode.next[i];
                                break;
                            } else {
                                prevFailNode = prevFailNode.failNext;
                            }
                        } while (prevFailNode != null);

                        if (prevFailNode == null) {
                            curNode.failNext = root;
                        }
                    }
                    queue.push(curNode);
                }
            }
        }
    }

    /**
     * 查找字串,并返回开始下标
     * @param target
     * @return
     */
    public int find(String txt) {
        AMTrie.Node root = amTrie.getRootNode();
        int pos = -1;
        int i = 0;
        int len = txt.length();
        while (i < len) {

            if (root.isEOF) {
                break;
            }

            char c = txt.charAt(i);
            if (c > 255) {
                ++i;
                root = amTrie.getRootNode();
            } else if (root == amTrie.getRootNode() && root.next[c] == null) {
                ++i;
            } else if (root.next[c] != null) {
                root = root.next[c];
                ++i;
            } else {
                root = root.failNext;
                if (root == null) {
                    root = amTrie.getRootNode();
                }
            }
        }

        if (root.isEOF) {
            pos = i - root.wordLen;
            // break;
        }
        // pos = i - txt.length();
        return pos;
    }

    /**
     * Trie树，单词树
     */
    private static class AMTrie {
        private static final int childCount = 256;

        private class Node {
            // char ch;
            int     wordLen  = -1;
            boolean isEOF    = false;                // 是否是一个单词的结束位置
            Node[]  next     = new Node[childCount];
            Node    failNext = null;

            public Node(){
                super();
                // this.ch = ch;
            }
        }

        private Node rootNode = null; // 根节点

        /**
         * 初始化
         * @param s
         */
        protected void initTrie(String[] words) {
            rootNode = new Node();// 初始化一个跟节点
            for (String word : words) {
                // System.out.println(word);
                addWord(word);
            }
        }

        /**
         * 添加一个单词
         * @param word
         * @return
         */
        private boolean addWord(String word) {
            Node curNode = rootNode;
            for (int i = 0, len = word.length(); i < len; ++i) {
                char c = word.charAt(i);
                if (curNode.next[c] == null) {
                    curNode.next[c] = new Node();
                }

                curNode = curNode.next[c];

                if (i == len - 1) {
                    curNode.isEOF = true;
                    curNode.wordLen = word.length();
                }
            }
            return true;
        }

        public Node getRootNode() {
            return rootNode;
        }

    }

    public static void main(String[] args) {
        AutoMatonMatch amm = AutoMatonMatch.createACMatch(new String[] { "she", "her", "he" });
        System.out.println(amm.find("exsherx"));

    }

}
