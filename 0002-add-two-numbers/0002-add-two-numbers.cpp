class Solution {
public:
    // Function to add two numbers represented by two linked lists
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        // Initialize a dummy head to build the result list
        ListNode* dummyHead = new ListNode();
        // Variable to keep track of the carry
        int carry = 0;
        // We use 'current' to add new nodes to the result list
        ListNode* current = dummyHead;
        // Continue looping until both lists are traversed completely and there is no carry
        while (l1 || l2 || carry) {
            // Calculate the sum of the current digits along with the carry
            int sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
            // Update the carry for the next iteration
            carry = sum / 10;
            // Create a new node with the digit part of the sum and append to the result list
            current->next = new ListNode(sum % 10);
            // Move the 'current' pointer to the new node
            current = current->next;
            // Move the list pointers l1 and l2 to the next nodes if they exist
            l1 = l1 ? l1->next : nullptr;
            l2 = l2 ? l2->next : nullptr;
        }
        // The result list starts after the dummy head's next pointer
        return dummyHead->next;
    }
};