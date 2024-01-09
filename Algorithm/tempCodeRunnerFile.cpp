if(l > r) return INT_MIN;
    int mid = l + (r - l) / 2;
    int max_left = maxSubArraySum(a, l, mid-1);
    int max_right = maxSubArraySum(a, mid+1, r);

    int max_left_sum = 0, max_right_sum = 0;
    for(int i = mid-1, sum = 0; i >= l; i--) {
        sum += a[i];
        max_left_sum = max(max_left_sum, sum);
    }
    for(int i = mid+1, sum = 0; i <= r; i++) {
        sum += a[i];
        max_right_sum = max(max_right_sum, sum);
    }

    int max_mid_sum = max_left_sum + max_right_sum + a[mid];
    return max(max(max_left, max_right), max_mid_sum);