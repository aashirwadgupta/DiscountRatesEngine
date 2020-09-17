# Discount Rates Engine
Java application to prepare a engine to calculate final cart price after applying sales and promotional offers. 

## Given some items with their base price as follows

| Item  | Price|
| :-: | :-: |
| Item1 | 50   |
| Item2 | 45   |
| Item3 | 30   |
| Item4 | 15   |

## Given the promotional offer as below

| Item  | Condition of offer | Discounted Rates |
| :-: | :-: | :-: |
| Item1 | Buy 3 | 130 |
| Item2 | Buy 2 | 60 |
| Item3 & Item4 | Buy a combo of both | 20|

## Cart Items - Test Cases

### Cart Items - Case 1
| Item  | Quantity|
| :-: | :-: |
| Item1 | 4   |
| Item2 | 3   |
| Item3 | 2   |
| Item4 | 1   |

Applying the promotional offer the total value of cart should be **335**
- Explaination is as below
  - 4 Item 1 - 3 for discounted rate @ 130 and 1 for 50
  - 3 Item 2 - 2 for discounted rate @ 60 and 1 for 45
  - 2 Item3 and 1 Item4 - 1 quantity of Item3 @ 30 and a combo of Item3 and Item4 @ 20
  
### Cart Items - Case 2
| Item  | Quantity|
| :-: | :-: |
| Item1 | 3   |
| Item2 | 5   |
| Item4 | 1   |

Applying the promotional offer the total value of cart should be **310**
- Explaination is as below
  - 3 Item1 - 3 for discounted rate @ 130 
  - 5 Item2 - 2 pairs for discounted rate @ 60 each (total 120) and 1 for 45
  - 1 Item4 - 1 Item4 priced @ 20
