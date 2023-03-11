USE airport_info;
CREATE TABLE planes_info (
    Serial_number VARCHAR(20) PRIMARY KEY,
    Model VARCHAR(50),
    Maximum_take_off_weight_kg INTEGER,
    Plane_owners VARCHAR(50)
);

INSERT INTO planes_info
VALUES ('AT3-003', 'AT-3 R100', 582, 'Jetstar'),
('1178', 'ATR 72-212A (600 version)', 23000, 'Air France KLM'),
('3260', 'Airbus 319-115', 75500, 'Jetstar'),
('2462', 'Airbus A321-231', 89000, 'American Airlines'),
('466', 'Airbus A320-212', 77000, 'Air France KLM'),
('139', 'Alouette-M III', 2200, 'Jetstar'),
('306911207', 'AУС-N-7', 700, 'American Airlines');