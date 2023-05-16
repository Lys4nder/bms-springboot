package com.project.transactions;

public class TransactionNotFoundException extends Throwable{
    TransactionNotFoundException(String message) {
        super(message);
    }
}
