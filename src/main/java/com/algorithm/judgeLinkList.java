package com.algorithm;

import com.fasterxml.jackson.databind.util.LinkedNode;

/**
 *
 * @author 71972
 * @date 2019/4/23
 */
public class judgeLinkList {
    /**
     * 判断一个链表是否成环
     * @param head
     * @return
     */
    public boolean hasCycle(LinkedNode head)
    {
        if(head == null || head.next() == null) {
            return false;
        }
        LinkedNode fast = head;
        LinkedNode slow = head;
        while(fast != null && fast.next() != null) {
            fast = fast.next().next();
            slow = slow.next();
            if(fast == slow) {
                return true;
            }
        }
        return false;

    }
}
