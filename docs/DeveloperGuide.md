# Developer Guide

## Introduction

Trippie is a command-line app to plan any of your upcoming trips. It is tailored to match the needs of student travellers. Trippie lets users plan multiple trips through timetabling and also allows users to track their expenses overseas. Trippie is designed for users to enter their input quickly and efficiently.

## Setting up the project in your computer

**Prerequisites:**
* JDK 11
* IntelliJ IDE

<div markdown="span" class="alert alert-warning">

⚠️ **Caution:**

Follow the steps in the following guide precisely. Things will not work out if you deviate in some steps.
</div>

First, **fork** this repo, and **clone** the fork into your computer.

If you plan to use Intellij IDEA (highly recommended):
1. **Configure the JDK**: Follow the guide [_[se-edu/guides] IDEA: Configuring the JDK_](https://se-education.org/guides/tutorials/intellijJdk.html) to to ensure Intellij is configured to use **JDK 11**.
1. **Import the project as a Gradle project**: Follow the guide [_[se-edu/guides] IDEA: Importing a Gradle project_](https://se-education.org/guides/tutorials/intellijImportGradleProject.html) to import the project into IDEA.<br>
  :exclamation: Note: Importing a Gradle project is slightly different from importing a normal Java project.
1. **Verify the setup**:
   1. Run the `seedu.trippie.Trippie` and try a few commands.
   2. [Run the tests](Testing.md) to ensure they all pass. 

## Design & Implementation

This section explains the high-level design of the application. Given below is an overview of each component and a more detailed explanation of the architecture. Trippie is the main class which manages the initialization of the relevant classes and their execution.

### Architecture

![UML Diagram Main](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/docs/Trippie%20UML-Main.jpg?raw=true)
<center><i>Figure 1: Overall Architecture</i></center>

The Architecture Diagram given above explains the high-level design of Trippie. Given below is a quick overview of each component.

## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
