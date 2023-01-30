# FOR CUSTOMER BACKEND (Remaining Pages :- PROFILE)

1. Home Page :- Display all categories [DONE]

   http://localhost:Port/products/categories

   Fetch => category_image, category_name, category_desc (Page Load Fail, Success)
   Method => GET
   Query =>
   select cat_id, cat_name,cat_desc, cat_image_path from category;

2. Customer Sigin [Done]

   http://localhost:Port/customer/signin_auth

   Fetch => cutomer_details (Invalid User, Error, Success)
   Method => GET
   Query =>
   select c_id,c_fname,c_lname,c_email,c_mobile,c_address,c_pincode from customer where c_email="abc@gmail.com" and c_password="xxxxx" and isdeleted = false;

3. New Customer Signup [Done]

   http://localhost:Port/customer/signup

   Fetch => customer_signup_status (Success, Failure, User Already Exists, Error)
   Method => POST

   Query =>
   insert into location values('city',413722,'state');

   insert into customer values(default,'c_fname','c_lname','c_email',7028144961,'xxxxx','c_address',413722,default);

4. Product Details of Selected Category [Done]

   http://localhost:Port/products/categories/{category_id}

   Fetch => Product_details(All Products in that category) , Product_image, All_category_names (Page Load Fail, Success)
   Method => GET
   Query =>
   select p_id,cat_id,s_id,p_name,p_price,p_unit,p_details,p_image_path from product where cat_id=1 and isDeleted=false;

5. Details about selected product [Done]

   http://localhost:Port/products/{product_id}

   Fetch => Product_details (All details about a single product), Product_image (Page Load Fail, Success)
   Method => GET
   Query =>
   select p_id,cat_id,s_id,p_name,p_price,p_unit,p_details,p_image_path from product where p_id=1 and isDeleted=false;

6. Search Product by name [Done]

   http://localhost:Port/products

   Fetch => Matched_product_details (All details about matched product), Product_image (Page Load Fail, Success)
   Method => POST
   Query => select p_id,cat_id,s_id,p_name,p_price,p_unit,p_details,p_image_path from product where p_name like "%or%" and isDeleted=false;

7. Contact Us Page [DONE]

   http://localhost:Port/customer/contact_us

   Fetch => contact_us_status (Success, Error, Unable to contact)
   Method => POST
   Query =>
   Insert into contact_us values('name','email',7028144961,'message');

8. Customer cart checkout Order[Done]

   http://localhost:Port/customer/orders

   Fetch => order_details_status (Success, Error, Unable to store)
   Method => POST
   Query =>
   insert into orders values(c_id,o_date);

9. Customer cart checkout Order Details[Done]

   http://localhost:Port/customer/order_details

   Fetch => order_details_status (Success, Error, Unable to store)
   Method => POST
   Query =>
   insert into order_details values(current_order_id,s_id,p_id,p_qty);

# FOR SELLER (Remaining Pages :- ADD, UPDATE, PROFILE)

1. Seller Login

   http://localhost:Port/sellers/signin_auth [Done]

   Fetch => seller_details (Invalid User, Error, Success)
   Method => POST
   Query => select s_id,s_name,s_email,s_mobile,s_pincode from seller where isdeleted=false and s_email=? and s_password=?;

2. Products of the logged in seller [Done]

   http://localhost:Port/sellers/products/{seller_id}

   Fetch => seller_own_product_details (Page Load Fail, Error, Success)
   Method => GET
   Query => select p_id,cat_id,p_name,p_price,p_unit,p_details,p_image_path from product where s_id=? and isDeleted=false;

3. Add product for logged in seller [Done]

   http://localhost:Port/sellers/products/add

   Fetch => seller_own_product_add_status (Failure to add product, Error, Success)
   Method => POST
   Query => insert into product values(default,cat_id,s_id,'p_name',p_price,p_unit,p_details,p_image_path,default);

4. Delete product for logged in seller [Done]

   http://localhost:Port/sellers/products/delete/{product_id}

   Fetch => seller_own_product_delete_status (Failure to delete product, Error, Success)
   Method => PUT(Means Delete)
   Query => update product set isdeleted=true where p_id=?;

