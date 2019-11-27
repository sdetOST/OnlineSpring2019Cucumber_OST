$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\resources\\features\\login\\Login.feature");
formatter.feature({
  "name": "Login",
  "description": "  As user I want to login under different roles",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@VYT-4121"
    }
  ]
});
formatter.scenario({
  "name": "Login as a store manager",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@VYT-4121"
    },
    {
      "name": "@storemanager"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs in as a store manager",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinitions.user_logs_in_as_a_store_manager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies that \"Dashboard\" page name is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinitions.user_verifies_that_page_name_is_displayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify warning message for invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@VYT-4121"
    },
    {
      "name": "@negative"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs in with \"wrong\" username and \"wrong\" password",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinitions.user_logs_in_with_username_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies that \"Invalid user name or password.\" warning message is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinitions.user_verifies_that_warning_message_is_displayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});