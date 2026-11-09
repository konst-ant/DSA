# Live Coding Interview Task Catalog

Tasks found in this repository, sorted descending by relevance/likelihood for a **modern live coding interview** (common patterns — arrays/hashing, two pointers, sliding window, stacks, linked lists, trees/graphs/BFS-DFS, heaps, binary search, dynamic programming, backtracking — ranked highest; classic Codility-style counting/array tasks ranked mid; language trivia, concurrency gotchas, benchmarks, and niche data-structure builds ranked lowest).

All paths are relative to `src/main/java/` unless noted.

1. **Two Sum** — `leetcode2/TwoSum.java`
2. **Three Sum** — `leetcode2/ThreeSum.java`
3. **Longest Substring Without Repeating Characters** — `pastInterviews/LongestSubstring.java`
4. **Valid / Balanced Parentheses** — `leetcode2/ValidParentheses.java`, `leetcode2/BalancedBrackets.java`, `leetcode2/WellFormedParentheses.java`
5. **Minimum Remove to Make Valid Parentheses** — `leetcode2/MinimumRemoveToMakeValidParentheses.java`
6. **Merge Intervals** — `leetcode2/MergeIntervals.java`
7. **Merge Two Sorted Arrays** — `leetcode2/MergeSortedArrays.java`
8. **Subarray Sum Equals K** — `leetcode2/SubarraySumEqualsK.java`
9. **Sort Colors (Dutch National Flag)** — `pastInterviews/ColorsInPlaceSort.java`
10. **Top K Frequent Elements/Words** — `leetcode2/TopKFrequentWords.java`, `misc/KMostFrequentElements.java`
11. **Kth Largest Element in an Array** — `leetcode/KthLargestArrayElement.java`
12. **K Closest Points to Origin** — `leetcode2/KClosestPoints.java`
13. **Median of Two Sorted Arrays** — `leetcode/MedianTwoSortedArrays.java`, `leetcode2/MedianOfTwoSortedArrays.java`
14. **Find Median from Data Stream** — `leetcode2/MedianFinder.java`
15. **First Non-Repeated Character in a String** — `pastInterviews/FirstNonRepeatedCharacter.java`
16. **Most Common Word (with banned list)** — `leetcode2/MostCommonWord.java`
17. **Unique Email Addresses** — `leetcode2/UniqueEmailAddresses.java`
18. **Reverse Integer** — `leetcode2/ReverseInteger.java`
19. **Partition Labels** — `leetcode2/PartitionLabels.java`
20. **Longest Palindromic Substring** — `misc/LongestPalindromicSubstring.java`
21. **Minimum Covering Substring (find minimal unique substrings containing all chars)** — `pastInterviews/FindSubString.java`
22. **Word Break II (construct valid sentences)** — `pastInterviews/FindProperSentence.java`
23. **Shortest Unsorted Continuous Subarray** — `leetcode2/ShortestUnsortedContinuousSubarray.java`
24. **License Key Formatting** — `leetcode2/LicenseKeyFormatting.java`
25. **Two Sum (HashMap variant)** — `misc/FindTwoNumbers.java`
26. **Common Elements in Three Sorted Arrays** — `misc/CommonIntegersThreeSortedArrays.java`
27. **Reverse Order of Words in a String** — `misc/ReverseOrderOfWords.java`
28. **Reverse a String (multiple approaches)** — `pastInterviews/StringReversion.java`
29. **All Unique Characters in a String** — `crackingCodingInterview/AllUniqueCharacters.java`
30. **String Compression** — `crackingCodingInterview/CompressString.java`
31. **Stock Span Problem (Compute Spans)** — `misc/ComputeSpans.java`
32. **Min Stack (O(1) minimum retrieval)** — `pastInterviews/m/StackWithMinValue.java`
33. **LRU Cache** — `cache/LRUCache.java`, `cache/LRUCache2.java`, `cache/LRUCache3.java`, `cache/LRUCache4.java`, `cache/Node.java`
34. **Max Heap Implementation** — `cache/MaxHeap.java`
35. **Detect Linked List Cycle** — `lists/DetectLinkedListCycle.java`
36. **Copy Linked List with Random Pointer** — `lists/CopyLinkedListWithRandom.java`, `lists/CopyLinkedListWithRandom2.java`
37. **Circularly Linked List Implementation** — `lists/CircularlyLinkedList.java`
38. **Singly Linked List Implementation** — `cache/SinglyLinkedList.java`
39. **Number of Islands** — `leetcode/CountIslands.java`
40. **Rotting Oranges** — `leetcode2/RottingOranges.java`
41. **Word Ladder** — `leetcode2/WordLadder.java`
42. **Word Search in Grid** — `leetcode/WordSearch.java`
43. **Implement Trie (Prefix Tree)** — `pastInterviews/Trie.java`
44. **Binary Search Tree Insert & Find** — `pastInterviews/BinaryTreeInsertAndFind.java`
45. **Binary Search Tree (generic implementation)** — `trees/BST.java`
46. **Binary Tree Maximum Path Sum** — `leetcode2/BinaryTreeMaxPathSum.java`
47. **Dijkstra's Shortest Path** — `graphs/DijkstraShortestPath.java`
48. **Clone/Copy a Graph** — `graphs/CopyGraph.java`
49. **Common Dependencies in a DAG** — `graphs/CommonDependencies.java`
50. **N-Queens** — `leetcode2/NQueens.java`
51. **Maximal Rectangle in Binary Matrix** — `leetcode2/MaximalRectangle.java`, `leetcode2/MaximalRectangle2.java`
52. **Peak Index in a Mountain Array** — `leetcode2/PeakIndexInAMountainArray.java`
53. **Search in Mountain Array** — `leetcode2/FindInMountainArray.java`
54. **Square Root via Binary Search** — `misc/SquareRoot.java`
55. **Odd Even Jump** — `leetcode2/OddEvenJump.java`
56. **0/1 Knapsack** — `dp/knapsack/KnapsackRecursive.java`, `dp/knapsack/KnapsackTabular.java`, `dp/knapsack/KnapsackBad.java`
57. **Unbounded Knapsack** — `dp/knapsack/unbounded/KnapsackRecursive.java`, `dp/knapsack/unbounded/KnapsackTabular.java`
58. **Coin Change — Minimum Coins** — `dp/knapsack/unbounded/MinimumCoinChangeRecursive.java`, `dp/knapsack/unbounded/MinimumCoinChangeTabular.java`, `dp/knapsack/unbounded/MinimumCoinChangeTabular2.java`
59. **Coin Change — Count Combinations** — `dp/knapsack/unbounded/CoinChangeRecursive.java`, `dp/knapsack/unbounded/CoinChangeTabular.java`
60. **Coin Change (LeetCode variants)** — `leetcode2/CoinChange.java`, `leetcode2/CoinChange2.java`, `leetcode2/CoinChange3.java`
61. **Rod / Ribbon Cutting** — `dp/knapsack/unbounded/MaximumRibbonCutRecursive.java`, `dp/knapsack/unbounded/MaximumRibbonCutTabular.java`
62. **Subset Sum — Does It Exist** — `dp/knapsack/DoesExistSubsetOfSumRecursive.java`, `dp/knapsack/DoesExistSubsetOfSumTabular.java`
63. **Subset Sum — Count Ways** — `dp/knapsack/HowManySubsetsOfSumRecursive.java`, `dp/knapsack/HowManySubsetOfSumTabular.java`
64. **Equal Sum Partition** — `dp/knapsack/TwoEqualSubsetsRecursive.java`, `dp/knapsack/TwoEqualSubsetsTabular.java`, `dp/knapsack/TwoEqualSubsetsBad.java`
65. **Minimum Subset Sum Difference** — `dp/knapsack/TwoSubsetsWithMinimumDifferenceRecursive.java`, `dp/knapsack/TwoSubsetsWithMinimumDifferenceTabular.java`
66. **Target Sum (Positive/Negative Assignment)** — `dp/knapsack/PositiveOrNegativeRecursive.java`
67. **Longest Increasing Subsequence** — `dp/knapsack/LongestIncreasingSequence.java`
68. **Longest Palindrome (DP)** — `dp/palindromic/LongestPalindrome.java`, `dp/palindromic/LongestPalindromeBottomUp.java`, `dp/palindromic/LongestPalindromeRecursive.java`
69. **Fibonacci Sequence** — `dp/fibonacci/Fibonacci.java`, `dp/fibonacci/FibonacciIterative.java`, `dp/fibonacci/FibonacciGoodrichTamassia.java`
70. **Climbing Stairs** — `dp/fibonacci/StairCaseRecursive.java`, `dp/fibonacci/StairCaseTabular.java`, `crackingCodingInterview/StairCaseClimbing.java`
71. **House Robber (Maximum Non-Consecutive Sum)** — `dp/fibonacci/MaximumNonConsecutiveRecursive.java`, `dp/fibonacci/MaximumNonConsecutiveBottomUp.java`
72. **Minimum Jumps to Reach the End** — `dp/fibonacci/MinimumLeapsRecursive.java`, `dp/fibonacci/MinimumLeapsBottomUp.java`
73. **Minimum Cost Jumps** — `dp/fibonacci/MinimumLeapsWithCostRecursive.java`, `dp/fibonacci/MinimumLeapsWithCostBottomUp.java`
74. **Number of Ways to Sum to N (Addends)** — `dp/fibonacci/NumberAddendsTabular.java`
75. **Generate All Permutations** — `misc/AllPermutations.java`
76. **Generate All Subsets** — `misc/AllSubsets.java`
77. **Combinations Summing to a Target (Fill to Twenty)** — `misc/FillToTwenty.java`
78. **Tower of Hanoi** — `recursion/HanoiTower.java`
79. **Robot Unique Paths (with Obstacles)** — `crackingCodingInterview/RobotPath.java`
80. **Generic Merge Sort** — `sorting/GenericMergeSort.java`
81. **Generic Comparable-Based Sort** — `sorting/GenericSort.java`
82. **Collatz Conjecture Sequence** — `pastInterviews/m/CollatzConjecture.java`, `pastInterviews/m/CollatzConjecture2.java`
83. **Prison Cells After N Days** — `leetcode2/PrisonCellsAfterNDays.java`
84. **Maximize Value by Repeating a Digit (R of X)** — `leetcode2/MaximizeRofX.java`
85. **Bounded Leaderboard / High-Score Tracker (OOD)** — `misc/GameHighScore.java`
86. **Document Page Validation Rules (OOD)** — `pastInterviews/Design.java`
87. **Simple Parenthesized Calculator** — `misc/SimpleCalculator.java`
88. **Print Multiplication Table** — `pastInterviews/m/TimeTable.java`
89. **Binary Gap** — `codility/Task1_BinaryGap.java`
90. **Cyclic Rotation of an Array** — `codility/Task2_CyclicRotation.java`
91. **Odd Occurrences in an Array** — `codility/Task3_OddOccurencesInArray.java`
92. **Frog Jump** — `codility/Task4_FrogJump.java`
93. **Permutation Missing Element** — `codility/Task5_PermMissingElem.java`
94. **Tape Equilibrium** — `codility/Task6_TapeEquilibrium.java`
95. **Frog River One** — `codility/Task7_FrogRiver.java`
96. **Max Counters** — `codility/Task8_MaxCounters.java`
97. **Missing Integer** — `codility/Task9_MissingInteger.java`
98. **Permutation Check** — `codility/Task10_PermCheck.java`
99. **Count Divisible Numbers in Range** — `codility/Task11_CountDiv.java`
100. **Genomic Range Query** — `codility/Task12_GenomicRangeQuery.java`
101. **Minimum Average Two-Element Slice** — `codility/Task13_MinAvgTwoSlice.java`
102. **Passing Cars** — `codility/Task14_PassingCars.java`
103. **Distinct Values in Array** — `codility/Task15_DistinctValues.java`
104. **Maximum Product of Three** — `codility/Task16_MaxProductOfThree.java`
105. **Number of Disc Intersections** — `codility/Task17_NumberOfDiscs.java`, `codility/NumberOfDiscIntersections.java`
106. **Triangle Check** — `codility/Task18_Triangle.java`
107. **Brackets Validation** — `codility/Task19_Brackets.java`
108. **Fish Survival Simulation** — `codility/Task20_Fish.java`
109. **Nesting (Balanced Parens)** — `codility/Task21_Nesting.java`
110. **Stone Wall** — `codility/Task22_StoneWall.java`
111. **Dominator Element** — `codility/Task23_Dominator.java`
112. **EquiLeader** — `codility/Task24_Equileader.java`
113. **Max Double Slice Sum** — `codility/Task25_MaxDoubleSliceSum.java`
114. **Max Profit from Stock Prices** — `codility/Task26_MaxProfit.java`
115. **Max Slice Sum (Kadane's Algorithm)** — `codility/Task27_MaxSliceSum.java`
116. **Maximum Flags on Hill Peaks** — `codility/Task29_MaximumFlags.java`
117. **Maximum Peak Blocks** — `codility/Task31_MaximumPeakBlocks.java`
118. **Count Triangles** — `codility/Task42_CountTriangles.java`
119. **Greatest Common Divisor** — `codility/GCD.java`
120. **Minimum Split of a String into Unique Substrings** — `codility/MinimumSplitStringToUnique.java`
121. **Count Non-Divisible Numbers** — `codility/NonDivisible.java`
122. **Linked List/Cycle Length via Index-Array** — `codility/Codility2.java`
123. **First Missing Positive Number** — `codility/Codility.java`
124. **Count Repeats of "BANANA" from Letters** — `pastInterviews/CountBananas.java`
125. **Maximum Combined Length of Two Sticks** — `pastInterviews/TwoWoodenSticks.java`
126. **Longest Constant-Distance Subsequence** — `pastInterviews/MaximumEqualDistanceSequence.java`
127. **equals()/hashCode() Contract Demo** — `javaLanguage/EqualsAndHashcode.java`
128. **Sort a Map by Value** — `javaLanguage/MapUtils.java`
129. **TimeZone API Exploration** — `javaLanguage/TimezoneTry.java`
130. **Effectively-Final Class via Private Constructor** — `javaLanguage/privateconstructor/A.java`, `javaLanguage/privateconstructor/B.java`
131. **Concurrency Visibility Gotcha (interview trivia)** — `pastInterviews/OomaConcurrency.java`
132. **ArrayList vs LinkedList Performance Benchmark** — `benchmark/ArrayListVsLinkedList.java`, `benchmark/ArrayListVsLinkedList_NoBenchmark.java`
133. **Inverse Square Sequence Benchmark** — `benchmark/InverseSquareSequence.java`
134. **B+ Tree Implementation** — `trees/btreeplus/BTree.java`, `trees/btreeplus/BTreeInnerNode.java`, `trees/btreeplus/BTreeLeafNode.java`, `trees/btreeplus/BTreeNode.java`, `trees/btreeplus/BTreeTest.java`, `trees/btreeplus/DebugStopper.java`
