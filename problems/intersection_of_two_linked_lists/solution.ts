/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */
 
function getIntersectionNode(headA: ListNode | null, headB: ListNode | null): ListNode | null {
    let lenA = 0, lenB = 0;
    let ptrA = headA, ptrB = headB;

    while (ptrA != null) {
        lenA++;
        ptrA = ptrA.next;
    }

    while (ptrB != null) {
        lenB++;
        ptrB = ptrB.next;
    }

    ptrA = headA;
    ptrB = headB;

    let diff = Math.abs(lenA - lenB);
    if (lenA > lenB) {
        while (diff > 0) {
            diff--;
            ptrA = ptrA!.next;
        }
    } else {
        while (diff > 0) {
            diff--;
            ptrB = ptrB!.next;
        }
    }

    while (ptrA != null && ptrB != null) {
        if (ptrA === ptrB) {
            return ptrA;
        }
        ptrA = ptrA.next;
        ptrB = ptrB.next;
    }

    return null;
};