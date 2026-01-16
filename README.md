# Java Code Challenges

This project contains a collection of algorithmic and logical code challenges implemented in Java 17 or higher.
It is designed as a lightweight, single-layer project focused exclusively on problem-solving and clean code.

## Architecture

This project follows a **single-layer, utility-class architecture** designed specifically for code challenge implementations. The architecture emphasizes:

### Design Principles
- **Single Responsibility**: Each method solves one specific problem
- **Pure Functions**: All methods are static and stateless, producing deterministic outputs
- **Functional Programming**: Heavy use of Java Streams API for elegant, declarative solutions
- **Optimal Performance**: All solutions are optimized for time complexity, with Big-O notation documented
- **Zero Dependencies**: Pure Java implementation with no external frameworks or libraries

### Architecture Characteristics
- **Single Layer**: No separation into service, repository, or controller layers - just one utility class
- **Static Methods**: All challenges are implemented as static utility methods for easy invocation
- **Immutable by Default**: Solutions prefer immutable data structures and avoid side effects
- **Stream-Based**: Solutions leverage Java Streams API whenever it improves readability and performance

### Code Organization
```
com.andres.codechallenges.CodeChallenges
├── Each challenge is a static method
├── Method names are descriptive and indicate the challenge being solved
├── Each method has a header comment with:
│   ├── Challenge description
│   └── Time Complexity (Big-O notation)
└── Solutions prioritize optimal algorithms with Streams when applicable
```

### Project Structure
```
java-code-challenges/
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── andres/
                    └── codechallenges/
                        └── CodeChallenges.java (All 23+ challenges)
```

## Code Challenges

This project contains **23 code challenges**, each with:
- Clear problem statement in method comments
- Optimal solution using Java best practices
- Stream-based implementation when applicable
- Documented time complexity (Big-O notation)
- Descriptive method names

### Challenge Categories
- **Array/List Manipulation**: Filtering, sorting, searching, transformations
- **String Operations**: Palindromes, anagrams, character counting, pattern matching
- **Mathematical Problems**: Primes, GCD, factorial, Fibonacci, digit operations
- **Search Algorithms**: Binary search, finding elements, missing numbers
- **Data Structure Operations**: Intersections, grouping, counting, duplicates

## Requirements
- Java 17 or higher
- No external dependencies
- Compatible with any Java IDE or build tool

## How to Run

### Option 1: Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Ensure Java 17+ is configured as the project SDK
3. Create a test class or use the scratch file feature to call static methods:
   ```java
   import com.andres.codechallenges.CodeChallenges;
   
   public class Test {
       public static void main(String[] args) {
           boolean result = CodeChallenges.isPalindrome("racecar");
           System.out.println(result); // true
       }
   }
   ```

### Option 2: Command Line
```bash
# Compile
javac -d build src/main/java/com/andres/codechallenges/CodeChallenges.java

# Run (with your test class)
java -cp build com.andres.codechallenges.CodeChallenges
```

## Usage Examples

```java
import com.andres.codechallenges.CodeChallenges;
import java.util.List;

// Sum even numbers
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
int sum = CodeChallenges.sumEvenNumbers(numbers); // 12

// Check palindrome
boolean isPal = CodeChallenges.isPalindrome("racecar"); // true

// Find second largest
int second = CodeChallenges.findSecondLargest(List.of(3, 1, 4, 1, 5)); // 4

// Group strings by length
Map<Integer, List<String>> grouped = CodeChallenges.groupStringsByLength(
    List.of("a", "bb", "ccc", "dd", "eee")
);
```

## Performance Notes

All solutions are optimized with their time complexity documented:
- **O(1)**: Constant time operations
- **O(log n)**: Logarithmic operations (binary search, GCD)
- **O(n)**: Linear time operations (most challenges)
- **O(n log n)**: Comparison-based sorting operations
- **O(n²)**: Nested iterations (avoided when possible)

## Contributing

When adding new challenges:
1. Create a static method with a descriptive name
2. Add a header comment with challenge description and time complexity
3. Prefer Stream-based solutions when applicable
4. Ensure optimal time complexity
5. Keep solutions clean and readable