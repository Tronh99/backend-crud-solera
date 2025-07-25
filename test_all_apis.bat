@echo off
echo Testing Vehicle Management API...
echo.

echo 1. Testing Location Creation (Valid)
curl -X POST http://localhost:8080/api/v1/locations -H "Content-Type: application/json" -d "{\"name\":\"Downtown Auto Center\",\"street\":\"123 Main Street\",\"extNumber\":\"456A\",\"postalCode\":\"85001\",\"city\":\"Phoenix\",\"country\":\"USA\"}"
echo.
echo.

echo 2. Testing Location Creation (Invalid - Should show validation errors)
curl -X POST http://localhost:8080/api/v1/locations -H "Content-Type: application/json" -d "{\"name\":\"\",\"street\":\"123 Main St!@#\",\"extNumber\":\"123456\",\"postalCode\":\"ABCDE\",\"city\":\"\",\"country\":\"\"}"
echo.
echo.

echo 3. Getting All Locations
curl -X GET http://localhost:8080/api/v1/locations
echo.
echo.

echo 4. Testing Workshop Creation (Valid - assuming location ID 1 exists)
curl -X POST http://localhost:8080/api/v1/workshops -H "Content-Type: application/json" -d "{\"name\":\"Premium Auto Repair\",\"description\":\"Full service automotive repair specializing in engine diagnostics\",\"locationId\":1}"
echo.
echo.

echo 5. Testing Vehicle Creation (Valid - assuming workshop ID 1 exists)
curl -X POST http://localhost:8080/api/v1/vehicles -H "Content-Type: application/json" -d "{\"model\":\"Camry\",\"brand\":\"Toyota\",\"year\":\"2022\",\"color\":\"Silver Metallic\",\"vin\":\"1HGBH41JXMN109186\",\"workshopId\":1}"
echo.
echo.

echo 6. Testing Part Creation (Valid)
curl -X POST http://localhost:8080/api/v1/parts -H "Content-Type: application/json" -d "{\"name\":\"Brake Pad Set Front\",\"description\":\"Premium ceramic brake pads for front wheels\",\"quantity\":25,\"cost\":89.99}"
echo.
echo.

echo 7. Testing VehiclePart Creation (Valid - assuming vehicle ID 1 and part ID 1 exist)
curl -X POST http://localhost:8080/api/v1/vehicle-parts -H "Content-Type: application/json" -d "{\"vehicleId\":1,\"partId\":1,\"quantity\":4}"
echo.
echo.

echo API Testing Complete!
pause
