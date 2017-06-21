<<<<<<< HEAD

=======
# API

## COMMON INFO
### URL
https://localhost:8443...

### STATUS
CODE | STATUS
---  | ---
200  | OK
201  | CREATED
304  | NOT MODIFIED
400  | BAD REQUEST
401  | UNAUTHORIZED - WRONG PASSWORD
404  | NOT FOUND

### LOGIN 
...URL              | METHOD    | INPUT                   | OUTPUT 
---                 | ---       | ---                     | --- 
/api/logIn          | GET       | None                    | User
/api/logOut         | GET       | HttpSession             | Boolean

#### EXAMPLE
[GET] */api/logIn*  
![Alt text](Capturas/REST/REST_logIn_A.PNG "REST logIn")
![Alt text](Capturas/REST/REST_logIn_B.PNG "REST logIn Output")

[GET] */api/logOut* 
![Alt text](Capturas/REST/REST_logOut_A.PNG "REST logOut")
![Alt text](Capturas/REST/REST_logOut_B.PNG "REST logOut Output")

### PRODUCTS
...URL              | METHOD    | INPUT                   | OUTPUT 
---                 | ---       | ---                     | --- 
/api/products/      | GET       | None                    | List of [Product]
/api/products/{id}  | GET       | Product.Id              | Product
/api/products/{name}| GET       | Product.Name            | Product
/api/products/      | POST      | Product                 | Product 
/api/products/{id}  | PUT       | Product.Id, Product     | Product 
/api/products/{id}  | DELETE    | Product.Id              | Product 

[GET] */api/products/*      
![Alt text](Capturas/REST/REST_products_GET_A.PNG "Products GET")
![Alt text](Capturas/REST/REST_products_GET_B.PNG "Products GET Output")

[GET] */api/products/{id}*  
![Alt text](Capturas/REST/REST_product_GET_A.PNG "Product GET")
![Alt text](Capturas/REST/REST_product_GET_B.PNG "Product GET Output")

[GET] */api/products/{name}*      
![Alt text](Capturas/REST/REST_product_GET_NAME_A.PNG "Product GET")
![Alt text](Capturas/REST/REST_product_GET_NAME_B.PNG "Product GET Output")

[POST] */api/products/*      
![Alt text](Capturas/REST/REST_product_POST_A.PNG "Product POST")
![Alt text](Capturas/REST/REST_product_POST_B.PNG "Product POST Output")

[PUT] */api/products/{id}*      
![Alt text](Capturas/REST/REST_product_PUT_A.PNG "Product PUT")
![Alt text](Capturas/REST/REST_product_PUT_B.PNG "Product PUT Output")

[DELETE] */api/products/{id}*      
![Alt text](Capturas/REST/REST_product_DELETE_A.PNG "Product DELETE")
![Alt text](Capturas/REST/REST_product_DELETE_B.PNG "Product DELETE Output")

### USERS
...URL              | METHOD    | INPUT                   | OUTPUT 
---                 | ---       | ---                     | --- 
/api/users/         | GET       | None                    | List of [User] 
/api/users/{id}     | GET       | User.Id                 | User
/api/users/         | POST      | User                    | User
/api/users/{id}     | PUT       | User.Id, Product        | User 
/api/users/{id}     | DELETE    | User.Id                 | User 

[GET] */api/users/*      
![Alt text](Capturas/REST/REST_users_GET_A.PNG "Users GET")
![Alt text](Capturas/REST/REST_users_GET_B.PNG "Users GET Output")

[GET] */api/users/{id}*
![Alt text](Capturas/REST/REST_user_GET_A.PNG "User GET")
![Alt text](Capturas/REST/REST_user_GET_B.PNG "User GET Output")

[POST] */api/users/*
![Alt text](Capturas/REST/REST_user_POST_A.PNG "User POST")
![Alt text](Capturas/REST/REST_user_POST_B.PNG "User POST Output")

[PUT] */api/users/{id}*
![Alt text](Capturas/REST/REST_user_PUT_A.PNG "User PUT")
![Alt text](Capturas/REST/REST_user_PUT_B.PNG "User PUT Output")

[DELETE] */api/users/{id}*
![Alt text](Capturas/REST/REST_user_DELETE_A.PNG "User DELETE")
![Alt text](Capturas/REST/REST_user_DELETE_B.PNG "User DELETE Output")

### ORDERS [Order = OrderSummary]
...URL                  | METHOD    | INPUT                   | OUTPUT 
---                     | ---       | ---                     | --- 
/api/carts/             | GET       | None                    | List of [Cart]
/api/carts/{id}         | GET       | Cart.Id                 | Cart
/api/carts/             | POST      | Cart                    | Cart
/api/orders/            | GET       | None                    | List of [Order]               
/api/orders/{id}        | GET       | Order.Id                | Order     
/api/orders/            | POST      | Order                   | Order                     
/api/orders/{id}        | PUT       | Order.Id, Order         | Order    
/api/orders/{id}        | DELETE    | Order.Id                | Order    
/api/listcart/          | GET       | None                    | List of [Cart]
/api/cart/addlist       | POST      | Cart                    | List of [Cart]
/api/cart/remove/{name} | DELETE    | Cart.Name               | Text


