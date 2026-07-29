# Algorithm Patterns Study Guide (33 Core Patterns)

---

## 1. Two Pointers
**Trigger words:** sorted array, pair, palindrome  
**Core idea:** Move two indices toward each other  
**Examples:**
- Two Sum II (sorted)
- Container With Most Water
- Valid Palindrome
- 3Sum  
  **Complexity:** O(n)

---

## 2. Sliding Window
**Trigger words:** substring, subarray, longest/shortest  
**Core idea:** Maintain dynamic window  
**Examples:**
- Longest Substring Without Repeating Characters
- Minimum Window Substring
- Maximum Sum Subarray of Size K
- Longest Repeating Character Replacement  
  **Complexity:** O(n)

---

## 3. Prefix Sum
**Trigger words:** range sum, cumulative  
**Core idea:** Precompute prefix sums  
**Examples:**
- Subarray Sum Equals K
- Range Sum Query
- Continuous Subarray Sum
- Product of Array Except Self  
  **Complexity:** O(n)

---

## 4. Hash Map / Frequency Counting
**Trigger words:** count, frequency  
**Core idea:** Store counts for fast lookup  
**Examples:**
- Two Sum
- Group Anagrams
- Top K Frequent Elements
- First Unique Character  
  **Complexity:** O(n)

---

## 5. Binary Search
**Trigger words:** sorted, search space  
**Core idea:** Halve search space  
**Examples:**
- Binary Search
- Search in Rotated Sorted Array
- Find First and Last Position
- Search Insert Position  
  **Complexity:** O(log n)

---

## 6. Binary Search on Answer
**Trigger words:** minimize/maximize  
**Core idea:** Search solution space  
**Examples:**
- Koko Eating Bananas
- Capacity to Ship Packages Within D Days
- Split Array Largest Sum
- Aggressive Cows  
  **Complexity:** O(n log n)

---

## 7. Fast & Slow Pointers
**Trigger words:** cycle detection  
**Core idea:** Different pointer speeds  
**Examples:**
- Linked List Cycle
- Find the Duplicate Number
- Happy Number
- Middle of Linked List  
  **Complexity:** O(n)

---

## 8. Intervals
**Trigger words:** overlapping ranges  
**Core idea:** Sort + merge intervals  
**Examples:**
- Merge Intervals
- Insert Interval
- Non-overlapping Intervals
- Meeting Rooms  
  **Complexity:** O(n log n)

---

## 9. Monotonic Stack
**Trigger words:** next greater/smaller  
**Core idea:** Maintain ordered stack  
**Examples:**
- Next Greater Element
- Daily Temperatures
- Largest Rectangle in Histogram
- Trapping Rain Water  
  **Complexity:** O(n)

---

## 10. Heap / Priority Queue
**Trigger words:** top K, min/max  
**Core idea:** Maintain heap  
**Examples:**
- Kth Largest Element
- Top K Frequent Elements
- Merge K Sorted Lists
- Find Median from Data Stream  
  **Complexity:** O(n log k)

---

## 11. Greedy
**Trigger words:** optimal locally  
**Core idea:** Choose best immediate option  
**Examples:**
- Jump Game
- Gas Station
- Candy
- Activity Selection  
  **Complexity:** O(n)

---

## 12. Backtracking
**Trigger words:** all combinations  
**Core idea:** Try + undo choices  
**Examples:**
- N-Queens
- Subsets
- Permutations
- Combination Sum  
  **Complexity:** Exponential

---

## 13. Recursion (General)
**Trigger words:** divide problem  
**Core idea:** Solve via smaller subproblems  
**Examples:**
- Factorial
- Fibonacci (recursive)
- Tree DFS
- Tower of Hanoi  
  **Complexity:** Varies

---

## 14. Dynamic Programming (1D)
**Trigger words:** overlapping subproblems  
**Core idea:** Store previous results  
**Examples:**
- Climbing Stairs
- House Robber
- Maximum Subarray (Kadane)
- Coin Change  
  **Complexity:** O(n)

---

## 15. Dynamic Programming (2D)
**Trigger words:** grid, subsequence  
**Core idea:** 2D state table  
**Examples:**
- Longest Common Subsequence
- Edit Distance
- Unique Paths
- Longest Palindromic Subsequence  
  **Complexity:** O(n²)

---

## 16. Bit Manipulation
**Trigger words:** XOR, bits  
**Core idea:** operate at bit level  
**Examples:**
- Single Number
- Missing Number
- Counting Bits
- Sum of Two Integers  
  **Complexity:** O(n)

---

