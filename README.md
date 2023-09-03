# alacriti

# Description
This project has been designed using micro-services architecture. It contains 2 spring boot application. The database is a relationed database (Postgresql). It utilizes db merchant which has 2 tables merchant and payment. The spring boot application utilizes the following dependencies spring-boot-starter-data-jpa, spring-boot-starter-web, spring-boot-devtools, postgresql and lombok.

1. Merchant Application
2. Payment Application

# Merchant Application
It has 2 RestControllers.

## Merchant Controller

It has 1 endpoint. POST "api/register_payment" with below request body.

{
    "merchantId": "8282",
    "name": "Merchant Name",
    "email": "merchant@example.com",
    "businessType": "Online Retail",
    "address": "123 Main St, City",
    "phone": "123-456-7890"
}

The above endpoint, does a restTemplate call internally to Payment microservice POST "api/register" which saves the details in merchant table under merchant db and returns a string confirmation message.

## Payment Controller

It has 2 endpoints.

1. POST "api/payment" with below request body.

{
    "merchantId": "8282",
    "amount": 50.00,
    "currency": "USD",
    "orderId": "order123"
}

The above endpoint, does a restTemplate call internally to Payment microservice POST "api/payment" which saves the details in payment table under merchant db and returns a string confirmation message.

2.  GET "api/payment_status/{paymentId}" with paymentId to be checked.

The above endpoint, does a restTemplate call internally to Payment microservice POST "api/payment/{paymentId}" which fetches the details from payment table under merchant db and returns a string confirmation message.
