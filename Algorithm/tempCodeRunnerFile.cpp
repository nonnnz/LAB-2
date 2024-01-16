    int m = (l + r) / 2;

    int p_index;
    if (arr[l] < arr[m] && arr[m] < arr[r])
        p_index = m;
    else if (arr[l] < arr[r] && arr[r] < arr[m])
        p_index = r;
    else
        p_index = l;

    swap(arr[l], arr[p_index]);