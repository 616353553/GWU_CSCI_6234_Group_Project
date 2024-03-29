INSERT INTO Doughs (name, price) VALUES ('Brooklyn Style Crust', 0);
INSERT INTO Doughs (name, price) VALUES ('Crunchy Thin Crust', 0);
INSERT INTO Doughs (name, price) VALUES ('Hand Tossed Crust', 0);
INSERT INTO Doughs (name, price) VALUES ('Gluten Free Crust', 0);
INSERT INTO Doughs (name, price) VALUES ('Handmade Pan', 0);

INSERT INTO DoughSizes (name, inch, multiplier) VALUES ('Small', 10, 1);
INSERT INTO DoughSizes (name, inch, multiplier) VALUES ('Medium', 12, 1.2);
INSERT INTO DoughSizes (name, inch, multiplier) VALUES ('Large', 14, 1.5);
INSERT INTO DoughSizes (name, inch, multiplier) VALUES ('Extra-Large', 16, 2.0);

INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (1, 1);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (1, 2);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (1, 3);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (2, 1);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (2, 2);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (2, 3);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (2, 4);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (3, 2);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (3, 3);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (3, 4);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (4, 2);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (4, 3);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (5, 1);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (5, 2);
INSERT INTO Dough_DoughSize (dough_id, dough_size_id) VALUES (5, 3);


INSERT INTO Cheeses (name, price) VALUES ('No Cheese', 0);
INSERT INTO Cheeses (name, price) VALUES ('Mozzarella Cheese', 3.90);
INSERT INTO Cheeses (name, price) VALUES ('Provolone Cheese', 3.10);
INSERT INTO Cheeses (name, price) VALUES ('Cheddar Cheese', 3.00);
INSERT INTO Cheeses (name, price) VALUES ('Parmesan Cheese', 2.60);
INSERT INTO Cheeses (name, price) VALUES ('Gouda Cheese', 3.50);
INSERT INTO Cheeses (name, price) VALUES ('Goat Cheese Cheese', 3.50);
INSERT INTO Cheeses (name, price) VALUES ('Gruyere Cheese', 4.0);
INSERT INTO Cheeses (name, price) VALUES ('Ricotta Cheese', 4.2);

INSERT INTO CheeseLevels (name, multiplier) VALUES ('Less', 0.5);
INSERT INTO CheeseLevels (name, multiplier) VALUES ('Normal', 1);
INSERT INTO CheeseLevels (name, multiplier) VALUES ('Extra', 1.5);

INSERT INTO Sauces (name, price) VALUES ('No Sauce', 0);
INSERT INTO Sauces (name, price) VALUES ('Tomato Sauce', 0);
INSERT INTO Sauces (name, price) VALUES ('Ranch', 0);
INSERT INTO Sauces (name, price) VALUES ('Hearty Marinara Sauce', 0);
INSERT INTO Sauces (name, price) VALUES ('Honey BBQ Sauce', 0);
INSERT INTO Sauces (name, price) VALUES ('Garlic Parmesan Sauce', 0);
INSERT INTO Sauces (name, price) VALUES ('Alfredo Sauce', 0);

INSERT INTO SauceIntensities (name, multiplier) VALUES ('Less', 0.5);
INSERT INTO SauceIntensities (name, multiplier) VALUES ('Normal', 1.0);
INSERT INTO SauceIntensities (name, multiplier) VALUES ('Extra', 1.5);

INSERT INTO Toppings (name, price, veggie) VALUES ('None', 0, FALSE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Ham', 3.00, FALSE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Beef', 3.00, FALSE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Salami', 2.5, FALSE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Pepperoni', 2.5, FALSE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Italian Sausage', 2.8, FALSE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Premium Chicken', 2.8, FALSE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Bacon', 3.70, FALSE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Philly Steak', 4.00, FALSE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Garlic', 1, TRUE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Jalapeno Peppers', 1.2, TRUE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Onions', 0.8, TRUE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Banana Peppers', 1.2, TRUE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Diced Tomatoes', 0.8, TRUE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Black Olives', 0.5, TRUE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Mushrooms', 1.4, TRUE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Pineapple', 2.6, TRUE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Green Peppers', 2.00, TRUE);
INSERT INTO Toppings (name, price, veggie) VALUES ('Spinach', 1.5, TRUE);


INSERT INTO Pizzas (name, dough_id, dough_size_id, cheese_id_1,
                    cheese_level_id_1, cheese_id_2, cheese_level_id_2,
                    sauce_id, sauce_intensity_id, topping_id_1,
                    topping_id_2, topping_id_3, retail_price)
       VALUES ('Custom Pizza', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO Pizzas (name, dough_id, dough_size_id, cheese_id_1,
                    cheese_level_id_1, cheese_id_2, cheese_level_id_2,
                    sauce_id, sauce_intensity_id, topping_id_1,
                    topping_id_2, topping_id_3, retail_price)
       VALUES ('ExtravaganZZa', 1, 3, 2, 1, 2, 1, 2, 2, 9, 13, 16, 12.49);
INSERT INTO Pizzas (name, dough_id, dough_size_id, cheese_id_1,
                    cheese_level_id_1, cheese_id_2, cheese_level_id_2,
                    sauce_id, sauce_intensity_id, topping_id_1,
                    topping_id_2, topping_id_3, retail_price)
       VALUES ('MeatZZa', 3, 3, 4, 2, 4, 2, 5, 3, 2, 6, 7, 18.99);
INSERT INTO Pizzas (name, dough_id, dough_size_id, cheese_id_1,
                    cheese_level_id_1, cheese_id_2, cheese_level_id_2,
                    sauce_id, sauce_intensity_id, topping_id_1,
                    topping_id_2, topping_id_3, retail_price)
       VALUES ('Buffalo Chicken', 5, 3, 5, 2, 6, 2, 7, 2, 7, 11, 1, 15.99);
INSERT INTO Pizzas (name, dough_id, dough_size_id, cheese_id_1,
                    cheese_level_id_1, cheese_id_2, cheese_level_id_2,
                    sauce_id, sauce_intensity_id, topping_id_1,
                    topping_id_2, topping_id_3, retail_price)
       VALUES ('SPINACH & FETA', 4, 3, 5, 2, 6, 2, 7, 2, 12, 19, 1, 10.99);
