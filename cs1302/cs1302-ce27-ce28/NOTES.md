# Notes

## Bubble Sort Algo

```java
void bubble(array, lo, hi, c) {
    // REMEMBER, n = hi - lo + 1
    for (int i = lo; i < hi; i++) { // --------------------------\
        if (c.compare(array[i], array[i + 1]) > 0) { // -----> 1 | = hi - lo + 1 -> U(n) = 1 * (hi - lo + 1)
            swap(array, i, i + 1);                               |                       = 1 * n [since n = hi - lo + 1]
        } // if                                                  |                       = n
    } // for // -------------------------------------------------/
} // bubble
```

```java
void bubbleSort(array, lo, hi, c)
    // REMEMBER, n = hi - lo + 1
    for (int i = hi; i > lo; i --) { // -------------\
        bubble(array, lo, i, c); // -----------> < n | n -> T(n) < n * n
    } // for // -------------------------------------/           < n^2
} // bubble
```
   ANSWERS

i. U(lo, hi) = n

ii. T(n) < n^2


## Selection Sort Algo

```java
void selectMin(array, lo, hi, c) {
    // REMEMBER, n = hi - lo + 1
    int min = lo;
    for (int i = lo; i <= hi; i ++) { // -----------------\
        if (c.compare(array[min], array[i]) > 0) { --> 1  | n -> W(n) = n
            min = i;                                      |
        } // if                                           |
    } // for // ------------------------------------------/
    swap(array, min, lo); -----> 1 | U(n) = 1
} // selectMin
```

```java
void selectionSort(array, lo, hi, c)
    // REMEMBER, n = hi - lo + 1
    for (int i = lo; i < hi; i ++) { //------------------\
        selectMin(array, i, hi, c); // -----> U(n) = 1   | n -> T[swap](n) = 1 * n  = n
                                    // -----> W(n) = < n | n -> T[compare](n) < n^2
    } // for // -----------------------------------------/
} // selectionSort
```
   ANSWERS

i. T(n) = n

ii. T(n) < n^2


## Partition Algo

```java
void partition(array, lo, pivot, hi, c) {
    // REMEMBER, n = hi - lo + 1
    swap(array, pivot, hi); // ----------------------> 1
    int i = lo;
    for (int j = lo; j < hi; j++) { // -------------------\
        if (c.compare(array[j], array[hi]) < 0) { // -> 1 | n -> T[compare](n) = n * 1 = n
            swap(array, i, j); // --------------------> 1 | n -> T[swap](n) = (n * 1) + 1 + 1
            i += 1;                                       |                 = n + 2
        } // if                                           |
    } // for // ------------------------------------------/
    swap(array, i, hi); // --------------------------> 1
    return i;
} // partition
```
   ANSWERS

i. T(n) = n + 2

ii. T(n) = n