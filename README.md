# Bank Account Management System

## Project Overview
The Bank Account Management System is a Java-based platform that enables users to perform financial transactions such as deposits, withdrawals, transfers, and account management. It efficiently handles client queues, manages transaction history, and ensures organized and reliable banking operations.

## Features
- Client Queue Management (FIFO)
- Account creation & management
- Deposits, Withdrawals, Transfers
- Transaction history with Stack
- Robust exception handling

## Data Structures Used
- Queue → Manages client order for service.
- Singly Linked List → Stores and manages bank accounts.
- Stack → Maintains transaction history (latest to oldest).
  
## Project Structure
- LLQueue → Client queue (enqueue, dequeue, assist next).
- LinkedList → Account list (create, view, deposit, withdraw, transfer).
- LLStack → Transactions (push, pop, reset history).
- Account → Base class for account details.
- Transactional & Savings Accounts → Specialized account types.
- Transaction → Stores transaction details.
- Main → Entry point with menu-driven options.
  
## Main Menu Options
- Client Queue
- View Next Client
- Assist Next Client
- Create Account
- View Past Transactions
- Deposit
- Withdraw
- Transfer
- View Account
- Reset Account History
- Exit

## This project is developed as part of Data Structures course, By:
- Danah Aldhawi
- Haifa Alghafis
- Raghad Alduaij
- Amani Alhusseini
- Leen Alsaif
