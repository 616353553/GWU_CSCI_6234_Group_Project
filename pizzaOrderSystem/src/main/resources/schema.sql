CREATE TABLE Doughs (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    price DECIMAL(10, 2),
    PRIMARY KEY (id)
);

CREATE TABLE DoughSizes (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    inch int,
    multiplier DECIMAL(10, 2),
    PRIMARY KEY (id)
);

CREATE TABLE Dough_DoughSize (
    dough_id int NOT NULL,
    dough_size_id int NOT NULL,
    PRIMARY KEY (dough_id, dough_size_id),
    FOREIGN KEY (dough_id) REFERENCES Doughs(id),
    FOREIGN KEY (dough_size_id) REFERENCES DoughSizes(id)
);

CREATE TABLE Cheeses (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    price DECIMAL(10, 2),
    PRIMARY KEY(id)
);

CREATE TABLE CheeseLevels (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    multiplier DECIMAL(10, 2),
    PRIMARY KEY(id)
);

CREATE TABLE Sauces (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    price DECIMAL(10, 2),
    PRIMARY KEY(id)
);

CREATE TABLE SauceIntensities (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    multiplier DECIMAL(10, 2),
    PRIMARY KEY(id)
);

CREATE TABLE Toppings (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    price DECIMAL(10, 2),
    veggie BOOLEAN,
    PRIMARY KEY(id)
);

CREATE TABLE Pizzas (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    dough_id int,
    dough_size_id int,
    cheese_id_1 int,
    cheese_level_id_1 int,
    cheese_id_2 int,
    cheese_level_id_2 int,
    sauce_id int,
    sauce_intensity_id int,
    topping_id_1 int,
    topping_id_2 int,
    topping_id_3 int,
    retail_price DECIMAL(10, 2),
    PRIMARY KEY(id),
    FOREIGN KEY (dough_id) REFERENCES Doughs(id),
    FOREIGN KEY (dough_size_id) REFERENCES DoughSizes(id),
    FOREIGN KEY (cheese_id_1) REFERENCES Cheeses(id),
    FOREIGN KEY (cheese_level_id_1) REFERENCES CheeseLevels(id),
    FOREIGN KEY (cheese_id_2) REFERENCES Cheeses(id),
    FOREIGN KEY (cheese_level_id_2) REFERENCES CheeseLevels(id),
    FOREIGN KEY (sauce_id) REFERENCES Sauces(id),
    FOREIGN KEY (sauce_intensity_id) REFERENCES SauceIntensities(id),
    FOREIGN KEY (topping_id_1) REFERENCES Toppings(id),
    FOREIGN KEY (topping_id_2) REFERENCES Toppings(id),
    FOREIGN KEY (topping_id_3) REFERENCES Toppings(id)
);

