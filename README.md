# IP addresses

This project contains a pair of functions that unambiguously convert the string representation of an IpV4 address (of the form "127.0.0.1") to an int32 value and vice versa.

### Examples

```java
// Converting an IpV4 address to int32
ipToInt32("128.32.10.0"); // 2149583360
ipToInt32("0.0.0.255"); // 255

// Converting int32 to an IpV4 address
int32ToIp(2149583360); // "128.32.10.0"
int32ToIp(255); // "0.0.0.255"
```

### Data

All the data needed for this project are stored in the ***ip_to_int*** directory.

# Tends to zero or infinity?

This project contains a function that calculates the value of the expression:

$$
u_n = \frac{1}{n!} \cdot \left(1! + 2! + 3! + \dots + n!\right)
$$

for integer *n* > 1 (with an accuracy of no worse than 6 decimal places). The project also proves that this expression tends to the 1 as *n* tends to infinity.

### Examples

```java
// Calculating the value of u_n for n = 10
calculateSeries(10, 6); // 1.112741

// Calculating the value of u_n for n = 45
calculateSeries(45, 6); // 1.022739
```

### Data

All the data needed for this project are stored in the ***factorial_check*** directory.

# Unauthorized deliveries

This project implements the following steps:

1. Read the *logins.csv* file from the local file system
2. Read the *postings.csv* file from the local file system (rows with values in the `Mat. Doc.` field)
3. Add a boolean field `authorized` to the data from postings.csv, which will indicate that `User Name` (*postings.csv*) is in the list of `AppAccountName` (*logins.csv*) and `IsActive`
4. Save the data from the *logins.csv* file to the SQL DBMS
5. Save the data from the *postings.csv* file to the SQL DBMS (with an additional field)
6. Return by GET (REST API) for a period (day, month, quarter, year) the data from the database loaded from *postings.csv* (with the possibility of a request with a filter by the field `authorized`)

### Data

All the data needed for this project are stored in the ***unauthorized_supplies*** directory.
