-- Відображується ім'я та вік 3-х найстарших пілотів.
SELECT Pilot_name, Pilot_age
FROM pilots_info
ORDER BY Pilot_age DESC
LIMIT 3;

-- Відображуються ім'я пілотів, моделі літаків, вага яких менша за 5000кг.
SELECT pilots_info.Pilot_name, planes_info.Model, planes_info.Maximum_take_off_weight_kg
FROM pilots_info
INNER JOIN planes_info
ON pilots_info.Models_of_planes_that_he_can_fly = planes_info.Model
WHERE planes_info.Maximum_take_off_weight_kg < 5000;

-- Відображається загальна вага літаків у зворотному порядку та середній вік пілотів компанії
SELECT planes_info.Plane_owners AS Fly_companies, SUM(planes_info.Maximum_take_off_weight_kg) AS Total_weight, AVG(pilots_info.Pilot_age) AS Average_age_of_pilots
FROM planes_info
INNER JOIN pilots_info
ON planes_info.Model = pilots_info.Models_of_planes_that_he_can_fly
GROUP BY planes_info.Plane_owners
ORDER BY SUM(planes_info.Maximum_take_off_weight_kg) DESC;