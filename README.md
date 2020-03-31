# Project 3 - *VGR-App*

**VGR** is a video game search app that allows the user to find released and upcoming video games that meet their criteria.

Time spent: **X** hours spent in total

## User Stories

The following **required** functionality is completed:

- [ ] User is able to select the genre of the game
- [ ] User is able to select the company from which the game is created
- [ ] User can has the option to search either upcoming games or released games
- [ ] User can order titles by rating, price, alphabet, etc.
- [ ] User has the option to listen to video game music while using the app
- [ ] User can has the option to search either upcoming games or released games
- [ ] User can navigate through the titles resulting from the filtered search
- [ ] The user is able to select any title and view more details on that page; along with a relative trailer.
- [ ] User is able to Comment their thoughts on the game; as well as View comments from other users.

The following **additional** features are implemented:

- [ ] List anything else that you can get done to improve the app functionality!

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

Here's a walkthrough of implemented user stories:

<img src='https://github.com/Game-Recommendation/VGR-App/blob/master/Schema.jpg?raw=true' title='Schema' width='' alt='Schema' />

<img src='https://github.com/Game-Recommendation/VGR-App/blob/master/Wireframes.jpg?raw=true' title='Wireframes' width='' alt='Wireframes' />

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
