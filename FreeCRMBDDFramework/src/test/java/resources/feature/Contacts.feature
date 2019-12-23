@Create_contacts
Feature:Free CRM Create Contacts
  Scenario Outline: Free CRM Create Contact scenario
    Given user is on login page
    When title of login page is Free CRM
    Then user enters "<username>" and "<password>"

    Then user move to new contact page
    Then user enters to "<firstname>" and "<lastname>" and "<position>"

    Examples:
      | username             | password | firstname | lastname | position |
      | musfiliz@hotmail.com | Bfsi2879 | Ayse      | Buyuk    | Manager  |
      | musfiliz@hotmail.com | Bfsi2879 | Ahmet     | Kara     | Director |