## 17. Graph Traversal (DFS/BFS)
**Trigger words:** graph, traversal  
**Core idea:** explore nodes  
**Examples:**
- Number of Islands
- Clone Graph
- Flood Fill
- Surrounded Regions  
  **Complexity:** O(V+E)

---

## 18. Topological Sort
**Trigger words:** dependency, DAG  
**Core idea:** order nodes  
**Examples:**
- Course Schedule
- Course Schedule II
- Alien Dictionary
- Minimum Height Trees  
  **Complexity:** O(V+E)

---

## 19. Union-Find (DSU)
**Trigger words:** connected components  
**Core idea:** union + find  
**Examples:**
- Number of Provinces
- Redundant Connection
- Accounts Merge
- Kruskal’s MST  
  **Complexity:** ~O(1)

---

## 20. Shortest Path
**Trigger words:** shortest distance  
**Core idea:** Dijkstra/BFS  
**Examples:**
- Network Delay Time
- Cheapest Flights Within K Stops
- Dijkstra Algorithm
- Bellman-Ford  
  **Complexity:** O(E log V)

---

## 21. Trie (Prefix Tree)
**Trigger words:** prefix, dictionary  
**Core idea:** tree of characters  
**Examples:**
- Implement Trie
- Word Search II
- Replace Words
- Autocomplete System  
  **Complexity:** O(n)

---

## 22. Divide & Conquer
**Trigger words:** split and merge  
**Core idea:** break problem  
**Examples:**
- Merge Sort
- Quick Sort
- Maximum Subarray (divide)
- Binary Search  
  **Complexity:** O(n log n)

---

## 23. Sorting Algorithms
**Trigger words:** ordering  
**Core idea:** rearrange elements  
**Examples:**
- Quick Sort
- Merge Sort
- Heap Sort
- Selection Sort  
  **Complexity:** O(n log n)

---

## 24. Tree Traversals
**Trigger words:** binary tree  
**Core idea:** DFS/BFS traversal  
**Examples:**
- Inorder Traversal
- Preorder Traversal
- Level Order Traversal
- Zigzag Traversal  
  **Complexity:** O(n)

---

## 25. Binary Search Trees
**Trigger words:** ordered tree  
**Core idea:** left < root < right  
**Examples:**
- Validate BST
- Lowest Common Ancestor
- Kth Smallest Element
- Insert/Delete in BST  
  **Complexity:** O(log n)

---

## 26. Linked Lists
**Trigger words:** node pointers  
**Core idea:** pointer manipulation  
**Examples:**
- Reverse Linked List
- Merge Two Lists
- Remove Nth Node
- Detect Cycle  
  **Complexity:** O(n)

---

## 27. Segment Tree
**Trigger words:** range query/update  
**Core idea:** tree for intervals  
**Examples:**
- Range Sum Query
- Range Minimum Query
- Lazy Propagation
- Interval Updates  
  **Complexity:** O(log n)

---

## 28. Fenwick Tree (BIT)
**Trigger words:** prefix sum updates  
**Core idea:** compact tree  
**Examples:**
- Range Sum Query
- Inversion Count
- Frequency Table
- Dynamic Prefix Sum  
  **Complexity:** O(log n)

---

## 29. Sweep Line
**Trigger words:** events, intervals  
**Core idea:** process sorted events  
**Examples:**
- Meeting Rooms II
- Skyline Problem
- Rectangle Area
- Line Segment Intersection  
  **Complexity:** O(n log n)

---

## 30. String Matching
**Trigger words:** pattern search  
**Core idea:** efficient matching  
**Examples:**
- KMP Algorithm
- Rabin-Karp
- Z Algorithm
- strstr()  
  **Complexity:** O(n)

---

## 31. Rolling Hash
**Trigger words:** substring hash  
**Core idea:** sliding hash  
**Examples:**
- Rabin-Karp
- Longest Duplicate Substring
- Substring Search
- DNA Sequences  
  **Complexity:** O(n)

---

## 32. Greedy Scheduling / Interval Scheduling
**Trigger words:** schedule, deadlines  
**Core idea:** pick optimal ordering  
**Examples:**
- Activity Selection
- Meeting Rooms II
- Job Scheduling with Deadlines
- Airport Runway Scheduling  
  **Complexity:** O(n log n)

---

## 33. Randomized Algorithms
**Trigger words:** random pivot  
**Core idea:** randomness improves average  
**Examples:**
- Quickselect
- Randomized Quicksort
- Reservoir Sampling
- Shuffle Array  
  **Complexity:** Expected O(n)

---

# 🎯 Usage Strategy

- Learn **pattern recognition first**
- Solve **2–4 problems per pattern**
- Revisit weak areas weekly