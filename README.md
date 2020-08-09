# tax-calculator
Input - input.txt <br/>
output - output.png
use mvn to build project and run test cases

All the main code is present in src folder.
All the tests are present in test folder (MainTest runs input.txt test cases).

In the above project to model various products such as books, food, medical etc Factory Pattern
is used. The advantage of this pattern is that it is extensible to any product Type. Also,
more details can be added into current product types

For the tax calc, I have used Strategy patern. The advantage is that any new tax calc logic
can be easily added and the tax logic is dynamically decided at Runtime


Future Extentions:
    1. Adding of dao layers to communicate with DB, service layers
    2. Storing and fetching data into Db
    3. Making more robust test cases
    4. Adding UI to create Orders
    5. Adding auth, permission, access layer etc
