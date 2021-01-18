Feature: Ipipeline

Scenario Outline: New Requests
Given that the "chrome" browser is initialized
And the URL "https://pipepasstoigo-td3.ipipeline.com/default.aspx?gaid=5315" is launched
And the username <Username> and the password <Password> is entered
When the New Request button is clicked
Then the page for new request should be opened and the required data should be entered

Examples:
|Username|	Password|
|GuardianB|	Password!|
|GuardianC|	Password!|


