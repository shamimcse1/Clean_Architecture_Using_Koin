# Fake Store App

A sample Android application built using MVVM Architecture, Koin for Dependency Injection, Kotlin Flow, and Room Database. The app fetches product details from FakeStoreAPI(https://fakestoreapi.com/) and supports caching for offline access.

# Features

## Clean Architecture with separate layers:

- Data Layer: Handles API calls and local database operations.

- Domain Layer: Contains business logic and use cases.

- Presentation Layer: Manages UI and ViewModel logic.

- Room Database for local caching.

- Retrofit for network requests.

- Kotlin Flow for reactive data streams.

- Koin for dependency injection.

- GridView for presenting product details in a grid format.

# Architecture Overview

## Presentation Layer
  - ViewModel
  - Composable UI
## Domain Layer
  - Entiry
  - Repository
  - UseCase (Business Logic)
## Data Layer
  - RepositoryImp
  - Retrofit API
  - Room Database

# Tech Stack

- Language: Kotlin

- Architecture: MVVM

- Networking: Retrofit

- Dependency Injection: Koin

- Database: Room

- Reactive Programming: Kotlin Flow

- Jetpack Compose: For UI

#Installation

Clone the repository:
```plaintext
git clone https://github.com/your-username/fake-store-app.git
```
Open the project in Android Studio.

Sync Gradle.

Run the application on an emulator or device.

# Code Structure

## Data Layer

- Entities: ProductEntity

- DAO: ProductDao

- API: ProductApi

- Repository Implementation: ProductRepositoryImpl

## Domain Layer

- Use Case: GetProductUseCase

## Presentation Layer

- ViewModel: ProductViewModel

- UI: ProductScreen

Dependencies
```plaintext
dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib"
    implementation "androidx.core:core-ktx"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx"
    implementation "androidx.room:room-runtime"
    kapt "androidx.room:room-compiler"
    implementation "androidx.compose.ui:ui"
    implementation "androidx.compose.material:material"
    implementation "androidx.activity:activity-compose"
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "io.insert-koin:koin-android"
    implementation "io.insert-koin:koin-core:3.1.2"
    implementation "androidx.gridlayout:gridlayout:1.0.0"
}
```
Screenshots

Add screenshots of the app here.

# License

This project is licensed under the MIT License - see the LICENSE file for details.

# Contributions

- Contributions are welcome! Feel free to open issues or submit pull requests.

- Acknowledgments

- FakeStoreAPI(https://fakestoreapi.com/) for providing the sample API.

- The Android community for amazing resources and libraries.
