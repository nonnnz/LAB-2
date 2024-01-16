#include <iostream>
#include <vector>
#include <algorithm>

void search(const std::vector<int>& A, int M, int k) {
    // Sort A in ascending order
    std::vector<int> sortedA = A;
    std::sort(sortedA.begin(), sortedA.end());

    // Search for M in sortedA
    auto it = std::find(sortedA.begin(), sortedA.end(), M);

    if (it != sortedA.end()) {
        // Indices in the original array
        int i = std::distance(sortedA.begin(), it);
        int left = i - 1;
        int right = i;

        // Print initial indices
        std::cout << "Initial indices: " << left << " " << right << std::endl;

        // Expand the range while (right - left) <= k
        while ((right - left) <= k) {
            if (left >= 0 && right < sortedA.size()) {
                // Print current indices
                std::cout << "Current indices: " << left << " " << right << std::endl;

                // Update indices based on proximity to M
                if (std::abs(sortedA[left] - M) > std::abs(sortedA[right] - M)) {
                    ++right;
                } else {
                    --left;
                }
            } else {
                // Break if one of the indices reaches the array boundary
                break;
            }
        }
    } else {
        std::cout << "Element not found in the array." << std::endl;
    }
}

int main() {
    std::vector<int> A = {10, 12, 15, 17, 18, 20, 25};
    int M = 8;
    int k = 2;

    search(A, M, k);

    return 0;
}
