# glauto my-test-framework

This framework is designed in order to perform tests for github using UI and API.

## Framework structure

### Test Config module

Place your config here: *src/test/resources*

### Test  module

API tests :*src/test/java/api*  
UI tests :*src/test/ui*

Run tests: _mvn clean test_

### Application Config module

Config and resources location for test framework: *src/main/resources*
Properties can be read from:

1. config.properties file
2. config.json file
3. system properties

The order of the source is same as in list.

### Application module

API: *src/main/java/api*  
UI: *src/main/java/ui*

### Docker image

To build docker image run command from the project root folder:  
*docker build -t glauto/testframework:0.1 .*

Right now test results are saved only in container.


