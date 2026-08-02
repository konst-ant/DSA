# B+ Tree – Semantics & Design Notes

## Core Concepts

- **Structure**
    - **Inner (non-leaf) nodes**: store **keys only** and are used for navigation.
    - **Leaf nodes**: store actual **(key, value)** entries.

- **Generic Types**
    - Both **key** and **value** are arbitrary Java objects: `Tkey`, `TValue`.
    - Ordering is defined by key comparison (`Comparable` or comparator).

- **(Key, Value) Model**
    - The tree stores entries as **logical pairs**: `(key, value)`.
    - Duplicate keys are **allowed**; uniqueness is on the pair, not the key.
    - Duplicate key entries are implemented as separate entries, following adjacently left-to-right in order of insertion

- **Balancing**
    - Insertions may cause inner **node splits** (propagating up).
    - Deletions may cause inner **node merges/redistribution** (propagating up).
    - Tree remains **balanced** (all leaves at the same depth).

- **Leaf-Level Linking**
    - Leaf nodes are connected via **left/right pointers** (doubly-linked list).
    - Enables efficient **sequential and range traversal**.

## Operation Semantics

This B+ tree is designed as a **prototype of a database index structure**.

- Models a **secondary index**:
    - the tree works as `Multimap<TKey → List<TValue>>`
    - key may appear multiple times in leaves, so as to index multiple tuples (TValue) having same key (e.g. age -> many users)
    - hence `insert(TKey key, TValue value)` is adding preserving overall order, plus duplicate key entries are adjacent in insertion order
    - `delete(TKey key, TValue value)` is primary index update operation when some entry of given **key* is deleted from table
    - range scan operations allow for SQL queries with predicates `key between 123 and 567`
  
## Complexity

- Search / insert / delete: O(log n)
- Range scan: O(log n + k) where k = number of results


