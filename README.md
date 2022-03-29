# accountmanager
Mox Bank Coding Assessment - Application to Backend Engineer

Restful API

Check Balance 
localhost:8080/checkBalance
Method Get
{
    "accountNum":12345678
}


Transfer Money Betwen Accounts
localhost:8080/transfer
Method Post
{
    "fromAccountNum":12345678,
    "toAccountNum":88888888,
    "amount":100000

}

