![Message](https://img.shields.io/static/v1?label=Android&message=Project&color=green)
![License](https://img.shields.io/badge/License-Apache-blue.svg)

**Albums App**  is an Android Project with Modular Architecture and Clean Architecture.
- it contain 3 layers for common components (core - data - presentation) and library module

<p align="center">
<img src="https://github.com/AhmedTawfiqM/Albums/blob/master/design.PNG" alt="design"/>
</p>


# Table of contents

- [Description](#Description)
- [Software Stack](#Stack)
- [Why](#why)


## Description
The app is composed of 2 screens, first is the profile screen, it has the user name and address  pinned at the top and then it lists all of this user’s albums. You can get user albums by requesting  the albums endpoint and passing user id as a parameter. 
When you press on any album it navigates to the second screen which is an album details screen.  You request the photos endpoint and pass album id as a parameter, then list the images in an  instagram-like grid. Also there should be a search bar that you can filter within the album by the  image title, when you start typing the screen should show only images that are related to this  search query.

### Api End Point https://jsonplaceholder.typicode.com

## Software Stack
- Kotlin <br/>
- MVVM  
- Android JetPack 
- Retrofit 2 
- Hilt dagger 
- Coroutines
- jetpack Compose 
- Navigation Compose 

<br/>
<img src="https://github.com/AhmedTawfiqM/Albums/blob/master/clean_arch.png" alt="clean-architecture"/>

# why Modular Architecture ?

- The Project is Clean , Testable , Maintainable and changable
- High quality App with high cohesion and low coupling
- Build Time 
- Development Can be Divided
- Readable Programs
- Programming Errors are Easy to Detect
- Allows Re-Use of Codes
- Improves Manageability
- Collaboration

## :clap: Contribution

- PRs are welcome, let's make this library better. :raised_hands:

- please :star: if you like the idea!


## Check my last lecture about Clean architecture and Clean Code [Lecture](https://www.youtube.com/watch?v=kFll5whDTJc&t=759s&ab_channel=AHMEDTAWFIQ)

## License

**Apache License**, Version 2.0

<details>
    <summary>
        click to reveal License
    </summary>

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
   https://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

</details>
