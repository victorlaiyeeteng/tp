---
layout: page
title: Victor Lai's Project Portfolio Page
---

### Project: FriendBook

FriendBook - is a desktop app for managing friend contacts and plan details, 
optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI) created with JavaFX.
If you can type fast, FriendBook can get your plans management done faster than traditional GUI apps.
It is written in Java, and has about 17kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the functionality for users to add plan.
  * What it does: allows user to add a plan to his FriendBook, and associate the plan to an existing friend. User are allowed to specify the plan's name, 
  date and friend details of the plan.
  * Justification: This feature is a key functionality of FriendBook which requires plans to be added, so that user can view and manipulate with
  the added plan as required.
  * Highlights:
    * Deciding on the most user-friendly way of user's interaction with the CLI to identify the friend that is to be associated with the plan was challenging, 
    eventually deciding on `FRIEND_NAME` as the identifier as it is not only unique to each friend, but also easily retrievable
    * Required an in-depth analysis of existing `addressbook` object design to implement checking if user's inputted
    friend exists, finally deciding on adding a search method to `getPersonByName` and check if the friend exists 
  
* **New Feature**: Added the functionality for users to find plans by existing friends' names.
  * What it does: allows user to find existing plans that are associated with the given friend. 
  * Justification: This feature provides a clean and neat way for users to filter through their many plans and view only plans that are of his 
  interest (related to queried friend).
  * Highlights: 
    * Similar to the above point, obtaining (and checking that he exists) the queried friend by the `FRIEND_NAME` using the added function stated above was 
    needed to get the filtered list of plans associated with the friend
    * Filtering plans based on `FRIEND_NAME` required implementation of `PlanContainsFriendPredicate` to fulfill the previous highlight
  * Credits:
    * Inspiration of `PlanContainsFriendPredicate` was taken from other predicate designs in AB3, on how they obtain the required filtered plans.

* **New Feature**: Added the functionality for users to list all their plans.
  * What it does: allows user to get all their plans without any filters.
  * Justification: This feature provides users the ability to view all their plans after the scenario where they execute the above `find-plan` command to filter
  the plans.
  
* **Enhance Existing Delete Command**: Modified `DeleteCommand` to ensure friends are deleted safely.
  * What it does: prevents and alerts user when he attempts to delete a friend that is involved in at least 1 plan.
  * Justification: This modification provides logical sense for user who wishes to view complete details of friend associated to his existing
  plans, allowing for better user experience.
  * Highlights: Utilised previously implemented `PlanContainsFriendPredicate` from above to find plans still associated to the friend attempted to be deleted.

* **Enhance Existing Edit Command**: Built on `EditCommand` to ensure edited friends' detailed are reflected in associated plans.
  * What it does: updates relevant plans which are associated to the edited friends' details
  * Justification: This ensures correctness of FriendBook whereby plans should have its friend details updated accordingly when needed.
  * Highlights:
    * It was challenging figuring out the bug as I initially thought it was a Ui rendering bug of updated friend's name not reflecting in related plans.
    * It required an in-depth analysis of existing AB3 `EditCommand` implementation, before realising that it creates a new `Person` object and replaces the old one, 
    hence a similar replacement had to be done for each associated plan.

* **Testing**: Added relevant test and helper files to aid testing of above implementations
  * What it does: tests all new functionalities and bug fixes for optimal code coverage
  * Highlights: Added test files for above commands and function checks. Added test helper files like `TypicalPlans` and `PlanBuilder` that were also used in other test files.


* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-09-22&tabOpen=true&tabType=authorship&tabAuthor=victorlaiyeeteng&tabRepo=AY2324S1-CS2103T-W16-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)


* **Project management**:
  * Set up team's GitHub organization
  * Set up FriendBook repository, enabling issue tracker, setting up CodeCov and CI
  * Managed releases `v1.3(trial) - v1.3(final)`(2 releases) on GitHub
  * Documented V1.2 postmortem and V1.3 product demo on developer document


* **Documentation**:
  * User Guide:
    * Added documentation for `add-plan`, `find-plan`, `list-plan`, `clear`, `help`, `exit` commands
    * Polish arguments and unexpected outputs for all other commands
    * Update `Command summary` portion to match it with the available commands
  * Developer Guide:
    * Added implementation details of the `list-plan` feature.
    * Wrote `Product scope`, `User Stories`, 2 `Use Cases`, `Non-Functional Requirements` for the `Appendix: Requirements` section
    * Wrote `Deleting a person`, `Editing a plan` and `Saving data` sections for the `Appendix: Instructions for manual testing` section


* **Review / Mentoring Contributions**:
  * Shared with teammates how we can use newly implemented `getPersonByName` function and `PlanContainsFriendPredicate` predicate
  to facilitate our `Plan` commands
  * Review bugs flagged out during PE-D and categorised them while removing repeated bugs


* **Community**:
  * Suggested to another team in tutorial class on how to use existing predicates to improve their OOP design.
  * Advised other team outside of class on how ChatGPT's provided regex don't always pass corner cases.
