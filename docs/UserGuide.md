---
layout: page
title: User Guide
---

FriendBook is a **desktop app for managing contacts, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, FriendBook can get your plans management done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `friendbook.jar` from here (link coming soon).

1. Copy the file to the folder you want to use as the _home folder_ for your FriendBook.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar friendbook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list-friend` : Lists all contacts.

   * `add-friend n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the FriendBook.

   * `delete-friend 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add-friend n/NAME`, `NAME` is a parameter which can be used as `add-friend n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Adding a person: `add-friend`

Adds a person to the friends list.

Format: `add-friend n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS`

Examples:
* `add-friend n/John Doe p/98321234 e/johnd@example.com a/Thomson Avenue`
* `add-friend n/Jack Ma p/92839102 e/jack.ma@yahoo.com a/Sixth Avenue`

Arguments:
- `NAME`, `PHONE_NUMBER`, `EMAIL`, `ADDRESS` are all required fields.

Successful Output:

`[NAME, PHONE_NUMBER, EMAIL, ADDRESS] added to friends list.`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Empty name: `Invalid Adding of Friend: A name must be entered. Syntax: add-friend n/NAME p/NUMBER e/EMAIL a/ADDRESS`

- Non-numeric phone number: `Invalid Adding of Friend: Phone number must be numeric. Syntax: add-friend n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS`

- Invalid email format: `Invalid Adding of Friend: Invalid email. Syntax: add-friend n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS`

- Additional arguments provided: `Invalid syntax: Too many arguments. Syntax: add-friend n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS`

### Removing a Friend : `delete-friend`

Removes an existing friend from the friends list.

Format: `delete-friend NAME`

Examples:
* `delete-friend John Doe`
* `delete-friend Jack Ma`

Arguments:
- `NAME` must be a string

Successful Output:

`[NAME, PHONE_NUMBER, EMAIL, ADDRESS] removed from friends list.`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Empty name: `Invalid Removing of Friend: A name must be entered. Syntax: delete-friend NAME`

- Argument provided is not a STRING: `Invalid Removing of Friend: Name should be a STRING. Syntax: delete-friend NAME`

- Not a valid friend: `Invalid Removing of Friend: No such friend in friends list.`

- Additional arguments provided: `Invalid syntax: Too many arguments. Syntax: delete-friend NAME`

### Editing a Friend's Information: `edit-friend` [Coming Soon]

Edits an existing friend’s information in the friends list at the specified index.

Format: `edit-friend INDEX n/NAME p/PHONE e/EMAIL a/ADDRESS`

Examples:
* `edit friend 3 n/Jack Ma`
* `edit friend 1 p/99990000`

Arguments:

- `NAME` must be a STRING, `PHONE` must be an INT, and `EMAIL` must be a STRING

- An `INDEX` must be provided

- `NAME`, `PHONE_NUMBER`, `EMAIL` and `ADDRESS` are optional but at least 1 must be given

Successful Output:

`[NAME, PHONE_NUMBER, EMAIL, ADDRESS] updated in friends list.`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Invalid index is given: `Invalid Updating of Friend: Index given is invalid. Syntax: edit-friend INDEX n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS`

- No optional arguments provided: `Invalid Updating of Friend: Missing information to be updated. Syntax: edit-friend INDEX n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS`

- Not a valid friend: `Invalid Updating of Friend: No such friend in friends list.`

- Additional arguments provided: `Invalid syntax: Too many arguments. Syntax: edit-friend INDEX n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS`

### Adding a plan : `add-plan`

Adds a plan and associates with involved friends.

Format: `add-plan n/PLAN_NAME d/DATE_TIME f/FRIEND_NAME`

Examples:
* `add-plan n/Project Meeting d/2023-10-23-10:00 f/Royden`

Arguments:

- `PLAN_NAME` must be a STRING, `DATE_TIME` must be in the YYYY-MM-DD-HH:MM format

- `FRIEND_NAME` is optional. If specified, `FRIEND_NAME` must be the name of an existing friend

Successful Output:

`[PLAN_NAME with FRIEND_NAME at DATE_TIME] added to your plans.`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Missing arguments: `Invalid syntax: Missing arguments. Syntax: add-plan n/PLAN_NAME d/DATE_TIME f/FRIEND_NAME`

- Date-Time in wrong format: `Invalid Adding of Plan: Date-Time given is invalid. Syntax: Date-Time must be in YYYY-MM-DD-HH:MM format`

- Date-Time in the past: `Invalid Adding of Plan: Date-Time given is invalid. Ensure that the Date-Time provided is not in the past.`

- Not a valid friend: `Invalid Adding of Plan: No such friend in friends list.`

- Additional arguments provided: `Invalid syntax: Too many arguments. Syntax: add-plan n/PLAN_NAME d/DATE_TIME f/FRIEND_NAME`

### Marking a Plan as Completed : `complete-plan`

Marks the specified plan as completed.

Format: `complete-plan INDEX`

Examples:
* `complete-plan 4`

Arguments:

- `INDEX` must be an INTEGER

Successful Output:

`[PLAN_NAME] is marked as completed.`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Missing arguments: `Invalid syntax: Missing arguments. Syntax: complete-plan INDEX`

- Non-numeric index: `Invalid Marking of Plan: Index given is non-numeric. Syntax: complete-plan INDEX`

- Not a valid index: `Invalid Marking of Plan: No plans at given index. Syntax: complete-plan INDEX`

- Additional arguments provided: `Invalid syntax: Too many arguments. Syntax: complete-plan INDEX`

### Deleting a Plan : `delete plan`

Deletes the specified plan.

Format: `delete-plan INDEX`

Examples:
* `delete-plan 4`

Arguments:

- `INDEX` must be an INTEGER

Successful Output:

`[PLAN_NAME] is deleted.`

Unsuccessful Output:

- Invalid command: `Invalid command.` + help message with list of all commands

- Missing arguments: `Invalid syntax: Missing arguments. Syntax: delete-plan INDEX`

- Non-numeric index: `Invalid Deletion of Plan: Index given is non-numeric. Syntax: delete-plan INDEX`

- Not a valid index: `Invalid Deletion of Plan: No plans at given index. Syntax: delete-plan INDEX`

- Additional arguments provided: `Invalid syntax: Too many arguments. Syntax: delete-plan INDEX`

### Saving the data

FriendBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

FriendBook data are saved automatically as a JSON file `[JAR file location]/data/friendbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, FriendBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

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
**add-friend** | `add friend n/NAME p/PHONE_NUMBER e/EMAIL` <br> e.g., `add friend n/John Doe p/98321234 e/johnd@example.com`
**delete-friend** | `remove friend NAME` <br> e.g., `remove friend John Doe`
**edit-friend** | `edit friend INDEX n/NAME p/PHONE e/EMAIL`<br> e.g., `edit friend 3 n/Jack Ma`
**add-plan** | `add plan n/PLAN_NAME d/DATE_TIME f/FRIEND_NAME`<br> e.g.,`add plan n/Project Meeting d/2023-10-23-10:00 f/Royden`
**complete-plan** | `complete plan INDEX`<br> e.g., `complete plan 4`
**delete-plan** | `delete plan INDEX` <br> e.g., `delete plan 4`
