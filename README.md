# Project 3 - SHA-256 Hashing

**Author:** Sean Clewis  
**Project:** SHA-256 Hashing Exploration  

## Project Overview
This project explores the use of the SHA-256 cryptographic hashing algorithm using Java and the `MessageDigest` library. The project includes two main tasks: evaluating the time it takes to hash files of different sizes and attempting to match hash values to specific digits of a chosen date using brute force. The project was developed using the IntelliJ IDEA.

## Features
- **SHA-256 Hashing**: Implemented SHA-256 hashing of arbitrary text using the Java `MessageDigest` library.
- **Performance Measurement**: Evaluated the time taken to hash a long and short text file on high-performance hardware.
- **Brute-Force Hash Matching**: Implemented a brute-force approach to find hash values matching specific digits of a target value.

## Task 1: File Hashing Performance
- **Hardware**: Intel i7-13700K processor, NVIDIA RTX 4090 GPU.
- **Files**: 
  - **Long file**: Arbitrary text file.
  - **Short file**: Another arbitrary text file.
- **Performance Results**:
  - **Long file**: 0.0107303 seconds to hash.
  - **Short file**: 6.459E-4 seconds to hash.

SHA-256 produces 2^256 possible hash values. To find a collision, one would need to go through at least 2^128 hashes. Based on my performance results, it would take approximately 1.60x10^18 years to find a collision, making it computationally infeasible to brute force.

## Task 2: Brute-Force Hash Matching
For this task, I attempted to find hash values that matched the digits of my birthday: **01/09/1997**.

- **Logging Setup**: I set up output feedback every 1 million attempts to ensure that the code was running properly. The program also logs the time it took after finding a matching hash value.
- **Performance Results**:
  - **First 4 digits**: Less than a second to find a matching hash.
  - **5th digit**: 6 seconds, 1,369,265 attempts.
  - **6th digit**: 1 minute, about 15 million attempts.
  - **7th digit**: 6 minutes, 81 million attempts.
  - **8th digit**: Unable to find a matching hash after letting the program run for 3 hours. The integer variable tracking the number of attempts exceeded its size and started outputting negative values.

### Insights:
- The process was surprisingly fast, with 15 million hash attempts completed in about 6 seconds.
- However, as more digits were added, the time required to find a matching hash increased exponentially.
- By the time I reached 7 digits, it took significantly longer, and matching all 8 digits proved infeasible within a reasonable time frame.
  
This demonstrates the robustness of SHA-256, as finding specific hash values for longer outputs becomes increasingly difficult.

## Project Structure
- **Source Code**: The Java source code is located in the two seperate task files.
- **Screenshots**: Zipped folder containing screenshots of code executions and project snapshots.

## How to Use
1. **Run the Program**: 
   - The program takes text files as input and outputs their SHA-256 hash values.
   - For Task 2, the program attempts to find hash values matching specified digits by brute force.

2. **Evaluate Results**:
   - Check the console output for performance results and hash matches.
   - Screenshots of execution are included for reference.

## Installation
1. **Java**: Ensure you have Java installed.
2. **IDE**: Use IntelliJ IDEA or another Java-compatible IDE to run the project.
3. **MessageDigest Library**: This is part of Java's standard libraries, so no additional installations are required.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
