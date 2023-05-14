# Parallel Merge Sort

This project provides a parallel implementation of the merge sort algorithm in Java using multithreading.

## Features

- Parallel implementation of the merge sort algorithm using the `RecursiveAction` class from the `java.util.concurrent` package.
- Unit tests to verify the correctness of the implementation.
- Performance comparison with the sequential version of the merge sort algorithm.

## Usage

To use the parallel merge sort algorithm, create an instance of the `ParallelMergeSort` class and pass it to the `invoke()` method of a `ForkJoinPool`:

```java
int[] array = ...
ForkJoinPool pool = new ForkJoinPool();
pool.invoke(new ParallelMergeSort(array, 0, array.length));
```

This will sort the specified array in parallel using the merge sort algorithm.

## Documentation
The documentation provided in the specific directory `documentation` 

You can generate HTML documentation for this project using the javadoc tool. Run the following command from the project directory to generate the documentation:

`javadoc ParallelMergeSort.java`

This will generate HTML documentation in a directory named doc. Open the index.html file in this directory using a web browser to view the documentation.

## License
This project is licensed under the MIT License. See the LICENSE file for details.


This `README.md` file provides an overview of your project, including its features and usage instructions. It also includes information about how to generate documentation for your code and a brief mention of the project's license.

You can customize this template to include additional information about your project, such as its dependencies, installation instructions, and contribution guidelines.