# tax-calculator
Input - **input.txt** <br/>
output - **output.png** <br/>
use mvn to build project and run test cases

All the main code is present in src folder. <br/>
All the tests are present in test folder (MainTest runs input.txt test cases). <br/>

In the above project to model various products such as books, food, medical etc a common model<br/>
called Product is used. The advantage is that product is extensible to any product Type.<br/>
Also, more details can be added into current product types

For input a factory design pattern is used. Current input is static however this input can be<br/>
can be extended to Database also.

For the tax calc, I have used Strategy pattern. The advantage is that any new tax calc logic
can be easily added and the tax logic is dynamically decided at Runtime


Future Extentions: <br/>
    1. Adding of dao layers to communicate with DB, service layers <br/>
    2. Storing and fetching data into Db <br/>
    3. Making more robust test cases <br/>
    4. Adding UI to create Orders <br/>
    5. Adding auth, permission, access layer etc
