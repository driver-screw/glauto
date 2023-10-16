# glauto my-test-framework
This framework is designed in order to perform tests for github using UI and API.

## Framework structure
### Test Config module
Place your config here: *src/test/<APP_NAME>/resources*  
Github app example: *src/test/github/resources/test.properties*

### Test  module
API tests :*src/test/<APP_NAME>/java/api*  
UI tests :*src/test/<APP_NAME>/java/ui*
### Application Config module
Config and resources location for test framework: *src/main/<APP_NAME>/resources*
### Application module
API: *src/main/<APP_NAME>/java/api*  
UI: *src/main/<APP_NAME>/java/ui*


