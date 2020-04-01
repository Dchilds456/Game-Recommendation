# Project 3 - *VGR-App*

## Overview

Description 

**VGR** is a video game search app that allows the user to find released and upcoming video games that meet their criteria.

App Evaluation 

•	Category: Social networking/ Gaming

•	Mobile: This app would be primarily developed for mobile but would perhaps be just as viable on a computer. Functionality wouldn't be limited to mobile devices, however mobile version could potentially have more features.

•	Story: User is able to select the genre of the game. It has the option to search either upcoming games or released games. User is able to Comment their thoughts on the game, as well as View comments from other users.

•	Market: Any individual between the age of 14 and older could choose to use this app, and to keep it a safe environment, people would be organized into age groups.

•	Habit: This app could be used as often or unoften as the user wanted depending on what new games that came out, and what exactly they're looking for to purchase

•	Scope: First we would start with pairing people based on their game taste, then perhaps this could evolve into a game sharing application as well to broaden its usage.




Time spent: **X** hours spent in total

## User Stories

The following **required** functionality is completed:

- [ ]	User logs in and is greeted by a welcome screen
- [ ]	User picks what their desired genre/rating/company/etc. 
- [ ]	User sees a screen full of games sort of like Netflix
- [ ]	Add a comment section to each post sort of like Instagram 
- [ ]	Add price to each game
- [ ]	Create a “coming soon” menu for unreleased games
- [ ]	Settings (Accessibility, Notification, General, etc.)


The following **additional** features are implemented:

-  [ ]	Video game music
-  [ ]	Age Rating
-  [ ]	Share button


## Schema

Here's a Schema for our data:

### Login

| __Property__ | __Type__  |       __Description__       |
|--------------|-----------|-----------------------------|
| login_ID     | String    | Username for Login          |
| login_PW     | String    | Password for Login          |


### Profile

| __Property__ | __Type__  |            __Description__              |
|--------------|-----------|-----------------------------------------|
| profile_name | String    | Username for Login                      |
| profile_image| File      | Image uploaded by user for profile      |
| login_ID     | String    | users Login title                       |
| NavBar       | Pointer   | Access to the rest of the application   |


### Comments

| __Property__ | __Type__  |            __Description__              |
|--------------|-----------|-----------------------------------------|
| comment      | String    | Users comment posted on the comment page|
| com_rate     | number    | Rating User gives for the game          |
| login_ID     | String    | users Login title                       |
| NavBar       | Pointer   | Access to the rest of the application   |


## Video Walkthrough

Here's a Wireframe of implemented user stories:


<img src='https://github.com/Game-Recommendation/VGR-App/blob/master/Wireframes%20(Updated).jpg?raw=true' title='Wireframes' width='' alt='Wireframes' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.

## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
