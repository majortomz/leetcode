//
// Created by zjw on 2021/8/29.
//
#include <iostream>
using namespace std;

struct ListNode {
     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
 };

class Solution2 {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if (l1 == nullptr || l2 == nullptr) {
            return l1 == nullptr ? l2 : l1;
        }

        ListNode head;
        ListNode* cur = &head;
        int c = 0;
        while (l1 != nullptr || l2 != nullptr) {
            if (l1 == nullptr) {
                c += l2->val;
                l2 = l2->next;
            } else if (l2 == nullptr) {
                c += l1->val;
                l1 = l1->next;
            } else {
                c += (l1->val + l2->val);
                l1 = l1->next;
                l2 = l2->next;
            }
            auto next = new ListNode();
            next->val = c % 10;
            cur->next = next;
            cur = next;
            c /= 10;
        }
        if (c > 0) {
            cur->next = new ListNode(c);
        }

        return head.next;
    }
};

int main() {
    Solution2 solution2;
    auto* l1 = new ListNode(0);
    auto* l2 = new ListNode(3);
    ListNode* res = solution2.addTwoNumbers(l1, l2);
    while (res != nullptr) {
        cout << res->val;
        res = res->next;
    }
}