5. Update product for logged in seller [Done]

   http://localhost:Port/seller/products/update/{product_id}

   Fetch => seller_own_product_update_status (Failure to update product, Error, Success)
   Method => PUT
   Query=> update product set p_name=?,p_price=?,p_unit=?,p_details=?,p_image_path=? where p_id=?;

6. Details of all the products ordered by the customers\*\*

   http://localhost:Port/seller/products/order_details

   Fetch => seller_own_product_order_details (Failure to load products, Error, Success)
   Method => GET
   Query=>
   select p.p_name,p.p_price,c.cat_name,a.c_fname from category c inner join product p on p.cat_id=c.cat_id inner join order_details o on p.p_id = o.p_id inner join orders b on b.o_id=o.o_id inner join customer a on b.c_id = a.c_id where o.s_id=?;

# FOR ADMIN (Remaining Pages :- ADD, UPDATE)

1. Admin login

   http://localhost:Port/admin/signin_auth

   username='admin', password='admin' (static)

2. All order details\*\*

   http://localhost:Port/admin/order_details

   Fetch => order_details (Cannot load page, Error, Success)
   Method => GET
   Query=>

# 1.1 For seller

2. All sellers List [Done]

   http://localhost:Port/admin/sellers_list

   Fetch => all_seller_details (Page Load Fail, Error, Success)
   Method => GET
   Query=> select s_id,s_name,s_email,s_mobile,s_password,s_pincode,isdeleted from seller;

3. Add a seller [Done]

   http://localhost:Port/admin/sellers/add

   Fetch => seller_add_status (Unable to add seller, Error, Success)
   Method => POST
   Query=>insert into seller values(default,s_name,s_email,s_mobile,s_password,s_pincode,default);

4. Delete a seller [Done]

   http://localhost:Port/admin/sellers/delete/{seller_id}

   Fetch => seller_delete_status (Unable to delete seller, Error, Success)
   Method => PUT(Means Delete)
   Query=> update seller set isdeleted=true where s_id=?;

5. Update a seller [Done]

   http://localhost:Port/admin/sellers/update/{seller_id}

   Fetch => seller_update_status (Unable to update seller, Error, Success)
   Method => PUT
   Query=> update seller set sname=?,s_email=?,s_mobile=?,s_password=?,s_pincode=?,isdeleted=? where s_id=?;

# 1.2 For Product

1. All product List [Done]

   http://localhost:Port/admin/products_list

   Fetch => all_product_details (Page Load Fail, Error, Success)
   Method => GET
   Query=> select p_id,cat_id,s_id,p_name,p_price,p_unit,p_details,p_image_path,isdeleted from product;

2. Delete a Product [Done]

   http://localhost:Port/admin/products/delete/{product_id}

   Fetch => product_delete_status (Unable to delete product, Error, Success)
   Method => PUT(Means Delete)
   Query=>update product set isdeleted=true where p_id=?;

# 1.3 For Customer

1. All customers List [Done]

   http://localhost:Port/admin/customers_list

   Fetch => all_customer_details (Page Load Fail, Error, Success)
   Method => GET
   Query=> select c_id,c_fname,c_lname,c_email,c_mobile,c_password,c_address,c_pincode,isdeleted from customer;

2. Delete a customer [Done]

   http://localhost:Port/admin/customers/delete/{customer_id}

   Fetch => customer_delete_status (Unable to delete customer, Error, Success)
   Method => PUT(Means Delete)
   Query=> update customer set isdeleted=true where c_id=?;

3. Update a customer [Done]

   http://localhost:Port/admin/customers/update/{customer_id}

   Fetch => customer_update_status (Unable to update customer, Error, Success)
   Method => PUT
   Query=>update customer set c_fname=?,c_lname=?,c_email=?,c_mobile=?,c_address=?,c_pincode=? where c_id=?;

<!-- image upload -->

<!-- api checking response request study -->

<!-- exception handling -->

web security
jwstoken
