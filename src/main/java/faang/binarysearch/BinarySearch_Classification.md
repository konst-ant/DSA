## All Binary Search can be classified in the following cases:

1. Exact match — find an existing element  

```
while (lo <= hi) {
int mid = lo + (hi - lo) / 2;

    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        lo = mid + 1;
    } else {
        hi = mid - 1;
    }
}
return -1;
```

2. Boundary search — find the insertion position

// example of finding lower boundary - notice we're moving right boundary (hi) on equals to reach the left-most equal element
```
while (lo < hi) {
int mid = lo + (hi - lo) / 2;

    if (nums[mid] < target) {
        lo = mid + 1;
    } else {
        hi = mid;
    }
}
return lo;
```

// example of finding upper boundary - notice we're moving left boundary (lo) on equals to reach the right-most equals element
```
while (lo < hi) {
int mid = lo + (hi - lo) / 2;

    if (nums[mid] <= target) {
        lo = mid + 1;
    } else {
        hi = mid;
    }
}
return lo;
```

3. Answer-space search — optimise a result

// Example from KoKoEatingBananas
```
while (lo < hi) {
int mid = lo + (hi - lo) / 2;

    if (hoursNeeded(piles, mid) > h) {
        lo = mid + 1;
    } else {
        hi = mid;
    }
}
return lo;
```

