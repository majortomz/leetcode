//
// Created by zjw on 2021/8/21.
//
#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution1 {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

        vector<int> res;

        map<int, int> pos;
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            int cur = nums[i];
            if (pos.count(target - cur) > 0) {
                 res.push_back(pos[target - cur]);
                 res.push_back(i);
                 return res;
            } else {
                pos[cur] = i;
            }
        }
        return res;

    }
};

int main() {
   Solution1 solution;
   vector<int> numsa = {1, 2, 3, 4, 5};
   vector<int> &nums = numsa;
   vector<int> res = solution.twoSum(nums, 3);
   cout << res[0] << "  " << res[1];
}
