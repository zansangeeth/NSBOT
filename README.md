# NSBOT 
 
Sangeeth Amirthanathan

**NSBOT** is an native android app user can view restaurants, view detail pages and view branch location on map view

Time spent: **2** days spent in total

## Android MVVM Architecture

MVVM stands for Model, View, ViewModel.

* [ ] Model: This holds the data of the application. It cannot directly talk to the View. Generally, it’s recommended to expose the data to the ViewModel through Observables.

* [ ] View: It represents the UI of the application devoid of any Application Logic. It observes the ViewModel.

The following flow illustrates the core MVVM Pattern.

![android-mvvm-pattern](https://user-images.githubusercontent.com/42418189/186920956-39430cc6-9eab-4b5a-86fc-c9cba4b72e3b.png)

## Functionality 

The following **required** functionality is completed:

* [ ] Activities
* [ ] Fragments
* [ ] View Holder
* [ ] Lifecycle
* [ ] Activity Navigations
* [ ] Fragment Navigations
* [ ] Google maps
* [ ] Custom layouts
* [ ] Google Sign in
* [ ] Firebase
* [ ] App icon

The following **extensions** are implemented:

* [ ] User need to sign with their google account
* [ ] User can view home page that have overview of the company
* [ ] User can view the location of author
* [ ] imlemented custom bottom navigation bar
* [ ] imlemented custom shapes
* [ ] imlemented MVVM pattern
* [ ] user can see setting page that have profile details and logout 
* [ ] app will automatically check user is existing or not 


The following **extensions** are not implemented:

* [ ] implemented current location but cant be add current location marker - so implemented default marker with custom drawable of marker
* [ ] screen time out 

## Video walkthrough

![XRecorder_28092-1664383124809](https://user-images.githubusercontent.com/42418189/192840026-7d359e70-a169-4006-b290-1334bca3d991.gif)

## Image Walkthrough

Here's a walkthrough of implemented user stories:

# Screenshots Mobile
Screen | App View | Sign In View | Home View | Location View | Setting View 
--- | --- | --- | --- | --- | --- |
Imaages | ![Screenshot_20220928-215548](https://user-images.githubusercontent.com/42418189/192835293-674add0d-e87f-4c2c-9a3f-7c7a6a56bf5a.png) | ![Screenshot_20220928-214238](https://user-images.githubusercontent.com/42418189/192835727-cffc0a9f-c9d5-470a-aa39-37790485dadc.png) | ![Screenshot_20220928-213058](https://user-images.githubusercontent.com/42418189/192835943-c57204e6-0e18-4949-8e1b-7542f0ebb6c3.png) | ![Screenshot_20220928-214224](https://user-images.githubusercontent.com/42418189/192836139-8c0bf41f-c072-4a5f-a02f-5fcff4376413.png) | ![Screenshot_20220928-214232](https://user-images.githubusercontent.com/42418189/192836382-048efb58-e4e8-43ad-969e-7d0cb637aef2.png) |

# Screenshots Tablet
Screen | Sign In Landscape |
--- | --- |
Images | ![Screenshot_20220928_221932](https://user-images.githubusercontent.com/42418189/192848521-f1c672d7-b9d1-4b73-a31a-e481b69b0713.png) |



## Notes

Describe any challenges encountered while building the app.

* [ ] Navigating Activities
* [ ] Navigating Fragments
* [ ] Dealing with build.gradle
* [ ] Designing Application in XML
* [ ] Design Custom UI
* [ ] imlemented firebase authentications
* [ ] imlemented bottom nav bar 
* [ ] imlemented view binding


## License

    Copyright 2022 Sangeeth Amirthanathan, NSBOT

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
