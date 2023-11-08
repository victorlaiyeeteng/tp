---
layout: page
title: FriendBook User Guide
---

FriendBook is a GUI/CLI program made for **SoC Students** to help them keep track and manage their friends and plans.

Here's a quick summary of what FriendBook can do for you:

* All features are easily achieved using simple, typed commands!
* Reminders on how each command can be used!
* Add friends into FriendBook and keep track of their information!
* Add plans into FriendBook and keep track of them!
* Add useful information like deadlines to each of your plan!
* Associate a friend with each of your plan!

# Table of Content
- [Installation Guide](#installation-guide)
- [Disclaimers](#disclaimers)
- [Important Information](#important-information)
- [Friend-Related Features](#friends-related-features)
  - [add-friend](#add-friend)
  - [delete-friend](#delete-friend)
  - [edit-friend](#edit-friend)
  - [find-friend]()
  - [list-friend]()
- [Plan-Related Features](#features)
  - [add-plan](#add-plan)
  - [delete-plan](#delete-plan)
  - [edit-plan](#edit-plan)
  - [find-plan](#find-plan)
  - [list-plan](#list-plan)
- [Command Summary](#command-summary)
- [FAQs](#faqs)

--------------------------------------------------------------------------------------------------------------------

## Installation Guide
1. Ensure you have Java 11 or above installed in your Computer. Click [here](https://blog.hubspot.com/website/check-java-verison#:~:text=First%2C%20find%20and%20click%20on,get%20your%20current%20version%20details) to learn how to find out what Java version you have!
2. You might also need to install JavaFX 11. You can find the installation guide [here](https://openjfx.io/openjfx-docs/#install-javafx). 
3. Download the latest `friendbook.jar` from here (link coming soon).
4. Open up the [terminal](https://support.apple.com/en-sg/guide/terminal/apd5265185d-f365-44cb-8b09-71a064a42125/mac) (Mac) or [command prompt](https://support.kaspersky.com/common/windows/14637#block0) (Windows).
5. Type `cd` followed by the directory path to the folder where you have downloaded FriendBook in and press `Enter`.
6. Use the command `java -jar friendbook.jar` to get the application running!
7. If you have successfully done everything, a GUI similar to the following image should appear. Please note that the application should have no data when it is used for the first time.
   ![Ui](images/Ui.png)

--------------------------------------------------------------------------------------------------------------------

## Disclaimers
1. Due to FriendBook being a beta release, we only support up to 10000 friends and plans.

--------------------------------------------------------------------------------------------------------------------

## Important Information

<div markdown="span" class="alert alert-info">
:information_source: The blue block highlights additional information that might be useful.
</div>

<div markdown="span" class="alert alert-danger">
:bangbang: The red block highlights disclaimers related to each command.
</div>

```
Texts in this box shows a command and it's corresponding syntax
```
- Words in `UPPER_CASE` are the parameters to be supplied by the user.
- Texts in [square brackets] indicate that the argument is optional
- `...` indicate that more than 1 argument of that type can be passed into the command

--------------------------------------------------------------------------------------------------------------------

## Friends-Related Features

### `add-friend`

This command allows you to add a friend to your FriendBook.

```
add-friend n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]...
```

#### Examples of Correct Usage:
* `add-friend n/John Doe p/98321234 e/johnd@example.com a/Thomson Avenue t/Classmate`
* `add-friend n/Jack Ma p/92839102 e/jack.ma@yahoo.com a/Sixth Avenue`

#### Successful Output:
![add-friendOutput](images/ug/add-friendOutput.png)

#### Unsuccessful Output:
- Invalid command :
  `Invalid command...`

- Non-unique person added (by their name or email) :
  `This friend already exists in the FriendBook...`

- Empty or invalid name :
  `Names should only contain alphanumeric characters and spaces, and it should not be blank...`

- Non-numeric phone number :
  `Phone numbers should only contain numbers, and it should be at least 3 digits long`

- Invalid email format :
  `Emails should be of the format local-part@domain...`

<div markdown="span" class="alert alert-danger">
Each friend must have a unique name and email.
</div>

<div markdown="span" class="alert alert-danger">
Friend's names are case insensitive (John and john are the same name).
</div>

<div markdown="span" class="alert alert-danger">
Friend's names can only contain alphanumeric characters and spaces. No special characters like `/` or `-` are allowed. It cannot consist of only numbers.
</div>

### `delete-friend`

This command allows you to delete a friend to your FriendBook.

```
delete-friend INDEX
```

#### Examples of Correct Usage:
* `delete-friend 1`
* `delete-friend 2`

#### Successful Output:
![delete-friendOutput](images/ug/delete-friendOutput.png)

#### Unsuccessful Output:
- Invalid command :
  `Invalid command...`

- Missing or invalid arguments :
  `Invalid command...`

- INDEX is greater than the number of friends :
  `The friend index provided is bigger than your number of friends.`

<div markdown="span" class="alert alert-danger">
delete-friend command must be provided with a positive non-zero index else, an invalid command message will be shown.
</div>

### `edit-friend`

This command allows you to edit a friend's details in your FriendBook.

```
edit-friend INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]...
```

#### Examples of Correct Usage:
* `edit-friend 3 n/Jack Ma`
* `edit-friend 1 p/99990000`

#### Successful Output:
![edit-friendOutput](images/ug/edit-friendOutput.png)

#### Unsuccessful Output:
- Invalid command :
  `Invalid command...`

- Missing or invalid arguments :
  `Invalid command...`

- INDEX is greater than the number of friends :
  `The friend index provided is bigger than your number of friends.`

- No optional arguments provided :
  `At least one field to edit must be provided.`

- Friend (identified by name or email) already exists :
  `This friend already exists in the FriendBook...`

### `find-friend`

This command allows you to find a friend by name in your FriendBook. 

```
find-friend KEYWORD [MORE_KEYWORDS]
```

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search). e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

#### Examples of Correct Usage:
* `find-friend John` returns `john` and `John Doe`
* `find-friend alex david` returns `Alex Yeoh`, `David Li`

#### Successful Output:
![find-friendOutput](images/ug/find-friendOutput.png)

#### Unsuccessful Output:
- Invalid command :
  `Invalid command...`

- Empty arguments: `Invalid syntax: Missing arguments...`

### Listing friends : `list-friend`

This command allows you to list all your friends in your FriendBook.

```
list-friend
```

#### Successful Output:
![list-friendOutput](images/ug/list-friendOutput.png)

--------------------------------------------------------------------------------------------------------------------

## Plan-Related Features

#### Constraints:
* Duplicate plans are not allowed. This refers to plans with the exact same plan name, date-time and friends.
* Plan names are case-sensitive (eg meeting and Meeting are different names)
* Plan names can only contain alphanumeric characters and spaces.
  * No special characters like `/` or `-` are allowed.
  * It cannot consist of only numbers.

### Adding a plan : `add-plan`

Adds a plan and associates it with involved friends.

Format: `add-plan n/PLAN_NAME d/DATE_TIME f/FRIEND_NAME`

Examples:
* `add-plan n/Project Meeting d/2023-10-23-10:00 f/Royden`

Arguments:

- `PLAN_NAME` must be a STRING, `DATE_TIME` must be in the YYYY-MM-DD-HH:MM format

- `FRIEND_NAME` is optional. If specified, `FRIEND_NAME` must be the name of an existing friend

Successful Output:

`New plan added: PLAN_NAME with FRIEND_NAME at DATE_TIME`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Missing arguments: `Invalid syntax: Missing arguments.
  add-plan: Adds a plan to the FriendBook.
  Parameters: n/PLAN_NAME d/DATE_TIME f/FRIEND_NAME
  Example: add-plan n/Project Meeting d/2023-10-20-09:00 f/John Doe`

- Date-Time in wrong format: `Date-Time given is invalid.
  Date-Time must be in YYYY-MM-DD-HH:MM format with valid values.`

- Date-Time in the past: `Date-Time given is invalid. Ensure that the Date-Time provided is not in the past.`

- Not a valid friend: `The friend does not exist in the FriendBook.`

### Editing a Plan's Information: `edit-plan`

Edits an existing plan’s information in the plans list at the specified index.

Format: `edit-plan INDEX [n/PLAN_NAME] [d/DATE_TIME] [f/FRIEND_NAME]`

Examples:
* `edit-plan 3 n/Dota 3`
* `edit-plan 1 d/2025-01-01-10:00`

Arguments:

- `PLAN_NAME` and `FRIEND_NAME` must be a STRING, `DATE_TIME` must be in the YYYY-MM-DD-HH:MM format
- An `INDEX` must be provided and be a positive integer 1, 2, 3, ... and within the count of plans.
- `PLAN_NAME`, `DATE_TIME`, `FRIEND_NAME` are optional but at least 1 must be given
- If specified, `FRIEND_NAME` must be the name of an existing friend

Successful Output:

`Edited Plan: PLAN_NAME with FRIEND_NAME at DATE_TIME`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Missing or invalid arguments: `Invalid command.
  edit-plan: Edits the details of the plan identified by the index number used in the displayed plan list. Existing values will be overwritten by the input values.
  Parameters: INDEX (must be a positive integer) [n/NAME] [d/DATE_TIME] [f/FRIEND_NAME]
  Example: edit-plan 1 d/2023-10-20-09:00 f/John Doe`
    - FriendBook saves you the headache of counting your number of plans, hence if the index given
      is greater than your number of plans, this error will be shown: `The plan index provided is bigger than your number of plans.`

- No optional arguments provided: `At least one field to edit must be provided.`

- Not a valid friend: `The friend does not exist in the FriendBook.`

### Marking a Plan as Completed : `complete-plan`

Marks the specified plan as completed.

Format: `complete-plan INDEX`

Examples:
* `complete-plan 4`

Arguments:

- An `INDEX` must be provided and be a positive integer 1, 2, 3, ... and within the count of friends.

Successful Output:

`Completed Plan: PLAN_NAME with FRIEND_NAME at DATE_TIME`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Missing or invalid arguments: `Invalid command.
  complete-plan: Marks the plan as completed identified by the index number used in the displayed plan list.
  Parameters: INDEX (must be a positive non-zero integer)
  Example: complete-plan 1`
    - FriendBook saves you the headache of counting your number of plans, hence if the index given
      is greater than your number of plans, this error will be shown: `The plan index provided is bigger than your number of plans.`

### Marking a Plan as Uncompleted : `uncomplete-plan`

Marks the specified plan as uncompleted.

Format: `uncomplete-plan INDEX`

Examples:
* `uncomplete-plan 4`

Arguments:

- An `INDEX` must be provided and be a positive integer 1, 2, 3, ... and within the count of friends.

Successful Output:

`Uncompleted Plan: PLAN_NAME with FRIEND_NAME at DATE_TIME`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Missing or invalid arguments: `Invalid command.
  uncomplete-plan: Marks the plan as not completed identified by the index number used in the displayed plan list.
  Parameters: INDEX (must be a positive non-zero integer)
  Example: uncomplete-plan 1`
    - FriendBook saves you the headache of counting your number of plans, hence if the index given
      is greater than your number of plans, this error will be shown: `The plan index provided is bigger than your number of plans.`

### Deleting a Plan : `delete-plan`

Deletes the specified plan.

Format: `delete-plan INDEX`

Examples:
* `delete-plan 4`

Arguments:

- An `INDEX` must be provided and be a positive integer 1, 2, 3, ... and within the count of friends.

Successful Output:

`Deleted Plan: PLAN_NAME with FRIEND_NAME at DATE_TIME`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Missing or invalid arguments: `Invalid command.
  delete-plan: Deletes the plan identified by the index number used in the displayed plan list.
  Parameters: INDEX (must be a positive non-zero integer)
  Example: delete-plan 1`
    - FriendBook saves you the headache of counting your number of plans, hence if the index given
      is greater than your number of plans, this error will be shown: `The plan index provided is bigger than your number of plans.`

### Finding a plan : `find-plan`

Find plans which is associated to a given friend.

Format: `find-plan FRIEND_NAME`

* `FRIEND_NAME` has to be the full name of the Person instance. e.g `find-plan Elijah` will throw an error if no Person has the full name `Elijah`

* The search is case-sensitive. e.g `hans` will not match `Hans`

* Only one full name will be taken in and searched (only one person's plans will be searched)

Examples:
* `find-plan John` returns all plans associated to `John`

Arguments:
- `FRIEND_NAME` must be the full name belonging to a Person saved in the FriendBook

Successful Output:
`COUNT_OF_PLANS plans listed!`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Missing arguments: `Invalid syntax: Missing arguments.
  find-plan: Finds all plans which contains the specified friend.
  Parameters: FRIEND_NAME
  Example: find-plan Elijah Chia`

- Not a valid friend: `The friend does not exist in the FriendBook.`

### Listing plans : `list-plan`

Shows a list of all plans in the FriendBook.

Format: `list-plan`

Successful Output:
`Listed all plans`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

### Clearing the Storage : `clear`
Clears the stored friends and plans on the `friendbook.json` file which is located in the `data` folder in FriendBook's home folder.

### Get the User Guide : `help`
Provides the FriendBook user guide's link.

### Exit FriendBook : `exit`
Closes the FriendBook Application.

### Saving the data

FriendBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

FriendBook data are saved automatically as a JSON file `[JAR file location]/data/friendbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, FriendBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</div>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous FriendBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**add-friend** | `add-friend n/NAME p/PHONE_NUMBER e/EMAIL [t/TAG]...` <br> e.g., `add-friend n/John Doe p/98321234 e/johnd@example.com`
**edit-friend** | `edit-friend INDEX [n/NAME] [p/PHONE] [e/EMAIL] [t/TAG]...`<br> e.g., `edit-friend 3 n/Jack Ma`
**delete-friend** | `delete-friend NAME` <br> e.g., `delete-friend John Doe`
**find-friend** | `find-friend KEYWORD [MORE_KEYWORDS]`<br> e.g., `find-friend Jack`
**list-friend** | `list-friend`
**add-plan** | `add-plan n/PLAN_NAME d/DATE_TIME f/FRIEND_NAME`<br> e.g.,`add-plan n/Project Meeting d/2023-10-23-10:00 f/Royden`
**edit-plan** | `edit-plan INDEX [n/PLAN_NAME] [d/DATE_TIME] [f/FRIEND_NAME]`<br> e.g., `edit-plan 1 d/2025-01-01-10:00`
**complete-plan** | `complete-plan INDEX`<br> e.g., `complete-plan 4`
**uncomplete-plan** | `uncomplete-plan INDEX`<br> e.g., `uncomplete-plan 4`
**delete-plan** | `delete-plan INDEX` <br> e.g., `delete-plan 4`
**find-plan** | `find-plan FRIEND_NAME` <br> e.g., `find-plan John`
**list-plan** | `list-plan`
