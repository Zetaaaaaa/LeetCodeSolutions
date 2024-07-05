 /**
  * Definition for singly-linked list.
  * struct ListNode {
  *     int val;
  *     ListNode *next;
  *     ListNode() : val(0), next(nullptr) {}
  *     ListNode(int x) : val(x), next(nullptr) {}
  *     ListNode(int x, ListNode *next) : val(x), next(next) {}
  * };
  */
 static const int __ =[](){
     ios_base::sync_with_stdio(false);
     cin.tie(NULL);
     cout.tie(nullptr);
     return 0;
 }();
 
 class Solution {
 public:
     vector<int> nodesBetweenCriticalPoints(ListNode* head) {
         if(!head || !head->next){
             return {-1,-1};
         }
         // vector<int> ans;
 
         ListNode* ptr1 = head;
         ListNode* ptr2 = head->next;
         vector<int> resMax;
         int count = 1;
         while(ptr2->next){
             if( (ptr1->val < ptr2->val && ptr2->val > ptr2->next->val)  ||  (ptr1->val > ptr2->val && ptr2->val < ptr2->next->val) ){
                 resMax.push_back(count);
             }
 
             ptr1 = ptr2;
             ptr2 = ptr2 -> next; 
             count++;
         }
 
         // for(int i = 0; i < resMax.size(); i++){
         //     cout << resMax[i] << " ";
         // }
         if(resMax.size()<2){
             return {-1,-1};
         }
         int r = resMax.size()-1;
 
         int maxx = resMax[r]-resMax[0];
         int minn = maxx;
 
         for(int i = 1; i<=r; i++) minn = min(minn, resMax[i]-resMax[i-1]);
 
 
         return {minn,maxx};
     }
 };