[GET] */api/carts/*
![Alt text](Capturas/REST/REST_carts_GET_A.PNG "Carts GET")
![Alt text](Capturas/REST/REST_carts_GET_B.PNG "Carts GET Output")

[GET] */api/carts/{id}*
![Alt text](Capturas/REST/REST_carts_GET_ID_A.PNG "Carts GET")
![Alt text](Capturas/REST/REST_carts_GET_ID_B.PNG "Carts GET Output")

[POST] */api/carts/*
![Alt text](Capturas/REST/REST_carts_POST_A.PNG "Carts POST")
![Alt text](Capturas/REST/REST_carts_POST_B.PNG "Carts POST Output")

[GET] */api/orders/*
![Alt text](Capturas/REST/REST_orders_GET_A.PNG "Orders GET")
![Alt text](Capturas/REST/REST_orders_GET_B.PNG "Orders GET Output")

[GET] */api/orders/{id}*
![Alt text](Capturas/REST/REST_orders_GET_ID_A.PNG "Orders GET")
![Alt text](Capturas/REST/REST_orders_GET_ID_B.PNG "Orders GET Output")

[POST] */api/orders/*
![Alt text](Capturas/REST/REST_orders_POST_A.PNG "Orders POST")
![Alt text](Capturas/REST/REST_orders_POST_B.PNG "Orders POST Output")

[PUT] */api/orders/{id}*
![Alt text](Capturas/REST/REST_orders_PUT_A.PNG "Orders PUT")
![Alt text](Capturas/REST/REST_orders_PUT_B.PNG "Orders PUT Output")

[DELETE] */api/orders/{id}*
![Alt text](Capturas/REST/REST_orders_DELETE_A.PNG "Orders DELETE")
![Alt text](Capturas/REST/REST_orders_DELETE_B.PNG "Orders DELETE Output")

#### Examen of Cart

[GET] */api/listcart/*
![Alt text](Capturas/REST/REST_listCart_GET_A.PNG "Cart GET")
![Alt text](Capturas/REST/REST_listCart_GET_B.PNG "Cart GET Output")

[POST] */api/listcart/*
![Alt text](Capturas/REST/REST_addlistCart_POST_A.PNG "Cart POST")
![Alt text](Capturas/REST/REST_addlistCart_POST_B.PNG "Cart POST Output")

[GET] */api/listcart/*
![Alt text](Capturas/REST/REST_listCart2_GET_A.PNG "Cart GET")
![Alt text](Capturas/REST/REST_listCart2_GET_B.PNG "Cart GET Output")

[DELETE] */api/listcart/{name}*
![Alt text](Capturas/REST/REST_removelistCart_DELETE_A.PNG "Cart DELETE")
![Alt text](Capturas/REST/REST_removelistCart_DELETE_B.PNG "Cart DELETE Output")

[GET] */api/listcart/*
![Alt text](Capturas/REST/REST_listCart_GET_A.PNG "Cart GET")
![Alt text](Capturas/REST/REST_listCart_GET_B.PNG "Cart GET Output")

#### Example of Product
https://localhost:8443/api/products/15
```json
{
  "id": 15,
  "name": "accesory15",
  "brand": "brand15",
  "model": "model15",
  "reference": "reference15",
  "type": "type3",
  "colour": null,
  "size": null,
  "sphere": null,
  "radio": null,
  "published": false,
  "price": 0.5,
  "quantity": 5,
  "image": "producto15",
  "description": "description15"
}
```

#### Example of User
https://localhost:8443/api/users/2
``` json
{
  "id": 2,
  "name": "user2",
  "passwordHash": "$2a$10$cnbjIHCE.X8kAndSenKLbuRGSpcnMP3Hh4kqm8GEAlpeVW2bADhR6",
  "confirmpasswordHash": null,
  "surnames": "pig",
  "email": "megustacomer@zanahorias.com",
  "birthdate": "01/01/2000",
  "address": "En tu barrio Nº69 bajo A ",
  "address2": null,
  "zipcode": 69000,
  "locality": "Madrid",
  "province": "Madrid",
  "country": "España",
  "phone": "612345678",
  "nid": "A12345678",
  "other": null,
  "roles": [
    "ROLE_USER"
  ]
}
```

#### Example of Order
https://localhost:8443/api/orders/1
``` json
{
  "id": 1,
  "ordername": "order1",
  "user": "user1",
  "paymentmethod": "paymentcard1",
  "order": [
    {
      "id": 1,
      "name": "name1",
      "price": 20.4,
      "quantity": 1,
      "size": "size1",
      "sphere": "0",
      "radio": "0",
      "diameter": "0",
      "eye": "0"
    }
  ]
}
```
>>>>>>> fase4
