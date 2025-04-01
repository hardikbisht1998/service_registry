-- Insert dummy data into 'orders' table
INSERT INTO orders (order_status, total_price)
VALUES
    ('PENDING', 199.99),
    ('COMPLETED', 349.50),
    ('SHIPPED', 89.99),
    ('CANCELLED', 149.75),
    ('PROCESSING', 259.00),
    ('DELIVERED', 99.99);

-- Insert dummy data into 'order_items' table
INSERT INTO order_items (product_id, quantity, order_id)
VALUES
    (1, 1, 1),  -- Order 1: Wireless Mouse, Quantity: 1
    (2, 2, 1),  -- Order 1: Bluetooth Headphones, Quantity: 2
    (3, 1, 2),  -- Order 2: Laptop Stand, Quantity: 1
    (4, 1, 2),  -- Order 2: Smartwatch, Quantity: 1
    (5, 3, 3),  -- Order 3: USB-C Cable, Quantity: 3
    (6, 2, 4),  -- Order 4: Gaming Keyboard, Quantity: 1
    (7, 1, 5),  -- Order 5: Bluetooth Speaker, Quantity: 1
    (8, 2, 6);  -- Order 6: External SSD Drive, Quantity: 2

