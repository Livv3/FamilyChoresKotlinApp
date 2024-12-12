# Family Chores App

## Overview
As the name suggests, this app is designed for families to help distribute and manage household chores.
Each family member can have their own to-do list of tasks assigned to them. Once a task is completed, it can be checked off the list.
Upon completing a task, a short confetti animation plays on the screen.
Additionally, a bar chart displays the number of completed tasks for each family member, providing a visual overview of everyone's contributions.

## Key Features
- Home Screen (Main Screen):
Family members’ profiles are displayed in a vertical list, each showing a profile picture and name.
A new family member can be added using an "Add Member" button.
     - Adding a Family Member:
This action opens a new screen where the name can be entered, and a profile picture can be uploaded. After completing the details, clicking the "Add" button returns to the home screen, where the new member is now listed.
- Task Management:
Clicking on a family member's profile opens a new screen that displays their assigned tasks in a checklist format.
    
    - Adding Tasks:
    New tasks can be added using the "+" button at the bottom of the screen.
    
    - Deleting Tasks:
    Individual tasks can be deleted using a button next to each task.

    - Marking Tasks as Completed:
    Tasks can be marked as completed by checking their corresponding checkboxes, which triggers a confetti animation.

- Statistics:
From the main screen, a button leads to a bar chart (BarChart) screen.
The chart visually represents the number of completed tasks for each family member.


## Used Technologies

- Animations
- Fragments
- RecyclerView