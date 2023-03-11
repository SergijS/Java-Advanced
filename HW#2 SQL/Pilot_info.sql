USE airport_info;
CREATE TABLE pilots_info (
    Pilot_id INTEGER PRIMARY KEY,
    Pilot_name VARCHAR(20),
    Pilot_age INTEGER,
    Models_of_planes_that_he_can_fly VARCHAR(50)
);

INSERT INTO pilots_info 
VALUE (0001, 'Alex', 35, 'AT-3 R100'),
(0002, 'Mike', 42, 'AT-3 R100' ),
(0003, 'Jhon', 54, 'ATR 72-212A (600 version)'),
(0004, 'Helen', 43, 'Airbus 319-115'),
(0005, 'Laura', 38, 'Airbus A321-231'),
(0006, 'Nik', 58, 'Airbus A320-212'),
(0007, 'Scott', 32, 'Alouette-M III'),
(0008, 'Lenny', 28, 'AУС-N-7');